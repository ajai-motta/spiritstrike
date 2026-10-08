package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes3.dex */
public final class p1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s1 f1666a;

    public p1(s1 s1Var) {
        this.f1666a = s1Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s1 s1Var = this.f1666a;
        s1Var.getClass();
        r.f1668a.execute(new r1(s1Var));
    }
}
