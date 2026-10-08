package com.fyber.inneractive.sdk.network;

import com.fyber.inneractive.sdk.external.InneractiveAdRequest;

/* JADX INFO: loaded from: classes3.dex */
public final class s extends m {
    public final InneractiveAdRequest e;
    public final q0 f;

    public s(InneractiveAdRequest inneractiveAdRequest, String str, com.fyber.inneractive.sdk.config.global.r rVar, com.fyber.inneractive.sdk.flow.o oVar) {
        super(rVar, str, oVar);
        this.e = inneractiveAdRequest;
        q0 q0Var = new q0(new q(this), inneractiveAdRequest, rVar);
        this.f = q0Var;
        q0Var.d = new r(this);
    }

    @Override // com.fyber.inneractive.sdk.network.m
    public final void a() {
        this.b = true;
        this.f1208a = null;
        this.f.f1217a = true;
    }

    @Override // com.fyber.inneractive.sdk.network.m
    public final String b() {
        return this.f.r();
    }
}
