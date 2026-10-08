package com.moloco.sdk.internal.client_metrics_data;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: loaded from: classes6.dex */
public final class e {
    public static final e b = new e("SDKInit", 0, "sdk_init_time");
    public static final e c = new e("SDKPerformInitAttempt", 1, "sdk_perform_init_time_ms");
    public static final e d = new e("SDKInitHttpRequest", 2, "sdk_init_request_time_ms");
    public static final e e = new e("SDKInitCacheRead", 3, "sdk_init_cache_read_time_ms");
    public static final e f = new e("SDKInitCacheWrite", 4, "sdk_init_cache_write_time_ms");
    public static final e g = new e("SDKInitCacheClear", 5, "sdk_init_cache_clear_time_ms");
    public static final e h = new e("CreateAd", 6, "create_ad_time_ms");
    public static final e i = new e("CreateAdAwaitAdFactory", 7, "create_ad_await_ad_factory_time_ms");
    public static final e j = new e("LoadAd", 8, "load_ad_time");
    public static final e k = new e("NativePrepareAd", 9, "native_ad_load_prepare_time");
    public static final e l = new e("BidTokenFetch", 10, "bid_token_fetch_time");
    public static final e m = new e("ServerBidTokenFetch", 11, "sbt_fetch_time_ms");
    public static final e n = new e("ServerBidTokenApiFetchTime", 12, "sbt_api_fetch_time_ms");
    public static final e o = new e("ClientBidTokenBuild", 13, "bid_token_build_time_ms");
    public static final e p = new e("LoadToShow", 14, "load_to_show_time");
    public static final e q = new e("CreateToLoad", 15, "ad_create_to_load_ms");
    public static final e r = new e("WebviewLoadAd", 16, "webview_load_ad_ms");
    public static final e s = new e("WebviewEventHandled", 17, "webview_event_handled_time_ms");
    public static final e t = new e("WebviewEventHandlerLatency", 18, "webview_event_handler_latency_ms");
    public static final e u = new e("WebviewPageLoadLatency", 19, "webview_page_load_ms");
    public static final e v = new e("WebviewRequiredContentLoadLatency", 20, "webview_required_content_load_ms");
    public static final /* synthetic */ e[] w;
    public static final /* synthetic */ EnumEntries x;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2036a;

    static {
        e[] eVarArrA = a();
        w = eVarArrA;
        x = EnumEntriesKt.enumEntries(eVarArrA);
    }

    public e(String str, int i2, String str2) {
        this.f2036a = str2;
    }

    public static final /* synthetic */ e[] a() {
        return new e[]{b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v};
    }

    public static EnumEntries<e> b() {
        return x;
    }

    public static e valueOf(String str) {
        return (e) Enum.valueOf(e.class, str);
    }

    public static e[] values() {
        return (e[]) w.clone();
    }

    public final String c() {
        return this.f2036a;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f2036a;
    }
}
