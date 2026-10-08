package com.gomfactory.adpie.sdk.ui.progressbar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import com.gomfactory.adpie.sdk.AdPieSDK;
import com.gomfactory.adpie.sdk.util.AdPieLog;
import com.gomfactory.adpie.sdk.util.DisplayUtil;

/* JADX INFO: loaded from: classes3.dex */
public class CircleProgressBar extends View {
    private static final String TAG = "CircleProgressBar";
    private int centerX;
    private int centerY;
    int color;
    private boolean mIsTimerMode;
    private Paint mPaintProgress;
    private int mProgress;
    private RectF mRectF;
    private int max;
    private Paint paint;
    private Path path;
    private int swipeAndgle;
    private String text;
    private final Rect textBounds;
    private Paint textPaint;

    public CircleProgressBar(Context context) {
        super(context);
        this.textBounds = new Rect();
        this.color = -12269339;
        this.max = 100;
        this.path = new Path();
        this.text = "";
        this.swipeAndgle = 0;
        initUI();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.textBounds = new Rect();
        this.color = -12269339;
        this.max = 100;
        this.path = new Path();
        this.text = "";
        this.swipeAndgle = 0;
        initUI();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.textBounds = new Rect();
        this.color = -12269339;
        this.max = 100;
        this.path = new Path();
        this.text = "";
        this.swipeAndgle = 0;
        initUI();
    }

    public CircleProgressBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.textBounds = new Rect();
        this.color = -12269339;
        this.max = 100;
        this.path = new Path();
        this.text = "";
        this.swipeAndgle = 0;
        initUI();
    }

    private void initUI() {
        Paint paint = new Paint();
        this.paint = paint;
        paint.setAntiAlias(true);
        this.paint.setStrokeWidth(DisplayUtil.dpToPx(getContext(), 1));
        this.paint.setStyle(Paint.Style.STROKE);
        this.paint.setColor(this.color);
        Paint paint2 = new Paint();
        this.mPaintProgress = paint2;
        paint2.setAntiAlias(true);
        this.mPaintProgress.setStyle(Paint.Style.STROKE);
        this.mPaintProgress.setStrokeWidth(DisplayUtil.dpToPx(getContext(), 6));
        this.mPaintProgress.setColor(this.color);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setAntiAlias(true);
        this.textPaint.setStyle(Paint.Style.FILL);
        this.textPaint.setColor(this.color);
        this.textPaint.setStrokeWidth(3.0f);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        try {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            int iMin = (Math.min(size, size2) - DisplayUtil.dpToPx(getContext(), 2)) / 2;
            this.path.reset();
            int i3 = size / 2;
            this.centerX = i3;
            int i4 = size2 / 2;
            this.centerY = i4;
            float f = iMin;
            this.path.addCircle(i3, i4, f, Path.Direction.CW);
            int iDpToPx = iMin - DisplayUtil.dpToPx(getContext(), 5);
            this.path.addCircle(this.centerX, this.centerY, iDpToPx, Path.Direction.CW);
            int iDpToPx2 = iDpToPx + DisplayUtil.dpToPx(getContext(), 2);
            int i5 = this.centerX;
            int i6 = this.centerY;
            this.mRectF = new RectF(i5 - iDpToPx2, i6 - iDpToPx2, i5 + iDpToPx2, i6 + iDpToPx2);
            this.textPaint.setTextSize(f * 0.6f);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            canvas.drawPath(this.path, this.paint);
            canvas.drawArc(this.mRectF, 270.0f, this.swipeAndgle, false, this.mPaintProgress);
            drawTextCentred(canvas);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void drawTextCentred(Canvas canvas) {
        try {
            Paint paint = this.textPaint;
            String str = this.text;
            paint.getTextBounds(str, 0, str.length(), this.textBounds);
            canvas.drawText(this.text, this.centerX - this.textBounds.exactCenterX(), this.centerY - this.textBounds.exactCenterY(), this.textPaint);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

    public void setMax(int i) {
        if (i < 0) {
            this.max = 0;
        } else {
            this.max = i;
        }
    }

    public void setProgress(int i) {
        if (i < 0) {
            this.mProgress = 0;
        } else {
            this.mProgress = i;
        }
        if (this.mIsTimerMode) {
            int i2 = this.max;
            if (i2 == 0) {
                this.swipeAndgle = 0;
                this.text = i + "";
            } else {
                int i3 = ((i2 - this.mProgress) * 100) / i2;
                this.swipeAndgle = ((i3 >= 0 ? i3 : 0) * 360) / 100;
                this.text = i + "";
            }
        } else {
            int i4 = this.max;
            if (i4 == 0) {
                this.swipeAndgle = 0;
                this.text = "0%";
            } else {
                int i5 = (i * 100) / i4;
                this.swipeAndgle = (i5 * 360) / 100;
                this.text = i5 + "%";
            }
        }
        invalidate();
    }

    public void setColor(int i, int i2, int i3) {
        try {
            this.paint.setColor(i);
            this.mPaintProgress.setColor(i2);
            this.textPaint.setColor(i3);
        } catch (Exception e) {
            if (AdPieSDK.getInstance().getConfiguration().isAdpieSdkLog()) {
                AdPieLog.e(TAG, e);
            }
        }
    }

    public void setTimerMode(boolean z) {
        this.mIsTimerMode = z;
    }
}
