package com.facebook.ads.redexgen.core;

import android.content.SharedPreferences;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.ads.internal.protocol.AdPlacementType;
import com.google.common.base.Ascii;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class WA {
    public static byte[] A0C;
    public static String[] A0D = {"u7auSF2QbA7keT455OtLfVATNnMuonV2", "9Ni6xyVwZaeKacoBimRjslH6Dei", "NGE2fLmKrMN6Gw2Fz9z7jAXvyfAydpGl", "srT3S5MN", "jMoNZ8Vk", "oZZQeSbHWWSZcPAQallJMC7N5h2", "GNfhbJ55AYf3nQ2lY9fIFOrmofPjrLRg", "qccEv4BxkjzqCatZiOtTgryF8DF84JXr"};
    public int A00;
    public T8 A01;
    public EnumC1640Vq A02;
    public C1686Xn A03;
    public String A04;
    public String A05;
    public String A06;
    public String A07;
    public boolean A08;
    public final U3 A09;
    public final AdPlacementType A0A;
    public final C1644Vu A0B;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 78);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A0C = new byte[]{-34, -95, -105, -102, -75, -101, -82, -90, -101, -88, -97, -101, -92, -103, -101, -75, -86, -81, -90, -101, -52, -49, -22, -35, -48, -37, -38, -35, -33, -44, -39, -46, -22, -50, -38, -39, -47, -44, -46, -22, -41, -52, -34, -33, -22, -32, -37, -49, -52, -33, -48, -22, -33, -44, -40, -48, Ascii.VT, Ascii.DC2, Ascii.CR, 40, Ascii.DC2, Ascii.CR, -29, -22, -27, 0, -11, -22, -18, -26, 0, -11, -16, -20, -26, -17, -105, -96, -99, -103, -94, -88, -77, -90, -103, -91, -87, -103, -89, -88, -77, -99, -104, -109, -97, -96, -96, -111, -59, -58, -50, -48, -32, -62, -59, -32, -54, -59, -74, -55, -59, -61, -78, -48, -71, -70, -65, -59, -60, -9, -12, -8, -10, -9, 3, -74, -79, -77, -82, -54, -59, -57, -62, -32, -57, -51, -62, -56, -92, -82, -70, -88, -80, -89, -81, -92, -70, -100, -97, -70, -96, -77, -85, -96, -83, -92, -96, -87, -98, -96, 4, 0, Ascii.CAN, Ascii.VT, -2, Ascii.FF, Ascii.CR, Ascii.VT, 2, -4, Ascii.CR, -2, -3, -34, -45, -27, -26, -15, -27, -45, -24, -41, -42, -15, -34, -31, -43, -45, -34, -41, -28, -21, -29, -11, -41, -38, -23, -11, -24, -37, -25, -21, -37, -23, -22, -37, -38, -77, -81, -92, -90, -88, -80, -88, -79, -73, -62, -84, -89, -50, -54, -65, -63, -61, -53, -61, -52, -46, -35, -46, -41, -50, -61, Ascii.NAK, 8, Ascii.DC4, Ascii.CAN, 8, Ascii.SYN, Ascii.ETB, 34, Ascii.ETB, Ascii.FF, Ascii.DLE, 8, -4, -3, -22, -20, -12, 8, -3, -5, -22, -20, -18, -7, -22, -14, -11, -15, -26, -7, -22, 4, -18, -23, -58, -73, -59, -58, -47, -65, -63, -74, -73, -13, -27, -32, -16, -28};
    }

    static {
        A02();
    }

    public WA(T8 t8, String str, C1686Xn c1686Xn, EnumC1640Vq enumC1640Vq, int i, C1644Vu c1644Vu, String str2, String str3, String str4, U3 u3) {
        this.A01 = t8;
        this.A06 = str;
        this.A03 = c1686Xn;
        this.A02 = enumC1640Vq;
        this.A00 = i;
        this.A0B = c1644Vu;
        this.A0A = enumC1640Vq.A05(this.A01);
        this.A07 = str2;
        this.A05 = str3;
        this.A04 = str4;
        this.A09 = u3;
    }

    private long A00() {
        SharedPreferences sharedPreferencesA00 = WN.A00(this.A01);
        String strA01 = A01(0, 0, 79);
        String strA012 = A01(TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, 17, 68);
        String lastSavedLocale = sharedPreferencesA00.getString(strA012, strA01);
        if (lastSavedLocale == null) {
            return 0L;
        }
        if (lastSavedLocale.equals(Locale.getDefault().toString())) {
            return AbstractC1456Oh.A00(this.A01.A02()).A09();
        }
        sharedPreferencesA00.edit().putString(strA012, Locale.getDefault().toString()).apply();
        return 0L;
    }

    private void A03(Map<String, String> params, String str, String str2) {
        params.put(str, str2);
    }

    public final int A04() {
        return this.A00;
    }

    public final U3 A05() {
        return this.A09;
    }

    public final AdPlacementType A06() {
        return this.A0A;
    }

    public final EnumC1640Vq A07() {
        return this.A02;
    }

    public final C1686Xn A08() {
        return this.A03;
    }

    public final String A09() {
        return this.A06;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A0A(java.util.Map<java.lang.String, java.lang.String> r9) {
        /*
            Method dump skipped, instruction units count: 687
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.WA.A0A(java.util.Map):java.util.Map");
    }
}
