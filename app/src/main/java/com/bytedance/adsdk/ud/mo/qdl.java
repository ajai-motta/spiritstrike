package com.bytedance.adsdk.ud.mo;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes.dex */
public abstract class qdl extends ValueAnimator {
    private final Set<ValueAnimator.AnimatorUpdateListener> qdl = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorListener> ud = new CopyOnWriteArraySet();
    private final Set<Animator.AnimatorPauseListener> lnr = new CopyOnWriteArraySet();

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setStartDelay(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public ValueAnimator setDuration(long j) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public void setInterpolator(TimeInterpolator timeInterpolator) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator
    public void addUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.qdl.add(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.qdl.remove(animatorUpdateListener);
    }

    @Override // android.animation.ValueAnimator
    public void removeAllUpdateListeners() {
        this.qdl.clear();
    }

    @Override // android.animation.Animator
    public void addListener(Animator.AnimatorListener animatorListener) {
        this.ud.add(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeListener(Animator.AnimatorListener animatorListener) {
        this.ud.remove(animatorListener);
    }

    @Override // android.animation.Animator
    public void removeAllListeners() {
        this.ud.clear();
    }

    void qdl(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.ud) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationStart(this, z);
            } else {
                animatorListener.onAnimationStart(this);
            }
        }
    }

    @Override // android.animation.Animator
    public void addPauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lnr.add(animatorPauseListener);
    }

    @Override // android.animation.Animator
    public void removePauseListener(Animator.AnimatorPauseListener animatorPauseListener) {
        this.lnr.remove(animatorPauseListener);
    }

    void qdl() {
        Iterator<Animator.AnimatorListener> it = this.ud.iterator();
        while (it.hasNext()) {
            it.next().onAnimationRepeat(this);
        }
    }

    void ud(boolean z) {
        for (Animator.AnimatorListener animatorListener : this.ud) {
            if (Build.VERSION.SDK_INT >= 26) {
                animatorListener.onAnimationEnd(this, z);
            } else {
                animatorListener.onAnimationEnd(this);
            }
        }
    }

    void ud() {
        Iterator<Animator.AnimatorListener> it = this.ud.iterator();
        while (it.hasNext()) {
            it.next().onAnimationCancel(this);
        }
    }

    void lnr() {
        Iterator<ValueAnimator.AnimatorUpdateListener> it = this.qdl.iterator();
        while (it.hasNext()) {
            it.next().onAnimationUpdate(this);
        }
    }

    void mml() {
        Iterator<Animator.AnimatorPauseListener> it = this.lnr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationPause(this);
        }
    }

    void mzz() {
        Iterator<Animator.AnimatorPauseListener> it = this.lnr.iterator();
        while (it.hasNext()) {
            it.next().onAnimationResume(this);
        }
    }
}
