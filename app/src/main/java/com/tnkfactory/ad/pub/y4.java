package com.tnkfactory.ad.pub;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ToggleButton;

/* JADX INFO: loaded from: classes6.dex */
public final class y4 implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i5 f3226a;

    public y4(i5 i5Var) {
        this.f3226a = i5Var;
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zA = n2.a((View) this.f3226a, true);
        i5 i5Var = this.f3226a;
        if (!zA) {
            if (i5Var.q) {
                i5Var.a();
            }
        } else {
            if (!i5Var.r || i5Var.q) {
                return;
            }
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
}
