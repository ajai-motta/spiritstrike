package com.applovin.impl;

import com.applovin.impl.sdk.utils.JsonUtils;
import com.google.android.gms.measurement.AppMeasurement;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class d2 {
    public static final d2 A;
    public static final d2 A0;
    public static final d2 B;
    public static final d2 B0;
    public static final d2 C;
    public static final d2 C0;
    public static final d2 D;
    public static final d2 D0;
    public static final d2 E;
    public static final d2 E0;
    public static final d2 F;
    public static final d2 F0;
    public static final d2 G;
    public static final d2 G0;
    public static final d2 H;
    public static final d2 H0;
    public static final d2 I;
    public static final d2 I0;
    public static final d2 J;
    public static final d2 J0;
    public static final d2 K;
    public static final d2 K0;
    public static final d2 L;
    public static final d2 L0;
    public static final d2 M;
    public static final d2 M0;
    public static final d2 N;
    public static final d2 N0;
    public static final d2 O;
    public static final d2 O0;
    public static final d2 P;
    public static final d2 P0;
    public static final d2 Q;
    public static final d2 Q0;
    public static final d2 R;
    public static final d2 R0;
    public static final d2 S;
    public static final d2 S0;
    public static final d2 T;
    public static final d2 T0;
    public static final d2 U;
    public static final d2 U0;
    public static final d2 V;
    public static final d2 V0;
    public static final d2 W;
    public static final d2 W0;
    public static final d2 X;
    public static final d2 X0;
    public static final d2 Y;
    public static final d2 Y0;
    public static final d2 Z;
    public static final d2 Z0;
    public static final d2 a0;
    public static final d2 a1;
    public static final d2 b0;
    public static final d2 b1;
    private static JSONObject c;
    public static final d2 c0;
    public static final d2 d;
    public static final d2 d0;
    public static final d2 e;
    public static final d2 e0;
    public static final d2 f;
    public static final d2 f0;
    public static final d2 g;
    public static final d2 g0;
    public static final d2 h;
    public static final d2 h0;
    public static final d2 i;
    public static final d2 i0;
    public static final d2 j;
    public static final d2 j0;
    public static final d2 k;
    public static final d2 k0;
    public static final d2 l;
    public static final d2 l0;
    public static final d2 m;
    public static final d2 m0;
    public static final d2 n;
    public static final d2 n0;
    public static final d2 o;
    public static final d2 o0;
    public static final d2 p;
    public static final d2 p0;
    public static final d2 q;
    public static final d2 q0;
    public static final d2 r;
    public static final d2 r0;
    public static final d2 s;
    public static final d2 s0;
    public static final d2 t;
    public static final d2 t0;
    public static final d2 u;
    public static final d2 u0;
    public static final d2 v;
    public static final d2 v0;
    public static final d2 w;
    public static final d2 w0;
    public static final d2 x;
    public static final d2 x0;
    public static final d2 y;
    public static final d2 y0;
    public static final d2 z;
    public static final d2 z0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f351a;
    private final b b;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f352a;

        static {
            int[] iArr = new int[b.values().length];
            f352a = iArr;
            try {
                iArr[b.AD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f352a[b.MEDIATED_AD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f352a[b.ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f352a[b.USER_SESSION.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public enum b {
        AD,
        MEDIATED_AD,
        ERROR,
        USER_SESSION
    }

    static {
        b bVar = b.ERROR;
        d = new d2("generic", bVar);
        b bVar2 = b.USER_SESSION;
        e = new d2("sdk_init", bVar2);
        f = new d2("fetch_basic_settings_started", bVar2);
        g = new d2("fetch_basic_settings_success", bVar2);
        h = new d2("fetch_basic_settings_failure", bVar2);
        i = new d2("pub_init_callback", bVar2);
        j = new d2("sdk_extra_parameter_set", bVar2);
        k = new d2("app_validation_success", bVar2);
        l = new d2("app_validation_failure", bVar2);
        m = new d2("consent_flow_started", bVar2);
        n = new d2("terms_and_privacy_policy_alert_shown", bVar2);
        o = new d2("terms_and_privacy_policy_alert_hidden", bVar2);
        p = new d2("cmp_load_started", bVar2);
        q = new d2("cmp_load_success", bVar2);
        r = new d2("cmp_load_failure", bVar2);
        s = new d2("cmp_show_attempted", bVar2);
        t = new d2("cmp_show_failure", bVar2);
        u = new d2("cmp_hidden", bVar2);
        v = new d2("consent_flow_completed", bVar2);
        b bVar3 = b.AD;
        w = new d2("ad_requested", bVar3);
        x = new d2("ad_request_success", bVar3);
        y = new d2("ad_request_failure", bVar3);
        z = new d2("ad_load_success", bVar3);
        A = new d2("ad_load_failure", bVar3);
        B = new d2("ad_display_attempted", bVar3);
        C = new d2("ad_displayed", bVar3);
        D = new d2("ad_reshown", bVar3);
        E = new d2("ad_display_failure", bVar3);
        F = new d2("ad_hidden", bVar3);
        G = new d2("reward_reporting_error", bVar3);
        H = new d2("reward_validation_error", bVar3);
        I = new d2("user_not_rewarded", bVar3);
        J = new d2("original_resource_urls_restored", bVar3);
        K = new d2("resource_load_started", bVar3);
        L = new d2("resource_retrieved_from_cache", bVar3);
        M = new d2("resource_load_success", bVar3);
        N = new d2("resource_load_failure", bVar3);
        O = new d2("resource_download_started", bVar3);
        P = new d2("resource_stream_loaded", bVar3);
        Q = new d2("resource_download_success", bVar3);
        R = new d2("resource_download_failure", bVar3);
        S = new d2("ad_persist_request", bVar3);
        T = new d2("ad_persist_success", bVar3);
        U = new d2("ad_persist_failure", bVar3);
        V = new d2("persisted_ad_requested", bVar3);
        W = new d2("persisted_ad_load_success", bVar3);
        X = new d2("persisted_ad_load_failure", bVar3);
        Y = new d2("persisted_ad_expired", bVar3);
        Z = new d2("custom_intent_launch_success", bVar3);
        a0 = new d2("custom_intent_launch_failure", bVar3);
        b bVar4 = b.MEDIATED_AD;
        b0 = new d2("adapter_init_started", bVar4);
        c0 = new d2("adapter_init_success", bVar4);
        d0 = new d2("adapter_init_failure", bVar4);
        e0 = new d2("signal_collection_success", bVar4);
        f0 = new d2("signal_collection_failure", bVar4);
        g0 = new d2("mediated_ad_requested", bVar4);
        h0 = new d2("mediated_ad_request_success", bVar4);
        i0 = new d2("mediated_ad_request_failure", bVar4);
        j0 = new d2("mediated_ad_load_started", bVar4);
        k0 = new d2("mediated_ad_load_success", bVar4);
        l0 = new d2("mediated_ad_load_failure", bVar4);
        m0 = new d2("waterfall_processing_complete", bVar4);
        n0 = new d2("mediated_ad_display_attempted", bVar4);
        o0 = new d2("mediated_ad_displayed", bVar4);
        p0 = new d2("mediated_ad_viewability_impression_called", bVar4);
        q0 = new d2("mediated_ad_display_failure", bVar4);
        r0 = new d2("mediated_ad_hidden", bVar4);
        s0 = new d2("mediated_ad_hidden_callback_not_called", bVar4);
        t0 = new d2("mediated_ad_reward_reporting_error", bVar4);
        u0 = new d2("mediated_ad_reward_validation_error", bVar4);
        v0 = new d2("user_not_rewarded_for_mediated_ad", bVar4);
        w0 = new d2("mediated_ad_extra_parameter_set", bVar4);
        x0 = new d2("mediated_ad_failover_missing_cached_ad", bVar4);
        y0 = new d2("mediated_ad_failover_attempted", bVar4);
        z0 = new d2("mediated_ad_failover_success", bVar4);
        A0 = new d2("mediated_ad_failover_failure", bVar4);
        B0 = new d2("activity_destroyed_by_app_relaunch", bVar);
        C0 = new d2("activity_missing", bVar);
        D0 = new d2("ad_context_violation", bVar);
        E0 = new d2("anr", bVar);
        F0 = new d2("app_exit_info_stack_trace", bVar);
        G0 = new d2("app_killed_during_ad", bVar);
        H0 = new d2("app_killed_during_mediated_ad", bVar);
        I0 = new d2("array_error", bVar);
        J0 = new d2("auto_redirect", bVar);
        K0 = new d2("black_view_detected", bVar);
        L0 = new d2("black_view", bVar);
        M0 = new d2("cache_error", bVar);
        N0 = new d2("caught_exception", bVar);
        O0 = new d2("consent_flow_error", bVar);
        P0 = new d2(AppMeasurement.CRASH_ORIGIN, bVar);
        Q0 = new d2("file_error", bVar);
        R0 = new d2("haptic_error", bVar);
        S0 = new d2("integration_error", bVar);
        T0 = new d2("media_error", bVar);
        U0 = new d2("memory_leak", bVar);
        V0 = new d2("native_error", bVar);
        W0 = new d2("network_error", bVar);
        X0 = new d2("task_exception", bVar);
        Y0 = new d2("task_latency_alert", bVar);
        Z0 = new d2("template_error", bVar);
        a1 = new d2("unexpected_state", bVar);
        b1 = new d2("web_view_error", bVar);
    }

    public d2(String str, b bVar) {
        this.f351a = str;
        this.b = bVar;
    }

    public b a() {
        return this.b;
    }

    public String b() {
        return this.f351a;
    }

    public double a(com.applovin.impl.sdk.k kVar) {
        if (o7.k(com.applovin.impl.sdk.k.o())) {
            return 100.0d;
        }
        double dA = a(this.f351a, kVar);
        if (dA >= 0.0d) {
            return dA;
        }
        double dA2 = a(this.b, kVar);
        return dA2 >= 0.0d ? dA2 : ((Float) kVar.a(y4.H)).floatValue();
    }

    private double a(String str, com.applovin.impl.sdk.k kVar) {
        if (c == null) {
            c = JsonUtils.deserialize((String) kVar.a(y4.D));
        }
        Double d2 = JsonUtils.getDouble(c, str, (Double) null);
        if (d2 != null) {
            return d2.doubleValue();
        }
        return -1.0d;
    }

    private double a(b bVar, com.applovin.impl.sdk.k kVar) {
        float fFloatValue;
        int i2 = a.f352a[bVar.ordinal()];
        if (i2 == 1 || i2 == 2) {
            fFloatValue = ((Float) kVar.a(y4.E)).floatValue();
        } else if (i2 == 3) {
            fFloatValue = ((Float) kVar.a(y4.F)).floatValue();
        } else {
            if (i2 != 4) {
                return -1.0d;
            }
            fFloatValue = ((Float) kVar.a(y4.G)).floatValue();
        }
        return fFloatValue;
    }
}
