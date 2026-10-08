package com.fyber.inneractive.sdk.dv;

import com.fyber.inneractive.sdk.config.global.r;
import com.fyber.inneractive.sdk.config.s0;
import com.fyber.inneractive.sdk.flow.x;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends x {
    public c g;
    public com.fyber.inneractive.sdk.dv.banner.c h;
    public Object i;

    public a(s0 s0Var, r rVar, i iVar) {
        super(s0Var, rVar);
        this.b = iVar;
    }

    public abstract void a(AdRequest adRequest, c cVar);

    @Override // com.fyber.inneractive.sdk.flow.x
    public final com.fyber.inneractive.sdk.response.e b() {
        return (i) this.b;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public final void destroy() {
        this.g = null;
        this.i = null;
    }

    @Override // com.fyber.inneractive.sdk.flow.x
    public boolean isVideoAd() {
        return false;
    }
}
