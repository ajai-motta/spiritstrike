package com.tnkfactory.ad.pub;

import android.content.Context;
import com.tnkfactory.ad.AdError;

/* JADX INFO: loaded from: classes6.dex */
public final class f4 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t5 f3131a;
    public final /* synthetic */ h4 b;

    public f4(h4 h4Var, t5 t5Var) {
        this.b = h4Var;
        this.f3131a = t5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c4 c4Var;
        h4 h4Var = this.b;
        t5 t5Var = this.f3131a;
        h4Var.getClass();
        Context context = t5Var.getContext();
        int[] viewSizeSdk35 = t5Var.getViewSizeSdk35();
        int i = viewSizeSdk35[0];
        int i2 = viewSizeSdk35[1];
        c cVar = h4Var.e;
        int i3 = c4.r;
        try {
            System.currentTimeMillis();
            c4Var = new c4(context, i, i2, cVar);
        } catch (Exception e) {
            e.printStackTrace();
            c4Var = null;
        }
        h4Var.g = c4Var;
        if (c4Var == null || !c4Var.j) {
            t5Var.a();
            h4Var.a();
            h4Var.a(h4Var.f, AdError.FAIL_AD_FRAME);
        } else {
            c4Var.c = new g4(h4Var);
            c4Var.i = h4Var.c;
            c4Var.a(t5Var);
            m4.a(context).b(h4Var.f3115a);
        }
    }
}
