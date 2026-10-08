package com.unity3d.player;

/* JADX INFO: loaded from: classes6.dex */
final class c1 implements Y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d1 f3300a;

    c1(d1 d1Var) {
        this.f3300a = d1Var;
    }

    public final void a(int i) {
        this.f3300a.h.e.lock();
        i1 i1Var = this.f3300a.h;
        i1Var.g = i;
        if (i == 3 && i1Var.i) {
            i1Var.runOnUiThread(new b1(this));
        }
        if (i != 0) {
            this.f3300a.h.d.release();
        }
        this.f3300a.h.e.unlock();
    }
}
