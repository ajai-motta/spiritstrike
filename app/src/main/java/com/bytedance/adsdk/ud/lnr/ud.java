package com.bytedance.adsdk.ud.lnr;

import android.graphics.PointF;

/* JADX INFO: loaded from: classes.dex */
public class ud {
    public PointF exu;
    public PointF fs;
    public int jpc;
    public float lnr;
    public qdl mml;
    public float mo;
    public int mzz;
    public String qdl;
    public boolean rq;
    public float to;
    public int tvp;
    public String ud;
    public float wd;

    public enum qdl {
        LEFT_ALIGN,
        RIGHT_ALIGN,
        CENTER
    }

    public ud(String str, String str2, float f, qdl qdlVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        qdl(str, str2, f, qdlVar, i, f2, f3, i2, i3, f4, z, pointF, pointF2);
    }

    public ud() {
    }

    public void qdl(String str, String str2, float f, qdl qdlVar, int i, float f2, float f3, int i2, int i3, float f4, boolean z, PointF pointF, PointF pointF2) {
        this.qdl = str;
        this.ud = str2;
        this.lnr = f;
        this.mml = qdlVar;
        this.mzz = i;
        this.mo = f2;
        this.wd = f3;
        this.jpc = i2;
        this.tvp = i3;
        this.to = f4;
        this.rq = z;
        this.fs = pointF;
        this.exu = pointF2;
    }

    public int hashCode() {
        int iHashCode = (((((int) ((((this.qdl.hashCode() * 31) + this.ud.hashCode()) * 31) + this.lnr)) * 31) + this.mml.ordinal()) * 31) + this.mzz;
        long jFloatToRawIntBits = Float.floatToRawIntBits(this.mo);
        return (((iHashCode * 31) + ((int) (jFloatToRawIntBits ^ (jFloatToRawIntBits >>> 32)))) * 31) + this.jpc;
    }
}
