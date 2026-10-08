package com.bytedance.sdk.component.mo.qdl.qdl;

import com.bytedance.sdk.component.mo.qdl.jpc;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public class ud extends qdl {
    private final Queue<String> lnr;
    private final mml qdl;
    private final lnr ud;

    public ud() {
        ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
        this.lnr = concurrentLinkedQueue;
        this.qdl = new mo(concurrentLinkedQueue);
        this.ud = new lnr();
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.mml
    public synchronized void qdl(com.bytedance.sdk.component.mo.qdl.mml.qdl qdlVar, int i) {
        mml mmlVar;
        lnr lnrVar;
        if (i != 5) {
            if (jpc.wd().jtx().qdl(jpc.wd().mo()) && (mmlVar = this.qdl) != null && qdlVar != null) {
                mmlVar.qdl(qdlVar, i);
            }
            lnrVar = this.ud;
            if (lnrVar != null && qdlVar != null) {
                lnrVar.qdl(qdlVar, i);
            }
        } else {
            lnrVar = this.ud;
            if (lnrVar != null) {
                lnrVar.qdl(qdlVar, i);
            }
        }
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.mml
    public synchronized void qdl(int i, List<com.bytedance.sdk.component.mo.qdl.mml.qdl> list) {
        Iterator<com.bytedance.sdk.component.mo.qdl.mml.qdl> it = list.iterator();
        while (it.hasNext()) {
            this.lnr.remove(it.next().lnr());
        }
        mml mmlVar = this.qdl;
        if (mmlVar != null) {
            mmlVar.qdl(i, list);
        }
        lnr lnrVar = this.ud;
        if (lnrVar != null) {
            lnrVar.qdl(i, list);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0018 A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0009, B:7:0x000f, B:64:0x0148, B:67:0x014f, B:68:0x0153, B:70:0x0159, B:74:0x016b, B:11:0x0018, B:13:0x002b, B:15:0x0031, B:16:0x003d, B:18:0x0043, B:19:0x0051, B:20:0x005c, B:22:0x0062, B:23:0x006c, B:25:0x0072, B:27:0x0082, B:28:0x008a, B:29:0x008e, B:31:0x0094, B:32:0x00a2, B:33:0x00ad, B:35:0x00b3, B:36:0x00c1, B:37:0x00c6, B:39:0x00cf, B:41:0x00d5, B:42:0x00d8, B:44:0x00e0, B:46:0x00e6, B:47:0x00ef, B:49:0x00f5, B:50:0x0103, B:52:0x010c, B:53:0x0110, B:55:0x0116, B:57:0x0122, B:58:0x0126, B:59:0x0131, B:61:0x0137), top: B:80:0x0001 }] */
    @Override // com.bytedance.sdk.component.mo.qdl.qdl.mml
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.util.List<com.bytedance.sdk.component.mo.qdl.mml.qdl> qdl(int r7, int r8, java.util.List<java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.component.mo.qdl.qdl.ud.qdl(int, int, java.util.List):java.util.List");
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.mml
    public synchronized boolean qdl(int i, boolean z) {
        if (this.qdl.qdl(i, z)) {
            com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.kdv(), 1);
            return true;
        }
        if ((i != 1 && i != 2) || !this.ud.qdl(i, z)) {
            return false;
        }
        com.bytedance.sdk.component.mo.qdl.lnr.ud.qdl(com.bytedance.sdk.component.mo.qdl.ud.mml.mml.ekw(), 1);
        return true;
    }

    @Override // com.bytedance.sdk.component.mo.qdl.qdl.mml
    public void qdl(int i, long j) {
        this.ud.qdl(i, j);
        this.qdl.qdl(i, j);
    }
}
