package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class exu extends ImageView {
    private boolean exu;
    private volatile boolean fs;
    private float jpc;
    private int lnr;
    private AnimatedImageDrawable mml;
    private boolean mo;
    private boolean mzz;
    private Movie qdl;
    private boolean rdp;
    private int rq;
    private int to;
    private float tvp;
    private long ud;
    private float wd;

    public exu(Context context) {
        super(context);
        this.mzz = Build.VERSION.SDK_INT >= 28;
        this.mo = false;
        this.exu = true;
        this.rdp = true;
        qdl();
    }

    void qdl() {
        if (this.mzz) {
            return;
        }
        setLayerType(1, null);
    }

    private void setDrawable(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        setImageDrawable(drawable);
        if (Build.VERSION.SDK_INT >= 28 && (drawable instanceof AnimatedImageDrawable)) {
            AnimatedImageDrawable animatedImageDrawable = (AnimatedImageDrawable) drawable;
            this.mml = animatedImageDrawable;
            if (!this.fs) {
                animatedImageDrawable.start();
            }
            if (!this.rdp) {
                animatedImageDrawable.setRepeatCount(0);
            }
        }
        ud();
    }

    public void setRepeatConfig(boolean z) {
        AnimatedImageDrawable animatedImageDrawable;
        this.rdp = z;
        if (z) {
            return;
        }
        try {
            if (Build.VERSION.SDK_INT < 28 || (animatedImageDrawable = this.mml) == null) {
                return;
            }
            animatedImageDrawable.setRepeatCount(0);
        } catch (Exception unused) {
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        Movie movie;
        int size;
        int size2;
        super.onMeasure(i, i2);
        if (this.mzz || (movie = this.qdl) == null) {
            return;
        }
        int iWidth = movie.width();
        int iHeight = this.qdl.height();
        float fMax = 1.0f / Math.max((View.MeasureSpec.getMode(i) == 0 || iWidth <= (size2 = View.MeasureSpec.getSize(i))) ? 1.0f : iWidth / size2, (View.MeasureSpec.getMode(i2) == 0 || iHeight <= (size = View.MeasureSpec.getSize(i2))) ? 1.0f : iHeight / size);
        this.tvp = fMax;
        int i3 = (int) (iWidth * fMax);
        this.to = i3;
        int i4 = (int) (iHeight * fMax);
        this.rq = i4;
        setMeasuredDimension(i3, i4);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.qdl != null && !this.mzz) {
            this.wd = (getWidth() - this.to) / 2.0f;
            this.jpc = (getHeight() - this.rq) / 2.0f;
        }
        this.exu = getVisibility() == 0;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.qdl != null && !this.mzz) {
            try {
                if (!this.fs) {
                    lnr();
                    qdl(canvas);
                    ud();
                    return;
                }
                qdl(canvas);
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        super.onDraw(canvas);
    }

    private void ud() {
        if (this.qdl == null || this.mzz || !this.exu) {
            return;
        }
        postInvalidateOnAnimation();
    }

    private void lnr() {
        if (this.qdl == null) {
            return;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.ud == 0) {
            this.ud = jUptimeMillis;
        }
        int iDuration = this.qdl.duration();
        if (iDuration == 0) {
            iDuration = 1000;
        }
        if (!this.rdp && Math.abs(iDuration - this.lnr) < 60) {
            this.lnr = iDuration;
            this.fs = true;
        } else {
            this.lnr = (int) ((jUptimeMillis - this.ud) % ((long) iDuration));
        }
    }

    private void qdl(Canvas canvas) {
        Movie movie = this.qdl;
        if (movie == null) {
            return;
        }
        movie.setTime(this.lnr);
        float f = this.tvp;
        if (f == 0.0f) {
            canvas.scale(1.0f, 1.0f);
            this.qdl.draw(canvas, 0.0f, 0.0f);
        } else {
            canvas.scale(f, f);
            Movie movie2 = this.qdl;
            float f2 = this.wd;
            float f3 = this.tvp;
            movie2.draw(canvas, f2 / f3, this.jpc / f3);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onScreenStateChanged(int i) {
        super.onScreenStateChanged(i);
        if (this.qdl != null) {
            this.exu = i == 1;
            ud();
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (this.qdl != null) {
            this.exu = i == 0;
            ud();
        }
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        if (this.qdl != null) {
            this.exu = i == 0;
            ud();
        }
    }
}
