package com.bytedance.adsdk.ugeno.tvp.mml;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.AnimatedImageDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.adsdk.ugeno.core.mo;
import com.bytedance.adsdk.ugeno.mzz;
import com.bytedance.adsdk.ugeno.qdl;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.bytedance.adsdk.ugeno.wd.mml;

/* JADX INFO: loaded from: classes2.dex */
public class lnr extends com.bytedance.adsdk.ugeno.ud.lnr<qdl> {
    protected ImageView.ScaleType dps;
    protected boolean iw;
    private int kr;
    protected String lme;
    protected String qdl;
    private float syy;
    private float xx;

    public lnr(Context context) {
        super(context);
        this.dps = ImageView.ScaleType.FIT_XY;
        this.kr = -1;
        this.xx = -1.0f;
        this.syy = -1.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        tvp();
        ((qdl) this.mzz).setScaleType(this.dps);
        ((qdl) this.mzz).setBorderColor(this.sy);
        ((qdl) this.mzz).setCornerRadius(this.cx);
        ((qdl) this.mzz).setBorderWidth(this.tid);
        if (this.kr != -1) {
            ((qdl) this.mzz).setColorFilter(this.kr);
        }
    }

    public void bjy(String str) {
        this.qdl = str;
    }

    private void tvp() {
        if (TextUtils.isEmpty(this.qdl)) {
            return;
        }
        ((qdl) this.mzz).setImageDrawable(null);
        if (this.qdl.startsWith("local://")) {
            try {
                String strReplace = this.qdl.replace("local://", "");
                if (TextUtils.equals(lnr(), "raw")) {
                    ((qdl) this.mzz).setImageResource(mml.qdl(this.ud, strReplace));
                    return;
                } else {
                    ((qdl) this.mzz).setImageResource(mml.ud(this.ud, strReplace));
                    return;
                }
            } catch (Throwable unused) {
                return;
            }
        }
        if (this.qdl.startsWith("@")) {
            try {
                ((qdl) this.mzz).setImageResource(Integer.parseInt(this.qdl.substring(1)));
                return;
            } catch (Exception unused2) {
                return;
            }
        }
        to();
    }

    private void to() {
        if (this.xx > 0.0f) {
            mzz.qdl().ud().qdl(this.tvp, this.qdl, new qdl.InterfaceC0186qdl() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.1
                @Override // com.bytedance.adsdk.ugeno.qdl.InterfaceC0186qdl
                public void qdl(Bitmap bitmap) {
                    if (bitmap == null) {
                        if (lnr.this.jut != null) {
                            mo unused = lnr.this.jut;
                            return;
                        }
                        return;
                    }
                    if (lnr.this.jut != null) {
                        mo unused2 = lnr.this.jut;
                    }
                    final Bitmap bitmapQdl = jpc.qdl(lnr.this.ud, bitmap, (int) lnr.this.xx);
                    if (bitmapQdl != null) {
                        jpc.qdl(new Runnable() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ((qdl) lnr.this.mzz).setImageBitmap(bitmapQdl);
                            }
                        });
                    }
                    if (lnr.this.iw || lnr.this.syy > 0.0f) {
                        Bitmap bitmapQdl2 = jpc.qdl(lnr.this.ud, bitmap, lnr.this.syy > 0.0f ? (int) lnr.this.syy : 10);
                        if (bitmapQdl2 != null) {
                            final BitmapDrawable bitmapDrawable = new BitmapDrawable(lnr.this.ud.getResources(), bitmapQdl2);
                            jpc.qdl(new Runnable() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.1.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    ((qdl) lnr.this.mzz).setBackground(bitmapDrawable);
                                }
                            });
                        }
                    }
                }
            });
            return;
        }
        mzz.qdl().ud().qdl(this.tvp, this.qdl, (ImageView) this.mzz, ((qdl) this.mzz).getWidth(), ((qdl) this.mzz).getHeight(), new qdl.InterfaceC0186qdl() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.2
            @Override // com.bytedance.adsdk.ugeno.qdl.InterfaceC0186qdl
            public void qdl(Bitmap bitmap) {
                if (bitmap == null) {
                    if (lnr.this.jut != null) {
                        mo unused = lnr.this.jut;
                    }
                } else if (lnr.this.jut != null) {
                    mo unused2 = lnr.this.jut;
                }
            }
        });
        if (this.iw || this.syy > 0.0f) {
            mzz.qdl().ud().qdl(this.tvp, this.qdl, new qdl.InterfaceC0186qdl() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.3
                @Override // com.bytedance.adsdk.ugeno.qdl.InterfaceC0186qdl
                public void qdl(Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    final Bitmap bitmapQdl = jpc.qdl(lnr.this.ud, bitmap, lnr.this.syy > 0.0f ? (int) lnr.this.syy : 10);
                    jpc.qdl(new Runnable() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (bitmapQdl != null) {
                                ((qdl) lnr.this.mzz).setBackground(new BitmapDrawable(lnr.this.ud.getResources(), bitmapQdl));
                            }
                        }
                    });
                }
            });
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public qdl qdl() {
        qdl qdlVar = new qdl(this.ud);
        qdlVar.qdl(this);
        return qdlVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.qdl(str, str2);
        str.hashCode();
        switch (str) {
            case "scaleMode":
            case "scaleType":
                this.dps = rdp(str2);
                break;
            case "imageBlur":
                this.xx = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, -1.0f);
                break;
            case "isBgGaussianBlur":
                this.iw = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, false);
                break;
            case "src":
                this.qdl = str2;
                break;
            case "tintColor":
                this.kr = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                break;
            case "imageBgBlur":
                this.syy = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, -1.0f);
                break;
        }
    }

    private ImageView.ScaleType rdp(String str) {
        ImageView.ScaleType scaleType;
        scaleType = ImageView.ScaleType.FIT_XY;
        str.hashCode();
        switch (str) {
            case "center":
                return ImageView.ScaleType.CENTER;
            case "fitEnd":
                return ImageView.ScaleType.FIT_END;
            case "fitStart":
                return ImageView.ScaleType.FIT_START;
            case "centerInside":
                return ImageView.ScaleType.CENTER_INSIDE;
            case "fit":
            case "fitCenter":
                return ImageView.ScaleType.FIT_CENTER;
            case "crop":
            case "centerCrop":
                return ImageView.ScaleType.CENTER_CROP;
            case "fill":
            case "fitXY":
                return ImageView.ScaleType.FIT_XY;
            default:
                return scaleType;
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr, com.bytedance.adsdk.ugeno.mml
    public void wd() {
        super.wd();
        ((qdl) this.mzz).post(new Runnable() { // from class: com.bytedance.adsdk.ugeno.tvp.mml.lnr.4
            @Override // java.lang.Runnable
            public void run() {
                Drawable drawable = ((qdl) lnr.this.mzz).getDrawable();
                if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
                    return;
                }
                ((AnimatedImageDrawable) drawable).start();
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr, com.bytedance.adsdk.ugeno.mml
    public void jpc() {
        super.jpc();
        Drawable drawable = ((qdl) this.mzz).getDrawable();
        if (Build.VERSION.SDK_INT < 28 || !(drawable instanceof AnimatedImageDrawable)) {
            return;
        }
        ((AnimatedImageDrawable) drawable).stop();
    }

    protected String lnr() {
        return this.lme;
    }
}
