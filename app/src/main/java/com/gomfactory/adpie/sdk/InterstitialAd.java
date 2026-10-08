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
import com.gomfactory.adpie.sdk.ui.webview.AdWebView;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import com.gomfactory.adpie.sdk.videoads.VideoAdPlaybackListener;
import com.gomfactory.adpie.sdk.videoads.VideoFullScreenActivity;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class InterstitialAd {
    public static final String TAG = "InterstitialAd";
    private AdData adData;
    private boolean initialized;
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private Thread mAdThread;
    private AdWebView mAdWebView;
    private Context mContext;
    private HashMap<String, String> mHashMap;
    private boolean mIsLoading;
    private OnPaidEventListener mOnPaidEventListener;
    private String mSlotId;
    private TargetingData mTargetingData;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private InterstitialAdListener mInterstitialAdListener = null;
    private VideoAdPlaybackListener mVideoAdPlaybackListener = null;
    private InterstitialState mInterstitialState = InterstitialState.NOT_READY;

    public interface InterstitialAdListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdFailedToLoad(int i);

        void onAdFailedToShow();

        void onAdLoaded();

        void onAdShown();
    }

    public interface OnPaidEventListener {
        void onPaidEvent(double d);
    }

    public InterstitialAd(Context context, String str) {
        this.mContext = context;
        this.mSlotId = str;
        init();
    }

    public InterstitialAdListener getAdListener() {
        return this.mInterstitialAdListener;
    }

    public void setAdListener(InterstitialAdListener interstitialAdListener) {
        this.mInterstitialAdListener = interstitialAdListener;
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.mOnPaidEventListener = onPaidEventListener;
    }

    public void setVideoAdPlaybackListener(VideoAdPlaybackListener videoAdPlaybackListener) {
        this.mVideoAdPlaybackListener = videoAdPlaybackListener;
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
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (InterstitialAd.this.mAdEventListener != null) {
                                    InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                InterstitialAd.this.adData = adResponse.getAdData();
                                if (InterstitialAd.this.adData != null) {
                                    if (InterstitialAd.this.adData.getIcType() == 21) {
                                        String admImageTag = InterstitialAd.this.adData.getAdmImageTag();
                                        if (!TextUtils.isEmpty(admImageTag)) {
                                            InterstitialAd.this.preloadHtml(admImageTag);
                                        } else {
                                            InterstitialAd.this.preloadHtml("");
                                        }
                                    } else if (InterstitialAd.this.adData.getIcType() == 22) {
                                        InterstitialAd.this.preloadResource();
                                    } else {
                                        AdPieLog.i(InterstitialAd.TAG, "'" + InterstitialAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (InterstitialAd.this.mAdEventListener != null) {
                                            InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (InterstitialAd.this.mAdEventListener != null) {
                                    InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (InterstitialAd.this.mAdEventListener != null) {
                                InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(InterstitialAd.TAG, e);
                        }
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyAdLoaded");
                        InterstitialAd.this.mIsLoading = false;
                        if (InterstitialAd.this.mInterstitialAdListener != null) {
                            InterstitialAd.this.mInterstitialAdListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        InterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                        InterstitialAd.this.adData = null;
                        if (i != 106) {
                            InterstitialAd.this.mIsLoading = false;
                        }
                        if (InterstitialAd.this.mInterstitialAdListener != null) {
                            InterstitialAd.this.mInterstitialAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyAdShown");
                        InterstitialAd.this.mInterstitialState = InterstitialState.SHOW;
                        if (InterstitialAd.this.mInterstitialAdListener != null) {
                            InterstitialAd.this.mInterstitialAdListener.onAdShown();
                        }
                        if (InterstitialAd.this.mOnPaidEventListener == null || InterstitialAd.this.adData == null) {
                            return;
                        }
                        InterstitialAd.this.mOnPaidEventListener.onPaidEvent(InterstitialAd.this.adData.getEcpm());
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyAdDismissed");
                        InterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                        if (InterstitialAd.this.mInterstitialAdListener != null) {
                            InterstitialAd.this.mInterstitialAdListener.onAdDismissed();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyAdClicked");
                        if (InterstitialAd.this.mInterstitialAdListener != null) {
                            InterstitialAd.this.mInterstitialAdListener.onAdClicked();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyVideoAdStarted");
                        if (InterstitialAd.this.mVideoAdPlaybackListener != null) {
                            InterstitialAd.this.mVideoAdPlaybackListener.onVideoAdStarted();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyVideoAdSkipped");
                        if (InterstitialAd.this.mVideoAdPlaybackListener != null) {
                            InterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.SKIPPED);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyVideoAdError");
                        if (InterstitialAd.this.mVideoAdPlaybackListener != null) {
                            InterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.ERROR);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
                InterstitialAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::notifyVideoAdCompleted");
                        if (InterstitialAd.this.mVideoAdPlaybackListener != null) {
                            InterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.COMPLETED);
                        }
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
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(InterstitialAd.TAG, InterstitialAd.this.mSlotId + ":::load");
                        InterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                        InterstitialAd.this.adData = null;
                        if (!InterstitialAd.this.initialized) {
                            InterstitialAd.this.init();
                        }
                        InterstitialAd.this.mAdController.setSlotID(InterstitialAd.this.mSlotId);
                        InterstitialAd.this.mAdController.setTargetingData(InterstitialAd.this.mTargetingData);
                        InterstitialAd.this.mAdController.loadAd(InterstitialAd.this.mHashMap);
                    } catch (Exception e) {
                        AdPieLog.e(InterstitialAd.TAG, e);
                        if (InterstitialAd.this.mAdEventListener != null) {
                            InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(104);
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
    public void preloadHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mInterstitialState = InterstitialState.READY;
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdLoaded(new Object[0]);
                return;
            }
            return;
        }
        String str2 = TAG;
        AdPieLog.d(str2, this.mSlotId + ":::preloadHtml - " + str);
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
        AdWebView adWebView2 = new AdWebView(this.mContext);
        this.mAdWebView = adWebView2;
        adWebView2.setWebViewEventListener(new AdWebView.WebViewEventListener() { // from class: com.gomfactory.adpie.sdk.InterstitialAd.3
            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onUserClick(String str3) {
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageFinished() {
                InterstitialAd.this.mInterstitialState = InterstitialState.READY;
                if (InterstitialAd.this.mAdEventListener != null) {
                    InterstitialAd.this.mAdEventListener.notifyAdLoaded(new Object[0]);
                }
            }

            @Override // com.gomfactory.adpie.sdk.ui.webview.AdWebView.WebViewEventListener
            public void onPageDelayed() {
                InterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                InterstitialAd.this.adData = null;
                if (InterstitialAd.this.mAdWebView != null) {
                    InterstitialAd.this.mAdWebView.setWebViewEventListener(null);
                    InterstitialAd.this.mAdWebView.destroy();
                    InterstitialAd.this.mAdWebView = null;
                }
                if (InterstitialAd.this.mAdEventListener != null) {
                    InterstitialAd.this.mAdEventListener.notifyAdFailedToLoad(107);
                }
            }
        });
        AdPieLog.d(str2, this.mSlotId + ":::AdWebView-loadData");
        this.mAdWebView.loadData(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadResource() {
        this.mInterstitialState = InterstitialState.READY;
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
                if (this.mInterstitialState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 21) {
                        InterstitialActivity.start(this.mContext, InterstitialActivity.class, this.mSlotId, this.adData, null, null, this.mAdEventListener);
                        return;
                    }
                    if (this.adData.getIcType() == 22) {
                        VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, null, null, this.mAdEventListener);
                        return;
                    }
                    AdPieLog.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
                    if (interstitialAdListener != null) {
                        interstitialAdListener.onAdFailedToShow();
                        return;
                    }
                    return;
                }
                if (!this.mInterstitialState.isReady()) {
                    AdPieLog.i(str, this.mSlotId + ":::show:::InterstitialState is not ready.");
                } else {
                    AdPieLog.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                }
                InterstitialAdListener interstitialAdListener2 = this.mInterstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdFailedToShow();
                    return;
                }
                return;
            }
            AdPieLog.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            InterstitialAdListener interstitialAdListener3 = this.mInterstitialAdListener;
            if (interstitialAdListener3 != null) {
                interstitialAdListener3.onAdFailedToShow();
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
            InterstitialAdListener interstitialAdListener4 = this.mInterstitialAdListener;
            if (interstitialAdListener4 != null) {
                interstitialAdListener4.onAdFailedToShow();
            }
        }
    }

    public boolean isLoaded() {
        return this.mInterstitialState.isReady();
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
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
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

    private enum InterstitialState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
