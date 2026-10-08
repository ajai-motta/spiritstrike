package com.facebook.ads.redexgen.core;

import java.util.Arrays;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class JE {
    public static byte[] A05;
    public static String[] A06 = {"OUufb3XpwzKYnlflZdZ6sRl07O4y2xde", "sKTdS4Xom3soESmXE0UV17qKIdPOParu", "kk23Dr8l3bATGrEguhsdZQtf", "3jRjB5CH7VItg40f0wyJnaKmLrgr1NBM", "BH8vD2JIXWvofCU6hHaybnU4mVSHqFOc", "vohsQcTTzwLv029o6bcJNqcBVW1DxWoo", "Jn5KmPxuP80vuetXL26eN8MkgXOAz5Tn", "UdULkD"};
    public int A00;
    public final InterfaceC1272Hd A01;
    public final C1273He A02;
    public final JO A03;
    public final JR A04;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A06;
            if (strArr[1].charAt(29) == strArr[4].charAt(29)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[2] = "SmGAr1wQXpWbqjnIPPUcEk3V";
            strArr2[7] = "BndLoX";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 105);
            i4++;
        }
    }

    public static void A01() {
        A05 = new byte[]{-20, 0, -17, -12, -6, -70, -1, -3, 0, -16, -72, -13, -17};
    }

    static {
        A01();
    }

    public JE(JO jo, JR jr, InterfaceC1272Hd interfaceC1272Hd) {
        C1273He c1273He;
        this.A03 = jo;
        this.A04 = jr;
        this.A01 = interfaceC1272Hd;
        if (A00(0, 13, 34).equals(jo.A07.A0W)) {
            c1273He = new C1273He();
        } else {
            c1273He = null;
        }
        this.A02 = c1273He;
    }
}
