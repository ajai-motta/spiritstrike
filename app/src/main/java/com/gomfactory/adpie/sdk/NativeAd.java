package com.gomfactory.adpie.sdk;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import com.gomfactory.adpie.sdk.common.AdData;
import com.gomfactory.adpie.sdk.common.AdResponse;
import com.gomfactory.adpie.sdk.controller.AdController;
import com.gomfactory.adpie.sdk.event.AdEventListener;
import com.gomfactory.adpie.sdk.nativeads.MainAdView;
import com.gomfactory.adpie.sdk.nativeads.NativeAdData;
import com.gomfactory.adpie.sdk.nativeads.NativeAdView;
import com.gomfactory.adpie.sdk.nativeads.NativeAdViewBinder;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.MemUtil;
import com.gomfactory.adpie.sdk.videoads.FinishState;
import com.gomfactory.adpie.sdk.videoads.VideoAdPlaybackListener;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: classes3.dex */
public class NativeAd {
    public static final String TAG = "NativeAd";
    private AdController mAdController;
    private AdEventListener mAdEventListener;
    private AdListener mAdListener;
    private Thread mAdThread;
    private Context mContext;
    private final Handler mHandler;
    private HashMap<String, String> mHashMap;
    private boolean mIsLoading;
    private boolean mIsSkipDownload;
    private NativeAdViewBinder mNativeAdViewBinder;
    private String mSlotId;
    private TargetingData mTargetingData;
    private VideoAdPlaybackListener mVideoAdPlaybackListener;

    public interface AdListener {
        void onAdClicked();

        void onAdFailedToLoad(int i);

        void onAdLoaded(NativeAdView nativeAdView);

        void onAdShown();
    }

    public NativeAd(Context context, NativeAdViewBinder nativeAdViewBinder) {
        this.mHandler = new Handler(Looper.getMainLooper());
        init(context, nativeAdViewBinder);
    }

    public NativeAd(Context context, String str, NativeAdViewBinder nativeAdViewBinder) {
        this.mHandler = new Handler(Looper.getMainLooper());
        this.mAdEventListener = null;
        this.mVideoAdPlaybackListener = null;
        this.mSlotId = str;
        init(context, nativeAdViewBinder);
    }

