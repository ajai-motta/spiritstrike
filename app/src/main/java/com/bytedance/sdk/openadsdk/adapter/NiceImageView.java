package com.bytedance.sdk.openadsdk.adapter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.os.Build;
import android.util.AttributeSet;
import com.bytedance.sdk.openadsdk.core.mo.mml;
import com.bytedance.sdk.openadsdk.utils.ax;

/* JADX INFO: loaded from: classes3.dex */
public class NiceImageView extends mml {
    private RectF aaj;
    private Path bch;
    private int bjy;
    private final float[] exc;
    private int exu;
    private int fs;
    private final float[] jl;
    private int jpc;
    private int jtx;
    private final RectF jyq;
    private final Path ljh;
    private boolean lnr;
    private int mml;
    private int mo;
    private int mzz;
    private final Paint oth;
    private final Context qdl;
    private final Xfermode rdp;
    private int rq;
    private int to;
    private int tvp;
    private boolean ud;
    private int wd;
    private float yt;

    public NiceImageView(Context context) {
        this(context, null);
    }

    public NiceImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NiceImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mzz = -1;
        this.wd = -1;
        this.qdl = context;
        this.jpc = ax.ud(context, 10.0f);
        this.jl = new float[8];
        this.exc = new float[8];
        this.jyq = new RectF();
        this.aaj = new RectF();
        this.oth = new Paint();
        this.ljh = new Path();
        if (Build.VERSION.SDK_INT <= 27) {
            this.rdp = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
        } else {
            this.rdp = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
            this.bch = new Path();
        }
        lnr();
        mml();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.bjy = i;
        this.jtx = i2;
        qdl();
        ud();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        canvas.saveLayer(this.aaj, null, 31);
        if (!this.lnr) {
            int i = this.bjy;
            int i2 = this.mml;
            int i3 = this.mo;
            int i4 = this.jtx;
            canvas.scale((((i - (i2 * 2)) - (i3 * 2)) * 1.0f) / i, (((i4 - (i2 * 2)) - (i3 * 2)) * 1.0f) / i4, i / 2.0f, i4 / 2.0f);
        }
        super.onDraw(canvas);
        this.oth.reset();
        this.ljh.reset();
        if (this.ud) {
            this.ljh.addCircle(this.bjy / 2.0f, this.jtx / 2.0f, this.yt, Path.Direction.CCW);
        } else {
            this.ljh.addRoundRect(this.aaj, this.exc, Path.Direction.CCW);
        }
        this.oth.setAntiAlias(true);
        this.oth.setStyle(Paint.Style.FILL);
        this.oth.setXfermode(this.rdp);
        if (Build.VERSION.SDK_INT <= 27) {
            canvas.drawPath(this.ljh, this.oth);
        } else {
            this.bch.addRect(this.aaj, Path.Direction.CCW);
            this.bch.op(this.ljh, Path.Op.DIFFERENCE);
            canvas.drawPath(this.bch, this.oth);
        }
        this.oth.setXfermode(null);
        int i5 = this.exu;
        if (i5 != 0) {
            this.oth.setColor(i5);
            canvas.drawPath(this.ljh, this.oth);
        }
        canvas.restore();
        qdl(canvas);
    }

    private void qdl(Canvas canvas) {
        if (this.ud) {
            int i = this.mml;
            if (i > 0) {
                qdl(canvas, i, this.mzz, this.yt - (i / 2.0f));
            }
            int i2 = this.mo;
            if (i2 > 0) {
                qdl(canvas, i2, this.wd, (this.yt - this.mml) - (i2 / 2.0f));
                return;
            }
            return;
        }
        int i3 = this.mml;
        if (i3 > 0) {
            qdl(canvas, i3, this.mzz, this.jyq, this.jl);
        }
    }

    private void qdl(Canvas canvas, int i, int i2, float f) {
        qdl(i, i2);
        this.ljh.addCircle(this.bjy / 2.0f, this.jtx / 2.0f, f, Path.Direction.CCW);
        canvas.drawPath(this.ljh, this.oth);
    }

    private void qdl(Canvas canvas, int i, int i2, RectF rectF, float[] fArr) {
        qdl(i, i2);
        this.ljh.addRoundRect(rectF, fArr, Path.Direction.CCW);
        canvas.drawPath(this.ljh, this.oth);
    }

    private void qdl(int i, int i2) {
        this.ljh.reset();
        this.oth.setStrokeWidth(i);
        this.oth.setColor(i2);
        this.oth.setStyle(Paint.Style.STROKE);
    }

    private void qdl() {
        if (this.ud) {
            return;
        }
        RectF rectF = this.jyq;
        int i = this.mml;
        rectF.set(i / 2.0f, i / 2.0f, this.bjy - (i / 2.0f), this.jtx - (i / 2.0f));
    }

    private void ud() {
        if (this.ud) {
            float fMin = Math.min(this.bjy, this.jtx) / 2.0f;
            this.yt = fMin;
            RectF rectF = this.aaj;
            int i = this.bjy;
            int i2 = this.jtx;
            rectF.set((i / 2.0f) - fMin, (i2 / 2.0f) - fMin, (i / 2.0f) + fMin, (i2 / 2.0f) + fMin);
            return;
        }
        this.aaj.set(0.0f, 0.0f, this.bjy, this.jtx);
        if (this.lnr) {
            this.aaj = this.jyq;
        }
    }

    private void lnr() {
        if (this.ud) {
            return;
        }
        int i = 0;
        if (this.jpc <= 0) {
            float[] fArr = this.jl;
            int i2 = this.tvp;
            float f = i2;
            fArr[1] = f;
            fArr[0] = f;
            int i3 = this.to;
            float f2 = i3;
            fArr[3] = f2;
            fArr[2] = f2;
            int i4 = this.fs;
            float f3 = i4;
            fArr[5] = f3;
            fArr[4] = f3;
            int i5 = this.rq;
            float f4 = i5;
            fArr[7] = f4;
            fArr[6] = f4;
            float[] fArr2 = this.exc;
            int i6 = this.mml;
            float f5 = i2 - (i6 / 2.0f);
            fArr2[1] = f5;
            fArr2[0] = f5;
            float f6 = i3 - (i6 / 2.0f);
            fArr2[3] = f6;
            fArr2[2] = f6;
            float f7 = i4 - (i6 / 2.0f);
            fArr2[5] = f7;
            fArr2[4] = f7;
            float f8 = i5 - (i6 / 2.0f);
            fArr2[7] = f8;
            fArr2[6] = f8;
            return;
        }
        while (true) {
            float[] fArr3 = this.jl;
            if (i >= fArr3.length) {
                return;
            }
            int i7 = this.jpc;
            fArr3[i] = i7;
            this.exc[i] = i7 - (this.mml / 2.0f);
            i++;
        }
    }

    private void qdl(boolean z) {
        if (z) {
            this.jpc = 0;
        }
        lnr();
        qdl();
        invalidate();
    }

    private void mml() {
        if (this.ud) {
            return;
        }
        this.mo = 0;
    }

    public void isCoverSrc(boolean z) {
        this.lnr = z;
        ud();
        invalidate();
    }

    public void isCircle(boolean z) {
        this.ud = z;
        mml();
        ud();
        invalidate();
    }

    public void setBorderWidth(int i) {
        this.mml = ax.ud(this.qdl, i);
        qdl(false);
    }

    public void setBorderColor(int i) {
        this.mzz = i;
        invalidate();
    }

    public void setInnerBorderWidth(int i) {
        this.mo = ax.ud(this.qdl, i);
        mml();
        invalidate();
    }

    public void setInnerBorderColor(int i) {
        this.wd = i;
        invalidate();
    }

    public void setCornerRadius(int i) {
        this.jpc = ax.ud(this.qdl, i);
        qdl(false);
    }

    public void setCornerTopLeftRadius(int i) {
        this.tvp = ax.ud(this.qdl, i);
        qdl(true);
    }

    public void setCornerTopRightRadius(int i) {
        this.to = ax.ud(this.qdl, i);
        qdl(true);
    }

    public void setCornerBottomLeftRadius(int i) {
        this.rq = ax.ud(this.qdl, i);
        qdl(true);
    }

    public void setCornerBottomRightRadius(int i) {
        this.fs = ax.ud(this.qdl, i);
        qdl(true);
    }

    public void setMaskColor(int i) {
        this.exu = i;
        invalidate();
    }
}
