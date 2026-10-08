package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import com.bytedance.adsdk.qdl.ud.ud.qdl.aaj;
import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public class ud extends mo {
    @Override // com.bytedance.adsdk.qdl.ud.lnr.qdl.mo
    public int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar) {
        if ('\'' != qdl(i, str)) {
            return qdlVar.qdl(str, i, deque);
        }
        int i2 = i + 1;
        int length = str.length();
        int i3 = i2;
        while (i3 < length && qdl(i3, str) != '\'') {
            i3++;
        }
        if (qdl(i3, str) != '\'') {
            throw new com.bytedance.adsdk.qdl.qdl.qdl("String expression not surrounded by '", str.substring(i));
        }
        deque.push(new aaj(str.substring(i2, i3)));
        return i3 + 1;
    }
}
