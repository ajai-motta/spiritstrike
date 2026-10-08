package com.facebook.ads.redexgen.core;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.eE, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC2012eE {
    public static boolean A00;
    public static byte[] A01;
    public static String[] A02 = {"LOnHKZUk03MjG3VYzMMYiec9SpPsFOh7", "Pbkw0DRwc7jrPzgwHcPKSBrc9yMoULer", "Hj", "S7", "LLbZvFImhG4qXHtXSuU8lE9QXb8BQ4aR", "3BEuw5zYnH62E4dXOlScK8tmPuoX0Dzi", "Tjz3D17CMTsDMz51rRXrrUvPJCeC", "mII8e5HllIg"};

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{81, 124, 102, 101, 121, 116, 108, 88, 112, 97, 103, 124, 118, 102, 53, 124, 102, 53, 123, 96, 121, 121, 59, Ascii.EM, 46, 56, 36, 62, 57, 40, 46, 56, 107, 34, 56, 107, 37, 62, 39, 39, 101, 37, Ascii.DC2, Ascii.US, Ascii.SUB, Ascii.ETB, Ascii.DC2, 7, Ascii.SUB, Ascii.FS, Ascii.GS, 83, Ascii.NAK, Ascii.DC2, Ascii.SUB, Ascii.US, Ascii.SYN, Ascii.ETB, 93, 107, 105, 106};
    }

    static {
        A03();
        A00 = true;
    }

    public static BitmapDrawable A00(C2165gi c2165gi, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            byte[] bArrDecode = Base64.decode(str, 0);
            Bitmap overlayBm = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
            if (overlayBm != null && (!A00 || A05(c2165gi, overlayBm))) {
                BitmapDrawable overlayRepeat = new BitmapDrawable(overlayBm);
                overlayRepeat.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                Resources resources = c2165gi.getResources();
                if (resources != null) {
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    if (displayMetrics != null) {
                        overlayRepeat.setTargetDensity(displayMetrics.densityDpi);
                    } else {
                        A04(c2165gi, A02(0, 23, 41));
                    }
                } else {
                    A04(c2165gi, A02(23, 18, 119));
                }
                return overlayRepeat;
            }
            return null;
        } catch (Throwable th) {
            c2165gi.A08().ABC(A02(59, 3, 58), AbstractC1577Td.A1u, new C1578Te(th));
            return null;
        }
    }

    public static C2013eF A01(C2165gi c2165gi, String str) {
        BitmapDrawable bitmapDrawableA00;
        try {
            if (TextUtils.isEmpty(str) || (bitmapDrawableA00 = A00(c2165gi, str)) == null) {
                return null;
            }
            C2013eF c2013eF = new C2013eF(c2165gi);
            c2013eF.setBackground(bitmapDrawableA00);
            c2013eF.setClickable(false);
            c2013eF.setFocusable(false);
            return c2013eF;
        } catch (Throwable th) {
            c2165gi.A08().ABC(A02(59, 3, 58), AbstractC1577Td.A1u, new C1578Te(th));
            return null;
        }
    }

    public static void A04(C2165gi c2165gi, String str) {
        c2165gi.A08().ABC(A02(59, 3, 58), AbstractC1577Td.A1u, new C1578Te(str));
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0005 */
    /* JADX WARN: Incorrect condition in loop: B:7:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A05(com.facebook.ads.redexgen.core.C2165gi r4, android.graphics.Bitmap r5) {
        /*
            r3 = 0
        L1:
            int r0 = r5.getWidth()
            if (r3 >= r0) goto L36
            r2 = 0
        L8:
            int r0 = r5.getHeight()
            if (r2 >= r0) goto L33
            int r0 = r5.getPixel(r3, r2)
            int r0 = android.graphics.Color.alpha(r0)
            float r1 = (float) r0
            r0 = 1132396544(0x437f0000, float:255.0)
            float r1 = r1 / r0
            r0 = 1022739087(0x3cf5c28f, float:0.03)
            int r0 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r0 <= 0) goto L30
            r2 = 41
            r1 = 18
            r0 = 79
            java.lang.String r0 = A02(r2, r1, r0)
            A04(r4, r0)
            r0 = 0
            return r0
        L30:
            int r2 = r2 + 1
            goto L8
        L33:
            int r3 = r3 + 1
            goto L1
        L36:
            r3 = 1
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC2012eE.A02
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L4f
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L4f:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC2012eE.A02
            java.lang.String r1 = "LR4kTGqXNNTRbn07qZCCCo1h4xvtCqSD"
            r0 = 0
            r2[r0] = r1
            java.lang.String r1 = "LZTU5gCJod3YylAEiVGeMzo2seGubyq7"
            r0 = 4
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC2012eE.A05(com.facebook.ads.redexgen.X.gi, android.graphics.Bitmap):boolean");
    }
}
