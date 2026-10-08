package com.tnkfactory.ad.pub;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes6.dex */
public final class p5 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable f3178a;
    public final /* synthetic */ q5 b;

    public p5(q5 q5Var, Drawable drawable) {
        this.b = q5Var;
        this.f3178a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.c.setImageDrawable(this.f3178a);
    }
}
