package com.hive.ui.effect;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import androidx.core.view.MotionEventCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ProcessBlur.kt */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"Lcom/hive/ui/effect/ProcessBlur;", "", "<init>", "()V", "takeScreenShot", "Landroid/graphics/Bitmap;", "activity", "Landroid/app/Activity;", "fastblur", "sentBitmap", "radius", "", "hive-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ProcessBlur {
    public static final ProcessBlur INSTANCE = new ProcessBlur();

    private ProcessBlur() {
    }

    public final Bitmap takeScreenShot(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        View decorView = activity.getWindow().getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "getDecorView(...)");
        decorView.setDrawingCacheEnabled(true);
        decorView.buildDrawingCache();
        Bitmap drawingCache = decorView.getDrawingCache();
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        int i = rect.top;
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, 0, i, activity.getWindowManager().getDefaultDisplay().getWidth(), activity.getWindowManager().getDefaultDisplay().getHeight() - i);
        Intrinsics.checkNotNullExpressionValue(bitmapCreateBitmap, "createBitmap(...)");
        decorView.destroyDrawingCache();
        return bitmapCreateBitmap;
    }

    public final Bitmap fastblur(Bitmap sentBitmap, int radius) {
        int[] iArr;
        int i = radius;
        Intrinsics.checkNotNullParameter(sentBitmap, "sentBitmap");
        Bitmap.Config config = sentBitmap.getConfig();
        Bitmap bitmapCopy = config != null ? sentBitmap.copy(config, true) : null;
        if (i < 1 || bitmapCopy == null) {
            return null;
        }
        int width = bitmapCopy.getWidth();
        int height = bitmapCopy.getHeight();
        int i2 = width * height;
        int[] iArr2 = new int[i2];
        StringBuilder sb = new StringBuilder();
        sb.append(width);
        sb.append(' ');
        sb.append(height);
        sb.append(' ');
        sb.append(i2);
        Log.e("pix", sb.toString());
        bitmapCopy.getPixels(iArr2, 0, width, 0, 0, width, height);
        int i3 = width - 1;
        int i4 = height - 1;
        int i5 = i + i;
        int i6 = i5 + 1;
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        int[] iArr5 = new int[i2];
        int[] iArr6 = new int[Math.max(width, height)];
        int i7 = (i5 + 2) >> 1;
        int i8 = i7 * i7;
        int i9 = i8 * 256;
        int[] iArr7 = new int[i9];
        Bitmap bitmap = bitmapCopy;
        for (int i10 = 0; i10 < i9; i10++) {
            iArr7[i10] = i10 / i8;
        }
        int[][] iArr8 = new int[i6][];
        for (int i11 = 0; i11 < i6; i11++) {
            iArr8[i11] = new int[3];
        }
        int i12 = i + 1;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        while (i13 < height) {
            int i16 = i2;
            int i17 = -i;
            int i18 = 0;
            int i19 = 0;
            int i20 = 0;
            int i21 = 0;
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            int i26 = 0;
            while (i17 <= i) {
                int i27 = height;
                int i28 = i4;
                int i29 = iArr2[i14 + Math.min(i3, Math.max(i17, 0))];
                int[] iArr9 = iArr8[i17 + i];
                iArr9[0] = (i29 & 16711680) >> 16;
                iArr9[1] = (i29 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr9[2] = i29 & 255;
                int iAbs = i12 - Math.abs(i17);
                int i30 = iArr9[0];
                i18 += i30 * iAbs;
                int i31 = iArr9[1];
                i19 += i31 * iAbs;
                int i32 = iArr9[2];
                i20 += iAbs * i32;
                if (i17 > 0) {
                    i24 += i30;
                    i25 += i31;
                    i26 += i32;
                } else {
                    i21 += i30;
                    i22 += i31;
                    i23 += i32;
                }
                i17++;
                height = i27;
                i4 = i28;
            }
            int i33 = height;
            int i34 = i4;
            int i35 = i;
            int i36 = 0;
            while (i36 < width) {
                iArr3[i14] = iArr7[i18];
                iArr4[i14] = iArr7[i19];
                iArr5[i14] = iArr7[i20];
                int i37 = i18 - i21;
                int i38 = i19 - i22;
                int i39 = i20 - i23;
                int[] iArr10 = iArr8[((i35 - i) + i6) % i6];
                int i40 = i21 - iArr10[0];
                int i41 = i22 - iArr10[1];
                int i42 = i23 - iArr10[2];
                if (i13 == 0) {
                    iArr = iArr7;
                    iArr6[i36] = Math.min(i36 + i + 1, i3);
                } else {
                    iArr = iArr7;
                }
                int i43 = iArr2[i15 + iArr6[i36]];
                int i44 = (i43 & 16711680) >> 16;
                iArr10[0] = i44;
                int i45 = (i43 & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8;
                iArr10[1] = i45;
                int i46 = i43 & 255;
                iArr10[2] = i46;
                int i47 = i24 + i44;
                int i48 = i25 + i45;
                int i49 = i26 + i46;
                i18 = i37 + i47;
                i19 = i38 + i48;
                i20 = i39 + i49;
                i35 = (i35 + 1) % i6;
                int[] iArr11 = iArr8[i35 % i6];
                int i50 = iArr11[0];
                i21 = i40 + i50;
                int i51 = iArr11[1];
                i22 = i41 + i51;
                int i52 = iArr11[2];
                i23 = i42 + i52;
                i24 = i47 - i50;
                i25 = i48 - i51;
                i26 = i49 - i52;
                i14++;
                i36++;
                iArr7 = iArr;
            }
            i15 += width;
            i13++;
            i2 = i16;
            height = i33;
            i4 = i34;
        }
        int i53 = height;
        int[] iArr12 = iArr7;
        int i54 = i4;
        int i55 = i2;
        int i56 = 0;
        while (i56 < width) {
            int i57 = -i;
            int i58 = i57 * width;
            int i59 = 0;
            int i60 = 0;
            int i61 = 0;
            int i62 = 0;
            int i63 = 0;
            int i64 = 0;
            int i65 = 0;
            int i66 = 0;
            int i67 = 0;
            while (i57 <= i) {
                int[] iArr13 = iArr6;
                int iMax = Math.max(0, i58) + i56;
                int[] iArr14 = iArr8[i57 + i];
                iArr14[0] = iArr3[iMax];
                iArr14[1] = iArr4[iMax];
                iArr14[2] = iArr5[iMax];
                int iAbs2 = i12 - Math.abs(i57);
                i59 += iArr3[iMax] * iAbs2;
                i60 += iArr4[iMax] * iAbs2;
                i61 += iArr5[iMax] * iAbs2;
                if (i57 > 0) {
                    i65 += iArr14[0];
                    i66 += iArr14[1];
                    i67 += iArr14[2];
                } else {
                    i62 += iArr14[0];
                    i63 += iArr14[1];
                    i64 += iArr14[2];
                }
                int i68 = i54;
                if (i57 < i68) {
                    i58 += width;
                }
                i57++;
                i54 = i68;
                iArr6 = iArr13;
            }
            int[] iArr15 = iArr6;
            int i69 = i54;
            int i70 = i;
            int i71 = i56;
            int i72 = i53;
            int i73 = 0;
            while (i73 < i72) {
                iArr2[i71] = (iArr2[i71] & (-16777216)) | (iArr12[i59] << 16) | (iArr12[i60] << 8) | iArr12[i61];
                int i74 = i59 - i62;
                int i75 = i60 - i63;
                int i76 = i61 - i64;
                int[] iArr16 = iArr8[((i70 - i) + i6) % i6];
                int i77 = i62 - iArr16[0];
                int i78 = i63 - iArr16[1];
                int i79 = i64 - iArr16[2];
                if (i56 == 0) {
                    iArr15[i73] = Math.min(i73 + i12, i69) * width;
                }
                int i80 = iArr15[i73] + i56;
                int i81 = iArr3[i80];
                iArr16[0] = i81;
                int i82 = iArr4[i80];
                iArr16[1] = i82;
                int i83 = iArr5[i80];
                iArr16[2] = i83;
                int i84 = i65 + i81;
                int i85 = i66 + i82;
                int i86 = i67 + i83;
                i59 = i74 + i84;
                i60 = i75 + i85;
                i61 = i76 + i86;
                i70 = (i70 + 1) % i6;
                int[] iArr17 = iArr8[i70];
                int i87 = iArr17[0];
                i62 = i77 + i87;
                int i88 = iArr17[1];
                i63 = i78 + i88;
                int i89 = iArr17[2];
                i64 = i79 + i89;
                i65 = i84 - i87;
                i66 = i85 - i88;
                i67 = i86 - i89;
                i71 += width;
                i73++;
                i = radius;
            }
            i56++;
            i = radius;
            i53 = i72;
            i54 = i69;
            iArr6 = iArr15;
        }
        int i90 = i53;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(width);
        sb2.append(' ');
        sb2.append(i90);
        sb2.append(' ');
        sb2.append(i55);
        Log.e("pix", sb2.toString());
        bitmap.setPixels(iArr2, 0, width, 0, 0, width, i90);
        return bitmap;
    }
}
