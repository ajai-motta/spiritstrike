package com.fyber.inneractive.sdk.network;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1193a;
    public final /* synthetic */ long b;
    public final /* synthetic */ f c;

    public c(f fVar, int i, long j) {
        this.c = fVar;
        this.f1193a = i;
        this.b = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.d.sendEmptyMessageDelayed(this.f1193a, this.b);
    }
}
