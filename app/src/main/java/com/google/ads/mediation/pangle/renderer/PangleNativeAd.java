package com.google.ads.mediation.pangle.renderer;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAd;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdData;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdInteractionListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeAdLoadListener;
import com.bytedance.sdk.openadsdk.api.nativeAd.PAGNativeRequest;
import com.google.ads.mediation.pangle.PangleConstants;
import com.google.ads.mediation.pangle.PangleFactory;
import com.google.ads.mediation.pangle.PangleInitializer;
import com.google.ads.mediation.pangle.PangleMediationAdapter;
import com.google.ads.mediation.pangle.PangleRequestHelper;
import com.google.ads.mediation.pangle.PangleSdkWrapper;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes8.dex */
public class PangleNativeAd extends UnifiedNativeAdMapper {
    static final String ASSET_ID_ADCHOICES_TEXT_VIEW = "3012";
    static final double PANGLE_SDK_IMAGE_SCALE = 1.0d;
    private final MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> adLoadCallback;
    private MediationNativeAdCallback callback;
    private PAGNativeAd pagNativeAd;
    private final PangleFactory pangleFactory;
    private final PangleInitializer pangleInitializer;
    private final PangleSdkWrapper pangleSdkWrapper;

    public PangleNativeAd(MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> mediationAdLoadCallback, PangleInitializer pangleInitializer, PangleSdkWrapper pangleSdkWrapper, PangleFactory pangleFactory) {
        this.adLoadCallback = mediationAdLoadCallback;
        this.pangleInitializer = pangleInitializer;
        this.pangleSdkWrapper = pangleSdkWrapper;
        this.pangleFactory = pangleFactory;
    }

    public void render(final MediationNativeAdConfiguration mediationNativeAdConfiguration) {
        Bundle serverParameters = mediationNativeAdConfiguration.getServerParameters();
        final String string = serverParameters.getString(PangleConstants.PLACEMENT_ID);
        if (TextUtils.isEmpty(string)) {
            AdError adErrorCreateAdapterError = PangleConstants.createAdapterError(101, "Failed to load native ad from Pangle. Missing or invalid Placement ID.");
            Log.e(PangleMediationAdapter.TAG, adErrorCreateAdapterError.toString());
            this.adLoadCallback.onFailure(adErrorCreateAdapterError);
        } else {
            final String bidResponse = mediationNativeAdConfiguration.getBidResponse();
            this.pangleInitializer.initialize(mediationNativeAdConfiguration.getContext(), serverParameters.getString(PangleConstants.APP_ID), new PangleInitializer.Listener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.1
                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeSuccess() {
                    PAGNativeRequest pAGNativeRequestCreatePagNativeRequest = PangleNativeAd.this.pangleFactory.createPagNativeRequest();
                    pAGNativeRequestCreatePagNativeRequest.setAdString(bidResponse);
                    PangleRequestHelper.setWatermarkString(pAGNativeRequestCreatePagNativeRequest, bidResponse, mediationNativeAdConfiguration);
                    PangleNativeAd.this.pangleSdkWrapper.loadNativeAd(string, pAGNativeRequestCreatePagNativeRequest, new PAGNativeAdLoadListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.1.1
                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener, com.bytedance.sdk.openadsdk.common.mo
                        public void onError(int i, String str) {
                            AdError adErrorCreateSdkError = PangleConstants.createSdkError(i, str);
                            Log.w(PangleMediationAdapter.TAG, adErrorCreateSdkError.toString());
                            PangleNativeAd.this.adLoadCallback.onFailure(adErrorCreateSdkError);
                        }

                        @Override // com.bytedance.sdk.openadsdk.api.PAGLoadListener
                        public void onAdLoaded(PAGNativeAd pAGNativeAd) {
                            PangleNativeAd.this.mapNativeAd(pAGNativeAd);
                            PangleNativeAd.this.callback = (MediationNativeAdCallback) PangleNativeAd.this.adLoadCallback.onSuccess(PangleNativeAd.this);
                        }
                    });
                }

                @Override // com.google.ads.mediation.pangle.PangleInitializer.Listener
                public void onInitializeError(AdError adError) {
                    Log.w(PangleMediationAdapter.TAG, adError.toString());
                    PangleNativeAd.this.adLoadCallback.onFailure(adError);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mapNativeAd(PAGNativeAd pAGNativeAd) {
        this.pagNativeAd = pAGNativeAd;
        PAGNativeAdData nativeAdData = pAGNativeAd.getNativeAdData();
        setHeadline(nativeAdData.getTitle());
        setBody(nativeAdData.getDescription());
        setCallToAction(nativeAdData.getButtonText());
        if (nativeAdData.getIcon() != null) {
            setIcon(new PangleNativeMappedImage(null, Uri.parse(nativeAdData.getIcon().getImageUrl()), PANGLE_SDK_IMAGE_SCALE));
        }
        setOverrideClickHandling(true);
        setMediaView(nativeAdData.getMediaView());
        setAdChoicesContent(nativeAdData.getAdLogoView());
    }

    @Override // com.google.android.gms.ads.mediation.UnifiedNativeAdMapper
    public void trackViews(View view, Map<String, View> map, Map<String, View> map2) {
        HashMap map3 = new HashMap(map);
        map3.remove("3011");
        map3.remove(ASSET_ID_ADCHOICES_TEXT_VIEW);
        View view2 = (View) map3.get("3002");
        ArrayList arrayList = new ArrayList();
        if (view2 != null) {
            arrayList.add(view2);
        }
        this.pagNativeAd.registerViewForInteraction((ViewGroup) view, new ArrayList(map3.values()), arrayList, (View) null, new PAGNativeAdInteractionListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.2
            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdDismissed() {
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdClicked() {
                if (PangleNativeAd.this.callback != null) {
                    PangleNativeAd.this.callback.reportAdClicked();
                }
            }

            @Override // com.bytedance.sdk.openadsdk.api.PAGAdListener
            public void onAdShowed() {
                if (PangleNativeAd.this.callback != null) {
                    PangleNativeAd.this.callback.reportAdImpression();
                }
            }
        });
        getAdChoicesContent().setOnClickListener(new View.OnClickListener() { // from class: com.google.ads.mediation.pangle.renderer.PangleNativeAd.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view3) {
                PangleNativeAd.this.pagNativeAd.showPrivacyActivity();
            }
        });
    }

    public class PangleNativeMappedImage extends NativeAd.Image {
        private final Drawable drawable;
        private final Uri imageUri;
        private final double scale;

        private PangleNativeMappedImage(Drawable drawable, Uri uri, double d) {
            this.drawable = drawable;
            this.imageUri = uri;
            this.scale = d;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Drawable getDrawable() {
            return this.drawable;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public Uri getUri() {
            return this.imageUri;
        }

        @Override // com.google.android.gms.ads.formats.NativeAd.Image
        public double getScale() {
            return this.scale;
        }
    }
}
