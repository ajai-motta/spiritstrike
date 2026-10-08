package com.tnkfactory.ad.pub;

import android.view.View;
import com.tnkfactory.ad.AdListener;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class e5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3127a;

    public e5(i5 i5Var) {
        this.f3127a = i5Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i5 i5Var = this.f3127a;
        if (i5Var.b == null || !i5Var.q) {
            return;
        }
        c cVar = i5Var.C;
        if (cVar != null && !cVar.j0.m.isEmpty()) {
            k4 k4VarA = k4.a();
            ArrayList arrayList = this.f3127a.C.j0.m;
            k4VarA.getClass();
            k4.a(arrayList);
            this.f3127a.b.getClass();
        }
        h5 h5Var = this.f3127a.t;
        if (h5Var != null) {
            x1 x1Var = ((m1) h5Var).f3158a;
            int i = AdListener.CLOSE_SIMPLE;
            u uVar = x1Var.j;
            if (uVar != null) {
                uVar.sendEmptyMessage(i);
            }
        }
    }
}
