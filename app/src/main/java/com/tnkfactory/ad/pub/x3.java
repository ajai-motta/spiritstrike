package com.tnkfactory.ad.pub;

import com.tnkfactory.ad.AdListener;

/* JADX INFO: loaded from: classes6.dex */
public final class x3 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c4 f3220a;

    public x3(c4 c4Var) {
        this.f3220a = c4Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f3220a.a(AdListener.CLOSE_AUTO, false);
    }
}
