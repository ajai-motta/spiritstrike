package com.tnkfactory.ad.pub;

import android.view.animation.Animation;
import android.widget.TextView;

/* JADX INFO: loaded from: classes6.dex */
public final class y0 implements Animation.AnimationListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f3223a;

    public y0(TextView textView) {
        this.f3223a = textView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        this.f3223a.clearAnimation();
        this.f3223a.setSelected(true);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
    }
}
