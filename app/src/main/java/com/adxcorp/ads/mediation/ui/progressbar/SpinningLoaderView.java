package com.adxcorp.ads.mediation.ui.progressbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: classes2.dex */
public class SpinningLoaderView extends View {
    private ValueAnimator animator;
    private Paint paint;
    private int spinnerColor;
    private float startAngle;
    private float sweepAngle;

    public SpinningLoaderView(Context context) {
        super(context);
        this.paint = new Paint(1);
        this.sweepAngle = 270.0f;
        this.startAngle = 0.0f;
        this.spinnerColor = Color.parseColor("#FF4081");
        init();
    }

    public SpinningLoaderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.paint = new Paint(1);
        this.sweepAngle = 270.0f;
        this.startAngle = 0.0f;
        this.spinnerColor = Color.parseColor("#FF4081");
        init();
    }

    private void init() {
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(8.0f);
        this.paint.setColor(this.spinnerColor);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 360.0f);
        this.animator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.animator.setRepeatCount(-1);
        this.animator.setInterpolator(new LinearInterpolator());
        this.animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.adxcorp.ads.mediation.ui.progressbar.SpinningLoaderView$$ExternalSyntheticLambda0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                this.f$0.m4351x23504857(valueAnimator);
            }
        });
        this.animator.start();
    }

    /* JADX INFO: renamed from: lambda$init$0$com-adxcorp-ads-mediation-ui-progressbar-SpinningLoaderView, reason: not valid java name */
    /* synthetic */ void m4351x23504857(ValueAnimator valueAnimator) {
        this.startAngle = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawArc(new RectF(12.0f, 12.0f, getWidth() - 12.0f, getHeight() - 12.0f), this.startAngle, this.sweepAngle, false, this.paint);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }
}
