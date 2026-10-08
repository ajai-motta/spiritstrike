package com.google.ads.mediation.facebook.rtb;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import com.adxcorp.util.ADXLogUtil;
import com.facebook.ads.Ad;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.ExtraHints;
import com.facebook.ads.MediaView;
import com.facebook.ads.MediaViewListener;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.NativeBannerAd;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.ads.mediation.facebook.MetaFactory;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class FacebookRtbNativeAd extends UnifiedNativeAdMapper {
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> callback;
    private MediaView mediaView;
    private final MetaFactory metaFactory;
    private NativeAdBase nativeAdBase;
    private MediationNativeAdCallback nativeAdCallback;

    private interface NativeAdMapperListener {
        void onMappingFailed(AdError adError);

        void onMappingSuccess();
    }

    public FacebookRtbNativeAd(MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, MetaFactory metaFactory) {
        this.callback = mediationAdLoadCallback;
        this.metaFactory = metaFactory;
    }

    public void render(MediationNativeAdConfiguration mediationNativeAdConfiguration) {
        ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD);
        String placementID = FacebookMediationAdapter.getPlacementID(mediationNativeAdConfiguration.getServerParameters());
        if (TextUtils.isEmpty(placementID)) {
            AdError adError = new AdError(101, "Failed to request ad. PlacementID is null or empty.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
            this.callback.onFailure(adError);
            return;
        }
        FacebookMediationAdapter.setMixedAudience(mediationNativeAdConfiguration);
        this.mediaView = this.metaFactory.createMediaView(mediationNativeAdConfiguration.getContext());
        try {
            this.nativeAdBase = NativeAdBase.fromBidPayload(mediationNativeAdConfiguration.getContext(), placementID, mediationNativeAdConfiguration.getBidResponse());
            if (!TextUtils.isEmpty(mediationNativeAdConfiguration.getWatermark())) {
                this.nativeAdBase.setExtraHints(new ExtraHints.Builder().mediationData(mediationNativeAdConfiguration.getWatermark()).build());
            }
            NativeAdBase nativeAdBase = this.nativeAdBase;
            nativeAdBase.loadAd(nativeAdBase.buildLoadAdConfig().withAdListener(new NativeListener(mediationNativeAdConfiguration.getContext(), this.nativeAdBase)).withBid(mediationNativeAdConfiguration.getBidResponse()).withMediaCacheFlag(NativeAdBase.MediaCacheFlag.ALL).withPreloadedIconView(-1, -1).build());
        } catch (Exception e) {
            AdError adError2 = new AdError(109, "Failed to create native ad from bid payload: " + e.getMessage(), FacebookMediationAdapter.ERROR_DOMAIN);
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            this.callback.onFailure(adError2);
        }
    }

    private class NativeListener implements AdListener, NativeAdListener {
        private final WeakReference<Context> context;
        private final NativeAdBase nativeAd;

        @Override // com.facebook.ads.AdListener
        public void onLoggingImpression(Ad ad) {
        }

        NativeListener(Context context, NativeAdBase nativeAdBase) {
            this.nativeAd = nativeAdBase;
            this.context = new WeakReference<>(context);
        }

        @Override // com.facebook.ads.AdListener
        public void onAdClicked(Ad ad) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_CLICK);
            FacebookRtbNativeAd.this.nativeAdCallback.reportAdClicked();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdOpened();
            FacebookRtbNativeAd.this.nativeAdCallback.onAdLeftApplication();
        }

        @Override // com.facebook.ads.AdListener
        public void onAdLoaded(Ad ad) {
            if (ad != this.nativeAd) {
                AdError adError = new AdError(106, "Ad Loaded is not a Native Ad.", FacebookMediationAdapter.ERROR_DOMAIN);
                Log.e(FacebookMediationAdapter.TAG, adError.getMessage());
                FacebookRtbNativeAd.this.callback.onFailure(adError);
                return;
            }
            Context context = this.context.get();
            if (context == null) {
                AdError adError2 = new AdError(107, "Context is null.", FacebookMediationAdapter.ERROR_DOMAIN);
                Log.e(FacebookMediationAdapter.TAG, adError2.getMessage());
                FacebookRtbNativeAd.this.callback.onFailure(adError2);
                return;
            }
            FacebookRtbNativeAd.this.mapNativeAd(context, new NativeAdMapperListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeListener.1
                @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                public void onMappingSuccess() {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_NATIVE, ADXLogUtil.EVENT_LOAD_SUCCESS);
                    FacebookRtbNativeAd.this.nativeAdCallback = (MediationNativeAdCallback) FacebookRtbNativeAd.this.callback.onSuccess(FacebookRtbNativeAd.this);
                }

                @Override // com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.NativeAdMapperListener
                public void onMappingFailed(AdError adError3) {
                    ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_NATIVE, "Failure, " + adError3.getCode() + "(" + adError3.getMessage() + ")");
                    Log.w(FacebookMediationAdapter.TAG, adError3.getMessage());
                    FacebookRtbNativeAd.this.callback.onFailure(adError3);
                }
            });
        }

        @Override // com.facebook.ads.AdListener
        public void onError(Ad ad, com.facebook.ads.AdError adError) {
            ADXLogUtil.logAdMobEvent(ADXLogUtil.PLATFORM_FACEBOOK, ADXLogUtil.INVENTORY_NATIVE, "Failure, " + adError.getErrorCode() + "(" + adError.getErrorMessage() + ")");
            AdError adError2 = FacebookMediationAdapter.getAdError(adError);
            Log.w(FacebookMediationAdapter.TAG, adError2.getMessage());
            FacebookRtbNativeAd.this.callback.onFailure(adError2);
        }

        @Override // com.facebook.ads.NativeAdListener
        public void onMediaDownloaded(Ad ad) {
            Log.d(FacebookMediationAdapter.TAG, "onMediaDownloaded");
        }
    }

    public void mapNativeAd(Context context, NativeAdMapperListener nativeAdMapperListener) {
        if (!containsRequiredFieldsForUnifiedNativeAd(this.nativeAdBase)) {
            AdError adError = new AdError(108, "Ad from Meta Audience Network doesn't have all required assets.", FacebookMediationAdapter.ERROR_DOMAIN);
            Log.w(FacebookMediationAdapter.TAG, adError.getMessage());
            nativeAdMapperListener.onMappingFailed(adError);
            return;
        }
        setHeadline(this.nativeAdBase.getAdHeadline());
        if (this.nativeAdBase.getAdCoverImage() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdCoverImage().getUrl())));
            setImages(arrayList);
        }
        setBody(this.nativeAdBase.getAdBodyText());
        if (this.nativeAdBase.getPreloadedIconViewDrawable() == null) {
            if (this.nativeAdBase.getAdIcon() == null) {
                setIcon(new FacebookAdapterNativeAdImage());
            } else {
                setIcon(new FacebookAdapterNativeAdImage(Uri.parse(this.nativeAdBase.getAdIcon().getUrl())));
            }
        } else {
            setIcon(new FacebookAdapterNativeAdImage(this.nativeAdBase.getPreloadedIconViewDrawable()));
        }
        setCallToAction(this.nativeAdBase.getAdCallToAction());
        setAdvertiser(this.nativeAdBase.getAdvertiserName());
        this.mediaView.setListener(new MediaViewListener() { // from class: com.google.ads.mediation.facebook.rtb.FacebookRtbNativeAd.1
            @Override // com.facebook.ads.MediaViewListener
            public void onEnterFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onExitFullscreen(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenBackground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onFullscreenForeground(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPause(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onPlay(MediaView mediaView) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onVolumeChange(MediaView mediaView, float f) {
            }

            @Override // com.facebook.ads.MediaViewListener
            public void onComplete(MediaView mediaView) {
                if (FacebookRtbNativeAd.this.nativeAdCallback != null) {
                    FacebookRtbNativeAd.this.nativeAdCallback.onVideoComplete();
                }
            }
        });
        setHasVideoContent(true);
        setMediaView(this.mediaView);
        Bundle bundle = new Bundle();
        bundle.putCharSequence("id", this.nativeAdBase.getId());
        bundle.putCharSequence(FacebookMediationAdapter.KEY_SOCIAL_CONTEXT_ASSET, this.nativeAdBase.getAdSocialContext());
        setExtras(bundle);
        setAdChoicesContent(new AdOptionsView(context, this.nativeAdBase, null));
        nativeAdMapperListener.onMappingSuccess();
    }

    private boolean containsRequiredFieldsForUnifiedNativeAd(NativeAdBase nativeAdBase) {
        boolean z = (nativeAdBase.getAdHeadline() == null || nativeAdBase.getAdBodyText() == null || nativeAdBase.getAdIcon() == null || nativeAdBase.getAdCallToAction() == null) ? false : true;
        return nativeAdBase instanceof NativeBannerAd ? z : (!z || nativeAdBase.getAdCoverImage() == null || this.mediaView == null) ? false : true;
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        setOverrideClickHandling(true);
        ArrayList arrayList = new ArrayList(map.values());
        View view2 = map.get("3003");
        NativeAdBase nativeAdBase = this.nativeAdBase;
        if (nativeAdBase instanceof NativeBannerAd) {
            if (view2 == null) {
                Log.w(FacebookMediationAdapter.TAG, "Missing or invalid native ad icon asset. Meta Audience Network impression recording might be impacted for this ad.");
                return;
            } else if (!(view2 instanceof ImageView)) {
                Log.w(FacebookMediationAdapter.TAG, String.format("Native ad icon asset is rendered with an incompatible class type. Meta Audience Network impression recording might be impacted for this ad. Expected: ImageView, actual: %s.", view2.getClass()));
                return;
            } else {
                ((NativeBannerAd) nativeAdBase).registerViewForInteraction(view, (ImageView) view2, arrayList);
                return;
            }
        }
        if (nativeAdBase instanceof NativeAd) {
            NativeAd nativeAd = (NativeAd) nativeAdBase;
            if (view2 instanceof ImageView) {
                nativeAd.registerViewForInteraction(view, this.mediaView, (ImageView) view2, arrayList);
                return;
            } else {
                Log.w(FacebookMediationAdapter.TAG, "Native icon asset is not of type ImageView. Calling registerViewForInteraction() without a reference to the icon view.");
                nativeAd.registerViewForInteraction(view, this.mediaView, arrayList);
                return;
            }
        }
        Log.w(FacebookMediationAdapter.TAG, "Native ad type is not of type NativeAd or NativeBannerAd. It is not currently supported by the Meta Audience Network Adapter. Meta Audience Network impression recording might be impacted for this ad.");
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void untrackView(View view) {
        NativeAdBase nativeAdBase = this.nativeAdBase;
        if (nativeAdBase != null) {
            nativeAdBase.unregisterView();
        }
        super.untrackView(view);
    }

    private class FacebookAdapterNativeAdImage extends NativeAd.Image {
        private Drawable drawable;
        private Uri uri;

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return 1.0d;
        }

        public FacebookAdapterNativeAdImage() {
        }

        public FacebookAdapterNativeAdImage(Uri uri) {
            this.uri = uri;
        }

        public FacebookAdapterNativeAdImage(Drawable drawable) {
            this.drawable = drawable;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Drawable getDrawable() {
            return this.drawable;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Uri getUri() {
            return this.uri;
        }
    }
}
