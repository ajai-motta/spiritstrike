package com.bytedance.sdk.component.mo.qdl.qdl.ud;

import com.bytedance.sdk.component.mo.qdl.mml.qdl;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes3.dex */
public abstract class mml<T extends com.bytedance.sdk.component.mo.qdl.mml.qdl> {
    private Queue<String> lnr;
    private String mml;
    private com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdl;
    private Queue<T> ud = new ConcurrentLinkedQueue();

    public mml(com.bytedance.sdk.component.mo.qdl.mml.ud.qdl qdlVar, Queue<String> queue, String str) {
        this.qdl = qdlVar;
        this.lnr = queue;
        this.mml = str;
    }

    public void qdl(T t) {
        Queue<T> queue = this.ud;
        if (queue == null || t == null) {
            return;
        }
        queue.offer(t);
    }

    public synchronized List<com.bytedance.sdk.component.mo.qdl.mml.qdl> qdl(int i, int i2) {
        if (!ud(i, i2)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.qdl.qdl());
        do {
            T tPoll = this.ud.poll();
            if (tPoll == null) {
                break;
            }
            arrayList.add(tPoll);
        } while (arrayList.size() != this.qdl.ud());
        return arrayList;
    }

    public synchronized void qdl(int i, List<T> list) {
        if (i == -1 || i == 200 || i == 509) {
            this.ud.size();
        } else {
            this.ud.addAll(list);
        }
    }

    public synchronized boolean ud(int i, int i2) {
        int size = this.ud.size();
        int iQdl = this.qdl.qdl();
        return (i == 2 || i == 1) ? com.bytedance.sdk.component.mo.qdl.lnr.qdl.lnr() ? size > 0 : size >= iQdl : size >= iQdl;
    }
}
