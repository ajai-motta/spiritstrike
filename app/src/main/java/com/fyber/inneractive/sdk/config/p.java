package com.fyber.inneractive.sdk.config;

/* JADX INFO: loaded from: classes3.dex */
public final class p implements com.fyber.inneractive.sdk.network.f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f967a;

    public p(s sVar) {
        this.f967a = sVar;
    }

    @Override // com.fyber.inneractive.sdk.network.f0
    public final void a(Object obj, Exception exc, boolean z) {
        o oVar = (o) obj;
        if (oVar != null) {
            s sVar = this.f967a;
            if (oVar.equals(sVar.b)) {
                return;
            }
            sVar.d = true;
            sVar.b = oVar;
            com.fyber.inneractive.sdk.util.r.f1668a.execute(new q(sVar));
        }
    }
}
