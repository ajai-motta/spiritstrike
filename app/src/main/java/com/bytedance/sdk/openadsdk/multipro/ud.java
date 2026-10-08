package com.bytedance.sdk.openadsdk.multipro;

import com.bytedance.sdk.openadsdk.core.rdp;
import com.bytedance.sdk.openadsdk.multipro.aidl.BinderPoolService;

/* JADX INFO: loaded from: classes3.dex */
public class ud {
    public static Boolean qdl;

    public static void qdl() {
        qdl = Boolean.TRUE;
        com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_info", "is_support_multi_process", Boolean.TRUE);
    }

    public static void ud() {
        qdl = Boolean.FALSE;
        BinderPoolService.qdl = true;
    }

    public static boolean lnr() {
        Boolean bool = qdl;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (!rdp.mzz()) {
            return false;
        }
        if (qdl == null) {
            qdl = Boolean.valueOf(com.bytedance.sdk.openadsdk.multipro.mml.qdl.qdl("sp_multi_info", "is_support_multi_process", false));
        }
        return qdl.booleanValue();
    }
}
