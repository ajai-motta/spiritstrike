package com.fyber.inneractive.sdk.player.controller;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class i implements TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f1245a;

    public i(q qVar) {
        this.f1245a = qVar;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        q qVar = this.f1245a;
        qVar.getClass();
        IAlog.a("%s onSurfaceTextureAvailable", IAlog.a(qVar));
        q.a(this.f1245a, surfaceTexture);
        q qVar2 = this.f1245a;
        x xVar = qVar2.d;
        if (xVar != null) {
            TextureView textureView = qVar2.j;
            z zVar = xVar.f1257a;
            zVar.getClass();
            IAlog.a("%s onTextureViewAvailable", IAlog.a(zVar));
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        q qVar = this.f1245a;
        qVar.getClass();
        IAlog.a("%s onSurfaceTextureDestroyed", IAlog.a(qVar));
        this.f1245a.i();
        this.f1245a.a((Surface) null);
        q qVar2 = this.f1245a;
        qVar2.o = true;
        com.fyber.inneractive.sdk.player.enums.b bVar = qVar2.e;
        if (bVar == com.fyber.inneractive.sdk.player.enums.b.Error || bVar == com.fyber.inneractive.sdk.player.enums.b.Idle) {
            qVar2.getClass();
            IAlog.a("%sReleasing surface texture", IAlog.a(qVar2));
            this.f1245a.k = null;
            return true;
        }
        qVar2.getClass();
        IAlog.a("%s caching surface texture", IAlog.a(qVar2));
        q qVar3 = this.f1245a;
        qVar3.k = surfaceTexture;
        qVar3.i.post(new h(this));
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        q qVar = this.f1245a;
        if (qVar.e == com.fyber.inneractive.sdk.player.enums.b.Paused) {
            int iB = qVar.b();
            int iC = qVar.c();
            if (iB <= 0 || iB > iC) {
                return;
            }
            qVar.a(iB - 1, false);
            qVar.a(iB, false);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        Surface surface;
        q qVar;
        q qVar2 = this.f1245a;
        x xVar = qVar2.d;
        if (xVar != null) {
            TextureView textureView = qVar2.j;
            com.fyber.inneractive.sdk.player.f fVar = xVar.f1257a.f1259a;
            if (fVar != null && (qVar = fVar.f1498a) != null) {
                qVar.i.post(new n(qVar));
            }
        }
        q qVar3 = this.f1245a;
        if (!qVar3.o || (surface = qVar3.l) == null) {
            return;
        }
        qVar3.a(surface);
        this.f1245a.o = false;
    }
}
