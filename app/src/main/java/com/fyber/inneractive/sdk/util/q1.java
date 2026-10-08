package com.fyber.inneractive.sdk.util;

/* JADX INFO: loaded from: classes3.dex */
public final class q1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f1667a;
    public final /* synthetic */ s1 b;

    public q1(s1 s1Var, String str) {
        this.b = s1Var;
        this.f1667a = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.getSharedPreferences("fyber.ua", 0).edit().putString("ua", this.f1667a).apply();
    }
}
