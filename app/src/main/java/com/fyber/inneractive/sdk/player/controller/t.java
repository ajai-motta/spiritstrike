package com.fyber.inneractive.sdk.player.controller;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f1253a;

    public t(z zVar) {
        this.f1253a = zVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        z zVar = this.f1253a;
        zVar.j = null;
        zVar.r();
    }
}
