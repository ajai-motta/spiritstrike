package com.fyber.inneractive.sdk.player.ui;

import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.u1;

/* JADX INFO: loaded from: classes3.dex */
public final class j implements u1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1525a;
    public final /* synthetic */ l b;

    public j(l lVar, int i) {
        this.b = lVar;
        this.f1525a = i;
    }

    @Override // com.fyber.inneractive.sdk.util.u1
    public final void a() {
        if (this.b.h) {
            IAlog.a("Autoclick is aborted - app in background", new Object[0]);
        } else {
            IAlog.a("Autoclick is triggered", new Object[0]);
            ((z) this.b.g).a(this.f1525a, l.I);
        }
        this.b.p();
    }
}
