package com.fyber.inneractive.sdk.renderers;

/* JADX INFO: loaded from: classes3.dex */
public final class u implements com.fyber.inneractive.sdk.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f1607a;

    public u(v vVar) {
        this.f1607a = vVar;
    }

    @Override // com.fyber.inneractive.sdk.player.e
    public final void a() {
        this.f1607a.y.b(false);
        ((com.fyber.inneractive.sdk.player.controller.z) this.f1607a.y).y();
    }
}
