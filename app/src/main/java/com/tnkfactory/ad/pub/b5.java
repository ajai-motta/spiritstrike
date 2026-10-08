package com.tnkfactory.ad.pub;

import android.view.View;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes6.dex */
public final class b5 implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3113a;

    public b5(i5 i5Var) {
        this.f3113a = i5Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        i5 i5Var = this.f3113a;
        i5Var.getClass();
        ToggleButton toggleButton = (ToggleButton) view;
        if (i5Var.b == null) {
            return;
        }
        if (!toggleButton.isChecked()) {
            i5Var.r = false;
            i5Var.a();
        } else {
            i5Var.r = true;
            i5Var.b.a();
            i5Var.a(700L);
        }
    }
}
