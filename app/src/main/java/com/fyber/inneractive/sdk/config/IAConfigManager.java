package com.fyber.inneractive.sdk.config;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.ext.SdkExtensions;
import android.webkit.WebView;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.s1;
import com.fyber.inneractive.sdk.util.y0;
import com.fyber.inneractive.sdk.web.a1;
import com.fyber.inneractive.sdk.web.b1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class IAConfigManager {
    public static long P;
    public final y0 A;
    public com.fyber.inneractive.sdk.network.v0 B;
    public com.fyber.inneractive.sdk.network.v0 C;
    public g D;
    public final com.fyber.inneractive.sdk.ignite.h E;
    public final com.fyber.inneractive.sdk.topics.b F;
    public final com.fyber.inneractive.sdk.dv.handler.a G;
    public final com.fyber.inneractive.sdk.cache.k H;
    public final com.fyber.inneractive.sdk.network.f I;
    public final HashMap J;
    public com.fyber.inneractive.sdk.measurement.e K;
    public WebView L;
    public final com.fyber.inneractive.sdk.config.global.r M;
    public com.fyber.inneractive.sdk.config.cellular.a N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HashMap f925a = new HashMap();
    public HashMap b = new HashMap();
    public String c;
    public String d;
    public String e;
    public Context f;
    public final CopyOnWriteArrayList g;
    public boolean h;
    public final k0 i;
    public InneractiveUserConfig j;
    public boolean k;
    public String l;
    public InneractiveMediationName m;
    public String n;
    public String o;
    public ArrayList p;
    public boolean q;
    public final AtomicBoolean r;
    public final com.fyber.inneractive.sdk.network.l0 s;
    public String t;
    public s u;
    public i v;
    public t w;
    public final x0 x;
    public s1 y;
    public com.fyber.inneractive.sdk.config.global.a z;
    public static final IAConfigManager O = new IAConfigManager();
    public static final g0 Q = new g0();

    public interface OnConfigurationReadyAndValidListener {
        void onConfigurationReadyAndValid(IAConfigManager iAConfigManager, boolean z, Exception exc);
    }

    public IAConfigManager() {
        com.fyber.inneractive.sdk.dv.handler.a eVar;
        new HashSet();
        this.h = false;
        this.i = new k0();
        this.k = false;
        this.q = false;
        this.r = new AtomicBoolean(false);
        this.s = new com.fyber.inneractive.sdk.network.l0();
        this.t = "";
        this.x = new x0();
        this.A = new y0();
        this.E = new com.fyber.inneractive.sdk.ignite.h();
        this.F = new com.fyber.inneractive.sdk.topics.b();
        String[] strArr = {"com.google.android.gms.ads.MobileAds", "com.google.android.gms.ads.query.QueryInfoGenerationCallback"};
        for (int i = 0; i < 2; i++) {
            try {
                Class.forName(strArr[i]);
            } catch (ClassNotFoundException unused) {
                eVar = new com.fyber.inneractive.sdk.dv.handler.f();
            }
        }
        eVar = new com.fyber.inneractive.sdk.dv.handler.e();
        this.G = eVar;
        this.H = new com.fyber.inneractive.sdk.cache.k();
        this.I = new com.fyber.inneractive.sdk.network.f();
        this.J = new HashMap();
        this.M = com.fyber.inneractive.sdk.config.global.r.a();
        this.g = new CopyOnWriteArrayList();
    }

    public static void addListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.add(onConfigurationReadyAndValidListener);
    }

    public static void b() {
        s sVar;
        com.fyber.inneractive.sdk.topics.b bVar;
        IAConfigManager iAConfigManager = O;
        iAConfigManager.getClass();
        if (iAConfigManager.F.i.get() || (sVar = iAConfigManager.u) == null || sVar.b == null) {
            return;
        }
        if (iAConfigManager.r.compareAndSet(false, true)) {
            int iA = iAConfigManager.u.b.a("topics_enabled", 0, 0);
            int iA2 = iAConfigManager.u.b.a("e_topics_enabled", 0, 0);
            if (iA == 0 && iA2 == 0) {
                IAlog.a("Topics API feature disabled - topics_enabled & e_topics_enabled flags are 0", new Object[0]);
                return;
            }
            boolean z = iA != 0;
            boolean z2 = iA2 != 0;
            try {
                if (!f() || (bVar = iAConfigManager.F) == null) {
                    return;
                }
                bVar.a(z, z2);
                iAConfigManager.F.c();
            } catch (Throwable th) {
                IAlog.a("error while trying to init topics ", th, new Object[0]);
            }
        }
    }

    public static boolean c() {
        return Build.VERSION.SDK_INT >= 30 && SdkExtensions.getExtensionVersion(1000000) >= 11 && com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static boolean d() {
        g gVar = O.D;
        return gVar != null && gVar.e();
    }

    public static boolean e() {
        IAConfigManager iAConfigManager = O;
        boolean z = iAConfigManager.e != null;
        int i = k.f959a;
        boolean zBooleanValue = Boolean.valueOf(System.getProperty("ia.testEnvironmentConfiguration.forceConfigRefresh", Boolean.toString(false))).booleanValue();
        if ((z && System.currentTimeMillis() - P > 3600000) || zBooleanValue) {
            if (zBooleanValue) {
                s sVar = iAConfigManager.u;
                sVar.d = false;
                com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.util.l(sVar.e));
            }
            a();
            b1 b1Var = b1.c;
            b1Var.getClass();
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new a1(b1Var));
        }
        return z;
    }

    public static boolean f() {
        return Build.VERSION.SDK_INT >= 31 && SdkExtensions.getExtensionVersion(1000000) >= 4 && com.fyber.inneractive.sdk.util.o.a("android.permission.ACCESS_ADSERVICES_TOPICS");
    }

    public static void g() {
        SharedPreferences sharedPreferences = com.fyber.inneractive.sdk.util.o.f1662a.getSharedPreferences("IAConfigurationPreferences", 0);
        if (sharedPreferences != null) {
            sharedPreferences.edit().putBoolean("IAConfigFQE", true).apply();
        }
    }

    public static void removeListener(OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener) {
        O.g.remove(onConfigurationReadyAndValidListener);
    }

    public final void a(Exception exc) {
        for (OnConfigurationReadyAndValidListener onConfigurationReadyAndValidListener : this.g) {
            if (onConfigurationReadyAndValidListener != null) {
                boolean z = O.e != null;
                IAlog.e("notifying listener configuration state has been resolved", new Object[0]);
                onConfigurationReadyAndValidListener.onConfigurationReadyAndValid(this, z, !z ? exc : null);
            }
        }
    }

    public static void a() {
        IAConfigManager iAConfigManager = O;
        com.fyber.inneractive.sdk.network.v0 v0Var = iAConfigManager.B;
        if (v0Var != null) {
            iAConfigManager.s.a(v0Var);
        }
        s sVar = iAConfigManager.u;
        if (sVar.d) {
            return;
        }
        iAConfigManager.s.a(new com.fyber.inneractive.sdk.network.v0(new p(sVar), sVar.f979a, sVar.e));
    }
}
