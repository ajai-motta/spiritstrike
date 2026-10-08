package com.gomfactory.adpie.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.controller.AdController;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import com.gomfactory.adpie.sdk.videoads.VideoFullScreenActivity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
@Deprecated
public class RewardedVideoAd {
    public static final String TAG = "RewardedVideoAd";
    private AdData adData;
    private boolean initialized;
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private Thread mAdThread;
    private Context mContext;
    private FinishState mFinishState;
    private HashMap<String, String> mHashMap;
    private boolean mIsLoading;
    private OnPaidEventListener mOnPaidEventListener;
    private String mSlotId;
    private String mSsvCustomData;
    private String mSsvUserId;
    private TargetingData mTargetingData;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private RewardedVideoAdListener mRewardedVideoAdListener = null;
    private RewardedVideoState mRewardedVideoState = RewardedVideoState.NOT_READY;

    public interface OnPaidEventListener {
        void onPaidEvent(double d);
    }

    public interface RewardedVideoAdListener {
        void onRewardedVideoClicked();

        void onRewardedVideoFailedToLoad(int i);

        void onRewardedVideoFinished(FinishState finishState);

        void onRewardedVideoLoaded();

        void onRewardedVideoStarted();
    }

    public RewardedVideoAd(Context context, String str) {
        this.mContext = context;
        this.mSlotId = str;
        init();
    }

    public RewardedVideoAdListener getAdListener() {
        return this.mRewardedVideoAdListener;
    }

