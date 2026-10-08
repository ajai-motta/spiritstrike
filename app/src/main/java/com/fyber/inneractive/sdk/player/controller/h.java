package com.fyber.inneractive.sdk.player.controller;

import android.view.TextureView;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f1244a;

    public h(i iVar) {
        this.f1244a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        q qVar = this.f1244a.f1245a;
        x xVar = qVar.d;
        if (xVar != null) {
            TextureView textureView = qVar.j;
            z zVar = xVar.f1257a;
            zVar.getClass();
            IAlog.a("%s onTextureViewDestroyed", IAlog.a(zVar));
        }
    }
}
