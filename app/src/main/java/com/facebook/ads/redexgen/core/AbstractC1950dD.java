package com.facebook.ads.redexgen.core;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.dD, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC1950dD {
    public static String[] A00 = {"M7M7680JiQXMJzeuHBUdBK3CqcsunIE3", "7YJQc0MEUr6fNb1HoLhvfznehf2fNPi1", "fqXve0BGHc", "EJDyhBK8ScH8NN0H4G45MCvGKFSIU6i3", "lE5hsHUrpnTpaSUAUiDOdKdDJm2EXpBt", "fXhWa5fzMs", "jGMjXmbPjJmsUXbAj46daPhZmilD9JtA", "gy7nSuWAyo"};
    public static final Map<String, WeakReference<C1949dC>> A01 = new HashMap();

    public static int A00() {
        Map<String, WeakReference<C1949dC>> map = A01;
        if (A00[4].charAt(3) != 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A00;
        strArr[3] = "KcOG1rzwVGm5OqslsWQoAqhkYEC7FRij";
        strArr[1] = "Dhj4Lprngz6YVn4AutwbBiUWJOZdaDii";
        return map.size();
    }

    public static C1949dC A01(C2165gi c2165gi, AbstractC2330jd abstractC2330jd, int i, InterfaceC1947dA interfaceC1947dA) {
        C1949dC c1949dC = new C1949dC(c2165gi, abstractC2330jd, c2165gi.A02().A0A(), i);
        c1949dC.A0b(interfaceC1947dA);
        c1949dC.A0X();
        A01.put(abstractC2330jd.A1D(), new WeakReference<>(c1949dC));
        return c1949dC;
    }

    public static C1949dC A02(String str) {
        WeakReference<C1949dC> weakReference = A01.get(str);
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public static void A03(AbstractC2330jd abstractC2330jd, C1949dC c1949dC) {
        A01.put(abstractC2330jd.A1D(), new WeakReference<>(c1949dC));
    }

    public static void A04(String str) {
        A01.remove(str);
    }
}
