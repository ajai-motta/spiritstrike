package com.fyber.inneractive.sdk.flow;

import com.fyber.inneractive.sdk.bidder.adm.AdmParametersOuterClass$AdmParameters;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.network.k1;
import com.fyber.inneractive.sdk.util.IAlog;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.bidder.adm.y f1038a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ String c;
    public final /* synthetic */ h0 d;

    public c0(h0 h0Var, com.fyber.inneractive.sdk.bidder.adm.y yVar, com.fyber.inneractive.sdk.config.global.r rVar, String str) {
        this.d = h0Var;
        this.f1038a = yVar;
        this.b = rVar;
        this.c = str;
    }

    public final void a() {
        com.fyber.inneractive.sdk.config.global.q qVar;
        com.fyber.inneractive.sdk.config.global.b bVar;
        com.fyber.inneractive.sdk.config.global.k kVar;
        com.fyber.inneractive.sdk.config.global.l lVar;
        com.fyber.inneractive.sdk.config.global.q qVar2;
        IAlog.a("%s : InneractiveAdSpotImpl markup data available", h0.a(this.d));
        if (this.d.m.get()) {
            h0 h0Var = this.d;
            p pVar = h0Var.l;
            h0Var.a(h0Var.e);
            return;
        }
        AdmParametersOuterClass$AdmParameters admParametersOuterClass$AdmParameters = this.f1038a.f885a;
        if (admParametersOuterClass$AdmParameters != null) {
            com.fyber.inneractive.sdk.config.global.r rVar = this.b;
            List<AdmParametersOuterClass$AdmParameters.Experiment> abExperimentsList = admParametersOuterClass$AdmParameters.getAbExperimentsList();
            rVar.getClass();
            com.fyber.inneractive.sdk.config.global.a aVar = IAConfigManager.O.z;
            aVar.getClass();
            for (com.fyber.inneractive.sdk.config.global.features.h hVar : rVar.b.values()) {
                if (hVar != null && (lVar = aVar.f942a) != null && (qVar2 = (com.fyber.inneractive.sdk.config.global.q) lVar.f951a.get(hVar.b)) != null) {
                    hVar.f953a = qVar2.f953a;
                }
            }
            if (abExperimentsList == null || abExperimentsList.size() <= 0) {
                return;
            }
            com.fyber.inneractive.sdk.config.global.a aVar2 = IAConfigManager.O.z;
            aVar2.b = rVar;
            for (com.fyber.inneractive.sdk.config.global.features.h hVar2 : rVar.b.values()) {
                for (AdmParametersOuterClass$AdmParameters.Experiment experiment : abExperimentsList) {
                    String identifier = experiment.getIdentifier();
                    String variant = experiment.getVariant();
                    com.fyber.inneractive.sdk.config.global.l lVar2 = aVar2.f942a;
                    if (lVar2 != null && (qVar = (com.fyber.inneractive.sdk.config.global.q) lVar2.f951a.get(hVar2.b)) != null && (bVar = (com.fyber.inneractive.sdk.config.global.b) qVar.c.get(identifier)) != null) {
                        Iterator it = bVar.c.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                kVar = (com.fyber.inneractive.sdk.config.global.k) it.next();
                                if (kVar.b.equals(variant)) {
                                    break;
                                }
                            } else {
                                kVar = null;
                                break;
                            }
                        }
                        hVar2.c.put(bVar.f943a, bVar);
                        if (kVar != null) {
                            hVar2.d.put(bVar.f943a, kVar);
                        }
                    }
                }
            }
        }
    }

    public final void a(Exception exc, InneractiveErrorCode inneractiveErrorCode, com.fyber.inneractive.sdk.response.e... eVarArr) {
        i iVar;
        com.fyber.inneractive.sdk.network.t tVar;
        if (this.d.m.get()) {
            IAlog.a("%s : onResponseDataError: spot is already destroyed won't continue", h0.a(this.d));
            h0 h0Var = this.d;
            p pVar = h0Var.l;
            h0Var.a(h0Var.e);
            return;
        }
        IAlog.a("%s : InneractiveAdSpotImpl data error", h0.a(this.d));
        com.fyber.inneractive.sdk.response.e eVar = eVarArr.length > 0 ? eVarArr[0] : null;
        this.d.getClass();
        if (exc.getCause() instanceof com.fyber.inneractive.sdk.response.nativead.a) {
            iVar = i.NATIVE_AD_PARSING_ERROR;
        } else {
            iVar = i.ADM_FETCH_FAILED;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(inneractiveErrorCode, iVar);
        e0 e0Var = this.d.d;
        if (e0Var != null) {
            e0Var.a(null, eVar, inneractiveInfrastructureError);
        }
        p pVar2 = this.d.l;
        if (pVar2 != null) {
            IAlog.e("%sgot handleFailedLoading! with: %s", pVar2.d(), inneractiveInfrastructureError);
            n nVar = pVar2.b;
            if (nVar != null) {
                ((e0) nVar).a(null, eVar, inneractiveInfrastructureError);
            }
            if (inneractiveInfrastructureError.getFyberMarketplaceAdLoadFailureReason() != i.NATIVE_AD_PARSING_ERROR) {
                pVar2.a(null, eVar);
            }
        }
        h0 h0Var2 = this.d;
        String str = this.c;
        com.fyber.inneractive.sdk.config.global.r rVar = this.b;
        h0Var2.getClass();
        int i = f0.f1062a[inneractiveErrorCode.ordinal()];
        if (i == 1 || i == 2) {
            tVar = com.fyber.inneractive.sdk.network.t.FATAL_ADM_MARKUP_FETCHING_ERROR;
        } else if (i != 3) {
            tVar = com.fyber.inneractive.sdk.network.t.FATAL_ADM_PARSING_ERROR;
        } else {
            tVar = com.fyber.inneractive.sdk.network.t.NATIVE_ERROR_INVALID_NATIVE_RESPONSE;
        }
        if (eVar != null) {
            eVar.D = false;
        }
        String name = exc.getClass().getName();
        if (exc instanceof k1) {
            name = "NetworkStackException";
        }
        JSONArray jSONArrayB = rVar.b();
        com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(eVar);
        wVar.b = tVar;
        wVar.f1220a = null;
        wVar.d = jSONArrayB;
        com.fyber.inneractive.sdk.network.x xVar = new com.fyber.inneractive.sdk.network.x();
        xVar.a(name, "exception").a(exc.getLocalizedMessage() != null ? exc.getLocalizedMessage() : exc, "message");
        InneractiveErrorCode inneractiveErrorCode2 = InneractiveErrorCode.NATIVE_AD_FAILED_TO_LOAD;
        if (inneractiveErrorCode == inneractiveErrorCode2 && exc.getCause() != null && exc.getCause().getCause() != null) {
            xVar.a(exc.getCause().getCause().getMessage(), "reason");
        } else if (inneractiveErrorCode != inneractiveErrorCode2) {
            xVar.a(str, "admPayload");
        }
        wVar.f.put(xVar.f1221a);
        wVar.a((String) null);
    }
}
