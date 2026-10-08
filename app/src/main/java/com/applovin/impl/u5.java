package com.applovin.impl;

import android.app.ActivityManager;
import android.net.Uri;
import android.os.SystemClock;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.l;
import com.applovin.impl.sdk.network.a;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.v;
import com.applovin.impl.v4;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.security.ProviderInstaller;
import com.unity3d.ads.core.data.datasource.AndroidTcfDataSource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class u5 extends j5 {
    private static final AtomicBoolean j = new AtomicBoolean();
    private final int g;
    private final Object h;
    private b i;

    public interface b {
        void a(JSONObject jSONObject);
    }

    private class c extends j5 {
        public c(com.applovin.impl.sdk.k kVar) {
            super("TaskTimeoutFetchBasicSettings", kVar, true);
        }

        @Override // java.lang.Runnable
        public void run() {
            if (u5.this.i != null) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.b(this.b, "Timing out fetch basic settings...");
                }
                u5.this.a(new JSONObject());
            }
        }
    }

    public u5(int i, com.applovin.impl.sdk.k kVar, b bVar) {
        super("TaskFetchBasicSettings", kVar, true);
        this.h = new Object();
        this.g = i;
        this.i = bVar;
    }

    private HashMap b(String str) {
        return a(str, 0L, 0, null, null);
    }

    private String f() {
        return r0.a((String) this.f428a.a(y4.p0), "5.0/i", b());
    }

    private String g() {
        return r0.a((String) this.f428a.a(y4.o0), "5.0/i", b());
    }

    protected JSONObject e() {
        JSONObject jSONObject = new JSONObject();
        try {
            com.applovin.impl.sdk.k kVar = this.f428a;
            y4 y4Var = y4.A5;
            if (((Boolean) kVar.a(y4Var)).booleanValue() || ((Boolean) this.f428a.a(y4Var)).booleanValue()) {
                jSONObject.put("rid", UUID.randomUUID().toString());
            }
            jSONObject.put("sdk_version", AppLovinSdk.VERSION);
            JsonUtils.putStringIfValid(jSONObject, "ad_review_sdk_version", j.b());
            jSONObject.put("init_count", this.g);
            jSONObject.put("server_installed_at", this.f428a.a(y4.o));
            if (this.f428a.D0()) {
                jSONObject.put("first_install", true);
            }
            if (!this.f428a.A0()) {
                jSONObject.put("first_install_v2", true);
            }
            JsonUtils.putStringIfValid(jSONObject, "process_name", o7.c(a()));
            JsonUtils.putBooleanIfValid(jSONObject, "is_main_process", o7.i(a()));
            JsonUtils.putStringIfValid(jSONObject, "plugin_version", (String) this.f428a.a(y4.Q3));
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider", this.f428a.V());
            JsonUtils.putStringIfValid(jSONObject, "mediation_provider_v2", this.f428a.C());
            jSONObject.put("installed_mediation_adapters", w3.b(this.f428a));
            Map mapF = this.f428a.A().F();
            jSONObject.put("package_name", mapF.get("package_name"));
            jSONObject.put("app_version", mapF.get("app_version"));
            jSONObject.put("debug", mapF.get("debug"));
            jSONObject.put("tg", mapF.get("tg"));
            jSONObject.put("target_sdk", mapF.get("target_sdk"));
            jSONObject.put("session_id", mapF.get("session_id"));
            List list = (List) mapF.get("application_start_info");
            if (!CollectionUtils.isEmpty(list)) {
                JsonUtils.putJsonArray(jSONObject, "application_start_info", new JSONArray((Collection) list));
            }
            List list2 = (List) mapF.get("application_exit_info");
            if (!CollectionUtils.isEmpty(list2)) {
                JsonUtils.putJsonArray(jSONObject, "application_exit_info", new JSONArray((Collection) list2));
            }
            List<String> adUnitIds = this.f428a.J() != null ? this.f428a.J().getAdUnitIds() : null;
            if (adUnitIds != null && adUnitIds.size() > 0) {
                List<String> listRemoveTrimmedEmptyStrings = CollectionUtils.removeTrimmedEmptyStrings(adUnitIds);
                jSONObject.put("ad_unit_ids", CollectionUtils.implode(listRemoveTrimmedEmptyStrings, listRemoveTrimmedEmptyStrings.size()));
            }
            jSONObject.put(AndroidTcfDataSource.TCF_TCSTRING_KEY, mapF.get(AndroidTcfDataSource.TCF_TCSTRING_KEY));
            jSONObject.put("IABTCF_gdprApplies", mapF.get("IABTCF_gdprApplies"));
            Object obj = mapF.get("IABTCF_AddtlConsent");
            if (obj instanceof String) {
                JsonUtils.putStringIfValid(jSONObject, "IABTCF_AddtlConsent", (String) obj);
            }
            jSONObject.put("consent_flow_info", this.f428a.x().b());
            Map mapM = this.f428a.A().M();
            jSONObject.put("platform", mapM.get("platform"));
            jSONObject.put("os", mapM.get("os"));
            jSONObject.put("locale", mapM.get("locale"));
            jSONObject.put("brand", mapM.get("brand"));
            jSONObject.put("brand_name", mapM.get("brand_name"));
            jSONObject.put("hardware", mapM.get("hardware"));
            jSONObject.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, mapM.get(DeviceRequestsHelper.DEVICE_INFO_MODEL));
            jSONObject.put("revision", mapM.get("revision"));
            jSONObject.put("is_tablet", mapM.get("is_tablet"));
            jSONObject.put("screen_size_in", mapM.get("screen_size_in"));
            jSONObject.put("supported_abis", mapM.get("supported_abis"));
            Object obj2 = mapM.get("video_decoders");
            if (obj2 != null) {
                jSONObject.put("video_decoders", obj2);
            }
            if (((Boolean) this.f428a.a(y4.b4)).booleanValue()) {
                jSONObject.put("mtl", this.f428a.n0().getLastTrimMemoryLevel());
            }
            try {
                ActivityManager activityManager = (ActivityManager) com.applovin.impl.sdk.k.o().getSystemService("activity");
                ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                if (activityManager != null) {
                    activityManager.getMemoryInfo(memoryInfo);
                    jSONObject.put("fm", memoryInfo.availMem);
                    jSONObject.put("tm", memoryInfo.totalMem);
                    jSONObject.put("lmt", memoryInfo.threshold);
                    jSONObject.put("lm", memoryInfo.lowMemory);
                }
            } catch (Throwable unused) {
            }
            v.a aVarF = this.f428a.A().f();
            jSONObject.put("dnt", aVarF.c());
            jSONObject.put("dnt_code", aVarF.b().b());
            Boolean boolB = p0.c().b(a());
            if (((Boolean) this.f428a.a(y4.L3)).booleanValue() && StringUtils.isValidString(aVarF.a()) && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfa", aVarF.a());
            }
            l.b bVarG = this.f428a.A().G();
            if (((Boolean) this.f428a.a(y4.E3)).booleanValue() && bVarG != null && !Boolean.TRUE.equals(boolB)) {
                jSONObject.put("idfv", bVarG.f644a);
                jSONObject.put("idfv_scope", bVarG.b);
            }
            if (((Boolean) this.f428a.a(y4.H3)).booleanValue()) {
                jSONObject.put("compass_random_token", this.f428a.u());
            }
            if (((Boolean) this.f428a.a(y4.J3)).booleanValue()) {
                jSONObject.put("applovin_random_token", this.f428a.i0());
            }
            if (((Boolean) this.f428a.a(y4.N3)).booleanValue()) {
                JsonUtils.putStringIfValid(jSONObject, "art", this.f428a.r());
            }
            JsonUtils.putStringIfValid(jSONObject, "eventid", this.f428a.E());
            if (this.f428a.t0().c()) {
                jSONObject.put("test_mode", true);
            }
            List listB = this.f428a.t0().b();
            if (listB != null && !listB.isEmpty()) {
                jSONObject.put("test_mode_networks", listB);
            }
            jSONObject.put("sdk_extra_parameters", new JSONObject(this.f428a.o0().getExtraParameters()));
            Map mapL0 = this.f428a.l0();
            if (!CollectionUtils.isEmpty(mapL0)) {
                jSONObject.put("segments", new JSONObject(mapL0));
            }
        } catch (JSONException e) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.a(this.b, "Failed to create JSON body", e);
            }
            this.f428a.D().a(this.b, "createJSONBody", e);
        }
        return jSONObject;
    }

    protected Map h() {
        HashMap map = new HashMap();
        if (!((Boolean) this.f428a.a(y4.B5)).booleanValue() && !((Boolean) this.f428a.a(y4.A5)).booleanValue()) {
            map.put("rid", UUID.randomUUID().toString());
        }
        if (!((Boolean) this.f428a.a(y4.l5)).booleanValue()) {
            map.put(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, this.f428a.j0());
        }
        CollectionUtils.putStringIfValid("connectEventKey", this.f428a.q(), map);
        Boolean boolB = p0.b().b(a());
        if (boolB != null) {
            map.put("huc", boolB.toString());
        }
        Boolean boolB2 = p0.c().b(a());
        if (boolB2 != null) {
            map.put("aru", boolB2.toString());
        }
        Boolean boolB3 = p0.a().b(a());
        if (boolB3 != null) {
            map.put("dns", boolB3.toString());
        }
        return map;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!o0.j() && j.compareAndSet(false, true)) {
            try {
                ProviderInstaller.installIfNeeded(com.applovin.impl.sdk.k.o());
            } catch (Throwable th) {
                if (com.applovin.impl.sdk.o.a()) {
                    this.c.a(this.b, "Cannot update security provider", th);
                }
            }
        }
        this.f428a.w0().d(d2.f, b(g()));
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        Map mapH = h();
        a.C0161a c0161aB = com.applovin.impl.sdk.network.a.a(this.f428a).b(g()).a(f()).b(mapH).a(e()).b(((Boolean) this.f428a.a(y4.M5)).booleanValue()).c("POST").a((Object) new JSONObject()).a(((Integer) this.f428a.a(y4.h3)).intValue()).b(((Integer) this.f428a.a(y4.k3)).intValue());
        com.applovin.impl.sdk.k kVar = this.f428a;
        y4 y4Var = y4.g3;
        com.applovin.impl.sdk.network.a aVarA = c0161aB.c(((Integer) kVar.a(y4Var)).intValue()).e(((Boolean) this.f428a.a(y4.t3)).booleanValue()).a(v4.a.a(((Integer) this.f428a.a(y4.q5)).intValue())).f(true).a();
        this.f428a.r0().a(new c(this.f428a), e6.b.TIMEOUT, ((long) ((Integer) this.f428a.a(y4Var)).intValue()) + 250);
        a aVar = new a(aVarA, this.f428a, d(), jElapsedRealtime);
        aVar.c(y4.o0);
        aVar.b(y4.p0);
        this.f428a.r0().a(aVar);
    }

    class a extends m6 {
        final /* synthetic */ long m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(com.applovin.impl.sdk.network.a aVar, com.applovin.impl.sdk.k kVar, boolean z, long j) {
            super(aVar, kVar, z);
            this.m = j;
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, JSONObject jSONObject, int i) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            u5.this.a(jSONObject);
            this.f428a.w0().d(d2.g, u5.this.a(str, jElapsedRealtime, i, jSONObject, null));
        }

        @Override // com.applovin.impl.m6, com.applovin.impl.q0.e
        public void a(String str, int i, String str2, JSONObject jSONObject) {
            if (com.applovin.impl.sdk.o.a()) {
                this.c.b(this.b, "Unable to fetch basic SDK settings: server returned " + i);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.m;
            u5.this.a(jSONObject != null ? jSONObject : new JSONObject());
            this.f428a.w0().d(d2.h, u5.this.a(str, jElapsedRealtime, i, jSONObject, str2));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public HashMap a(String str, long j2, int i, JSONObject jSONObject, String str2) {
        Uri uriBuild = Uri.parse(str).buildUpon().clearQuery().build();
        JSONObject jSONObject2 = new JSONObject();
        JsonUtils.putString(jSONObject2, "domain", uriBuild.getHost());
        if (jSONObject != null) {
            JSONArray jSONArray = JsonUtils.getJSONArray(jSONObject, "signal_providers", null);
            JSONArray jSONArray2 = JsonUtils.getJSONArray(jSONObject, "auto_init_adapters", null);
            if (jSONArray != null) {
                JsonUtils.putInt(jSONObject2, "signal_provider_count", jSONArray.length());
            }
            if (jSONArray2 != null) {
                JsonUtils.putInt(jSONObject2, "auto_init_adapter_count", jSONArray2.length());
            }
        }
        HashMap map = new HashMap();
        map.put("attempt_number", Integer.toString(this.g));
        map.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str2);
        map.put("url", uriBuild.toString());
        map.put("details", jSONObject2.toString());
        map.put("duration_ms", Long.toString(j2));
        map.put("code", Integer.toString(i));
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(JSONObject jSONObject) {
        b bVar;
        synchronized (this.h) {
            bVar = this.i;
            this.i = null;
        }
        if (bVar != null) {
            bVar.a(jSONObject);
        }
    }
}
