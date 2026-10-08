package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes3.dex */
public class kdv extends mo {
    private int aaj;
    private boolean jyq;
    private Runnable oth;
    ObjectAnimator qdl;
    ObjectAnimator ud;

    public kdv(Context context, DynamicRootView dynamicRootView, com.bytedance.sdk.component.adexpress.dynamic.mml.jpc jpcVar) {
        super(context, dynamicRootView, jpcVar);
        this.aaj = 0;
        this.jyq = false;
        this.oth = new Runnable() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kdv.1
            @Override // java.lang.Runnable
            public void run() {
                kdv.this.qdl();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qdl() {
        View childAt;
        final View childAt2;
        final View childAt3 = getChildAt(this.aaj);
        int i = this.aaj;
        if (i == 0) {
            this.jyq = false;
        }
        boolean z = i + 1 >= getChildCount() || ((ViewGroup) getChildAt(this.aaj + 1)).getChildCount() <= 0;
        if (!this.exu.to().mzz().qdl() && z) {
            this.jyq = true;
            childAt2 = getChildAt(this.aaj - 1);
            this.qdl = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (this.jpc + getChildAt(this.aaj).getHeight()) / 2);
        } else {
            if (z) {
                childAt = getChildAt((this.aaj + 2) % getChildCount());
            } else {
                childAt = getChildAt((this.aaj + 1) % getChildCount());
            }
            this.qdl = ObjectAnimator.ofFloat(childAt3, "translationY", 0.0f, (-(this.jpc + getChildAt(this.aaj).getHeight())) / 2);
            if (z) {
                this.aaj++;
            }
            childAt2 = childAt;
        }
        this.qdl.setInterpolator(new LinearInterpolator());
        this.qdl.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kdv.2
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
                childAt3.setVisibility(8);
            }
        });
        if (this.jyq) {
            this.ud = ObjectAnimator.ofFloat(childAt2, "translationY", (-(this.jpc + childAt2.getHeight())) / 2, 0.0f);
        } else {
            this.ud = ObjectAnimator.ofFloat(childAt2, "translationY", (this.jpc + childAt2.getHeight()) / 2, 0.0f);
        }
        this.ud.setInterpolator(new LinearInterpolator());
        this.ud.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.dynamicview.kdv.3
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
        if (this.jyq) {
            this.aaj--;
        } else {
            int i2 = this.aaj + 1;
            this.aaj = i2;
            this.aaj = i2 % getChildCount();
        }
        postDelayed(this.oth, 3000L);
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
