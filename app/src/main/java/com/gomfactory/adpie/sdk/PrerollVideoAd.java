package com.gomfactory.adpie.sdk;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.controller.AdController;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import com.gomfactory.adpie.sdk.videoads.VideoAdData;
import com.gomfactory.adpie.sdk.videoads.VideoAdPlaybackListener;
import com.gomfactory.adpie.sdk.videoads.VideoAdView;

/* JADX INFO: loaded from: classes3.dex */
public class PrerollVideoAd {
    public static final String TAG = "PrerollVideoAd";
    private AdData adData;
    private boolean initialized;
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private Thread mAdThread;
    private Context mContext;
    private boolean mIsLoading;
    private String mSlotId;
    private TargetingData mTargetingData;
    private VideoAdView mVideoAdView;
    private final Handler mHandler = new Handler(Looper.getMainLooper());
    private AdListener mAdListener = null;
    private VideoAdPlaybackListener mVideoAdPlaybackListener = null;
    private VideoState mVideoState = VideoState.NOT_READY;

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded();
    }

    public PrerollVideoAd(Context context, String str, VideoAdView videoAdView) {
        this.mContext = context;
        this.mVideoAdView = videoAdView;
        this.mSlotId = str;
        init();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        AdPieLog.d(TAG, this.mSlotId + ":::init");
        addEventListener();
        this.mAdController = new AdController(this.mContext, this.mAdEventListener);
        this.initialized = true;
    }

    public AdListener getAdListener() {
        return this.mAdListener;
    }

    public void setAdListener(AdListener adListener) {
        this.mAdListener = adListener;
    }

    public VideoAdPlaybackListener getVideoAdPlaybackListener() {
        return this.mVideoAdPlaybackListener;
    }

    public void setVideoAdPlaybackListener(VideoAdPlaybackListener videoAdPlaybackListener) {
        this.mVideoAdPlaybackListener = videoAdPlaybackListener;
    }

    public boolean isPlaying() {
        VideoAdView videoAdView = this.mVideoAdView;
        if (videoAdView != null) {
            return videoAdView.isPlaying();
        }
        return false;
    }

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (PrerollVideoAd.this.mAdEventListener != null) {
                                    PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                PrerollVideoAd.this.adData = adResponse.getAdData();
                                if (PrerollVideoAd.this.adData != null) {
                                    if (PrerollVideoAd.this.adData.getIcType() == 42) {
                                        PrerollVideoAd.this.preloadResource();
                                    } else {
                                        AdPieLog.i(PrerollVideoAd.TAG, "'" + PrerollVideoAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (PrerollVideoAd.this.mAdEventListener != null) {
                                            PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (PrerollVideoAd.this.mAdEventListener != null) {
                                    PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (PrerollVideoAd.this.mAdEventListener != null) {
                                PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (PrerollVideoAd.this.mAdEventListener != null) {
                            PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(PrerollVideoAd.TAG, e);
                        }
                        if (PrerollVideoAd.this.mAdEventListener != null) {
                            PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(Object... objArr) {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyAdLoaded");
                        PrerollVideoAd.this.mIsLoading = false;
                        if (PrerollVideoAd.this.mAdListener != null) {
                            PrerollVideoAd.this.mAdListener.onAdLoaded();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        PrerollVideoAd.this.mVideoState = VideoState.NOT_READY;
                        PrerollVideoAd.this.adData = null;
                        if (i != 106) {
                            PrerollVideoAd.this.mIsLoading = false;
                        }
                        if (PrerollVideoAd.this.mAdListener != null) {
                            PrerollVideoAd.this.mAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyAdClicked");
                        if (PrerollVideoAd.this.mAdListener != null) {
                            PrerollVideoAd.this.mAdListener.onAdClicked();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyVideoAdStarted");
                        if (PrerollVideoAd.this.mVideoAdPlaybackListener != null) {
                            PrerollVideoAd.this.mVideoAdPlaybackListener.onVideoAdStarted();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyVideoAdSkipped");
                        if (PrerollVideoAd.this.mVideoAdPlaybackListener != null) {
                            PrerollVideoAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.SKIPPED);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyVideoAdError");
                        if (PrerollVideoAd.this.mVideoAdPlaybackListener != null) {
                            PrerollVideoAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.ERROR);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
                PrerollVideoAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::notifyVideoAdCompleted");
                        if (PrerollVideoAd.this.mVideoAdPlaybackListener != null) {
                            PrerollVideoAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.COMPLETED);
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
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.PrerollVideoAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(PrerollVideoAd.TAG, PrerollVideoAd.this.mSlotId + ":::load");
                        PrerollVideoAd.this.mVideoState = VideoState.NOT_READY;
                        PrerollVideoAd.this.adData = null;
                        if (!PrerollVideoAd.this.initialized) {
                            PrerollVideoAd.this.init();
                        }
                        PrerollVideoAd.this.mAdController.setSlotID(PrerollVideoAd.this.mSlotId);
                        PrerollVideoAd.this.mAdController.setTargetingData(PrerollVideoAd.this.mTargetingData);
                        PrerollVideoAd.this.mAdController.loadAd();
                    } catch (Exception e) {
                        AdPieLog.e(PrerollVideoAd.TAG, e);
                        if (PrerollVideoAd.this.mAdEventListener != null) {
                            PrerollVideoAd.this.mAdEventListener.notifyAdFailedToLoad(104);
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
        this.mVideoState = VideoState.READY;
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
                if (this.mVideoState.isReady() && (adData = this.adData) != null) {
                    this.mVideoAdView.playVideo(this.mAdEventListener, (VideoAdData) adData);
                    return true;
                }
                if (this.adData == null) {
                    AdPieLog.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                } else {
                    AdPieLog.i(str, this.mSlotId + ":::show:::VideoState is not ready.");
                }
            } else {
                AdPieLog.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            }
        } catch (Exception e) {
            AdPieLog.e(TAG, e);
        }
        AdEventListener adEventListener = this.mAdEventListener;
        if (adEventListener == null) {
            return false;
        }
        adEventListener.notifyVideoAdError();
        return false;
    }

    public boolean isLoaded() {
        return this.mVideoState.isReady();
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
    }

    private enum VideoState {
        NOT_READY,
        READY;

        boolean isReady() {
            return this == READY;
        }
    }
}
