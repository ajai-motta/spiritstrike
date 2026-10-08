package com.tnkfactory.ad.pub;

/* JADX INFO: loaded from: classes6.dex */
public final class w5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f3216a;
    public final /* synthetic */ a6 b;

    public w5(a6 a6Var, String str) {
        this.b = a6Var;
        this.f3216a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.f3108a.loadUrl("javascript:" + this.f3216a);
    }
}
