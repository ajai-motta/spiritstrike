package com.bytedance.adsdk.ud.mo;

/* JADX INFO: loaded from: classes.dex */
public class ud {
    private static float qdl(float f) {
        return f <= 0.0031308f ? f * 12.92f : (float) ((Math.pow(f, 0.4166666567325592d) * 1.0549999475479126d) - 0.054999999701976776d);
    }

    private static float ud(float f) {
        return f <= 0.04045f ? f / 12.92f : (float) Math.pow((f + 0.055f) / 1.055f, 2.4000000953674316d);
    }

    public static int qdl(float f, int i, int i2) {
        if (i == i2) {
            return i;
        }
        float f2 = ((i >> 24) & 255) / 255.0f;
        float fUd = ud(((i >> 16) & 255) / 255.0f);
        float fUd2 = ud(((i >> 8) & 255) / 255.0f);
        float fUd3 = ud((i & 255) / 255.0f);
        float fUd4 = ud(((i2 >> 16) & 255) / 255.0f);
        float f3 = f2 + (((((i2 >> 24) & 255) / 255.0f) - f2) * f);
        float fUd5 = fUd2 + ((ud(((i2 >> 8) & 255) / 255.0f) - fUd2) * f);
        float fUd6 = fUd3 + (f * (ud((i2 & 255) / 255.0f) - fUd3));
        return (Math.round(qdl(fUd + ((fUd4 - fUd) * f)) * 255.0f) << 16) | (Math.round(f3 * 255.0f) << 24) | (Math.round(qdl(fUd5) * 255.0f) << 8) | Math.round(qdl(fUd6) * 255.0f);
    }
}
