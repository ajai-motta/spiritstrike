package com.bytedance.sdk.component.adexpress.dynamic.animation.qdl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class mzz extends mml {
    public mzz(View view, com.bytedance.sdk.component.adexpress.dynamic.mml.qdl qdlVar) {
        super(view, qdlVar);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:17:0x003d  */
    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mml
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.util.List<android.animation.ObjectAnimator> qdl() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.bytedance.sdk.component.adexpress.dynamic.mml.qdl r1 = r5.ud
            java.lang.String r1 = r1.jyq()
            int r2 = r1.hashCode()
            r3 = 2
            r4 = 1
            switch(r2) {
                case 3029889: goto L33;
                case 3387192: goto L29;
                case 483313230: goto L1f;
                case 1356771568: goto L15;
                default: goto L14;
            }
        L14:
            goto L3d
        L15:
            java.lang.String r2 = "backwards"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = r3
            goto L3e
        L1f:
            java.lang.String r2 = "forwards"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = r4
            goto L3e
        L29:
            java.lang.String r2 = "none"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = 3
            goto L3e
        L33:
            java.lang.String r2 = "both"
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L3d
            r1 = 0
            goto L3e
        L3d:
            r1 = -1
        L3e:
            if (r1 == 0) goto L50
            if (r1 == r4) goto L4c
            if (r1 == r3) goto L48
            r5.lnr(r0)
            goto L53
        L48:
            r5.ud(r0)
            goto L53
        L4c:
            r5.mml(r0)
            goto L53
        L50:
            r5.qdl(r0)
        L53:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mzz.qdl():java.util.List");
    }

    private void qdl(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.ud.aaj())).setDuration(((int) (this.ud.to() * 1000.0d)) / 2);
        duration.setInterpolator(new LinearInterpolator());
        duration.setRepeatMode(2);
        this.ud.mo(this.ud.bjy() * 2);
        list.add(qdl(duration));
    }

    private void ud(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.ud.aaj())).setDuration((int) (this.ud.to() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mzz.1
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
                mzz.this.lnr.setTranslationY(0.0f);
            }
        });
        list.add(qdl(duration));
    }

    private void lnr(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.ud.aaj())).setDuration((int) (this.ud.to() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        duration.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mzz.2
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
                mzz.this.lnr.setTranslationY(0.0f);
            }
        });
        list.add(qdl(duration));
    }

    private void mml(List<ObjectAnimator> list) {
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "translationY", 0.0f, -com.bytedance.sdk.component.adexpress.mml.wd.qdl(com.bytedance.sdk.component.adexpress.mml.qdl(), this.ud.aaj())).setDuration((int) (this.ud.to() * 1000.0d));
        duration.setInterpolator(new BounceInterpolator());
        list.add(qdl(duration));
    }
}
