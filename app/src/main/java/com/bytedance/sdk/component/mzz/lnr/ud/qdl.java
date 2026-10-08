package com.bytedance.sdk.component.mzz.lnr.ud;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/* JADX INFO: loaded from: classes3.dex */
public class qdl {
    public static final ImageView.ScaleType qdl = ImageView.ScaleType.CENTER_INSIDE;
    public static final Bitmap.Config ud = Bitmap.Config.ARGB_4444;
    private final ImageView.ScaleType jpc;
    private final Bitmap.Config lnr;
    private int mml;
    private final int mo;
    private int mzz;
    private final int wd;
    private final int tvp = 3840;
    private final int to = 104857600;

    public qdl(int i, int i2, ImageView.ScaleType scaleType, Bitmap.Config config, int i3, int i4) {
        this.lnr = config;
        this.mml = i;
        this.mzz = i2;
        this.jpc = scaleType;
        this.mo = i3;
        this.wd = i4;
        qdl(i, i2);
    }

    static int qdl(int i, int i2, int i3, int i4, int i5, int i6) {
        double dMin = Math.min(((double) i) / ((double) i3), ((double) i2) / ((double) i4));
        if (i5 > 0 && i6 > 0) {
            dMin = Math.max(dMin, Math.min(((double) Math.max(i, i2)) / ((double) Math.max(i5, i6)), ((double) Math.min(i, i2)) / ((double) Math.min(i5, i6))));
        }
        float f = 1.0f;
        while (true) {
            float f2 = 2.0f * f;
            if (f2 > dMin) {
                return (int) f;
            }
            f = f2;
        }
    }

    private static int qdl(int i, int i2, int i3, int i4, ImageView.ScaleType scaleType) {
        if (i == 0 && i2 == 0) {
            return i3;
        }
        if (scaleType == ImageView.ScaleType.FIT_XY) {
            return i == 0 ? i3 : i;
        }
        if (i == 0) {
            return (int) (((double) i3) * (((double) i2) / ((double) i4)));
        }
        if (i2 == 0) {
            return i;
        }
        double d = ((double) i4) / ((double) i3);
        if (scaleType == ImageView.ScaleType.CENTER_CROP) {
            double d2 = i2;
            return ((double) i) * d < d2 ? (int) (d2 / d) : i;
        }
        double d3 = i2;
        return ((double) i) * d > d3 ? (int) (d3 / d) : i;
    }

    public Bitmap qdl(byte[] bArr) {
        Bitmap bitmapDecodeByteArray;
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.mml == 0 && this.mzz == 0) {
            options.inPreferredConfig = this.lnr;
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int iQdl = qdl(this.mml, this.mzz, i, i2, this.jpc);
            int iQdl2 = qdl(this.mzz, this.mml, i2, i, this.jpc);
            options.inJustDecodeBounds = false;
            options.inSampleSize = qdl(i, i2, iQdl, iQdl2, this.mo, this.wd);
            bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (bitmapDecodeByteArray != null && (bitmapDecodeByteArray.getWidth() > iQdl || bitmapDecodeByteArray.getHeight() > iQdl2)) {
                Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeByteArray, iQdl, iQdl2, true);
                if (bitmapCreateScaledBitmap != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                bitmapDecodeByteArray = bitmapCreateScaledBitmap;
            }
        }
        if (bitmapDecodeByteArray != null && bitmapDecodeByteArray.getByteCount() > 104857600) {
            int width = bitmapDecodeByteArray.getWidth() / 2;
            int height = bitmapDecodeByteArray.getHeight() / 2;
            if (width > 0 && height > 0) {
                Bitmap bitmapCreateScaledBitmap2 = Bitmap.createScaledBitmap(bitmapDecodeByteArray, width, height, true);
                if (bitmapCreateScaledBitmap2 != bitmapDecodeByteArray) {
                    bitmapDecodeByteArray.recycle();
                }
                return bitmapCreateScaledBitmap2;
            }
        }
        return bitmapDecodeByteArray;
    }

    private void qdl(int i, int i2) {
        if (i > 3840 && i2 > 3840) {
            if (i > i2) {
                this.mml = 3840;
                this.mzz = (i2 * 3840) / i;
                return;
            } else {
                this.mml = (i * 3840) / i2;
                this.mzz = 3840;
                return;
            }
        }
        if (i > 3840) {
            this.mml = 3840;
            this.mzz = (i2 * 3840) / i;
        } else if (i2 > 3840) {
            this.mml = (i * 3840) / i2;
            this.mzz = 3840;
        }
    }
}
