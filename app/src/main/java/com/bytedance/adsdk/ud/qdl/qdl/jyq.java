package com.bytedance.adsdk.ud.qdl.qdl;

import com.bytedance.adsdk.ud.lnr.ud.exc;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class jyq implements lnr, qdl.InterfaceC0180qdl {
    private final List<qdl.InterfaceC0180qdl> lnr = new ArrayList();
    private final exc.qdl mml;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> mo;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> mzz;
    private final String qdl;
    private final boolean ud;
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> wd;

    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    public void qdl(List<lnr> list, List<lnr> list2) {
    }

    public jyq(com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.exc excVar) {
        this.qdl = excVar.qdl();
        this.ud = excVar.mo();
        this.mml = excVar.ud();
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl = excVar.mml().qdl();
        this.mzz = qdlVarQdl;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl2 = excVar.lnr().qdl();
        this.mo = qdlVarQdl2;
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl3 = excVar.mzz().qdl();
        this.wd = qdlVarQdl3;
        qdlVar.qdl(qdlVarQdl);
        qdlVar.qdl(qdlVarQdl2);
        qdlVar.qdl(qdlVarQdl3);
        qdlVarQdl.qdl(this);
        qdlVarQdl2.qdl(this);
        qdlVarQdl3.qdl(this);
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        for (int i = 0; i < this.lnr.size(); i++) {
            this.lnr.get(i).qdl();
        }
    }

    void qdl(qdl.InterfaceC0180qdl interfaceC0180qdl) {
        this.lnr.add(interfaceC0180qdl);
    }

    exc.qdl ud() {
        return this.mml;
    }

    public com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> lnr() {
        return this.mzz;
    }

    public com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> mml() {
        return this.mo;
    }

    public com.bytedance.adsdk.ud.qdl.ud.qdl<?, Float> mzz() {
        return this.wd;
    }

    public boolean mo() {
        return this.ud;
    }
}
