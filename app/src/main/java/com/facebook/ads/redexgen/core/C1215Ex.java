package com.facebook.ads.redexgen.core;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ex, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1215Ex {
    public static String[] A05 = {"LpJTwMN2G", "VgMO4aUKUhad1vQS8qeWccWG6TZwybQB", "ACcLkDhyx", "Vz4L8Yk2qa8xi00BpA99exXw347yn2OW", "M93qmyVYUpuFuHp", "Ixo", "WCFkueysi57ip8GEP7BFiSRGMX4T5ofH", "LFY6A3GYQmBEHARGrOHSwwc2jPi1aXj0"};
    public final int A00;
    public final C2680pY A01;
    public final Object A02;
    public final C10477s[] A03;
    public final InterfaceC2537nE[] A04;

    public C1215Ex(C10477s[] c10477sArr, InterfaceC2537nE[] interfaceC2537nEArr, C2680pY c2680pY, Object obj) {
        this.A03 = c10477sArr;
        this.A04 = (InterfaceC2537nE[]) interfaceC2537nEArr.clone();
        this.A01 = c2680pY;
        this.A02 = obj;
        this.A00 = c10477sArr.length;
    }

    public final boolean A00(int i) {
        return this.A03[i] != null;
    }

    public final boolean A01(C1215Ex c1215Ex, int i) {
        if (c1215Ex == null) {
            return false;
        }
        C10477s[] c10477sArr = this.A03;
        if (A05[5].length() == 3) {
            A05[1] = "2a41zxf8OUQisEdMYeAN8aC4JNcLEgEy";
            if (!C5C.A1E(c10477sArr[i], c1215Ex.A03[i])) {
                return false;
            }
            InterfaceC2537nE interfaceC2537nE = this.A04[i];
            InterfaceC2537nE interfaceC2537nE2 = c1215Ex.A04[i];
            String[] strArr = A05;
            if (strArr[2].length() == strArr[0].length()) {
                A05[4] = "ShAZgc6gkhlm9OR";
                return C5C.A1E(interfaceC2537nE, interfaceC2537nE2);
            }
        }
        throw new RuntimeException();
    }
}
