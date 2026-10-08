package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.lZ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2447lZ implements InterfaceC1329Jj {
    public static String[] A03 = {"LK8mEMUSnifSCT0YT0fQtLG", "zQWICugnqrmXEq8sMdeIuA9JBPwrta0k", "lKxJonOWK2Axk83UnpUnbJJcLxj", "3DYuz", "CNQNHGpRGAv1E31EB6wcq1FAARNpDgXE", "DpJK", "NUJ585yfBdIWgF7XcRLbZeMVqrhzmgk", "1sPINCYISeoO6PXpnzvAKZkikus6bvvY"};
    public final List<C1351Kf> A00;
    public final long[] A01;
    public final long[] A02;

    /* JADX WARN: Incorrect condition in loop: B:4:0x001d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public C2447lZ(java.util.List<com.facebook.ads.redexgen.core.C1351Kf> r8) {
        /*
            r7 = this;
            r7.<init>()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r8)
            java.util.List r0 = java.util.Collections.unmodifiableList(r0)
            r7.A00 = r0
            int r0 = r8.size()
            int r0 = r0 * 2
            long[] r0 = new long[r0]
            r7.A01 = r0
            r6 = 0
        L19:
            int r0 = r8.size()
            if (r6 >= r0) goto L38
            java.lang.Object r5 = r8.get(r6)
            com.facebook.ads.redexgen.X.Kf r5 = (com.facebook.ads.redexgen.core.C1351Kf) r5
            int r4 = r6 * 2
            long[] r2 = r7.A01
            long r0 = r5.A01
            r2[r4] = r0
            long[] r3 = r7.A01
            int r2 = r4 + 1
            long r0 = r5.A00
            r3[r2] = r0
            int r6 = r6 + 1
            goto L19
        L38:
            long[] r1 = r7.A01
            long[] r0 = r7.A01
            int r0 = r0.length
            long[] r0 = java.util.Arrays.copyOf(r1, r0)
            r7.A02 = r0
            long[] r0 = r7.A02
            java.util.Arrays.sort(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2447lZ.<init>(java.util.List):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1329Jj
    public final List<C2675pT> A7X(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.A00.size(); i++) {
            if (this.A01[i * 2] <= j) {
                long j2 = this.A01[(i * 2) + 1];
                if (A03[2].length() == 27) {
                    A03[5] = "FOcCQTOovqYXamkXPEg";
                    if (j < j2) {
                        C1351Kf c1351Kf = this.A00.get(i);
                        if (c1351Kf.A02.A01 == -3.4028235E38f) {
                            arrayList2.add(c1351Kf);
                        } else {
                            C2675pT c2675pT = c1351Kf.A02;
                            String[] strArr = A03;
                            if (strArr[6].length() != strArr[0].length()) {
                                String[] strArr2 = A03;
                                strArr2[4] = "KriihMM2RWcrEfyoWolOk5PIi1Nv3YmO";
                                strArr2[1] = "gocQSZMmm3PjEWFg0RBonPYHqyNHFxQo";
                                arrayList.add(c2675pT);
                            }
                        }
                    } else {
                        continue;
                    }
                }
                throw new RuntimeException();
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.facebook.ads.redexgen.X.Kp
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((C1351Kf) obj).A01, ((C1351Kf) obj2).A01);
            }
        });
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            arrayList.add(((C1351Kf) arrayList2.get(i2)).A02.A02().A07((-1) - i2, 1).A0H());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1329Jj
    public final long A83(int i) {
        boolean z = true;
        AbstractC09493y.A07(i >= 0);
        if (i >= this.A02.length) {
            z = false;
        }
        AbstractC09493y.A07(z);
        return this.A02[i];
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1329Jj
    public final int A84() {
        return this.A02.length;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1329Jj
    public final int A8a(long j) {
        int iA0K = C5C.A0K(this.A02, j, false, false);
        int index = this.A02.length;
        if (iA0K < index) {
            return iA0K;
        }
        return -1;
    }
}
