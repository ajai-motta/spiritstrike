package com.bytedance.sdk.component.adexpress.dynamic.animation.qdl;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class to extends mml {
    private qdl mml;
    private float mo;
    private float mzz;

    public to(View view, com.bytedance.sdk.component.adexpress.dynamic.mml.qdl qdlVar) {
        super(view, qdlVar);
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.mml
    List<ObjectAnimator> qdl() {
        int i;
        String str;
        if ((this.lnr instanceof ImageView) && (this.lnr.getParent() instanceof com.bytedance.sdk.component.adexpress.dynamic.dynamicview.mzz)) {
            this.lnr = (View) this.lnr.getParent();
        }
        this.lnr.setAlpha(0.0f);
        ObjectAnimator duration = ObjectAnimator.ofFloat(this.lnr, "alpha", 0.0f, 1.0f).setDuration((int) (this.ud.to() * 1000.0d));
        this.mml = new qdl(this.lnr);
        final int i2 = this.lnr.getLayoutParams().height;
        this.mzz = i2;
        this.mo = this.lnr.getLayoutParams().width;
        if ("left".equals(this.ud.qdl()) || TtmlNode.RIGHT.equals(this.ud.qdl())) {
            i = (int) this.mo;
            str = ViewHierarchyConstants.DIMENSION_WIDTH_KEY;
        } else {
            str = ViewHierarchyConstants.DIMENSION_HEIGHT_KEY;
            i = i2;
        }
        ObjectAnimator duration2 = ObjectAnimator.ofInt(this.mml, str, 0, i).setDuration((int) (this.ud.to() * 1000.0d));
        ArrayList arrayList = new ArrayList();
        arrayList.add(qdl(duration));
        arrayList.add(qdl(duration2));
        ((ObjectAnimator) arrayList.get(0)).addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.dynamic.animation.qdl.to.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator, boolean z) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                to.this.mml.qdl(i2);
            }
        });
        return arrayList;
    }

    private class qdl {
        private View ud;

        public qdl(View view) {
            this.ud = view;
        }

        public void qdl(int i) {
            if (ViewHierarchyConstants.DIMENSION_TOP_KEY.equals(to.this.ud.qdl())) {
                if (to.this.lnr instanceof ViewGroup) {
                    for (int i2 = 0; i2 < ((ViewGroup) to.this.lnr).getChildCount(); i2++) {
                        ((ViewGroup) to.this.lnr).getChildAt(i2).setTranslationY(i - to.this.mzz);
                    }
                }
                to.this.lnr.setTranslationY(to.this.mzz - i);
                return;
            }
            ViewGroup.LayoutParams layoutParams = this.ud.getLayoutParams();
            layoutParams.height = i;
            this.ud.setLayoutParams(layoutParams);
            this.ud.requestLayout();
        }
    }
}
