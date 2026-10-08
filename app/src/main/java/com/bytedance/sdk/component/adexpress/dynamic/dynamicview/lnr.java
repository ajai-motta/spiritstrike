package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes3.dex */
public class lnr extends mo {
    private int aaj;
    private boolean jyq;
    private Runnable oth;
    ObjectAnimator qdl;
    ObjectAnimator ud;

    public lnr(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.aaj = 0;
        this.jyq = false;
        this.oth = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lnr.1
            @Override // java.lang.Runnable
            public void run() {
                lnr.this.qdl();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl() {
        final View childAt;
        final View childAt2 = getChildAt(this.aaj);
        if (childAt2 == null) {
            return;
        }
        int i = this.aaj;
        if (i == 0) {
            this.jyq = false;
        }
        if (i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.aaj + 1)).getChildCount() <= 0) {
            this.jyq = true;
            childAt = getChildAt(this.aaj - 1);
            this.qdl = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (this.wd + getChildAt(this.aaj).getWidth()) / 2);
        } else {
            childAt = getChildAt(this.aaj + 1);
            this.qdl = ObjectAnimator.ofFloat(childAt2, "translationX", 0.0f, (-(this.wd + getChildAt(this.aaj).getWidth())) / 2);
        }
        if (childAt == null) {
            return;
        }
        this.qdl.setInterpolator(new LinearInterpolator());
        this.qdl.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lnr.2
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
                childAt2.setVisibility(8);
            }
        });
        if (this.jyq) {
            this.ud = ObjectAnimator.ofFloat(childAt, "translationX", (-(this.wd + childAt.getWidth())) / 2, 0.0f);
        } else {
            this.ud = ObjectAnimator.ofFloat(childAt, "translationX", (this.wd + childAt.getWidth()) / 2, 0.0f);
        }
        this.ud.setInterpolator(new LinearInterpolator());
        this.ud.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.lnr.3
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
                childAt.setVisibility(0);
            }
        });
        this.qdl.setDuration(500L);
        this.ud.setDuration(500L);
        this.qdl.start();
        this.ud.start();
        if (this.jyq) {
            this.aaj--;
        } else {
            this.aaj++;
        }
        postDelayed(this.oth, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
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
        postDelayed(this.oth, 2500L);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz, com.bytedance.sdk.component.adexpress.dynamic.dynamicview.hzv
    public void ud() {
        removeCallbacks(this.oth);
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
