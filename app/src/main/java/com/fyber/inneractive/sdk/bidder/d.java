package com.fyber.inneractive.sdk.bidder;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveUserConfig;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.z0;
import com.unity3d.services.core.properties.MadeWithUnityDetector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public String A;
    public Boolean B;
    public String C;
    public int D;
    public InneractiveUserConfig.Gender E;
    public boolean F;
    public String G;
    public String H;
    public String I;
    public String J;
    public final boolean K;
    public Boolean L;
    public ArrayList M = new ArrayList();
    public ArrayList N = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.fyber.inneractive.sdk.serverapi.c f888a;
    public String b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public String k;
    public Long l;
    public int m;
    public int n;
    public final q o;
    public String p;
    public String q;
    public final d0 r;
    public Boolean s;
    public Boolean t;
    public Boolean u;
    public boolean v;
    public Boolean w;
    public Boolean x;
    public Boolean y;
    public int z;

    public d(com.fyber.inneractive.sdk.serverapi.c cVar) {
        String str;
        this.f888a = cVar;
        if (TextUtils.isEmpty(this.b)) {
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new c(this));
        }
        StringBuilder sb = new StringBuilder("2.2.0-Android-8.4.0");
        if (!TextUtils.isEmpty(InneractiveAdManager.getDevPlatform())) {
            sb.append('-');
            sb.append(InneractiveAdManager.getDevPlatform());
        }
        this.c = sb.toString();
        this.d = com.fyber.inneractive.sdk.util.o.f1662a.getPackageName();
        this.e = com.fyber.inneractive.sdk.util.k.j();
        this.f = com.fyber.inneractive.sdk.util.k.l();
        this.m = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.e());
        this.n = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.d());
        com.fyber.inneractive.sdk.serverapi.a aVar = com.fyber.inneractive.sdk.serverapi.b.f1622a;
        try {
            Class.forName(MadeWithUnityDetector.UNITY_PLAYER_CLASS_NAME);
            str = "unity3d";
        } catch (Throwable unused) {
            str = "native";
        }
        this.o = !str.equals("native") ? !str.equals("unity3d") ? q.UNRECOGNIZED : q.UNITY3D : q.NATIVE;
        this.r = ((com.fyber.inneractive.sdk.util.s.a() ^ true) || IAConfigManager.O.q) ? d0.SECURE : d0.UNSECURE;
        IAConfigManager iAConfigManager = IAConfigManager.O;
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            this.H = iAConfigManager.l;
        } else {
            this.H = iAConfigManager.l + "_" + iAConfigManager.n;
        }
        this.K = InneractiveAdManager.isCurrentUserAChild();
        a();
        this.t = com.fyber.inneractive.sdk.serverapi.b.g();
        this.B = com.fyber.inneractive.sdk.serverapi.b.i();
        this.w = com.fyber.inneractive.sdk.serverapi.b.f();
        this.x = com.fyber.inneractive.sdk.serverapi.b.l();
        this.y = com.fyber.inneractive.sdk.serverapi.b.k();
    }

    public final void a() {
        this.f888a.getClass();
        IAConfigManager iAConfigManager = IAConfigManager.O;
        this.g = iAConfigManager.o;
        if (!InneractiveAdManager.isCurrentUserAChild()) {
            this.f888a.getClass();
            this.h = com.fyber.inneractive.sdk.util.k.i();
            this.i = this.f888a.a();
            String str = this.f888a.b;
            this.j = str == null ? "" : str.substring(0, Math.min(3, str.length()));
            String str2 = this.f888a.b;
            this.k = str2 != null ? str2.substring(Math.min(3, str2.length())) : "";
            this.f888a.getClass();
            z0 z0VarA = z0.a();
            IAlog.a("ExchangeRequestParamsProvider: getNetwork : type: %s value: %s", z0VarA, z0VarA.b());
            this.q = z0VarA.b();
            int i = com.fyber.inneractive.sdk.config.k.f959a;
            String property = System.getProperty("ia.testEnvironmentConfiguration.device");
            if (TextUtils.isEmpty(property)) {
                com.fyber.inneractive.sdk.config.v vVar = com.fyber.inneractive.sdk.config.u.f982a.b;
                property = vVar != null ? vVar.f984a : null;
            }
            this.A = property;
            this.G = iAConfigManager.j.getZipCode();
        }
        this.E = iAConfigManager.j.getGender();
        this.D = iAConfigManager.j.getAge();
        this.l = com.fyber.inneractive.sdk.serverapi.b.e();
        this.f888a.getClass();
        ArrayList arrayList = iAConfigManager.p;
        if (arrayList != null && !arrayList.isEmpty()) {
            this.p = com.fyber.inneractive.sdk.util.o.a(arrayList);
        }
        this.C = com.fyber.inneractive.sdk.serverapi.b.b();
        this.v = com.fyber.inneractive.sdk.serverapi.b.h().booleanValue();
        this.z = com.fyber.inneractive.sdk.serverapi.b.c().intValue();
        this.F = iAConfigManager.k;
        this.s = com.fyber.inneractive.sdk.serverapi.b.m();
        if (TextUtils.isEmpty(iAConfigManager.n)) {
            this.H = iAConfigManager.l;
        } else {
            this.H = iAConfigManager.l + "_" + iAConfigManager.n;
        }
        this.u = com.fyber.inneractive.sdk.serverapi.b.n();
        iAConfigManager.E.n();
        com.fyber.inneractive.sdk.ignite.l lVar = iAConfigManager.E.p;
        this.I = lVar != null ? lVar.f840a.i() : null;
        com.fyber.inneractive.sdk.ignite.l lVar2 = iAConfigManager.E.p;
        this.J = lVar2 != null ? lVar2.f840a.d() : null;
        this.f888a.getClass();
        this.m = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.e());
        this.f888a.getClass();
        this.n = com.fyber.inneractive.sdk.util.o.c(com.fyber.inneractive.sdk.util.o.d());
        this.L = com.fyber.inneractive.sdk.serverapi.b.j();
        com.fyber.inneractive.sdk.topics.b bVar = iAConfigManager.F;
        if (bVar != null && IAConfigManager.f()) {
            this.N = bVar.f;
            this.M = bVar.e;
        }
    }
}