    public void setAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.mRewardedVideoAdListener = rewardedVideoAdListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        AdPieLog.d(TAG, this.mSlotId + ":::init");
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            addEventListener();
            this.mAdController = new AdController(this.mContext, this.mAdEventListener);
            this.initialized = true;
        } catch (ClassNotFoundException e) {
            AdPieLog.e(TAG, e);
        }
    }

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (RewardedVideoAd.this.mAdEventListener != null) {
                                    RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                RewardedVideoAd.this.adData = adResponse.getAdData();
                                if (RewardedVideoAd.this.adData != null) {
                                    if (RewardedVideoAd.this.adData.getIcType() == 52) {
                                        RewardedVideoAd.this.preloadResource();
                                    } else {
                                        AdPieLog.i(RewardedVideoAd.TAG, "'" + RewardedVideoAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (RewardedVideoAd.this.mAdEventListener != null) {
                                            RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (RewardedVideoAd.this.mAdEventListener != null) {
                                    RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (RewardedVideoAd.this.mAdEventListener != null) {
                                RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (RewardedVideoAd.this.mAdEventListener != null) {
                            RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(RewardedVideoAd.TAG, e);
                        }
                        if (RewardedVideoAd.this.mAdEventListener != null) {
                            RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyAdLoaded");
                        RewardedVideoAd.this.mIsLoading = false;
                        if (RewardedVideoAd.this.mRewardedVideoAdListener != null) {
                            RewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        RewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                        RewardedVideoAd.this.adData = null;
                        if (i != 106) {
                            RewardedVideoAd.this.mIsLoading = false;
                        }
                        if (RewardedVideoAd.this.mRewardedVideoAdListener != null) {
                            RewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyAdShown");
                        RewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.SHOW;
                        if (RewardedVideoAd.this.mOnPaidEventListener == null || RewardedVideoAd.this.adData == null) {
                            return;
                        }
                        RewardedVideoAd.this.mOnPaidEventListener.onPaidEvent(RewardedVideoAd.this.adData.getEcpm());
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyAdDismissed - " + RewardedVideoAd.this.mFinishState);
                        RewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                        if (RewardedVideoAd.this.mRewardedVideoAdListener != null) {
                            RewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoFinished(RewardedVideoAd.this.mFinishState);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyAdClicked");
                        if (RewardedVideoAd.this.mRewardedVideoAdListener != null) {
                            RewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoClicked();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyVideoAdStarted");
                        if (RewardedVideoAd.this.mRewardedVideoAdListener != null) {
                            RewardedVideoAd.this.mRewardedVideoAdListener.onRewardedVideoStarted();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyVideoAdSkipped");
                        RewardedVideoAd.this.mFinishState = FinishState.SKIPPED;
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyVideoAdError");
                        RewardedVideoAd.this.mFinishState = FinishState.ERROR;
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
                RewardedVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::notifyVideoAdCompleted");
                        RewardedVideoAd.this.mFinishState = FinishState.COMPLETED;
                    }
                });
            }
        };
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
    }

    public void load() {
        try {
            if (this.mIsLoading) {
                AdPieLog.d(TAG, "AdPie (" + this.mSlotId + ") is already loading an ad. Wait for previous load to finish.");
                AdEventListener adEventListener = this.mAdEventListener;
                if (adEventListener != null) {
                    adEventListener.notifyAdFailedToLoad(106);
                    return;
                }
                return;
            }
            this.mIsLoading = true;
            Thread thread = this.mAdThread;
            if (thread != null) {
                thread.interrupt();
                this.mAdThread = null;
            }
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedVideoAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(RewardedVideoAd.TAG, RewardedVideoAd.this.mSlotId + ":::load");
                        RewardedVideoAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                        RewardedVideoAd.this.mFinishState = FinishState.UNKNOWN;
                        RewardedVideoAd.this.adData = null;
                        if (!RewardedVideoAd.this.initialized) {
                            RewardedVideoAd.this.init();
                        }
                        RewardedVideoAd.this.mAdController.setSlotID(RewardedVideoAd.this.mSlotId);
                        RewardedVideoAd.this.mAdController.setTargetingData(RewardedVideoAd.this.mTargetingData);
                        RewardedVideoAd.this.mAdController.loadAd(RewardedVideoAd.this.mHashMap);
                    } catch (Exception e) {
                        AdPieLog.e(RewardedVideoAd.TAG, e);
                        if (RewardedVideoAd.this.mAdEventListener != null) {
                            RewardedVideoAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            AdEventListener adEventListener2 = this.mAdEventListener;
            if (adEventListener2 != null) {
                adEventListener2.notifyAdFailedToLoad(104);
            }
        }
    }

    public void load(TargetingData targetingData) {
        this.mTargetingData = targetingData;
        load();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadResource() {
        this.mRewardedVideoState = RewardedVideoState.READY;
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyAdLoaded(new Object[0]);
        }
    }

    public boolean show() {
        AdData adData;
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::show:::" + AdPieSDK.getInstance().getNetworkConnectionType() + "," + Build.VERSION.SDK_INT);
        try {
            if (AdPieSDK.getInstance().getNetworkConnectionType() != 0) {
                if (this.mRewardedVideoState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 52) {
                        VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, this.mSsvUserId, this.mSsvCustomData, this.mAdEventListener);
                        return true;
                    }
                    AdPieLog.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    return false;
                }
                if (!this.mRewardedVideoState.isReady()) {
                    AdPieLog.i(str, this.mSlotId + ":::show:::RewardedVideoState is not ready.");
                    return false;
                }
                AdPieLog.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                return false;
            }
            AdPieLog.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            return false;
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            return false;
        }
    }

    public boolean isLoaded() {
        return this.mRewardedVideoState.isReady();
    }

    public void destroy() {
        AdPieLog.d(TAG, this.mSlotId + ":::destroy");
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
        Thread thread = this.mAdThread;
        if (thread != null) {
            thread.interrupt();
            this.mAdThread = null;
        }
        HashMap<String, String> map = this.mHashMap;
        if (map != null) {
            map.clear();
            this.mHashMap = null;
        }
    }

    public void setExtraParameter(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals("floorPrice")) {
            return;
        }
        if (this.mHashMap == null) {
            this.mHashMap = new HashMap<>();
        }
        this.mHashMap.put("bidfloor", str2);
        this.mHashMap.put("bidfloorcur", "USD");
    }

    public void setUserIdForSSV(String str) {
        this.mSsvUserId = str;
    }

    public void setCustomDataForSSV(String str) {
        this.mSsvCustomData = str;
    }

    private enum RewardedVideoState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
