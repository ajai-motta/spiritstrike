package com.bytedance.adsdk.ugeno.mzz;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.ViewCompat;
import com.bytedance.adsdk.ugeno.mzz.mzz;
import com.bytedance.adsdk.ugeno.ud.qdl;

/* JADX INFO: loaded from: classes2.dex */
public class mo extends com.bytedance.adsdk.ugeno.ud.qdl<mzz> {
    private int dps;
    private int iw;
    private int kr;
    private int lme;
    private int xx;

    public mo(Context context) {
        super(context);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    /* JADX INFO: renamed from: lnr, reason: merged with bridge method [inline-methods] */
    public mzz qdl() {
        mzz mzzVar = new mzz(this.ud);
        mzzVar.qdl(this);
        return mzzVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl, com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        ((mzz) this.mzz).setFlexDirection(this.dps);
        ((mzz) this.mzz).setFlexWrap(this.iw);
        ((mzz) this.mzz).setJustifyContent(this.lme);
        ((mzz) this.mzz).setAlignItems(this.kr);
        ((mzz) this.mzz).setAlignContent(this.xx);
    }

    @Override // com.bytedance.adsdk.ugeno.ud.qdl
    public qdl.C0190qdl to() {
        return new qdl(this);
    }

    public static class qdl extends qdl.C0190qdl {
        public float bqt;
        public int ekw;
        public int hkc;
        public int hzv;
        public int kdv;
        public float koa;
        public float rc;
        public int vu;
        public int xmv;

        public qdl(com.bytedance.adsdk.ugeno.ud.qdl qdlVar) {
            super(qdlVar);
            this.xmv = 1;
            this.bqt = 0.0f;
            this.koa = 0.0f;
            this.vu = -1;
            this.rc = -1.0f;
            this.kdv = -1;
            this.ekw = -1;
            this.hkc = ViewCompat.MEASURED_SIZE_MASK;
            this.hzv = ViewCompat.MEASURED_SIZE_MASK;
        }

        @Override // com.bytedance.adsdk.ugeno.ud.qdl.C0190qdl
        public void qdl(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
            }
            super.qdl(context, str, str2);
            str.hashCode();
            switch (str) {
                case "flexBasisPercent":
                    this.rc = mml(str2);
                    break;
                case "order":
                    this.xmv = qdl(str2);
                    break;
                case "flexShrink":
                    this.koa = lnr(str2);
                    break;
                case "flexGrow":
                    this.bqt = ud(str2);
                    break;
                case "alignSelf":
                    this.vu = mzz(str2);
                    break;
            }
        }

        private int qdl(String str) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return 1;
            }
        }

        private float ud(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float lnr(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return 0.0f;
            }
        }

        private float mml(String str) {
            try {
                return Float.parseFloat(str);
            } catch (Exception unused) {
                return -1.0f;
            }
        }

        private int mzz(String str) {
            str.hashCode();
            switch (str) {
                case "stretch":
                    return 4;
                case "baseline":
                    return 3;
                case "center":
                    return 2;
                case "flex_start":
                    return 0;
                case "flex_end":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.bytedance.adsdk.ugeno.ud.qdl.C0190qdl
        /* JADX INFO: renamed from: ud, reason: merged with bridge method [inline-methods] */
        public mzz.qdl qdl() {
            mzz.qdl qdlVar = new mzz.qdl((int) this.qdl, (int) this.ud);
            qdlVar.leftMargin = (int) this.mo;
            qdlVar.rightMargin = (int) this.wd;
            qdlVar.topMargin = (int) this.jpc;
            qdlVar.bottomMargin = (int) this.tvp;
            qdlVar.lnr(this.xmv);
            qdlVar.mml(this.vu);
            qdlVar.qdl(this.bqt);
            qdlVar.ud(this.koa);
            qdlVar.lnr(this.rc);
            return qdlVar;
        }

        @Override // com.bytedance.adsdk.ugeno.ud.qdl.C0190qdl
        public String toString() {
            return "LayoutParams{mWidth=" + this.qdl + ", mHeight=" + this.ud + ", mMargin=" + this.mzz + ", mMarginLeft=" + this.mo + ", mMarginRight=" + this.wd + ", mMarginTop=" + this.jpc + ", mMarginBottom=" + this.tvp + ", mParams=" + this.bch + ", mOrder=" + this.xmv + ", mFlexGrow=" + this.bqt + ", mFlexShrink=" + this.koa + ", mAlignSelf=" + this.vu + ", mFlexBasisPercent=" + this.rc + ", mMinWidth=" + this.kdv + ", mMinHeight=" + this.ekw + ", mMaxWidth=" + this.hkc + ", mMaxHeight=" + this.hzv + "} " + super.toString();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.qdl(str, str2);
        str.hashCode();
        switch (str) {
            case "alignItems":
                this.kr = yt(str2);
                break;
            case "flexDirection":
                this.dps = rdp(str2);
                break;
            case "alignContent":
                this.xx = jl(str2);
                break;
            case "flexWrap":
                this.iw = bjy(str2);
                break;
            case "justifyContent":
                this.lme = jtx(str2);
                break;
        }
    }

    int rdp(String str) {
        str.hashCode();
        switch (str) {
            case "column_reverse":
                return 3;
            case "column":
                return 2;
            case "row_reverse":
                return 1;
            default:
                return 0;
        }
    }

    private int bjy(String str) {
        str.hashCode();
        return !str.equals("wrap") ? 0 : 1;
    }

    private int jtx(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 2;
            case "space_around":
                return 4;
            case "space_between":
                return 3;
            case "flex_end":
                return 1;
            default:
                return 0;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x003f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int yt(java.lang.String r7) {
        /*
            r6 = this;
            int r0 = r7.hashCode()
            r1 = 4
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            switch(r0) {
                case -1881872635: goto L35;
                case -1720785339: goto L2b;
                case -1364013995: goto L21;
                case 1384876188: goto L17;
                case 1744442261: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L3f
        Ld:
            java.lang.String r0 = "flex_end"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r5
            goto L40
        L17:
            java.lang.String r0 = "flex_start"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r2
            goto L40
        L21:
            java.lang.String r0 = "center"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r4
            goto L40
        L2b:
            java.lang.String r0 = "baseline"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r3
            goto L40
        L35:
            java.lang.String r0 = "stretch"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L3f
            r7 = r1
            goto L40
        L3f:
            r7 = -1
        L40:
            if (r7 == 0) goto L4c
            if (r7 == r5) goto L4b
            if (r7 == r4) goto L4a
            if (r7 == r3) goto L49
            return r1
        L49:
            return r3
        L4a:
            return r4
        L4b:
            return r5
        L4c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mzz.mo.yt(java.lang.String):int");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int jl(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r8.hashCode()
            r1 = 5
            r2 = 0
            r3 = 4
            r4 = 3
            r5 = 2
            r6 = 1
            switch(r0) {
                case -1881872635: goto L40;
                case -1364013995: goto L36;
                case -932331738: goto L2c;
                case 1384876188: goto L22;
                case 1682480591: goto L18;
                case 1744442261: goto Le;
                default: goto Ld;
            }
        Ld:
            goto L4a
        Le:
            java.lang.String r0 = "flex_end"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r6
            goto L4b
        L18:
            java.lang.String r0 = "space_between"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r3
            goto L4b
        L22:
            java.lang.String r0 = "flex_start"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r2
            goto L4b
        L2c:
            java.lang.String r0 = "space_around"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r4
            goto L4b
        L36:
            java.lang.String r0 = "center"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r5
            goto L4b
        L40:
            java.lang.String r0 = "stretch"
            boolean r8 = r8.equals(r0)
            if (r8 == 0) goto L4a
            r8 = r1
            goto L4b
        L4a:
            r8 = -1
        L4b:
            if (r8 == 0) goto L5a
            if (r8 == r6) goto L59
            if (r8 == r5) goto L58
            if (r8 == r4) goto L57
            if (r8 == r3) goto L56
            return r1
        L56:
            return r4
        L57:
            return r3
        L58:
            return r5
        L59:
            return r6
        L5a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.mzz.mo.jl(java.lang.String):int");
    }
}
