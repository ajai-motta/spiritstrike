package com.fyber.inneractive.sdk.flow.endcard;

import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class e implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f1045a;
    public final com.fyber.inneractive.sdk.player.ui.n b;
    public final int[] c = new int[2];
    public final g1 d = new g1();

    public e(int i, com.fyber.inneractive.sdk.player.ui.n nVar) {
        this.f1045a = i;
        this.b = nVar;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        view.getRootView().getLocationOnScreen(this.c);
        float rawX = motionEvent.getRawX() - this.c[0];
        float rawY = motionEvent.getRawY() - this.c[1];
        g1 g1Var = this.d;
        g1Var.f1652a = rawX;
        g1Var.b = rawY;
        ((z) this.b).a(this.f1045a, g1Var);
        return true;
    }
}
