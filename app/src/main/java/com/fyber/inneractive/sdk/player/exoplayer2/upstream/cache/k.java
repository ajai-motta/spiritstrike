package com.fyber.inneractive.sdk.player.exoplayer2.upstream.cache;

import android.os.ConditionVariable;

/* JADX INFO: loaded from: classes3.dex */
public final class k extends Thread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ConditionVariable f1443a;
    public final /* synthetic */ l b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(l lVar, ConditionVariable conditionVariable) {
        super("SimpleCache.initialize()");
        this.b = lVar;
        this.f1443a = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        synchronized (this.b) {
            this.f1443a.open();
            try {
                l.a(this.b);
            } catch (a e) {
                this.b.f = e;
            }
            this.b.b.getClass();
        }
    }
}
