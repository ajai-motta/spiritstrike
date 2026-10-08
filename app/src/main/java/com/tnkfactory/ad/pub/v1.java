package com.tnkfactory.ad.pub;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class v1 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f3207a;
    public final /* synthetic */ w1 b;

    public v1(w1 w1Var, View view) {
        this.b = w1Var;
        this.f3207a = view;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        int i;
        x1 x1Var = this.b.b;
        View view = this.f3207a;
        x1Var.getClass();
        try {
            i = Integer.parseInt((String) view.getTag());
        } catch (Exception unused) {
            i = 0;
        }
        u uVar = x1Var.j;
        if (uVar != null) {
            x1Var.j.sendMessage(uVar.obtainMessage(1, i, 0));
        }
        return true;
    }
}
