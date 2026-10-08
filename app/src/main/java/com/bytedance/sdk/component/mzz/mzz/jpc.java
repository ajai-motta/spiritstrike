package com.bytedance.sdk.component.mzz.mzz;

import com.bytedance.sdk.component.mzz.jtx;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class jpc extends qdl {
    private String lnr;
    private Throwable qdl;
    private int ud;

    public jpc(int i, String str, Throwable th) {
        this.ud = i;
        this.lnr = str;
        this.qdl = th;
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public void qdl(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        lnrVar.qdl(new com.bytedance.sdk.component.mzz.lnr.qdl(this.ud, this.lnr, this.qdl));
        String strOth = lnrVar.oth();
        Map<String, List<com.bytedance.sdk.component.mzz.lnr.lnr>> mapJpc = lnrVar.jl().jpc();
        List<com.bytedance.sdk.component.mzz.lnr.lnr> list = mapJpc.get(strOth);
        if (list == null) {
            ud(lnrVar);
            return;
        }
        synchronized (list) {
            Iterator<com.bytedance.sdk.component.mzz.lnr.lnr> it = list.iterator();
            while (it.hasNext()) {
                ud(it.next());
            }
            list.clear();
            mapJpc.remove(strOth);
        }
    }

    @Override // com.bytedance.sdk.component.mzz.mzz.tvp
    public String qdl() {
        return "failed";
    }

    private void ud(com.bytedance.sdk.component.mzz.lnr.lnr lnrVar) {
        jtx jtxVarJpc = lnrVar.jpc();
        if (jtxVarJpc != null) {
            jtxVarJpc.qdl(this.ud, this.lnr, this.qdl);
        }
    }
}
