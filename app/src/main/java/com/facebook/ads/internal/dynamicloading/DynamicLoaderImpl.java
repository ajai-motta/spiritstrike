package com.facebook.ads.internal.dynamicloading;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.AudienceNetworkActivity;
import com.facebook.ads.InterstitialAd;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdBase;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.NativeAdScrollView;
import com.facebook.ads.NativeAdView;
import com.facebook.ads.NativeAdViewAttributes;
import com.facebook.ads.NativeAdsManager;
import com.facebook.ads.NativeBannerAd;
import com.facebook.ads.RewardedInterstitialAd;
import com.facebook.ads.RewardedVideoAd;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.api.AdSettingsApi;
import com.facebook.ads.internal.api.AdSizeApi;
import com.facebook.ads.internal.api.AdViewApi;
import com.facebook.ads.internal.api.AdViewParentApi;
import com.facebook.ads.internal.api.AudienceNetworkActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkAdsApi;
import com.facebook.ads.internal.api.AudienceNetworkExportedActivityApi;
import com.facebook.ads.internal.api.AudienceNetworkRemoteServiceApi;
import com.facebook.ads.internal.api.BidderTokenProviderApi;
import com.facebook.ads.internal.api.DefaultMediaViewVideoRendererApi;
import com.facebook.ads.internal.api.InitApi;
import com.facebook.ads.internal.api.InterstitialAdApi;
import com.facebook.ads.internal.api.MediaViewApi;
import com.facebook.ads.internal.api.MediaViewVideoRendererApi;
import com.facebook.ads.internal.api.NativeAdBaseApi;
import com.facebook.ads.internal.api.NativeAdImageApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;
import com.facebook.ads.internal.api.NativeAdScrollViewApi;
import com.facebook.ads.internal.api.NativeAdViewApi;
import com.facebook.ads.internal.api.NativeAdViewAttributesApi;
import com.facebook.ads.internal.api.NativeAdViewTypeApi;
import com.facebook.ads.internal.api.NativeAdsManagerApi;
import com.facebook.ads.internal.api.NativeBannerAdApi;
import com.facebook.ads.internal.api.NativeBannerAdViewApi;
import com.facebook.ads.internal.api.NativeComponentTagApi;
import com.facebook.ads.internal.api.RewardedInterstitialAdApi;
import com.facebook.ads.internal.api.RewardedVideoAdApi;
import com.facebook.ads.redexgen.core.AbstractC1523Ra;
import com.facebook.ads.redexgen.core.C1525Rc;
import com.facebook.ads.redexgen.core.C1526Rd;
import com.facebook.ads.redexgen.core.C1527Re;
import com.facebook.ads.redexgen.core.C1528Rf;
import com.facebook.ads.redexgen.core.C1530Rh;
import com.facebook.ads.redexgen.core.C1536Rn;
import com.facebook.ads.redexgen.core.C1538Rp;
import com.facebook.ads.redexgen.core.C1540Rr;
import com.facebook.ads.redexgen.core.C1541Rs;
import com.facebook.ads.redexgen.core.C1548Rz;
import com.facebook.ads.redexgen.core.C1599Tz;
import com.facebook.ads.redexgen.core.C1627Vb;
import com.facebook.ads.redexgen.core.C1628Vc;
import com.facebook.ads.redexgen.core.C1629Vd;
import com.facebook.ads.redexgen.core.C1638Vn;
import com.facebook.ads.redexgen.core.C1649Vz;
import com.facebook.ads.redexgen.core.C2194hB;
import com.facebook.ads.redexgen.core.C2195hC;
import com.facebook.ads.redexgen.core.C2212hT;
import com.facebook.ads.redexgen.core.InterfaceC1626Va;
import com.facebook.ads.redexgen.core.S2;
import com.facebook.ads.redexgen.core.S3;
import com.facebook.ads.redexgen.core.S4;
import com.facebook.ads.redexgen.core.S5;
import com.facebook.ads.redexgen.core.S6;
import com.facebook.ads.redexgen.core.SA;
import com.facebook.ads.redexgen.core.SB;
import com.facebook.ads.redexgen.core.SC;
import com.facebook.ads.redexgen.core.SD;
import com.facebook.ads.redexgen.core.SH;
import com.facebook.ads.redexgen.core.U2;
import com.facebook.ads.redexgen.core.UK;
import com.facebook.ads.redexgen.core.V3;
import com.facebook.ads.redexgen.core.V4;
import com.facebook.ads.redexgen.core.XG;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class DynamicLoaderImpl implements DynamicLoader, RemoteRenderingApi {
    public static AdSettingsApi A00;
    public static AudienceNetworkAdsApi A01;
    public static NativeAdViewApi A02;
    public static NativeBannerAdViewApi A03;
    public static C1536Rn A04;
    public static String[] A05 = {"FC7PnIQgfKJQfBdQKCurjH6JKIFxjroV", "Ez", "t7pjhhQGIazlhmf4UkwJSh", "Iyhtqk6gC8uyo8Dul94yaDEfv0PrNxAT", "5egoyUR4tSKxNoVVXreZdHvR7BDPW4Oi", "IYlCvOKkAZQkBJEI1e2UxVPIL3gdF2Y", "0QNvsKlwTsAv0tvLZz9yZ17i9BLNPSLj", "RauEdYPLg0wTIRL3lDclFm017FzJm5su"};
    public static final InitApi A06 = new C1540Rr();

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView.Orientation orientation, int i, AdOptionsView adOptionsView) {
        return new C2212hT(context, nativeAdBase, nativeAdLayout, orientation, i, adOptionsView);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdOptionsViewApi createAdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, AdOptionsView adOptionsView) {
        return new C2212hT(context, nativeAdBase, nativeAdLayout, adOptionsView);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdSettingsApi createAdSettingsApi() {
        if (A00 == null) {
            A00 = new C1525Rc();
        }
        return A00;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdSizeApi createAdSizeApi(int i) {
        return new C1599Tz(this, XG.A02(i));
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdViewApi createAdViewApi(Context context, String str, AdSize adSize, AdViewParentApi adViewParentApi, AdView adView) {
        return (AdViewApi) AbstractC1523Ra.A00(new C1526Rd(context, str, adSize, adViewParentApi, adView), AdViewApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AdViewApi createAdViewApi(Context context, String str, String str2, AdViewParentApi adViewParentApi, AdView adView) throws Exception {
        try {
            return (AdViewApi) AbstractC1523Ra.A00(new C1526Rd(context, str, str2, adViewParentApi, adView), AdViewApi.class);
        } catch (C1638Vn e) {
            throw new Exception(e.A01());
        }
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AudienceNetworkActivityApi createAudienceNetworkActivity(AudienceNetworkActivity audienceNetworkActivity, AudienceNetworkActivityApi audienceNetworkActivityApi) {
        return new C1528Rf(audienceNetworkActivity, audienceNetworkActivityApi, new C1527Re(audienceNetworkActivity, audienceNetworkActivityApi));
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public AudienceNetworkAdsApi createAudienceNetworkAdsApi() {
        if (A01 == null) {
            A01 = new C1530Rh();
        }
        AudienceNetworkAdsApi audienceNetworkAdsApi = A01;
        if (A05[2].length() != 22) {
            throw new RuntimeException();
        }
        A05[3] = "WLYy1k58X1wQ2fFP1Kpc3q8pOUGU5mJB";
        return audienceNetworkAdsApi;
    }

    @Override // com.facebook.ads.internal.dynamicloading.RemoteRenderingApi
    public AudienceNetworkExportedActivityApi createAudienceNetworkExportedActivityApi(Activity activity) {
        return new V3(activity);
    }

    @Override // com.facebook.ads.internal.dynamicloading.RemoteRenderingApi
    public AudienceNetworkRemoteServiceApi createAudienceNetworkRemoteService(Service service) {
        return new V4(service);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public BidderTokenProviderApi createBidderTokenProviderApi() {
        return getBidderTokenProviderApi();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public DefaultMediaViewVideoRendererApi createDefaultMediaViewVideoRendererApi() {
        return new C1649Vz();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public InterstitialAdApi createInterstitialAd(Context context, String str, InterstitialAd interstitialAd) {
        return (InterstitialAdApi) AbstractC1523Ra.A00(new C1541Rs(context, str, interstitialAd), InterstitialAdApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public MediaViewApi createMediaViewApi() {
        return new C2195hC();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public MediaViewVideoRendererApi createMediaViewVideoRendererApi() {
        return new C1548Rz();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public S2 createNativeAdApi(NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new S2(nativeAd, nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public S2 createNativeAdApi(NativeAdBase nativeAdBase, NativeAd nativeAd, NativeAdBaseApi nativeAdBaseApi) {
        return new S2(nativeAdBase, nativeAd, nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBaseApi createNativeAdBaseApi(Context context, String str) {
        return new UK(context, str, (InterfaceC1626Va) UK.A0K(), false);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBaseApi createNativeAdBaseApi(NativeAdBaseApi nativeAdBaseApi) {
        return new UK((UK) nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdBase createNativeAdBaseFromBidPayload(Context context, String str, String str2) throws Exception {
        try {
            return UK.A0A(context, str, str2);
        } catch (C1638Vn e) {
            throw new Exception(e.A01());
        }
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdImageApi createNativeAdImageApi(JSONObject jSONObject) {
        return C1627Vb.A00(jSONObject);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdLayoutApi createNativeAdLayoutApi() {
        return new C2194hB();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public C1628Vc createNativeAdRatingApi(JSONObject jSONObject) {
        return C1628Vc.A00(jSONObject);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdScrollViewApi createNativeAdScrollViewApi(NativeAdScrollView nativeAdScrollView, Context context, NativeAdsManager nativeAdsManager, NativeAdScrollView.AdViewProvider adViewProvider, int i, NativeAdView.Type type, NativeAdViewAttributes nativeAdViewAttributes, int i2) {
        return new S3(nativeAdScrollView, context, nativeAdsManager, adViewProvider, i, type, nativeAdViewAttributes, i2);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewApi createNativeAdViewApi() {
        if (A02 == null) {
            A02 = new S4();
        }
        return A02;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewAttributesApi createNativeAdViewAttributesApi() {
        return new C1629Vd();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdViewTypeApi createNativeAdViewTypeApi(int i) {
        return new S5(i);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeAdsManagerApi createNativeAdsManagerApi(Context context, String str, int i) {
        return (NativeAdsManagerApi) AbstractC1523Ra.A00(new S6(context, str, i), NativeAdsManagerApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeBannerAdApi createNativeBannerAdApi(NativeBannerAd nativeBannerAd, NativeAdBaseApi nativeAdBaseApi) {
        return new SA(nativeAdBaseApi);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeBannerAdViewApi createNativeBannerAdViewApi() {
        if (A03 == null) {
            A03 = new SB();
        }
        return A03;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public NativeComponentTagApi createNativeComponentTagApi() {
        return new SC();
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public RewardedInterstitialAdApi createRewardedInterstitialAd(Context context, String str, RewardedInterstitialAd rewardedInterstitialAd) {
        return (RewardedInterstitialAdApi) AbstractC1523Ra.A00(new SD(context, str, rewardedInterstitialAd), RewardedInterstitialAdApi.class);
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public RewardedVideoAdApi createRewardedVideoAd(Context context, String str, RewardedVideoAd rewardedVideoAd) {
        return (RewardedVideoAdApi) AbstractC1523Ra.A00(new SH(context, str, rewardedVideoAd), RewardedVideoAdApi.class);
    }

    public static C1536Rn getBidderTokenProviderApi() {
        if (A04 == null) {
            A04 = new C1536Rn();
        }
        return A04;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public InitApi getInitApi() {
        return A06;
    }

    @Override // com.facebook.ads.internal.dynamicloading.DynamicLoader
    public void maybeInitInternally(Context context) {
        U2.A0A(C1538Rp.A09(context));
    }
}
