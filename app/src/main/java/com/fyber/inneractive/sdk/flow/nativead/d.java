package com.fyber.inneractive.sdk.flow.nativead;

import com.adxcorp.util.ADXLogUtil;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.w0;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends com.fyber.inneractive.sdk.flow.k {
    public final String m = ADXLogUtil.INVENTORY_NATIVE;
    public f n;

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        x xVar = this.c;
        if (xVar != null) {
            ((w0) xVar).destroy();
        }
        f fVar = this.n;
        if (fVar != null) {
            fVar.d.clear();
            fVar.f = null;
            Iterator it = fVar.f1073a.iterator();
            while (it.hasNext()) {
                ((c) it.next()).destroy();
            }
            fVar.f1073a.clear();
            this.n = null;
        }
        this.k.a();
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.f1066a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final String e() {
        return "send_failed_native_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final void h() {
        com.fyber.inneractive.sdk.response.e eVar = this.b;
        if (eVar == null || ((com.fyber.inneractive.sdk.response.nativead.j) eVar).T.N == null) {
            return;
        }
        com.fyber.inneractive.sdk.config.global.r rVar = this.g;
        InneractiveAdRequest inneractiveAdRequest = this.f1066a;
        com.fyber.inneractive.sdk.response.nativead.j jVar = (com.fyber.inneractive.sdk.response.nativead.j) this.b;
        f fVar = new f(rVar, inneractiveAdRequest, jVar, jVar.T.N, this, this.m);
        this.n = fVar;
        com.fyber.inneractive.sdk.flow.nativead.mainasset.d dVarA = com.fyber.inneractive.sdk.flow.nativead.mainasset.e.a(fVar.i, fVar.k, fVar.h, fVar.c, fVar.j, fVar);
        if (dVarA == null) {
            if (fVar.g.compareAndSet(false, true)) {
                InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.NATIVE_AD_FAILED_TO_LOAD, com.fyber.inneractive.sdk.flow.i.NATIVE_AD_EMPTY_CONTENT);
                inneractiveInfrastructureError.setCause(new com.fyber.inneractive.sdk.flow.nativead.mainasset.a("Could not start loading main media"));
                d dVar = fVar.f;
                dVar.getClass();
                com.fyber.inneractive.sdk.util.r.f1668a.execute(new com.fyber.inneractive.sdk.flow.e(new com.fyber.inneractive.sdk.flow.f(dVar.b, dVar.f1066a, "send_failed_native_creatives", dVar.g.b()), inneractiveInfrastructureError));
                dVar.b(inneractiveInfrastructureError);
                return;
            }
            return;
        }
        fVar.f1073a.add(dVarA);
        CopyOnWriteArrayList copyOnWriteArrayList = fVar.f1073a;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = fVar.c.f1621a;
        if (arrayList2 != null && !arrayList2.isEmpty()) {
            for (com.fyber.inneractive.sdk.response.nativead.f fVar2 : fVar.c.f1621a) {
                if (fVar2 != null && fVar2.f1618a != 2 && fVar2.d != null) {
                    arrayList.add(fVar2);
                }
            }
        }
        copyOnWriteArrayList.add(new h(arrayList, fVar.l));
        Iterator it = fVar.f1073a.iterator();
        while (it.hasNext()) {
            ((c) it.next()).b();
        }
    }
}
