package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.Map;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.md, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2501md implements H9 {
    public static String[] A0G = {"imixVRybNrgJBpwbrV4yrZtrfnRN6CnJ", "WtIdTgOpLr9NKs5TxCGGWraEed8Ae14z", "nvE", "WSn", "ErTHk7eYnTgSookYOy4dYMthSURbPHEq", "4jyr3GyUtTi8KljoItgNNDucP2AqNlsy", "x6x5cMRZdfdA3RZcYJIixT0Q9ac0Pw6j", "1jBqwsY8y2xmCvig0OcgZP2KEis0q"};
    public static final HD A0H = new HD() { // from class: com.facebook.ads.redexgen.X.me
        @Override // com.facebook.ads.redexgen.core.HD
        public final H9[] A5N() {
            return C2501md.A07();
        }

        @Override // com.facebook.ads.redexgen.core.HD
        public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
            return HC.A01(this, uri, map);
        }
    };
    public int A00;
    public int A02;
    public int A03;
    public long A04;
    public long A05;
    public HA A06;
    public C2503mf A07;
    public C2498ma A08;
    public boolean A09;
    public boolean A0A;
    public final C09724v A0C = new C09724v(4);
    public final C09724v A0B = new C09724v(9);
    public final C09724v A0E = new C09724v(11);
    public final C09724v A0D = new C09724v();
    public final C2500mc A0F = new C2500mc();
    public int A01 = 1;

    private long A00() {
        if (!this.A09) {
            if (this.A0F.A0D() == C.TIME_UNSET) {
                return 0L;
            }
            return this.A05;
        }
        long j = this.A04;
        String[] strArr = A0G;
        if (strArr[5].charAt(7) == strArr[0].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[2] = "BRg";
        strArr2[3] = "MUb";
        return j + this.A05;
    }

    private C09724v A01(InterfaceC2516ms interfaceC2516ms) throws IOException {
        if (this.A02 > this.A0D.A08()) {
            this.A0D.A0j(new byte[Math.max(this.A0D.A08() * 2, this.A02)], 0);
        } else {
            this.A0D.A0f(0);
        }
        this.A0D.A0e(this.A02);
        interfaceC2516ms.readFully(this.A0D.A0l(), 0, this.A02);
        return this.A0D;
    }

    @RequiresNonNull({"extractorOutput"})
    private void A02() {
        if (!this.A0A) {
            this.A06.AJ7(new C2511mn(C.TIME_UNSET));
            this.A0A = true;
        }
    }

    private void A03(InterfaceC2516ms interfaceC2516ms) throws IOException {
        interfaceC2516ms.AK3(this.A00);
        this.A00 = 0;
        this.A01 = 3;
    }

    @RequiresNonNull({"extractorOutput"})
    private boolean A04(InterfaceC2516ms interfaceC2516ms) throws IOException {
        if (!interfaceC2516ms.AHR(this.A0B.A0l(), 0, 9, true)) {
            return false;
        }
        this.A0B.A0f(0);
        C09724v c09724v = this.A0B;
        String[] strArr = A0G;
        if (strArr[5].charAt(7) == strArr[0].charAt(7)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A0G;
        strArr2[5] = "nuvUOUbepbklYX7VO8aNhI2QGU1lTbhE";
        strArr2[0] = "EarG3ISTV8IaVYTIGtUgI942SJk0uODJ";
        c09724v.A0g(4);
        int iA0I = this.A0B.A0I();
        int flags = iA0I & 4;
        boolean z = flags != 0;
        int i = iA0I & 1;
        String[] strArr3 = A0G;
        String str = strArr3[2];
        String str2 = strArr3[3];
        int length = str.length();
        int flags2 = str2.length();
        if (length != flags2) {
            throw new RuntimeException();
        }
        A0G[6] = "imt3Psvl5i5WkMBxXJw1tYAVhho8FT7n";
        boolean hasAudio = i != 0;
        if (z && this.A07 == null) {
            this.A07 = new C2503mf(this.A06.AKS(8, 1));
        }
        if (hasAudio && this.A08 == null) {
            this.A08 = new C2498ma(this.A06.AKS(9, 2));
        }
        this.A06.A6O();
        int flags3 = this.A0B.A0C();
        this.A00 = (flags3 - 9) + 4;
        this.A01 = 2;
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00ae  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"extractorOutput"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A05(com.facebook.ads.redexgen.core.InterfaceC2516ms r12) throws java.io.IOException {
        /*
            r11 = this;
            r10 = 1
            r9 = 0
            long r1 = r11.A00()
            int r3 = r11.A03
            r0 = 8
            r6 = 1
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r3 != r0) goto L5e
            com.facebook.ads.redexgen.X.mf r0 = r11.A07
            if (r0 == 0) goto L5e
            r11.A02()
            com.facebook.ads.redexgen.X.mf r3 = r11.A07
            com.facebook.ads.redexgen.X.4v r0 = r11.A01(r12)
            boolean r9 = r3.A00(r0, r1)
        L23:
            boolean r0 = r11.A09
            if (r0 != 0) goto L54
            if (r9 == 0) goto L54
            r11.A09 = r6
            com.facebook.ads.redexgen.X.mc r0 = r11.A0F
            long r1 = r0.A0D()
            int r0 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r0 != 0) goto L5b
            long r3 = r11.A05
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            r0 = 5
            r1 = r2[r0]
            r0 = 0
            r2 = r2[r0]
            r0 = 7
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto Lb6
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            java.lang.String r1 = "qsMwkk9xIwtWzz8Y8bf9D9RZC3dmDCSF"
            r0 = 4
            r2[r0] = r1
            long r0 = -r3
        L52:
            r11.A04 = r0
        L54:
            r0 = 4
            r11.A00 = r0
            r0 = 2
            r11.A01 = r0
            return r10
        L5b:
            r0 = 0
            goto L52
        L5e:
            int r3 = r11.A03
            r0 = 9
            if (r3 != r0) goto L76
            com.facebook.ads.redexgen.X.ma r0 = r11.A08
            if (r0 == 0) goto L76
            r11.A02()
            com.facebook.ads.redexgen.X.ma r3 = r11.A08
            com.facebook.ads.redexgen.X.4v r0 = r11.A01(r12)
            boolean r9 = r3.A00(r0, r1)
            goto L23
        L76:
            int r3 = r11.A03
            r0 = 18
            if (r3 != r0) goto Lae
            boolean r0 = r11.A0A
            if (r0 != 0) goto Lae
            com.facebook.ads.redexgen.X.mc r3 = r11.A0F
            com.facebook.ads.redexgen.X.4v r0 = r11.A01(r12)
            boolean r9 = r3.A00(r0, r1)
            com.facebook.ads.redexgen.X.mc r0 = r11.A0F
            long r2 = r0.A0D()
            int r0 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r0 == 0) goto L23
            com.facebook.ads.redexgen.X.HA r5 = r11.A06
            com.facebook.ads.redexgen.X.mc r0 = r11.A0F
            long[] r4 = r0.A0E()
            com.facebook.ads.redexgen.X.mc r0 = r11.A0F
            long[] r1 = r0.A0F()
            com.facebook.ads.redexgen.X.mo r0 = new com.facebook.ads.redexgen.X.mo
            r0.<init>(r4, r1, r2)
            r5.AJ7(r0)
            r11.A0A = r6
            goto L23
        Lae:
            int r0 = r11.A02
            r12.AK3(r0)
            r10 = 0
            goto L23
        Lb6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2501md.A05(com.facebook.ads.redexgen.X.ms):boolean");
    }

    private boolean A06(InterfaceC2516ms interfaceC2516ms) throws IOException {
        if (!interfaceC2516ms.AHR(this.A0E.A0l(), 0, 11, true)) {
            return false;
        }
        this.A0E.A0f(0);
        this.A03 = this.A0E.A0I();
        this.A02 = this.A0E.A0K();
        this.A05 = this.A0E.A0K();
        long jA0I = this.A0E.A0I() << 24;
        if (A0G[4].charAt(4) != 'k') {
            throw new RuntimeException();
        }
        String[] strArr = A0G;
        strArr[5] = "4ZAub2Q05bEVVYNgLvK28njcI37CKeIt";
        strArr[0] = "aUQSwXMZXC0bGVhjCWvBp2fyGyckkl15";
        this.A05 = (jA0I | this.A05) * 1000;
        this.A0E.A0g(3);
        this.A01 = 4;
        return true;
    }

    public static /* synthetic */ H9[] A07() {
        return new H9[]{new C2501md()};
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A06 = ha;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        throw new java.lang.RuntimeException();
     */
    @Override // com.facebook.ads.redexgen.core.H9
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int AHL(com.facebook.ads.redexgen.core.InterfaceC2516ms r6, com.facebook.ads.redexgen.core.HV r7) throws java.io.IOException {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.HA r0 = r5.A06
            com.facebook.ads.redexgen.core.AbstractC09493y.A02(r0)
        L5:
            int r0 = r5.A01
            r4 = -1
            switch(r0) {
                case 1: goto L72;
                case 2: goto L6e;
                case 3: goto L48;
                case 4: goto L11;
                default: goto Lb;
            }
        Lb:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L11:
            boolean r3 = r5.A05(r6)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2501md.A0G
            r0 = 6
            r1 = r1[r0]
            r0 = 17
            char r1 = r1.charAt(r0)
            r0 = 74
            if (r1 == r0) goto L2a
        L24:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2a:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            java.lang.String r1 = "hEtErmVw2pGEM2VKW7DPZ3jvJ8JWR8Qp"
            r0 = 5
            r2[r0] = r1
            java.lang.String r1 = "qL5KjU5Lqv7wAr3B2PcEEy6NtzLZKXIh"
            r0 = 0
            r2[r0] = r1
            if (r3 == 0) goto L5
            r3 = 0
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2501md.A0G
            r0 = 4
            r1 = r1[r0]
            r0 = 4
            char r1 = r1.charAt(r0)
            r0 = 107(0x6b, float:1.5E-43)
            if (r1 == r0) goto L79
            goto L24
        L48:
            boolean r3 = r5.A06(r6)
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            r0 = 2
            r1 = r2[r0]
            r0 = 3
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L64
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L64:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            java.lang.String r1 = "tWexpPkMi4voS1yCEJ5KNGfvnIQwX6NI"
            r0 = 6
            r2[r0] = r1
            if (r3 != 0) goto L5
            return r4
        L6e:
            r5.A03(r6)
            goto L5
        L72:
            boolean r0 = r5.A04(r6)
            if (r0 != 0) goto L5
            return r4
        L79:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2501md.A0G
            java.lang.String r1 = "EltTpHvyDDt"
            r0 = 7
            r2[r0] = r1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2501md.AHL(com.facebook.ads.redexgen.X.ms, com.facebook.ads.redexgen.X.HV):int");
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j, long j2) {
        if (j == 0) {
            this.A01 = 1;
            this.A09 = false;
        } else {
            this.A01 = 3;
        }
        this.A00 = 0;
        if (A0G[4].charAt(4) != 'k') {
            throw new RuntimeException();
        }
        A0G[1] = "RsgGxkOp5mo19RRr3aJo3NcocokVUXQ7";
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC2516ms interfaceC2516ms) throws IOException {
        interfaceC2516ms.AGt(this.A0C.A0l(), 0, 3);
        this.A0C.A0f(0);
        if (this.A0C.A0K() != 4607062) {
            return false;
        }
        interfaceC2516ms.AGt(this.A0C.A0l(), 0, 2);
        this.A0C.A0f(0);
        if ((this.A0C.A0M() & 250) != 0) {
            return false;
        }
        interfaceC2516ms.AGt(this.A0C.A0l(), 0, 4);
        this.A0C.A0f(0);
        int dataOffset = this.A0C.A0C();
        interfaceC2516ms.AIl();
        interfaceC2516ms.A47(dataOffset);
        interfaceC2516ms.AGt(this.A0C.A0l(), 0, 4);
        this.A0C.A0f(0);
        int dataOffset2 = this.A0C.A0C();
        return dataOffset2 == 0;
    }
}
