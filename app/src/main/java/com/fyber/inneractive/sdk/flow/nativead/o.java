package com.fyber.inneractive.sdk.flow.nativead;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class o implements com.fyber.inneractive.sdk.click.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1082a;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g b;
    public final /* synthetic */ p c;

    public o(p pVar, i iVar, com.fyber.inneractive.sdk.util.g gVar) {
        this.c = pVar;
        this.f1082a = iVar;
        this.b = gVar;
    }

    @Override // com.fyber.inneractive.sdk.click.o
    public final void a(com.fyber.inneractive.sdk.click.b bVar) {
        if (bVar.f913a == com.fyber.inneractive.sdk.click.q.FAILED) {
            p pVar = this.c;
            i iVar = this.f1082a;
            String str = bVar.d;
            com.fyber.inneractive.sdk.util.g gVar = this.b;
            pVar.getClass();
            IAlog.f("%s : Trying to resolve fallback Link: %s", p.b, str);
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
