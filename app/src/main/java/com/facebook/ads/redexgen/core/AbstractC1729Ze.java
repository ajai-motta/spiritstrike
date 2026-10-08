package com.facebook.ads.redexgen.core;

import android.view.View;
import com.facebook.ads.NativeAdLayout;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ze, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1729Ze {
    public static String[] A00 = {"B", "b", "N7Y4O4Xp0bXRpwQYmrnUbbD5XPNn0nfl", "PsTgqcCc8jcMoxm2RXWy1mA6rhf59", "zMLnehec4ICfDGOtTSDp3symXOGZpaRx", "AnvCnC9uV", "JoTWE5M61fQkMjrwCjPz5KG5vu8cqeKb", "O6aKPphMSjoWO4xDWlhiQ7T2kp0fs"};
    public static final int A01 = (int) (XX.A02 * 200.0f);
    public static final int A03 = (int) (XX.A02 * 200.0f);
    public static final int A02 = (int) (XX.A02 * 50.0f);

    public static NF A00(NativeAdLayout nativeAdLayout) {
        if (nativeAdLayout == null) {
            return NF.A04;
        }
        if (A03(nativeAdLayout)) {
            return NF.A05;
        }
        return NF.A03;
    }

    public static AbstractC1728Zd A01(C2165gi c2165gi, VA va, String str, View view) {
        if (view == null) {
            return null;
        }
        int w = view.getWidth();
        int height = view.getHeight();
        if (w >= A01 && height >= A01) {
            return new MC(c2165gi, va, str);
        }
        if (w >= A03) {
            int i = A02;
            String[] strArr = A00;
            if (strArr[6].charAt(28) == strArr[4].charAt(28)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A00;
            strArr2[7] = "MXaU9iKOIfaGo19ccmM4SYJQh1BEv";
            strArr2[3] = "urarsFS1owFx4szCeqq2cq67A77KP";
            if (height >= i) {
                return new MD(c2165gi, va, str);
            }
        }
        return null;
    }

    public static ME A02(C2165gi c2165gi, VA va, String str, C1435Nm c1435Nm, InterfaceC1707Yi interfaceC1707Yi, InterfaceC1706Yh interfaceC1706Yh) {
        return new ME(c2165gi, va, str, c1435Nm, interfaceC1707Yi, interfaceC1706Yh);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0010  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A03(com.facebook.ads.NativeAdLayout r6) {
        /*
            int r5 = r6.getWidth()
            int r4 = r6.getHeight()
            int r0 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A01
            if (r5 < r0) goto L10
            int r0 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A01
            if (r4 >= r0) goto L2a
        L10:
            int r3 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A03
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A00
            r0 = 1
            r1 = r2[r0]
            r0 = 0
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L2c
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            r0 = 0
            goto L3f
        L2c:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A00
            java.lang.String r1 = "e"
            r0 = 1
            r2[r0] = r1
            java.lang.String r1 = "I"
            r0 = 0
            r2[r0] = r1
            if (r5 < r3) goto L3e
            int r0 = com.facebook.ads.redexgen.core.AbstractC1729Ze.A02
            if (r4 >= r0) goto L2a
        L3e:
            r0 = 1
        L3f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AbstractC1729Ze.A03(com.facebook.ads.NativeAdLayout):boolean");
    }
}
