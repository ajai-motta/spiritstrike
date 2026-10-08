package com.unity3d.player;

/* JADX INFO: renamed from: com.unity3d.player.p0, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
final class C3210p0 implements G {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ RunnableC3212q0 f3328a;

    C3210p0(RunnableC3212q0 runnableC3212q0) {
        this.f3328a = runnableC3212q0;
    }

    public final void a() {
        RunnableC3212q0 runnableC3212q0 = this.f3328a;
        runnableC3212q0.f3330a = true;
        if (runnableC3212q0.b) {
            runnableC3212q0.c.release();
        }
    }
}
