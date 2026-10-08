package com.bytedance.sdk.component.jpc.qdl;

import com.bytedance.sdk.component.jpc.qdl.lnr;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: classes3.dex */
public class mml<T extends lnr> {
    private int qdl;
    private BlockingQueue<T> ud = new LinkedBlockingQueue();

    public static mml qdl(int i) {
        return new mml(i);
    }

    private mml(int i) {
        this.qdl = i;
    }

    public T qdl() {
        return this.ud.poll();
    }

    public boolean qdl(T t) {
        if (t == null) {
            return false;
        }
        t.qdl();
        if (this.ud.size() >= this.qdl) {
            return false;
        }
        return this.ud.offer(t);
    }
}
