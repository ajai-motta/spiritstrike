package com.fyber.inneractive.sdk.player.ui;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.fyber.inneractive.sdk.player.controller.z;
import com.fyber.inneractive.sdk.util.g1;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f1527a;
    public final /* synthetic */ int[] b;
    public final /* synthetic */ int c;
    public final /* synthetic */ s d;

    public q(s sVar, View view, int[] iArr, int i) {
        this.d = sVar;
        this.f1527a = view;
        this.b = iArr;
        this.c = i;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        onSingleTapConfirmed(motionEvent);
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onDown(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final void onLongPress(MotionEvent motionEvent) {
        onSingleTapConfirmed(motionEvent);
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f1527a.getRootView().getLocationOnScreen(this.b);
            float rawX = motionEvent.getRawX() - this.b[0];
            float rawY = motionEvent.getRawY() - this.b[1];
            g1 g1Var = this.d.f1523a;
            g1Var.f1652a = rawX;
            g1Var.b = rawY;
        }
        s sVar = this.d;
        n nVar = sVar.g;
        if (nVar != null) {
            ((z) nVar).a(this.c, sVar.f1523a);
        }
        return true;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent motionEvent) {
        return true;
    }
}
