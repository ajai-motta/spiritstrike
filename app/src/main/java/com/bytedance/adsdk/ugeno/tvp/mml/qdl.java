package com.bytedance.adsdk.ugeno.tvp.mml;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Shader;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.util.Log;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.IAnimation;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.qdl.jpc;
import com.bytedance.adsdk.ugeno.qdl.wd;

/* JADX INFO: loaded from: classes2.dex */
public class qdl extends ImageView implements IAnimation, wd {
    static final /* synthetic */ boolean ud = true;
    private mml aaj;
    private int bjy;
    private Shader.TileMode exc;
    private boolean exu;
    private boolean fs;
    private Shader.TileMode jl;
    private float jpc;
    private int jtx;
    private jpc jyq;
    private float lnr;
    private Drawable mo;
    private final float[] mzz;
    private boolean rdp;
    private Drawable rq;
    private boolean to;
    private ColorFilter tvp;
    private ColorStateList wd;
    private ImageView.ScaleType yt;
    public static final Shader.TileMode qdl = Shader.TileMode.CLAMP;
    private static final ImageView.ScaleType[] mml = {ImageView.ScaleType.MATRIX, ImageView.ScaleType.FIT_XY, ImageView.ScaleType.FIT_START, ImageView.ScaleType.FIT_CENTER, ImageView.ScaleType.FIT_END, ImageView.ScaleType.CENTER, ImageView.ScaleType.CENTER_CROP, ImageView.ScaleType.CENTER_INSIDE};

    public qdl(Context context) {
        super(context);
        this.mzz = new float[]{0.0f, 0.0f, 0.0f, 0.0f};
        this.wd = ColorStateList.valueOf(-16777216);
        this.jpc = 0.0f;
        this.tvp = null;
        this.to = false;
        this.fs = false;
        this.exu = false;
        this.rdp = false;
        Shader.TileMode tileMode = qdl;
        this.jl = tileMode;
        this.exc = tileMode;
        this.jyq = new jpc(this);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        invalidate();
    }

    @Override // android.widget.ImageView
    public ImageView.ScaleType getScaleType() {
        return this.yt;
    }

