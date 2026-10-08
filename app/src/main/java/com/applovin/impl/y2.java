package com.applovin.impl;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import androidx.arch.core.util.Function;
import com.applovin.impl.sdk.utils.BundleUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxAdWaterfallInfo;
import com.applovin.mediation.nativeAds.MaxNativeAd;
import com.applovin.sdk.AppLovinSdkUtils;
import com.google.ads.mediation.facebook.FacebookMediationAdapter;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hive.analytics.provider.adjust.AnalyticsProviderAdjust;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public abstract class y2 extends k3 implements MaxAd {
    private final AtomicBoolean k;
    private final AtomicBoolean l;
    private final a3 m;
    protected com.applovin.impl.mediation.h n;
    private final String o;
    private MaxAdWaterfallInfo p;
    private long q;
    private String r;
    private String s;

    protected y2(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.mediation.h hVar, com.applovin.impl.sdk.k kVar) {
        super(a3Var.e(), jSONObject, jSONObject2, kVar);
        this.k = new AtomicBoolean();
        this.l = new AtomicBoolean();
        this.m = a3Var;
        this.n = hVar;
        this.o = hVar != null ? hVar.b() : null;
    }

    private long H() {
        return a("load_started_time_ms", 0L);
    }

    public static y2 a(a3 a3Var, JSONObject jSONObject, JSONObject jSONObject2, com.applovin.impl.sdk.k kVar) {
        String string = JsonUtils.getString(jSONObject2, FirebaseAnalytics.Param.AD_FORMAT, null);
        MaxAdFormat fromString = MaxAdFormat.formatFromString(string);
        Objects.requireNonNull(fromString, "Invalid ad format for string: " + string);
        if (fromString.isAdViewAd()) {
            return new b3(a3Var, jSONObject, jSONObject2, kVar);
        }
        if (fromString == MaxAdFormat.NATIVE) {
            return new d3(a3Var, jSONObject, jSONObject2, kVar);
        }
        if (fromString.isFullscreenAd()) {
            return new c3(a3Var, jSONObject, jSONObject2, kVar);
        }
        throw new IllegalArgumentException("Unsupported ad format: " + string);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject b(i5 i5Var) {
        return JsonUtils.deepCopy(i5Var.a("ad_values", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Bundle c(i5 i5Var) {
        JSONObject jSONObjectA;
        if (i5Var.a("credentials")) {
            jSONObjectA = i5Var.a("credentials", new JSONObject());
        } else {
            jSONObjectA = i5Var.a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, P());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject d(i5 i5Var) {
        return JsonUtils.deepCopy(i5Var.a("publisher_extra_info", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Double e(i5 i5Var) {
        return Double.valueOf(JsonUtils.getDouble(i5Var.a("revenue_parameters", (JSONObject) null), AnalyticsProviderAdjust.EventKeys.revenue, -1.0d));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ JSONObject f(i5 i5Var) {
        return JsonUtils.deepCopy(i5Var.a("revenue_parameters", new JSONObject()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ String g(i5 i5Var) {
        return JsonUtils.getString(i5Var.a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    public com.applovin.impl.mediation.h A() {
        return this.n;
    }

    public String B() {
        return a("bcode", "");
    }

    public long C() {
        return a("bid_expiration_ms", BundleUtils.getLong("bid_expiration_ms", -1L, l()));
    }

    public String D() {
        return a("bid_response", (String) null);
    }

    public Bundle E() {
        JSONObject jSONObjectA;
        i5 i5Var = this.h;
        if (i5Var != null) {
            return (Bundle) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda2
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return this.f$0.c((i5) obj);
                }
            });
        }
        if (c("credentials")) {
            jSONObjectA = a("credentials", new JSONObject());
        } else {
            jSONObjectA = a("server_parameters", new JSONObject());
            JsonUtils.putString(jSONObjectA, FacebookMediationAdapter.RTB_PLACEMENT_PARAMETER, P());
        }
        return JsonUtils.toBundle(jSONObjectA);
    }

    public long F() {
        if (H() > 0) {
            return G() - H();
        }
        return -1L;
    }

    public long G() {
        return a("load_completed_time_ms", 0L);
    }

    public String I() {
        return this.r;
    }

    public int J() {
        return a("mspc", ((Integer) this.f440a.a(r3.l8)).intValue());
    }

    public JSONObject K() {
        i5 i5Var = this.h;
        return i5Var != null ? (JSONObject) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda5
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return y2.d((i5) obj);
            }
        }) : a("publisher_extra_info", new JSONObject());
    }

    public a3 L() {
        return this.m;
    }

    public String M() {
        return JsonUtils.getString(N(), "revenue_event", "");
    }

    public JSONObject N() {
        i5 i5Var = this.h;
        return i5Var != null ? (JSONObject) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda1
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return y2.f((i5) obj);
            }
        }) : a("revenue_parameters", new JSONObject());
    }

    public String O() {
        return b("event_id", "");
    }

    public String P() {
        return a("third_party_ad_placement_id", (String) null);
    }

    public List Q() {
        return b("mwf_info_urls");
    }

    public String R() {
        return b("waterfall_name", "");
    }

    public String S() {
        return b("waterfall_test_name", "");
    }

    public boolean T() {
        return StringUtils.isValidString(D());
    }

    public boolean U() {
        com.applovin.impl.mediation.h hVar = this.n;
        return hVar != null && hVar.k() && this.n.j();
    }

    public boolean V() {
        return a("only_load_when_initialized", Boolean.FALSE).booleanValue();
    }

    public boolean W() {
        return a("prefer_load_when_initialized", Boolean.TRUE).booleanValue();
    }

    public void X() {
        c("load_completed_time_ms", SystemClock.elapsedRealtime());
    }

    public void Y() {
        c("load_started_time_ms", SystemClock.elapsedRealtime());
    }

    public Boolean Z() {
        return a("destroy_on_ui_thread", (Boolean) null);
    }

    public abstract y2 a(com.applovin.impl.mediation.h hVar);

    public Boolean a0() {
        return a("load_on_ui_thread", (Boolean) null);
    }

    public Boolean b0() {
        return a("show_on_ui_thread", (Boolean) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdReviewCreativeId() {
        return this.s;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str) {
        return getAdValue(str, null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getCreativeId() {
        return a("creative_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspId() {
        return a("dsp_id", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public String getDspName() {
        return a("dsp_name", (String) null);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdFormat getFormat() {
        return MaxAdFormat.formatFromString(a(FirebaseAnalytics.Param.AD_FORMAT, b(FirebaseAnalytics.Param.AD_FORMAT, (String) null)));
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxNativeAd getNativeAd() {
        com.applovin.impl.mediation.h hVar = this.n;
        if (hVar != null) {
            return hVar.e();
        }
        return null;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkName() {
        return a("network_name", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public String getNetworkPlacement() {
        return StringUtils.emptyIfNull(P());
    }

    @Override // com.applovin.mediation.MaxAd
    public long getRequestLatencyMillis() {
        return this.q;
    }

    @Override // com.applovin.mediation.MaxAd
    public double getRevenue() {
        if (!((Boolean) this.f440a.a(r3.q8)).booleanValue() || !getFormat().isFullscreenAd() || u().get()) {
            i5 i5Var = this.h;
            return i5Var != null ? ((Double) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda4
                @Override // androidx.arch.core.util.Function
                public final Object apply(Object obj) {
                    return y2.e((i5) obj);
                }
            })).doubleValue() : JsonUtils.getDouble(a("revenue_parameters", (JSONObject) null), AnalyticsProviderAdjust.EventKeys.revenue, -1.0d);
        }
        this.f440a.O();
        if (!com.applovin.impl.sdk.o.a()) {
            return 0.0d;
        }
        this.f440a.O().b("MediatedAd", "Attempting to retrieve revenue when not available yet");
        return 0.0d;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getRevenuePrecision() {
        i5 i5Var = this.h;
        return i5Var != null ? (String) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda3
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return y2.g((i5) obj);
            }
        }) : JsonUtils.getString(a("revenue_parameters", (JSONObject) null), "precision", "");
    }

    @Override // com.applovin.mediation.MaxAd
    public AppLovinSdkUtils.Size getSize() {
        int iA = a("ad_width", -3);
        int iA2 = a("ad_height", -3);
        return (iA == -3 || iA2 == -3) ? getFormat().getSize() : new AppLovinSdkUtils.Size(iA, iA2);
    }

    @Override // com.applovin.mediation.MaxAd
    public MaxAdWaterfallInfo getWaterfall() {
        return this.p;
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.r = str;
    }

    public void t() {
        this.n = null;
        this.p = null;
    }

    @Override // com.applovin.impl.k3
    public String toString() {
        return "MediatedAd{thirdPartyAdPlacementId=" + P() + ", adUnitId=" + getAdUnitId() + ", format=" + getFormat().getLabel() + ", networkName='" + getNetworkName() + "'}";
    }

    public AtomicBoolean u() {
        return this.k;
    }

    public String v() {
        return a("adomain", (String) null);
    }

    public AtomicBoolean w() {
        return this.l;
    }

    public JSONObject x() {
        i5 i5Var = this.h;
        return i5Var != null ? (JSONObject) i5Var.a(new Function() { // from class: com.applovin.impl.y2$$ExternalSyntheticLambda0
            @Override // androidx.arch.core.util.Function
            public final Object apply(Object obj) {
                return y2.b((i5) obj);
            }
        }) : a("ad_values", new JSONObject());
    }

    public View y() {
        com.applovin.impl.mediation.h hVar;
        if (!U() || (hVar = this.n) == null) {
            return null;
        }
        return hVar.d();
    }

    public String z() {
        return this.o;
    }

    @Override // com.applovin.mediation.MaxAd
    public String getAdValue(String str, String str2) {
        JSONObject jSONObjectX = x();
        if (jSONObjectX.has(str)) {
            return JsonUtils.getString(jSONObjectX, str, str2);
        }
        Bundle bundleL = l();
        if (bundleL.containsKey(str)) {
            return bundleL.getString(str);
        }
        JSONObject jSONObjectK = K();
        return jSONObjectK.has(str) ? JsonUtils.getString(jSONObjectK, str, str2) : a(str, str2);
    }

    public void a(MaxAdWaterfallInfo maxAdWaterfallInfo) {
        this.p = maxAdWaterfallInfo;
    }

    public void a(long j) {
        this.q = j;
    }

    public void a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0) {
            return;
        }
        JSONObject jSONObjectK = K();
        JsonUtils.putAll(jSONObjectK, jSONObject);
        a("publisher_extra_info", (Object) jSONObjectK);
    }

    public void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        if (bundle.containsKey("creative_id") && !c("creative_id")) {
            c("creative_id", BundleUtils.getString("creative_id", bundle));
        }
        if (bundle.containsKey("ad_width") && !c("ad_width") && bundle.containsKey("ad_height") && !c("ad_height")) {
            int i = BundleUtils.getInt("ad_width", bundle);
            int i2 = BundleUtils.getInt("ad_height", bundle);
            c("ad_width", i);
            c("ad_height", i2);
        }
        if (bundle.containsKey("publisher_extra_info")) {
            a(BundleUtils.toJSONObject(bundle.getBundle("publisher_extra_info")));
        }
    }
}
