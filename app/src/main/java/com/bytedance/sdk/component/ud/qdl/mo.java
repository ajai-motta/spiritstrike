package com.bytedance.sdk.component.ud.qdl;

/* JADX INFO: loaded from: classes3.dex */
public final class mo {
    private final String[] qdl;

    public mo(String[] strArr) {
        this.qdl = strArr;
    }

    public int qdl() {
        return this.qdl.length / 2;
    }

    public String qdl(int i) {
        return this.qdl[i * 2];
    }

    public String ud(int i) {
        return this.qdl[(i * 2) + 1];
    }
}
