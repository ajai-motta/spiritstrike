package com.tnkfactory.ad.pub;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes6.dex */
public final class t4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Drawable f3197a;
    public final /* synthetic */ u4 b;

    public t4(u4 u4Var, Drawable drawable) {
        this.b = u4Var;
        this.f3197a = drawable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.b.setImageDrawable(this.f3197a);
    }
}
