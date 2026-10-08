package com.fyber.inneractive.sdk.flow.nativead.mainasset;

import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.external.InneractiveAdRequest;
import com.fyber.inneractive.sdk.external.InneractiveErrorCode;
import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;
import com.fyber.inneractive.sdk.flow.i;
import com.fyber.inneractive.sdk.flow.t0;
import com.fyber.inneractive.sdk.flow.u;
import com.fyber.inneractive.sdk.flow.x;
import com.fyber.inneractive.sdk.player.s;
import com.fyber.inneractive.sdk.response.g;
import com.fyber.inneractive.sdk.util.IAlog;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements d, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r f1080a;
    public final com.fyber.inneractive.sdk.response.nativead.f b;
    public g c;
    public InneractiveAdRequest d;
    public c e;
    public com.fyber.inneractive.sdk.flow.nativead.b g = com.fyber.inneractive.sdk.flow.nativead.b.UNINITIALIZED;
    public u f = new u();

    public f(com.fyber.inneractive.sdk.response.nativead.f fVar, r rVar, g gVar, InneractiveAdRequest inneractiveAdRequest, String str, com.fyber.inneractive.sdk.flow.nativead.f fVar2) {
        this.b = fVar;
        this.f1080a = rVar;
        this.c = gVar;
        this.d = inneractiveAdRequest;
        this.e = fVar2;
    }

    @Override // com.fyber.inneractive.sdk.player.s
    public final void a(InneractiveInfrastructureError inneractiveInfrastructureError) {
        InneractiveInfrastructureError inneractiveInfrastructureError2 = new InneractiveInfrastructureError(inneractiveInfrastructureError.getErrorCode(), i.NATIVE_AD_VIDEO_LOAD_FAILED);
        this.g = com.fyber.inneractive.sdk.flow.nativead.b.FAILED;
        c cVar = this.e;
        if (cVar != null) {
            ((com.fyber.inneractive.sdk.flow.nativead.f) cVar).a(inneractiveInfrastructureError2, "onAdFailedToLoad");
        }
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final void b() {
        com.fyber.inneractive.sdk.response.nativead.f fVar;
        com.fyber.inneractive.sdk.response.nativead.e eVar;
        String str;
        g gVar;
        if (this.f != null && (fVar = this.b) != null && (eVar = fVar.c) != null && (str = eVar.f1617a) != null && !str.trim().isEmpty() && (gVar = this.c) != null) {
            this.g = com.fyber.inneractive.sdk.flow.nativead.b.LOADING;
            this.f.a(this.f1080a, gVar, this.d, this);
            return;
        }
        InneractiveInfrastructureError inneractiveInfrastructureError = new InneractiveInfrastructureError(InneractiveErrorCode.SDK_INTERNAL_ERROR, i.VIDEO_ERROR_NULL);
        this.g = com.fyber.inneractive.sdk.flow.nativead.b.FAILED;
        c cVar = this.e;
        if (cVar != null) {
            ((com.fyber.inneractive.sdk.flow.nativead.f) cVar).a(inneractiveInfrastructureError, "mVideoContentLoader is null, can't start loading");
        }
        IAlog.b("%smVideoContentLoader is null, can't start loading", IAlog.a(this));
    }

    @Override // com.fyber.inneractive.sdk.player.s
    public final void c() throws Throwable {
        u uVar;
        this.g = com.fyber.inneractive.sdk.flow.nativead.b.LOADED;
        c cVar = this.e;
        if (cVar == null || (uVar = this.f) == null) {
            IAlog.b("%sCan't notify success, required member is null in onAdLoaded. Is null: mLoadListener: %s, mVideoContentLoader: %s", IAlog.a(this), Boolean.valueOf(this.e == null), Boolean.valueOf(this.f == null));
            return;
        }
        t0 t0Var = (t0) uVar.c;
        com.fyber.inneractive.sdk.flow.nativead.f fVar = (com.fyber.inneractive.sdk.flow.nativead.f) cVar;
        fVar.getClass();
        if (t0Var == null) {
            fVar.a(new InneractiveInfrastructureError(InneractiveErrorCode.NATIVE_AD_FAILED_TO_LOAD, i.NATIVE_AD_EMPTY_CONTENT), "Undetectable main media");
            return;
        }
        if (t0Var != null) {
            fVar.e = t0Var;
        }
        fVar.a();
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final void destroy() {
        u uVar = this.f;
        if (uVar != null) {
            x xVar = uVar.c;
            if (xVar != null) {
                ((t0) xVar).destroy();
            }
            u uVar2 = this.f;
            uVar2.getClass();
            IAlog.a("%s: IAAdContentLoaderImpl : cancel load ad content retry task", IAlog.a(uVar2));
            com.fyber.inneractive.sdk.util.r.b.removeCallbacks(uVar2.l);
            uVar2.k.a();
            this.f = null;
        }
        this.e = null;
        this.d = null;
        this.c = null;
        this.g = com.fyber.inneractive.sdk.flow.nativead.b.DESTROYED;
    }

    @Override // com.fyber.inneractive.sdk.flow.nativead.c
    public final boolean a() {
        return this.g == com.fyber.inneractive.sdk.flow.nativead.b.LOADING;
    }
}
