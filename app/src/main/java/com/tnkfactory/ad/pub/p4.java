package com.tnkfactory.ad.pub;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes6.dex */
public final class p4 extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f3177a = 0;
    public i0 b = null;

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        this.f3177a = 0L;
        return false;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f3177a <= 1500) {
            return false;
        }
        this.f3177a = jCurrentTimeMillis;
        i0 i0Var = this.b;
        if (i0Var == null) {
            return false;
        }
        i0Var.a();
        return false;
    }
}
