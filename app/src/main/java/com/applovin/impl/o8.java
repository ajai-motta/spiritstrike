package com.applovin.impl;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdkUtils;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public abstract class o8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f549a;
    private static int d;
    private static String e;
    private static String f;
    private static final Object b = new Object();
    private static final AtomicBoolean c = new AtomicBoolean();
    private static final AtomicBoolean g = new AtomicBoolean();

    static {
        com.applovin.impl.sdk.k kVar = com.applovin.impl.sdk.k.D0;
        if (kVar != null && ((Boolean) kVar.a(y4.i4)).booleanValue() && e()) {
            f549a = (String) b5.a(a5.M, "", com.applovin.impl.sdk.k.o());
        } else {
            f549a = "";
            b5.b(a5.M, (Object) null, com.applovin.impl.sdk.k.o());
        }
    }

    public static void a(final com.applovin.impl.sdk.k kVar) {
        if (c.getAndSet(true)) {
            return;
        }
        AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.o8$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                o8.d(kVar);
            }
        });
    }

    public static String b() {
        return f;
    }

    public static String c() {
        return e;
    }

    public static int d() {
        return d;
    }

    private static boolean e() {
        boolean zIsValidString;
        synchronized (b) {
            zIsValidString = StringUtils.isValidString((String) b5.a(a5.M, "", com.applovin.impl.sdk.k.o()));
        }
        return zIsValidString;
    }

    public static void b(com.applovin.impl.sdk.k kVar) {
        if (g.getAndSet(true)) {
            return;
        }
        PackageInfo packageInfoC = c(kVar);
        if (packageInfoC != null) {
            d = packageInfoC.versionCode;
            e = packageInfoC.versionName;
            f = packageInfoC.packageName;
        } else {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().b("WebViewDataCollector", "Failed to get WebView package info");
            }
        }
    }

    private static PackageInfo c(com.applovin.impl.sdk.k kVar) {
        PackageManager packageManager = com.applovin.impl.sdk.k.o().getPackageManager();
        if (o0.h()) {
            return WebView.getCurrentWebViewPackage();
        }
        Iterator it = kVar.c(y4.t4).iterator();
        while (it.hasNext()) {
            try {
                return packageManager.getPackageInfo((String) it.next(), 0);
            } catch (Throwable unused) {
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void d(com.applovin.impl.sdk.k kVar) {
        try {
            synchronized (b) {
                String defaultUserAgent = WebSettings.getDefaultUserAgent(com.applovin.impl.sdk.k.o());
                if (!TextUtils.isEmpty(defaultUserAgent)) {
                    f549a = defaultUserAgent;
                    b5.b(a5.M, f549a, com.applovin.impl.sdk.k.o());
                } else {
                    kVar.O();
                    if (com.applovin.impl.sdk.o.a()) {
                        kVar.O().b("WebViewDataCollector", "Collected invalid user agent");
                    }
                    kVar.D().a(d2.b1, "collectedInvalidUserAgent");
                }
            }
        } catch (Throwable th) {
            kVar.O();
            if (com.applovin.impl.sdk.o.a()) {
                kVar.O().a("WebViewDataCollector", "Failed to collect user agent", th);
            }
            kVar.D().a("WebViewDataCollector", "collectUserAgent", th);
        }
    }

    public static String a() {
        String str;
        synchronized (b) {
            str = f549a;
        }
        return str;
    }
}
