package com.applovin.impl;

import android.content.Context;
import android.util.Log;
import com.applovin.impl.e6;
import com.applovin.impl.sdk.utils.StringUtils;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkUtils;
import com.applovin.sdk.R;
import com.facebook.internal.AnalyticsEvents;
import com.iab.omid.library.applovin.Omid;
import com.iab.omid.library.applovin.adsession.Partner;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes2.dex */
public class j4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.applovin.impl.sdk.k f427a;
    private final Context b = com.applovin.impl.sdk.k.o();
    private String c;

    public j4(com.applovin.impl.sdk.k kVar) {
        this.f427a = kVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void f() {
        if (this.c != null) {
            return;
        }
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.b.getResources().openRawResource(R.raw.omsdk_v1_5_3)));
            try {
                try {
                    StringBuilder sb = new StringBuilder();
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line == null) {
                            this.c = sb.toString();
                            bufferedReader.close();
                            return;
                        }
                        sb.append(line);
                    }
                } catch (Throwable th) {
                    try {
                        Log.e("OpenMeasurementService", "Failed to load JavaScript Open Measurement SDK", th);
                        bufferedReader.close();
                    } catch (Throwable th2) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e) {
                            Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e);
                        }
                        throw th2;
                    }
                }
            } catch (IOException e2) {
                Log.e("OpenMeasurementService", "Failed to close the BufferReader for reading JavaScript Open Measurement SDK", e2);
            }
        } catch (Throwable th3) {
            this.f427a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f427a.O().a("OpenMeasurementService", "Failed to retrieve resource omsdk_v1_5_3.js", th3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void g() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        Omid.activate(this.b);
        this.f427a.O();
        if (com.applovin.impl.sdk.o.a()) {
            com.applovin.impl.sdk.o oVarO = this.f427a.O();
            StringBuilder sb = new StringBuilder("Init ");
            sb.append(d() ? AnalyticsEvents.PARAMETER_SHARE_OUTCOME_SUCCEEDED : "failed");
            sb.append(" and took ");
            sb.append(System.currentTimeMillis() - jCurrentTimeMillis);
            sb.append("ms");
            oVarO.a("OpenMeasurementService", sb.toString());
        }
        h();
    }

    private void h() {
        this.f427a.r0().a((j5) new s6(this.f427a, "OpenMeasurementService", new Runnable() { // from class: com.applovin.impl.j4$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.f();
            }
        }), e6.b.OTHER);
    }

    public String a() {
        return this.c;
    }

    public Partner b() {
        return Partner.createPartner((String) this.f427a.a(y4.g0), AppLovinSdk.VERSION);
    }

    public String c() {
        return Omid.getVersion();
    }

    public boolean d() {
        return Omid.isActive();
    }

    public boolean e() {
        String str = this.f427a.o0().getExtraParameters().get("enable_omsdk_testing");
        if (StringUtils.isValidString(str)) {
            return Boolean.parseBoolean(str);
        }
        return false;
    }

    public void i() {
        if (((Boolean) this.f427a.a(y4.f0)).booleanValue()) {
            this.f427a.O();
            if (com.applovin.impl.sdk.o.a()) {
                this.f427a.O().a("OpenMeasurementService", "Initializing Open Measurement SDK v" + c() + "...");
            }
            AppLovinSdkUtils.runOnUiThread(new Runnable() { // from class: com.applovin.impl.j4$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    this.f$0.g();
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String a(java.lang.String r4, java.util.Map r5) {
        /*
            r3 = this;
            boolean r0 = r3.e()     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L17
            com.applovin.impl.sdk.k r0 = r3.f427a     // Catch: java.lang.Throwable -> L1f
            java.lang.String r5 = com.applovin.impl.k4.a(r0, r5)     // Catch: java.lang.Throwable -> L1f
            boolean r0 = com.applovin.impl.sdk.utils.StringUtils.isValidString(r5)     // Catch: java.lang.Throwable -> L1f
            if (r0 == 0) goto L17
            java.lang.String r5 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r5, r4)     // Catch: java.lang.Throwable -> L1f
            goto L18
        L17:
            r5 = r4
        L18:
            java.lang.String r0 = r3.c     // Catch: java.lang.Throwable -> L1f
            java.lang.String r4 = com.iab.omid.library.applovin.ScriptInjector.injectScriptContentIntoHtml(r0, r5)     // Catch: java.lang.Throwable -> L1f
            return r4
        L1f:
            r5 = move-exception
            com.applovin.impl.sdk.k r0 = r3.f427a
            r0.O()
            boolean r0 = com.applovin.impl.sdk.o.a()
            if (r0 == 0) goto L38
            com.applovin.impl.sdk.k r0 = r3.f427a
            com.applovin.impl.sdk.o r0 = r0.O()
            java.lang.String r1 = "OpenMeasurementService"
            java.lang.String r2 = "Failed to inject JavaScript SDK into HTML"
            r0.a(r1, r2, r5)
        L38:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.applovin.impl.j4.a(java.lang.String, java.util.Map):java.lang.String");
    }
}
