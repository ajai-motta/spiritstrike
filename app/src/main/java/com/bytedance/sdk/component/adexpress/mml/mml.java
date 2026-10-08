package com.bytedance.sdk.component.adexpress.mml;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public class mml {
    public static void qdl(com.bytedance.sdk.component.jpc.jpc jpcVar, int i) {
        if (jpcVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.qdl.qdl.lnr lnrVarLnr = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr();
        ExecutorService executorServiceRdp = lnrVarLnr != null ? lnrVarLnr.rdp() : null;
        if (executorServiceRdp != null) {
            jpcVar.setPriority(i);
            executorServiceRdp.execute(jpcVar);
        } else {
            com.bytedance.sdk.component.jpc.mo.qdl(jpcVar, i);
        }
    }

    public static void ud(com.bytedance.sdk.component.jpc.jpc jpcVar, int i) {
        if (jpcVar == null) {
            return;
        }
        com.bytedance.sdk.component.adexpress.qdl.qdl.lnr lnrVarLnr = com.bytedance.sdk.component.adexpress.qdl.qdl.qdl.qdl().lnr();
        ExecutorService executorServiceExu = lnrVarLnr != null ? lnrVarLnr.exu() : null;
        if (executorServiceExu != null) {
            jpcVar.setPriority(i);
            executorServiceExu.execute(jpcVar);
        } else {
            com.bytedance.sdk.component.jpc.mo.qdl(jpcVar);
        }
    }

    public static ScheduledFuture qdl(Runnable runnable, long j, TimeUnit timeUnit) {
        return com.bytedance.sdk.component.jpc.mo.mo().schedule(runnable, j, timeUnit);
    }
}
