package com.bytedance.sdk.openadsdk.component.jpc;

import android.content.Context;
import android.widget.FrameLayout;
import com.bykv.vk.openvk.qdl.qdl.qdl.mml.lnr;
import com.bytedance.sdk.component.utils.aaj;
import com.bytedance.sdk.openadsdk.CacheDirFactory;
import com.bytedance.sdk.openadsdk.core.lnr.qdl;
import com.bytedance.sdk.openadsdk.core.model.ljh;
import com.bytedance.sdk.openadsdk.mml.mzz.ud.bjy;

/* JADX INFO: loaded from: classes3.dex */
public class lnr implements qdl.InterfaceC0238qdl {
    private ljh lnr;
    private ud mml;
    private boolean mzz = false;
    private Context qdl;
    private FrameLayout ud;

    public lnr(Context context) {
        this.qdl = context.getApplicationContext();
    }

    public void qdl(FrameLayout frameLayout, ljh ljhVar) {
        this.ud = frameLayout;
        this.lnr = ljhVar;
        this.mml = new ud(this.qdl, frameLayout, ljhVar);
    }

    public boolean qdl() {
        com.bytedance.sdk.openadsdk.core.exu.qdl.ud udVarQdl = ljh.qdl(CacheDirFactory.getICacheDir(0).ud(), this.lnr);
        udVarQdl.ud(this.lnr.yre());
        udVarQdl.ud(this.ud.getWidth());
        udVarQdl.lnr(this.ud.getHeight());
        udVarQdl.lnr(this.lnr.ir());
        udVarQdl.qdl(0L);
        udVarQdl.qdl(true);
        return this.mml.qdl(udVarQdl);
    }

    public ud ud() {
        return this.mml;
    }

    public void qdl(boolean z) {
        this.mzz = z;
    }

    public boolean lnr() {
        return this.mzz;
    }

    public boolean mml() {
        ud udVar = this.mml;
        return (udVar == null || udVar.rq() == null || !this.mml.rq().ud()) ? false : true;
    }

    public boolean mzz() {
        ud udVar = this.mml;
        return (udVar == null || udVar.rq() == null || !this.mml.rq().mo()) ? false : true;
    }

    public boolean mo() {
        ud udVar = this.mml;
        return (udVar == null || udVar.rq() == null || !this.mml.rq().wd()) ? false : true;
    }

    public boolean wd() {
        ud udVar = this.mml;
        return udVar != null && udVar.rdp();
    }

    public void qdl(lnr.qdl qdlVar) {
        ud udVar = this.mml;
        if (udVar != null) {
            udVar.qdl(qdlVar);
        }
    }

    public boolean qdl(FrameLayout frameLayout, com.bytedance.sdk.openadsdk.component.qdl qdlVar, ljh ljhVar) {
        qdl(frameLayout, ljhVar);
        qdl(qdlVar);
        try {
            return qdl();
        } catch (Throwable th) {
            aaj.lnr("TTAppOpenVideoManager", "open_ad", "ttAppOpenAd playVideo error: " + th.getMessage());
            return false;
        }
    }

    public boolean qdl(float f) {
        try {
            ud udVar = this.mml;
            if (udVar != null) {
                return udVar.qdl(f);
            }
        } catch (Throwable th) {
            aaj.lnr("TTAppOpenVideoManager", "open_ad", "setPlaybackSpeed error: " + th.getMessage());
        }
        return false;
    }

    public void jpc() {
        try {
            if (mzz()) {
                this.mml.ud();
            }
        } catch (Throwable th) {
            aaj.lnr("TTAppOpenVideoManager", "open_ad", "AppOpenVideoManager onPause throw Exception :" + th.getMessage());
        }
    }

    public void tvp() {
        try {
            if (mo()) {
                rq();
            }
        } catch (Throwable th) {
            aaj.lnr("TTAppOpenVideoManager", "onContinue throw Exception :" + th.getMessage());
        }
    }

    public void to() {
        ud udVar = this.mml;
        if (udVar == null) {
            return;
        }
        udVar.mml();
        this.mml = null;
    }

    public void rq() {
        ud udVar = this.mml;
        if (udVar != null) {
            udVar.lnr();
        }
    }

    public void fs() {
        ud udVar = this.mml;
        if (udVar == null) {
            return;
        }
        this.qdl = null;
        udVar.mml();
        this.mml = null;
    }

    public long exu() {
        ud udVar = this.mml;
        if (udVar != null) {
            return udVar.mo();
        }
        return 0L;
    }

    public long rdp() {
        ud udVar = this.mml;
        if (udVar != null) {
            return udVar.wd();
        }
        return 0L;
    }

    public long bjy() {
        ud udVar = this.mml;
        if (udVar != null) {
            return udVar.tvp() + this.mml.wd();
        }
        return 0L;
    }

    public void qdl(int i) {
        if (this.mml != null) {
            bjy.qdl qdlVar = new bjy.qdl();
            qdlVar.ud(exu());
            qdlVar.mml(bjy());
            qdlVar.lnr(rdp());
            qdlVar.lnr(i);
            qdlVar.mml(this.mml.jpc());
            qdlVar.qdl(this.mml.yt());
            this.mml.qdl(qdlVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.lnr.qdl.InterfaceC0238qdl
    public long getVideoProgress() {
        return exu();
    }
}
