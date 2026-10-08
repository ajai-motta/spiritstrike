package com.gomfactory.adpie.sdk.ui.progressbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public final class CircularProgressBar extends View {
    private static final long DEFAULT_ANIMATION_DURATION = 1500;
    private static final float DEFAULT_MAX_VALUE = 100.0f;
    private static final float DEFAULT_START_ANGLE = 270.0f;
    private Paint backgroundPaint;
    private int backgroundProgressBarColor;
    private GradientDirection backgroundProgressBarColorDirection;
    private Integer backgroundProgressBarColorEnd;
    private Integer backgroundProgressBarColorStart;
    private float backgroundProgressBarWidth;
    private Paint foregroundPaint;
    private boolean indeterminateMode;
    private Handler indeterminateModeHandler;
    private final Runnable indeterminateModeRunnable;
    private Paint innerCirclePaint;
    private float progress;
    private ValueAnimator progressAnimator;
    private int progressBarColor;
    private GradientDirection progressBarColorDirection;
    private Integer progressBarColorEnd;
    private Integer progressBarColorStart;
    private float progressBarWidth;
    private ProgressDirection progressDirection;
    private ProgressDirection progressDirectionIndeterminateMode;
    private float progressIndeterminateMode;
    private float progressMax;
    private RectF rectF;
    private boolean roundBorder;
    private float startAngle;
    private float startAngleIndeterminateMode;

    private void init(Context context, AttributeSet attributeSet) {
    }

    public void setCircleBackgroundColor(int i) {
        this.innerCirclePaint.setColor(i);
        invalidate();
    }

    public void setProgressWithAnimation(float f, Long l, TimeInterpolator timeInterpolator) {
        setProgressWithAnimation$default(this, f, l, timeInterpolator, null, 8, null);
    }

    public void setProgressWithAnimation(float f, Long l) {
        setProgressWithAnimation$default(this, f, l, null, null, 12, null);
    }

    public void setProgressWithAnimation(float f) {
        setProgressWithAnimation$default(this, f, null, null, null, 14, null);
    }

    public CircularProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.rectF = new RectF();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        this.backgroundPaint = paint;
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setStyle(Paint.Style.STROKE);
        this.foregroundPaint = paint2;
        this.progressMax = 100.0f;
        this.progressBarColor = -16777216;
        this.progressBarColorDirection = GradientDirection.LEFT_TO_RIGHT;
        this.backgroundProgressBarColor = -7829368;
        this.backgroundProgressBarColorDirection = GradientDirection.LEFT_TO_RIGHT;
        this.startAngle = DEFAULT_START_ANGLE;
        this.progressDirection = ProgressDirection.TO_RIGHT;
        this.progressDirectionIndeterminateMode = ProgressDirection.TO_RIGHT;
        this.startAngleIndeterminateMode = DEFAULT_START_ANGLE;
        Paint paint3 = new Paint();
        paint3.setAntiAlias(true);
        paint3.setStyle(Paint.Style.FILL);
        this.innerCirclePaint = paint3;
        this.indeterminateModeRunnable = new Runnable() { // from class: com.gomfactory.adpie.sdk.ui.progressbar.CircularProgressBar.1
            @Override // java.lang.Runnable
            public final void run() {
                if (CircularProgressBar.this.getIndeterminateMode()) {
                    CircularProgressBar.this.postIndeterminateModeHandler();
                    CircularProgressBar circularProgressBar = CircularProgressBar.this;
                    circularProgressBar.setProgressDirectionIndeterminateMode(circularProgressBar.reverse(circularProgressBar.progressDirectionIndeterminateMode));
                    CircularProgressBar circularProgressBar2 = CircularProgressBar.this;
                    if (circularProgressBar2.isToRight(circularProgressBar2.progressDirectionIndeterminateMode)) {
                        CircularProgressBar.setProgressWithAnimation$default(CircularProgressBar.this, 0.0f, Long.valueOf(CircularProgressBar.DEFAULT_ANIMATION_DURATION), null, null, 12, null);
                    } else {
                        CircularProgressBar circularProgressBar3 = CircularProgressBar.this;
                        CircularProgressBar.setProgressWithAnimation$default(circularProgressBar3, circularProgressBar3.getProgressMax(), Long.valueOf(CircularProgressBar.DEFAULT_ANIMATION_DURATION), null, null, 12, null);
                    }
                }
            }
        };
        init(context, attributeSet);
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float f) {
        float f2 = this.progress;
        float f3 = this.progressMax;
        if (f2 > f3) {
            f = f3;
        }
        this.progress = f;
        invalidate();
    }

    public float getProgressMax() {
        return this.progressMax;
    }

    public void setProgressMax(float f) {
        if (this.progressMax < 0.0f) {
            f = 100.0f;
        }
        this.progressMax = f;
        invalidate();
    }

    public float getProgressBarWidth() {
        return this.progressBarWidth;
    }

    public void setProgressBarWidth(float f) {
        float fDpToPx = dpToPx(f);
        this.progressBarWidth = fDpToPx;
        this.foregroundPaint.setStrokeWidth(fDpToPx);
        requestLayout();
        invalidate();
    }

    public float getBackgroundProgressBarWidth() {
        return this.backgroundProgressBarWidth;
    }

    public void setBackgroundProgressBarWidth(float f) {
        float fDpToPx = dpToPx(f);
        this.backgroundProgressBarWidth = fDpToPx;
        this.backgroundPaint.setStrokeWidth(fDpToPx);
        requestLayout();
        invalidate();
    }

    public int getProgressBarColor() {
        return this.progressBarColor;
    }

    public void setProgressBarColor(int i) {
        this.progressBarColor = i;
        manageColor();
        invalidate();
    }

    public Integer getProgressBarColorStart() {
        return this.progressBarColorStart;
    }

    public void setProgressBarColorStart(Integer num) {
        this.progressBarColorStart = num;
        manageColor();
        invalidate();
    }

    public Integer getProgressBarColorEnd() {
        return this.progressBarColorEnd;
    }

    public void setProgressBarColorEnd(Integer num) {
        this.progressBarColorEnd = num;
        manageColor();
        invalidate();
    }

    public GradientDirection getProgressBarColorDirection() {
        return this.progressBarColorDirection;
    }

    public void setProgressBarColorDirection(GradientDirection gradientDirection) {
        this.progressBarColorDirection = gradientDirection;
        manageColor();
        invalidate();
    }

    public int getBackgroundProgressBarColor() {
        return this.backgroundProgressBarColor;
    }

    public void setBackgroundProgressBarColor(int i) {
        this.backgroundProgressBarColor = i;
        manageBackgroundProgressBarColor();
        invalidate();
    }

    public Integer getBackgroundProgressBarColorStart() {
        return this.backgroundProgressBarColorStart;
    }

    public void setBackgroundProgressBarColorStart(Integer num) {
        this.backgroundProgressBarColorStart = num;
        manageBackgroundProgressBarColor();
        invalidate();
    }

    public Integer getBackgroundProgressBarColorEnd() {
        return this.backgroundProgressBarColorEnd;
    }

    public void setBackgroundProgressBarColorEnd(Integer num) {
        this.backgroundProgressBarColorEnd = num;
        manageBackgroundProgressBarColor();
        invalidate();
    }

    public GradientDirection getBackgroundProgressBarColorDirection() {
        return this.backgroundProgressBarColorDirection;
    }

    public void setBackgroundProgressBarColorDirection(GradientDirection gradientDirection) {
        this.backgroundProgressBarColorDirection = gradientDirection;
        manageBackgroundProgressBarColor();
        invalidate();
    }

    public boolean getRoundBorder() {
        return this.roundBorder;
    }

    public void setRoundBorder(boolean z) {
        this.roundBorder = z;
        this.foregroundPaint.setStrokeCap(z ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        invalidate();
    }

    public float getStartAngle() {
        return this.startAngle;
    }

    public void setStartAngle(float f) {
        float f2 = f + DEFAULT_START_ANGLE;
        while (f2 > 360.0f) {
            f2 -= 360.0f;
        }
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 360.0f) {
            f2 = 360.0f;
        }
        this.startAngle = f2;
        invalidate();
    }

    public ProgressDirection getProgressDirection() {
        return this.progressDirection;
    }

    public void setProgressDirection(ProgressDirection progressDirection) {
        this.progressDirection = progressDirection;
        invalidate();
    }

    public boolean getIndeterminateMode() {
        return this.indeterminateMode;
    }

    public void setIndeterminateMode(boolean z) {
        this.indeterminateMode = z;
        setProgressIndeterminateMode(0.0f);
        setProgressDirectionIndeterminateMode(ProgressDirection.TO_RIGHT);
        setStartAngleIndeterminateMode(DEFAULT_START_ANGLE);
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.removeCallbacks(this.indeterminateModeRunnable);
        }
        ValueAnimator valueAnimator = this.progressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler2 = new Handler();
        this.indeterminateModeHandler = handler2;
        if (this.indeterminateMode) {
            handler2.post(this.indeterminateModeRunnable);
        }
    }

    public void setProgressIndeterminateMode(float f) {
        this.progressIndeterminateMode = f;
        invalidate();
    }

    public void setProgressDirectionIndeterminateMode(ProgressDirection progressDirection) {
        this.progressDirectionIndeterminateMode = progressDirection;
        invalidate();
    }

    public void setStartAngleIndeterminateMode(float f) {
        this.startAngleIndeterminateMode = f;
        invalidate();
    }

    public void postIndeterminateModeHandler() {
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.postDelayed(this.indeterminateModeRunnable, DEFAULT_ANIMATION_DURATION);
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.progressAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        Handler handler = this.indeterminateModeHandler;
        if (handler != null) {
            handler.removeCallbacks(this.indeterminateModeRunnable);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        manageColor();
        manageBackgroundProgressBarColor();
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        canvas.drawCircle(width, height, Math.min(width, height) - (Math.max(this.progressBarWidth, this.backgroundProgressBarWidth) / 2.0f), this.innerCirclePaint);
        canvas.drawOval(this.rectF, this.backgroundPaint);
        boolean z = this.indeterminateMode;
        canvas.drawArc(this.rectF, this.indeterminateMode ? this.startAngleIndeterminateMode : this.startAngle, ((((z && isToRight(this.progressDirectionIndeterminateMode)) || (!this.indeterminateMode && isToRight(this.progressDirection))) ? 360 : -360) * (((z ? this.progressIndeterminateMode : this.progress) * 100.0f) / this.progressMax)) / 100.0f, false, this.foregroundPaint);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        setBackgroundProgressBarColor(i);
    }

    private void manageColor() {
        Paint paint = this.foregroundPaint;
        Integer num = this.progressBarColorStart;
        int iIntValue = num != null ? num.intValue() : this.progressBarColor;
        Integer num2 = this.progressBarColorEnd;
        paint.setShader(createLinearGradient(iIntValue, num2 != null ? num2.intValue() : this.progressBarColor, this.progressBarColorDirection));
    }

    private void manageBackgroundProgressBarColor() {
        Paint paint = this.backgroundPaint;
        Integer num = this.backgroundProgressBarColorStart;
        int iIntValue = num != null ? num.intValue() : this.backgroundProgressBarColor;
        Integer num2 = this.backgroundProgressBarColorEnd;
        paint.setShader(createLinearGradient(iIntValue, num2 != null ? num2.intValue() : this.backgroundProgressBarColor, this.backgroundProgressBarColorDirection));
    }

    /* JADX INFO: renamed from: com.gomfactory.adpie.sdk.ui.progressbar.CircularProgressBar$3, reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] $SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection;

        static {
            int[] iArr = new int[GradientDirection.values().length];
            $SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection = iArr;
            try {
                iArr[GradientDirection.LEFT_TO_RIGHT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection[GradientDirection.RIGHT_TO_LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection[GradientDirection.TOP_TO_BOTTOM.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection[GradientDirection.BOTTOM_TO_END.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private LinearGradient createLinearGradient(int i, int i2, GradientDirection gradientDirection) {
        float width;
        float width2;
        float height;
        float height2;
        int i3 = AnonymousClass3.$SwitchMap$com$gomfactory$adpie$sdk$ui$progressbar$CircularProgressBar$GradientDirection[gradientDirection.ordinal()];
        if (i3 != 1) {
            if (i3 == 2) {
                width2 = getWidth();
                height = 0.0f;
            } else if (i3 == 3) {
                height2 = getHeight();
                width2 = 0.0f;
                height = 0.0f;
                width = 0.0f;
            } else if (i3 != 4) {
                width2 = 0.0f;
                height = 0.0f;
            } else {
                height = getHeight();
                width2 = 0.0f;
                width = 0.0f;
                height2 = width;
            }
            width = height;
            height2 = width;
        } else {
            width = getWidth();
            width2 = 0.0f;
            height = 0.0f;
            height2 = 0.0f;
        }
        return new LinearGradient(width2, height, width, height2, i, i2, Shader.TileMode.CLAMP);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int iMin = Math.min(View.getDefaultSize(getSuggestedMinimumWidth(), i), View.getDefaultSize(getSuggestedMinimumHeight(), i2));
        setMeasuredDimension(iMin, iMin);
        float f = this.progressBarWidth;
        float f2 = this.backgroundProgressBarWidth;
        if (f <= f2) {
            f = f2;
        }
        float f3 = f / 2.0f;
        float f4 = 0.0f + f3;
        float f5 = iMin - f3;
        this.rectF.set(f4, f4, f5, f5);
    }

    public static void setProgressWithAnimation$default(CircularProgressBar circularProgressBar, float f, Long l, TimeInterpolator timeInterpolator, Long l2, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        if ((i & 4) != 0) {
            timeInterpolator = null;
        }
        if ((i & 8) != 0) {
            l2 = null;
        }
        circularProgressBar.setProgressWithAnimation(f, l, timeInterpolator, l2);
    }

    public void setProgressWithAnimation(float f, Long l, TimeInterpolator timeInterpolator, Long l2) {
        ValueAnimator valueAnimator;
        ValueAnimator valueAnimator2 = this.progressAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.cancel();
        }
        float[] fArr = new float[2];
        fArr[0] = this.indeterminateMode ? this.progressIndeterminateMode : this.progress;
        fArr[1] = f;
        this.progressAnimator = ValueAnimator.ofFloat(fArr);
        if (l != null) {
            long jLongValue = l.longValue();
            ValueAnimator valueAnimator3 = this.progressAnimator;
            if (valueAnimator3 != null) {
                valueAnimator3.setDuration(jLongValue);
            }
        }
        if (timeInterpolator != null && (valueAnimator = this.progressAnimator) != null) {
            valueAnimator.setInterpolator(timeInterpolator);
        }
        if (l2 != null) {
            long jLongValue2 = l2.longValue();
            ValueAnimator valueAnimator4 = this.progressAnimator;
            if (valueAnimator4 != null) {
                valueAnimator4.setStartDelay(jLongValue2);
            }
        }
        ValueAnimator valueAnimator5 = this.progressAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.gomfactory.adpie.sdk.ui.progressbar.CircularProgressBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator6) {
                    Object animatedValue = valueAnimator6.getAnimatedValue();
                    if (!(animatedValue instanceof Float)) {
                        animatedValue = null;
                    }
                    Float f2 = (Float) animatedValue;
                    if (f2 != null) {
                        float fFloatValue = f2.floatValue();
                        if (CircularProgressBar.this.getIndeterminateMode()) {
                            CircularProgressBar.this.setProgressIndeterminateMode(fFloatValue);
                        } else {
                            CircularProgressBar.this.setProgress(fFloatValue);
                        }
                        if (CircularProgressBar.this.getIndeterminateMode()) {
                            float f3 = (fFloatValue * 360.0f) / 100.0f;
                            CircularProgressBar circularProgressBar = CircularProgressBar.this;
                            if (!circularProgressBar.isToRight(circularProgressBar.progressDirectionIndeterminateMode)) {
                                f3 = -f3;
                            }
                            circularProgressBar.setStartAngleIndeterminateMode(f3 + CircularProgressBar.DEFAULT_START_ANGLE);
                        }
                    }
                }
            });
        }
        ValueAnimator valueAnimator6 = this.progressAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.start();
        }
    }

    private float dpToPx(float f) {
        return f * Resources.getSystem().getDisplayMetrics().density;
    }

    private float pxToDp(float f) {
        return f / Resources.getSystem().getDisplayMetrics().density;
    }

    private ProgressDirection toProgressDirection(int i) {
        if (i == 1) {
            return ProgressDirection.TO_RIGHT;
        }
        if (i == 2) {
            return ProgressDirection.TO_LEFT;
        }
        throw new IllegalArgumentException("This value is not supported for ProgressDirection: " + i);
    }

    public ProgressDirection reverse(ProgressDirection progressDirection) {
        return isToRight(progressDirection) ? ProgressDirection.TO_LEFT : ProgressDirection.TO_RIGHT;
    }

    public boolean isToRight(ProgressDirection progressDirection) {
        return progressDirection == ProgressDirection.TO_RIGHT;
    }

    private GradientDirection toGradientDirection(int i) {
        if (i == 1) {
            return GradientDirection.LEFT_TO_RIGHT;
        }
        if (i == 2) {
            return GradientDirection.RIGHT_TO_LEFT;
        }
        if (i == 3) {
            return GradientDirection.TOP_TO_BOTTOM;
        }
        if (i == 4) {
            return GradientDirection.BOTTOM_TO_END;
        }
        throw new IllegalArgumentException("This value is not supported for GradientDirection: " + i);
    }

    public enum ProgressDirection {
        TO_RIGHT(1),
        TO_LEFT(2);

        private final int value;

        public final int getValue() {
            return this.value;
        }

        ProgressDirection(int i) {
            this.value = i;
        }
    }

    public enum GradientDirection {
        LEFT_TO_RIGHT(1),
        RIGHT_TO_LEFT(2),
        TOP_TO_BOTTOM(3),
        BOTTOM_TO_END(4);

        private final int value;

        public final int getValue() {
            return this.value;
        }

        GradientDirection(int i) {
            this.value = i;
        }
    }
}
