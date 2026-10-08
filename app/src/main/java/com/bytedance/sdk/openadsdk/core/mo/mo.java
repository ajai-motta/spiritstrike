package com.bytedance.sdk.openadsdk.core.mo;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RotateDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import com.google.android.exoplayer2.ExoPlayer;

/* JADX INFO: loaded from: classes3.dex */
public class mo extends FrameLayout {
    private boolean jpc;
    private Drawable lnr;
    private Drawable mml;
    private boolean mo;
    private Drawable mzz;
    private int qdl;
    private int ud;
    private ValueAnimator wd;

    public void setProgress(int i) {
        this.ud = i;
        Drawable drawable = this.lnr;
        if (drawable != null) {
            drawable.setLevel((int) ((i * 10000.0f) / this.qdl));
        }
    }

    public void setMax(int i) {
        this.qdl = i;
    }

    public void setProgressDrawable(Drawable drawable) {
        this.mml = drawable;
        setBackground(drawable);
        Drawable drawable2 = this.mml;
        if (drawable2 instanceof LayerDrawable) {
            int numberOfLayers = ((LayerDrawable) drawable2).getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                Drawable drawable3 = ((LayerDrawable) this.mml).getDrawable(i);
                if ((drawable3 instanceof ScaleDrawable) || (drawable3 instanceof ClipDrawable)) {
                    this.lnr = drawable3;
                }
            }
        }
        Drawable drawable4 = this.mml;
        if (drawable4 instanceof RotateDrawable) {
            this.lnr = drawable4;
        }
    }

    public void setIndeterminateDrawable(Drawable drawable) {
        this.mzz = drawable;
        setProgressDrawable(drawable);
        if (this.mo && this.wd == null) {
            qdl();
        }
    }

    public mo(Context context) {
        super(context);
        this.qdl = 100;
    }

    public mo(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.qdl = 100;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(tvp.qdl(this, layoutParams));
    }

    @Override // android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mo = true;
        if (this.mzz != null) {
            qdl();
        }
    }

    private void qdl() {
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(0, 10000);
        this.wd = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        this.wd.setRepeatCount(-1);
        this.wd.setInterpolator(new LinearInterpolator());
        this.wd.setRepeatMode(1);
        this.wd.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.mo.mo.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                mo.this.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
            }
        });
        this.wd.start();
        setMax(10000);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mo = false;
        ValueAnimator valueAnimator = this.wd;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.wd.removeAllUpdateListeners();
            this.wd = null;
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            if (this.jpc) {
                this.jpc = false;
                ValueAnimator valueAnimator = this.wd;
                if (valueAnimator != null) {
                    valueAnimator.resume();
                    return;
                } else {
                    qdl();
                    return;
                }
            }
            return;
        }
        if (this.wd == null || this.jpc) {
            return;
        }
        this.jpc = true;
        this.wd.pause();
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }
}
