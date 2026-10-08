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
public class RewardedAd {
    public static final String TAG = "RewardedAd";
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
    private RewardedAdListener mRewardedAdListener = null;
    private RewardedState mRewardedVideoState = RewardedState.NOT_READY;

    public interface OnPaidEventListener {
        void onPaidEvent(double d);
    }

    public interface RewardedAdListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdFailedToLoad(int i);

        void onAdFailedToShow();

        void onAdLoaded();

        void onAdRewarded();

        void onAdShown();
    }

    public RewardedAd(Context context, String str) {
        this.mContext = context;
        this.mSlotId = str;
        init();
    }

    public RewardedAdListener getAdListener() {
        return this.mRewardedAdListener;
    }

    public void setAdListener(RewardedAdListener rewardedAdListener) {
        this.mRewardedAdListener = rewardedAdListener;
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
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (RewardedAd.this.mAdEventListener != null) {
                                    RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                RewardedAd.this.adData = adResponse.getAdData();
                                if (RewardedAd.this.adData != null) {
                                    if (RewardedAd.this.adData.getIcType() == 52) {
                                        RewardedAd.this.preloadResource();
                                    } else {
                                        AdPieLog.i(RewardedAd.TAG, "'" + RewardedAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (RewardedAd.this.mAdEventListener != null) {
                                            RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (RewardedAd.this.mAdEventListener != null) {
                                    RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (RewardedAd.this.mAdEventListener != null) {
                                RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(RewardedAd.TAG, e);
                        }
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyAdLoaded");
                        RewardedAd.this.mIsLoading = false;
                        if (RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        RewardedAd.this.mRewardedVideoState = RewardedState.NOT_READY;
                        RewardedAd.this.adData = null;
                        if (i != 106) {
                            RewardedAd.this.mIsLoading = false;
                        }
                        if (RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyAdShown");
                        RewardedAd.this.mRewardedVideoState = RewardedState.SHOW;
                        if (RewardedAd.this.mOnPaidEventListener == null || RewardedAd.this.adData == null) {
                            return;
                        }
                        RewardedAd.this.mOnPaidEventListener.onPaidEvent(RewardedAd.this.adData.getEcpm());
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyAdDismissed - " + RewardedAd.this.mFinishState);
                        RewardedAd.this.mRewardedVideoState = RewardedState.NOT_READY;
                        if (RewardedAd.this.mFinishState == FinishState.COMPLETED && RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdRewarded();
                        }
                        if (RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdDismissed();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyAdClicked");
                        if (RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdClicked();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyVideoAdStarted");
                        if (RewardedAd.this.mRewardedAdListener != null) {
                            RewardedAd.this.mRewardedAdListener.onAdShown();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyVideoAdSkipped");
                        RewardedAd.this.mFinishState = FinishState.SKIPPED;
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyVideoAdError");
                        RewardedAd.this.mFinishState = FinishState.ERROR;
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
                RewardedAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::notifyVideoAdCompleted");
                        RewardedAd.this.mFinishState = FinishState.COMPLETED;
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
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.RewardedAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(RewardedAd.TAG, RewardedAd.this.mSlotId + ":::load");
                        RewardedAd.this.mRewardedVideoState = RewardedState.NOT_READY;
                        RewardedAd.this.mFinishState = FinishState.UNKNOWN;
                        RewardedAd.this.adData = null;
                        if (!RewardedAd.this.initialized) {
                            RewardedAd.this.init();
                        }
                        RewardedAd.this.mAdController.setSlotID(RewardedAd.this.mSlotId);
                        RewardedAd.this.mAdController.setTargetingData(RewardedAd.this.mTargetingData);
                        RewardedAd.this.mAdController.loadAd(RewardedAd.this.mHashMap);
                    } catch (Exception e) {
                        AdPieLog.e(RewardedAd.TAG, e);
                        if (RewardedAd.this.mAdEventListener != null) {
                            RewardedAd.this.mAdEventListener.notifyAdFailedToLoad(104);
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
        this.mRewardedVideoState = RewardedState.READY;
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener != null) {
            adEventListener.notifyAdLoaded(new Object[0]);
        }
    }

    public void show() {
        AdData adData;
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::show:::" + AdPieSDK.getInstance().getNetworkConnectionType() + "," + Build.VERSION.SDK_INT);
        try {
            if (AdPieSDK.getInstance().getNetworkConnectionType() != 0) {
                if (this.mRewardedVideoState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 52) {
                        VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, this.mSsvUserId, this.mSsvCustomData, this.mAdEventListener);
                        return;
                    }
                    AdPieLog.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    RewardedAdListener rewardedAdListener = this.mRewardedAdListener;
                    if (rewardedAdListener != null) {
                        rewardedAdListener.onAdFailedToShow();
                        return;
                    }
                    return;
                }
                if (!this.mRewardedVideoState.isReady()) {
                    AdPieLog.i(str, this.mSlotId + ":::show:::RewardedVideoState is not ready.");
                } else {
                    AdPieLog.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                }
                RewardedAdListener rewardedAdListener2 = this.mRewardedAdListener;
                if (rewardedAdListener2 != null) {
                    rewardedAdListener2.onAdFailedToShow();
                    return;
                }
                return;
            }
            AdPieLog.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            RewardedAdListener rewardedAdListener3 = this.mRewardedAdListener;
            if (rewardedAdListener3 != null) {
                rewardedAdListener3.onAdFailedToShow();
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            RewardedAdListener rewardedAdListener4 = this.mRewardedAdListener;
            if (rewardedAdListener4 != null) {
                rewardedAdListener4.onAdFailedToShow();
            }
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

    private enum RewardedState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
