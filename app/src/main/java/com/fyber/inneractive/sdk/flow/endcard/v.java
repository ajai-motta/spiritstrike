package com.fyber.inneractive.sdk.flow.endcard;

import com.fyber.inneractive.sdk.flow.x0;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends c {
    public final com.fyber.inneractive.sdk.model.vast.k h;

    public v(x0 x0Var, com.fyber.inneractive.sdk.model.vast.c cVar, int i) {
        super(x0Var, cVar, i);
        this.h = cVar.b;
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.b
    public final n c() {
        return new w(this);
    }

    @Override // com.fyber.inneractive.sdk.flow.endcard.c, com.fyber.inneractive.sdk.flow.endcard.b
    public final boolean l() {
        return super.l() && ((w) f()).c != null;
    }
}
