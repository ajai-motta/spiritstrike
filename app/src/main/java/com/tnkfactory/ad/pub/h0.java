package com.tnkfactory.ad.pub;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class h0 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l0 f3135a;

    public h0(l0 l0Var) {
        this.f3135a = l0Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        this.f3135a.d.onTouchEvent(motionEvent);
        return false;
    }
}
