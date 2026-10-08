package com.bytedance.sdk.component.mo.qdl.mo;

import com.bytedance.sdk.component.mo.qdl.jpc;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    private static volatile ud qdl;

    public static ud qdl() {
        if (qdl == null) {
            synchronized (ud.class) {
                if (qdl == null) {
                    qdl = new lnr(jpc.wd().mo(), new mo(jpc.wd().mo()));
                }
            }
        }
        return qdl;
    }
}
