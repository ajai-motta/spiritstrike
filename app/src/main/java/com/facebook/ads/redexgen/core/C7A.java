package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.7A, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C7A {
    public static byte[] A0E;
    public static String[] A0F = {"qTjlphzGhjtz23pZpbkrfGV3", "gcvQ0aFRAZsVeDDMvPpq9fmBIR43z3dS", "1g2pSH5s64tGUAh3eJ0e3X43Q9jzw3mq", "lB1M4R9KcDs1NZsKBVQ3JQYLP4RbMvTH", "7AgciWFjZyCuzmH359m88XAJrahqi7eF", "Et2BwvNp", "Oz1eJxJHgMWzrYsZQ0zZlFN1YCxGY3CZ", "Iy7o67ktSbvMBIxm3lxnuK7UTKgUaVFx"};
    public C7B A00;
    public boolean A01;
    public boolean A02;
    public long A03;
    public C7A A04;
    public C2555nW A05 = C2555nW.A06;
    public C1215Ex A06;
    public final InterfaceC2574np A07;
    public final Object A08;
    public final DT[] A09;
    public final AnonymousClass79 A0A;
    public final AbstractC1214Ew A0B;
    public final InterfaceC10447p[] A0C;
    public final boolean[] A0D;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0E, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 22);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0E = new byte[]{81, 121, 120, 117, 125, 76, 121, 110, 117, 115, 120, 84, 115, 112, 120, 121, 110, Ascii.FS, 41, 62, 37, 35, 40, 108, 62, 41, 32, 41, 45, 63, 41, 108, 42, 45, 37, 32, 41, 40, 98};
    }

    static {
        A04();
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Old exoplayer method. requires deleting")
    public C7A(InterfaceC10447p[] interfaceC10447pArr, long j, AbstractC1214Ew abstractC1214Ew, F0 f0, InterfaceC1163Cx interfaceC1163Cx, C7B c7b, C1215Ex c1215Ex) {
        this.A0C = interfaceC10447pArr;
        this.A03 = j - c7b.A03;
        this.A0B = abstractC1214Ew;
        this.A08 = AbstractC09493y.A01(c7b.A04.A04);
        this.A00 = c7b;
        this.A06 = c1215Ex;
        this.A09 = new DT[interfaceC10447pArr.length];
        this.A0D = new boolean[interfaceC10447pArr.length];
        this.A0A = new C2635op(this, interfaceC1163Cx);
        this.A07 = A00(c7b.A04, this.A0A, f0, c7b.A03, c7b.A01);
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "MediaSourceList is temporarily changed to MediaSourceAdapter")
    public static InterfaceC2574np A00(C2573no c2573no, AnonymousClass79 anonymousClass79, F0 f0, long j, long j2) {
        InterfaceC2574np interfaceC2574npA5W = anonymousClass79.A5W(c2573no, f0, j);
        if (j2 != C.TIME_UNSET) {
            return new C9v(interfaceC2574npA5W, true, 0L, j2);
        }
        return interfaceC2574npA5W;
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A02() {
        /*
            r3 = this;
            boolean r0 = r3.A08()
            if (r0 != 0) goto L7
            return
        L7:
            r2 = 0
        L8:
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            int r0 = r0.A00
            if (r2 >= r0) goto L24
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            boolean r1 = r0.A00(r2)
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            com.facebook.ads.redexgen.X.nE[] r0 = r0.A04
            r0 = r0[r2]
            if (r1 == 0) goto L21
            if (r0 == 0) goto L21
            r0.A5x()
        L21:
            int r2 = r2 + 1
            goto L8
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C7A.A02():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:7:0x000c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A03() {
        /*
            r3 = this;
            boolean r0 = r3.A08()
            if (r0 != 0) goto L7
            return
        L7:
            r2 = 0
        L8:
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            int r0 = r0.A00
            if (r2 >= r0) goto L24
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            boolean r1 = r0.A00(r2)
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            com.facebook.ads.redexgen.X.nE[] r0 = r0.A04
            r0 = r0[r2]
            if (r1 == 0) goto L21
            if (r0 == 0) goto L21
            r0.A6K()
        L21:
            int r2 = r2 + 1
            goto L8
        L24:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C7A.A03():void");
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "Temporary bridging of MediaSourceList with MediaSourceAdapter")
    public static void A05(AnonymousClass79 anonymousClass79, InterfaceC2574np interfaceC2574np) {
        try {
            if (interfaceC2574np instanceof C9v) {
                anonymousClass79.AHk(((C9v) interfaceC2574np).A05);
            } else {
                anonymousClass79.AHk(interfaceC2574np);
            }
        } catch (RuntimeException e) {
            AbstractC09574g.A08(A01(0, 17, 10), A01(17, 22, 90), e);
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.core.DT[] r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.7p[] r0 = r3.A0C
            int r0 = r0.length
            if (r2 >= r0) goto L23
            com.facebook.ads.redexgen.X.7p[] r0 = r3.A0C
            r0 = r0[r2]
            int r1 = r0.A9N()
            r0 = -2
            if (r1 != r0) goto L20
            com.facebook.ads.redexgen.X.Ex r0 = r3.A06
            boolean r0 = r0.A00(r2)
            if (r0 == 0) goto L20
            com.facebook.ads.redexgen.X.nr r0 = new com.facebook.ads.redexgen.X.nr
            r0.<init>()
            r4[r2] = r0
        L20:
            int r2 = r2 + 1
            goto L1
        L23:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C7A.A06(com.facebook.ads.redexgen.X.DT[]):void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0004 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A07(com.facebook.ads.redexgen.core.DT[] r4) {
        /*
            r3 = this;
            r2 = 0
        L1:
            com.facebook.ads.redexgen.X.7p[] r0 = r3.A0C
            int r0 = r0.length
            if (r2 >= r0) goto L17
            com.facebook.ads.redexgen.X.7p[] r0 = r3.A0C
            r0 = r0[r2]
            int r1 = r0.A9N()
            r0 = -2
            if (r1 != r0) goto L14
            r0 = 0
            r4[r2] = r0
        L14:
            int r2 = r2 + 1
            goto L1
        L17:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C7A.A07(com.facebook.ads.redexgen.X.DT[]):void");
    }

    private boolean A08() {
        return this.A04 == null;
    }

    public final long A09() {
        if (!this.A02) {
            return this.A00.A03;
        }
        long jA78 = this.A01 ? this.A07.A78() : Long.MIN_VALUE;
        return jA78 == Long.MIN_VALUE ? this.A00.A00 : jA78;
    }

    public final long A0A() {
        if (this.A02) {
            return this.A07.A8b();
        }
        return 0L;
    }

    public final long A0B() {
        return this.A03;
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"})
    public final long A0C(long j) {
        return this.A07.A76(j);
    }

    public final long A0D(long j) {
        return j - A0B();
    }

    public final long A0E(long j) {
        return A0B() + j;
    }

    public final long A0F(C1215Ex c1215Ex, long j, boolean z) {
        return A0G(c1215Ex, j, z, new boolean[this.A0C.length]);
    }

    public final long A0G(C1215Ex c1215Ex, long j, boolean z, boolean[] zArr) {
        int i = 0;
        while (true) {
            boolean z2 = false;
            if (i < c1215Ex.A00) {
                boolean[] zArr2 = this.A0D;
                if (!z) {
                    boolean zA01 = c1215Ex.A01(this.A06, i);
                    if (A0F[5].length() != 8) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A0F;
                    strArr[4] = "ZW5cY05fUZ7YDJtoLiROAD1s3u7pqZaY";
                    strArr[3] = "DBvv8TdqbKzS7YgGUgxEKNMIgeBwY4FK";
                    if (zA01) {
                        z2 = true;
                    }
                }
                zArr2[i] = z2;
                i++;
            } else {
                A07(this.A09);
                A02();
                this.A06 = c1215Ex;
                A03();
                long jAJ9 = this.A07.AJ9(c1215Ex.A04, this.A0D, this.A09, zArr, j);
                A06(this.A09);
                this.A01 = false;
                for (int i2 = 0; i2 < this.A09.length; i2++) {
                    if (this.A09[i2] != null) {
                        AbstractC09493y.A08(c1215Ex.A00(i2));
                        if (this.A0C[i2].A9N() != -2) {
                            this.A01 = true;
                        }
                    } else {
                        AbstractC09493y.A08(c1215Ex.A04[i2] == null);
                    }
                }
                return jAJ9;
            }
        }
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"})
    public final long A0H(boolean z) {
        if (!z) {
            return this.A03;
        }
        return this.A00.A03 + this.A03;
    }

    public final C7A A0I() {
        return this.A04;
    }

    public final C2555nW A0J() {
        return this.A05;
    }

    public final C1215Ex A0K() {
        return this.A06;
    }

    public final C1215Ex A0L(float f, Timeline timeline) throws AD {
        C1215Ex c1215ExA0b = this.A0B.A0b(this.A0C, A0J(), this.A00.A04, timeline);
        for (InterfaceC2537nE interfaceC2537nE : c1215ExA0b.A04) {
            if (interfaceC2537nE != null) {
                interfaceC2537nE.AFJ(f);
            }
        }
        return c1215ExA0b;
    }

    @MetaExoPlayerCustomization(type = {"TEMPORARY"}, value = "MediaSourceAdapter to be replaced with MediaSourceList")
    public final void A0M() {
        A02();
        A05(this.A0A, this.A07);
    }

    public final void A0N(float f, Timeline timeline) throws AD {
        this.A02 = true;
        this.A05 = this.A07.A9M();
        long jA0F = A0F(A0L(f, timeline), this.A00.A03, false);
        this.A03 += this.A00.A03 - jA0F;
        this.A00 = this.A00.A00(jA0F);
    }

    public final void A0O(long j) {
        AbstractC09493y.A08(A08());
        this.A07.A5C(A0D(j));
    }

    public final void A0P(long j) {
        AbstractC09493y.A08(A08());
        if (this.A02) {
            this.A07.AHW(A0D(j));
        }
    }

    public final void A0Q(C7A c7a) {
        if (c7a == this.A04) {
            return;
        }
        A02();
        this.A04 = c7a;
        A03();
    }

    public final boolean A0R() {
        return this.A02 && (!this.A01 || this.A07.A78() == Long.MIN_VALUE);
    }
}
