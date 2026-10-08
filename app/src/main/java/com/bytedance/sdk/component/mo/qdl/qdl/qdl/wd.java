package com.bytedance.sdk.component.mo.qdl.qdl.qdl;

import com.bytedance.sdk.component.mo.qdl.jpc;

/* JADX INFO: loaded from: classes3.dex */
public class wd {
    public static String qdl = "com.bytedance.openadsdk";
    public static String ud = "content://" + qdl + ".TTMultiProvider";

    static {
        qdl();
    }

    public static void qdl() {
        if (jpc.wd().mo() != null) {
            qdl = jpc.wd().mo().getPackageName();
            ud = "content://" + qdl + ".TTMultiProvider";
        }
    }
}
