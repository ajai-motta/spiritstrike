package com.tnkfactory.ad.pub;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class h3 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GestureDetector f3138a;
    public final /* synthetic */ i3 b;

    public h3(i3 i3Var, View view) {
        this.b = i3Var;
        if (!view.isClickable()) {
            view.setClickable(true);
        }
        this.f3138a = new GestureDetector(view.getContext(), new g3(this, view));
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.f3138a.onTouchEvent(motionEvent);
    }
}
