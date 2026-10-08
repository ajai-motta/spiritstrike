package com.fyber.inneractive.sdk.ui;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes3.dex */
public final class h implements ValueAnimator.AnimatorUpdateListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IAsmoothProgressBar f1639a;

    public h(IAsmoothProgressBar iAsmoothProgressBar) {
        this.f1639a = iAsmoothProgressBar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        super/*android.widget.ProgressBar*/.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }
}
