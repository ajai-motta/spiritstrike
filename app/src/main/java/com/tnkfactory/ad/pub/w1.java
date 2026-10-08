package com.tnkfactory.ad.pub;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class w1 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f3213a;
    public final /* synthetic */ x1 b;

    public w1(x1 x1Var, View view) {
        this.b = x1Var;
        if (!view.isClickable()) {
            view.setClickable(true);
        }
        this.f3213a = new GestureDetector(view.getContext(), new v1(this, view));
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f3213a.onTouchEvent(motionEvent);
    }
}
