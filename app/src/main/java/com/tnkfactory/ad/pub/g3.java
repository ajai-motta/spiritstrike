package com.tnkfactory.ad.pub;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class g3 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3133a;
    public final /* synthetic */ h3 b;

    public g3(h3 h3Var, View view) {
        this.b = h3Var;
        this.f3133a = view;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        i3 i3Var = this.b.b;
        Context context = this.f3133a.getContext();
        if (i3Var.e.C != null) {
            new o4(i3Var.e.C).start();
        }
        i3Var.a(context, i3Var.e.j);
        return true;
    }
}
