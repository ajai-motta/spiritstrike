package com.bytedance.sdk.component.jpc;

/* JADX INFO: loaded from: classes3.dex */
public abstract class jpc implements Comparable<jpc>, Runnable {
    private int qdl;
    private String ud;

    public jpc(String str, int i) {
        this.qdl = 0;
        this.qdl = i == 0 ? 5 : i;
        this.ud = str;
    }

    public jpc(String str) {
        this.qdl = 5;
        this.ud = str;
    }

    public void setPriority(int i) {
        this.qdl = i;
    }

    public int getPriority() {
        return this.qdl;
    }

    @Override // java.lang.Comparable
    public int compareTo(jpc jpcVar) {
        if (getPriority() < jpcVar.getPriority()) {
            return 1;
        }
        return getPriority() >= jpcVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.ud;
    }
}
