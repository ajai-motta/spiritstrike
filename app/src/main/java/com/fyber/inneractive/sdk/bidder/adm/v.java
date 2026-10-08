package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.flow.c0;
import com.fyber.inneractive.sdk.flow.e0;
import com.fyber.inneractive.sdk.flow.h0;
import com.fyber.inneractive.sdk.network.f0;
import com.fyber.inneractive.sdk.network.k1;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class v implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f882a;
    public final /* synthetic */ com.fyber.inneractive.sdk.response.e b;
    public final /* synthetic */ y c;

    public v(y yVar, c0 c0Var, com.fyber.inneractive.sdk.response.e eVar) {
        this.c = yVar;
        this.f882a = c0Var;
        this.b = eVar;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        com.fyber.inneractive.sdk.response.e eVar = (com.fyber.inneractive.sdk.response.e) obj;
        if (eVar == null || exc != null) {
            String message = exc != null ? exc.getMessage() : "empty";
            com.fyber.inneractive.sdk.metrics.i iVarB = com.fyber.inneractive.sdk.metrics.d.d.b(this.c.d);
            iVarB.f1157a.put(new com.fyber.inneractive.sdk.metrics.h(message), Long.valueOf(System.currentTimeMillis() - iVarB.c));
            if (this.f882a != null) {
                Exception exc2 = exc != null ? exc : new Exception("adm markup network result is empty");
                c0 c0Var = this.f882a;
                this.c.getClass();
                c0Var.a(exc2, (exc == null || !(exc.getCause() instanceof com.fyber.inneractive.sdk.response.nativead.a)) ? ((exc instanceof k1) && ((k1) exc).f1204a == 404) ? InneractiveErrorCode.NO_FILL : InneractiveErrorCode.CONNECTION_ERROR : InneractiveErrorCode.NATIVE_AD_FAILED_TO_LOAD, this.b);
                return;
            }
            return;
        }
        com.fyber.inneractive.sdk.metrics.d dVar = com.fyber.inneractive.sdk.metrics.d.d;
        com.fyber.inneractive.sdk.metrics.i iVarB2 = dVar.b(this.c.d);
        iVarB2.f1157a.put(new com.fyber.inneractive.sdk.metrics.h("success"), Long.valueOf(System.currentTimeMillis() - iVarB2.c));
        c0 c0Var2 = this.f882a;
        if (c0Var2 != null) {
            IAlog.a("%s : InneractiveAdSpotImpl data available", h0.a(c0Var2.d));
            h0 h0Var = c0Var2.d;
            com.fyber.inneractive.sdk.config.global.r rVar = c0Var2.b;
            e0 e0Var = h0Var.d;
            if (h0Var.m.get()) {
                IAlog.a("%s: loadAdWithRetries: spot is already destroyed won't continue", IAlog.a(h0Var));
                h0Var.a(h0Var.e);
                return;
            }
            com.fyber.inneractive.sdk.flow.p pVar = h0Var.l;
            if (pVar != null) {
                pVar.b = e0Var;
                dVar.b(h0Var.f1064a).d = System.currentTimeMillis();
                pVar.g = eVar;
                if (!IAConfigManager.e()) {
                    IAConfigManager.addListener(pVar);
                    IAConfigManager.a();
                } else {
                    pVar.c = rVar;
                    com.fyber.inneractive.sdk.network.p pVar2 = new com.fyber.inneractive.sdk.network.p(rVar, eVar, h0Var.f1064a, pVar);
                    pVar.d = pVar2;
                    pVar2.c();
                }
            }
        }
    }
}
