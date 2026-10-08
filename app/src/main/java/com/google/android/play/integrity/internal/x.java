package com.google.android.play.integrity.internal;

/* JADX INFO: compiled from: com.google.android.play:integrity@@1.4.0 */
/* JADX INFO: loaded from: classes5.dex */
final class x extends t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f1812a;

    x(ae aeVar) {
        this.f1812a = aeVar;
    }

    @Override // com.google.android.play.integrity.internal.t
    public final void b() {
        synchronized (this.f1812a.g) {
            if (this.f1812a.m.get() > 0 && this.f1812a.m.decrementAndGet() > 0) {
                this.f1812a.c.d("Leaving the connection open for other ongoing calls.", new Object[0]);
                return;
            }
            ae aeVar = this.f1812a;
            if (aeVar.o != null) {
                aeVar.c.d("Unbind from service.", new Object[0]);
                ae aeVar2 = this.f1812a;
                aeVar2.b.unbindService(aeVar2.n);
                this.f1812a.h = false;
                this.f1812a.o = null;
                this.f1812a.n = null;
            }
            this.f1812a.x();
        }
    }
}
