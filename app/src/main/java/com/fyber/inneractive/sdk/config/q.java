package com.fyber.inneractive.sdk.config;

import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ s f968a;

    public q(s sVar) {
        this.f968a = sVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        s sVar = this.f968a;
        Iterator it = sVar.c.iterator();
        while (it.hasNext()) {
            ((r) it.next()).onGlobalConfigChanged(sVar, sVar.b);
        }
    }
}
