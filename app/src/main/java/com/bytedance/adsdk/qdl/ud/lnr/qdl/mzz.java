package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class mzz extends mo {
    @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl.mo
    public int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        char cQdl;
        int i2 = i;
        while (true) {
            cQdl = qdl(i2, str);
            if (!com.bytedance.adsdk.qdl.ud.mzz.qdl.ud(cQdl) && !com.bytedance.adsdk.qdl.ud.mzz.qdl.lnr(cQdl)) {
                break;
            }
            i2++;
        }
        if (cQdl != '(') {
            return qdlVar.qdl(str, i, deque);
        }
        deque.push(new com.bytedance.adsdk.qdl.ud.ud.qdl.to(str.substring(i, i2)));
        return i2 + 1;
    }
}
