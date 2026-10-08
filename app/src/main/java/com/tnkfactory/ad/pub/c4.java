package com.tnkfactory.ad.pub;

import android.app.AlertDialog;
import android.content.Context;
import android.text.Html;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import com.tnkfactory.ad.AdListener;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public final class c4 extends v {
    public static final /* synthetic */ int r = 0;
    public final int o;
    public x3 p;
    public boolean q;

    public c4(Context context, int i, int i2, c cVar) {
        super(context, i, i2, cVar, true);
        this.p = null;
        this.q = false;
        this.o = cVar.Q;
    }

    @Override // com.tnkfactory.ad.pub.v
    public final void b() {
        addOnLayoutChangeListener(new w3(this));
    }

    @Override // com.tnkfactory.ad.pub.v, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getRootWindowInsets() != null) {
            a((View) this);
        } else {
            addOnAttachStateChangeListener(new v3());
        }
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 0) {
            return false;
        }
        this.q = true;
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public final boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (i != 4 || keyEvent.getAction() != 1 || !this.q) {
            return false;
        }
        this.q = false;
        int i2 = this.o;
        if (i2 >= 0) {
            a(i2, true);
        }
        return true;
    }

    public static void a(View view) {
        WindowInsets rootWindowInsets;
        if (view == null || (rootWindowInsets = view.getRootWindowInsets()) == null) {
            return;
        }
        view.setPadding(rootWindowInsets.getSystemWindowInsetLeft(), rootWindowInsets.getSystemWindowInsetTop(), rootWindowInsets.getSystemWindowInsetRight(), rootWindowInsets.getSystemWindowInsetBottom());
    }

    public final void a(t5 t5Var) {
        if (t5Var.b) {
            int[] viewSizeSdk35 = t5Var.getViewSizeSdk35();
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(viewSizeSdk35[0], viewSizeSdk35[1]);
            layoutParams.gravity = 17;
            FrameLayout frameLayout = new FrameLayout(t5Var.getContext());
            frameLayout.setLayoutParams(layoutParams);
            t5Var.addView(frameLayout);
            frameLayout.addView(this);
        } else {
            t5Var.addView(this);
        }
        e();
        long j = this.d.T;
        if (j > 0) {
            x3 x3Var = new x3(this);
            this.p = x3Var;
            this.e.postDelayed(x3Var, j * 1000);
        }
    }

    @Override // com.tnkfactory.ad.pub.v
    public final void a(int i, boolean z) {
        if (this.f) {
            View viewA = this.h.a(h1.a("c77c179fed549e"));
            i5 i5Var = viewA instanceof i5 ? (i5) viewA : null;
            if (i5Var != null) {
                i5Var.r = false;
                i5Var.a();
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle(Html.fromHtml(r2.a().e));
                builder.setMessage(r2.a().f);
                builder.setNegativeButton(Html.fromHtml(r2.a().g), new y3(this, i, z));
                builder.setPositiveButton(Html.fromHtml(r2.a().h), new z3(i5Var));
                builder.setCancelable(false);
                builder.create().show();
                return;
            }
        }
        x1 x1Var = this.h;
        for (String str : x1Var.g.keySet()) {
            View viewA2 = x1Var.a(str);
            if (viewA2 != null) {
                viewA2.clearAnimation();
            }
        }
        this.j = false;
        x3 x3Var = this.p;
        if (x3Var != null) {
            this.e.removeCallbacks(x3Var);
            this.p = null;
        }
        t5 t5VarA = a(getParent());
        if (t5VarA == null) {
            return;
        }
        t5VarA.setBackgroundColor(0);
        if (z && this.b != null && i != AdListener.CLOSE_EXIT) {
            Iterator it = n2.a(this, r5.class).iterator();
            while (it.hasNext()) {
                ((View) it.next()).setVisibility(8);
            }
            post(new a4(this, i));
        } else {
            t5 t5VarA2 = a(getParent());
            if (t5VarA2 != null) {
                t5VarA2.a();
            }
            k2 k2Var = this.c;
            if (k2Var != null) {
                k2Var.a(i);
            }
        }
        c cVar = this.d;
        if (cVar != null) {
            z1 z1Var = cVar.j0;
            if (z1Var != null && !z1Var.m.isEmpty()) {
                k4 k4VarA = k4.a();
                ArrayList arrayList = this.d.j0.m;
                k4VarA.getClass();
                k4.a(arrayList);
            }
            z1 z1Var2 = this.d.j0;
            if (z1Var2 == null || z1Var2.j.isEmpty()) {
                return;
            }
            k4 k4VarA2 = k4.a();
            ArrayList arrayList2 = this.d.j0.j;
            k4VarA2.getClass();
            k4.a(arrayList2);
        }
    }

    public static t5 a(ViewParent viewParent) {
        if (viewParent == null) {
            return null;
        }
        if (viewParent instanceof t5) {
            return (t5) viewParent;
        }
        return a(viewParent.getParent());
    }
}
