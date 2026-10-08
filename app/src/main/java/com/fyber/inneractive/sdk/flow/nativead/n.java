package com.fyber.inneractive.sdk.flow.nativead;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.v;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1081a;
    public final /* synthetic */ String b;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g c;
    public final /* synthetic */ p d;

    public n(p pVar, i iVar, String str, com.fyber.inneractive.sdk.util.g gVar) {
        this.d = pVar;
        this.f1081a = iVar;
        this.b = str;
        this.c = gVar;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        if (bVar.f913a == com.fyber.inneractive.sdk.click.q.FAILED) {
            p pVar = this.d;
            i iVar = this.f1081a;
            String str = this.b;
            com.fyber.inneractive.sdk.util.g gVar = this.c;
            pVar.getClass();
            IAlog.f("%s : Trying to resolve fallback Link: %s", p.b, str);
            if (v.a(str)) {
                o oVar = new o(pVar, iVar, gVar);
                k kVar = ((j) pVar.f1083a).b;
                if (kVar != null) {
                    kVar.a(str, true, gVar, oVar);
                    return;
                }
                return;
            }
            j jVar = (j) pVar.f1083a;
            i iVar2 = jVar.f1077a;
            if (iVar2 == null || iVar2.equals(iVar)) {
                IAlog.a("%s : No valid link object, origin: %s", j.d, gVar);
                return;
            }
            p pVar2 = jVar.c;
            i iVar3 = jVar.f1077a;
            pVar2.getClass();
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new m(pVar2, iVar3, true, gVar));
        }
    }
}
