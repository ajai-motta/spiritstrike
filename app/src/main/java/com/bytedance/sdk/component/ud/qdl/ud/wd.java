package com.bytedance.sdk.component.ud.qdl.ud;

import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
final class wd extends mml {
    final transient int[] jpc;
    final transient byte[][] wd;

    wd(qdl qdlVar, int i) {
        super(null);
        tvp.qdl(qdlVar.ud, 0L, i);
        mzz mzzVar = qdlVar.qdl;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            if (mzzVar.lnr == mzzVar.ud) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += mzzVar.lnr - mzzVar.ud;
            i4++;
            mzzVar = mzzVar.mo;
        }
        this.wd = new byte[i4][];
        this.jpc = new int[i4 * 2];
        mzz mzzVar2 = qdlVar.qdl;
        int i5 = 0;
        while (i2 < i) {
            this.wd[i5] = mzzVar2.qdl;
            i2 += mzzVar2.lnr - mzzVar2.ud;
            if (i2 > i) {
                i2 = i;
            }
            int[] iArr = this.jpc;
            iArr[i5] = i2;
            iArr[this.wd.length + i5] = mzzVar2.ud;
            mzzVar2.mml = true;
            i5++;
            mzzVar2 = mzzVar2.mo;
        }
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public String qdl() {
        return mzz().qdl();
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public String ud() {
        return mzz().ud();
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public mml qdl(int i, int i2) {
        return mzz().qdl(i, i2);
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public byte qdl(int i) {
        tvp.qdl(this.jpc[this.wd.length - 1], i, 1L);
        int iUd = ud(i);
        int i2 = iUd == 0 ? 0 : this.jpc[iUd - 1];
        int[] iArr = this.jpc;
        byte[][] bArr = this.wd;
        return bArr[iUd][(i - i2) + iArr[bArr.length + iUd]];
    }

    private int ud(int i) {
        int iBinarySearch = Arrays.binarySearch(this.jpc, 0, this.wd.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public int lnr() {
        return this.jpc[this.wd.length - 1];
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public byte[] mml() {
        int[] iArr = this.jpc;
        byte[][] bArr = this.wd;
        byte[] bArr2 = new byte[iArr[bArr.length - 1]];
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr2 = this.jpc;
            int i3 = iArr2[length + i];
            int i4 = iArr2[i];
            System.arraycopy(this.wd[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return bArr2;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public boolean qdl(int i, mml mmlVar, int i2, int i3) {
        if (i < 0 || i > lnr() - i3) {
            return false;
        }
        int iUd = ud(i);
        while (i3 > 0) {
            int i4 = iUd == 0 ? 0 : this.jpc[iUd - 1];
            int iMin = Math.min(i3, ((this.jpc[iUd] - i4) + i4) - i);
            int[] iArr = this.jpc;
            byte[][] bArr = this.wd;
            if (!mmlVar.qdl(i2, bArr[iUd], (i - i4) + iArr[bArr.length + iUd], iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iUd++;
        }
        return true;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public boolean qdl(int i, byte[] bArr, int i2, int i3) {
        if (i < 0 || i > lnr() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int iUd = ud(i);
        while (i3 > 0) {
            int i4 = iUd == 0 ? 0 : this.jpc[iUd - 1];
            int iMin = Math.min(i3, ((this.jpc[iUd] - i4) + i4) - i);
            int[] iArr = this.jpc;
            byte[][] bArr2 = this.wd;
            if (!tvp.qdl(bArr2[iUd], (i - i4) + iArr[bArr2.length + iUd], bArr, i2, iMin)) {
                return false;
            }
            i += iMin;
            i2 += iMin;
            i3 -= iMin;
            iUd++;
        }
        return true;
    }

    private mml mzz() {
        return new mml(mml());
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mml) {
            mml mmlVar = (mml) obj;
            if (mmlVar.lnr() == lnr() && qdl(0, mmlVar, 0, lnr())) {
                return true;
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public int hashCode() {
        int i = this.mzz;
        if (i != 0) {
            return i;
        }
        int length = this.wd.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            byte[] bArr = this.wd[i2];
            int[] iArr = this.jpc;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.mzz = i3;
        return i3;
    }

    @Override // com.bytedance.sdk.component.ud.qdl.ud.mml
    public String toString() {
        return mzz().toString();
    }
}
