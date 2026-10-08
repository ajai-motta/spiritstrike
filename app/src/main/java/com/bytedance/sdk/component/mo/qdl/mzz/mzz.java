package com.bytedance.sdk.component.mo.qdl.mzz;

import java.util.UUID;

/* JADX INFO: loaded from: classes3.dex */
public abstract class mzz implements Comparable<mzz>, Runnable {
    private String lnr;
    private int qdl = 5;
    private String ud = UUID.randomUUID().toString() + "-" + String.valueOf(System.nanoTime());

    public mzz(String str) {
        this.lnr = str;
    }

    public void qdl(int i) {
        this.qdl = i;
    }

    public int qdl() {
        return this.qdl;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public int compareTo(mzz mzzVar) {
        if (qdl() < mzzVar.qdl()) {
            return 1;
        }
        return qdl() >= mzzVar.qdl() ? -1 : 0;
    }
}
