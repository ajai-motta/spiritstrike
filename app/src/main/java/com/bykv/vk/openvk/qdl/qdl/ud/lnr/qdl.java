package com.bykv.vk.openvk.qdl.qdl.ud.lnr;

import com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr;

/* JADX INFO: loaded from: classes2.dex */
public abstract class qdl implements lnr {
    private lnr.mml jpc;
    private lnr.ud lnr;
    private lnr.qdl mml;
    private lnr.wd mo;
    private lnr.mo mzz;
    protected boolean qdl = false;
    private lnr.mzz ud;
    private lnr.InterfaceC0178lnr wd;

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.mzz mzzVar) {
        this.ud = mzzVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.ud udVar) {
        this.lnr = udVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.qdl qdlVar) {
        this.mml = qdlVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.mo moVar) {
        this.mzz = moVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.InterfaceC0178lnr interfaceC0178lnr) {
        this.wd = interfaceC0178lnr;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.mml mmlVar) {
        this.jpc = mmlVar;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public final void qdl(lnr.wd wdVar) {
        this.mo = wdVar;
    }

    public void qdl() {
        this.ud = null;
        this.mml = null;
        this.lnr = null;
        this.mzz = null;
        this.mo = null;
        this.wd = null;
        this.jpc = null;
    }

    protected final void ud() {
        try {
            lnr.mzz mzzVar = this.ud;
            if (mzzVar != null) {
                mzzVar.ud(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void lnr() {
        try {
            lnr.ud udVar = this.lnr;
            if (udVar != null) {
                udVar.qdl(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void qdl(int i) {
        try {
            lnr.qdl qdlVar = this.mml;
            if (qdlVar != null) {
                qdlVar.qdl(this, i);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void mml() {
        try {
            lnr.mo moVar = this.mzz;
            if (moVar != null) {
                moVar.lnr(this);
            }
        } catch (Throwable unused) {
        }
    }

    protected final void qdl(int i, int i2, int i3, int i4) {
        try {
            lnr.wd wdVar = this.mo;
            if (wdVar != null) {
                wdVar.qdl(this, i, i2, i3, i4);
            }
        } catch (Throwable unused) {
        }
    }

    protected final boolean qdl(int i, int i2) {
        try {
            lnr.InterfaceC0178lnr interfaceC0178lnr = this.wd;
            if (interfaceC0178lnr != null) {
                if (interfaceC0178lnr.qdl(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    protected final boolean ud(int i, int i2) {
        try {
            lnr.mml mmlVar = this.jpc;
            if (mmlVar != null) {
                if (mmlVar.ud(this, i, i2)) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    @Override // com.bykv.vk.openvk.qdl.qdl.ud.lnr.lnr
    public void qdl(boolean z) {
        this.qdl = z;
    }
}
