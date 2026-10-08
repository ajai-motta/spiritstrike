package com.fyber.inneractive.sdk.util;

import android.content.Context;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: classes3.dex */
public final class k0 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f1656a;
    public final /* synthetic */ n0 b;

    public k0(n0 n0Var, Context context) {
        this.b = n0Var;
        this.f1656a = context;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.b.a(this.f1656a);
        return true;
    }
}
