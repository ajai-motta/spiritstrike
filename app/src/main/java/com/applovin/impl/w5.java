package com.applovin.impl;

import android.content.Context;
import com.adxcorp.util.ADXLogUtil;
import com.applovin.impl.e6;
import com.applovin.impl.mediation.MaxErrorImpl;
import com.applovin.impl.mediation.ads.a;
import com.applovin.impl.sdk.p;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t3;
import com.applovin.impl.v4;
import com.applovin.mediation.AppLovinUtils;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.adapter.MaxAdapterError;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.internal.AnalyticsEvents;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import kotlin.UByte$$ExternalSyntheticBackport0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class w5 extends j5 {
    private final a3 g;
    private final JSONArray h;
    private final Context i;
    private final a.InterfaceC0152a j;

    public w5(a3 a3Var, JSONArray jSONArray, Context context, com.applovin.impl.sdk.k kVar, a.InterfaceC0152a interfaceC0152a) {
        super("TaskFetchMediatedAd", kVar, a3Var.b());
        this.g = a3Var;
        this.h = jSONArray;
        this.i = context;
        this.j = interfaceC0152a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        try {
            r0.c(jSONObject, this.f428a);
            r0.b(jSONObject, this.f428a);
            r0.a(jSONObject, this.f428a);
            l3.f(jSONObject, this.f428a);
            l3.d(jSONObject, this.f428a);
            l3.e(jSONObject, this.f428a);
            l3.g(jSONObject, this.f428a);
            this.f428a.m().a();
            MaxAdFormat maxAdFormatA = this.g.a();
            MaxAdFormat fromString = MaxAdFormat.formatFromString(JsonUtils.getString(jSONObject, FirebaseAnalytics.Param.AD_FORMAT, null));
            if (maxAdFormatA == fromString) {
                a(jSONObject);
                return;
            }
            String strB = this.g.b();
            if (fromString == null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Mediated ad response is missing the ad format field for ad unit " + strB);
                }
                if (jSONObject.has("ads")) {
                    HashMap map = new HashMap(3);
                    CollectionUtils.putStringIfValid("details", "Missing ad format field", map);
                    CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB, map);
                    CollectionUtils.putStringIfValid("mcode", JsonUtils.getString(jSONObject, "mcode", ""), map);
                    this.f428a.D().a(d2.a1, this.b, map);
                }
                this.j.onAdLoadFailed(strB, MaxAdapterError.NO_FILL);
                return;
            }
            String label = fromString.getLabel();
            String label2 = maxAdFormatA.getLabel();
            String str = "Incorrect format (" + label + ") loaded for (" + label2 + ") ad. Please verify if the ad unit ID (" + strB + ") is assigned to the correct ad format.";
            if (o7.a(maxAdFormatA, fromString)) {
                com.applovin.impl.sdk.o.j(this.b, str);
                a(jSONObject);
                return;
            }
            l1.a(str, new Object[0]);
            com.applovin.impl.sdk.o.h(this.b, str);
            this.j.onAdLoadFailed(strB, new MaxAdapterError(MaxAdapterError.INVALID_CONFIGURATION, 0, str));
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB);
            CollectionUtils.putStringIfValid("name", label2, mapHashMap);
            CollectionUtils.putStringIfValid("details", label, mapHashMap);
            this.f428a.D().a(d2.S0, "incompatible_ad_format", mapHashMap);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to process mediated ad response for ad unit " + this.g.b(), th);
            }
            throw new RuntimeException("Unable to process ad: " + th);
        }
    }

    private void c(JSONObject jSONObject) {
        JSONObject andResetCustomPostBodyData = this.f428a.X().getAndResetCustomPostBodyData();
        if (andResetCustomPostBodyData == null || !o7.h(com.applovin.impl.sdk.k.o())) {
            return;
        }
        JsonUtils.putAll(jSONObject, andResetCustomPostBodyData);
    }

    private void d(JSONObject jSONObject) {
        if (((Boolean) this.f428a.a(y4.N4)).booleanValue()) {
            u3 u3VarY = this.f428a.Y();
            JSONObject jSONObject2 = new JSONObject();
            JSONObject jSONObject3 = new JSONObject();
            s3 s3Var = s3.f;
            JsonUtils.putAll(jSONObject3, (Map<String, ?>) u3VarY.a(s3Var, t3.a.AD_UNIT_ID));
            JsonUtils.putJSONObject(jSONObject2, "arpau", jSONObject3);
            JSONObject jSONObject4 = new JSONObject();
            JsonUtils.putAll(jSONObject4, (Map<String, ?>) u3VarY.a(s3Var, t3.a.AD_FORMAT));
            JsonUtils.putJSONObject(jSONObject2, "arpaf", jSONObject4);
            JSONObject jSONObject5 = new JSONObject();
            JsonUtils.putAll(jSONObject5, (Map<String, ?>) u3VarY.a(s3.g, t3.a.AD));
            JsonUtils.putJSONObject(jSONObject2, "ttdasipa_ms", jSONObject5);
            JsonUtils.putJSONObject(jSONObject, "mediation_stats", jSONObject2);
        }
    }

    private String e() {
        return l3.a(this.f428a);
    }

    private String f() {
        return l3.b(this.f428a);
    }

    private JSONObject g() throws JSONException {
        Map mapA = this.f428a.A().a((Map) null, false, true);
        mapA.putAll(this.g.c());
        JSONObject jSONObject = new JSONObject(mapA);
        e(jSONObject);
        h(jSONObject);
        f(jSONObject);
        c(jSONObject);
        g(jSONObject);
        d(jSONObject);
        return jSONObject;
    }

    private Map h() {
        HashMap map = new HashMap(4);
        map.put("AppLovin-Ad-Unit-Id", this.g.b());
        map.put("AppLovin-Ad-Format", this.g.a().getLabel());
        Map mapD = this.g.d();
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Attempt", mapD.get("retry_attempt"), map);
        CollectionUtils.putObjectToStringIfValid("AppLovin-Retry-Delay-Sec", mapD.get("retry_delay_sec"), map);
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        MaxAdFormat maxAdFormatA = this.g.a();
        String strB = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Fetching next ad for " + maxAdFormatA.getLabel() + " ad unit " + strB);
        }
        k2.a();
        if (((Boolean) this.f428a.a(y4.Y3)).booleanValue() && o7.j() && com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "User is connected to a VPN");
        }
        this.f428a.P().a(d2.g0, maxAdFormatA, strB, (MaxError) null);
        if (((Boolean) this.f428a.a(y4.N4)).booleanValue()) {
            u3 u3VarY = this.f428a.Y();
            s3 s3Var = s3.f;
            u3VarY.a(s3Var, t3.a(strB));
            u3VarY.a(s3Var, t3.a(maxAdFormatA));
        }
        o7.a(this.f428a, this.b);
        try {
            JSONObject jSONObjectG = g();
            HashMap map = new HashMap();
            if (!((Boolean) this.f428a.a(y4.C5)).booleanValue() && !((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
                map.put("rid", UUID.randomUUID().toString());
            }
            if (!((Boolean) this.f428a.a(y4.l5)).booleanValue()) {
                map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f428a.j0());
            }
            if (this.f428a.t0().c()) {
                map.put("test_mode", "1");
            }
            List listB = this.f428a.t0().b();
            String str = this.f428a.o0().getExtraParameters().get("fan");
            if (listB != null && !listB.isEmpty()) {
                String strM = UByte$$ExternalSyntheticBackport0.m(",", listB);
                map.put("filter_ad_network", strM);
                if (!this.f428a.t0().c()) {
                    map.put("fhkZsVqYC7", "1");
                }
                if (this.f428a.t0().d()) {
                    map.put("force_ad_network", strM);
                }
            } else if (StringUtils.isValidString(str)) {
                map.put("filter_ad_network", str);
            }
            a aVar = new a(com.applovin.impl.sdk.network.a.a(this.f428a).c("POST").a(h()).b(f()).a(e()).b(map).a(jSONObjectG).b(((Boolean) this.f428a.a(r3.D8)).booleanValue()).a((Object) new JSONObject()).c(((Long) this.f428a.a(r3.x7)).intValue()).a(((Integer) this.f428a.a(y4.b3)).intValue()).b(((Long) this.f428a.a(r3.w7)).intValue()).a(v4.a.a(((Integer) this.f428a.a(y4.r5)).intValue())).f(true).a(), this.f428a, strB, maxAdFormatA);
            aVar.c(r3.u7);
            aVar.b(r3.v7);
            this.f428a.r0().a(aVar);
        } catch (Throwable th) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Unable to fetch ad for Ad Unit ID: " + strB, th);
            }
            a("", 0, th.getMessage());
        }
    }

    class a extends m6 {
        final /* synthetic */ String m;
        final /* synthetic */ MaxAdFormat n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, String str, MaxAdFormat maxAdFormat) {
            super(aVar, kVar);
            this.m = str;
            this.n = maxAdFormat;
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            if (i != 200) {
                w5.this.a(str, i, null);
                return;
            }
            JsonUtils.putLong(jSONObject, "ad_fetch_latency_millis", this.l.a());
            JsonUtils.putLong(jSONObject, "ad_fetch_response_size", this.l.b());
            HashMap map = new HashMap(6);
            CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
            CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
            CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, this.m, map);
            CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, this.n.getLabel(), map);
            CollectionUtils.putStringIfValid("latency_ms", String.valueOf(this.l.a()), map);
            CollectionUtils.putStringIfValid("response_size", String.valueOf(this.l.b()), map);
            this.f428a.P().d(d2.h0, map);
            w5.this.b(jSONObject);
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            w5.this.a(str, i, str2);
            this.f428a.D().a("fetchMediatedAd", str, i, str2);
        }
    }

    private void e(JSONObject jSONObject) throws JSONException {
        String strB = this.g.b();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB);
        jSONObject2.put(FirebaseAnalytics.Param.AD_FORMAT, this.g.a().getLabel());
        Map map = CollectionUtils.map(this.g.d());
        com.applovin.impl.sdk.p pVarA0 = this.f428a.a0();
        CollectionUtils.putStringIfValid("previous_request_id", pVarA0.b(strB), map);
        CollectionUtils.putStringIfValid("previous_loaded_request_id", pVarA0.a(strB), map);
        p.a aVarC = pVarA0.c(strB);
        if (aVarC != null) {
            if (Boolean.parseBoolean(this.f428a.o0().getExtraParameters().get("esc"))) {
                map.put("previous_winning_network", "APPLOVIN_NETWORK");
                map.put("previous_winning_network_name", ADXLogUtil.PLATFORM_APPLOVIN);
            } else {
                map.put("previous_winning_network", aVarC.a());
                map.put("previous_winning_network_name", aVarC.c());
            }
            if (this.f428a.R() != null) {
                Queue<y2> queueC = this.f428a.R().c(strB);
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                for (y2 y2Var : queueC) {
                    arrayList.add(y2Var.c());
                    arrayList2.add(y2Var.getNetworkName());
                }
                CollectionUtils.putStringIfValid("queued_ad_networks", UByte$$ExternalSyntheticBackport0.m(",", arrayList), map);
                CollectionUtils.putStringIfValid("queued_ad_network_names", UByte$$ExternalSyntheticBackport0.m(",", arrayList2), map);
            }
        }
        jSONObject2.put("extra_parameters", CollectionUtils.toJson(map));
        jSONObject.put("ad_info", jSONObject2);
    }

    private void f(JSONObject jSONObject) {
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("disabled", new JSONArray(this.f428a.T().a()));
            jSONObject2.put("installed", w3.b(this.f428a));
            jSONObject2.put("initialized", this.f428a.S().b());
            jSONObject2.put("initialized_classnames", new JSONArray((Collection) this.f428a.S().a()));
            jSONObject2.put("loaded_classnames", new JSONArray(this.f428a.T().c()));
            jSONObject2.put("failed_classnames", new JSONArray(this.f428a.T().b()));
            jSONObject.put("adapters_info", jSONObject2);
        } catch (Exception e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to populate adapter classNames", e);
            }
            throw new RuntimeException("Failed to populate classNames: " + e);
        }
    }

    private void a(JSONObject jSONObject) {
        g6 g6Var = new g6(this.g, jSONObject, this.i, this.f428a, this.j);
        long j = JsonUtils.getLong(jSONObject, "process_waterfall_delay_ms", -1L);
        if (j > 0) {
            this.f428a.r0().a(g6Var, e6.b.MEDIATION, j, true);
        } else {
            this.f428a.r0().a(g6Var);
        }
    }

    private void h(JSONObject jSONObject) throws JSONException {
        JSONArray jSONArray = this.h;
        if (jSONArray != null) {
            jSONObject.put("signal_data", jSONArray);
        }
    }

    private void g(JSONObject jSONObject) {
        JsonUtils.putObject(jSONObject, "sdk_extra_parameters", new JSONObject(this.f428a.o0().getExtraParameters()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, int i, String str2) {
        MaxErrorImpl maxErrorImpl;
        String strB = this.g.b();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.b(this.b, "Unable to fetch ad for ad unit " + strB + ": server returned " + i);
        }
        if (i == -1009) {
            maxErrorImpl = new MaxErrorImpl(-1009, str2);
        } else if (i == -1001) {
            maxErrorImpl = new MaxErrorImpl(-1001, str2);
        } else if (StringUtils.isValidString(str2)) {
            maxErrorImpl = new MaxErrorImpl(-1000, str2);
        } else {
            maxErrorImpl = new MaxErrorImpl(-1);
        }
        HashMap map = new HashMap(5);
        CollectionUtils.putStringIfValid("url", StringUtils.getHost(str), map);
        CollectionUtils.putStringIfValid("code", String.valueOf(i), map);
        CollectionUtils.putStringIfValid(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2, map);
        CollectionUtils.putStringIfValid(AppLovinUtils.ServerParameterKeys.AD_UNIT_ID, strB, map);
        CollectionUtils.putStringIfValid(FirebaseAnalytics.Param.AD_FORMAT, this.g.a().getLabel(), map);
        this.f428a.P().d(d2.i0, map);
        t2.a(this.j, strB, maxErrorImpl);
    }
}
