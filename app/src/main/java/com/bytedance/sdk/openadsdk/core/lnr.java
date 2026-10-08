package com.bytedance.sdk.openadsdk.core;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    private static volatile lnr qdl;

    private lnr() {
    }

    public static lnr qdl() {
        if (qdl == null) {
            synchronized (lnr.class) {
                if (qdl == null) {
                    qdl = new lnr();
                }
            }
        }
        return qdl;
    }

    public void qdl(String str, String str2) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("ttopenadsdk", str, str2);
    }

    public String ud(String str, String str2) {
        return com.bytedance.sdk.openadsdk.multipro.mml.mml.ud("ttopenadsdk", str, str2);
    }

    public void qdl(String str, int i) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("ttopenadsdk", str, Integer.valueOf(i));
    }

    public int ud(String str, int i) {
        return com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("ttopenadsdk", str, i);
    }

    public void qdl(String str, long j) {
        com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("ttopenadsdk", str, Long.valueOf(j));
    }

    public Long ud(String str, long j) {
        return Long.valueOf(com.bytedance.sdk.openadsdk.multipro.mml.mml.qdl("ttopenadsdk", str, j));
    }
}
