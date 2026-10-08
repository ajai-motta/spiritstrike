package com.applovin.impl;

import android.app.Activity;
import androidx.exifinterface.media.ExifInterface;
import com.applovin.impl.e6;
import com.applovin.impl.t4;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.AnalyticsEvents;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class d6 extends j5 {
    private final com.applovin.impl.sdk.k g;

    public d6(com.applovin.impl.sdk.k kVar) {
        super("TaskInitializeSdk", kVar, true);
        this.g = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(boolean z, p2 p2Var, Exception exc) {
        if (exc != null) {
            this.g.D().a("license_validation", exc);
        }
        this.g.r0().a(new t6(this.g, p2Var, exc));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void e() {
        this.g.S().a(this.g.e().b());
    }

    private void f() {
        if (this.g.S().c()) {
            return;
        }
        Activity activityV0 = this.g.v0();
        if (activityV0 != null) {
            this.g.S().a(activityV0);
            return;
        }
        this.g.D().a(d2.C0, this.b + ":maybeInitializeAdapters()");
        this.g.r0().a(new s6(this.g, true, "initializeAdapters", new Runnable() { // from class: com.applovin.impl.d6$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.e();
            }
        }), e6.b.CORE, TimeUnit.SECONDS.toMillis(1L));
    }

    private void g() {
        String str;
        boolean zC = this.g.p0().c();
        Map mapP = this.g.A().p();
        Map mapL = this.g.A().L();
        String strA = zC ? this.g.A().f().a() : "<Enable verbose logging to see the GAID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        if (zC) {
            str = mapP.get("idfv") + " (use this for test devices)";
        } else {
            str = "<Enable verbose logging to see the App Set ID to use for test devices - https://monetization-support.applovin.com/hc/en-us/articles/236114328-How-can-I-expose-verbose-logging-for-the-SDK>";
        }
        v2 v2Var = new v2();
        v2Var.a().a("=====AppLovin SDK=====");
        v2Var.a("===SDK Versions===").a("Version", AppLovinSdk.VERSION).a("Plugin Version", this.g.a(y4.Q3)).a("Ad Review Version", j.b()).a("OM SDK Version", this.g.e0().c());
        v2Var.a("===Device Info===").a(com.moloco.sdk.acm.b.d, o7.d()).a("GAID", strA).a("App Set ID", str).a(ExifInterface.TAG_MODEL, mapP.get(DeviceRequestsHelper.DEVICE_INFO_MODEL)).a("Locale", mapP.get("locale")).a("Emulator", mapP.get("sim")).a("Tablet", mapP.get("is_tablet"));
        v2Var.a("===App Info===").a("Application ID", mapL.get("package_name")).a("Target SDK", mapL.get("target_sdk"));
        v2Var.a("===SDK Settings===").a("SDK Key", this.g.j0()).a("Mediation Provider", this.g.V()).a("TG", n7.a(this.g)).a("MD", this.g.a(y4.t)).a("Test Mode On", Boolean.valueOf(this.g.t0().c())).a("Verbose Logging On", Boolean.valueOf(zC));
        v2Var.a("===Privacy States===\nPlease review AppLovin MAX documentation to be compliant with regional privacy policies.").a(p0.a(a()));
        v2Var.a("===MAX Terms and Privcay Policy Flow===");
        u0 u0VarX = this.g.x();
        boolean zJ = u0VarX.j();
        v2Var.a("Enabled", Boolean.valueOf(zJ));
        if (zJ) {
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography = this.g.v().getConsentFlowUserGeography();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeographyD = u0VarX.d();
            AppLovinSdkConfiguration.ConsentFlowUserGeography consentFlowUserGeography2 = AppLovinSdkConfiguration.ConsentFlowUserGeography.GDPR;
            String str2 = "Other";
            v2Var.a("Consent Flow Geography", consentFlowUserGeography == consentFlowUserGeography2 ? "GDPR" : consentFlowUserGeography == AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER ? "Other" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN);
            if (o7.c(this.g)) {
                if (consentFlowUserGeographyD == consentFlowUserGeography2) {
                    str2 = "GDPR";
                } else if (consentFlowUserGeography != AppLovinSdkConfiguration.ConsentFlowUserGeography.OTHER) {
                    str2 = "None";
                }
                v2Var.a("Debug User Geography", str2);
            }
        }
        v2Var.a("Privacy Policy URI", u0VarX.f()).a("Terms of Service URI", u0VarX.h());
        v2Var.a("===CMP (CONSENT MANAGEMENT PLATFORM)===").a(this.g.s0().i());
        v2Var.a();
        com.applovin.impl.sdk.o.g("AppLovinSdk", v2Var.toString());
    }

    private void h() {
        Long l = (Long) this.g.a(y4.z);
        if (l.longValue() >= 0 && !((Boolean) b5.a(a5.i, Boolean.FALSE, com.applovin.impl.sdk.k.o())).booleanValue()) {
            this.g.N().a(l.longValue()).a(this.g.r0().a("lv_task"), new t4.b() { // from class: com.applovin.impl.d6$$ExternalSyntheticLambda1
                @Override // com.applovin.impl.t4.b
                public final void a(boolean z, Object obj, Object obj2) {
                    this.f$0.a(z, (p2) obj, (Exception) obj2);
                }
            });
        }
    }

    /* JADX WARN: Finally extract failed */
    @Override // java.lang.Runnable
    public void run() {
        com.applovin.impl.sdk.o oVar;
        String str;
        StringBuilder sb;
        String str2 = AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (com.applovin.impl.sdk.o.a()) {
            this.c.a(this.b, "Initializing AppLovin SDK v" + AppLovinSdk.VERSION + "...");
        }
        try {
            this.g.G().b(a());
            this.g.G().e(a());
            this.g.r0().a((j5) new k5(this.g), e6.b.OTHER);
            this.g.A().a0();
            this.g.m0().c();
            this.g.y().l();
            if (o7.c(this.g)) {
                this.g.a();
            }
            this.g.Z0();
            g();
            f();
            this.g.a(true);
            h();
            this.g.f0().b();
            this.g.k().maybeFireAppKilledWhilePlayingAdPostback();
            if (((Boolean) this.g.a(y4.H2)).booleanValue()) {
                this.g.X().maybeFireAppKilledWhilePlayingMediatedAdPostback();
            }
            this.g.F().maybeTrackAppOpenEvent();
            this.g.z().a();
            if (((Boolean) this.g.a(y4.U2)).booleanValue()) {
                this.g.y0().b();
            }
            if (((Boolean) this.g.a(y4.c1)).booleanValue()) {
                this.g.h().b();
            } else {
                this.g.h().g();
            }
            if (this.g.U().g() || (((Boolean) this.g.a(r3.z7)).booleanValue() && o7.c(this.g) && this.g.H0())) {
                this.g.U().e();
            }
            if (this.g.h0() != null) {
                this.g.h0().b((String) this.g.a(y4.u));
            }
            this.g.e0().i();
        } catch (Throwable th) {
            try {
                com.applovin.impl.sdk.o.c("AppLovinSdk", "Failed to initialize SDK!", th);
                this.g.a(false);
                a(th);
                if (((Boolean) this.g.a(y4.i)).booleanValue()) {
                    this.g.f0().a();
                }
                if (((Boolean) this.g.a(y4.h)).booleanValue()) {
                    this.g.V0();
                }
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(y4.u));
                }
                this.g.e0().i();
                if (!com.applovin.impl.sdk.o.a()) {
                    return;
                }
                oVar = this.c;
                str = this.b;
                sb = new StringBuilder();
                sb.append("AppLovin SDK ");
                sb.append(AppLovinSdk.VERSION);
                sb.append(" initialization ");
                if (!this.g.C0()) {
                }
            } catch (Throwable th2) {
                if (this.g.h0() != null) {
                    this.g.h0().b((String) this.g.a(y4.u));
                }
                this.g.e0().i();
                if (com.applovin.impl.sdk.o.a()) {
                    com.applovin.impl.sdk.o oVar2 = this.c;
                    String str3 = this.b;
                    StringBuilder sb2 = new StringBuilder("AppLovin SDK ");
                    sb2.append(AppLovinSdk.VERSION);
                    sb2.append(" initialization ");
                    if (!this.g.C0()) {
                        str2 = "failed";
                    }
                    sb2.append(str2);
                    sb2.append(" in ");
                    sb2.append(System.currentTimeMillis() - jCurrentTimeMillis);
                    sb2.append("ms");
                    oVar2.a(str3, sb2.toString());
                }
                throw th2;
            }
        }
        if (com.applovin.impl.sdk.o.a()) {
            oVar = this.c;
            str = this.b;
            sb = new StringBuilder();
            sb.append("AppLovin SDK ");
            sb.append(AppLovinSdk.VERSION);
            sb.append(" initialization ");
            if (!this.g.C0()) {
                str2 = "failed";
            }
            sb.append(str2);
            sb.append(" in ");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append("ms");
            oVar.a(str, sb.toString());
        }
    }
}
