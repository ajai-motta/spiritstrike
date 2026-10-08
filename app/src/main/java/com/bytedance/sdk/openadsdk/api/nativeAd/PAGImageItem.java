package com.bytedance.sdk.openadsdk.api.nativeAd;

/* JADX INFO: loaded from: classes3.dex */
public class PAGImageItem {
    private final String lnr;
    private float mml;
    private final int qdl;
    private final int ud;

    public PAGImageItem(int i, int i2, String str, float f) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = str;
        this.mml = f;
    }

    public PAGImageItem(int i, int i2, String str) {
        this(i, i2, str, 0.0f);
    }

    public int getHeight() {
        return this.qdl;
    }

    public int getWidth() {
        return this.ud;
    }

    public String getImageUrl() {
        return this.lnr;
    }

    public float getDuration() {
        return this.mml;
    }
}
