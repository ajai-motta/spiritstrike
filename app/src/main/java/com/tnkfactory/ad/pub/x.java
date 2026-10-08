package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class x implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f3217a;
    public final /* synthetic */ y b;

    public x(y yVar, c cVar) {
        this.b = yVar;
        this.f3217a = cVar;
    }

    @Override // com.tnkfactory.ad.pub.k0
    public final void a() {
        c cVar = this.f3217a;
        if (cVar.i0 == 1) {
            s0 s0Var = new s0(this.b.f3222a, cVar.e, h1.a("d66d03d8e0"), h1.a("d66a0e95ec42825be17a684c3ffd"), new Object[]{cVar.c, cVar.g}, cVar.p0);
            s0Var.i = null;
            s0Var.start();
        }
    }

    @Override // com.tnkfactory.ad.pub.k0
    public final void b() {
        c cVar = this.f3217a;
        if (cVar.i0 == 2) {
            s0 s0Var = new s0(this.b.f3222a, cVar.e, h1.a("d66d03d8e0"), h1.a("d66a0e95ec42825be17a684c3ffd"), new Object[]{cVar.c, cVar.g}, cVar.p0);
            s0Var.i = null;
            s0Var.start();
        }
        this.f3217a.h0.setPageListener(null);
        this.b.b(this.f3217a);
    }
}
