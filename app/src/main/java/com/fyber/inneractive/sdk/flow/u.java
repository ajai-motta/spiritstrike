package com.fyber.inneractive.sdk.flow;

import android.text.TextUtils;
import com.fyber.inneractive.sdk.config.IAConfigManager;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.external.InneractiveVideoError;
import com.fyber.inneractive.sdk.util.IAlog;
import com.iab.omid.library.fyber.adsession.AdEvents;
import com.iab.omid.library.fyber.adsession.AdSession;
import com.iab.omid.library.fyber.adsession.AdSessionConfiguration;
import com.iab.omid.library.fyber.adsession.AdSessionContext;
import com.iab.omid.library.fyber.adsession.CreativeType;
import com.iab.omid.library.fyber.adsession.ImpressionType;
import com.iab.omid.library.fyber.adsession.Owner;
import com.iab.omid.library.fyber.adsession.Partner;
import com.iab.omid.library.fyber.adsession.media.MediaEvents;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends k implements com.fyber.inneractive.sdk.player.s {
    public com.fyber.inneractive.sdk.player.t m;
    public String n;
    public final t o = new t(this);

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.b
    public final void a() {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        if (this.m != null) {
            com.fyber.inneractive.sdk.response.e eVar = this.b;
            this.m.a((eVar == null || (bVar = ((com.fyber.inneractive.sdk.response.g) eVar).O) == null) ? null : bVar.d.size() == 0 ? new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES, null) : new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_MEDIA_FILE, null), null, true);
        }
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
        super.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final String e() {
        return "send_failed_vast_creatives";
    }

    @Override // com.fyber.inneractive.sdk.flow.k
    public final void h() {
        IAlog.a(IAlog.a(this) + "start called", new Object[0]);
        a(this.g, (com.fyber.inneractive.sdk.response.g) this.b, this.f1066a, this);
    }

    public final com.fyber.inneractive.sdk.player.ui.remote.g j() {
        com.fyber.inneractive.sdk.player.a aVar;
        com.fyber.inneractive.sdk.player.t tVar = this.m;
        if (tVar == null || (aVar = tVar.f) == null) {
            return null;
        }
        com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
        if (nVar.u != null) {
            return nVar.u;
        }
        return null;
    }

    @Override // com.fyber.inneractive.sdk.flow.k, com.fyber.inneractive.sdk.interfaces.c
    public final void cancel() {
        IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(this));
        com.fyber.inneractive.sdk.util.r.b.removeCallbacks(this.l);
        this.k.a();
    }

    public final void a(Exception exc, String str, boolean z) {
        HashMap map = new HashMap();
        map.put("description", str);
        if (exc != null) {
            map.put("exception", exc.getMessage());
        }
        if (j() != null) {
            j().f1534a.a();
        }
        com.fyber.inneractive.sdk.network.events.a.a(com.fyber.inneractive.sdk.network.t.VAST_ERROR_DVC_FAILURE, com.fyber.inneractive.sdk.network.events.b.TEMPLATE_ERROR.name(), this.n, this.f1066a, this.b, map, Boolean.valueOf(z));
    }

    @Override // com.fyber.inneractive.sdk.player.s
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        com.fyber.inneractive.sdk.util.r.f1668a.execute(new e(new f(this.b, this.f1066a, "send_failed_vast_creatives", this.g.b()), inneractiveInfrastructureError));
        b(inneractiveInfrastructureError);
    }

    public final void a(com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.response.g gVar, InneractiveAdRequest inneractiveAdRequest, com.fyber.inneractive.sdk.player.s sVar) {
        com.fyber.inneractive.sdk.model.vast.b bVar;
        AdSessionConfiguration adSessionConfigurationCreateAdSessionConfiguration;
        String str;
        com.fyber.inneractive.sdk.network.t tVar;
        com.fyber.inneractive.sdk.model.vast.b bVar2;
        com.fyber.inneractive.sdk.config.s0 s0VarF = f();
        if (s0VarF == null && gVar != null) {
            s0VarF = com.fyber.inneractive.sdk.config.a.a(gVar.o);
        }
        AdSessionContext adSessionContextCreateNativeAdSessionContext = null;
        com.fyber.inneractive.sdk.model.vast.b bVar3 = gVar == null ? null : gVar.O;
        if (bVar3 != null && bVar3.d.size() < bVar3.i) {
            bVar3.d.clear();
            bVar3.g.clear();
            bVar3.d.addAll(bVar3.k);
            bVar3.g.addAll(bVar3.l);
        }
        t0 t0Var = new t0(s0VarF, rVar, gVar, inneractiveAdRequest);
        this.c = t0Var;
        com.fyber.inneractive.sdk.player.t tVar2 = new com.fyber.inneractive.sdk.player.t(gVar, inneractiveAdRequest, t0Var, sVar);
        this.m = tVar2;
        t0 t0Var2 = (t0) this.c;
        t0Var2.i = tVar2;
        t0Var2.f = this.h;
        this.n = bVar3 != null ? bVar3.n : null;
        tVar2.e = null;
        if (gVar != null && (bVar2 = gVar.O) != null) {
            tVar2.e = (com.fyber.inneractive.sdk.model.vast.r) bVar2.d.poll();
        }
        if (tVar2.e == null) {
            InneractiveVideoError.Error playerError = new InneractiveVideoError(InneractiveVideoError.Error.ERROR_FAILED_PLAYING_ALL_MEDIA_FILES).getPlayerError();
            int i = com.fyber.inneractive.sdk.player.r.f1518a[playerError.ordinal()];
            if (i == 1) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_NO_MEDIA_FILES;
            } else if (i == 2) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_MEDIA_FILE;
            } else if (i == 3) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_FAILED_PLAYING_ALL_MEDIA_FILES;
            } else if (i == 4) {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_PRE_BUFFER_TIMEOUT;
            } else if (i != 5) {
                IAlog.a("IAReportError, Does not know player error " + playerError.getErrorString(), new Object[0]);
                tVar = com.fyber.inneractive.sdk.network.t.VAST_UNKNOWN_PLAYER_ERROR;
            } else {
                tVar = com.fyber.inneractive.sdk.network.t.VAST_ERROR_BUFFER_TIMEOUT;
            }
            InneractiveAdRequest inneractiveAdRequest2 = tVar2.b;
            com.fyber.inneractive.sdk.response.g gVar2 = tVar2.c;
            JSONArray jSONArrayB = tVar2.h.b();
            com.fyber.inneractive.sdk.network.w wVar = new com.fyber.inneractive.sdk.network.w(gVar2);
            wVar.b = tVar;
            wVar.f1220a = inneractiveAdRequest2;
            wVar.d = jSONArrayB;
            wVar.a((String) null);
            sVar.a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.VAST_NO_MEDIA_FILES));
        } else {
            try {
                tVar2.f = tVar2.f1519a.a();
            } catch (Throwable th) {
                tVar2.d.a(new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.COULD_NOT_CREATE_FLOW_MANAGER, th));
            }
            com.fyber.inneractive.sdk.player.a aVar = tVar2.f;
            if (aVar != null) {
                com.fyber.inneractive.sdk.player.n nVar = (com.fyber.inneractive.sdk.player.n) aVar;
                com.fyber.inneractive.sdk.measurement.e eVar = nVar.d;
                if (eVar != null) {
                    com.fyber.inneractive.sdk.measurement.f fVar = new com.fyber.inneractive.sdk.measurement.f();
                    ArrayList arrayList = nVar.p.e;
                    t0 t0Var3 = nVar.b;
                    try {
                        try {
                            CreativeType creativeType = CreativeType.VIDEO;
                            ImpressionType impressionType = ImpressionType.UNSPECIFIED;
                            Owner owner = Owner.NATIVE;
                            adSessionConfigurationCreateAdSessionConfiguration = AdSessionConfiguration.createAdSessionConfiguration(creativeType, impressionType, owner, owner, false);
                        } catch (Throwable th2) {
                            fVar.a(th2);
                            adSessionConfigurationCreateAdSessionConfiguration = null;
                        }
                        ArrayList arrayListA = fVar.a(arrayList);
                        Partner partner = eVar.e;
                        if (partner != null && (str = eVar.b) != null) {
                            try {
                                adSessionContextCreateNativeAdSessionContext = AdSessionContext.createNativeAdSessionContext(partner, str, arrayListA, "", "");
                            } catch (Throwable th3) {
                                fVar.a(th3);
                            }
                        }
                        AdSession adSessionCreateAdSession = AdSession.createAdSession(adSessionConfigurationCreateAdSessionConfiguration, adSessionContextCreateNativeAdSessionContext);
                        fVar.f1147a = adSessionCreateAdSession;
                        fVar.b = AdEvents.createAdEvents(adSessionCreateAdSession);
                        fVar.c = MediaEvents.createMediaEvents(fVar.f1147a);
                        fVar.f1147a.start();
                        fVar.f = t0Var3;
                    } catch (Throwable th4) {
                        fVar.a(th4);
                    }
                    nVar.e = fVar;
                    nVar.f = new com.fyber.inneractive.sdk.player.p(fVar);
                }
                if (nVar.e == null && (bVar = nVar.p) != null) {
                    for (com.fyber.inneractive.sdk.measurement.h hVar : bVar.e) {
                        com.fyber.inneractive.sdk.measurement.i iVar = com.fyber.inneractive.sdk.measurement.i.ERROR_DURING_RESOURCE_LOAD;
                        com.fyber.inneractive.sdk.model.vast.x xVar = com.fyber.inneractive.sdk.model.vast.x.EVENT_VERIFICATION_NOT_EXECUTED;
                        com.fyber.inneractive.sdk.player.n.a(new com.fyber.inneractive.sdk.measurement.g(hVar.a(xVar), iVar), xVar);
                    }
                }
            }
            tVar2.a();
        }
        if (TextUtils.isEmpty(this.n)) {
            return;
        }
        IAConfigManager.O.s.a(new com.fyber.inneractive.sdk.network.v0(this.o, com.fyber.inneractive.sdk.util.o.f1662a, new com.fyber.inneractive.sdk.cache.l(this.n)));
    }
}
