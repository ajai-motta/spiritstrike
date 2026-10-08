package com.adxcorp.ads.mediation;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.adxcorp.ads.common.MediationData;
import com.adxcorp.ads.common.MediationSettings;
import com.adxcorp.ads.common.NewsFeed;
import com.adxcorp.ads.mediation.common.AdData;
import com.adxcorp.ads.mediation.common.AdResponse;
import com.adxcorp.ads.mediation.controller.AdController;
import com.adxcorp.ads.mediation.event.InhouseAdEventListener;
import com.adxcorp.ads.mediation.nativeads.MainAdView;
import com.adxcorp.ads.mediation.nativeads.NativeAdData;
import com.adxcorp.ads.mediation.nativeads.NativeAdView;
import com.adxcorp.ads.mediation.nativeads.NativeAdViewBinder;
import com.adxcorp.ads.mediation.util.MemUtil;
import com.adxcorp.ads.mediation.videoads.FinishState;
import com.adxcorp.ads.mediation.videoads.VideoAdPlaybackListener;
import com.adxcorp.util.ADXLogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes2.dex */
public class MNativeAd {
    public static final String TAG = "MNativeAd";
    private HashMap<String, String> hashMap;
    private AdController mAdController;
    private AdListener mAdListener;
    private Context mContext;
    private final Handler mHandler;
    private InhouseAdEventListener mInhouseAdEventListener;
    private boolean mIsSkipDownload;
    private NativeAdViewBinder mNativeAdViewBinder;
    private String mSlotId;
    private VideoAdPlaybackListener mVideoAdPlaybackListener;

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded(NativeAdView nativeAdView);

        void onAdShown();

