package com.fyber.inneractive.sdk.flow;

import android.content.Context;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class y implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1128a;
    public final /* synthetic */ String b;
    public final /* synthetic */ g1 c;
    public final /* synthetic */ com.fyber.inneractive.sdk.util.g d;
    public final /* synthetic */ boolean e;
    public final /* synthetic */ com.fyber.inneractive.sdk.click.o f;
    public final /* synthetic */ b0 g;

    public y(b0 b0Var, Context context, String str, g1 g1Var, com.fyber.inneractive.sdk.util.g gVar, boolean z, com.fyber.inneractive.sdk.click.o oVar) {
        this.g = b0Var;
        this.f1128a = context;
        this.b = str;
        this.c = g1Var;
        this.d = gVar;
        this.e = z;
        this.f = oVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.g.a(this.f1128a, this.b, this.c, this.d, this.e, this.f);
    }
}
