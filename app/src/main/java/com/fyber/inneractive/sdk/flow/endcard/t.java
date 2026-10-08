package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.external.InneractiveInfrastructureError;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements com.fyber.inneractive.sdk.web.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a f1061a;
    public final /* synthetic */ u b;

    public t(u uVar, com.fyber.inneractive.sdk.flow.endcard.loaders.listeners.a aVar) {
        this.b = uVar;
        this.f1061a = aVar;
    }

    @Override // com.fyber.inneractive.sdk.web.g
    public final void a(com.fyber.inneractive.sdk.web.i iVar) {
        this.b.h.set(false);
        this.b.i.a(iVar);
        this.f1061a.a();
    }

    @Override // com.fyber.inneractive.sdk.web.g
    public final void a(com.fyber.inneractive.sdk.web.i iVar, InneractiveInfrastructureError inneractiveInfrastructureError) {
        this.b.h.set(false);
        this.b.i.a(iVar, inneractiveInfrastructureError);
        this.f1061a.a(inneractiveInfrastructureError.description());
    }
}
