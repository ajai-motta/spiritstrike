package com.bytedance.sdk.openadsdk;

/* JADX INFO: loaded from: classes3.dex */
public class TTImage {
    private final String lnr;
    private double mml;
    private final int qdl;
    private final int ud;

    public TTImage(int i, int i2, String str, double d) {
        this.qdl = i;
        this.ud = i2;
        this.lnr = str;
        this.mml = d;
    }

    public TTImage(int i, int i2, String str) {
        this(i, i2, str, 0.0d);
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

    public double getDuration() {
        return this.mml;
    }

    public boolean isValid() {
        String str;
        return this.qdl > 0 && this.ud > 0 && (str = this.lnr) != null && str.length() > 0;
    }
}
