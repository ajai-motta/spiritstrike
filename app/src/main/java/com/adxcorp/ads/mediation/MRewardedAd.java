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
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.ads.mediation.videoads.VideoFullScreenActivity;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
public class MRewardedAd {
    public static final String TAG = "MRewardedAd";
    private AdData adData;
    private AdController mAdController;
    private Context mContext;
    private FinishState mFinishState;
    private InhouseAdEventListener mInhouseAdEventListener;
    private RewardedAdListener mRewardedAdListener = null;
    private RewardedVideoState mRewardedVideoState = RewardedVideoState.NOT_READY;
    private HashMap<String, String> mSSVOptions;
    private String mSlotId;

    public interface RewardedAdListener {
        void onAdClicked();

        void onAdDismissed();

        void onAdFailedToLoad(int i);

        void onAdFailedToShow();

        void onAdLoaded();

        void onAdRewarded();

        void onAdShown();

        void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings);
    }

    public MRewardedAd(Context context, String str) {
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

    public void setSSVOption(String str, String str2) {
        HashMap<String, String> map = this.mSSVOptions;
        if (map == null) {
            this.mSSVOptions = new HashMap<>();
        } else {
            map.clear();
        }
        if (!TextUtils.isEmpty(str)) {
            this.mSSVOptions.put("userId", str);
        }
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        this.mSSVOptions.put("customData", str2);
    }

    private void init() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::init");
        try {
            Class.forName("androidx.localbroadcastmanager.content.LocalBroadcastManager");
            addEventListener();
            this.mAdController = new AdController(this.mContext, this.mInhouseAdEventListener);
        } catch (ClassNotFoundException e) {
            ADXLogUtil.e(TAG, e);
        }
    }

    private void addEventListener() {
        this.mInhouseAdEventListener = new InhouseAdEventListener() { // from class: com.adxcorp.ads.mediation.MRewardedAd.1
            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void receivedResponse(AdResponse adResponse) {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (MRewardedAd.this.mInhouseAdEventListener != null) {
                                    MRewardedAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                MRewardedAd.this.adData = adResponse.getAdData();
                                if (MRewardedAd.this.adData != null) {
                                    if (MRewardedAd.this.adData.getIcType() == 52) {
                                        MRewardedAd.this.preloadResource();
                                    } else {
                                        ADXLogUtil.i(MRewardedAd.TAG, "'" + MRewardedAd.this.adData.getIcType() + "' inventory and contentType are not matched.");
                                        if (MRewardedAd.this.mInhouseAdEventListener != null) {
                                            MRewardedAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    }
                                } else if (MRewardedAd.this.mInhouseAdEventListener != null) {
                                    MRewardedAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            }
                        } else if (result == 204) {
                            if (MRewardedAd.this.mInhouseAdEventListener != null) {
                                MRewardedAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (MRewardedAd.this.mInhouseAdEventListener != null) {
                            MRewardedAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                            ADXLogUtil.e(MRewardedAd.TAG, e);
                        }
                        notifyAdFailedToLoad(104);
                    }
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed) {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyMediationLoaded");
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onMediationLoaded(arrayList, mediationSettings);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdLoaded(Object... objArr) {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyAdLoaded");
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdLoaded();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdFailedToLoad(int i) {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                MRewardedAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                MRewardedAd.this.adData = null;
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdFailedToLoad(i);
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdShown() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyAdShown");
                MRewardedAd.this.mRewardedVideoState = RewardedVideoState.SHOW;
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdDismissed() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyAdDismissed - " + MRewardedAd.this.mFinishState);
                MRewardedAd.this.mRewardedVideoState = RewardedVideoState.NOT_READY;
                if (MRewardedAd.this.mFinishState == FinishState.COMPLETED && MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdRewarded();
                }
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdDismissed();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyAdClicked() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyAdClicked");
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdClicked();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdStarted() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyVideoAdStarted");
                if (MRewardedAd.this.mRewardedAdListener != null) {
                    MRewardedAd.this.mRewardedAdListener.onAdShown();
                }
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdSkipped() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyVideoAdSkipped");
                MRewardedAd.this.mFinishState = FinishState.SKIPPED;
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdError() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyVideoAdError");
                MRewardedAd.this.mFinishState = FinishState.ERROR;
            }

            @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
            public void notifyVideoAdCompleted() {
                ADXLogUtil.d(MRewardedAd.TAG, MRewardedAd.this.mSlotId + ":::notifyVideoAdCompleted");
                MRewardedAd.this.mFinishState = FinishState.COMPLETED;
            }
        };
    }

    private void removeEventListener() {
        this.mInhouseAdEventListener = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void preloadResource() {
        this.mRewardedVideoState = RewardedVideoState.READY;
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
                if (this.mRewardedVideoState.isReady() && (adData = this.adData) != null) {
                    if (adData.getIcType() == 52) {
                        VideoFullScreenActivity.start(this.mContext, VideoFullScreenActivity.class, this.mSlotId, this.adData, this.mInhouseAdEventListener);
                        return;
                    }
                    ADXLogUtil.i(str, ":::show:::'" + this.adData.getIcType() + "' inventory and contentType are not matched.");
                    RewardedAdListener rewardedAdListener = this.mRewardedAdListener;
                    if (rewardedAdListener != null) {
                        rewardedAdListener.onAdFailedToShow();
                        return;
                    }
                    return;
                }
                if (this.adData == null) {
                    ADXLogUtil.i(str, this.mSlotId + ":::show:::Ads data cannot be null.");
                } else {
                    ADXLogUtil.i(str, this.mSlotId + ":::show:::RewardedVideoState is not ready.");
                }
                RewardedAdListener rewardedAdListener2 = this.mRewardedAdListener;
                if (rewardedAdListener2 != null) {
                    rewardedAdListener2.onAdFailedToShow();
                    return;
                }
                return;
            }
            ADXLogUtil.i(str, this.mSlotId + ":::show:::Check your internet connection.");
            RewardedAdListener rewardedAdListener3 = this.mRewardedAdListener;
            if (rewardedAdListener3 != null) {
                rewardedAdListener3.onAdFailedToShow();
            }
        } catch (Exception e) {
            ADXLogUtil.e(TAG, e);
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
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
        HashMap<String, String> map = this.mSSVOptions;
        if (map != null) {
            map.clear();
            this.mSSVOptions = null;
        }
        AdController adController = this.mAdController;
        if (adController != null) {
            adController.destroy();
            this.mAdController = null;
        }
        removeEventListener();
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

    private enum RewardedVideoState {
        NOT_READY,
        READY,
        SHOW;

        boolean isReady() {
            return this == READY;
        }
    }
}
