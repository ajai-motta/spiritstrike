package com.bytedance.adsdk.qdl.ud.lnr.qdl;

import java.util.Deque;

/* JADX INFO: loaded from: classes.dex */
public abstract class mo {
    public abstract int qdl(String str, int i, Deque<com.bytedance.adsdk.qdl.ud.ud.qdl> deque, com.bytedance.adsdk.qdl.ud.lnr.qdl qdlVar);

    protected char qdl(int i, String str) {
        if (i >= str.length()) {
            return (char) 26;
        }
        return str.charAt(i);
    }

    protected int ud(int i, String str) {
        while (com.bytedance.adsdk.qdl.ud.mzz.qdl.qdl(qdl(i, str))) {
            i++;
        }
        return i;
    }
}
