package com.tnkfactory.ad.pub;

import android.view.View;
import android.widget.ToggleButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class c5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3118a;

    public c5(i5 i5Var) {
        this.f3118a = i5Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i5 i5Var = this.f3118a;
        i5Var.getClass();
        if (view == null) {
            return;
        }
        boolean zIsChecked = ((ToggleButton) view).isChecked();
        i5Var.p = zIsChecked;
        if (zIsChecked) {
            z1 z1Var = i5Var.C.j0;
            if (z1Var != null && !z1Var.g.isEmpty()) {
                k4 k4VarA = k4.a();
                ArrayList arrayList = i5Var.C.j0.g;
                k4VarA.getClass();
                k4.a(arrayList);
            }
        } else {
            z1 z1Var2 = i5Var.C.j0;
            if (z1Var2 != null && !z1Var2.h.isEmpty()) {
                k4 k4VarA2 = k4.a();
                ArrayList arrayList2 = i5Var.C.j0.h;
                k4VarA2.getClass();
                k4.a(arrayList2);
            }
        }
        i5Var.b.setVolumeOn(!i5Var.p);
    }
}
