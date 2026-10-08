package com.bytedance.adsdk.ud.mo;

/* JADX INFO: loaded from: classes.dex */
public class mml {
    private float qdl;
    private int ud;

    public void qdl(float f) {
        float f2 = this.qdl + f;
        this.qdl = f2;
        int i = this.ud + 1;
        this.ud = i;
        if (i == Integer.MAX_VALUE) {
            this.qdl = f2 / 2.0f;
            this.ud = i / 2;
        }
    }
}
