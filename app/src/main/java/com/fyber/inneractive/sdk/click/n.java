package com.fyber.inneractive.sdk.click;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f923a;
    public final /* synthetic */ r b;

    public n(r rVar, b bVar) {
        this.b = rVar;
        this.f923a = bVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        o oVar = this.b.d;
        if (oVar != null) {
            oVar.a(this.f923a);
        }
    }
}
