package com.applovin.impl;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.ad.AppLovinAdImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinWebViewActivity;
import com.facebook.bolts.AppLinks;
import com.facebook.internal.NativeProtocol;
import com.google.ads.mediation.applovin.AppLovinMediationAdapter;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public abstract class l7 {

    class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f450a;
        final /* synthetic */ com.applovin.impl.adview.a b;
        final /* synthetic */ com.applovin.impl.sdk.k c;

        a(String str, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.k kVar) {
            this.f450a = str;
            this.b = aVar;
            this.c = kVar;
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (activity instanceof AppLovinWebViewActivity) {
                ((AppLovinWebViewActivity) activity).loadUrl(this.f450a, null);
                t2.c(this.b.e(), this.b.g(), this.b.i());
            }
        }

        @Override // com.applovin.impl.b, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            if (activity instanceof AppLovinWebViewActivity) {
                t2.a(this.b.e(), this.b.g(), this.b.i());
                this.c.e().b(this);
            }
        }
    }

    public static boolean a(Uri uri, Context context, com.applovin.impl.sdk.k kVar) {
        return b(uri, null, context, kVar);
    }

    public static boolean b(Uri uri, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.k kVar) {
        return a(uri, null, bVar, context, kVar);
    }

    public static void c(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar) {
        String strEmptyIfNull = StringUtils.emptyIfNull(uri.getQueryParameter("error"));
        String strEmptyIfNull2 = StringUtils.emptyIfNull(uri.getQueryParameter("exception"));
        String strEmptyIfNull3 = StringUtils.emptyIfNull(uri.getQueryParameter("details"));
        HashMap<String, String> mapHashMap = CollectionUtils.hashMap("source", strEmptyIfNull);
        CollectionUtils.putStringIfValid("top_main_method", strEmptyIfNull2, mapHashMap);
        CollectionUtils.putStringIfValid("details", strEmptyIfNull3, mapHashMap);
        if (bVar != null) {
            mapHashMap.putAll(f2.a((AppLovinAdImpl) bVar));
            mapHashMap.putAll(f2.a(bVar));
        }
        kVar.D().d(d2.Z0, mapHashMap);
    }

    public static boolean a(Uri uri, String str, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.k kVar) {
        String strDefaultIfEmpty = null;
        boolean z = false;
        if (uri == null) {
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.external_redirect_failure"), null);
            return false;
        }
        try {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().d("UriUtils", "Opening URI: " + uri);
            }
            Intent intent = new Intent("android.intent.action.VIEW", uri);
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            strDefaultIfEmpty = StringUtils.defaultIfEmpty(str, a(intent, uri, bVar, context));
            intent.setPackage(strDefaultIfEmpty);
            kVar.n0().pauseForClick();
            context.startActivity(intent);
            z = true;
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Unable to open \"" + uri + "\".", th);
            }
            HashMap<String, String> mapHashMap = CollectionUtils.hashMap("url", uri.toString());
            mapHashMap.put("name", strDefaultIfEmpty);
            if (bVar != null) {
                mapHashMap.putAll(f2.a((AppLovinAdImpl) bVar));
                mapHashMap.putAll(f2.a(bVar));
            }
            if ("play.google.com".equals(uri.getHost())) {
                CollectionUtils.putStringIfValid("details", (String) kVar.A().M().get("ps_version"), mapHashMap);
            }
            kVar.D().a("UriUtils", "openUri", th, mapHashMap);
        }
        if (!z) {
            kVar.n0().resumeForClick();
        }
        AppLovinBroadcastManager.sendBroadcast(new Intent(z ? "com.applovin.external_redirect_success" : "com.applovin.external_redirect_failure"), CollectionUtils.map("url", uri));
        return z;
    }

    public static void b(Uri uri, final com.applovin.impl.sdk.ad.b bVar, final com.applovin.impl.sdk.k kVar) {
        final String queryParameter = uri.getQueryParameter("url");
        if (!StringUtils.isValidString(queryParameter)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("UriUtils", "Could not find resource URL to preload from query parameters");
            }
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.preload_failure"), CollectionUtils.map("error", "Invalid URL"));
            return;
        }
        if (bVar == null) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("UriUtils", "Cannot preload resource: ad is null");
            }
            Map map = CollectionUtils.map("error", "Invalid ad reference");
            map.put("resource_url", queryParameter);
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.preload_failure"), map);
            return;
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().a("UriUtils", "Attempting to preload resource: " + queryParameter);
        }
        kVar.r0().a((j5) new s6(kVar, false, "preloadResource", new Runnable() { // from class: com.applovin.impl.l7$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                l7.a(kVar, queryParameter, bVar);
            }
        }), e6.b.CACHING);
    }

    private static String a(Intent intent, Uri uri, com.applovin.impl.sdk.ad.b bVar, Context context) {
        if (!"market".equals(intent.getScheme()) && !"play.google.com".equals(uri.getHost())) {
            if ("https".equals(intent.getScheme()) && bVar != null) {
                if (bVar.c1()) {
                    String strI = com.applovin.impl.sdk.l.I();
                    if (a(strI, context)) {
                        return strI;
                    }
                }
                for (String str : bVar.N()) {
                    if (a(str, context)) {
                        return str;
                    }
                }
            }
            return null;
        }
        if (Boolean.FALSE.equals(a(context))) {
            return "com.android.vending";
        }
        return null;
    }

    private static boolean a(String str, Context context) {
        return (TextUtils.isEmpty(str) || context.getPackageManager().getLaunchIntentForPackage(str) == null) ? false : true;
    }

    public static boolean a(Uri uri) {
        return uri != null && "applovin".equalsIgnoreCase(uri.getScheme()) && AppLovinMediationAdapter.APPLOVIN_SDK_ERROR_DOMAIN.equalsIgnoreCase(uri.getHost()) && "/adservice/deeplink".equals(uri.getPath());
    }

    public static void a(Uri uri, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.k kVar) {
        com.applovin.impl.adview.b bVarF = aVar.f();
        String queryParameter = uri.getQueryParameter("n");
        if (TextUtils.isEmpty(queryParameter)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("UriUtils", "Could not find url to load from query in original uri");
            }
            AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.external_redirect_failure"), null);
            return;
        }
        b5 b5VarQ0 = kVar.q0();
        a5 a5Var = a5.T;
        String queryParameter2 = (String) b5VarQ0.a(a5Var, null);
        if (uri.getQueryParameterNames().contains("browser")) {
            queryParameter2 = uri.getQueryParameter("browser");
            if (TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = null;
            }
            if (Boolean.parseBoolean(uri.getQueryParameter("retain_browser"))) {
                kVar.q0().b(a5Var, queryParameter2);
            }
        }
        String queryParameter3 = uri.getQueryParameter("load_type");
        if ("external".equalsIgnoreCase(queryParameter3)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Loading new page externally: " + queryParameter);
            }
            a(queryParameter, queryParameter2, aVar, kVar);
            return;
        }
        if ("internal".equalsIgnoreCase(queryParameter3)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Loading new page in WebView: " + queryParameter);
            }
            bVarF.loadUrl(queryParameter);
            String queryParameter4 = uri.getQueryParameter("bg_color");
            if (StringUtils.isValidString(queryParameter4)) {
                bVarF.setBackgroundColor(Color.parseColor(queryParameter4));
                return;
            }
            return;
        }
        if ("in_app".equalsIgnoreCase(queryParameter3)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Loading new page in slide-up webview: " + queryParameter);
            }
            kVar.e().a(new a(queryParameter, aVar, kVar));
            Intent intent = new Intent(com.applovin.impl.sdk.k.o(), (Class<?>) AppLovinWebViewActivity.class);
            intent.putExtra(AppLovinWebViewActivity.INTENT_EXTRA_KEY_SDK_KEY, kVar.j0());
            intent.setFlags(268435456);
            com.applovin.impl.sdk.k.o().startActivity(intent);
            return;
        }
        if ("in_app_v2".equalsIgnoreCase(queryParameter3)) {
            aVar.a(aVar.g(), aVar.i(), null, bVarF.getAndClearLastClickEvent());
            if (aVar.h() != null) {
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("UriUtils", "Loading new page in Custom Tabs: " + queryParameter);
                }
                kVar.z().a(Uri.parse(queryParameter), aVar, kVar.v0());
                return;
            }
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Custom Tabs not supported, loading new page externally: " + queryParameter);
            }
            a(queryParameter, queryParameter2, aVar, kVar);
            return;
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().b("UriUtils", "Could not find load type in original uri");
        }
    }

    public static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, com.applovin.impl.sdk.k kVar) {
        String queryParameter = uri.getQueryParameter("n");
        if (URLUtil.isValidUrl(queryParameter)) {
            kVar.f0().e(com.applovin.impl.sdk.network.d.b().d(StringUtils.appendQueryParameter(queryParameter, "clcode", bVar.getClCode())).a(false).b(Boolean.parseBoolean(uri.getQueryParameter("fire_from_webview"))).a());
            return;
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().b("UriUtils", "Could not find postback url to fire from query in original uri: " + uri);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.k kVar, String str, com.applovin.impl.sdk.ad.b bVar) {
        String str2;
        try {
            com.applovin.impl.sdk.m mVarG = kVar.G();
            Context contextO = com.applovin.impl.sdk.k.o();
            try {
                String strA = mVarG.a(com.applovin.impl.sdk.k.o(), str, bVar.getCachePrefix(), bVar.S(), true, mVarG.a(str, bVar), null, f2.a((AppLovinAdImpl) bVar));
                if (strA != null) {
                    String string = Uri.fromFile(mVarG.a(strA, contextO)).toString();
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("UriUtils", "Successfully cached resource at: " + string);
                    }
                    Map map = CollectionUtils.map("resource_url", str);
                    map.put("cached_url", string);
                    AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.preload_success"), map);
                    return;
                }
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().k("UriUtils", "Failed to cache resource: " + str);
                }
                Map map2 = CollectionUtils.map("error", "Failed to cache resource");
                map2.put("resource_url", str);
                str2 = "com.applovin.preload_failure";
                try {
                    AppLovinBroadcastManager.sendBroadcast(new Intent(str2), map2);
                } catch (Throwable th) {
                    th = th;
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().a("UriUtils", "Exception while caching resource", th);
                    }
                    Map map3 = CollectionUtils.map("url", str);
                    map3.putAll(f2.a((AppLovinAdImpl) bVar));
                    map3.putAll(f2.a(bVar));
                    kVar.D().a("UriUtils", "handlePreload", th, map3);
                    Map map4 = CollectionUtils.map("error", "Internal error while caching");
                    map4.put("resource_url", str);
                    AppLovinBroadcastManager.sendBroadcast(new Intent(str2), map4);
                }
            } catch (Throwable th2) {
                th = th2;
                str2 = "com.applovin.preload_failure";
            }
        } catch (Throwable th3) {
            th = th3;
            str2 = "com.applovin.preload_failure";
        }
    }

    public static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, AppLovinAdView appLovinAdView, com.applovin.impl.sdk.k kVar) {
        Throwable th;
        Intent intentC;
        k7 k7Var = new k7();
        Context contextA = a(uri.getQueryParameter("context_source"), appLovinAdView, kVar);
        Intent intent = null;
        try {
            k7Var.f(uri.getQueryParameter("identifier")).d(uri.getQueryParameter(NativeProtocol.WEB_DIALOG_ACTION)).a(uri.getQueryParameter("data"), uri.getQueryParameter("type")).b(uri.getQueryParameter("flags")).e(uri.getQueryParameter(AppLinks.KEY_NAME_EXTRAS)).a(uri.getQueryParameter("categories")).a(uri.getQueryParameter("clip_data_uri"), uri.getQueryParameter("clip_data_mime_type"), uri.getQueryParameter("clip_data_label")).h(uri.getQueryParameter("source_bounds")).b(uri.getQueryParameter("component"), uri.getQueryParameter("class_name"), uri.getQueryParameter("package")).g(uri.getQueryParameter("selector_action"));
            if (!(contextA instanceof Activity)) {
                k7Var.b(String.valueOf(268435456));
            }
            intentC = Boolean.parseBoolean(uri.getQueryParameter("use_chooser")) ? k7Var.c(uri.getQueryParameter("chooser_title")) : k7Var.a();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Attempting to launch intent with configuration:\n" + a(intentC));
            }
            if (intentC.resolveActivity(contextA.getPackageManager()) != null) {
                contextA.startActivity(intentC);
                kVar.O();
                if (com.applovin.impl.sdk.o.a()) {
                    kVar.O().a("UriUtils", "Successfully launched intent");
                }
                AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_intent_launch_success"), null);
                kVar.g().d(d2.Z, a(intentC, uri, bVar));
                return;
            }
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("UriUtils", "No activity found to handle the intent");
            }
            a("noActivityToHandleIntent", null, uri, a(intentC, uri, bVar), bVar, contextA, kVar);
        } catch (Throwable th3) {
            th = th3;
            intent = intentC;
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("UriUtils", "Exception while launching intent", th);
            }
            a("intentLaunchException", th, uri, a(intent, uri, bVar), bVar, contextA, kVar);
        }
    }

    private static Context a(String str, AppLovinAdView appLovinAdView, com.applovin.impl.sdk.k kVar) {
        if ("application".equalsIgnoreCase(str)) {
            return com.applovin.impl.sdk.k.o();
        }
        if ("activity".equalsIgnoreCase(str)) {
            Activity activityB = f8.b(appLovinAdView, kVar);
            if (activityB != null) {
                return activityB;
            }
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().k("UriUtils", "Could not retrieve the activity context. Falling back to view context.");
            }
        }
        return appLovinAdView.getContext();
    }

    private static void a(String str, Throwable th, Uri uri, Map map, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.k kVar) {
        AppLovinBroadcastManager.sendBroadcast(new Intent("com.applovin.custom_intent_launch_failure"), null);
        HashMap map2 = new HashMap(map);
        if (th != null) {
            kVar.D().a("UriUtils", "launchCustomIntent", th, map);
            CollectionUtils.putStringIfValid("top_main_method", th.toString(), map2);
        }
        CollectionUtils.putStringIfValid("source", str, map2);
        kVar.g().d(d2.a0, map2);
        a(uri, bVar, context, kVar);
    }

    private static void a(Uri uri, com.applovin.impl.sdk.ad.b bVar, Context context, com.applovin.impl.sdk.k kVar) {
        String queryParameter = uri.getQueryParameter("fallback_url");
        if (TextUtils.isEmpty(queryParameter)) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("UriUtils", "Could not find fallback URL to open from query parameters");
                return;
            }
            return;
        }
        kVar.O();
        if (com.applovin.impl.sdk.o.a()) {
            kVar.O().a("UriUtils", "Opening fallback URL: " + queryParameter);
        }
        b(Uri.parse(queryParameter), bVar, context, kVar);
    }

    private static Map a(Intent intent, Uri uri, com.applovin.impl.sdk.ad.b bVar) {
        Map mapA = f2.a((AppLovinAdImpl) bVar);
        CollectionUtils.putStringIfValid("url", uri.toString(), mapA);
        CollectionUtils.putStringIfValid("details", a(intent), mapA);
        return mapA;
    }

    private static String a(Intent intent) {
        if (intent == null) {
            return "Intent not available";
        }
        ComponentName component = intent.getComponent();
        StringBuilder sb = new StringBuilder("Identifier: ");
        sb.append(o0.j() ? intent.getIdentifier() : null);
        sb.append("\nAction: ");
        sb.append(intent.getAction());
        sb.append("\nData: ");
        sb.append(intent.getData());
        sb.append("\nType: ");
        sb.append(intent.getType());
        sb.append("\nFlags: ");
        sb.append(intent.getFlags());
        sb.append("\nExtras: ");
        sb.append(intent.getExtras());
        sb.append("\nCategories: ");
        sb.append(intent.getCategories());
        sb.append("\nClipData: ");
        sb.append(intent.getClipData());
        sb.append("\nSourceBounds: ");
        sb.append(intent.getSourceBounds());
        sb.append("\nComponent: ");
        sb.append(component != null ? component.flattenToString() : intent.getPackage());
        sb.append("\nSelector: ");
        sb.append(intent.getSelector());
        return sb.toString();
    }

    private static void a(String str, String str2, com.applovin.impl.adview.a aVar, com.applovin.impl.sdk.k kVar) {
        a(Uri.parse(str), str2, aVar.g(), aVar.f().getContext(), kVar);
        t2.b(aVar.e(), aVar.g(), aVar.i());
    }

    public static Boolean a(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            boolean z = true;
            packageManager.getPackageInfo("com.android.vending", 1);
            int applicationEnabledSetting = packageManager.getApplicationEnabledSetting("com.android.vending");
            if (applicationEnabledSetting != 2 && applicationEnabledSetting != 3) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (PackageManager.NameNotFoundException unused) {
            return Boolean.TRUE;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
