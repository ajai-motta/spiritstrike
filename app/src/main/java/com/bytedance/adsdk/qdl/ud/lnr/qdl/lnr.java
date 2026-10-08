package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import com.bytedance.adsdk.qdl.ud.ud.qdl.oth;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class lnr extends mo {
    @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl.mo
    public int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        char cQdl = qdl(i, str);
        if (!com.bytedance.adsdk.qdl.ud.mzz.qdl.ud(cQdl) && cQdl != '$') {
            return qdlVar.qdl(str, i, deque);
        }
        return qdl(str, i, deque);
    }

    private int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque) {
        int i2;
        int i3 = 0;
        while (true) {
            i2 = i3 + i;
            char cQdl = qdl(i2, str);
            if (!com.bytedance.adsdk.qdl.ud.mzz.qdl.ud(cQdl) && !com.bytedance.adsdk.qdl.ud.mzz.qdl.lnr(cQdl) && '.' != cQdl && '[' != cQdl && ']' != cQdl && '_' != cQdl && '$' != cQdl) {
                break;
            }
            i3++;
        }
        String strSubstring = str.substring(i, i2);
        if (com.bytedance.adsdk.qdl.ud.mml.qdl.qdl(strSubstring) != null) {
            deque.push(new com.bytedance.adsdk.qdl.ud.ud.qdl.wd(strSubstring));
        } else {
            deque.push(new oth(strSubstring));
        }
        return i2;
    }
}
