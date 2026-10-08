package com.bytedance.adsdk.ud.lnr.ud;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class mml {
    private final float[] qdl;
    private final int[] ud;

    public mml(float[] fArr, int[] iArr) {
        this.qdl = fArr;
        this.ud = iArr;
    }

    public float[] qdl() {
        return this.qdl;
    }

    public int[] ud() {
        return this.ud;
    }

    public int lnr() {
        return this.ud.length;
    }

    public void qdl(mml mmlVar, mml mmlVar2, float f) {
        if (mmlVar.ud.length != mmlVar2.ud.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + mmlVar.ud.length + " vs " + mmlVar2.ud.length + ")");
        }
        for (int i = 0; i < mmlVar.ud.length; i++) {
            this.qdl[i] = com.bytedance.adsdk.ud.mo.mzz.qdl(mmlVar.qdl[i], mmlVar2.qdl[i], f);
            this.ud[i] = com.bytedance.adsdk.ud.mo.ud.qdl(f, mmlVar.ud[i], mmlVar2.ud[i]);
        }
    }

    public mml qdl(float[] fArr) {
        int[] iArr = new int[fArr.length];
        for (int i = 0; i < fArr.length; i++) {
            iArr[i] = qdl(fArr[i]);
        }
        return new mml(fArr, iArr);
    }

    private int qdl(float f) {
        int iBinarySearch = Arrays.binarySearch(this.qdl, f);
        if (iBinarySearch >= 0) {
            return this.ud[iBinarySearch];
        }
        int i = -(iBinarySearch + 1);
        if (i == 0) {
            return this.ud[0];
        }
        int[] iArr = this.ud;
        if (i == iArr.length - 1) {
            return iArr[iArr.length - 1];
        }
        float[] fArr = this.qdl;
        int i2 = i - 1;
        float f2 = fArr[i2];
        return com.bytedance.adsdk.ud.mo.ud.qdl((f - f2) / (fArr[i] - f2), iArr[i2], iArr[i]);
    }
}
