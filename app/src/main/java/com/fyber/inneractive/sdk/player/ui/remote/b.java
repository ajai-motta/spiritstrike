package com.fyber.inneractive.sdk.player.ui.remote;

import com.fyber.inneractive.sdk.util.IAlog;
import com.fyber.inneractive.sdk.util.r;

/* JADX INFO: loaded from: classes3.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f1529a;

    public b(d dVar) {
        this.f1529a = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        IAlog.a("%s : remote UI load timeout task executed", "RemoteUIWebviewController");
        d dVar = this.f1529a;
        dVar.g = true;
        IAlog.a("%s : UI load timed out", "RemoteUIWebviewController");
        r.b.post(dVar.l);
    }
}
