package com.tnkfactory.ad.pub;

import android.os.Handler;

/* JADX INFO: loaded from: classes6.dex */
public final class i0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f3139a;

    public i0(l0 l0Var) {
        this.f3139a = l0Var;
    }

    public final void a() {
        l0 l0Var = this.f3139a;
        Handler handler = l0Var.f3151a;
        if (handler != null) {
            l0Var.f3151a.sendMessage(handler.obtainMessage(1, l0Var.getPageIndex(), 0));
        }
    }
}
