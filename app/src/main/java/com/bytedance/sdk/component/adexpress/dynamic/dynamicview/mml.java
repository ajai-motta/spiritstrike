package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends mo {
    private int aaj;
    private Runnable jyq;
    ObjectAnimator qdl;
    ObjectAnimator ud;

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl() {
        final View childAt = getChildAt(this.aaj);
        final View childAt2 = getChildAt((this.aaj + 1) % getChildCount());
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(childAt, "translationY", 0.0f, (-(this.jpc + getChildAt(this.aaj).getHeight())) / 2);
        this.qdl = objectAnimatorOfFloat;
        objectAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.qdl.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mml.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                childAt.setVisibility(8);
            }
        });
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(childAt2, "translationY", (this.jpc + childAt2.getHeight()) / 2, 0.0f);
        this.ud = objectAnimatorOfFloat2;
        objectAnimatorOfFloat2.setInterpolator(new LinearInterpolator());
        this.ud.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mml.3
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                childAt2.setVisibility(0);
            }
        });
        this.qdl.setDuration(500L);
        this.ud.setDuration(500L);
        this.qdl.start();
        this.ud.start();
        int i = this.aaj + 1;
        this.aaj = i;
        this.aaj = i % getChildCount();
        postDelayed(this.jyq, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
    }

    public mml(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.aaj = 0;
        this.jyq = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mml.1
            @Override // java.lang.Runnable
            public void run() {
                mml.this.qdl();
            }
        };
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mo, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
            layoutParams.topMargin = (this.jpc - layoutParams.height) / 2;
            childAt.setLayoutParams(layoutParams);
            if (i != 0) {
                childAt.setVisibility(8);
            }
        }
        postDelayed(this.jyq, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hzv
    public void ud() {
        removeCallbacks(this.jyq);
        ObjectAnimator objectAnimator = this.qdl;
        if (objectAnimator != null) {
            objectAnimator.removeAllUpdateListeners();
            this.qdl.cancel();
        }
        ObjectAnimator objectAnimator2 = this.ud;
        if (objectAnimator2 != null) {
            objectAnimator2.removeAllUpdateListeners();
            this.ud.cancel();
        }
        super.ud();
    }
}
