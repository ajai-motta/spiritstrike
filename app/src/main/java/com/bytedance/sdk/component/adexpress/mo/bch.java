package com.bytedance.sdk.component.adexpress.mo;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.GravityCompat;

/* JADX INFO: loaded from: classes3.dex */
public class bch extends FrameLayout {
    private float jpc;
    private float lnr;
    private float mml;
    private Drawable mo;
    private Drawable mzz;
    LinearLayout qdl;
    LinearLayout ud;
    private double wd;
    private static final int tvp = (com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud("", 0.0f, true)[1] / 2) + 1;
    private static final int to = (com.bytedance.sdk.component.adexpress.dynamic.mzz.rq.ud("", 0.0f, true)[1] / 2) + 3;

    public bch(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.qdl = new LinearLayout(getContext());
        this.ud = new LinearLayout(getContext());
        this.qdl.setOrientation(0);
        this.qdl.setGravity(GravityCompat.START);
        this.ud.setOrientation(0);
        this.ud.setGravity(GravityCompat.START);
        this.mzz = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_star_thick");
        this.mo = com.bytedance.sdk.component.utils.ljh.lnr(context, "tt_star");
    }

    public Drawable getStarEmptyDrawable() {
        return this.mzz;
    }

    public Drawable getStarFillDrawable() {
        return this.mo;
    }

    public void qdl(double d, int i, int i2, int i3) {
        float f = i2;
        this.lnr = (int) com.bytedance.sdk.component.adexpress.mml.wd.lnr(getContext(), f);
        this.mml = (int) com.bytedance.sdk.component.adexpress.mml.wd.lnr(getContext(), f);
        this.wd = d;
        this.jpc = i3;
        removeAllViews();
        for (int i4 = 0; i4 < 5; i4++) {
            ImageView starImageView = getStarImageView();
            starImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView.setColorFilter(i, PorterDuff.Mode.SRC_IN);
            starImageView.setImageDrawable(getStarFillDrawable());
            this.ud.addView(starImageView);
        }
        for (int i5 = 0; i5 < 5; i5++) {
            ImageView starImageView2 = getStarImageView();
            starImageView2.setScaleType(ImageView.ScaleType.FIT_XY);
            starImageView2.setImageDrawable(getStarEmptyDrawable());
            this.qdl.addView(starImageView2);
        }
        addView(this.qdl);
        addView(this.ud);
        requestLayout();
    }

    private ImageView getStarImageView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams((int) this.lnr, (int) this.mml));
        imageView.setPadding(1, tvp, 1, to);
        return imageView;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.qdl.measure(i, i2);
        double d = this.wd;
        float f = this.lnr;
        this.ud.measure(View.MeasureSpec.makeMeasureSpec((int) (((double) ((((int) d) * f) + 1.0f)) + (((double) (f - 2.0f)) * (d - ((double) ((int) d))))), 1073741824), View.MeasureSpec.makeMeasureSpec(this.qdl.getMeasuredHeight(), 1073741824));
        if (this.jpc > 0.0f) {
            this.qdl.setPadding(0, ((int) (r7.getMeasuredHeight() - this.jpc)) / 2, 0, 0);
            this.ud.setPadding(0, ((int) (this.qdl.getMeasuredHeight() - this.jpc)) / 2, 0, 0);
        }
    }
}
