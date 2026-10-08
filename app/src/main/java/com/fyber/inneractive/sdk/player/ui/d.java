package com.fyber.inneractive.sdk.player.ui;

/* JADX INFO: loaded from: classes3.dex */
public final class d implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1522a;
    public final /* synthetic */ e b;

    public d(e eVar, boolean z) {
        this.b = eVar;
        this.f1522a = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1522a == this.b.hasWindowFocus()) {
            this.b.e();
        }
    }
}
