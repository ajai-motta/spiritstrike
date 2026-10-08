package com.bytedance.sdk.openadsdk.component.tvp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.core.widget.PAGLogoView;
import com.bytedance.sdk.openadsdk.core.widget.jtx;
import com.bytedance.sdk.openadsdk.core.widget.yt;
import com.bytedance.sdk.openadsdk.utils.ax;
import com.bytedance.sdk.openadsdk.utils.rq;

/* JADX INFO: loaded from: classes3.dex */
public class mml extends lnr {
    private final com.bytedance.sdk.openadsdk.core.mo.jpc bjy;
    private final com.bytedance.sdk.openadsdk.core.mo.lnr exu;
    private final com.bytedance.sdk.openadsdk.core.mo.mml jtx;
    private final jtx rdp;
    private final com.bytedance.sdk.openadsdk.core.mo.mzz yt;

    public mml(Context context, ljh ljhVar) {
        super(context);
        setId(520093753);
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        setBackgroundColor(0);
        int iUd = ax.ud(context, 8.0f);
        int iUd2 = ax.ud(context, 9.0f);
        int iUd3 = ax.ud(context, 10.0f);
        int iUd4 = ax.ud(context, 40.0f);
        this.fs = new com.bytedance.sdk.openadsdk.core.widget.lnr(context);
        this.fs.setPadding(iUd2, 0, iUd2, 0);
        this.fs.setScaleType(ImageView.ScaleType.FIT_CENTER);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ax.ud(context, 32.0f), ax.ud(context, 14.0f));
        layoutParams.addRule(12);
        layoutParams.addRule(11);
        layoutParams.setMargins(0, 0, iUd3, iUd3);
        this.fs.setLayoutParams(layoutParams);
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
        this.exu = lnrVar;
        lnrVar.setBackgroundColor(-1);
        lnrVar.setId(520093758);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, ax.ud(context, 107.0f));
        layoutParams2.addRule(12);
        lnrVar.setLayoutParams(layoutParams2);
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        mzzVar.setOrientation(0);
        mzzVar.setGravity(16);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 17;
        mzzVar.setLayoutParams(layoutParams3);
        lnrVar.addView(mzzVar);
        this.mo = new yt(context);
        this.mo.setId(520093759);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(iUd4, iUd4);
        layoutParams4.rightMargin = iUd;
        layoutParams4.setMarginEnd(iUd);
        this.mo.setLayoutParams(layoutParams4);
        this.wd = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.wd.setId(520093761);
        this.wd.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        this.wd.setEllipsize(TextUtils.TruncateAt.END);
        this.wd.setMaxLines(2);
        this.wd.setTextColor(Color.parseColor("#161823"));
        this.wd.setTextSize(30.0f);
        mzzVar.addView(this.mo);
        mzzVar.addView(this.wd);
        com.bytedance.sdk.openadsdk.core.mo.lnr lnrVar2 = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams(-1, -1);
        layoutParams5.addRule(2, lnrVar.getId());
        layoutParams5.addRule(10);
        lnrVar2.setLayoutParams(layoutParams5);
        this.qdl = new com.bytedance.sdk.openadsdk.core.mo.mml(context);
        this.qdl.setId(520093754);
        this.qdl.setScaleType(ImageView.ScaleType.CENTER_CROP);
        lnrVar2.addView(this.qdl, new FrameLayout.LayoutParams(-1, -1));
        this.ud = new com.bytedance.sdk.openadsdk.core.mo.lnr(context);
        this.ud.setId(520093755);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        layoutParams6.gravity = 17;
        lnrVar2.addView(this.ud, layoutParams6);
        this.lnr = new com.bytedance.sdk.openadsdk.core.mo.mml(context);
        this.lnr.setId(520093756);
        lnrVar2.addView(this.lnr, new FrameLayout.LayoutParams(-1, -1));
        this.mzz = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.mzz.setId(520093717);
        this.mzz.setBackground(rq.qdl(context, Color.parseColor("#b3000000"), 24));
        this.mzz.setEllipsize(TextUtils.TruncateAt.END);
        this.mzz.setGravity(17);
        this.mzz.setSingleLine(true);
        this.mzz.setText(com.bytedance.sdk.component.utils.ljh.qdl(context, "tt_video_download_apk"));
        this.mzz.setTextColor(-1);
        this.mzz.setTextSize(1, 16.0f);
        this.mzz.setTag("open_ad_click_button_tag");
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(ax.ud(context, 236.0f), ax.ud(context, 48.0f));
        layoutParams7.gravity = 81;
        layoutParams7.bottomMargin = ax.ud(context, 32.0f);
        lnrVar2.addView(this.mzz, layoutParams7);
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar2 = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        this.yt = mzzVar2;
        mzzVar2.setOrientation(0);
        mzzVar2.setGravity(16);
        mzzVar2.setBackground(new qdl(context));
        mzzVar2.setPadding(ax.ud(context, 16.0f), ax.ud(context, 8.0f), ax.ud(context, 16.0f), ax.ud(context, 8.0f));
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams8.addRule(10);
        layoutParams8.topMargin = ax.ud(context, 90.0f);
        mzzVar2.setLayoutParams(layoutParams8);
        yt ytVar = new yt(context);
        this.jtx = ytVar;
        mzzVar2.addView(ytVar, new LinearLayout.LayoutParams(ax.ud(context, 36.0f), ax.ud(context, 36.0f)));
        com.bytedance.sdk.openadsdk.core.mo.mzz mzzVar3 = new com.bytedance.sdk.openadsdk.core.mo.mzz(context);
        mzzVar3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams9.leftMargin = ax.ud(context, 8.0f);
        mzzVar2.addView(mzzVar3, layoutParams9);
        com.bytedance.sdk.openadsdk.core.mo.jpc jpcVar = new com.bytedance.sdk.openadsdk.core.mo.jpc(context);
        this.bjy = jpcVar;
        jpcVar.setTextColor(-1);
        mzzVar3.addView(jpcVar, new LinearLayout.LayoutParams(-2, -2));
        jtx jtxVar = new jtx(context, true);
        this.rdp = jtxVar;
        mzzVar3.addView(jtxVar, new LinearLayout.LayoutParams(-2, -2));
        this.mml = PAGLogoView.createPAGLogoViewByMaterial(context, ljhVar);
        this.mml.setId(520093757);
        FrameLayout.LayoutParams layoutParams10 = new FrameLayout.LayoutParams(-2, ax.ud(context, 14.0f));
        layoutParams10.gravity = 83;
        lnrVar2.addView(this.mml, layoutParams10);
        addView(lnrVar2);
        addView(this.fs);
        addView(lnrVar);
        addView(this.jpc);
        addView(mzzVar2);
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public View getUserInfo() {
        return this.exu;
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public com.bytedance.sdk.openadsdk.core.mo.jpc getAdTitleTextView() {
        return this.bjy;
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public com.bytedance.sdk.openadsdk.core.mo.mml getAdIconView() {
        return this.jtx;
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public jtx getScoreBar() {
        return this.rdp;
    }

    private static final class qdl extends Drawable {
        private final boolean mml;
        private static final int mzz = Color.parseColor("#b0000000");
        private static final int mo = Color.parseColor("#40000000");
        private final RectF qdl = new RectF();
        private final Paint ud = new Paint();
        private final Path lnr = new Path();

        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }

        public qdl(Context context) {
            this.mml = com.bytedance.sdk.component.adexpress.mml.ud.qdl(context);
        }

        @Override // android.graphics.drawable.Drawable
        protected void onBoundsChange(Rect rect) {
            super.onBoundsChange(rect);
            this.qdl.set(rect);
            this.lnr.reset();
            float fHeight = rect.height() / 2;
            this.lnr.addRoundRect(this.qdl, this.mml ? new float[]{fHeight, fHeight, 0.0f, 0.0f, 0.0f, 0.0f, fHeight, fHeight} : new float[]{0.0f, 0.0f, fHeight, fHeight, fHeight, fHeight, 0.0f, 0.0f}, Path.Direction.CW);
            float f = rect.right;
            int[] iArr = new int[2];
            boolean z = this.mml;
            iArr[0] = z ? mo : mzz;
            iArr[1] = z ? mzz : mo;
            this.ud.setShader(new LinearGradient(0.0f, 0.0f, f, 0.0f, iArr, (float[]) null, Shader.TileMode.CLAMP));
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
            canvas.drawPath(this.lnr, this.ud);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.component.tvp.lnr
    public com.bytedance.sdk.openadsdk.core.mo.mzz getOverlayLayout() {
        return this.yt;
    }
}
