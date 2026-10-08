package com.tnkfactory.ad.pub;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: classes6.dex */
public final class r3 implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u3 f3187a;

    public r3(u3 u3Var) {
        this.f3187a = u3Var;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        u3 u3Var = this.f3187a;
        if (view != u3Var.e) {
            return false;
        }
        return u3Var.a(motionEvent);
    }
}
