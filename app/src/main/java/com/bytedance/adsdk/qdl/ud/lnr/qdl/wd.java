package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import com.bytedance.adsdk.qdl.ud.ud.qdl.bjy;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class wd extends mo {
    private boolean qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque) {
        if ('-' == qdl(i, str)) {
            if (deque.peek() != null && !com.bytedance.adsdk.qdl.ud.mml.lnr.qdl(deque.peek().qdl())) {
                return false;
            }
            if (com.bytedance.adsdk.qdl.ud.mzz.qdl.lnr(qdl(i + 1, str))) {
                return true;
            }
            throw new IllegalArgumentException("Unrecognized - symbol, not a negative number or operator, problem range:" + str.substring(0, i));
        }
        return com.bytedance.adsdk.qdl.ud.mzz.qdl.lnr(qdl(i, str));
    }

    @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl.mo
    public int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        char cQdl;
        if (!qdl(str, i, deque)) {
            return qdlVar.qdl(str, i, deque);
        }
        int i2 = qdl(i, str) == '-' ? i + 1 : i;
        boolean z = false;
        while (true) {
            cQdl = qdl(i2, str);
            if (!com.bytedance.adsdk.qdl.ud.mzz.qdl.lnr(cQdl) && (z || cQdl != '.')) {
                break;
            }
            i2++;
            if (cQdl == '.') {
                z = true;
            }
        }
        if (cQdl == '.') {
            throw new IllegalArgumentException("Illegal negative number format, problem interval:" + str.substring(i, i2));
        }
        deque.push(new bjy(str.substring(i, i2)));
        return i2;
    }
}
