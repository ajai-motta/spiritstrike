package com.bytedance.adsdk.ugeno.tvp.mzz;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.mml;
import com.bytedance.adsdk.ugeno.wd.jpc;

/* JADX INFO: loaded from: classes2.dex */
public class qdl extends FrameLayout {
    private mml jpc;
    private double lnr;
    private float mml;
    private LinearLayout mo;
    private LinearLayout mzz;
    private float qdl;
    private float ud;
    private Context wd;

    public qdl(Context context) {
        super(context);
        this.wd = context;
        this.mzz = new LinearLayout(context);
        this.mo = new LinearLayout(context);
        this.mzz.setOrientation(0);
        this.mzz.setGravity(GravityCompat.START);
        this.mo.setOrientation(0);
        this.mo.setGravity(GravityCompat.START);
    }

    public void qdl(double d, int i, int i2, float f, int i3) {
        removeAllViews();
        this.mzz.removeAllViews();
        this.mo.removeAllViews();
        this.qdl = (int) jpc.qdl(this.wd, f);
        this.ud = (int) jpc.qdl(this.wd, f);
        this.lnr = d;
        this.mml = i3;
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setImageResource(com.bytedance.adsdk.ugeno.wd.mml.ud(this.wd, "tt_ugen_rating_star"));
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            this.mo.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageResource(com.bytedance.adsdk.ugeno.wd.mml.ud(this.wd, "tt_ugen_rating_star"));
            starImageView2.setColorFilter(i2);
            this.mzz.addView(starImageView2);
        }
        addView(this.mzz);
        addView(this.mo);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) this.qdl, (int) this.ud);
        layoutParams.leftMargin = (int) this.mml;
        layoutParams.topMargin = 0;
        layoutParams.rightMargin = (int) this.mml;
        layoutParams.bottomMargin = 1;
        imageView.setLayoutParams(layoutParams);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        mml mmlVar = this.jpc;
        if (mmlVar != null) {
            mmlVar.qdl(i, i2);
        }
        super.onMeasure(i, i2);
        this.mzz.measure(i, i2);
        double dFloor = Math.floor(this.lnr);
        float f = this.mml;
        float f2 = this.qdl;
        this.mo.measure(View.MeasureSpec.makeMeasureSpec((int) ((((double) (f + f + f2)) * dFloor) + ((double) f) + ((this.lnr - dFloor) * ((double) f2))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.mzz.getMeasuredHeight(), 1073741824));
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        mml mmlVar = this.jpc;
        if (mmlVar != null) {
            mmlVar.qdl(i, i2, i3, i4);
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        mml mmlVar = this.jpc;
        if (mmlVar != null) {
            mmlVar.wd();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mml mmlVar = this.jpc;
        if (mmlVar != null) {
            mmlVar.jpc();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        mml mmlVar = this.jpc;
        if (mmlVar != null) {
            mmlVar.ud(i, i2, i3, i4);
        }
    }

    public void qdl(mml mmlVar) {
        this.jpc = mmlVar;
    }
}
