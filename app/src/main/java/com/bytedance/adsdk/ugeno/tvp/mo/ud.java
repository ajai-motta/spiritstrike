package com.bytedance.adsdk.ugeno.tvp.mo;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import androidx.core.view.GravityCompat;
import com.bytedance.adsdk.ugeno.ud.lnr;
import com.bytedance.adsdk.ugeno.wd.jpc;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.common.base.Ascii;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes2.dex */
public class ud extends lnr<qdl> {
    private int ca;
    protected int dps;

    @Deprecated
    private float fge;

    @Deprecated
    private TextUtils.TruncateAt gsp;

    @Deprecated
    private float hcs;
    private float hd;
    private float hr;
    private float iw;
    private float kj;
    private int kr;
    private float lme;
    private float nts;
    private float od;
    protected String qdl;
    private int se;
    private int syy;
    private int tdy;
    private boolean vc;
    private float vm;
    private int xx;
    private TextUtils.TruncateAt ygv;

    public ud(Context context) {
        super(context);
        this.dps = -16777216;
        this.iw = 12.0f;
        this.lme = -1.0f;
        this.xx = Integer.MAX_VALUE;
        this.tdy = GravityCompat.START;
        this.ygv = TextUtils.TruncateAt.END;
        this.hr = -1.0f;
        this.hd = 400.0f;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    /* JADX INFO: renamed from: lnr, reason: merged with bridge method [inline-methods] */
    public qdl qdl() {
        qdl qdlVar = new qdl(this.ud);
        qdlVar.qdl(this);
        return qdlVar;
    }

    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void ud() {
        super.ud();
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, this.qdl)) {
            this.qdl = "";
        }
        rdp(this.qdl);
        ((qdl) this.mzz).setTextSize(1, this.iw);
        ((qdl) this.mzz).setTextColor(this.dps);
        ((qdl) this.mzz).setLines(this.syy);
        ((qdl) this.mzz).setMaxLines(this.xx);
        ((qdl) this.mzz).setGravity(this.tdy);
        ((qdl) this.mzz).setIncludeFontPadding(false);
        ((qdl) this.mzz).setMinTextSize(jpc.qdl(this.ud, this.lme));
        qdl(this.ca);
        if (kdv()) {
            qdl(this.ygv);
        } else {
            qdl(this.gsp);
        }
        if (this.hr > 0.0f) {
            if (kdv()) {
                tvp();
            } else {
                mml();
            }
        }
        ((qdl) this.mzz).setBreakStrategy(0);
        if (kdv()) {
            if (this.vc) {
                if (this.vm <= 0.0f) {
                    this.vm = 1.0E-5f;
                }
                ((qdl) this.mzz).setShadowLayer(this.vm, this.kj, this.od, this.se);
            }
        } else {
            ((qdl) this.mzz).setShadowLayer(this.vm, this.fge, this.hcs, this.se);
        }
        if (this.kr == 1) {
            ((qdl) this.mzz).setTypeface(Typeface.DEFAULT, this.kr);
        } else if (Build.VERSION.SDK_INT >= 28) {
            ((qdl) this.mzz).setTypeface(Typeface.create(Typeface.DEFAULT, (int) this.hd, this.kr == 2));
        } else if (this.hd >= 500.0f) {
            ((qdl) this.mzz).setTypeface(Typeface.DEFAULT, 1);
        }
        if (jpc.qdl(this.ud, this.iw) > 0.0f) {
            ((qdl) this.mzz).setLetterSpacing(this.nts / jpc.qdl(this.ud, this.iw));
        }
    }

    private void mml() {
        ((qdl) this.mzz).setLineSpacing(0.0f, this.hr);
    }

    private void tvp() {
        if (this.hr <= 3.0f) {
            ((qdl) this.mzz).setLineSpacing(0.0f, this.hr);
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            int iRound = Math.round(jpc.qdl(this.ud, (this.hr - (this.iw * 1.2f)) / 2.0f));
            ((qdl) this.mzz).setPadding(((qdl) this.mzz).getPaddingLeft(), ((qdl) this.mzz).getPaddingTop() + iRound, ((qdl) this.mzz).getPaddingRight(), ((qdl) this.mzz).getPaddingBottom() + iRound);
            ((qdl) this.mzz).setLineHeight(Math.round(jpc.qdl(this.ud, this.hr)));
        }
    }

    public void rdp(String str) {
        this.qdl = str;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (TextUtils.equals(AbstractJsonLexerKt.NULL, str)) {
            this.qdl = "";
        }
        ((qdl) this.mzz).setText(this.qdl);
    }

    public void qdl(int i) {
        this.ca = i;
        if (i == Integer.MAX_VALUE) {
            return;
        }
        ((qdl) this.mzz).setPaintFlags(i);
    }

    public void qdl(TextUtils.TruncateAt truncateAt) {
        if (truncateAt == null) {
            return;
        }
        ((qdl) this.mzz).setEllipsize(truncateAt);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // com.bytedance.adsdk.ugeno.ud.lnr
    public void qdl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.qdl(str, str2);
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1621067310:
                if (str.equals("shadowRadius")) {
                    b = 0;
                }
                break;
            case -1589741021:
                if (str.equals("shadowColor")) {
                    b = 1;
                }
                break;
            case -1230714651:
                if (str.equals("shadowOffsetX")) {
                    b = 2;
                }
                break;
            case -1230714650:
                if (str.equals("shadowOffsetY")) {
                    b = 3;
                }
                break;
            case -1065511464:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_ALIGN)) {
                    b = 4;
                }
                break;
            case -1063571914:
                if (str.equals("textColor")) {
                    b = 5;
                }
                break;
            case -1048634236:
                if (str.equals("textStyle")) {
                    b = 6;
                }
                break;
            case -1021145689:
                if (str.equals("shadowBlur")) {
                    b = 7;
                }
                break;
            case -1003668786:
                if (str.equals("textSize")) {
                    b = 8;
                }
                break;
            case -879295043:
                if (str.equals(TtmlNode.ATTR_TTS_TEXT_DECORATION)) {
                    b = 9;
                }
                break;
            case -756368940:
                if (str.equals("shadowDx")) {
                    b = 10;
                }
                break;
            case -756368939:
                if (str.equals("shadowDy")) {
                    b = Ascii.VT;
                }
                break;
            case -734428249:
                if (str.equals(TtmlNode.ATTR_TTS_FONT_WEIGHT)) {
                    b = Ascii.FF;
                }
                break;
            case -515807685:
                if (str.equals("lineHeight")) {
                    b = Ascii.CR;
                }
                break;
            case 3556653:
                if (str.equals("text")) {
                    b = Ascii.SO;
                }
                break;
            case 102977279:
                if (str.equals("lines")) {
                    b = Ascii.SI;
                }
                break;
            case 188702929:
                if (str.equals("ellipsis")) {
                    b = Ascii.DLE;
                }
                break;
            case 351195968:
                if (str.equals("minTextSize")) {
                    b = 17;
                }
                break;
            case 390232059:
                if (str.equals("maxLines")) {
                    b = Ascii.DC2;
                }
                break;
            case 1554823821:
                if (str.equals("ellipsize")) {
                    b = 19;
                }
                break;
            case 2111078717:
                if (str.equals("letterSpacing")) {
                    b = Ascii.DC4;
                }
                break;
        }
        switch (b) {
            case 0:
            case 7:
                this.vm = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f);
                break;
            case 1:
                this.se = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                this.vc = true;
                break;
            case 2:
                this.kj = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 3:
                this.od = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
            case 4:
                this.tdy = jl(str2);
                break;
            case 5:
                this.dps = com.bytedance.adsdk.ugeno.wd.qdl.qdl(str2);
                break;
            case 6:
                this.kr = yt(str2);
                break;
            case 8:
                this.iw = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f);
                break;
            case 9:
                this.ca = exc(str2);
                break;
            case 10:
                this.fge = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f);
                break;
            case 11:
                this.hcs = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f);
                break;
            case 12:
                float fQdl = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, -1.0f);
                this.hd = fQdl;
                if (fQdl < 1.0f || fQdl > 1000.0f) {
                    this.hd = 400.0f;
                }
                break;
            case 13:
                this.hr = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 1.0f);
                break;
            case 14:
                this.qdl = str2;
                break;
            case 15:
                this.syy = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0);
                break;
            case 16:
                this.ygv = jtx(str2);
                break;
            case 17:
                this.lme = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, -1.0f);
                break;
            case 18:
                int iQdl = com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, Integer.MAX_VALUE);
                this.xx = iQdl > 0 ? iQdl : Integer.MAX_VALUE;
                break;
            case 19:
                this.gsp = bjy(str2);
                break;
            case 20:
                this.nts = jpc.qdl(this.ud, com.bytedance.adsdk.ugeno.wd.lnr.qdl(str2, 0.0f));
                break;
        }
    }

    private TextUtils.TruncateAt bjy(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                this.gsp = TextUtils.TruncateAt.MIDDLE;
                break;
            case "end":
                this.gsp = TextUtils.TruncateAt.END;
                break;
            case "start":
                this.gsp = TextUtils.TruncateAt.START;
                break;
            default:
                this.gsp = null;
                break;
        }
        return this.gsp;
    }

    private TextUtils.TruncateAt jtx(String str) {
        if (TextUtils.equals(str, "none")) {
            return null;
        }
        return TextUtils.TruncateAt.END;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int yt(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = -1178781136(0xffffffffb9bd3a30, float:-3.6092242E-4)
            r2 = 0
            r3 = 2
            r4 = 1
            if (r0 == r1) goto L2b
            r1 = -1039745817(0xffffffffc206bce7, float:-33.684475)
            if (r0 == r1) goto L21
            r1 = 3029637(0x2e3a85, float:4.245426E-39)
            if (r0 == r1) goto L17
            goto L35
        L17:
            java.lang.String r0 = "bold"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r2
            goto L36
        L21:
            java.lang.String r0 = "normal"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r3
            goto L36
        L2b:
            java.lang.String r0 = "italic"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L35
            r6 = r4
            goto L36
        L35:
            r6 = -1
        L36:
            if (r6 == 0) goto L3d
            if (r6 == r4) goto L3b
            goto L3e
        L3b:
            r2 = r3
            goto L3e
        L3d:
            r2 = r4
        L3e:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ugeno.tvp.mo.ud.yt(java.lang.String):int");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private int jl(String str) {
        str.hashCode();
        byte b = -1;
        switch (str.hashCode()) {
            case -1364013995:
                if (str.equals(TtmlNode.CENTER)) {
                    b = 0;
                }
                break;
            case -348726240:
                if (str.equals("center_vertical")) {
                    b = 1;
                }
                break;
            case 3317767:
                if (str.equals("left")) {
                    b = 2;
                }
                break;
            case 108511772:
                if (str.equals(TtmlNode.RIGHT)) {
                    b = 3;
                }
                break;
            case 1063616078:
                if (str.equals("center_horizontal")) {
                    b = 4;
                }
                break;
        }
        switch (b) {
            case 0:
                return 17;
            case 1:
                return 16;
            case 2:
            default:
                return 3;
            case 3:
                return 5;
            case 4:
                return 1;
        }
    }

    private int exc(String str) {
        str.hashCode();
        switch (str) {
            case "underline":
                return 8;
            case "strikethrough":
                return 16;
            case "none":
            default:
                return Integer.MAX_VALUE;
        }
    }
}
