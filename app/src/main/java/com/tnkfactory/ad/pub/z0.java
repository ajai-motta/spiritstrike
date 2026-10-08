package com.tnkfactory.ad.pub;

import android.view.ViewTreeObserver;
import com.tnkfactory.ad.Logger;

/* JADX INFO: loaded from: classes6.dex */
public final class z0 implements ViewTreeObserver.OnPreDrawListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f3228a;
    public final /* synthetic */ b1 b;

    public z0(b1 b1Var, boolean z) {
        this.b = b1Var;
        this.f3228a = z;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        try {
            this.b.f.getViewTreeObserver().removeOnPreDrawListener(this.b.v);
            b1 b1Var = this.b;
            b1Var.v = null;
            a1 a1Var = b1Var.p;
            if (a1Var != null) {
                if (this.f3228a) {
                    a1Var.b(300L);
                } else {
                    a1Var.b();
                }
            }
            return false;
        } catch (Exception unused) {
            if (this.b.n == 3) {
                Logger.e(h1.a("e4790f98ec43d163f26c24413bfc3bf08edf100d2b57d18c1419"));
                return false;
            }
            Logger.e(h1.a("e4790f98ec43d163f26c24413bfc3bf08edf100d364ad18c1417b86c5ff6a935305ccf59a28323f65f328c4abb"));
            return false;
        }
    }
}
