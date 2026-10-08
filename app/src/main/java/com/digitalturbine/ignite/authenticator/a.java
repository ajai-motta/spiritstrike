package com.digitalturbine.ignite.authenticator;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IgniteManager f841a;

    public a(IgniteManager igniteManager) {
        this.f841a = igniteManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f841a.f840a.b();
    }
}
