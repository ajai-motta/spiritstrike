package com.tnkfactory.ad.pub;

import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes6.dex */
public final class a5 implements g5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Context f3107a;
    public final /* synthetic */ i5 b;

    public a5(i5 i5Var, Context context) {
        this.b = i5Var;
        this.f3107a = context;
    }

    public final void a(int i) {
        i5 i5Var = this.b;
        i5Var.q = true;
        i5Var.m = false;
        i5Var.k = i;
        i5Var.removeCallbacks(i5Var.G);
        i5 i5Var2 = this.b;
        i5Var2.postDelayed(i5Var2.G, 200L);
        ToggleButton toggleButton = this.b.d;
        if (toggleButton != null) {
            toggleButton.setChecked(true);
            this.b.a(700L);
        }
        i5 i5Var3 = this.b;
        h5 h5Var = i5Var3.t;
        if (h5Var != null && !i5Var3.w) {
            i5Var3.w = true;
            ((m1) h5Var).a(0);
            z1 z1Var = this.b.C.j0;
            if (z1Var != null && !z1Var.d.isEmpty()) {
                k4 k4VarA = k4.a();
                ArrayList arrayList = this.b.C.j0.d;
                k4VarA.getClass();
                k4.a(arrayList);
            }
        }
        this.b.b.setVolumeOn(!r6.p);
        i5 i5Var4 = this.b;
        if (i5Var4.C.j0 != null) {
            i5Var4.setPanelVisible(false);
            i5 i5Var5 = this.b;
            i5Var5.b.a(this.f3107a, i5Var5.g, i5Var5.C);
        }
        ArrayList arrayList2 = this.b.C.k0;
        if (arrayList2 == null || arrayList2.size() == 0) {
            return;
        }
        i5 i5Var6 = this.b;
        i5Var6.a(this.f3107a, i5Var6.f, i5Var6.C);
    }

    public final void b() {
        ClipDrawable clipDrawable;
        i5 i5Var = this.b;
        i5Var.q = false;
        ImageView imageView = i5Var.h;
        if (imageView != null && (clipDrawable = (ClipDrawable) imageView.getDrawable()) != null) {
            clipDrawable.setLevel(0);
        }
        TextView textView = this.b.i;
        if (textView != null) {
            textView.setText("");
        }
        ToggleButton toggleButton = this.b.d;
        if (toggleButton != null) {
            toggleButton.setChecked(false);
            this.b.setPanelVisible(true);
        }
    }

    public final void a() {
        i5 i5Var = this.b;
        i5Var.q = false;
        if (!i5Var.l) {
            i5Var.r = false;
        }
        i5Var.a(-1L);
        TextView textView = this.b.i;
        if (textView != null) {
            textView.setText("");
            z1 z1Var = this.b.C.j0;
            if (z1Var != null && !z1Var.b.isEmpty()) {
                k4 k4VarA = k4.a();
                ArrayList arrayList = this.b.C.j0.b;
                k4VarA.getClass();
                k4.a(arrayList);
            }
        }
        ToggleButton toggleButton = this.b.d;
        if (toggleButton != null) {
            toggleButton.setChecked(false);
            this.b.setPanelVisible(true);
        }
        i5 i5Var2 = this.b;
        f5 f5Var = i5Var2.s;
        if (f5Var != null && !i5Var2.l) {
            x1 x1Var = ((t1) f5Var).f3195a;
            x1Var.getClass();
            String str = (String) i5Var2.getTag();
            if (str != null) {
                x1Var.b(str);
            }
        }
        i5 i5Var3 = this.b;
        h5 h5Var = i5Var3.t;
        if (h5Var == null || i5Var3.A) {
            return;
        }
        i5Var3.A = true;
        ((m1) h5Var).a(100);
    }
}
