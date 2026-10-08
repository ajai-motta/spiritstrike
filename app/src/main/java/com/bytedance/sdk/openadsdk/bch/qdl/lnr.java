package com.bytedance.sdk.openadsdk.bch.qdl;

import com.bytedance.sdk.openadsdk.core.model.ljh;

/* JADX INFO: loaded from: classes3.dex */
public class lnr {
    public static String lnr = "engaged_view";
    public static boolean qdl = false;
    public static int ud = 6;

    public static void qdl(ljh ljhVar) {
        ud udVarLnr = lnr(ljhVar);
        if (udVarLnr == null) {
            return;
        }
        udVarLnr.qdl();
    }

    public static void ud(ljh ljhVar) {
        ud udVarLnr = lnr(ljhVar);
        if (udVarLnr == null) {
            return;
        }
        udVarLnr.ud();
    }

    public static void qdl(ljh ljhVar, int i) {
        ud udVarLnr = lnr(ljhVar);
        if (udVarLnr == null || udVarLnr.lnr()) {
            return;
        }
        udVarLnr.qdl(i);
    }

    public static void qdl(ljh ljhVar, boolean z) {
        ud udVarLnr = lnr(ljhVar);
        if (udVarLnr == null || udVarLnr.lnr()) {
            return;
        }
        udVarLnr.qdl(z);
        udVarLnr.qdl(z ? 4 : 8);
    }

    private static ud lnr(ljh ljhVar) {
        if (ljhVar == null || !ljhVar.jzw()) {
            return null;
        }
        return ljhVar.qo();
    }
}
