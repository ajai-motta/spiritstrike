package com.adxcorp.ads.mediation;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.AdResponse;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.ui.webview.AdWebView;
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.ads.mediation.videoads.VideoAdPlaybackListener;
import com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class MInterstitialAd {
    public static final String TAG = "MInterstitialAd";
    private AdData adData;
    private boolean initialized;
    private AdController mAdController;
    private AdWebView mAdWebView;
    private Context mContext;
    private InhouseAdEventListener mInhouseAdEventListener;
    private String mSlotId;
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

        void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings);
    }

    public MInterstitialAd(Context context, String str) {
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

    public void setVideoAdPlaybackListener(VideoAdPlaybackListener videoAdPlaybackListener) {
        this.mVideoAdPlaybackListener = videoAdPlaybackListener;
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::init");
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            addEventListener();
            this.mAdController = new AdController(this.mContext, this.mInhouseAdEventListener);
            this.initialized = true;
        } catch (ClassNotFoundException e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void addEventListener() {
        this.mInhouseAdEventListener = new InhouseAdEventListener() { // from class: com.adxcorp.ads.mediation.MInterstitialAd.1
            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void receivedResponse(AdResponse adResponse) {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                                    MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                MInterstitialAd.this.adData = adResponse.getAdData();
                                if (MInterstitialAd.this.adData != null) {
                                    if (MInterstitialAd.this.adData.getIcType() == 21) {
                                        String admImageTag = MInterstitialAd.this.adData.getAdmImageTag();
                                        if (!TextUtils.isEmpty(admImageTag)) {
                                            MInterstitialAd.this.preloadHtml(admImageTag);
                                        } else {
                                            MInterstitialAd.this.preloadHtml("");
                                        }
                                    } else if (MInterstitialAd.this.adData.getIcType() == 22) {
                                        MInterstitialAd.this.preloadResource();
                                    } else {
                                        ADXLogUtil.i(MInterstitialAd.TAG, "'" + MInterstitialAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                                            MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                                    MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                                MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                            MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(MInterstitialAd.TAG, e);
                        }
                        notifyAdFailedToLoad(104);
                    }
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyMediationLoaded");
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onMediationLoaded(arrayList, mediationSettings);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdLoaded(Object... objArr) {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyAdLoaded");
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdFailedToLoad(int i) {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                MInterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                MInterstitialAd.this.adData = null;
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onAdFailedToLoad(i);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdShown() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyAdShown");
                MInterstitialAd.this.mInterstitialState = InterstitialState.SHOW;
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onAdShown();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdDismissed() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyAdDismissed");
                MInterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onAdDismissed();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdClicked() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyAdClicked");
                if (MInterstitialAd.this.mInterstitialAdListener != null) {
                    MInterstitialAd.this.mInterstitialAdListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStarted() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyVideoAdStarted");
                if (MInterstitialAd.this.mVideoAdPlaybackListener != null) {
                    MInterstitialAd.this.mVideoAdPlaybackListener.onVideoAdStarted();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdSkipped() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyVideoAdSkipped");
                if (MInterstitialAd.this.mVideoAdPlaybackListener != null) {
                    MInterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.SKIPPED);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdError() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyVideoAdError");
                if (MInterstitialAd.this.mVideoAdPlaybackListener != null) {
                    MInterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.ERROR);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdCompleted() {
                ADXLogUtil.d(MInterstitialAd.TAG, MInterstitialAd.this.mSlotId + ":::notifyVideoAdCompleted");
                if (MInterstitialAd.this.mVideoAdPlaybackListener != null) {
                    MInterstitialAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.COMPLETED);
                }
            }
        };
    }

    private void removeEventListener() {
        this.mInhouseAdEventListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadHtml(String str) {
        if (TextUtils.isEmpty(str)) {
            this.mInterstitialState = InterstitialState.READY;
            InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
            if (inhouseAdEventListener != null) {
                inhouseAdEventListener.notifyAdLoaded(new Object[0]);
                return;
            }
            return;
        }
        String str2 = TAG;
        ADXLogUtil.d(str2, this.mSlotId + ":::preloadHtml - " + str);
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
        AdWebView adWebView2 = new AdWebView(this.mContext);
        this.mAdWebView = adWebView2;
        adWebView2.setWebViewEventListener(new AdWebView.WebViewEventListener() { // from class: com.adxcorp.ads.mediation.MInterstitialAd.2
            @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewEventListener
            public void onUserClick(String str3) {
            }

            @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewEventListener
            public void onPageFinished() {
                MInterstitialAd.this.mInterstitialState = InterstitialState.READY;
                if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                    MInterstitialAd.this.mInhouseAdEventListener.notifyAdLoaded(new Object[0]);
                }
            }

            @Override // com.adxcorp.ads.mediation.ui.webview.AdWebView.WebViewEventListener
            public void onPageDelayed() {
                MInterstitialAd.this.mInterstitialState = InterstitialState.NOT_READY;
                MInterstitialAd.this.adData = null;
                if (MInterstitialAd.this.mAdWebView != null) {
                    MInterstitialAd.this.mAdWebView.setWebViewEventListener(null);
                    MInterstitialAd.this.mAdWebView.destroy();
                    MInterstitialAd.this.mAdWebView = null;
                }
                if (MInterstitialAd.this.mInhouseAdEventListener != null) {
                    MInterstitialAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(107);
                }
            }
        });
        ADXLogUtil.d(str2, this.mSlotId + ":::AdWebView-loadData");
        this.mAdWebView.loadData(str, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadResource() {
        this.mInterstitialState = InterstitialState.READY;
        InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
        if (inhouseAdEventListener != null) {
            inhouseAdEventListener.notifyAdLoaded(new Object[0]);
        }
    }

    public void show() {
        AdData adData;
        String str = TAG;
        ADXLogUtil.d(str, this.mSlotId + ":::show:::" + MediationSDK.getInstance().getNetworkConnectionType() + "," + Build.VERSION.SDK_INT);
        try {
            if (MediationSDK.getInstance().getNetworkConnectionType() != 0) {
                if (this.mInterstitialState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 21) {
                        InterstitialActivity.start(this.mContext, InterstitialActivity.class, this.mSlotId, this.adData, this.mInhouseAdEventListener);
                        return;
                    }
                    if (this.adData.getIcType() == 22) {
                        VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, this.mInhouseAdEventListener);
                        return;
                    }
                    ADXLogUtil.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    InterstitialAdListener interstitialAdListener = this.mInterstitialAdListener;
                    if (interstitialAdListener != null) {
                        interstitialAdListener.onAdFailedToShow();
                        return;
                    }
                    return;
                }
                if (this.adData == null) {
                    ADXLogUtil.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                } else {
                    ADXLogUtil.i(str, this.mSlotId + ":::show:::InterstitialState is not ready.");
                }
                InterstitialAdListener interstitialAdListener2 = this.mInterstitialAdListener;
                if (interstitialAdListener2 != null) {
                    interstitialAdListener2.onAdFailedToShow();
                    return;
                }
                return;
            }
            ADXLogUtil.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            InterstitialAdListener interstitialAdListener3 = this.mInterstitialAdListener;
            if (interstitialAdListener3 != null) {
                interstitialAdListener3.onAdFailedToShow();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
        AdWebView adWebView = this.mAdWebView;
        if (adWebView != null) {
            adWebView.setWebViewEventListener(null);
            this.mAdWebView.destroy();
            this.mAdWebView = null;
        }
    }

    public void parsingBidResponse(MediationData mediationData) {
        AdController adController = this.mAdController;
        if (adController == null) {
            ADXLogUtil.d(TAG, "AdController cannot be null.");
            InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
            if (inhouseAdEventListener != null) {
                inhouseAdEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        if (mediationData == null) {
            ADXLogUtil.d(TAG, "Mediation data cannot be null.");
            InhouseAdEventListener inhouseAdEventListener2 = this.mInhouseAdEventListener;
            if (inhouseAdEventListener2 != null) {
                inhouseAdEventListener2.notifyAdFailedToLoad(108);
                return;
            }
            return;
        }
        adController.parsingBidResponse(mediationData);
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
