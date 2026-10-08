package com.fyber.inneractive.sdk.renderers;

/* JADX INFO: loaded from: classes3.dex */
public final class m implements com.fyber.inneractive.sdk.player.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1602a;

    public m(p pVar) {
        this.f1602a = pVar;
    }

    @Override // com.fyber.inneractive.sdk.player.e
    public final void a() {
        com.fyber.inneractive.sdk.ui.controller.b bVar = this.f1602a.k;
        if (bVar != null) {
            ((com.fyber.inneractive.sdk.player.controller.s) bVar).b(false);
            ((com.fyber.inneractive.sdk.player.controller.s) this.f1602a.k).y();
        }
    }
}
