package com.bytedance.adsdk.ud.qdl.qdl;

import android.graphics.PointF;
import com.bytedance.adsdk.ud.qdl.ud.qdl;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class yt implements exc, qdl.InterfaceC0180qdl {
    private final com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> lnr;
    private com.bytedance.adsdk.ud.lnr.ud.rdp mml;
    private final com.bytedance.adsdk.ud.tvp qdl;
    private final String ud;

    @Override // com.bytedance.adsdk.ud.qdl.qdl.lnr
    public void qdl(List<lnr> list, List<lnr> list2) {
    }

    public yt(com.bytedance.adsdk.ud.tvp tvpVar, com.bytedance.adsdk.ud.lnr.lnr.qdl qdlVar, com.bytedance.adsdk.ud.lnr.ud.exu exuVar) {
        this.qdl = tvpVar;
        this.ud = exuVar.qdl();
        com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> qdlVarQdl = exuVar.ud().qdl();
        this.lnr = qdlVarQdl;
        qdlVar.qdl(qdlVarQdl);
        qdlVarQdl.qdl(this);
    }

    @Override // com.bytedance.adsdk.ud.qdl.ud.qdl.InterfaceC0180qdl
    public void qdl() {
        this.qdl.invalidateSelf();
    }

    public com.bytedance.adsdk.ud.qdl.ud.qdl<Float, Float> ud() {
        return this.lnr;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x009f  */
    @Override // com.bytedance.adsdk.ud.qdl.qdl.exc
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.bytedance.adsdk.ud.lnr.ud.rdp qdl(com.bytedance.adsdk.ud.lnr.ud.rdp r19) {
        /*
            Method dump skipped, instruction units count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.adsdk.ud.qdl.qdl.yt.qdl(com.bytedance.adsdk.ud.lnr.ud.rdp):com.bytedance.adsdk.ud.lnr.ud.rdp");
    }

    private com.bytedance.adsdk.ud.lnr.ud.rdp ud(com.bytedance.adsdk.ud.lnr.ud.rdp rdpVar) {
        List<com.bytedance.adsdk.ud.lnr.qdl> listLnr = rdpVar.lnr();
        boolean zUd = rdpVar.ud();
        int size = listLnr.size() - 1;
        int i = 0;
        while (size >= 0) {
            com.bytedance.adsdk.ud.lnr.qdl qdlVar = listLnr.get(size);
            com.bytedance.adsdk.ud.lnr.qdl qdlVar2 = listLnr.get(qdl(size - 1, listLnr.size()));
            PointF pointFLnr = (size != 0 || zUd) ? qdlVar2.lnr() : rdpVar.qdl();
            i = (((size != 0 || zUd) ? qdlVar2.ud() : pointFLnr).equals(pointFLnr) && qdlVar.qdl().equals(pointFLnr) && !(!rdpVar.ud() && size == 0 && size == listLnr.size() - 1)) ? i + 2 : i + 1;
            size--;
        }
        com.bytedance.adsdk.ud.lnr.ud.rdp rdpVar2 = this.mml;
        if (rdpVar2 == null || rdpVar2.lnr().size() != i) {
            ArrayList arrayList = new ArrayList(i);
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(new com.bytedance.adsdk.ud.lnr.qdl());
            }
            this.mml = new com.bytedance.adsdk.ud.lnr.ud.rdp(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.mml.qdl(zUd);
        return this.mml;
    }

    private static int qdl(int i, int i2) {
        return i - (ud(i, i2) * i2);
    }

    private static int ud(int i, int i2) {
        int i3 = i / i2;
        return ((i ^ i2) >= 0 || i2 * i3 == i) ? i3 : i3 - 1;
    }
}
