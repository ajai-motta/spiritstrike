package com.facebook.ads.redexgen.core;

import android.content.pm.PackageInfo;
import android.text.TextUtils;
import android.util.Base64OutputStream;
import com.google.common.base.Ascii;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.zip.DeflaterOutputStream;
import org.json.JSONObject;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class ZJ implements UF {
    public static PackageInfo A02;
    public static boolean A03;
    public static byte[] A04;
    public static String[] A05 = {"txu4RBo63YQ5Q7SoAp", "BY8ga9ljLbuWBmJa1ktUn6UmPorDtudq", "oIcH05TUMC1H4eRB0f575BffOzLV6s", "RDV9o0Xs0wR3bMJwiMoqv", "Drf", "fWBbnfM052TaJjbz2mNIhyXx2yjBcv", "vwrAcDNdoQtjOaT8FPnJSektvmYH0bUo", "A7bgPIcOUjT1m5u12vt0AimohlYQKPcw"};
    public static final EnumC1394Lw[] A06;
    public final C1561Sn A00;
    public final T8 A01;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 63);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        if (A05[4].length() != 3) {
            throw new RuntimeException();
        }
        String[] strArr = A05;
        strArr[3] = "e8Iif6peCxlhmB6JTHauJ";
        strArr[0] = "U2Egyo0LhTV3FJWkcb";
        A04 = new byte[]{-98, -70, -85, -83, -83, -81, -67, -67, -77, -84, -77, -74, -77, -66, -61, -55, -81, -72, -85, -84, -74, -81, -82, -26, -13, -26, -15, -12, -20, -69, -54, -54, -39, -57, -61, -56, -39, -51, -66, -59, -39, -48, -65, -52, -51, -61, -55, -56, -38, -20, -31, -38, -20, -25, -7, -17, -22, -14, 5, 5, 3, -6, -13, 6, 5, -6, 0, -1, Ascii.DLE, -6, -11, -7, 0, -5, -5, -4, 9, Ascii.SYN, Ascii.VT, 6, 2, -4, 5, Ascii.SYN, -4, Ascii.SI, Ascii.VT, 9, -8, 10, -124, -117, -122, -122, -121, -108, -95, -106, -111, -115, -121, -112, -95, -106, -107, -95, -113, -107, -26, -7, -14, -24, -16, -23, -110, -112, -110, -105, -108, -73, -75, -60, -60, -71, -72, -45, -67, -72, -57, -96, -98, -81, -81, -90, -94, -81, -32, -35, -16, -35, -5, -20, -18, -21, -33, -31, -17, -17, -27, -22, -29, -5, -21, -20, -16, -27, -21, -22, -17, -120, -123, -104, -123, -93, -108, -106, -109, -121, -119, -105, -105, -115, -110, -117, -93, -109, -108, -104, -115, -109, -110, -105, -93, -121, -109, -103, -110, -104, -106, -99, -104, -107, -88, -107, -77, -92, -90, -93, -105, -103, -89, -89, -99, -94, -101, -77, -93, -92, -88, -99, -93, -94, -89, -77, -89, -88, -107, -88, -103, -71, -70, -61, -56, -66, -55, -50, -41, -26, -33, -33, -42, -35, -16, -44, -32, -29, -42, -16, -42, -25, -42, -33, -27, -28, -25, -10, -17, -17, -26, -19, 0, -19, -16, -24, -24, -26, -27, -81, -54, -46, -43, -50, -51, -119, -35, -40, -119, -53, -34, -46, -43, -51, -119, -34, -36, -50, -37, -119, -35, -40, -44, -50, -41, -96, -103, -85, -73, -99, -80, -89, -88, -92, -103, -79, -99, -86, -6, -11, -9, -14, -57, -62, -35, -63, -65, -63, -58, -61, -35, -46, -47, -35, -53, -47, -69, -74, -47, -59, -63, -57, -60, -75, -73, -24, -19, -14, -13, -32, -21, -21, -28, -15, -104, -101, -113, -115, -104, -111, 1, -11, -1, -7, -75, -83, -84, -79, -87, -68, -79, -73, -74, -57, -69, -83, -70, -66, -79, -85, -83, -10, -19, -4, -1, -9, -6, -13, 7, -4, 1, -8, -19, -82, -94, -76, -85, -76, -78, -66, -76, -78, -92, -79, -66, -88, -93, -100, -103, -103, -98, -113, -114, -74, -74, -61, -89, -80, -83, -87, -78, -72, -61, -73, -88, -81, -61, -70, -87, -74, -73, -83, -77, -78, 2, 2, Ascii.SI, -13, -1, -2, -10, -7, -9, Ascii.SI, 4, 3, Ascii.SI, -3, 3, -6, -6, 7, -19, 0, -4, -6, -23, -5, -89, -89, -76, -98, -88, -76, -101, -89, -92, -94, -76, -88, -102, -89, -85, -98, -104, -102, -111, -111, -98, -110, -124, -111, -107, -120, -126, -124, -98, -110, -125, -118, -98, -107, -124, -111, -110, -120, -114, -115, -42, -40, -54, -29, -54, -58, -29, -59, -44, -44, -29, -51, -46, -41, -40, -59, -48, -48, -55, -56, -109, -107, -121, -96, -121, -125, -96, -126, -111, -111, -96, -105, -122, -109, -108, -118, -112, -113, -17, -33, -18, -31, -31, -22, -5, -28, -31, -27, -29, -28, -16, -10, -26, -11, -24, -24, -15, 2, -6, -20, -25, -9, -21, -27, -42, -35, -15, -43, -45, -30, -45, -44, -37, -34, -37, -26, -21, -65, -80, -73, -53, -71, -83, -70, -83, -77, -79, -80, -53, -81, -83, -81, -76, -79, -9, -23, -9, -9, -19, -13, -14, 3, -8, -19, -15, -23, 17, 10, 5, Ascii.DLE, Ascii.NAK, -106, -108, -122, -109, -96, -126, -120, -122, -113, -107, -59, -80, -69, -65, -80, -63, -80, -68, -62, -60, -53, -62, -62};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    public final String A05(UD ud) {
        UB.A08(this.A01, true, null);
        ByteArrayOutputStream byteArrayOutputStream = null;
        Base64OutputStream base64OutputStream = null;
        DeflaterOutputStream deflaterOutputStream = null;
        try {
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                base64OutputStream = new Base64OutputStream(byteArrayOutputStream, 0);
                deflaterOutputStream = new DeflaterOutputStream(base64OutputStream);
                Map mapA06 = A06();
                if (TextUtils.isEmpty(SZ.A00().A03())) {
                    SZ.A07(this.A01);
                }
                mapA06.put(A01(296, 4, 114), SZ.A00().A03());
                mapA06.put(A01(587, 10, 2), UJ.A06(new C1588To(this.A01), this.A01, false));
                if (C1615Up.A21(this.A01)) {
                    mapA06.put(A01(119, 10, 53), N8.A01(this.A01).A0K());
                }
                Iterator it = mapA06.entrySet().iterator();
                while (it.hasNext()) {
                    if (!ud.A3A((String) ((Map.Entry) it.next()).getKey())) {
                        it.remove();
                    }
                }
                deflaterOutputStream.write(new JSONObject(mapA06).toString().getBytes());
                deflaterOutputStream.close();
                String strReplaceAll = byteArrayOutputStream.toString().replaceAll(A01(0, 1, 85), A01(0, 0, 46));
                try {
                    deflaterOutputStream.close();
                    base64OutputStream.close();
                    byteArrayOutputStream.close();
                } catch (IOException unused) {
                }
                return strReplaceAll;
            } catch (Throwable th) {
                if (A05[4].length() != 3) {
                    throw new RuntimeException();
                }
                A05[1] = "YYekAclIzhra9Pv39zprUDIkOoogCrwo";
                if (deflaterOutputStream != null) {
                    try {
                        deflaterOutputStream.close();
                    } catch (IOException unused2) {
                        throw th;
                    }
                }
                if (base64OutputStream != null) {
                    base64OutputStream.close();
                }
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                throw th;
            }
        } catch (IOException e) {
            throw new RuntimeException(A01(257, 26, 42), e);
        }
    }

    public final /* synthetic */ Map A06() {
        return UC.A00(this);
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 13 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:107:0x040a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02c6  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x03e1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x03ff  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x041f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x04d6  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x04d8  */
    @Override // com.facebook.ads.redexgen.core.UF
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.Map<java.lang.String, java.lang.String> A7y(com.facebook.ads.redexgen.core.U3 r12) {
        /*
            Method dump skipped, instruction units count: 1302
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.ZJ.A7y(com.facebook.ads.redexgen.X.U3):java.util.Map");
    }

    static {
        A02();
        A03 = false;
        A06 = new EnumC1394Lw[]{EnumC1394Lw.A1D, EnumC1394Lw.A0r, EnumC1394Lw.A1E, EnumC1394Lw.A1O, EnumC1394Lw.A18, EnumC1394Lw.A1A, EnumC1394Lw.A2h, EnumC1394Lw.A2i, EnumC1394Lw.A2j};
    }

    public ZJ(T8 t8, boolean z, C1561Sn c1561Sn) {
        this.A01 = t8;
        this.A00 = c1561Sn;
        UB.A08(t8, z, null);
    }

    public static synchronized PackageInfo A00(T8 t8) {
        if (!A03) {
            A02 = AbstractC1681Xi.A00(t8);
            A03 = true;
        }
        return A02;
    }

    private void A03(U3 u3, Map<String, String> map) {
        String strA01;
        if (u3 != null && u3.AAg()) {
            map.put(A01(436, 18, 22), Boolean.TRUE.toString());
            if (u3.A7N() != null) {
                map.put(A01(391, 21, 37), u3.A7N());
            }
        }
        if (AbstractC1618Us.A09(this.A01)) {
            T8 t8 = this.A01;
            if (A05[1].charAt(25) != 'o') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[7] = "qhmjNI7uMFHuEfCbgrNi3HvbFW0uqLeT";
            strArr[6] = "rAF5k5sPuv4hj6bjGKLvAsDqqwbdtY33";
            String strA03 = U5.A03(t8.A02());
            if (strA03 != null) {
                String remoteRenderingSdkVersion = A01(454, 22, 0);
                map.put(remoteRenderingSdkVersion, strA03);
            }
            String strA02 = U5.A02(this.A01.A02());
            if (strA03 != null) {
                String remoteRenderingSdkVersion2 = A01(427, 9, 105);
                map.put(remoteRenderingSdkVersion2, strA02);
            }
            if (AbstractC1618Us.A0D(this.A01)) {
                String strA012 = U5.A01(this.A01.A02());
                String[] strArr2 = A05;
                String remoteRenderingExtras = strArr2[7];
                if (remoteRenderingExtras.charAt(0) == strArr2[6].charAt(0)) {
                    throw new RuntimeException();
                }
                String[] strArr3 = A05;
                strArr3[7] = "Mj9TvIbv6bgZbZ2pKznECnYI7EK5ROuc";
                strArr3[6] = "5qjAp4YjV3Q6sbLE0XRdgT3gO1lX1tGk";
                if (strA03 != null) {
                    String remoteRenderingSdkVersion3 = A01(412, 15, 113);
                    map.put(remoteRenderingSdkVersion3, strA012);
                }
            }
        }
        if (C1615Up.A0x(this.A01) && (strA01 = U6.A01(this.A01.A02())) != null) {
            String cache = A01(114, 5, 16);
            map.put(cache, strA01);
        }
    }

    public final String A04() {
        return A05(UE.A00());
    }
}
