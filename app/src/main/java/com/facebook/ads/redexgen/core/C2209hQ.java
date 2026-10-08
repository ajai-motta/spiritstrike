package com.facebook.ads.redexgen.core;

import com.facebook.ads.AdListener;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.hQ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2209hQ extends WP {
    public static String[] A02 = {"aYZ348mE1NYrFcMBoebQMkiZFG78oX5w", "qZgy2fVZKkcRQxGeLIPji8yDZzfZsU0K", "FW", "4WpWxoGmbDHaVYPSEbV5W", "JuvmjYnKk99PR9XqbJ5bpADbGT7vNhdJ", "90qKQYWe37jbHMTFJzGbdEUnuOp61wed", "dYksIGNGyyMeZtC5mrM4so", "pL5NnltKvH9DFuMzl1s9TskXUqu4u7R4"};
    public final /* synthetic */ C2205hM A00;
    public final /* synthetic */ C1637Vm A01;

    public C2209hQ(C2205hM c2205hM, C1637Vm c1637Vm) {
        this.A00 = c2205hM;
        this.A01 = c1637Vm;
    }

    @Override // com.facebook.ads.redexgen.core.WP
    public final void A01() {
        if (this.A00.A01.A06() != null) {
            AdListener adListenerA06 = this.A00.A01.A06();
            C1526Rd c1526Rd = this.A00.A01;
            if (A02[2].length() != 2) {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[3] = "zGBwvDJj20KV94Zd2N0fZ";
            strArr[6] = "5j2wCmqr0QfuHbPw5sx74i";
            adListenerA06.onError(c1526Rd.A07(), XE.A00(this.A01));
        }
    }
}
