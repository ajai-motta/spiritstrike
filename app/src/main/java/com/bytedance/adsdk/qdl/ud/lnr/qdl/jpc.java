package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import com.bytedance.adsdk.qdl.ud.ud.qdl.jtx;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class jpc extends mo {
    @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl.mo
    public int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        if (!com.bytedance.adsdk.qdl.ud.mzz.qdl.mml(qdl(i, str))) {
            return qdlVar.qdl(str, i, deque);
        }
        int i2 = i + 1;
        String str2 = new String(new char[]{qdl(i, str), qdl(i2, str)});
        if (com.bytedance.adsdk.qdl.ud.mml.lnr.qdl(str2) != null) {
            deque.push(new jtx(com.bytedance.adsdk.qdl.ud.mml.lnr.qdl(str2)));
            return i + 2;
        }
        String strValueOf = String.valueOf(qdl(i, str));
        if (com.bytedance.adsdk.qdl.ud.mml.lnr.qdl(strValueOf) != null) {
            deque.push(new jtx(com.bytedance.adsdk.qdl.ud.mml.lnr.qdl(strValueOf)));
            return i2;
        }
        throw new IllegalArgumentException("Unrecognized:" + strValueOf + "examine:" + str.substring(0, i));
    }
}
