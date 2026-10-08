package com.tnkfactory.ad.pub;

import android.content.Context;
import com.tnkfactory.ad.AdError;

/* JADX INFO: loaded from: classes6.dex */
public final class h2 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ t5 f3137a;
    public final /* synthetic */ j2 b;

    public h2(j2 j2Var, t5 t5Var) {
        this.b = j2Var;
        this.f3137a = t5Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        c4 c4Var;
        j2 j2Var = this.b;
        t5 t5Var = this.f3137a;
        j2Var.getClass();
        Context context = t5Var.getContext();
        int[] viewSizeSdk35 = t5Var.getViewSizeSdk35();
        int i = viewSizeSdk35[0];
        int i2 = viewSizeSdk35[1];
        c cVar = j2Var.e;
        int i3 = c4.r;
        try {
            System.currentTimeMillis();
            c4Var = new c4(context, i, i2, cVar);
        } catch (Exception e) {
            e.printStackTrace();
            c4Var = null;
        }
        j2Var.g = c4Var;
        if (c4Var == null || !c4Var.j) {
            t5Var.a();
            j2Var.a();
            j2Var.a(j2Var.f, AdError.FAIL_AD_FRAME);
        } else {
            c4Var.c = new i2(j2Var);
            c4Var.i = j2Var.c;
            c4Var.a(t5Var);
            m4.a(context).b(j2Var.f3115a);
        }
    }
}