        void onMediationLoaded(ArrayList<MediationData> arrayList, MediationSettings mediationSettings, NewsFeed newsFeed);
    }

    public MNativeAd(Context context, NativeAdViewBinder nativeAdViewBinder) {
        this.mHandler = new Handler(Looper.getMainLooper());
        init(context, nativeAdViewBinder);
    }

    public MNativeAd(Context context, String str, NativeAdViewBinder nativeAdViewBinder) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mInhouseAdEventListener = null;
        this.mVideoAdPlaybackListener = null;
        this.mSlotId = str;
        init(context, nativeAdViewBinder);
    }

    private void init(Context context, NativeAdViewBinder nativeAdViewBinder) {
        String str = TAG;
        ADXLogUtil.d(str, this.mSlotId + ":::init");
        if (context == null) {
            ADXLogUtil.e(str, new Exception("Context cannot be null."));
            InhouseAdEventListener inhouseAdEventListener = this.mInhouseAdEventListener;
            if (inhouseAdEventListener != null) {
                inhouseAdEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        this.mContext = context;
        this.mNativeAdViewBinder = nativeAdViewBinder;
        addEventListener();
        checkAssets();
        this.mAdController = new AdController(this.mContext, this.mInhouseAdEventListener);
        MemUtil.setMemoryError(false);
    }

    public String getSlotId() {
        return this.mSlotId;
    }

    public void setSlotId(String str) {
        this.mSlotId = str;
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

    /* JADX INFO: renamed from: com.adxcorp.ads.mediation.MNativeAd$1, reason: invalid class name */
    class AnonymousClass1 implements InhouseAdEventListener {
        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyAdDismissed() {
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdPaused() {
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdStopped() {
        }

        AnonymousClass1() {
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void receivedResponse(AdResponse adResponse) {
            ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::receivedResponse");
            if (adResponse != null) {
                try {
                    int result = adResponse.getResult();
                    if (result == 0) {
                        if (adResponse.getCount() != 1) {
                            if (MNativeAd.this.mInhouseAdEventListener != null) {
                                MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else {
                            AdData adData = adResponse.getAdData();
                            if (adData == null) {
                                if (MNativeAd.this.mInhouseAdEventListener != null) {
                                    MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else if (adData.getIcType() == 31 || adData.getIcType() == 32) {
                                final NativeAdView nativeAdView = new NativeAdView(MNativeAd.this.mContext, MNativeAd.this.mNativeAdViewBinder, MNativeAd.this.mInhouseAdEventListener);
                                int iFillAd = nativeAdView.fillAd((NativeAdData) adData);
                                if (iFillAd == 0) {
                                    if (!MNativeAd.this.mIsSkipDownload) {
                                        nativeAdView.downloadResource(new NativeAdView.ResourceLoadEventListener() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.1
                                            @Override // com.adxcorp.ads.mediation.nativeads.NativeAdView.ResourceLoadEventListener
                                            public void onSuccess() {
                                                nativeAdView.setupOptOut();
                                                ADXLogUtil.d(MNativeAd.TAG, ":::downloadResource:::onSuccess");
                                                if (MNativeAd.this.mInhouseAdEventListener != null) {
                                                    MNativeAd.this.mInhouseAdEventListener.notifyAdLoaded(nativeAdView);
                                                }
                                            }

                                            @Override // com.adxcorp.ads.mediation.nativeads.NativeAdView.ResourceLoadEventListener
                                            public void onError() {
                                                ADXLogUtil.d(MNativeAd.TAG, ":::downloadResource:::onError");
                                                if (MNativeAd.this.mInhouseAdEventListener != null) {
                                                    MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(107);
                                                }
                                            }
                                        });
                                    } else {
                                        nativeAdView.setupOptOut();
                                        if (MNativeAd.this.mInhouseAdEventListener != null) {
                                            MNativeAd.this.mInhouseAdEventListener.notifyAdLoaded(nativeAdView);
                                        }
                                    }
                                } else if (iFillAd / 10 == -1) {
                                    if (MNativeAd.this.mInhouseAdEventListener != null) {
                                        MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(109);
                                    }
                                } else if (iFillAd / 10 == -2) {
                                    if (MNativeAd.this.mInhouseAdEventListener != null) {
                                        MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(108);
                                    }
                                } else if (MNativeAd.this.mInhouseAdEventListener != null) {
                                    MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(107);
                                }
                            } else {
                                ADXLogUtil.i(MNativeAd.TAG, "'" + adData.getIcType() + "' inventory and contentType are not matched.");
                                if (MNativeAd.this.mInhouseAdEventListener != null) {
                                    MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(108);
                                }
                            }
                        }
                    } else if (result == 204) {
                        if (MNativeAd.this.mInhouseAdEventListener != null) {
                            MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(100);
                        }
                    } else if (MNativeAd.this.mInhouseAdEventListener != null) {
                        MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(101);
                    }
                } catch (Exception e) {
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.e(MNativeAd.TAG, e);
                    }
                    if (MNativeAd.this.mInhouseAdEventListener != null) {
                        MNativeAd.this.mInhouseAdEventListener.notifyAdFailedToLoad(104);
                    }
                }
            }
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyMediationLoaded(final ArrayList<MediationData> arrayList, final MediationSettings mediationSettings, final NewsFeed newsFeed) {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.2
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyMediationLoaded");
                    if (MNativeAd.this.mAdListener != null) {
                        MNativeAd.this.mAdListener.onMediationLoaded(arrayList, mediationSettings, newsFeed);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyAdLoaded(final Object... objArr) {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.3
                @Override // java.lang.Runnable
                public void run() {
                    if (objArr[0] instanceof NativeAdView) {
                        ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyAdLoaded");
                        NativeAdView nativeAdView = (NativeAdView) objArr[0];
                        if (MNativeAd.this.mAdListener != null) {
                            MNativeAd.this.mAdListener.onAdLoaded(nativeAdView);
                            return;
                        }
                        return;
                    }
                    if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                        ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::param is not NativeAdView");
                    }
                    AnonymousClass1.this.notifyAdFailedToLoad(104);
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyAdFailedToLoad(final int i) {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.4
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                    if (MNativeAd.this.mAdListener != null) {
                        MNativeAd.this.mAdListener.onAdFailedToLoad(i);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyAdClicked() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.5
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyAdClicked");
                    if (MNativeAd.this.mAdListener != null) {
                        MNativeAd.this.mAdListener.onAdClicked();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyAdShown() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.6
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyAdShown");
                    if (MNativeAd.this.mAdListener != null) {
                        MNativeAd.this.mAdListener.onAdShown();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdStarted() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.7
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyVideoAdStarted");
                    if (MNativeAd.this.mVideoAdPlaybackListener != null) {
                        MNativeAd.this.mVideoAdPlaybackListener.onVideoAdStarted();
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdSkipped() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.8
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyVideoAdSkipped");
                    if (MNativeAd.this.mVideoAdPlaybackListener != null) {
                        MNativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.SKIPPED);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdError() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.9
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyVideoAdError");
                    if (MNativeAd.this.mVideoAdPlaybackListener != null) {
                        MNativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.ERROR);
                    }
                }
            });
        }

        @Override // com.adxcorp.ads.mediation.event.InhouseAdEventListener
        public void notifyVideoAdCompleted() {
            MNativeAd.this.mHandler.post(new Runnable() { // from class: com.adxcorp.ads.mediation.MNativeAd.1.10
                @Override // java.lang.Runnable
                public void run() {
                    ADXLogUtil.d(MNativeAd.TAG, MNativeAd.this.mSlotId + ":::notifyVideoAdCompleted");
                    if (MNativeAd.this.mVideoAdPlaybackListener != null) {
                        MNativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.COMPLETED);
                    }
                }
            });
        }
    }

    private void addEventListener() {
        this.mInhouseAdEventListener = new AnonymousClass1();
    }

    private void removeEventListener() {
        this.mInhouseAdEventListener = null;
    }

    private void checkAssets() {
        try {
            HashSet hashSet = new HashSet();
            if (this.mNativeAdViewBinder == null) {
                hashSet.add(NativeAsset.TITLE_ASSET);
                hashSet.add(NativeAsset.ICON_IMAGE_ASSET);
                hashSet.add(NativeAsset.DESCRIPTION_ASSET);
                hashSet.add(NativeAsset.MAIN_IMAGE_ASSET);
                hashSet.add(NativeAsset.CTA_ASSET);
            } else {
                ViewGroup viewGroup = (ViewGroup) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(this.mNativeAdViewBinder.getLayoutId(), (ViewGroup) null, false);
                if (viewGroup != null) {
                    if (((TextView) viewGroup.findViewById(this.mNativeAdViewBinder.getTitleId())) != null) {
                        hashSet.add(NativeAsset.TITLE_ASSET);
                    }
                    if (((ImageView) viewGroup.findViewById(this.mNativeAdViewBinder.getIconImageId())) != null) {
                        hashSet.add(NativeAsset.ICON_IMAGE_ASSET);
                    }
                    if (((RatingBar) viewGroup.findViewById(this.mNativeAdViewBinder.getRatingbarId())) != null) {
                        hashSet.add(NativeAsset.RATING_ASSET);
                    }
                    if (((TextView) viewGroup.findViewById(this.mNativeAdViewBinder.getDescriptionId())) != null) {
                        hashSet.add(NativeAsset.DESCRIPTION_ASSET);
                    }
                    if (((MainAdView) viewGroup.findViewById(this.mNativeAdViewBinder.getMainId())) != null) {
                        hashSet.add(NativeAsset.MAIN_IMAGE_ASSET);
                    }
                    if (((Button) viewGroup.findViewById(this.mNativeAdViewBinder.getCallToActionId())) != null) {
                        hashSet.add(NativeAsset.CTA_ASSET);
                    }
                }
            }
            if (hashSet.size() > 0) {
                EnumSet enumSetCopyOf = EnumSet.copyOf((Collection) hashSet);
                ADXLogUtil.d(TAG, this.mSlotId + ":::registered assets : " + enumSetCopyOf);
                HashMap<String, String> map = new HashMap<>();
                this.hashMap = map;
                map.put("assettype", enumSetCopyOf.toString());
            }
        } catch (Exception e) {
            if (MediationSDK.getInstance().getConfiguration().isSdkLog()) {
                ADXLogUtil.e(TAG, e);
            }
        }
    }

    public void setSkipDownload(boolean z) {
        this.mIsSkipDownload = z;
    }

    public void destroy() {
        ADXLogUtil.d(TAG, this.mSlotId + ":::destroy");
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

    public enum NativeAsset {
        TITLE_ASSET(1),
        ICON_IMAGE_ASSET(2),
        MAIN_IMAGE_ASSET(3),
        DESCRIPTION_ASSET(4),
        RATING_ASSET(5),
        CTA_ASSET(6);

        private final int mAssetName;

        NativeAsset(int i) {
            this.mAssetName = i;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.mAssetName);
        }
    }
}
