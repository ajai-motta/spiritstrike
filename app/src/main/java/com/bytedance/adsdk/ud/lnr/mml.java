package com.bytedance.adsdk.ud.lnr;

import com.bytedance.adsdk.ud.lnr.ud.jtx;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class mml {
    private final double lnr;
    private final double mml;
    private final String mo;
    private final String mzz;
    private final List<jtx> qdl;
    private final char ud;

    public static int qdl(char c, String str, String str2) {
        return (((c * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public mml(List<jtx> list, char c, double d, double d2, String str, String str2) {
        this.qdl = list;
        this.ud = c;
        this.lnr = d;
        this.mml = d2;
        this.mzz = str;
        this.mo = str2;
    }

    public List<jtx> qdl() {
        return this.qdl;
    }

    public double ud() {
        return this.mml;
    }

    public int hashCode() {
        return qdl(this.ud, this.mo, this.mzz);
    }
}
