package com.fyber.inneractive.sdk.renderers;

import com.fyber.inneractive.sdk.flow.w0;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements com.fyber.inneractive.sdk.ui.controller.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f1608a;

    public y(a0 a0Var) {
        this.f1608a = a0Var;
    }

    @Override // com.fyber.inneractive.sdk.ui.controller.c
    public final void u() {
        a0 a0Var = this.f1608a;
        boolean z = a0Var.m;
        if (z) {
            return;
        }
        if (a0Var.b != null && !z) {
            a0Var.m = true;
            IAlog.a("%sTracking impression", IAlog.a(a0Var));
            com.fyber.inneractive.sdk.flow.nativead.trackers.a aVar = new com.fyber.inneractive.sdk.flow.nativead.trackers.a((w0) a0Var.b);
            a0Var.n = aVar;
            aVar.a(a0Var);
        }
        a0Var.G();
    }
}
