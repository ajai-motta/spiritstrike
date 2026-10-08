package com.bytedance.adsdk.ugeno.core;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.bytedance.adsdk.ugeno.core.qdl;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class to {
    private AnimatorSet lnr = new AnimatorSet();
    private View mml;
    private int mo;
    private int mzz;
    Paint qdl;
    private qdl ud;
    private String wd;

    public to(View view, qdl qdlVar) {
        this.mml = view;
        this.ud = qdlVar;
        Paint paint = new Paint();
        this.qdl = paint;
        paint.setAntiAlias(true);
    }

    public void qdl() {
        ObjectAnimator objectAnimator;
        ArrayList arrayList = new ArrayList();
        List<qdl.C0181qdl> listLnr = this.ud.lnr();
        if (listLnr == null || listLnr.size() <= 0) {
            return;
        }
        for (qdl.C0181qdl c0181qdl : listLnr) {
            if (c0181qdl != null) {
                objectAnimator = new ObjectAnimator();
                objectAnimator.setDuration(c0181qdl.qdl());
                if (TextUtils.equals(c0181qdl.mzz(), "translateX")) {
                    objectAnimator.setPropertyName("translationX");
                } else if (TextUtils.equals(c0181qdl.mzz(), "translateY")) {
                    objectAnimator.setPropertyName("translationY");
                } else {
                    objectAnimator.setPropertyName(c0181qdl.mzz());
                }
                objectAnimator.setStartDelay(c0181qdl.mml());
                objectAnimator.setTarget(this.mml);
                if (TextUtils.equals(c0181qdl.mzz(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setIntValues((int) c0181qdl.mo(), (int) c0181qdl.wd());
                    Log.d("UGenAnimation", "playAnimation: from = " + c0181qdl.mo() + "; to=" + c0181qdl.wd());
                } else {
                    objectAnimator.setFloatValues(c0181qdl.mo(), c0181qdl.wd());
                }
                int iUd = (int) this.ud.ud();
                if (iUd != 0) {
                    objectAnimator.setRepeatCount(iUd);
                } else {
                    objectAnimator.setRepeatCount((int) c0181qdl.ud());
                }
                if (TextUtils.equals(c0181qdl.mzz(), TtmlNode.ATTR_TTS_BACKGROUND_COLOR)) {
                    objectAnimator.setEvaluator(new ArgbEvaluator());
                }
                String strMo = this.ud.mo();
                if (TextUtils.isEmpty(strMo)) {
                    strMo = c0181qdl.lnr();
                }
                if (TextUtils.equals(strMo, "reverse")) {
                    objectAnimator.setRepeatMode(2);
                } else {
                    objectAnimator.setRepeatMode(1);
                }
                if (c0181qdl.jpc() != null && c0181qdl.jpc().length > 0) {
                    objectAnimator.setFloatValues(c0181qdl.jpc());
                }
                if (TextUtils.equals(c0181qdl.mzz(), "rotationX")) {
                    this.mml.post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.core.to.1
                        @Override // java.lang.Runnable
                        public void run() {
                            to.this.mml.setPivotX(to.this.mml.getWidth() / 2.0f);
                            to.this.mml.setPivotY(to.this.mml.getHeight());
                        }
                    });
                }
                if (TextUtils.equals(c0181qdl.mzz(), "ripple")) {
                    this.wd = c0181qdl.to();
                }
                String strTvp = c0181qdl.tvp();
                strTvp.hashCode();
                switch (strTvp) {
                    case "accelerate":
                        objectAnimator.setInterpolator(new AccelerateInterpolator());
                        break;
                    case "decelerate":
                        objectAnimator.setInterpolator(new DecelerateInterpolator());
                        break;
                    case "linear":
                    case "standard":
                        objectAnimator.setInterpolator(new LinearInterpolator());
                        break;
                    case "accelerateDecelerate":
                        objectAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                        break;
                }
                arrayList.add(objectAnimator);
            }
        }
        if (this.ud.mml() != 0) {
            this.lnr.setDuration(this.ud.mml());
        }
        this.lnr.setStartDelay(this.ud.mzz());
        if (TextUtils.equals(this.ud.qdl(), "sequentially")) {
            this.lnr.playSequentially(arrayList);
        } else {
            this.lnr.playTogether(arrayList);
        }
        this.lnr.start();
    }

    public void ud() {
        AnimatorSet animatorSet = this.lnr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public void qdl(Canvas canvas, IAnimation iAnimation) {
        try {
            if (iAnimation.getRipple() == 0.0f || TextUtils.isEmpty(this.wd)) {
                return;
            }
            this.qdl.setColor(com.bytedance.adsdk.ugeno.wd.qdl.qdl(this.wd));
            this.qdl.setAlpha(90);
            ((ViewGroup) this.mml.getParent()).setClipChildren(true);
            canvas.drawCircle(this.mzz, this.mo, Math.min(r0, r2) * 2 * iAnimation.getRipple(), this.qdl);
        } catch (Throwable th) {
            Log.d("UGenAnimation", "ripple animation error " + th.getMessage());
        }
    }

    public void qdl(int i, int i2) {
        this.mzz = i / 2;
        this.mo = i2 / 2;
    }
}
