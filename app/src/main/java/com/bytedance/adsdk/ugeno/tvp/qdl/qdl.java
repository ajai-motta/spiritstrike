package com.bytedance.adsdk.ugeno.tvp.qdl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.mzz;
import com.bytedance.adsdk.ugeno.qdl;
import com.bytedance.adsdk.ugeno.tvp.mo.ud;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.bytedance.adsdk.ugeno.wd.mml;
import com.bytedance.adsdk.ugeno.wd.qdl;

/* JADX INFO: loaded from: classes2.dex */
public class qdl extends ud {
    private int ca;
    private boolean gsp;
    private String iw;
    private String kr;
    private String lme;
    private int syy;
    private qdl.C0191qdl tdy;
    private String xx;
    private boolean ygv;

    public qdl(Context context) {
        super(context);
        this.lme = "row";
    }

    @Override // com.bytedance.adsdk.ugeno.tvp.mo.ud, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        mml();
        ((com.bytedance.adsdk.ugeno.tvp.mo.qdl) this.mzz).setGravity(17);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    protected void wc() {
        super.wc();
        if (this.gsp) {
            ((com.bytedance.adsdk.ugeno.tvp.mo.qdl) this.mzz).setTextColor(this.ca);
        }
        if (this.ygv) {
            if (this.zpu) {
                qdl(this.tdy);
            } else {
                mml(this.syy);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    protected void om() {
        super.om();
        if (this.gsp) {
            ((com.bytedance.adsdk.ugeno.tvp.mo.qdl) this.mzz).setTextColor(this.dps);
        }
        if (this.ygv) {
            if (this.zpu) {
                qdl(this.jle);
            } else {
                mml(this.mrf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ud(android.graphics.drawable.Drawable r5) {
        /*
            r4 = this;
            if (r5 != 0) goto L3
            return
        L3:
            java.lang.String r0 = r4.lme
            int r1 = r0.hashCode()
            r2 = 2
            r3 = 1
            switch(r1) {
                case -1781065991: goto L2d;
                case -1354837162: goto L23;
                case -207799939: goto L19;
                case 113114: goto Lf;
                default: goto Le;
            }
        Le:
            goto L37
        Lf:
            java.lang.String r1 = "row"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 3
            goto L38
        L19:
            java.lang.String r1 = "row_reverse"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = 0
            goto L38
        L23:
            java.lang.String r1 = "column"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = r3
            goto L38
        L2d:
            java.lang.String r1 = "column_reverse"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L37
            r0 = r2
            goto L38
        L37:
            r0 = -1
        L38:
            r1 = 0
            if (r0 == 0) goto L57
            if (r0 == r3) goto L4f
            if (r0 == r2) goto L47
            T extends android.view.View r0 = r4.mzz
            com.bytedance.adsdk.ugeno.tvp.mo.qdl r0 = (com.bytedance.adsdk.ugeno.tvp.mo.qdl) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r5, r1, r1, r1)
            return
        L47:
            T extends android.view.View r0 = r4.mzz
            com.bytedance.adsdk.ugeno.tvp.mo.qdl r0 = (com.bytedance.adsdk.ugeno.tvp.mo.qdl) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r1, r1, r5)
            return
        L4f:
            T extends android.view.View r0 = r4.mzz
            com.bytedance.adsdk.ugeno.tvp.mo.qdl r0 = (com.bytedance.adsdk.ugeno.tvp.mo.qdl) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r5, r1, r1)
            return
        L57:
            T extends android.view.View r0 = r4.mzz
            com.bytedance.adsdk.ugeno.tvp.mo.qdl r0 = (com.bytedance.adsdk.ugeno.tvp.mo.qdl) r0
            r0.setCompoundDrawablesWithIntrinsicBounds(r1, r1, r5, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.tvp.qdl.qdl.ud(android.graphics.drawable.Drawable):void");
    }

    private void mml() {
        if (TextUtils.isEmpty(this.iw)) {
            return;
        }
        ((com.bytedance.adsdk.ugeno.tvp.mo.qdl) this.mzz).setCompoundDrawables(null, null, null, null);
        if (this.iw.startsWith("local://")) {
            try {
                ud(jpc.qdl(this.ud, mml.ud(this.ud, this.iw.replace("local://", ""))));
                return;
            } catch (Throwable unused) {
                return;
            }
        }
        mzz.qdl().ud().qdl(this.tvp, this.iw, new qdl.InterfaceC0186qdl() { // from class: com.bytedance.adsdk.ugeno.tvp.qdl.qdl.1
            @Override // com.bytedance.adsdk.ugeno.qdl.InterfaceC0186qdl
            public void qdl(final Bitmap bitmap) {
                if (bitmap == null) {
                    return;
                }
                jpc.qdl(new Runnable() { // from class: com.bytedance.adsdk.ugeno.tvp.qdl.qdl.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        qdl.this.ud(new BitmapDrawable(qdl.this.ud.getResources(), bitmap));
                    }
                });
            }
        });
    }

    @Override // com.bytedance.adsdk.ugeno.tvp.mo.ud, com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        super.qdl(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.lme = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.ca = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                this.gsp = true;
                break;
            case "image":
                this.iw = str2;
                break;
            case "highlightImage":
                this.kr = str2;
                break;
            case "highlightBackgroundColor":
                if (com.bytedance.adsdk.ugeno.wd.qdl.lnr(str2)) {
                    this.zpu = true;
                    this.tdy = com.bytedance.adsdk.ugeno.wd.qdl.ud(str2);
                } else {
                    this.syy = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                    this.zpu = false;
                }
                this.ygv = true;
                break;
            case "highlightBackgroundImage":
                this.xx = str2;
                break;
        }
    }
}
