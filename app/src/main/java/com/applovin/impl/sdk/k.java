package com.applovin.impl.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.applovin.impl.a5;
import com.applovin.impl.a7;
import com.applovin.impl.b5;
import com.applovin.impl.c4;
import com.applovin.impl.d2;
import com.applovin.impl.d6;
import com.applovin.impl.e1;
import com.applovin.impl.e6;
import com.applovin.impl.f1;
import com.applovin.impl.g7;
import com.applovin.impl.i8;
import com.applovin.impl.j1;
import com.applovin.impl.j4;
import com.applovin.impl.j5;
import com.applovin.impl.k2;
import com.applovin.impl.k3;
import com.applovin.impl.l3;
import com.applovin.impl.m7;
import com.applovin.impl.m8;
import com.applovin.impl.mediation.MaxSegmentCollectionImpl;
import com.applovin.impl.mediation.MediationServiceImpl;
import com.applovin.impl.n7;
import com.applovin.impl.o2;
import com.applovin.impl.o7;
import com.applovin.impl.p3;
import com.applovin.impl.privacy.cmp.CmpServiceImpl;
import com.applovin.impl.q0;
import com.applovin.impl.r0;
import com.applovin.impl.r1;
import com.applovin.impl.r3;
import com.applovin.impl.r4;
import com.applovin.impl.s6;
import com.applovin.impl.sdk.nativeAd.AppLovinNativeAdService;
import com.applovin.impl.sdk.network.PostbackServiceImpl;
import com.applovin.impl.sdk.utils.CollectionUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.impl.t2;
import com.applovin.impl.u0;
import com.applovin.impl.u3;
import com.applovin.impl.u5;
import com.applovin.impl.v3;
import com.applovin.impl.w3;
import com.applovin.impl.x4;
import com.applovin.impl.y3;
import com.applovin.impl.y4;
import com.applovin.impl.z2;
import com.applovin.impl.z4;
import com.applovin.mediation.MaxAdFormat;
import com.applovin.mediation.MaxSegmentCollection;
import com.applovin.mediation.adapter.MaxAdapter;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkInitializationConfiguration;
import com.applovin.sdk.AppLovinSdkSettings;
import com.applovin.sdk.AppLovinSdkUtils;
import com.facebook.internal.AnalyticsEvents;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class k {
    public static k D0;
    protected static Context E0;
    private static boolean F0;
    private static final boolean H0;
    private static volatile com.applovin.impl.c I0;
    private AppLovinSdk.SdkInitializationListener A0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f637a;
    private String b;
    private WeakReference c;
    private final long d;
    private long e;
    private long f;
    private Long g;
    private long h;
    private final AppLovinSdkSettings j;
    private com.applovin.impl.mediation.e j0;
    private MaxSegmentCollection k;
    private String l;
    private List l0;
    private volatile AppLovinSdk q;
    private boolean q0;
    private String v0;
    private AppLovinSdkInitializationConfiguration w0;
    private AppLovinSdk.SdkInitializationListener z0;
    private static final Object J0 = new Object();
    private static final long G0 = System.currentTimeMillis();
    private final AtomicBoolean i = new AtomicBoolean();
    private final AtomicReference m = new AtomicReference();
    private final AtomicReference n = new AtomicReference();
    private final AtomicReference o = new AtomicReference();
    private final AtomicReference p = new AtomicReference();
    private final o r = new o(this);
    private final com.applovin.impl.f s = new com.applovin.impl.f(this);
    private final z2 t = new z2(this);
    private final r1 u = new r1(this);
    private final m7 v = new m7(this);
    private final AtomicReference w = new AtomicReference();
    private final AtomicReference x = new AtomicReference();
    private final AtomicReference y = new AtomicReference();
    private final AtomicReference z = new AtomicReference();
    private final AtomicReference A = new AtomicReference();
    private final AtomicReference B = new AtomicReference();
    private final AtomicReference C = new AtomicReference();
    private final AtomicReference D = new AtomicReference();
    private final AtomicReference E = new AtomicReference();
    private final AtomicReference F = new AtomicReference();
    private final AtomicReference G = new AtomicReference();
    private final AtomicReference H = new AtomicReference();
    private final AtomicReference I = new AtomicReference();
    private final AtomicReference J = new AtomicReference();
    private final AtomicReference K = new AtomicReference();
    private final AtomicReference L = new AtomicReference();
    private final AtomicReference M = new AtomicReference();
    private final AtomicReference N = new AtomicReference();
    private final AtomicReference O = new AtomicReference();
    private final AtomicReference P = new AtomicReference();
    private final AtomicReference Q = new AtomicReference();
    private final AtomicReference R = new AtomicReference();
    private final AtomicReference S = new AtomicReference();
    private final AtomicReference T = new AtomicReference();
    private final AtomicReference U = new AtomicReference();
    private final AtomicReference V = new AtomicReference();
    private final AtomicReference W = new AtomicReference();
    private final AtomicReference X = new AtomicReference();
    private final AtomicReference Y = new AtomicReference();
    private final AtomicReference Z = new AtomicReference();
    private final AtomicReference a0 = new AtomicReference();
    private final AtomicReference b0 = new AtomicReference();
    private final AtomicReference c0 = new AtomicReference();
    private final AtomicReference d0 = new AtomicReference();
    private final AtomicReference e0 = new AtomicReference();
    private final AtomicReference f0 = new AtomicReference();
    private final AtomicReference g0 = new AtomicReference();
    private final AtomicReference h0 = new AtomicReference();
    private final AtomicReference i0 = new AtomicReference();
    private final AtomicReference k0 = new AtomicReference();
    private final Object m0 = new Object();
    private final AtomicBoolean n0 = new AtomicBoolean(true);
    private final AtomicBoolean o0 = new AtomicBoolean();
    private final AtomicBoolean p0 = new AtomicBoolean();
    private boolean r0 = false;
    private boolean s0 = false;
    private boolean t0 = false;
    private int u0 = 0;
    private final Object x0 = new Object();
    private SdkConfigurationImpl y0 = new SdkConfigurationImpl(this);
    private final j5 B0 = new s6(this, true, "scheduleAdLoadIntegrationError", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda6
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.L0();
        }
    });
    private final j5 C0 = new s6(this, true, "sdkInit", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda7
        @Override // java.lang.Runnable
        public final void run() {
            this.f$0.M0();
        }
    });

    class a implements u5.b {
        a() {
        }

        @Override // com.applovin.impl.u5.b
        public void a(JSONObject jSONObject) {
            boolean zIsValid = JsonUtils.isValid(jSONObject);
            k.this.c(jSONObject);
            if (((Boolean) k.this.a(r3.j8)).booleanValue()) {
                k kVar = k.this;
                kVar.j0 = new com.applovin.impl.mediation.e(kVar);
            }
            k.this.m().a();
            r0.a(jSONObject, zIsValid, k.this);
            Boolean bool = JsonUtils.getBoolean(jSONObject, "smd", Boolean.FALSE);
            k.this.U().a(bool.booleanValue(), JsonUtils.getInt(jSONObject, "smd_delay_sec", 2));
            k.this.D().b();
            k kVar2 = k.this;
            kVar2.l0 = kVar2.a(jSONObject);
            if (zIsValid) {
                k.this.y0.setEnabledAmazonAdUnitIds(CollectionUtils.explode(JsonUtils.getString(jSONObject, "eaaui", "")));
            }
            k.this.t0().a(jSONObject);
            k.this.b(jSONObject);
            t2.b(((Boolean) k.this.a(y4.x6)).booleanValue());
            t2.a(((Boolean) k.this.a(y4.y6)).booleanValue());
            k.this.R0();
            if (!((Boolean) k.this.a(y4.i3)).booleanValue() || zIsValid || !r0.a(k.o())) {
                k.this.P0();
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
            }
            k.this.U0();
        }
    }

    class b implements u0.c {
        b() {
        }

        @Override // com.applovin.impl.u0.c
        public void a(u0.b bVar) {
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Terms and Privacy Policy flow completed with status: " + bVar);
            }
            k.this.p0.set(bVar.b());
            if (!bVar.a()) {
                k.this.c("Initializing SDK in MAX environment...");
                return;
            }
            k.this.O();
            if (o.a()) {
                k.this.O().a("AppLovinSdk", "Re-initializing SDK with the updated privacy settings...");
            }
            k.this.T0();
            k.this.S0();
        }
    }

    class c implements u5.b {
        c() {
        }

        @Override // com.applovin.impl.u5.b
        public void a(JSONObject jSONObject) {
            k.this.c(jSONObject);
            k.this.i.set(false);
            k.this.P0();
        }
    }

    class d implements y3.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ y3 f641a;

        d(y3 y3Var) {
            this.f641a = y3Var;
        }

        @Override // com.applovin.impl.y3.a
        public void a() {
            k.this.O();
            if (o.a()) {
                k.this.O().d("AppLovinSdk", "Connected to internet - re-initializing SDK");
            }
            synchronized (k.this.m0) {
                if (!k.this.q0) {
                    k.this.T0();
                }
            }
            this.f641a.b(this);
        }

        @Override // com.applovin.impl.y3.a
        public void b() {
        }
    }

    static {
        try {
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda2
                @Override // java.lang.Runnable
                public final void run() {
                    o7.c();
                }
            });
            H0 = true;
        } catch (Throwable unused) {
            H0 = false;
        }
    }

    public k(AppLovinSdkSettings appLovinSdkSettings, Context context) {
        this.q0 = false;
        D0 = this;
        this.j = appLovinSdkSettings;
        this.d = System.currentTimeMillis();
        this.q0 = true;
        if (!G0()) {
            throw new RuntimeException("As of version 12.0.0, the AppLovin MAX SDK requires Java 8. For more information visit our docs: https://support.axon.ai/en/max/android/overview/integration");
        }
        E0 = context.getApplicationContext();
        if (context instanceof Activity) {
            this.c = new WeakReference((Activity) context);
        }
    }

    private void B0() {
        Context context = E0;
        o oVarO = O();
        b5 b5VarQ0 = q0();
        u0 u0VarX = x();
        a(context);
        n0();
        j();
        c0();
        S().a(MaxAdapter.InitializationStatus.INITIALIZING);
        NativeCrashReporter.a(this);
        String str = this.f637a;
        if (str == null || str.length() != 86) {
            o.h("AppLovinSdk", "SDK key provided is invalid (" + this.f637a + "). Expected length: 86 characters.\n\nStack trace:\n" + Log.getStackTraceString(new Throwable()));
        }
        if (StringUtils.isValidString(this.b) && this.b.length() != 36) {
            String str2 = "Axon event key length " + this.b + " is invalid - expected 36";
            if (o7.c(this)) {
                throw new IllegalArgumentException(str2);
            }
            o.h("AppLovinSdk", str2);
        }
        if (u0VarX.l()) {
            String str3 = "Terms Flow has been replaced. " + u0VarX.g();
            if (o7.c(this)) {
                throw new IllegalStateException(str3);
            }
            o.h("AppLovinSdk", str3);
        }
        if (o7.i()) {
            o.h("AppLovinSdk", "Failed to find class for name: com.applovin.sdk.AppLovinSdk. Please ensure proguard rules have not been omitted from the build.");
        }
        if (!o7.b(this)) {
            o.h("AppLovinSdk", "Detected non-Android core JSON library. Please double-check that none of your third party libraries include custom implementation of org.json.JSONObject.");
        }
        if (o7.m(context)) {
            this.j.setVerboseLogging(true);
        }
        p0().a(y4.k, Boolean.valueOf(this.j.isVerboseLoggingEnabled()));
        w3.e(this);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        a5 a5Var = a5.c;
        if (TextUtils.isEmpty((String) b5VarQ0.a(a5Var, (Object) null, defaultSharedPreferences))) {
            this.s0 = true;
            b5VarQ0.b(a5Var, Boolean.toString(true), defaultSharedPreferences);
        } else {
            b5VarQ0.b(a5Var, Boolean.toString(false), defaultSharedPreferences);
        }
        a5 a5Var2 = a5.d;
        if (((Boolean) b5VarQ0.a(a5Var2, Boolean.FALSE)).booleanValue()) {
            if (o.a()) {
                oVarO.a("AppLovinSdk", "Initializing SDK for non-maiden launch");
            }
            this.t0 = true;
        } else {
            if (o.a()) {
                oVarO.a("AppLovinSdk", "Initializing SDK for maiden launch");
            }
            b5VarQ0.b(a5Var2, Boolean.TRUE);
            b5VarQ0.b(a5.t, Boolean.valueOf(u0VarX.j()));
        }
        a5 a5Var3 = a5.e;
        this.f = ((Long) b5VarQ0.a(a5Var3, 0L)).longValue() + 1;
        q0().b(a5Var3, Long.valueOf(this.f));
        a5 a5Var4 = a5.f;
        this.g = (Long) b5VarQ0.a(a5Var4, null);
        q0().b(a5Var4, Long.valueOf(G0));
        a5 a5Var5 = a5.g;
        String str4 = (String) b5VarQ0.a(a5Var5, null);
        if (StringUtils.isValidString(str4)) {
            if (AppLovinSdk.VERSION_CODE > o7.g(str4)) {
                b5VarQ0.b(a5Var5, AppLovinSdk.VERSION);
            }
        } else {
            b5VarQ0.b(a5Var5, AppLovinSdk.VERSION);
        }
        w0().d(d2.e, CollectionUtils.map("details", "isInitProviderContextSet=" + F0));
    }

    public static boolean G0() {
        return H0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J0() {
        if (r0().g()) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Timing out adapters init...");
        }
        r0().h();
        b(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void K0() {
        e6 e6VarR0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        e6VarR0.a((j5) new u5(i, this, new c()), e6.b.CORE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void L0() {
        if (H0()) {
            k2.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void M0() {
        synchronized (this.m0) {
            boolean zA = r0.a(o());
            if (!H0()) {
                O();
                if (o.a()) {
                    O().a("AppLovinSdk", "non-MAX mediation detected, mediation provider is: " + V());
                }
            }
            if (!((Boolean) a(y4.j3)).booleanValue() || zA) {
                T0();
            }
            if (((Boolean) a(y4.i3)).booleanValue() && !zA) {
                O();
                if (o.a()) {
                    O().d("AppLovinSdk", "SDK initialized with no internet connection - listening for connection");
                }
                U0();
            }
        }
    }

    private r O0() {
        if (!r4.f(E0)) {
            return null;
        }
        try {
            return new r(this);
        } catch (Throwable th) {
            o.b("AppLovinSdk", "Failed to initialize Privacy Sandbox Service", th);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void P0() {
        Long l = (Long) a(y4.r3);
        if (l.longValue() >= 0 && this.i.compareAndSet(false, true)) {
            i8.a(l.longValue(), false, this, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.K0();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R0() {
        if (!H0()) {
            c("Initializing SDK in non-MAX environment...");
            return;
        }
        if (!this.o0.compareAndSet(false, true)) {
            c("Consent flow is already shown. Initializing SDK in MAX environment...");
        } else if (!x().j()) {
            c("Consent flow is not enabled. Initializing SDK in MAX environment...");
        } else {
            x().a(v0(), new b());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U0() {
        y3 y3VarC0 = c0();
        y3VarC0.a(new d(y3VarC0));
    }

    private Map W() {
        try {
            return JsonUtils.toStringMap(new JSONObject((String) a(y4.n4)));
        } catch (JSONException unused) {
            return Collections.emptyMap();
        }
    }

    public static long n() {
        return G0;
    }

    public static Context o() {
        return E0;
    }

    public l A() {
        Object lVar = this.A.get();
        if (lVar == null) {
            synchronized (this.A) {
                lVar = this.A.get();
                if (lVar == null) {
                    lVar = new l(this);
                    this.A.set(lVar);
                }
            }
        }
        if (lVar == this.A) {
            lVar = null;
        }
        return (l) lVar;
    }

    public boolean A0() {
        return this.t0;
    }

    public j1 B() {
        Object j1Var = this.E.get();
        if (j1Var == null) {
            synchronized (this.E) {
                j1Var = this.E.get();
                if (j1Var == null) {
                    j1Var = new j1(this);
                    this.E.set(j1Var);
                }
            }
        }
        if (j1Var == this.E) {
            j1Var = null;
        }
        return (j1) j1Var;
    }

    public String C() {
        return this.v0;
    }

    public boolean C0() {
        boolean z;
        synchronized (this.m0) {
            z = this.r0;
        }
        return z;
    }

    public r1 D() {
        return this.u;
    }

    public boolean D0() {
        return this.s0;
    }

    public String E() {
        return x0().d();
    }

    public boolean E0() {
        boolean z;
        synchronized (this.x0) {
            z = this.w0 != null;
        }
        return z;
    }

    public EventServiceImpl F() {
        Object eventServiceImpl = this.o.get();
        if (eventServiceImpl == null) {
            synchronized (this.o) {
                eventServiceImpl = this.o.get();
                if (eventServiceImpl == null) {
                    eventServiceImpl = new EventServiceImpl(this);
                    this.o.set(eventServiceImpl);
                }
            }
        }
        if (eventServiceImpl == this.o) {
            eventServiceImpl = null;
        }
        return (EventServiceImpl) eventServiceImpl;
    }

    public boolean F0() {
        boolean z;
        synchronized (this.m0) {
            z = this.q0;
        }
        return z;
    }

    public m G() {
        Object mVar = this.H.get();
        if (mVar == null) {
            synchronized (this.H) {
                mVar = this.H.get();
                if (mVar == null) {
                    mVar = new m(this);
                    this.H.set(mVar);
                }
            }
        }
        if (mVar == this.H) {
            mVar = null;
        }
        return (m) mVar;
    }

    public n H() {
        Object nVar = this.J.get();
        if (nVar == null) {
            synchronized (this.J) {
                nVar = this.J.get();
                if (nVar == null) {
                    nVar = new n(this);
                    this.J.set(nVar);
                }
            }
        }
        if (nVar == this.J) {
            nVar = null;
        }
        return (n) nVar;
    }

    public boolean H0() {
        return StringUtils.containsIgnoreCase(V(), "max");
    }

    public Activity I() {
        WeakReference weakReference;
        if (!((Boolean) a(y4.D4)).booleanValue() || (weakReference = this.c) == null) {
            return null;
        }
        return (Activity) weakReference.get();
    }

    public boolean I0() {
        return o7.a("com.unity3d.player.UnityPlayerActivity");
    }

    public AppLovinSdkInitializationConfiguration J() {
        return this.w0;
    }

    public long K() {
        return this.d;
    }

    public Long L() {
        return this.g;
    }

    public long M() {
        return this.f;
    }

    public o2 N() {
        Object o2Var = this.Y.get();
        if (o2Var == null) {
            synchronized (this.Y) {
                o2Var = this.Y.get();
                if (o2Var == null) {
                    o2Var = new o2(this);
                    this.Y.set(o2Var);
                }
            }
        }
        if (o2Var == this.Y) {
            o2Var = null;
        }
        return (o2) o2Var;
    }

    protected void N0() {
        b(false);
    }

    public o O() {
        return this.r;
    }

    public z2 P() {
        return this.t;
    }

    public com.applovin.impl.mediation.d Q() {
        Object dVar = this.i0.get();
        if (dVar == null) {
            synchronized (this.i0) {
                dVar = this.i0.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.mediation.d(this);
                    this.i0.set(dVar);
                }
            }
        }
        if (dVar == this.i0) {
            dVar = null;
        }
        return (com.applovin.impl.mediation.d) dVar;
    }

    public void Q0() {
        if (StringUtils.isValidString(this.l)) {
            return;
        }
        this.l = "max";
    }

    public com.applovin.impl.mediation.e R() {
        return this.j0;
    }

    public com.applovin.impl.mediation.f S() {
        Object fVar = this.d0.get();
        if (fVar == null) {
            synchronized (this.d0) {
                fVar = this.d0.get();
                if (fVar == null) {
                    fVar = new com.applovin.impl.mediation.f(this);
                    this.d0.set(fVar);
                }
            }
        }
        if (fVar == this.d0) {
            fVar = null;
        }
        return (com.applovin.impl.mediation.f) fVar;
    }

    public void S0() {
        t().a();
    }

    public com.applovin.impl.mediation.g T() {
        Object gVar = this.c0.get();
        if (gVar == null) {
            synchronized (this.c0) {
                gVar = this.c0.get();
                if (gVar == null) {
                    gVar = new com.applovin.impl.mediation.g(this);
                    this.c0.set(gVar);
                }
            }
        }
        if (gVar == this.c0) {
            gVar = null;
        }
        return (com.applovin.impl.mediation.g) gVar;
    }

    public void T0() {
        synchronized (this.m0) {
            this.q0 = true;
            r0().i();
            d();
        }
    }

    public p3 U() {
        Object p3Var = this.g0.get();
        if (p3Var == null) {
            synchronized (this.g0) {
                p3Var = this.g0.get();
                if (p3Var == null) {
                    p3Var = new p3(this);
                    this.g0.set(p3Var);
                }
            }
        }
        if (p3Var == this.g0) {
            p3Var = null;
        }
        return (p3) p3Var;
    }

    public String V() {
        return this.l;
    }

    public void V0() {
        o.h("AppLovinSdk", "Resetting SDK state...");
        p0().a();
        p0().e();
        if (this.n0.compareAndSet(true, false)) {
            T0();
        } else {
            this.n0.set(true);
        }
    }

    public void W0() {
        if (StringUtils.isValidString(this.v0)) {
            return;
        }
        this.v0 = "max";
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Detected mediation provider: MAX");
        }
    }

    public MediationServiceImpl X() {
        Object mediationServiceImpl = this.e0.get();
        if (mediationServiceImpl == null) {
            synchronized (this.e0) {
                mediationServiceImpl = this.e0.get();
                if (mediationServiceImpl == null) {
                    mediationServiceImpl = new MediationServiceImpl(this);
                    this.e0.set(mediationServiceImpl);
                }
            }
        }
        if (mediationServiceImpl == this.e0) {
            mediationServiceImpl = null;
        }
        return (MediationServiceImpl) mediationServiceImpl;
    }

    public void X0() {
        y().n();
    }

    public u3 Y() {
        Object u3Var = this.z.get();
        if (u3Var == null) {
            synchronized (this.z) {
                u3Var = this.z.get();
                if (u3Var == null) {
                    u3Var = new u3(this);
                    this.z.set(u3Var);
                }
            }
        }
        if (u3Var == this.z) {
            u3Var = null;
        }
        return (u3) u3Var;
    }

    public void Y0() {
        a((Map) null);
    }

    public v3 Z() {
        Object v3Var = this.f0.get();
        if (v3Var == null) {
            synchronized (this.f0) {
                v3Var = this.f0.get();
                if (v3Var == null) {
                    v3Var = new v3();
                    this.f0.set(v3Var);
                }
            }
        }
        if (v3Var == this.f0) {
            v3Var = null;
        }
        return (v3) v3Var;
    }

    public void Z0() {
        if ("admob".equalsIgnoreCase(this.l) && ((Boolean) a(y4.R3)).booleanValue()) {
            String str = (String) a(y4.Q3);
            if (TextUtils.isEmpty(str)) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            String str2 = AppLovinSdk.VERSION;
            sb.append(str2);
            sb.append(".");
            if (str.startsWith(sb.toString())) {
                return;
            }
            final String str3 = "Mismatched AdMob adapter (" + str + ") and AppLovin SDK (" + str2 + ") versions detected, which may cause compatibility issues.";
            o.h("AppLovinSdk", str3);
            AppLovinSdkUtils.runOnUiThread(true, new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda8
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.b(str3);
                }
            });
        }
    }

    public p a0() {
        Object pVar = this.h0.get();
        if (pVar == null) {
            synchronized (this.h0) {
                pVar = this.h0.get();
                if (pVar == null) {
                    pVar = new p(this);
                    this.h0.set(pVar);
                }
            }
        }
        if (pVar == this.h0) {
            pVar = null;
        }
        return (p) pVar;
    }

    public AppLovinNativeAdService b0() {
        Object appLovinNativeAdService = this.n.get();
        if (appLovinNativeAdService == null) {
            synchronized (this.n) {
                appLovinNativeAdService = this.n.get();
                if (appLovinNativeAdService == null) {
                    appLovinNativeAdService = new AppLovinNativeAdService(this);
                    this.n.set(appLovinNativeAdService);
                }
            }
        }
        if (appLovinNativeAdService == this.n) {
            appLovinNativeAdService = null;
        }
        return (AppLovinNativeAdService) appLovinNativeAdService;
    }

    public y3 c0() {
        Object y3Var = this.M.get();
        if (y3Var == null) {
            synchronized (this.M) {
                y3Var = this.M.get();
                if (y3Var == null) {
                    y3Var = new y3(o());
                    this.M.set(y3Var);
                }
            }
        }
        if (y3Var == this.M) {
            y3Var = null;
        }
        return (y3) y3Var;
    }

    public c4 d0() {
        Object c4Var = this.X.get();
        if (c4Var == null) {
            synchronized (this.X) {
                c4Var = this.X.get();
                if (c4Var == null) {
                    c4Var = new c4(this);
                    this.X.set(c4Var);
                }
            }
        }
        if (c4Var == this.X) {
            c4Var = null;
        }
        return (c4) c4Var;
    }

    public j4 e0() {
        Object j4Var = this.T.get();
        if (j4Var == null) {
            synchronized (this.T) {
                j4Var = this.T.get();
                if (j4Var == null) {
                    j4Var = new j4(this);
                    this.T.set(j4Var);
                }
            }
        }
        if (j4Var == this.T) {
            j4Var = null;
        }
        return (j4) j4Var;
    }

    public com.applovin.impl.sdk.network.b f0() {
        Object bVar = this.a0.get();
        if (bVar == null) {
            synchronized (this.a0) {
                bVar = this.a0.get();
                if (bVar == null) {
                    bVar = new com.applovin.impl.sdk.network.b(this);
                    this.a0.set(bVar);
                }
            }
        }
        if (bVar == this.a0) {
            bVar = null;
        }
        return (com.applovin.impl.sdk.network.b) bVar;
    }

    public PostbackServiceImpl g0() {
        Object postbackServiceImpl = this.Z.get();
        if (postbackServiceImpl == null) {
            synchronized (this.Z) {
                postbackServiceImpl = this.Z.get();
                if (postbackServiceImpl == null) {
                    postbackServiceImpl = new PostbackServiceImpl(this);
                    this.Z.set(postbackServiceImpl);
                }
            }
        }
        if (postbackServiceImpl == this.Z) {
            postbackServiceImpl = null;
        }
        return (PostbackServiceImpl) postbackServiceImpl;
    }

    public r h0() {
        Object objO0 = this.B.get();
        if (objO0 == null) {
            synchronized (this.B) {
                objO0 = this.B.get();
                if (objO0 == null) {
                    objO0 = O0();
                    if (objO0 == null) {
                        objO0 = this.B;
                    }
                    this.B.set(objO0);
                }
            }
        }
        if (objO0 == this.B) {
            objO0 = null;
        }
        return (r) objO0;
    }

    public e i() {
        Object eVar = this.F.get();
        if (eVar == null) {
            synchronized (this.F) {
                eVar = this.F.get();
                if (eVar == null) {
                    eVar = new e(this);
                    this.F.set(eVar);
                }
            }
        }
        if (eVar == this.F) {
            eVar = null;
        }
        return (e) eVar;
    }

    public String i0() {
        return x0().a();
    }

    public com.applovin.impl.j j() {
        Object jVar = this.b0.get();
        if (jVar == null) {
            synchronized (this.b0) {
                jVar = this.b0.get();
                if (jVar == null) {
                    jVar = new com.applovin.impl.j(this);
                    this.b0.set(jVar);
                }
            }
        }
        if (jVar == this.b0) {
            jVar = null;
        }
        return (com.applovin.impl.j) jVar;
    }

    public String j0() {
        return this.f637a;
    }

    public AppLovinAdServiceImpl k() {
        Object appLovinAdServiceImpl = this.m.get();
        if (appLovinAdServiceImpl == null) {
            synchronized (this.m) {
                appLovinAdServiceImpl = this.m.get();
                if (appLovinAdServiceImpl == null) {
                    appLovinAdServiceImpl = new AppLovinAdServiceImpl(this);
                    this.m.set(appLovinAdServiceImpl);
                }
            }
        }
        if (appLovinAdServiceImpl == this.m) {
            appLovinAdServiceImpl = null;
        }
        return (AppLovinAdServiceImpl) appLovinAdServiceImpl;
    }

    public MaxSegmentCollectionImpl k0() {
        return (MaxSegmentCollectionImpl) this.k;
    }

    public g l() {
        Object gVar = this.K.get();
        if (gVar == null) {
            synchronized (this.K) {
                gVar = this.K.get();
                if (gVar == null) {
                    gVar = new g(this);
                    this.K.set(gVar);
                }
            }
        }
        if (gVar == this.K) {
            gVar = null;
        }
        return (g) gVar;
    }

    public Map l0() {
        MaxSegmentCollectionImpl maxSegmentCollectionImplK0 = k0();
        if (maxSegmentCollectionImplK0 == null) {
            return null;
        }
        return maxSegmentCollectionImplK0.getJsonData();
    }

    public h m() {
        Object hVar = this.W.get();
        if (hVar == null) {
            synchronized (this.W) {
                hVar = this.W.get();
                if (hVar == null) {
                    hVar = new h(this);
                    this.W.set(hVar);
                }
            }
        }
        if (hVar == this.W) {
            hVar = null;
        }
        return (h) hVar;
    }

    public x4 m0() {
        Object x4Var = this.O.get();
        if (x4Var == null) {
            synchronized (this.O) {
                x4Var = this.O.get();
                if (x4Var == null) {
                    x4Var = new x4(this);
                    this.O.set(x4Var);
                }
            }
        }
        if (x4Var == this.O) {
            x4Var = null;
        }
        return (x4) x4Var;
    }

    public SessionTracker n0() {
        Object sessionTracker = this.I.get();
        if (sessionTracker == null) {
            synchronized (this.I) {
                sessionTracker = this.I.get();
                if (sessionTracker == null) {
                    sessionTracker = new SessionTracker(this);
                    this.I.set(sessionTracker);
                }
            }
        }
        if (sessionTracker == this.I) {
            sessionTracker = null;
        }
        return (SessionTracker) sessionTracker;
    }

    public AppLovinSdkSettings o0() {
        return this.j;
    }

    public i p() {
        Object iVar = this.P.get();
        if (iVar == null) {
            synchronized (this.P) {
                iVar = this.P.get();
                if (iVar == null) {
                    iVar = new i(this);
                    this.P.set(iVar);
                }
            }
        }
        if (iVar == this.P) {
            iVar = null;
        }
        return (i) iVar;
    }

    public z4 p0() {
        Object z4Var = this.x.get();
        if (z4Var == null) {
            synchronized (this.x) {
                z4Var = this.x.get();
                if (z4Var == null) {
                    z4Var = new z4(this);
                    this.x.set(z4Var);
                }
            }
        }
        if (z4Var == this.x) {
            z4Var = null;
        }
        return (z4) z4Var;
    }

    public String q() {
        return this.b;
    }

    public b5 q0() {
        Object b5Var = this.C.get();
        if (b5Var == null) {
            synchronized (this.C) {
                b5Var = this.C.get();
                if (b5Var == null) {
                    b5Var = new b5(this);
                    this.C.set(b5Var);
                }
            }
        }
        if (b5Var == this.C) {
            b5Var = null;
        }
        return (b5) b5Var;
    }

    public String r() {
        return x0().b();
    }

    public e6 r0() {
        Object e6Var = this.w.get();
        if (e6Var == null) {
            synchronized (this.w) {
                e6Var = this.w.get();
                if (e6Var == null) {
                    e6Var = new e6(this);
                    this.w.set(e6Var);
                }
            }
        }
        if (e6Var == this.w) {
            e6Var = null;
        }
        return (e6) e6Var;
    }

    public CmpServiceImpl s() {
        Object cmpServiceImpl = this.p.get();
        if (cmpServiceImpl == null) {
            synchronized (this.p) {
                cmpServiceImpl = this.p.get();
                if (cmpServiceImpl == null) {
                    cmpServiceImpl = new CmpServiceImpl(this);
                    this.p.set(cmpServiceImpl);
                }
            }
        }
        if (cmpServiceImpl == this.p) {
            cmpServiceImpl = null;
        }
        return (CmpServiceImpl) cmpServiceImpl;
    }

    public a7 s0() {
        Object a7Var = this.R.get();
        if (a7Var == null) {
            synchronized (this.R) {
                a7Var = this.R.get();
                if (a7Var == null) {
                    a7Var = new a7(this);
                    this.R.set(a7Var);
                }
            }
        }
        if (a7Var == this.R) {
            a7Var = null;
        }
        return (a7) a7Var;
    }

    public j t() {
        Object jVar = this.N.get();
        if (jVar == null) {
            synchronized (this.N) {
                jVar = this.N.get();
                if (jVar == null) {
                    jVar = new j(this);
                    this.N.set(jVar);
                }
            }
        }
        if (jVar == this.N) {
            jVar = null;
        }
        return (j) jVar;
    }

    public g7 t0() {
        Object g7Var = this.k0.get();
        if (g7Var == null) {
            synchronized (this.k0) {
                g7Var = this.k0.get();
                if (g7Var == null) {
                    g7Var = new g7(this);
                    this.k0.set(g7Var);
                }
            }
        }
        if (g7Var == this.k0) {
            g7Var = null;
        }
        return (g7) g7Var;
    }

    public String toString() {
        return "CoreSdk{sdkKey='" + this.f637a + "', enabled=" + this.r0 + ", isFirstSession=" + this.s0 + AbstractJsonLexerKt.END_OBJ;
    }

    public String u() {
        return x0().c();
    }

    public long u0() {
        if (this.h == 0) {
            return -1L;
        }
        return System.currentTimeMillis() - this.h;
    }

    public SdkConfigurationImpl v() {
        return this.y0;
    }

    public Activity v0() {
        Activity activityB = a(o()).b();
        return activityB != null ? activityB : I();
    }

    public q0 w() {
        Object q0Var = this.y.get();
        if (q0Var == null) {
            synchronized (this.y) {
                q0Var = this.y.get();
                if (q0Var == null) {
                    q0Var = new q0(this);
                    this.y.set(q0Var);
                }
            }
        }
        if (q0Var == this.y) {
            q0Var = null;
        }
        return (q0) q0Var;
    }

    public m7 w0() {
        return this.v;
    }

    public u0 x() {
        Object u0Var = this.Q.get();
        if (u0Var == null) {
            synchronized (this.Q) {
                u0Var = this.Q.get();
                if (u0Var == null) {
                    u0Var = new u0(this);
                    this.Q.set(u0Var);
                }
            }
        }
        if (u0Var == this.Q) {
            u0Var = null;
        }
        return (u0) u0Var;
    }

    public n7 x0() {
        Object n7Var = this.D.get();
        if (n7Var == null) {
            synchronized (this.D) {
                n7Var = this.D.get();
                if (n7Var == null) {
                    n7Var = new n7(this);
                    this.D.set(n7Var);
                }
            }
        }
        if (n7Var == this.D) {
            n7Var = null;
        }
        return (n7) n7Var;
    }

    public e1 y() {
        Object e1Var = this.S.get();
        if (e1Var == null) {
            synchronized (this.S) {
                e1Var = this.S.get();
                if (e1Var == null) {
                    e1Var = new e1(this);
                    this.S.set(e1Var);
                }
            }
        }
        if (e1Var == this.S) {
            e1Var = null;
        }
        return (e1) e1Var;
    }

    public m8 y0() {
        Object m8Var = this.L.get();
        if (m8Var == null) {
            synchronized (this.L) {
                m8Var = this.L.get();
                if (m8Var == null) {
                    m8Var = new m8(this);
                    this.L.set(m8Var);
                }
            }
        }
        if (m8Var == this.L) {
            m8Var = null;
        }
        return (m8) m8Var;
    }

    public f1 z() {
        Object f1Var = this.U.get();
        if (f1Var == null) {
            synchronized (this.U) {
                f1Var = this.U.get();
                if (f1Var == null) {
                    f1Var = new f1(this);
                    this.U.set(f1Var);
                }
            }
        }
        if (f1Var == this.U) {
            f1Var = null;
        }
        return (f1) f1Var;
    }

    public AppLovinSdk z0() {
        return this.q;
    }

    private void d() {
        e6 e6VarR0 = r0();
        int i = this.u0 + 1;
        this.u0 = i;
        e6VarR0.a((j5) new u5(i, this, new a()), e6.b.CORE);
    }

    public com.applovin.impl.c e() {
        return a(E0);
    }

    public com.applovin.impl.sdk.a f() {
        Object aVar = this.G.get();
        if (aVar == null) {
            synchronized (this.G) {
                aVar = this.G.get();
                if (aVar == null) {
                    aVar = new com.applovin.impl.sdk.a(this);
                    this.G.set(aVar);
                }
            }
        }
        if (aVar == this.G) {
            aVar = null;
        }
        return (com.applovin.impl.sdk.a) aVar;
    }

    public com.applovin.impl.f g() {
        return this.s;
    }

    public com.applovin.impl.sdk.d h() {
        Object dVar = this.V.get();
        if (dVar == null) {
            synchronized (this.V) {
                dVar = this.V.get();
                if (dVar == null) {
                    dVar = new com.applovin.impl.sdk.d(this);
                    this.V.set(dVar);
                }
            }
        }
        if (dVar == this.V) {
            dVar = null;
        }
        return (com.applovin.impl.sdk.d) dVar;
    }

    public static void b(Context context) {
        if (context == null) {
            return;
        }
        E0 = context.getApplicationContext();
        F0 = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(JSONObject jSONObject) {
        if (JsonUtils.isValid(jSONObject)) {
            this.h = System.currentTimeMillis();
            r0.c(jSONObject, this);
            r0.b(jSONObject, this);
            r0.a(jSONObject, this);
            l3.f(jSONObject, this);
            l3.d(jSONObject, this);
            l3.e(jSONObject, this);
            l3.g(jSONObject, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void a(AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration) {
        B0();
        this.j.attachAppLovinSdk(this);
        String pluginVersion = appLovinSdkInitializationConfiguration.getPluginVersion();
        if (pluginVersion != null) {
            o.g("AppLovinSdk", "Setting plugin version: " + pluginVersion);
            p0().a(y4.Q3, pluginVersion);
        }
        if (appLovinSdkInitializationConfiguration.isExceptionHandlerEnabled() && ((Boolean) a(y4.s)).booleanValue()) {
            AppLovinExceptionHandler.shared().addSdk(this);
            AppLovinExceptionHandler.shared().enable();
        }
        e6 e6VarR0 = r0();
        j5 j5Var = this.B0;
        e6.b bVar = e6.b.CORE;
        e6VarR0.a(j5Var, bVar);
        r0().a(this.C0, bVar);
    }

    public void a(AppLovinSdk appLovinSdk) {
        this.q = appLovinSdk;
    }

    public static String a(String str) {
        return a(str, (List) null);
    }

    public static String a(int i) {
        return a(i, (List) null);
    }

    public static String a(String str, List list) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Context contextO = o();
        return a(contextO.getResources().getIdentifier(str, TypedValues.Custom.S_STRING, contextO.getPackageName()), list);
    }

    public static String a(int i, List list) {
        String string = o().getResources().getString(i);
        return list != null ? String.format(string, list.toArray()) : string;
    }

    public static com.applovin.impl.c a(Context context) {
        if (I0 == null) {
            synchronized (J0) {
                if (I0 == null) {
                    I0 = new com.applovin.impl.c(context);
                }
            }
        }
        return I0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", str);
        }
        r0().a(new d6(this));
    }

    public void c() {
        synchronized (this.m0) {
            if (!this.q0 && !this.r0) {
                T0();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(JSONObject jSONObject) {
        Iterator it = JsonUtils.getList(jSONObject, "error_messages", Collections.emptyList()).iterator();
        while (it.hasNext()) {
            o.h("AppLovinSdk", (String) it.next());
        }
    }

    public void a(final AppLovinSdkInitializationConfiguration appLovinSdkInitializationConfiguration, final AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        synchronized (this.x0) {
            if (this.w0 != null) {
                o.h("AppLovinSdk", "AppLovin SDK already initialized with configuration: " + this.w0 + ". Ignoring the provided initialization configuration.");
                if (!C0() || sdkInitializationListener == null) {
                    return;
                }
                AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f$0.a(sdkInitializationListener);
                    }
                });
                return;
            }
            this.e = System.currentTimeMillis();
            this.w0 = appLovinSdkInitializationConfiguration;
            this.z0 = sdkInitializationListener;
            this.f637a = appLovinSdkInitializationConfiguration.getSdkKey();
            this.b = appLovinSdkInitializationConfiguration.getAxonEventKey();
            this.l = appLovinSdkInitializationConfiguration.getMediationProvider();
            this.k = appLovinSdkInitializationConfiguration.getSegmentCollection();
            o7.a(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.a(appLovinSdkInitializationConfiguration);
                }
            });
        }
    }

    public List c(y4 y4Var) {
        return p0().c(y4Var);
    }

    public void c(a5 a5Var) {
        q0().b(a5Var);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(String str) {
        if (!o7.c(this)) {
            HashMap map = new HashMap();
            map.put("details", "admob");
            map.put(AnalyticsEvents.PARAMETER_SHARE_ERROR_MESSAGE, str);
            D().a(d2.S0, "adapterVersionMismatch", map);
            return;
        }
        throw new IllegalStateException(str);
    }

    protected void b(boolean z) {
        final AppLovinSdk.SdkInitializationListener sdkInitializationListener;
        if (x().i() || (sdkInitializationListener = this.z0) == null) {
            return;
        }
        if (C0()) {
            this.z0 = null;
            this.A0 = null;
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_SUCCESS);
        } else {
            if (this.A0 == sdkInitializationListener) {
                return;
            }
            S().a(MaxAdapter.InitializationStatus.INITIALIZED_FAILURE);
            if (((Boolean) a(y4.p)).booleanValue()) {
                this.z0 = null;
            } else {
                this.A0 = sdkInitializationListener;
            }
        }
        JSONObject jSONObject = new JSONObject();
        JsonUtils.putBoolean(jSONObject, "enabled", C0());
        JsonUtils.putBoolean(jSONObject, "timeout", z);
        JsonUtils.putBoolean(jSONObject, "consent_flow_shown", this.p0.get());
        long jCurrentTimeMillis = System.currentTimeMillis() - this.e;
        HashMap map = new HashMap();
        map.put("duration_ms", String.valueOf(jCurrentTimeMillis));
        map.put("details", jSONObject.toString());
        this.v.d(d2.i, map);
        AppLovinSdkUtils.runOnUiThreadDelayed(new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.b(sdkInitializationListener);
            }
        }, Math.max(0L, ((Long) a(y4.q)).longValue()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List a(JSONObject jSONObject) {
        List listAsList = Arrays.asList(JsonUtils.getString(jSONObject, "eaf", "").split(","));
        ArrayList arrayList = new ArrayList(listAsList.size());
        Iterator it = listAsList.iterator();
        while (it.hasNext()) {
            MaxAdFormat fromString = MaxAdFormat.formatFromString((String) it.next());
            if (fromString != null) {
                arrayList.add(fromString);
            }
        }
        return arrayList;
    }

    public void a(boolean z) {
        synchronized (this.m0) {
            this.q0 = false;
            this.r0 = z;
        }
        if (z) {
            List listA = w3.a(this);
            if (listA.isEmpty()) {
                r0().h();
                N0();
                return;
            }
            Long l = (Long) a(r3.t7);
            s6 s6Var = new s6(this, true, "timeoutInitAdapters", new Runnable() { // from class: com.applovin.impl.sdk.k$$ExternalSyntheticLambda4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.J0();
                }
            });
            O();
            if (o.a()) {
                O().a("AppLovinSdk", "Waiting for required adapters to init: " + listA + " - timing out in " + l + "ms...");
            }
            r0().a(s6Var, e6.b.TIMEOUT, l.longValue(), true);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b(AppLovinSdk.SdkInitializationListener sdkInitializationListener) {
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "Calling back publisher's initialization completion handler...");
        }
        sdkInitializationListener.onSdkInitialized(this.y0);
    }

    public List b(y4 y4Var) {
        return p0().b(y4Var);
    }

    public void b(a5 a5Var, Object obj) {
        q0().b(a5Var, obj);
    }

    public Object b(a5 a5Var) {
        return q0().a(a5Var);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x006b, code lost:
    
        r12 = r4.entrySet().iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0077, code lost:
    
        if (r12.hasNext() == false) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0079, code lost:
    
        r13 = (java.util.Map.Entry) r12.next();
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0089, code lost:
    
        if (r11.startsWith((java.lang.String) r13.getKey()) == false) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x008b, code lost:
    
        r15.v0 = (java.lang.String) r13.getValue();
        O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x009a, code lost:
    
        if (com.applovin.impl.sdk.o.a() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x009c, code lost:
    
        O().a("AppLovinSdk", "Detected mediation provider: " + r15.v0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00b6, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00bb, code lost:
    
        if (r6.booleanValue() == false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00bd, code lost:
    
        r2.add(r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00c0, code lost:
    
        r8 = java.lang.Integer.valueOf(r8.intValue() - 1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String b() {
        /*
            Method dump skipped, instruction units count: 280
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.sdk.k.b():java.lang.String");
    }

    public void a(k3 k3Var) {
        if (r0().g()) {
            return;
        }
        List listA = w3.a(this);
        if (listA.size() <= 0 || !S().a().containsAll(listA)) {
            return;
        }
        O();
        if (o.a()) {
            O().a("AppLovinSdk", "All required adapters initialized");
        }
        r0().h();
        N0();
    }

    public boolean a(MaxAdFormat maxAdFormat) {
        List list = this.l0;
        return (list == null || list.size() <= 0 || this.l0.contains(maxAdFormat)) ? false : true;
    }

    public void a() {
        String str = (String) q0().a(a5.g, null);
        if (StringUtils.isValidString(str)) {
            if (AppLovinSdk.VERSION_CODE < o7.g(str)) {
                o.h("AppLovinSdk", "Current version (" + AppLovinSdk.VERSION + ") is older than earlier installed version (" + str + "), which may cause compatibility issues.");
            }
        }
    }

    public Object a(y4 y4Var) {
        return p0().a(y4Var);
    }

    public boolean a(y4 y4Var, MaxAdFormat maxAdFormat) {
        return b(y4Var).contains(maxAdFormat);
    }

    public void a(Map map) {
        U().a(map);
    }

    public void a(Uri uri) {
        B().a(uri);
    }

    public void a(String str, Object obj, SharedPreferences.Editor editor) {
        q0().a(str, obj, editor);
    }

    public Object a(a5 a5Var) {
        return a(a5Var, (Object) null);
    }

    public Object a(a5 a5Var, Object obj) {
        return q0().a(a5Var, obj);
    }

    public Object a(String str, Object obj, Class cls, SharedPreferences sharedPreferences) {
        return b5.a(str, obj, cls, sharedPreferences);
    }

    public void a(SharedPreferences sharedPreferences) {
        q0().a(sharedPreferences);
    }
}
