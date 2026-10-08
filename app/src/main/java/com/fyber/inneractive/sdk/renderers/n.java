package com.fyber.inneractive.sdk.renderers;

import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f1603a;

    public n(p pVar) {
        this.f1603a = pVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        p pVar = this.f1603a;
        if (pVar.t != null) {
            pVar.getClass();
            IAlog.a("%sIdle state reached!", IAlog.a(pVar));
            com.fyber.inneractive.sdk.ui.controller.b bVar = this.f1603a.k;
            if (bVar != null) {
                ((com.fyber.inneractive.sdk.player.controller.s) bVar).j(true);
            }
            this.f1603a.t = null;
        }
    }
}
