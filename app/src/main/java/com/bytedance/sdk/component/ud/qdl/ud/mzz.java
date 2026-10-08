package com.bytedance.sdk.component.ud.qdl.ud;

/* JADX INFO: loaded from: classes3.dex */
final class mzz {
    int lnr;
    boolean mml;
    mzz mo;
    boolean mzz;
    final byte[] qdl;
    int ud;
    mzz wd;

    mzz() {
        this.qdl = new byte[8192];
        this.mzz = true;
        this.mml = false;
    }

    mzz(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        this.qdl = bArr;
        this.ud = i;
        this.lnr = i2;
        this.mml = z;
        this.mzz = z2;
    }

    final mzz qdl() {
        this.mml = true;
        return new mzz(this.qdl, this.ud, this.lnr, true, false);
    }

    public final mzz ud() {
        mzz mzzVar = this.mo;
        mzz mzzVar2 = mzzVar != this ? mzzVar : null;
        mzz mzzVar3 = this.wd;
        if (mzzVar3 != null) {
            mzzVar3.mo = mzzVar;
        }
        mzz mzzVar4 = this.mo;
        if (mzzVar4 != null) {
            mzzVar4.wd = mzzVar3;
        }
        this.mo = null;
        this.wd = null;
        return mzzVar2;
    }

    public final mzz qdl(mzz mzzVar) {
        mzzVar.wd = this;
        mzzVar.mo = this.mo;
        this.mo.wd = mzzVar;
        this.mo = mzzVar;
        return mzzVar;
    }
}
