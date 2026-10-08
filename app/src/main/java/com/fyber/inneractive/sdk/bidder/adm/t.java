package com.fyber.inneractive.sdk.bidder.adm;

import com.fyber.inneractive.sdk.flow.c0;

/* JADX INFO: loaded from: classes3.dex */
public final class t implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f880a;
    public final /* synthetic */ com.fyber.inneractive.sdk.config.global.r b;
    public final /* synthetic */ y c;

    public t(y yVar, c0 c0Var, com.fyber.inneractive.sdk.config.global.r rVar) {
        this.c = yVar;
        this.f880a = c0Var;
        this.b = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.c.a(this.f880a, this.b);
    }
}
