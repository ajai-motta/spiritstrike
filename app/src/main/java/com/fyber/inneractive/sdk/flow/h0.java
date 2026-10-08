package com.fyber.inneractive.sdk.flow;

import android.app.Application;
import android.os.Looper;
import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveAdSpot;
import com.fyber.inneractive.sdk.external.InneractiveAdSpotManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveFullscreenUnitController;
import com.fyber.inneractive.sdk.external.InneractiveMediationName;
import com.fyber.inneractive.sdk.external.InneractiveUnitController;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class h0 implements i0, r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f1064a;
    public InneractiveAdSpot.RequestListener b;
    public InneractiveAdRequest c;
    public e0 d;
    public x e;
    public s0 f;
    public final HashSet g;
    public m h;
    public g0 i;
    public p l;
    public boolean j = true;
    public boolean k = false;
    public final AtomicBoolean m = new AtomicBoolean(false);
    public final Object n = new Object();

    public h0() {
        String string = UUID.randomUUID().toString();
        this.f1064a = string;
        this.g = new HashSet();
        IAlog.a("%sInneractiveAdSpotImpl created with UID: %s", IAlog.a(this), string);
    }

    public static String a(h0 h0Var) {
        h0Var.getClass();
        return IAlog.a(h0Var);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void addUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            s0 s0Var = (s0) inneractiveUnitController;
            s0Var.setAdSpot(this);
            if (this.g.size() > 0) {
                for (InneractiveUnitController inneractiveUnitController2 : new HashSet(this.g)) {
                    if (inneractiveUnitController2.getClass().equals(inneractiveUnitController.getClass())) {
                        removeUnitController(inneractiveUnitController2);
                    }
                }
            }
            this.g.add(s0Var);
            if (this.e != null) {
                for (s0 s0Var2 : this.g) {
                    if (s0Var2.supports(this)) {
                        this.f = s0Var2;
                        return;
                    }
                }
            }
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final x getAdContent() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveAdRequest getCurrentProcessedRequest() {
        return this.c;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getLocalUniqueId() {
        return this.f1064a;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveMediationName getMediationName() {
        return IAConfigManager.O.m;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationNameString() {
        return IAConfigManager.O.l;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getMediationVersion() {
        return IAConfigManager.O.n;
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final String getRequestedSpotId() {
        InneractiveAdRequest inneractiveAdRequest = this.c;
        return inneractiveAdRequest != null ? inneractiveAdRequest.getSpotId() : "";
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final InneractiveUnitController getSelectedUnitController() {
        return this.f;
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
            com.fyber.inneractive.sdk.flow.x r1 = r13.e
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            com.fyber.inneractive.sdk.response.e r1 = r1.b()
            r3 = 1
            if (r1 == 0) goto L24
            com.fyber.inneractive.sdk.flow.x r1 = r13.e
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
            if (r1 == 0) goto Lac
            com.fyber.inneractive.sdk.flow.x r4 = r13.e
            if (r4 == 0) goto Lac
            com.fyber.inneractive.sdk.response.e r5 = r4.b()
            boolean r6 = r13.k
            if (r6 != 0) goto Lac
            if (r5 == 0) goto Lac
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r7 = java.lang.System.currentTimeMillis()
            long r9 = r5.c
            long r7 = r7 - r9
            long r6 = r6.toMinutes(r7)
            long r8 = r5.b
            long r6 = r6 - r8
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
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L85
            goto L8e
        L85:
            java.lang.Object[] r11 = new java.lang.Object[r7]
            r11[r2] = r5
            r11[r3] = r6
            com.fyber.inneractive.sdk.util.IAlog.f(r0, r11)
        L8e:
            java.lang.String r5 = "timeout"
            java.lang.Long r6 = java.lang.Long.valueOf(r8)
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L98
            goto La1
        L98:
            java.lang.Object[] r7 = new java.lang.Object[r7]
            r7[r2] = r5
            r7[r3] = r6
            com.fyber.inneractive.sdk.util.IAlog.f(r0, r7)
        La1:
            org.json.JSONArray r0 = r10.f
            r0.put(r4)
            r0 = 0
            r10.a(r0)
            r13.k = r3
        Lac:
            if (r1 != 0) goto Lb7
            com.fyber.inneractive.sdk.flow.x r0 = r13.e
            boolean r0 = r0.e()
            if (r0 == 0) goto Lb7
            r2 = r3
        Lb7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.h0.isReady():boolean");
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void loadAd(String str) {
        if (this.m.get()) {
            IAlog.a("%s : loadAd: spot is already destroyed", IAlog.a(this));
            a(this.e);
            return;
        }
        IAlog.a("%s : InneractiveAdSpotImpl Start load ad process", IAlog.a(this));
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        if (str == null || TextUtils.isEmpty(str)) {
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d.d.a(this.f1064a).c();
        String str2 = this.f1064a;
        this.l = new p(str2);
        if (this.d == null) {
            this.d = new e0(this);
        }
        com.fyber.inneractive.sdk.bidder.adm.y yVar = new com.fyber.inneractive.sdk.bidder.adm.y(str, str2);
        com.fyber.inneractive.sdk.config.global.r rVarA = com.fyber.inneractive.sdk.config.global.r.a();
        c0 c0Var = new c0(this, yVar, rVarA, str);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1146a) {
            Application application = com.fyber.inneractive.sdk.util.o.f1662a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.config.a0(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.bidder.adm.t(yVar, c0Var, rVarA));
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void removeUnitController(InneractiveUnitController inneractiveUnitController) {
        if (inneractiveUnitController != null) {
            s0 s0Var = this.f;
            if (s0Var != null && s0Var.equals(inneractiveUnitController)) {
                this.f.destroy();
                this.f = null;
            }
            this.g.remove(inneractiveUnitController);
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void requestAd(InneractiveAdRequest inneractiveAdRequest) {
        if (IAConfigManager.d()) {
            IAlog.a("%sIAB TCF purpose 1 disabled, dropping request", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener = this.b;
            if (requestListener != null) {
                requestListener.onInneractiveFailedAdRequest(this, InneractiveErrorCode.IAB_TCF_PURPOSE_1_DISABLED);
                return;
            }
            return;
        }
        IAlog.a("%srequestAd called with request: %s", IAlog.a(this), inneractiveAdRequest);
        if (inneractiveAdRequest == null && this.c == null) {
            IAlog.b("%srequestAd called with a null request, but no previous request is available! Cannot continue", IAlog.a(this));
            InneractiveAdSpot.RequestListener requestListener2 = this.b;
            if (requestListener2 != null) {
                requestListener2.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        if (!InneractiveAdManager.wasInitialized()) {
            InneractiveAdSpot.RequestListener requestListener3 = this.b;
            if (requestListener3 != null) {
                requestListener3.onInneractiveFailedAdRequest(this, InneractiveErrorCode.SDK_NOT_INITIALIZED);
                return;
            }
            return;
        }
        InneractiveAdRequest inneractiveAdRequest2 = inneractiveAdRequest != null ? inneractiveAdRequest : this.c;
        String str = this.f1064a;
        inneractiveAdRequest2.b = str;
        com.fyber.inneractive.sdk.metrics.d.d.a(str).c();
        if (this.g.isEmpty()) {
            IAlog.b("%srequestAd called but no AdUnitControllers exist! Cannot continue", IAlog.a(this));
            if (this.b != null) {
                if (inneractiveAdRequest == null) {
                    inneractiveAdRequest = this.c;
                }
                a(inneractiveAdRequest, null);
                this.b.onInneractiveFailedAdRequest(this, InneractiveErrorCode.INVALID_INPUT);
                return;
            }
            return;
        }
        IAConfigManager.b();
        m mVar = this.h;
        if (mVar != null) {
            boolean z = inneractiveAdRequest != null || this.c == null;
            l lVar = mVar.g;
            if (lVar != null) {
                IAConfigManager.removeListener(lVar);
            }
            com.fyber.inneractive.sdk.network.m mVar2 = mVar.d;
            if (mVar2 != null) {
                mVar2.a();
                mVar.d = null;
            }
            mVar.a(z);
            mVar.b = null;
        }
        if (inneractiveAdRequest != null) {
            InneractiveAdRequest inneractiveAdRequest3 = this.c;
            if (inneractiveAdRequest3 != null) {
                inneractiveAdRequest.setSelectedUnitConfig(inneractiveAdRequest3.getSelectedUnitConfig());
            }
            this.c = inneractiveAdRequest;
            x xVar = this.e;
            if (xVar != null) {
                xVar.destroy();
                this.j = true;
            }
            Iterator it = this.g.iterator();
            while (true) {
                if (!it.hasNext()) {
                    this.c.f1119a = false;
                    break;
                } else if (((s0) it.next()) instanceof InneractiveFullscreenUnitController) {
                    break;
                }
            }
        }
        this.h = new m(this.f1064a);
        if (this.d == null) {
            this.d = new e0(this);
        }
        IAlog.a("%sFound ad source for request! %s", IAlog.a(this), this.h);
        IAlog.a("%s initOmidSdkIfNeeded", IAlog.a(this));
        IAConfigManager iAConfigManager = IAConfigManager.O;
        com.fyber.inneractive.sdk.measurement.e eVar = iAConfigManager.K;
        if (eVar == null || !eVar.f1146a) {
            Application application = com.fyber.inneractive.sdk.util.o.f1662a;
            IAlog.c("initOmidSdk", new Object[0]);
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.config.a0(iAConfigManager, application));
        }
        iAConfigManager.H.a();
        m mVar3 = this.h;
        if (mVar3 != null) {
            InneractiveAdRequest inneractiveAdRequest4 = this.c;
            mVar3.b = this.d;
            if (IAConfigManager.e()) {
                mVar3.c(inneractiveAdRequest4);
                return;
            }
            l lVar2 = new l(mVar3, inneractiveAdRequest4);
            mVar3.g = lVar2;
            IAConfigManager.addListener(lVar2);
            IAConfigManager.a();
        }
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(InneractiveMediationName inneractiveMediationName) {
        InneractiveAdManager.setMediationName(inneractiveMediationName);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationVersion(String str) {
        InneractiveAdManager.setMediationVersion(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void destroy() {
        IAlog.a("%sInneractiveAdSpotImpl spot destroy: %s", IAlog.a(this), this.f1064a);
        if (Looper.myLooper() == null || Looper.getMainLooper() != Looper.myLooper()) {
            com.fyber.inneractive.sdk.util.r.b.post(new d0(this));
            return;
        }
        this.m.set(true);
        Iterator it = this.g.iterator();
        while (it.hasNext()) {
            ((InneractiveUnitController) it.next()).destroy();
        }
        this.g.clear();
        a((x) null);
        this.b = null;
        a();
        InneractiveAdSpotManager.get().removeSpot(this);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setMediationName(String str) {
        InneractiveAdManager.setMediationName(str);
    }

    @Override // com.fyber.inneractive.sdk.external.InneractiveAdSpot
    public final void setRequestListener(InneractiveAdSpot.RequestListener requestListener) {
        IAlog.a("%ssetRequestListener called with: %s", IAlog.a(this), requestListener);
        this.b = requestListener;
    }

    @Override // com.fyber.inneractive.sdk.flow.r0
    public final void a(g0 g0Var) {
        this.i = g0Var;
        requestAd(null);
    }

    @Override // com.fyber.inneractive.sdk.flow.i0
    public final void a() {
        x xVar;
        JSONArray jSONArrayB;
        com.fyber.inneractive.sdk.config.global.r rVar;
        x xVar2 = this.e;
        if (xVar2 != null) {
            if (xVar2.c() && (xVar = this.e) != null && !xVar.e) {
                String string = Arrays.toString(Thread.currentThread().getStackTrace());
                IAlog.a("Firing Event 803 - Stack trace - %s", string);
                com.fyber.inneractive.sdk.network.t tVar = com.fyber.inneractive.sdk.network.t.IA_AD_DESTROYED_WITHOUT_SHOW;
                x xVar3 = this.e;
                InneractiveAdRequest inneractiveAdRequest = xVar3.f1126a;
                com.fyber.inneractive.sdk.response.e eVarB = xVar3.b();
                m mVar = this.h;
                p pVar = this.l;
                com.fyber.inneractive.sdk.config.global.r rVar2 = pVar != null ? pVar.c : null;
                if (mVar != null && (rVar = mVar.c) != null) {
                    jSONArrayB = rVar.b();
                } else {
                    jSONArrayB = rVar2 != null ? rVar2.b() : null;
                }
                com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVarB);
                wVar.b = tVar;
                wVar.f1220a = inneractiveAdRequest;
                wVar.d = jSONArrayB;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("stack_trace", string);
                } catch (Exception unused) {
                    IAlog.f("Got exception adding param to json object: %s, %s", "stack_trace", string);
                }
                wVar.f.put(jSONObject);
                wVar.a((String) null);
            }
            this.e.destroy();
            this.e = null;
        }
        this.f = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(com.fyber.inneractive.sdk.external.InneractiveAdRequest r10, com.fyber.inneractive.sdk.response.e r11) {
        /*
            r9 = this;
            r0 = 0
            if (r10 == 0) goto L33
            com.fyber.inneractive.sdk.config.s0 r1 = r10.getSelectedUnitConfig()
            if (r1 == 0) goto L33
            com.fyber.inneractive.sdk.config.s0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.r0 r1 = (com.fyber.inneractive.sdk.config.r0) r1
            com.fyber.inneractive.sdk.config.l0 r1 = r1.c
            if (r1 == 0) goto L1e
            com.fyber.inneractive.sdk.config.s0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.r0 r1 = (com.fyber.inneractive.sdk.config.r0) r1
            com.fyber.inneractive.sdk.config.l0 r1 = r1.c
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r1.b
            goto L34
        L1e:
            com.fyber.inneractive.sdk.config.s0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.r0 r1 = (com.fyber.inneractive.sdk.config.r0) r1
            com.fyber.inneractive.sdk.config.t0 r1 = r1.f
            if (r1 == 0) goto L33
            com.fyber.inneractive.sdk.config.s0 r1 = r10.getSelectedUnitConfig()
            com.fyber.inneractive.sdk.config.r0 r1 = (com.fyber.inneractive.sdk.config.r0) r1
            com.fyber.inneractive.sdk.config.t0 r1 = r1.f
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r1.j
            goto L34
        L33:
            r1 = r0
        L34:
            com.fyber.inneractive.sdk.flow.x r2 = r9.e
            if (r2 == 0) goto L3e
            com.fyber.inneractive.sdk.response.e r2 = r2.b
            if (r2 == 0) goto L3e
            r4 = r2
            goto L3f
        L3e:
            r4 = r11
        L3f:
            java.lang.String r6 = r9.f1064a
            if (r1 != 0) goto L47
            if (r4 == 0) goto L47
            com.fyber.inneractive.sdk.config.enums.UnitDisplayType r1 = r4.p
        L47:
            r7 = r1
            com.fyber.inneractive.sdk.metrics.c r11 = new com.fyber.inneractive.sdk.metrics.c
            com.fyber.inneractive.sdk.flow.x r1 = r9.e
            if (r1 != 0) goto L4f
            goto L55
        L4f:
            com.fyber.inneractive.sdk.config.global.r r0 = r1.c
            org.json.JSONArray r0 = r0.b()
        L55:
            r8 = r0
            r3 = r11
            r5 = r10
            r3.<init>(r4, r5, r6, r7, r8)
            r11.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.flow.h0.a(com.fyber.inneractive.sdk.external.InneractiveAdRequest, com.fyber.inneractive.sdk.response.e):void");
    }

    public final void a(x xVar) {
        synchronized (this.n) {
            p pVar = this.l;
            if (pVar != null) {
                pVar.a(true);
                pVar.b = null;
                this.l = null;
            }
            m mVar = this.h;
            if (mVar != null) {
                l lVar = mVar.g;
                if (lVar != null) {
                    IAConfigManager.removeListener(lVar);
                }
                com.fyber.inneractive.sdk.network.m mVar2 = mVar.d;
                if (mVar2 != null) {
                    mVar2.a();
                    mVar.d = null;
                }
                mVar.a(true);
                mVar.b = null;
                this.h = null;
            }
            if (xVar != null) {
                xVar.destroy();
            }
        }
    }
}