    @Override // android.widget.ImageView
    public void setScaleType(ImageView.ScaleType scaleType) {
        if (!ud && scaleType == null) {
            throw new AssertionError();
        }
        if (this.yt != scaleType) {
            this.yt = scaleType;
            int i = AnonymousClass1.qdl[scaleType.ordinal()];
            if (i == 1 || i == 2 || i == 3 || i == 4) {
                super.setScaleType(scaleType);
            } else {
                super.setScaleType(ImageView.ScaleType.FIT_XY);
            }
            lnr();
            qdl(false);
            invalidate();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.adsdk.ugeno.tvp.mml.qdl$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] qdl;

        static {
            int[] iArr = new int[ImageView.ScaleType.values().length];
            qdl = iArr;
            try {
                iArr[ImageView.ScaleType.FIT_CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                qdl[ImageView.ScaleType.FIT_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                qdl[ImageView.ScaleType.FIT_END.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                qdl[ImageView.ScaleType.FIT_XY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                qdl[ImageView.ScaleType.CENTER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                qdl[ImageView.ScaleType.CENTER_CROP.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                qdl[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        this.bjy = 0;
        this.rq = ud.qdl(drawable);
        lnr();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        this.bjy = 0;
        this.rq = ud.qdl(bitmap);
        lnr();
        super.setImageDrawable(this.rq);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        if (this.bjy != i) {
            this.bjy = i;
            this.rq = qdl();
            lnr();
            super.setImageDrawable(this.rq);
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        setImageDrawable(getDrawable());
    }

    private Drawable qdl() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.bjy;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.bjy, e);
                this.bjy = 0;
            }
        }
        return ud.qdl(drawable);
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        if (this.jtx != i) {
            this.jtx = i;
            Drawable drawableUd = ud();
            this.mo = drawableUd;
            setBackgroundDrawable(drawableUd);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.mo = colorDrawable;
        setBackgroundDrawable(colorDrawable);
    }

    private Drawable ud() {
        Resources resources = getResources();
        Drawable drawable = null;
        if (resources == null) {
            return null;
        }
        int i = this.jtx;
        if (i != 0) {
            try {
                drawable = resources.getDrawable(i);
            } catch (Exception e) {
                Log.w("RoundedImageView", "Unable to find resource: " + this.jtx, e);
                this.jtx = 0;
            }
        }
        return ud.qdl(drawable);
    }

    private void lnr() {
        qdl(this.rq, this.yt);
    }

    private void qdl(boolean z) {
        if (this.rdp) {
            if (z) {
                this.mo = ud.qdl(this.mo);
            }
            qdl(this.mo, ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.tvp != colorFilter) {
            this.tvp = colorFilter;
            this.fs = true;
            this.to = true;
            mml();
            invalidate();
        }
    }

    private void mml() {
        Drawable drawable = this.rq;
        if (drawable == null || !this.to) {
            return;
        }
        Drawable drawableMutate = drawable.mutate();
        this.rq = drawableMutate;
        if (this.fs) {
            drawableMutate.setColorFilter(this.tvp);
        }
    }

    private void qdl(Drawable drawable, ImageView.ScaleType scaleType) {
        if (drawable == null) {
            return;
        }
        if (drawable instanceof ud) {
            ud udVar = (ud) drawable;
            udVar.qdl(scaleType).qdl(this.jpc).qdl(this.wd).qdl(this.exu).qdl(this.jl).ud(this.exc);
            float[] fArr = this.mzz;
            if (fArr != null) {
                udVar.qdl(fArr[0], fArr[1], fArr[2], fArr[3]);
            }
            mml();
            return;
        }
        if (drawable instanceof LayerDrawable) {
            LayerDrawable layerDrawable = (LayerDrawable) drawable;
            int numberOfLayers = layerDrawable.getNumberOfLayers();
            for (int i = 0; i < numberOfLayers; i++) {
                qdl(layerDrawable.getDrawable(i), scaleType);
            }
        }
    }

    @Override // android.view.View
    @Deprecated
    public void setBackgroundDrawable(Drawable drawable) {
        this.mo = drawable;
        qdl(true);
        super.setBackgroundDrawable(this.mo);
    }

    public float getCornerRadius() {
        return getMaxCornerRadius();
    }

    public float getMaxCornerRadius() {
        float fMax = 0.0f;
        for (float f : this.mzz) {
            fMax = Math.max(f, fMax);
        }
        return fMax;
    }

    public void setCornerRadiusDimen(int i) {
        float dimension = getResources().getDimension(i);
        qdl(dimension, dimension, dimension, dimension);
    }

    public void setCornerRadius(float f) {
        qdl(f, f, f, f);
    }

    public void qdl(float f, float f2, float f3, float f4) {
        float[] fArr = this.mzz;
        if (fArr[0] == f && fArr[1] == f2 && fArr[2] == f4 && fArr[3] == f3) {
            return;
        }
        fArr[0] = f;
        fArr[1] = f2;
        fArr[3] = f3;
        fArr[2] = f4;
        lnr();
        qdl(false);
        invalidate();
    }

    public float getBorderWidth() {
        return this.jpc;
    }

    public void setBorderWidth(int i) {
        setBorderWidth(getResources().getDimension(i));
    }

    public void setBorderWidth(float f) {
        if (this.jpc == f) {
            return;
        }
        this.jpc = f;
        lnr();
        qdl(false);
        invalidate();
    }

    public int getBorderColor() {
        return this.wd.getDefaultColor();
    }

    public void setBorderColor(int i) {
        setBorderColor(ColorStateList.valueOf(i));
    }

    public ColorStateList getBorderColors() {
        return this.wd;
    }

    public void setBorderColor(ColorStateList colorStateList) {
        if (this.wd.equals(colorStateList)) {
            return;
        }
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(-16777216);
        }
        this.wd = colorStateList;
        lnr();
        qdl(false);
        if (this.jpc > 0.0f) {
            invalidate();
        }
    }

    public void setOval(boolean z) {
        this.exu = z;
        lnr();
        qdl(false);
        invalidate();
    }

    public Shader.TileMode getTileModeX() {
        return this.jl;
    }

    public void setTileModeX(Shader.TileMode tileMode) {
        if (this.jl == tileMode) {
            return;
        }
        this.jl = tileMode;
        lnr();
        qdl(false);
        invalidate();
    }

    public Shader.TileMode getTileModeY() {
        return this.exc;
    }

    public void setTileModeY(Shader.TileMode tileMode) {
        if (this.exc == tileMode) {
            return;
        }
        this.exc = tileMode;
        lnr();
        qdl(false);
        invalidate();
    }

    public void qdl(mml mmlVar) {
        this.aaj = mmlVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            int[] iArrQdl = mmlVar.qdl(i, i2);
            super.onMeasure(iArrQdl[0], iArrQdl[1]);
        } else {
            super.onMeasure(i, i2);
        }
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.qdl(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.qdl(canvas, this);
            this.aaj.qdl(canvas);
        }
    }

    @Override // android.view.View
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.ud(canvas);
        }
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i3);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.aaj;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation, com.bytedance.adsdk.ugeno.qdl.wd
    public float getRipple() {
        return this.lnr;
    }

    public void setShine(float f) {
        jpc jpcVar = this.jyq;
        if (jpcVar != null) {
            jpcVar.lnr(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getShine() {
        return this.jyq.getShine();
    }

    public void setStretch(float f) {
        jpc jpcVar = this.jyq;
        if (jpcVar != null) {
            jpcVar.mml(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getStretch() {
        return this.jyq.getStretch();
    }

    public void setRubIn(float f) {
        jpc jpcVar = this.jyq;
        if (jpcVar != null) {
            jpcVar.mzz(f);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.qdl.wd
    public float getRubIn() {
        return this.jyq.getRubIn();
    }

    @Override // com.bytedance.adsdk.ugeno.core.IAnimation
    public void setRipple(float f) {
        this.lnr = f;
        jpc jpcVar = this.jyq;
        if (jpcVar != null) {
            jpcVar.ud(f);
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    public void setBorderRadius(float f) {
        jpc jpcVar = this.jyq;
        if (jpcVar != null) {
            jpcVar.qdl(f);
        }
    }

    public float getBorderRadius() {
        return this.jyq.qdl();
    }
}