    private void init(Context context, NativeAdViewBinder nativeAdViewBinder) {
        String str = TAG;
        AdPieLog.d(str, this.mSlotId + ":::init");
        if (context == null) {
            AdPieLog.e(str, new Exception("Context cannot be null."));
            AdEventListener adEventListener = this.mAdEventListener;
            if (adEventListener != null) {
                adEventListener.notifyAdFailedToLoad(104);
                return;
            }
            return;
        }
        this.mContext = context;
        this.mNativeAdViewBinder = nativeAdViewBinder;
        addEventListener();
        checkAssets();
        this.mAdController = new AdController(this.mContext, this.mAdEventListener);
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

    private void addEventListener() {
        this.mAdEventListener = new AdEventListener() { // from class: com.gomfactory.adpie.sdk.NativeAd.1
            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdDismissed() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdPaused() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStopped() {
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void receivedResponse(AdResponse adResponse) {
                AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::receivedResponse");
                if (adResponse != null) {
                    try {
                        int result = adResponse.getResult();
                        if (result == 0) {
                            if (adResponse.getCount() != 1) {
                                if (NativeAd.this.mAdEventListener != null) {
                                    NativeAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                }
                            } else {
                                AdData adData = adResponse.getAdData();
                                if (adData == null) {
                                    if (NativeAd.this.mAdEventListener != null) {
                                        NativeAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                                    }
                                } else if (adData.getIcType() == 31 || adData.getIcType() == 32) {
                                    final NativeAdView nativeAdView = new NativeAdView(NativeAd.this.mContext, NativeAd.this.mNativeAdViewBinder, NativeAd.this.mAdEventListener);
                                    int iFillAd = nativeAdView.fillAd((NativeAdData) adData);
                                    if (iFillAd == 0) {
                                        if (!NativeAd.this.mIsSkipDownload) {
                                            nativeAdView.downloadResource(new NativeAdView.ResourceLoadEventListener() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.1
                                                @Override // com.gomfactory.adpie.sdk.nativeads.NativeAdView.ResourceLoadEventListener
                                                public void onSuccess() {
                                                    nativeAdView.setupOptOut();
                                                    AdPieLog.d(NativeAd.TAG, ":::downloadResource:::onSuccess");
                                                    if (NativeAd.this.mAdEventListener != null) {
                                                        NativeAd.this.mAdEventListener.notifyAdLoaded(nativeAdView);
                                                    }
                                                }

                                                @Override // com.gomfactory.adpie.sdk.nativeads.NativeAdView.ResourceLoadEventListener
                                                public void onError() {
                                                    AdPieLog.d(NativeAd.TAG, ":::downloadResource:::onError");
                                                    if (NativeAd.this.mAdEventListener != null) {
                                                        NativeAd.this.mAdEventListener.notifyAdFailedToLoad(107);
                                                    }
                                                }
                                            });
                                        } else {
                                            nativeAdView.setupOptOut();
                                            if (NativeAd.this.mAdEventListener != null) {
                                                NativeAd.this.mAdEventListener.notifyAdLoaded(nativeAdView);
                                            }
                                        }
                                    } else if (iFillAd / 10 == -1) {
                                        if (NativeAd.this.mAdEventListener != null) {
                                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(109);
                                        }
                                    } else if (iFillAd / 10 == -2) {
                                        if (NativeAd.this.mAdEventListener != null) {
                                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                        }
                                    } else if (NativeAd.this.mAdEventListener != null) {
                                        NativeAd.this.mAdEventListener.notifyAdFailedToLoad(107);
                                    }
                                } else {
                                    AdPieLog.i(NativeAd.TAG, "'" + adData.getIcType() + "' inventory and contentType are not matched.");
                                    if (NativeAd.this.mAdEventListener != null) {
                                        NativeAd.this.mAdEventListener.notifyAdFailedToLoad(108);
                                    }
                                }
                            }
                        } else if (result == 204) {
                            if (NativeAd.this.mAdEventListener != null) {
                                NativeAd.this.mAdEventListener.notifyAdFailedToLoad(100);
                            }
                        } else if (NativeAd.this.mAdEventListener != null) {
                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(101);
                        }
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(NativeAd.TAG, e);
                        }
                        if (NativeAd.this.mAdEventListener != null) {
                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdLoaded(final Object... objArr) {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (objArr[0] instanceof NativeAdView) {
                            AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyAdLoaded");
                            NativeAdView nativeAdView = (NativeAdView) objArr[0];
                            NativeAd.this.mIsLoading = false;
                            if (NativeAd.this.mAdListener != null) {
                                NativeAd.this.mAdListener.onAdLoaded(nativeAdView);
                                return;
                            }
                            return;
                        }
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::param is not NativeAdView");
                        }
                        if (NativeAd.this.mAdEventListener != null) {
                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdFailedToLoad(final int i) {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyAdFailedToLoad:::" + i);
                        if (i != 106) {
                            NativeAd.this.mIsLoading = false;
                        }
                        if (NativeAd.this.mAdListener != null) {
                            NativeAd.this.mAdListener.onAdFailedToLoad(i);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdClicked() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.4
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyAdClicked");
                        if (NativeAd.this.mAdListener != null) {
                            NativeAd.this.mAdListener.onAdClicked();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyAdShown() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.5
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyAdShown");
                        if (NativeAd.this.mAdListener != null) {
                            NativeAd.this.mAdListener.onAdShown();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdStarted() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.6
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyVideoAdStarted");
                        if (NativeAd.this.mVideoAdPlaybackListener != null) {
                            NativeAd.this.mVideoAdPlaybackListener.onVideoAdStarted();
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdSkipped() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.7
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyVideoAdSkipped");
                        if (NativeAd.this.mVideoAdPlaybackListener != null) {
                            NativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.SKIPPED);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdError() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.8
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyVideoAdError");
                        if (NativeAd.this.mVideoAdPlaybackListener != null) {
                            NativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.ERROR);
                        }
                    }
                });
            }

            @Override // com.gomfactory.adpie.sdk.event.AdEventListener
            public void notifyVideoAdCompleted() {
                NativeAd.this.mHandler.post(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.1.9
                    @Override // java.lang.Runnable
                    public void run() {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::notifyVideoAdCompleted");
                        if (NativeAd.this.mVideoAdPlaybackListener != null) {
                            NativeAd.this.mVideoAdPlaybackListener.onVideoFinished(FinishState.COMPLETED);
                        }
                    }
                });
            }
        };
    }

    private void removeEventListener() {
        this.mAdEventListener = null;
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
                AdPieLog.d(TAG, this.mSlotId + ":::registered assets : " + enumSetCopyOf);
                HashMap<String, String> map = new HashMap<>();
                this.mHashMap = map;
                map.put("assettype", enumSetCopyOf.toString());
            }
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void loadAd() {
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
            if (MemUtil.isMemoryError()) {
                AdPieLog.d(TAG, this.mSlotId + ":::load:::memory error!");
                AdEventListener adEventListener2 = this.mAdEventListener;
                if (adEventListener2 != null) {
                    adEventListener2.notifyAdFailedToLoad(104);
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
            Thread thread2 = new Thread(new Runnable() { // from class: com.gomfactory.adpie.sdk.NativeAd.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        AdPieLog.d(NativeAd.TAG, NativeAd.this.mSlotId + ":::load");
                        NativeAd.this.mAdController.setSlotID(NativeAd.this.mSlotId);
                        NativeAd.this.mAdController.setTargetingData(NativeAd.this.mTargetingData);
                        NativeAd.this.mAdController.loadAd(NativeAd.this.mHashMap);
                    } catch (Exception e) {
                        if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                            AdPieLog.e(NativeAd.TAG, e);
                        }
                        if (NativeAd.this.mAdEventListener != null) {
                            NativeAd.this.mAdEventListener.notifyAdFailedToLoad(104);
                        }
                    }
                }
            });
            this.mAdThread = thread2;
            thread2.start();
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
            AdEventListener adEventListener3 = this.mAdEventListener;
            if (adEventListener3 != null) {
                adEventListener3.notifyAdFailedToLoad(104);
            }
        }
    }

    public void loadAd(TargetingData targetingData) {
        this.mTargetingData = targetingData;
        loadAd();
    }

    public void setSkipDownload(boolean z) {
        this.mIsSkipDownload = z;
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
