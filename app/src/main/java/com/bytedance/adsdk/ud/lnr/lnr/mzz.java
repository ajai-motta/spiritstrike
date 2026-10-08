package com.bytedance.adsdk.ud.lnr.lnr;

import com.bytedance.adsdk.ud.lnr.qdl.fs;
import com.bytedance.adsdk.ud.lnr.qdl.rq;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public class mzz {
    private final List<com.bytedance.adsdk.ud.wd.qdl<Float>> aaj;
    private final com.bytedance.adsdk.ud.mzz.to bch;
    private final float bjy;
    private final com.bytedance.adsdk.ud.lnr.qdl.ud exc;
    private final float exu;
    private final int fs;
    private final rq jl;
    private final List<com.bytedance.adsdk.ud.lnr.ud.jpc> jpc;
    private final float jtx;
    private final ud jyq;
    private final com.bytedance.adsdk.ud.lnr.ud.qdl ljh;
    private final String lnr;
    private final long mml;
    private final long mo;
    private final qdl mzz;
    private final boolean oth;
    private final List<com.bytedance.adsdk.ud.lnr.ud.lnr> qdl;
    private final float rdp;
    private final int rq;
    private final int to;
    private final fs tvp;
    private final com.bytedance.adsdk.ud.wd ud;
    private final String wd;
    private final com.bytedance.adsdk.ud.lnr.qdl.to yt;

    public enum qdl {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    public enum ud {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public mzz(List<com.bytedance.adsdk.ud.lnr.ud.lnr> list, com.bytedance.adsdk.ud.wd wdVar, String str, long j, qdl qdlVar, long j2, String str2, List<com.bytedance.adsdk.ud.lnr.ud.jpc> list2, fs fsVar, int i, int i2, int i3, float f, float f2, float f3, float f4, com.bytedance.adsdk.ud.lnr.qdl.to toVar, rq rqVar, List<com.bytedance.adsdk.ud.wd.qdl<Float>> list3, ud udVar, com.bytedance.adsdk.ud.lnr.qdl.ud udVar2, boolean z, com.bytedance.adsdk.ud.lnr.ud.qdl qdlVar2, com.bytedance.adsdk.ud.mzz.to toVar2) {
        this.qdl = list;
        this.ud = wdVar;
        this.lnr = str;
        this.mml = j;
        this.mzz = qdlVar;
        this.mo = j2;
        this.wd = str2;
        this.jpc = list2;
        this.tvp = fsVar;
        this.to = i;
        this.rq = i2;
        this.fs = i3;
        this.exu = f;
        this.rdp = f2;
        this.bjy = f3;
        this.jtx = f4;
        this.yt = toVar;
        this.jl = rqVar;
        this.aaj = list3;
        this.jyq = udVar;
        this.exc = udVar2;
        this.oth = z;
        this.ljh = qdlVar2;
        this.bch = toVar2;
    }

    com.bytedance.adsdk.ud.wd qdl() {
        return this.ud;
    }

    float ud() {
        return this.exu;
    }

    float lnr() {
        return this.rdp / this.ud.yt();
    }

    List<com.bytedance.adsdk.ud.wd.qdl<Float>> mml() {
        return this.aaj;
    }

    public long mzz() {
        return this.mml;
    }

    public String mo() {
        return this.lnr;
    }

    public String wd() {
        return this.wd;
    }

    float jpc() {
        return this.bjy;
    }

    float tvp() {
        return this.jtx;
    }

    List<com.bytedance.adsdk.ud.lnr.ud.jpc> to() {
        return this.jpc;
    }

    public qdl rq() {
        return this.mzz;
    }

    ud fs() {
        return this.jyq;
    }

    long exu() {
        return this.mo;
    }

    List<com.bytedance.adsdk.ud.lnr.ud.lnr> rdp() {
        return this.qdl;
    }

    fs bjy() {
        return this.tvp;
    }

    int jtx() {
        return this.fs;
    }

    int yt() {
        return this.rq;
    }

    int jl() {
        return this.to;
    }

    com.bytedance.adsdk.ud.lnr.qdl.to exc() {
        return this.yt;
    }

    rq aaj() {
        return this.jl;
    }

    com.bytedance.adsdk.ud.lnr.qdl.ud jyq() {
        return this.exc;
    }

    public String toString() {
        return qdl("");
    }

    public boolean oth() {
        return this.oth;
    }

    public com.bytedance.adsdk.ud.lnr.ud.qdl ljh() {
        return this.ljh;
    }

    public com.bytedance.adsdk.ud.mzz.to bch() {
        return this.bch;
    }

    public String qdl(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(mo());
        sb.append("\n");
        mzz mzzVarQdl = this.ud.qdl(exu());
        if (mzzVarQdl != null) {
            sb.append("\t\tParents: ");
            sb.append(mzzVarQdl.mo());
            mzz mzzVarQdl2 = this.ud.qdl(mzzVarQdl.exu());
            while (mzzVarQdl2 != null) {
                sb.append("->");
                sb.append(mzzVarQdl2.mo());
                mzzVarQdl2 = this.ud.qdl(mzzVarQdl2.exu());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!to().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(to().size());
            sb.append("\n");
        }
        if (jl() != 0 && yt() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(jl()), Integer.valueOf(yt()), Integer.valueOf(jtx())));
        }
        if (!this.qdl.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (com.bytedance.adsdk.ud.lnr.ud.lnr lnrVar : this.qdl) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(lnrVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
