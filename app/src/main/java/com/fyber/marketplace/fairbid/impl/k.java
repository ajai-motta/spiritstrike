package com.fyber.marketplace.fairbid.impl;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.flow.g0;
import com.fyber.inneractive.sdk.flow.i0;
import com.fyber.inneractive.sdk.flow.r0;
import com.fyber.inneractive.sdk.flow.x;
import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public final class k implements i0, r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public InneractiveUnitController f1733a;
    public x b;
    public boolean d = false;
    public final String c = UUID.randomUUID().toString();

    public k(InneractiveUnitController inneractiveUnitController, x xVar) {
        this.f1733a = inneractiveUnitController;
        this.b = xVar;
    }

    @Override // com.fyber.inneractive.sdk.flow.r0
    public final void a(g0 g0Var) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void destroy() {
        InneractiveUnitController inneractiveUnitController = this.f1733a;
        if (inneractiveUnitController != null) {
            inneractiveUnitController.destroy();
        }
        a();
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final x getAdContent() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getLocalUniqueId() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveMediationName getMediationName() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationNameString() {
        return null;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationVersion() {
        return "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getRequestedSpotId() {
        return "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveUnitController getSelectedUnitController() {
        return this.f1733a;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0024  */
    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean isReady() {
        /*
            r13 = this;
            java.lang.String r0 = "Got exception adding param to json object: %s, %s"
            com.fyber.inneractive.sdk.flow.x r1 = r13.b
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            com.fyber.inneractive.sdk.response.e r1 = r1.b()
            r3 = 1
            if (r1 == 0) goto L24
            com.fyber.inneractive.sdk.flow.x r1 = r13.b
            com.fyber.inneractive.sdk.response.e r1 = r1.b()
            r1.getClass()
            long r4 = java.lang.System.currentTimeMillis()
            long r6 = r1.f1611a
            int r1 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r1 >= 0) goto L24
            r1 = r3
            goto L25
        L24:
            r1 = r2
        L25:
            if (r1 == 0) goto Lb9
            com.fyber.inneractive.sdk.flow.x r4 = r13.b
            com.fyber.inneractive.sdk.response.e r5 = r4.b()
            boolean r6 = r13.d
            if (r6 != 0) goto Lb9
            if (r5 == 0) goto Lb9
            long r6 = r5.c
            r8 = 0
            int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r6 == 0) goto Lb9
            long r6 = java.lang.System.currentTimeMillis()
            long r8 = r5.f1611a
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 >= 0) goto Lb9
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r10 = java.lang.System.currentTimeMillis()
            long r8 = r8 - r10
            long r6 = r6.toMinutes(r8)
            long r8 = r5.b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r11 = "Firing Event 802 - AdExpired - time passed- "
            r10.<init>(r11)
            r10.append(r6)
            java.lang.String r11 = ", sessionTimeOut - "
            r10.append(r11)
            r10.append(r8)
            java.lang.String r10 = r10.toString()
            java.lang.Object[] r11 = new java.lang.Object[r2]
            com.fyber.inneractive.sdk.util.IAlog.a(r10, r11)
            com.fyber.inneractive.sdk.network.w r10 = new com.fyber.inneractive.sdk.network.w
            com.fyber.inneractive.sdk.network.t r11 = com.fyber.inneractive.sdk.network.t.IA_AD_EXPIRED
            com.fyber.inneractive.sdk.external.InneractiveAdRequest r12 = r4.f1126a
            com.fyber.inneractive.sdk.config.global.r r4 = r4.c
            org.json.JSONArray r4 = r4.b()
            r10.<init>(r5)
            r10.b = r11
            r10.f1220a = r12
            r10.d = r4
            org.json.JSONObject r4 = new org.json.JSONObject
            r4.<init>()
            java.lang.String r5 = "time_passed"
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r7 = 2
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L92
            goto L9b
        L92:
            java.lang.Object[] r11 = new java.lang.Object[r7]
            r11[r2] = r5
            r11[r3] = r6
            com.fyber.inneractive.sdk.util.IAlog.f(r0, r11)
        L9b:
            java.lang.String r5 = "timeout"
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            r4.put(r5, r6)     // Catch: java.lang.Exception -> La5
            goto Lae
        La5:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r2] = r5
            r7[r3] = r6
            com.fyber.inneractive.sdk.util.IAlog.f(r0, r7)
        Lae:
            org.json.JSONArray r0 = r10.f
            r0.put(r4)
            r0 = 0
            r10.a(r0)
            r13.d = r3
        Lb9:
            r0 = r1 ^ 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.marketplace.fairbid.impl.k.isReady():boolean");
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void loadAd(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationVersion(String str) {
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
    }

    @Override // com.fyber.inneractive.sdk.flow.i0
    public final void a() {
        x xVar = this.b;
        if (xVar != null) {
            xVar.destroy();
        }
        this.b = null;
        this.f1733a = null;
        InneractiveAdSpotManager.get().removeSpot(this);
    }
}
