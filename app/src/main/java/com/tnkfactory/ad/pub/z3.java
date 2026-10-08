package com.tnkfactory.ad.pub;

import android.content.DialogInterface;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes6.dex */
public final class z3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3231a;

    public z3(i5 i5Var) {
        this.f3231a = i5Var;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        i5 i5Var = this.f3231a;
        i5Var.r = true;
        ToggleButton toggleButton = i5Var.d;
        if (toggleButton != null) {
            toggleButton.setChecked(true);
        }
        r5 r5Var = i5Var.b;
        if (r5Var != null) {
            r5Var.a();
            i5Var.a(700L);
        }
    }
}
