package com.facebook.ads.redexgen.core;

import android.text.SpannableStringBuilder;
import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class KO {
    public static byte[] A00;
    public static String[] A01 = {"KgPme38LEDVaM0D12Uwlfvq6nYMDVVkT", "a5g98XiYqimDBheiX8ybcf7PetcT8W7U", "dRcctykKkiCtpnpKZqpaePhb1Qg1PkeN", "6JMbAfNKE0NkFS9oLsx1Zln6Fen7GSJu", "0ohFdoD3UqF2FgjtvUgt7lzB", "HqtC3No697vYpZ7G6OCOOOlSljo", "Ih90XUpH", "6OUjWPhHhDm3iVNi78UT7lOYQX351vXz"};

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public static KM A00(KM km, Map<String, KT> map) {
        while (km != null) {
            KT ktA02 = A02(km.A04, km.A0H(), map);
            if (ktA02 != null && ktA02.A09() == 1) {
                return km;
            }
            km = km.A03;
        }
        return null;
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A01;
            if (strArr[3].charAt(23) != strArr[0].charAt(23)) {
                throw new RuntimeException();
            }
            A01[6] = "lLmUOaES";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 115);
            i4++;
        }
    }

    public static void A05() {
        if (A01[2].charAt(10) == 'x') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[1] = "BbbzftLMD2m3WHwPv0bAANWrbX2mWIyE";
        strArr[7] = "7lYjBODxVBmaGubq4OQdXtxLEf46a0ab";
        A00 = new byte[]{-117, -75, -78, -103, -40, -30, -62, -40, -30, SignedBytes.MAX_POWER_OF_TWO, 88, 86, 93, 93, 86, 91, 84, Ascii.CR, 95, 98, 79, 102, 65, 82, 101, 97, Ascii.CR, 91, 92, 81, 82, Ascii.CR, 100, 86, 97, 85, 92, 98, 97, Ascii.CR, 82, 101, 78, 80, 97, 89, 102, Ascii.CR, 92, 91, 82, Ascii.CR, 97, 82, 101, 97, Ascii.CR, 80, 85, 86, 89, 81, Ascii.ESC, -10, Ascii.SYN, Ascii.SI, Ascii.SO, -12, 7, Ascii.DLE, 6, 7, Ascii.DC4, -9, Ascii.SYN, Ascii.VT, Ascii.SO, 73, Ascii.SO, -9, 74, 102, Ascii.RS, 48, -6, -5, 75, Ascii.EM};
    }

    static {
        A05();
    }

    public static KM A01(KM km, Map<String, KT> map) {
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(km);
        while (!arrayDeque.isEmpty()) {
            KM km2 = (KM) arrayDeque.pop();
            KT kt = km2.A04;
            String[] strArrA0H = km2.A0H();
            if (A01[6].length() != 8) {
                throw new RuntimeException();
            }
            A01[6] = "prCmMBcG";
            KT ktA02 = A02(kt, strArrA0H, map);
            if (ktA02 != null && ktA02.A09() == 3) {
                return km2;
            }
            for (int iA0C = km2.A0C() - 1; iA0C >= 0; iA0C--) {
                arrayDeque.push(km2.A0D(iA0C));
            }
        }
        return null;
    }

    public static KT A02(KT kt, String[] strArr, Map<String, KT> map) {
        int i = 0;
        if (kt == null) {
            if (strArr == null) {
                return null;
            }
            if (strArr.length == 1) {
                return map.get(strArr[0]);
            }
            if (strArr.length > 1) {
                KT kt2 = new KT();
                int length = strArr.length;
                while (i < length) {
                    kt2.A0O(map.get(strArr[i]));
                    i++;
                }
                return kt2;
            }
        } else {
            if (strArr != null && strArr.length == 1) {
                String str = strArr[0];
                String[] strArr2 = A01;
                if (strArr2[1].charAt(10) != strArr2[7].charAt(10)) {
                    throw new RuntimeException();
                }
                A01[5] = "FXnyxRIFGSjHG1Q4pZ8iBycDDGv";
                return kt.A0O(map.get(str));
            }
            if (strArr != null) {
                int length2 = strArr.length;
                if (A01[2].charAt(10) == 'x') {
                    throw new RuntimeException();
                }
                A01[5] = "6UN5UNrVzg6BSs5KXnnHYvLLh5S";
                if (length2 > 1) {
                    int length3 = strArr.length;
                    while (i < length3) {
                        KT kt3 = map.get(strArr[i]);
                        if (A01[5].length() != 27) {
                            throw new RuntimeException();
                        }
                        A01[2] = "LBM9N0gh5w8sQTAl6eCIViVepwnbqV6U";
                        kt.A0O(kt3);
                        i++;
                    }
                    return kt;
                }
            }
        }
        return kt;
    }

    public static String A04(String str) {
        String strA03 = A03(1, 2, 53);
        String strA032 = A03(0, 1, 14);
        String strReplaceAll = str.replaceAll(strA03, strA032);
        String out = A03(4, 5, 69);
        String strReplaceAll2 = strReplaceAll.replaceAll(out, strA032);
        String strA033 = A03(3, 1, 6);
        String strReplaceAll3 = strReplaceAll2.replaceAll(strA032, strA033);
        String out2 = A03(77, 11, 123);
        return strReplaceAll3.replaceAll(out2, strA033);
    }

    /* JADX WARN: Removed duplicated region for block: B:72:0x0174  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void A06(android.text.Spannable r8, int r9, int r10, com.facebook.ads.redexgen.core.KT r11, com.facebook.ads.redexgen.core.KM r12, java.util.Map<java.lang.String, com.facebook.ads.redexgen.core.KT> r13, int r14) {
        /*
            Method dump skipped, instruction units count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.KO.A06(android.text.Spannable, int, int, com.facebook.ads.redexgen.X.KT, com.facebook.ads.redexgen.X.KM, java.util.Map, int):void");
    }

    public static void A07(SpannableStringBuilder spannableStringBuilder) {
        int length = spannableStringBuilder.length() - 1;
        while (length >= 0 && spannableStringBuilder.charAt(length) == ' ') {
            length--;
        }
        if (length >= 0 && spannableStringBuilder.charAt(length) != '\n') {
            spannableStringBuilder.append('\n');
        }
    }
}
