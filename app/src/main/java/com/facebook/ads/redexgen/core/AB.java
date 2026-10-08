package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.facebook.ads.androidx.media3.common.Timeline;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AB implements Handler.Callback, InterfaceC2575nq, InterfaceC1213Ev, InterfaceC1162Cw, C6P, InterfaceC10307b {
    public static byte[] A0x;
    public static String[] A0y = {"EvYOBb0fNCsu7OcAaOZNwoEPwn2", "8jIqnMhTOhQ3fU", "vmW", "edZR1F4oYcKYyzs7tUfX3dHGMGqqrKBY", "TI8UsWNSVk9Jh7srInWeHwVEqkc209d4", "AVB8fiMNMM9Dy8Zuh880FwllBoFt5PF1", "1mkHXRje2n0Pvvw2j", "LF2w13BN71krhrKRtprOb2x3jYcy1FYO"};
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public long A04;
    public long A06;
    public C10126j A07;
    public C10166n A08;
    public C7Z A0A;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public InterfaceC2634oo A0B;
    public C10497u A0C;
    public InterfaceC1163Cx A0D;
    public boolean A0G;
    public boolean A0H;
    public boolean A0I;
    public boolean A0K;
    public boolean A0M;
    public boolean A0N;
    public boolean A0O;
    public boolean A0P;
    public boolean A0Q;
    public boolean A0R;
    public boolean A0S;
    public boolean A0T;
    public boolean A0U;
    public boolean A0V;
    public InterfaceC2634oo[] A0W;
    public final long A0Y;
    public final long A0Z;
    public final Handler A0a;
    public final HandlerThread A0b;
    public final C2692pl A0c;
    public final C2690pj A0d;
    public final AnonymousClass45 A0e;
    public final C4X A0f;
    public final C2642ow A0g;
    public final C10156m A0h;
    public final AnonymousClass74 A0i;
    public final C2630ok A0k;
    public final AbstractC1214Ew A0l;
    public final C1215Ex A0m;
    public final F6 A0n;
    public final C10819g A0o;
    public final ArrayList<C10146l> A0p;
    public final boolean A0q;
    public final boolean A0r;
    public final boolean A0s;
    public final boolean A0t;
    public final boolean A0u;
    public final InterfaceC2634oo[] A0v;
    public final InterfaceC10447p[] A0w;
    public long A05 = C.TIME_UNSET;

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    public EnumC2291ir A0E = EnumC2291ir.A09;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0J = false;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public C7W A09 = null;

    @MetaExoPlayerCustomization("D63737392: Added for negative testing")
    public boolean A0L = false;

    @MetaExoPlayerCustomization("D71523094: Added for negative testing")
    public Integer A0F = null;
    public final C7E A0j = new C7E();

    @MetaExoPlayerCustomization
    public final int A0X = A00();

    public static String A0D(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0x, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "wOV";
            strArr[6] = "lGv9KfQpa0xBFnWlu";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 57);
        }
        return new String(bArrCopyOfRange);
    }

    /* JADX WARN: Code restructure failed: missing block: B:186:0x03ab, code lost:
    
        r24.A0R = r24.A0P;
     */
    /* JADX WARN: Code restructure failed: missing block: B:187:0x03bb, code lost:
    
        if (com.facebook.ads.redexgen.core.AB.A0y[5].charAt(1) == 'q') goto L220;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x03bd, code lost:
    
        r2 = com.facebook.ads.redexgen.core.AB.A0y;
        r2[4] = "Uyz0TdICBPSSMiRUHh3H6S4m2yqjGOAg";
        r2[3] = "3B1Lhsj2yRloVQBWBzqqqLZ9kauiXzuH";
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x03cb, code lost:
    
        if (r24.A0B == null) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03d4, code lost:
    
        if (r24.A0B.A9N() != 1) goto L193;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x03d6, code lost:
    
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:193:0x03d7, code lost:
    
        A0W(2, r8);
        A0O();
     */
    /* JADX WARN: Code restructure failed: missing block: B:217:0x043f, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x044b, code lost:
    
        throw new java.lang.RuntimeException();
     */
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 25
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:123:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01fa  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0F() throws com.facebook.ads.redexgen.core.AD, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 1100
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A0F():void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0P() throws com.facebook.ads.redexgen.core.AD, java.io.IOException {
        /*
            Method dump skipped, instruction units count: 560
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A0P():void");
    }

    public static void A0R() {
        A0x = new byte[]{-108, -57, -66, -97, -69, -80, -56, -76, -63, -104, -68, -65, -69, -104, -67, -61, -76, -63, -67, -80, -69, -15, 36, Ascii.ESC, -4, Ascii.CAN, Ascii.CR, 37, 17, Ascii.RS, -11, Ascii.EM, Ascii.FS, Ascii.CAN, -11, Ascii.SUB, 32, 17, Ascii.RS, Ascii.SUB, Ascii.CR, Ascii.CAN, -26, -12, Ascii.CR, Ascii.SUB, Ascii.DLE, Ascii.CAN, 17, Ascii.RS, -87, -57, -50, -49, -46, -55, -50, -57, -128, -51, -59, -45, -45, -63, -57, -59, -45, -128, -45, -59, -50, -44, -128, -63, -58, -44, -59, -46, -128, -46, -59, -52, -59, -63, -45, -59, -114, -107, -70, -64, -79, -66, -70, -83, -72, 108, -66, -63, -70, -64, -75, -71, -79, 108, -79, -66, -66, -69, -66, 122, -54, -26, -37, -13, -36, -37, -35, -27, -102, -33, -20, -20, -23, -20, -88, -114, -86, -97, -73, -96, -97, -95, -87, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -96, -77, -92, -92, -93, -80, -93, -94, -126, -77, -80, -97, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, 106, 94, -84, -93, -74, -78, -118, -83, -97, -94, -114, -83, -79, -89, -78, -89, -83, -84, -117, -79, 120, 94, 99, -94, -76, -48, -42, -45, -60, -58, -127, -58, -45, -45, -48, -45, -113, -72, -39, -44, -43, -123, -53, -58, -50, -47, -54, -55, -109, -78, -97, -91, -84, -67, -59, -56, -57, -54, -71, -54, -63, -60, -47, 120, -63, -65, -58, -57, -54, -63, -58, -65, 120, -53, -52, -54, -67, -71, -59, 120, -67, -54, -54, -57, -54, -110, 120, -108, -78, -71, -87, -82, -89, 96, -76, -81, 96, -77, -91, -82, -92, 96, -83, -91, -77, -77, -95, -89, -91, 96, -81, -82, 96, -95, 96, -92, -91, -95, -92, 96, -76, -88, -78, -91, -95, -92, 110, 5, Ascii.RS, Ascii.NAK, 40, 32, Ascii.NAK, 19, 36, Ascii.NAK, Ascii.DC4, -48, Ascii.NAK, 34, 34, Ascii.US, 34, -48, Ascii.DC4, Ascii.NAK, Ascii.FS, Ascii.EM, 38, Ascii.NAK, 34, Ascii.EM, Ascii.RS, Ascii.ETB, -48, Ascii.GS, Ascii.NAK, 35, 35, 17, Ascii.ETB, Ascii.NAK, -48, Ascii.US, Ascii.RS, -48, Ascii.NAK, 40, 36, Ascii.NAK, 34, Ascii.RS, 17, Ascii.FS, -48, 36, Ascii.CAN, 34, Ascii.NAK, 17, Ascii.DC4, -34, -34, -23, -51, -23, -25, -33, -47, -23, -20, -27, 37, Ascii.GS, Ascii.FS, 33, Ascii.EM, 8, Ascii.GS, 42, 33, 39, Ascii.FS, 1, Ascii.FS, -70, -81, -68, -77, -71, -82, -102, -71, -67, -77, -66, -77, -71, -72, -97, -67, -18, -31, -20, -24, -35, -33, -31, -49, -16, -18, -31, -35, -23};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 18 out of bounds for length 16
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x021b A[PHI: r8
  0x021b: PHI (r8v4 com.facebook.ads.redexgen.X.no) = (r8v2 com.facebook.ads.redexgen.X.no), (r8v6 com.facebook.ads.redexgen.X.no) binds: [B:93:0x024d, B:83:0x0219] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0e(com.facebook.ads.redexgen.core.C10136k r15) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A0e(com.facebook.ads.redexgen.X.6k):void");
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 22 out of bounds for length 20
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:135)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0f(C10166n c10166n) throws Throwable {
        long jLongValue;
        C2573no c2573noA0K;
        long jLongValue2;
        boolean z;
        this.A0h.A03(1);
        Pair<Object, Long> pairA09 = A09(c10166n, true);
        if (pairA09 == null) {
            c2573noA0K = A0A();
            jLongValue2 = C.TIME_UNSET;
            jLongValue = C.TIME_UNSET;
            z = true;
        } else {
            Object obj = pairA09.first;
            jLongValue = ((Long) pairA09.second).longValue();
            c2573noA0K = this.A0j.A0K(this.A0A.A03, obj, jLongValue);
            if (c2573noA0K.A00()) {
                jLongValue2 = 0;
                z = true;
            } else {
                jLongValue2 = ((Long) pairA09.second).longValue();
                z = c10166n.A01 == C.TIME_UNSET;
            }
        }
        try {
            try {
                if (this.A0D == null || this.A02 > 0) {
                    this.A08 = c10166n;
                    this.A07 = null;
                } else {
                    try {
                        if (jLongValue2 == C.TIME_UNSET) {
                            A0V(4);
                            A13(false, true, false);
                        } else {
                            long jA6r = jLongValue2;
                            if (c2573noA0K.equals(this.A0A.A05)) {
                                C7A c7aA0F = this.A0j.A0F();
                                if (c7aA0F != null && jA6r != 0) {
                                    jA6r = c7aA0F.A07.A6r(jA6r, this.A0C);
                                }
                                if (C2Y.A01(jA6r) == C2Y.A01(this.A0A.A0C)) {
                                    this.A0A = this.A0A.A06(c2573noA0K, this.A0A.A0C, jLongValue, A01());
                                    if (z) {
                                        this.A0h.A04(2);
                                        return;
                                    }
                                    return;
                                }
                            }
                            long jA06 = A06(c2573noA0K, jA6r);
                            z |= jLongValue2 != jA06;
                            jLongValue2 = jA06;
                        }
                    } catch (Throwable th) {
                        th = th;
                        this.A0A = this.A0A.A06(c2573noA0K, jLongValue2, jLongValue, A01());
                        if (z) {
                            this.A0h.A04(2);
                        }
                        throw th;
                    }
                }
                this.A0A = this.A0A.A06(c2573noA0K, jLongValue2, jLongValue, A01());
                if (z) {
                    this.A0h.A04(2);
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    static {
        A0R();
    }

    public AB(InterfaceC2634oo[] interfaceC2634ooArr, AbstractC1214Ew abstractC1214Ew, C1215Ex c1215Ex, AnonymousClass74 anonymousClass74, F6 f6, boolean z, int i, boolean z2, Handler handler, AnonymousClass45 anonymousClass45, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, long j, boolean z9, int i2, boolean z10, boolean z11, boolean z12, boolean z13, boolean z14, boolean z15, C8O c8o) {
        this.A0v = interfaceC2634ooArr;
        this.A0l = abstractC1214Ew;
        this.A0m = c1215Ex;
        this.A0i = anonymousClass74;
        this.A0n = f6;
        this.A0P = z;
        this.A03 = i;
        this.A0V = z2;
        this.A0a = handler;
        this.A0e = anonymousClass45;
        this.A0U = z3;
        this.A0H = z4;
        this.A0G = z5;
        this.A0M = z6;
        this.A0I = z7;
        this.A0T = z8;
        this.A0Z = j;
        this.A0q = z9;
        this.A00 = i2;
        this.A0u = z11;
        this.A0s = z10;
        this.A0O = z12;
        this.A0Q = z13;
        this.A0K = z14;
        this.A0t = z15;
        this.A0N = j > 0;
        this.A0Y = anonymousClass74.A70(c8o);
        this.A0r = anonymousClass74.AIn(c8o);
        this.A0C = C10497u.A03;
        this.A0A = new C7Z(Timeline.A02, C.TIME_UNSET, C2555nW.A06, c1215Ex);
        this.A0h = new C10156m();
        this.A0w = new InterfaceC10447p[interfaceC2634ooArr.length];
        for (int i3 = 0; i3 < interfaceC2634ooArr.length; i3++) {
            interfaceC2634ooArr[i3].AA9(i3, c8o);
            this.A0w[i3] = interfaceC2634ooArr[i3].A7D();
        }
        this.A0g = new C2642ow(this, anonymousClass45);
        this.A0k = new C2630ok(anonymousClass45);
        this.A0o = z11 ? new C10819g(anonymousClass45) : null;
        this.A0p = new ArrayList<>();
        this.A0W = new InterfaceC2634oo[0];
        this.A0d = new C2690pj();
        this.A0c = new C2692pl();
        abstractC1214Ew.A02(this, f6);
        this.A0b = new HandlerThread(A0D(21, 29, 115), -16);
        this.A0b.start();
        this.A0f = anonymousClass45.A5P(this.A0b.getLooper(), this);
    }

    @MetaExoPlayerCustomization
    private int A00() {
        int exoplayerThreadPollingIntervalMs = MetaExoPlayerUpgradeConfig.A00(EnumC2326jY.A04);
        if (exoplayerThreadPollingIntervalMs > 0) {
            return exoplayerThreadPollingIntervalMs;
        }
        return 10;
    }

    private long A01() {
        return A04(this.A0A.A0B);
    }

    private final long A02() {
        long loadingPeriodStartPositionUs;
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            loadingPeriodStartPositionUs = 0;
        } else {
            loadingPeriodStartPositionUs = A05(c7aA0E);
        }
        if (c7aA0E == null || loadingPeriodStartPositionUs == C.TIME_UNSET) {
            return 0L;
        }
        return c7aA0E.A0C(loadingPeriodStartPositionUs);
    }

    private final long A03() {
        long jA0C;
        C7A c7aA0F = this.A0j.A0F();
        if (c7aA0F == null) {
            jA0C = 0;
        } else {
            jA0C = c7aA0F.A0C(c7aA0F.A0D(this.A06));
        }
        return jA0C + A02();
    }

    private long A04(long j) {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            return 0L;
        }
        return j - c7aA0E.A0D(this.A06);
    }

    private final long A05(C7A c7a) {
        long jMin = Long.MAX_VALUE;
        DT[] dtArr = c7a.A09;
        for (int i = 0; i < dtArr.length; i++) {
            if (dtArr[i] instanceof DU) {
                long periodStartPositionUs = ((DU) dtArr[i]).A89();
                jMin = Math.min(jMin, periodStartPositionUs);
            }
        }
        return jMin == Long.MAX_VALUE ? C.TIME_UNSET : jMin;
    }

    private long A06(C2573no c2573no, long j) throws AD {
        return A07(false, c2573no, j, this.A0j.A0F() != this.A0j.A0G());
    }

    private long A07(boolean z, C2573no c2573no, long j, boolean z2) throws AD {
        A0O();
        this.A0R = false;
        A0V(2);
        C7A c7aA0F = this.A0j.A0F();
        C7A c7aA0B = c7aA0F;
        while (true) {
            if (c7aA0B == null) {
                break;
            }
            if (A18(c2573no, j, c7aA0B)) {
                this.A0j.A0S(c7aA0B);
                break;
            }
            c7aA0B = this.A0j.A0B();
        }
        if (c7aA0F != c7aA0B || z2) {
            for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
                A0l(interfaceC2634oo);
            }
            this.A0W = new InterfaceC2634oo[0];
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[4] = "70t8rv27mnV5UL6KHl8v284ienTbIO4o";
            strArr[3] = "4hBvGCC7ZdKRW68bijyzpqxjpy9h3CGi";
            c7aA0F = null;
        }
        if (c7aA0B != null) {
            A0g(c7aA0F);
            if (c7aA0B.A01) {
                j = c7aA0B.A07.AJ8(j, z);
                c7aA0B.A07.A60(j - this.A0Y, this.A0r);
            }
            A0Y(j);
            A0w(this.A0G);
        } else {
            this.A0j.A0M(true);
            A0Y(j);
        }
        A0v(false);
        this.A0f.AJA(2);
        return j;
    }

    private Pair<Object, Long> A08(Timeline timeline, int i, long j) {
        return timeline.A0D(this.A0d, this.A0c, i, j);
    }

    private Pair<Object, Long> A09(C10166n c10166n, boolean z) {
        int iA0A;
        Timeline timeline = this.A0A.A03;
        Timeline timeline2 = c10166n.A02;
        if (timeline.A0N()) {
            return null;
        }
        if (timeline2.A0N()) {
            timeline2 = timeline;
        }
        try {
            Pair<Object, Long> periodPosition = timeline2.A0E(this.A0d, this.A0c, c10166n.A00, c10166n.A01);
            if (timeline == timeline2 || (iA0A = timeline.A0A(periodPosition.first)) != -1) {
                return periodPosition;
            }
            if (!z || A0C(periodPosition.first, timeline2, timeline) == null) {
                return null;
            }
            return A08(timeline, timeline.A0H(iA0A, this.A0c).A00, C.TIME_UNSET);
        } catch (IndexOutOfBoundsException unused) {
            throw new C09172q(timeline, c10166n.A00, c10166n.A01);
        }
    }

    private C2573no A0A() {
        Timeline timeline = this.A0A.A03;
        if (timeline.A0N()) {
            return C7Z.A0E;
        }
        return new C2573no(timeline.A0M(timeline.A0K(timeline.A0B(this.A0V), this.A0d).A00));
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D71523094: Added for negative testing")
    private final Integer A0B() {
        C7V playbackLatencyConfig;
        if (this.A09 == null || (playbackLatencyConfig = this.A09.A02()) == null) {
            String[] strArr = A0y;
            if (strArr[2].length() != strArr[6].length()) {
                A0y[7] = "1rqbEBrQgQNr61xUccdMybR9UEwvq3L8";
                return null;
            }
        } else {
            int iA00 = playbackLatencyConfig.A00();
            if (A0y[0].length() != 16) {
                String[] strArr2 = A0y;
                strArr2[2] = "KUZ";
                strArr2[6] = "wQAKuizVIm50S6vdz";
                return Integer.valueOf(iA00);
            }
        }
        throw new RuntimeException();
    }

    private Object A0C(Object obj, Timeline timeline, Timeline timeline2) {
        int iA0A = timeline.A0A(obj);
        int i = -1;
        int maxIterations = timeline.A06();
        for (int newPeriodIndex = 0; newPeriodIndex < maxIterations && i == -1 && (iA0A = timeline.A09(iA0A, this.A0c, this.A0d, this.A03, this.A0V)) != -1; newPeriodIndex++) {
            i = timeline2.A0A(timeline.A0M(iA0A));
        }
        if (i == -1) {
            return null;
        }
        return timeline2.A0M(i);
    }

    private void A0E() {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            return;
        }
        c7aA0E.A07.A4s(c7aA0E.A0D(this.A06));
    }

    private void A0G() {
        A0V(4);
        A13(false, true, false);
    }

    private void A0H() {
        int i;
        if (this.A0h.A06(this.A0A)) {
            Handler handler = this.A0a;
            int i2 = this.A0h.A01;
            if (this.A0h.A03) {
                i = this.A0h.A00;
            } else {
                i = -1;
            }
            handler.obtainMessage(0, i2, i, this.A0A).sendToTarget();
            this.A0h.A05(this.A0A);
        }
    }

    private void A0I() throws IOException {
        C7A c7aA0E = this.A0j.A0E();
        C7A readingPeriodHolder = this.A0j.A0G();
        if (c7aA0E != null && !c7aA0E.A02) {
            if (readingPeriodHolder != null) {
                C7A loadingPeriodHolder = readingPeriodHolder.A0I();
                if (loadingPeriodHolder != c7aA0E) {
                    return;
                }
            }
            for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
                if (!interfaceC2634oo.A9p()) {
                    return;
                }
            }
            c7aA0E.A07.ACS();
        }
    }

    private void A0J() throws IOException {
        this.A0j.A0L(this.A06);
        if (this.A0j.A0O()) {
            C7B c7bA0H = this.A0j.A0H(this.A06, this.A0A);
            if (c7bA0H == null) {
                this.A0D.ACT();
                return;
            }
            this.A0j.A0J(this.A0w, this.A0t ? 60000000L : 0L, this.A0l, this.A0i.A6v(), this.A0D, c7bA0H, this.A0m).AH5(this, c7bA0H.A03);
            A0y(true);
            A0v(false);
        }
    }

    private void A0K() {
        A13(true, true, true);
        this.A0i.AFc(C8O.A03);
        A0V(1);
        this.A0b.quit();
        synchronized (this) {
            this.A0S = true;
            notifyAll();
        }
    }

    private void A0L() throws AD {
        boolean z;
        if (!this.A0j.A0N()) {
            return;
        }
        float f = this.A0g.A8m().A01;
        C7A periodHolder = this.A0j.A0G();
        boolean z2 = true;
        for (C7A c7aA0F = this.A0j.A0F(); c7aA0F != null && c7aA0F.A02; c7aA0F = c7aA0F.A0I()) {
            C1215Ex c1215ExA0L = c7aA0F.A0L(f, this.A0A.A03);
            if (c1215ExA0L != null) {
                if (z2) {
                    C7A c7aA0F2 = this.A0j.A0F();
                    boolean zA0S = this.A0j.A0S(c7aA0F2);
                    boolean[] zArr = new boolean[this.A0v.length];
                    long jA0G = c7aA0F2.A0G(c1215ExA0L, this.A0A.A0C, zA0S, zArr);
                    if (this.A0A.A00 != 4 && jA0G != this.A0A.A0C) {
                        this.A0A = this.A0A.A06(this.A0A.A05, jA0G, this.A0A.A01, A01());
                        this.A0h.A04(4);
                        A0Y(jA0G);
                    }
                    int i = 0;
                    boolean[] zArr2 = new boolean[this.A0v.length];
                    for (int i2 = 0; i2 < this.A0v.length; i2++) {
                        InterfaceC2634oo interfaceC2634oo = this.A0v[i2];
                        zArr2[i2] = interfaceC2634oo.A9A() != 0;
                        DT dt = c7aA0F2.A09[i2];
                        if (dt != null) {
                            i++;
                        }
                        if (zArr2[i2]) {
                            DT dtA9D = interfaceC2634oo.A9D();
                            if (A0y[7].charAt(12) == '2') {
                                throw new RuntimeException();
                            }
                            A0y[1] = "PyyQ9suxdi7C";
                            if (dt != dtA9D) {
                                A0l(interfaceC2634oo);
                            } else if (zArr[i2]) {
                                interfaceC2634oo.AIm(this.A06);
                            }
                        }
                    }
                    this.A0A = this.A0A.A07(c7aA0F2.A0J(), c7aA0F2.A0K());
                    A14(zArr2, i);
                    z = false;
                } else {
                    this.A0j.A0S(c7aA0F);
                    if (c7aA0F.A02) {
                        z = false;
                        c7aA0F.A0F(c1215ExA0L, Math.max(c7aA0F.A00.A03, c7aA0F.A0D(this.A06)), false);
                    } else {
                        z = false;
                    }
                }
                A0v(true);
                if (this.A0A.A00 != 4) {
                    A0w(z);
                    A0Q();
                    this.A0f.AJA(2);
                    return;
                }
                return;
            }
            if (c7aA0F == periodHolder) {
                z2 = false;
            }
        }
    }

    private void A0M() {
        for (int size = this.A0p.size() - 1; size >= 0; size--) {
            if (!A16(this.A0p.get(size))) {
                this.A0p.get(size).A03.A0A(false);
                this.A0p.remove(size);
            }
        }
        Collections.sort(this.A0p);
    }

    private void A0N() throws AD {
        this.A0R = false;
        this.A0g.A05();
        this.A0k.A00();
        if (this.A0u) {
            this.A0o.A00();
        }
        for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
            interfaceC2634oo.start();
        }
    }

    private void A0O() throws AD {
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
            A0m(interfaceC2634oo);
        }
    }

    private void A0Q() throws AD {
        if (!this.A0j.A0N()) {
            return;
        }
        C7A c7aA0F = this.A0j.A0F();
        long jAHQ = c7aA0F.A07.AHQ();
        if (jAHQ != C.TIME_UNSET) {
            A0Y(jAHQ);
            if (jAHQ != this.A0A.A0C) {
                this.A0A = this.A0A.A06(this.A0A.A05, jAHQ, this.A0A.A01, A01());
                this.A0h.A04(4);
            }
        } else {
            C2642ow c2642ow = this.A0g;
            C7A playingPeriodHolder = this.A0j.A0G();
            this.A06 = c2642ow.A04(c7aA0F != playingPeriodHolder);
            long jA0D = c7aA0F.A0D(this.A06);
            A0Z(this.A0A.A0C, jA0D);
            this.A0A.A0C = jA0D;
        }
        C7A playingPeriodHolder2 = this.A0j.A0E();
        this.A0A.A0B = playingPeriodHolder2.A09();
        this.A0A.A0D = A01();
        this.A0A.A0D = c7aA0F.A0C(this.A0A.A0C);
    }

    private void A0S(byte b) {
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E != null && this.A0U) {
            c7aA0E.A07.AKb(b);
        }
    }

    private void A0T(float f) {
        for (C7A c7aA0D = this.A0j.A0D(); c7aA0D != null && c7aA0D.A02; c7aA0D = c7aA0D.A0I()) {
            for (InterfaceC2537nE interfaceC2537nE : c7aA0D.A0K().A04) {
                if (interfaceC2537nE != null) {
                    interfaceC2537nE.AFJ(f);
                }
            }
        }
    }

    private void A0U(int i) throws AD {
        this.A03 = i;
        if (!this.A0j.A0P(this.A0A.A03, i)) {
            if (A0y[0].length() == 16) {
                throw new RuntimeException();
            }
            A0y[5] = "F0pbcDG7mrKSFF2ySsjJdp1en5xQxzay";
            A0x(true);
        }
        A0v(false);
    }

    private void A0V(int i) {
        if (this.A0A.A00 != i) {
            this.A0A = this.A0A.A01(i);
            if (i == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0W(int i, boolean z) {
        if (this.A0A.A00 != i) {
            C7Z c7zA03 = this.A0A.A03(i, z);
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            A0y[1] = "pTubBuiOOGTe";
            this.A0A = c7zA03;
            if (i == 2) {
                this.A04 = System.currentTimeMillis();
            } else {
                this.A04 = -1L;
            }
        }
    }

    private void A0X(int i, boolean playing, int i2) throws AD {
        C7A c7aA0F = this.A0j.A0F();
        InterfaceC2634oo interfaceC2634oo = this.A0v[i];
        this.A0W[i2] = interfaceC2634oo;
        if (interfaceC2634oo.A9A() == 0) {
            C7A c7aA0G = this.A0j.A0G();
            C7A playingPeriodHolder = this.A0j.A0F();
            boolean z = c7aA0G == playingPeriodHolder;
            C10477s c10477s = c7aA0F.A0K().A03[i];
            C2725qI[] c2725qIArrA1A = A1A(c7aA0F.A0K().A04[i]);
            boolean z2 = this.A0P && this.A0A.A00 == 3;
            interfaceC2634oo.A6L(c10477s, c2725qIArrA1A, c7aA0F.A09[i], this.A06, !playing && z2, z, c7aA0G.A0H(this.A0K), c7aA0F.A0B());
            this.A0g.A09(interfaceC2634oo);
            if (z2) {
                interfaceC2634oo.start();
            }
        }
    }

    private void A0Y(long j) throws AD {
        long jA0E;
        if (this.A0j.A0N()) {
            jA0E = this.A0j.A0F().A0E(j);
        } else {
            jA0E = ((long) (this.A0t ? 60000000 : 0)) + j;
        }
        this.A06 = jA0E;
        this.A0g.A07(this.A06);
        for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
            long j2 = this.A06;
            String[] strArr = A0y;
            if (strArr[2].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            A0y[5] = "3LWS1la82nevxXslk8B3HGv7gilut34u";
            interfaceC2634oo.AIm(j2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0108 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00fd A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0Z(long r8, long r10) throws com.facebook.ads.redexgen.core.AD {
        /*
            Method dump skipped, instruction units count: 389
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A0Z(long, long):void");
    }

    private void A0a(long j, long j2) {
        this.A0f.AIT(2);
        this.A0f.AJB(2, j + j2);
    }

    private void A0b(C2704px c2704px) {
        this.A0g.AJd(c2704px);
        if (this.A0o != null) {
            this.A0o.AJd(c2704px);
        }
        if (this.A0k != null) {
            this.A0k.AJd(c2704px);
        }
    }

    private void A0c(C10126j c10126j) throws AD {
        throw new NullPointerException(A0D(376, 16, 17));
    }

    private void A0d(C10126j c10126j, boolean z) throws AD {
        this.A0h.A03(1);
        throw new NullPointerException(A0D(363, 13, 127));
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0g(com.facebook.ads.redexgen.core.C7A r10) throws com.facebook.ads.redexgen.core.AD {
        /*
            r9 = this;
            com.facebook.ads.redexgen.X.7E r0 = r9.A0j
            com.facebook.ads.redexgen.X.7A r5 = r0.A0F()
            if (r5 == 0) goto La
            if (r10 != r5) goto Lb
        La:
            return
        Lb:
            r4 = 0
            com.facebook.ads.redexgen.X.oo[] r0 = r9.A0v
            int r0 = r0.length
            boolean[] r3 = new boolean[r0]
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AB.A0y
            r0 = 4
            r1 = r2[r0]
            r0 = 3
            r2 = r2[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            char r0 = r2.charAt(r0)
            if (r1 == r0) goto La5
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AB.A0y
            java.lang.String r1 = ""
            r0 = 0
            r2[r0] = r1
            r6 = 0
        L2c:
            com.facebook.ads.redexgen.X.oo[] r0 = r9.A0v
            int r0 = r0.length
            if (r6 >= r0) goto L91
            com.facebook.ads.redexgen.X.oo[] r0 = r9.A0v
            r7 = r0[r6]
            int r0 = r7.A9A()
            if (r0 == 0) goto L8f
            r0 = 1
        L3c:
            r3[r6] = r0
            com.facebook.ads.redexgen.X.Ex r0 = r5.A0K()
            boolean r0 = r0.A00(r6)
            if (r0 == 0) goto L4a
            int r4 = r4 + 1
        L4a:
            boolean r0 = r3[r6]
            if (r0 == 0) goto L85
            com.facebook.ads.redexgen.X.Ex r8 = r5.A0K()
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AB.A0y
            r0 = 5
            r1 = r1[r0]
            r0 = 1
            char r1 = r1.charAt(r0)
            r0 = 113(0x71, float:1.58E-43)
            if (r1 == r0) goto L88
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AB.A0y
            java.lang.String r1 = "5yNp1I7g7IY9vjHrSpd0TTAHnxoP5q4N"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "spEmpaFlzQc3LcHeWE04rIrq6t30lchN"
            r0 = 3
            r2[r0] = r1
            boolean r0 = r8.A00(r6)
            if (r0 == 0) goto L82
        L72:
            boolean r0 = r7.AAN()
            if (r0 == 0) goto L85
            com.facebook.ads.redexgen.X.DT r1 = r7.A9D()
            com.facebook.ads.redexgen.X.DT[] r0 = r10.A09
            r0 = r0[r6]
            if (r1 != r0) goto L85
        L82:
            r9.A0l(r7)
        L85:
            int r6 = r6 + 1
            goto L2c
        L88:
            boolean r0 = r8.A00(r6)
            if (r0 == 0) goto L82
            goto L72
        L8f:
            r0 = 0
            goto L3c
        L91:
            com.facebook.ads.redexgen.X.7Z r2 = r9.A0A
            com.facebook.ads.redexgen.X.nW r1 = r5.A0J()
            com.facebook.ads.redexgen.X.Ex r0 = r5.A0K()
            com.facebook.ads.redexgen.X.7Z r0 = r2.A07(r1, r0)
            r9.A0A = r0
            r9.A14(r3, r4)
            return
        La5:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A0g(com.facebook.ads.redexgen.X.7A):void");
    }

    private void A0h(C10327d c10327d) throws AD {
        if (c10327d.A0D()) {
            return;
        }
        try {
            c10327d.A05().A9i(c10327d.A01(), c10327d.A09());
        } finally {
            c10327d.A0A(true);
        }
    }

    private void A0i(C10327d c10327d) throws AD {
        if (c10327d.A02() == C.TIME_UNSET) {
            A0j(c10327d);
            return;
        }
        if (this.A0D == null || this.A02 > 0) {
            this.A0p.add(new C10146l(c10327d));
            return;
        }
        C10146l c10146l = new C10146l(c10327d);
        if (A16(c10146l)) {
            this.A0p.add(c10146l);
            Collections.sort(this.A0p);
        } else {
            c10327d.A0A(false);
        }
    }

    private void A0j(C10327d c10327d) throws AD {
        if (c10327d.A03() == this.A0f.A8R()) {
            A0h(c10327d);
            if (this.A0A.A00 == 3 || this.A0A.A00 == 2) {
                this.A0f.AJA(2);
                return;
            }
            return;
        }
        this.A0f.ACj(15, c10327d).A02();
    }

    private void A0k(final C10327d c10327d) {
        Looper looperA03 = c10327d.A03();
        if (!looperA03.getThread().isAlive()) {
            Log.w(A0D(220, 3, 37), A0D(258, 40, 7));
            c10327d.A0A(false);
        } else {
            this.A0e.A5P(looperA03, null).A03(new Runnable() { // from class: com.facebook.ads.redexgen.X.6h
                @Override // java.lang.Runnable
                public final void run() {
                    this.A00.A1E(c10327d);
                }
            });
        }
    }

    private void A0l(InterfaceC2634oo interfaceC2634oo) throws AD {
        this.A0g.A08(interfaceC2634oo);
        A0m(interfaceC2634oo);
        interfaceC2634oo.A5x();
    }

    private void A0m(InterfaceC2634oo interfaceC2634oo) throws AD {
        if (interfaceC2634oo.A9A() == 2) {
            interfaceC2634oo.stop();
        }
    }

    private void A0n(C10497u c10497u) {
        this.A0C = c10497u;
    }

    private void A0o(InterfaceC2574np interfaceC2574np) {
        if (!this.A0j.A0T(interfaceC2574np)) {
            return;
        }
        this.A0j.A0L(this.A06);
        A0w(false);
    }

    private void A0p(InterfaceC2574np interfaceC2574np) throws AD {
        byte b;
        if (!this.A0j.A0T(interfaceC2574np)) {
            return;
        }
        C7A c7aA0E = this.A0j.A0E();
        c7aA0E.A0N(this.A0g.A8m().A01, this.A0A.A03);
        A0s(c7aA0E.A0J(), c7aA0E.A0K());
        if (!this.A0j.A0N()) {
            C7A loadingPeriodHolder = this.A0j.A0B();
            A0Y(loadingPeriodHolder.A00.A03);
            A0g(null);
        }
        if (this.A0M || this.A0P) {
            b = 0;
        } else {
            b = 2;
        }
        A0S(b);
        A10(this.A0P);
        if (A0y[7].charAt(12) == '2') {
            throw new RuntimeException();
        }
        A0y[5] = "0JHOWU68jltYXS7XBlXTYuPeT3LWkLA2";
        A0w(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.core.DW
    /* JADX INFO: renamed from: A0q, reason: merged with bridge method [inline-methods] */
    public final void ADV(InterfaceC2574np interfaceC2574np) {
        this.A0f.ACj(10, interfaceC2574np).A02();
    }

    private void A0r(InterfaceC1163Cx interfaceC1163Cx, boolean z, boolean z2) {
        this.A02++;
        A13(true, z, z2);
        this.A0i.AFR(C8O.A03);
        this.A0D = interfaceC1163Cx;
        A0V(2);
        interfaceC1163Cx.AH7(this, null);
        this.A0f.AJA(2);
    }

    private void A0s(C2555nW c2555nW, C1215Ex c1215Ex) {
        this.A0i.AGF(new AnonymousClass73(C8O.A03, this.A0A.A03, this.A0A.A04, this.A0A.A0C, A01(), this.A0g.A8m().A01, this.A0P, this.A0R, C.TIME_UNSET, this.A04), c2555nW, c1215Ex.A04);
    }

    @MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")
    private void A0t(EnumC2291ir enumC2291ir, boolean z) {
        if (this.A0A.A00 != 3) {
            this.A0A = this.A0A.A02(3, enumC2291ir, z);
            this.A04 = -1L;
        }
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "D63737392: Added for negative testing")
    private void A0u(String str) {
        boolean z = false;
        if (str == null) {
            this.A0J = false;
            this.A09 = null;
            return;
        }
        if (str != null && str.length() > 0) {
            z = true;
        }
        this.A0J = z;
        this.A09 = new C7W(str);
    }

    private void A0v(boolean z) {
        C2573no c2573no;
        C7A c7aA0E = this.A0j.A0E();
        if (c7aA0E == null) {
            C7Z c7z = this.A0A;
            if (A0y[1].length() == 31) {
                throw new RuntimeException();
            }
            String[] strArr = A0y;
            strArr[2] = "b0w";
            strArr[6] = "WyMJg745VdMbfing6";
            c2573no = c7z.A05;
        } else {
            c2573no = c7aA0E.A00.A04;
        }
        C2573no loadingMediaPeriodId = this.A0A.A04;
        boolean loadingMediaPeriodChanged = !loadingMediaPeriodId.equals(c2573no);
        if (loadingMediaPeriodChanged) {
            this.A0A = this.A0A.A05(c2573no);
        }
        if ((loadingMediaPeriodChanged || z) && c7aA0E != null && c7aA0E.A02) {
            A0s(c7aA0E.A0J(), c7aA0E.A0K());
        }
    }

    @MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182")
    private void A0w(boolean z) {
        long jA0C;
        C7A c7aA0E = this.A0j.A0E();
        long jA0A = c7aA0E.A0A();
        if (jA0A == Long.MIN_VALUE) {
            A0y(false);
            return;
        }
        long jA0D = c7aA0E.A0D(this.A06);
        if (!this.A0s || c7aA0E == this.A0j.A0F() || this.A0j.A0F() == null) {
            jA0C = c7aA0E.A0C(jA0D);
            if (this.A0O) {
                for (C7A c7aA0F = this.A0j.A0F(); c7aA0F != null && c7aA0F != c7aA0E; c7aA0F = c7aA0F.A0I()) {
                    long nextLoadPositionUs = this.A06;
                    jA0C += c7aA0F.A0C(c7aA0F.A0D(nextLoadPositionUs));
                }
            }
        } else {
            jA0C = A02();
        }
        Timeline timeline = this.A0A.A03;
        C2573no c2573no = c7aA0E.A00.A04;
        float f = this.A0g.A8m().A01;
        boolean z2 = this.A0P || z;
        boolean z3 = this.A0R;
        long nextLoadPositionUs2 = this.A04;
        boolean zAJv = this.A0i.AJv(new AnonymousClass73(null, timeline, c2573no, jA0D, jA0C, f, z2, z3, C.TIME_UNSET, nextLoadPositionUs2));
        if (this.A0T && this.A0P && this.A0R && !zAJv && this.A0A.A00 == 2) {
            Long lValueOf = Long.valueOf(jA0D / 1000);
            Long lValueOf2 = Long.valueOf(jA0C / 1000);
            Long lValueOf3 = Long.valueOf(jA0A / 1000);
            String[] strArr = A0y;
            if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "Frr";
            strArr2[6] = "mfKzHFhLmxUYLc6Gx";
            this.A0a.obtainMessage(5, C5C.A0n(A0D(125, 70, 5), lValueOf, lValueOf2, lValueOf3)).sendToTarget();
            this.A0T = false;
        }
        A0y(zAJv);
        if (zAJv) {
            c7aA0E.A0O(this.A06);
        }
    }

    private void A0x(boolean z) throws AD {
        C2573no c2573no = this.A0j.A0F().A00.A04;
        long jA07 = A07(false, c2573no, this.A0A.A0C, true);
        if (jA07 != this.A0A.A0C) {
            this.A0A = this.A0A.A06(c2573no, jA07, this.A0A.A01, A01());
            if (z) {
                C10156m c10156m = this.A0h;
                String[] strArr = A0y;
                if (strArr[4].charAt(1) == strArr[3].charAt(1)) {
                    throw new RuntimeException();
                }
                A0y[5] = "dnthUoDEzHvBWSE2tp3YAJwgKJx1FOWZ";
                c10156m.A04(4);
            }
        }
    }

    private void A0y(boolean z) {
        if (this.A0A.A0A != z) {
            this.A0A = this.A0A.A08(z);
        }
    }

    private void A0z(boolean z) throws AD {
        try {
            this.A0R = false;
            this.A0P = z;
            A10(z);
            if (!z) {
                A0O();
                A0Q();
                A0S((byte) 2);
                if (this.A0I) {
                    A0E();
                }
            } else {
                A0S((byte) 0);
                if (this.A0A.A00 != 3) {
                    if (this.A0A.A00 == 2) {
                        this.A0f.AJA(2);
                    }
                } else {
                    A0N();
                    this.A0f.AJA(2);
                }
            }
        } finally {
            this.A0a.obtainMessage(3, Boolean.valueOf(z)).sendToTarget();
        }
    }

    @MetaExoPlayerCustomization("D19875605 Prevent further error loading once pausing video")
    private void A10(boolean z) {
        C7A loadingPeriod = this.A0j.A0E();
        if (loadingPeriod == null) {
            return;
        }
        loadingPeriod.A07.AJc(z);
    }

    private void A11(boolean z) throws AD {
        this.A0V = z;
        if (!this.A0j.A0R(this.A0A.A03, z)) {
            A0x(true);
        }
        A0v(false);
    }

    private void A12(boolean z, boolean z2) {
        A13(true, z, z);
        this.A0h.A03(this.A02 + (z2 ? 1 : 0));
        this.A02 = 0;
        this.A0i.AG6(C8O.A03);
        A0V(1);
    }

    private void A13(boolean z, boolean z2, boolean z3) {
        long j;
        C2555nW c2555nW;
        C1215Ex c1215Ex;
        this.A0f.AIT(2);
        this.A0R = false;
        this.A0g.A06();
        this.A0k.A01();
        if (this.A0u) {
            this.A0o.A01();
        }
        this.A06 = this.A0t ? 60000000L : 0L;
        for (InterfaceC2634oo interfaceC2634oo : this.A0W) {
            try {
                A0l(interfaceC2634oo);
            } catch (AD | RuntimeException e) {
                Log.e(A0D(0, 21, 22), A0D(208, 12, 44), e);
            }
        }
        this.A0W = new InterfaceC2634oo[0];
        this.A0j.A0M(!z2);
        A0y(false);
        if (z2) {
            this.A08 = null;
        }
        if (z3) {
            Iterator<C10146l> it = this.A0p.iterator();
            while (it.hasNext()) {
                it.next().A03.A0A(false);
            }
            this.A0p.clear();
            this.A01 = 0;
        }
        C2573no c2573noA0A = z2 ? A0A() : this.A0A.A05;
        long j2 = C.TIME_UNSET;
        if (z2) {
            j = -9223372036854775807L;
        } else {
            C7Z c7z = this.A0A;
            if (A0y[5].charAt(1) != 'q') {
                String[] strArr = A0y;
                strArr[4] = "7gx390g1msf1u5QKnR2KjvR4WQmRx8YK";
                strArr[3] = "VlC7tbQkEF507tv73u1W2v85d7ApXXNM";
                j = c7z.A0C;
            } else {
                A0y[5] = "C79IK8sPJjEkg2u4SoGimfUAaE3F5yew";
                j = c7z.A0C;
            }
        }
        if (!z2) {
            C7Z c7z2 = this.A0A;
            if (A0y[5].charAt(1) == 'q') {
                throw new RuntimeException();
            }
            String[] strArr2 = A0y;
            strArr2[2] = "uSR";
            strArr2[6] = "FwoZ6mA9qzJ4hrvJt";
            j2 = c7z2.A01;
        }
        Timeline timeline = z3 ? Timeline.A02 : this.A0A.A03;
        int i = this.A0A.A00;
        if (z3) {
            c2555nW = C2555nW.A06;
        } else {
            C7Z c7z3 = this.A0A;
            if (A0y[7].charAt(12) == '2') {
                throw new RuntimeException();
            }
            A0y[5] = "yizxhFEcEwEbIh7DB6ScCbr86G64zHmf";
            c2555nW = c7z3.A06;
        }
        if (z3) {
            c1215Ex = this.A0m;
        } else {
            c1215Ex = this.A0A.A07;
        }
        this.A0A = new C7Z(timeline, c2573noA0A, j, j2, i, false, c2555nW, c1215Ex, c2573noA0A, j, 0L, j);
        if (z && this.A0D != null) {
            this.A0D.AHl(this);
            this.A0D = null;
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x000f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A14(boolean[] r6, int r7) throws com.facebook.ads.redexgen.core.AD {
        /*
            r5 = this;
            com.facebook.ads.redexgen.X.oo[] r0 = new com.facebook.ads.redexgen.core.InterfaceC2634oo[r7]
            r5.A0W = r0
            r4 = 0
            com.facebook.ads.redexgen.X.7E r0 = r5.A0j
            com.facebook.ads.redexgen.X.7A r3 = r0.A0F()
            r2 = 0
        Lc:
            com.facebook.ads.redexgen.X.oo[] r0 = r5.A0v
            int r0 = r0.length
            if (r2 >= r0) goto L26
            com.facebook.ads.redexgen.X.Ex r0 = r3.A0K()
            boolean r0 = r0.A00(r2)
            if (r0 == 0) goto L23
            boolean r1 = r6[r2]
            int r0 = r4 + 1
            r5.A0X(r2, r1, r4)
            r4 = r0
        L23:
            int r2 = r2 + 1
            goto Lc
        L26:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A14(boolean[], int):void");
    }

    private boolean A15() {
        C7A playingPeriodHolder = this.A0j.A0F();
        C7A c7aA0I = playingPeriodHolder.A0I();
        long j = playingPeriodHolder.A00.A00;
        return j == C.TIME_UNSET || this.A0A.A0C < j || (c7aA0I != null && (c7aA0I.A02 || c7aA0I.A00.A04.A00()));
    }

    private boolean A16(C10146l c10146l) {
        if (c10146l.A02 == null) {
            Pair<Object, Long> pairA09 = A09(new C10166n(c10146l.A03.A04(), c10146l.A03.A00(), C2Y.A00(c10146l.A03.A02())), false);
            if (pairA09 == null) {
                return false;
            }
            int iA0A = this.A0A.A03.A0A(pairA09.first);
            if (A0y[5].charAt(1) != 'q') {
                A0y[5] = "NfGCtpMsHKBVYsn3O7a8Zqq9gxyOlhFa";
                c10146l.A01(iA0A, ((Long) pairA09.second).longValue(), pairA09.first);
                return true;
            }
            throw new RuntimeException();
        }
        int iA0A2 = this.A0A.A03.A0A(c10146l.A02);
        if (iA0A2 == -1) {
            return false;
        }
        c10146l.A00 = iA0A2;
        return true;
    }

    private boolean A17(InterfaceC2634oo interfaceC2634oo) {
        C7A c7aA0G = this.A0j.A0G();
        C7A readingPeriodHolder = c7aA0G.A0I();
        if (readingPeriodHolder != null) {
            C7A readingPeriodHolder2 = c7aA0G.A0I();
            if (readingPeriodHolder2.A02 && interfaceC2634oo.A9p()) {
                return true;
            }
        }
        return false;
    }

    private boolean A18(C2573no c2573no, long j, C7A c7a) {
        if (!c2573no.equals(c7a.A00.A04)) {
            return false;
        }
        boolean z = c7a.A02;
        if (A0y[1].length() == 31) {
            throw new RuntimeException();
        }
        A0y[1] = "z9";
        if (z) {
            this.A0A.A03.A0J(this.A0A.A05.A04, this.A0c);
            int iA07 = this.A0c.A07(j);
            if (iA07 != -1) {
                long jA0D = this.A0c.A0D(iA07);
                C7B c7b = c7a.A00;
                if (A0y[5].charAt(1) == 'q') {
                    A0y[5] = "RcBDfVPYXZ1IWswHj8kiKJAUw6BsFYM7";
                    if (jA0D == c7b.A01) {
                        return true;
                    }
                    return false;
                }
                String[] strArr = A0y;
                strArr[4] = "w6QknFDGuvwfcqywG7nwGfdAAoNokq6y";
                strArr[3] = "I5j8Ais0ITqpKL2oROmKoI7QN1W2GqI7";
                if (jA0D == c7b.A01) {
                    return true;
                }
                return false;
            }
            return true;
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00b4  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomizations({@com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Customized Buffered Duration MS D23157182"), @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("D18870411: Adding start stall debug reason")})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean A19(boolean r19) {
        /*
            r18 = this;
            r3 = r18
            com.facebook.ads.redexgen.X.oo[] r0 = r3.A0W
            int r0 = r0.length
            if (r0 != 0) goto Lc
            boolean r0 = r18.A15()
            return r0
        Lc:
            r9 = 0
            if (r19 != 0) goto L1c
            com.facebook.ads.redexgen.X.oo r0 = r3.A0B
            if (r0 == 0) goto L1b
            com.facebook.ads.redexgen.X.oo r0 = r3.A0B
            com.facebook.ads.redexgen.X.ir r0 = r0.A99()
            r3.A0E = r0
        L1b:
            return r9
        L1c:
            com.facebook.ads.redexgen.X.7Z r0 = r3.A0A
            boolean r1 = r0.A0A
            r0 = 1
            if (r1 != 0) goto L24
            return r0
        L24:
            com.facebook.ads.redexgen.X.7E r0 = r3.A0j
            com.facebook.ads.redexgen.X.7A r4 = r0.A0E()
            boolean r0 = r4.A0R()
            if (r0 == 0) goto Lb4
            com.facebook.ads.redexgen.X.7B r5 = r4.A00
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.AB.A0y
            r0 = 7
            r1 = r1[r0]
            r0 = 12
            char r1 = r1.charAt(r0)
            r0 = 50
            if (r1 == r0) goto Lb6
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.AB.A0y
            java.lang.String r1 = "JVFQROlQoWGuZTJ8G1Kf7NjovTqMHrup"
            r0 = 5
            r2[r0] = r1
            boolean r0 = r5.A05
            if (r0 == 0) goto Lb4
            r8 = 1
        L4d:
            boolean r0 = r3.A0s
            if (r0 == 0) goto L67
            com.facebook.ads.redexgen.X.7E r0 = r3.A0j
            com.facebook.ads.redexgen.X.7A r1 = r0.A0F()
            com.facebook.ads.redexgen.X.7E r0 = r3.A0j
            com.facebook.ads.redexgen.X.7A r0 = r0.A0E()
            if (r1 == r0) goto L67
            com.facebook.ads.redexgen.X.7E r0 = r3.A0j
            com.facebook.ads.redexgen.X.7A r0 = r0.A0F()
            if (r0 != 0) goto Laf
        L67:
            long r0 = r3.A06
            long r0 = r4.A0D(r0)
            long r11 = r4.A0C(r0)
        L71:
            long r6 = java.lang.System.currentTimeMillis()
            int r0 = r3.A00
            if (r0 <= 0) goto Lad
            long r4 = r3.A04
            r1 = 0
            int r0 = (r4 > r1 ? 1 : (r4 == r1 ? 0 : -1))
            if (r0 <= 0) goto Lad
            long r0 = r3.A04
            long r6 = r6 - r0
            int r0 = r3.A00
            long r1 = (long) r0
            int r0 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r0 >= 0) goto Lad
            r15 = 1
        L8c:
            if (r8 != 0) goto La5
            com.facebook.ads.redexgen.X.74 r10 = r3.A0i
            com.facebook.ads.redexgen.X.ow r0 = r3.A0g
            com.facebook.ads.redexgen.X.px r0 = r0.A8m()
            float r13 = r0.A01
            boolean r14 = r3.A0R
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            boolean r0 = r10.AJy(r11, r13, r14, r15, r16)
            if (r0 == 0) goto La6
        La5:
            r9 = 1
        La6:
            if (r9 != 0) goto Lac
            com.facebook.ads.redexgen.X.ir r0 = com.facebook.ads.redexgen.core.EnumC2291ir.A04
            r3.A0E = r0
        Lac:
            return r9
        Lad:
            r15 = 0
            goto L8c
        Laf:
            long r11 = r18.A03()
            goto L71
        Lb4:
            r8 = 0
            goto L4d
        Lb6:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A19(boolean):boolean");
    }

    public static C2725qI[] A1A(InterfaceC1208Eq interfaceC1208Eq) {
        int length = interfaceC1208Eq != null ? interfaceC1208Eq.length() : 0;
        C2725qI[] c2725qIArr = new C2725qI[length];
        for (int i = 0; i < length; i++) {
            c2725qIArr[i] = interfaceC1208Eq.A8B(i);
        }
        return c2725qIArr;
    }

    public final Looper A1B() {
        return this.A0b.getLooper();
    }

    /* JADX WARN: Incorrect condition in loop: B:9:0x0010 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void A1C() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.A0S     // Catch: java.lang.Throwable -> L23
            if (r0 == 0) goto L7
            monitor-exit(r2)
            return
        L7:
            com.facebook.ads.redexgen.X.4X r1 = r2.A0f     // Catch: java.lang.Throwable -> L23
            r0 = 7
            r1.AJA(r0)     // Catch: java.lang.Throwable -> L23
            r1 = 0
        Le:
            boolean r0 = r2.A0S     // Catch: java.lang.Throwable -> L23
            if (r0 != 0) goto L18
            r2.wait()     // Catch: java.lang.InterruptedException -> L16 java.lang.Throwable -> L23
            goto Le
        L16:
            r1 = 1
            goto Le
        L18:
            if (r1 == 0) goto L21
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L23
            r0.interrupt()     // Catch: java.lang.Throwable -> L23
        L21:
            monitor-exit(r2)
            return
        L23:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.AB.A1C():void");
    }

    public final void A1D(Timeline timeline, int i, long j) {
        this.A0f.ACj(3, new C10166n(timeline, i, j)).A02();
    }

    public final /* synthetic */ void A1E(C10327d c10327d) {
        try {
            A0h(c10327d);
        } catch (AD e) {
            Log.e(A0D(0, 21, 22), A0D(298, 55, 119), e);
            throw new RuntimeException(e);
        }
    }

    public final void A1F(InterfaceC1163Cx interfaceC1163Cx, boolean z, boolean z2) {
        this.A0f.ACi(0, z ? 1 : 0, z2 ? 1 : 0, interfaceC1163Cx).A02();
    }

    public final void A1G(boolean z) {
        this.A0f.ACh(1, z ? 1 : 0, 0).A02();
    }

    public final void A1H(boolean z) {
        this.A0f.ACh(6, z ? 1 : 0, 0).A02();
    }

    @Override // com.facebook.ads.redexgen.core.C6P
    public final void AFI(C2704px c2704px) {
        this.A0a.obtainMessage(1, c2704px).sendToTarget();
        A0T(c2704px.A01);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2575nq
    public final void AFS(InterfaceC2574np interfaceC2574np) {
        this.A0f.ACj(9, interfaceC2574np).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1162Cw
    public final void AG1(InterfaceC1163Cx interfaceC1163Cx, Timeline timeline) {
        this.A0f.ACj(8, new C10136k(interfaceC1163Cx, timeline)).A02();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1213Ev
    public final void AGD() {
        this.A0f.AJA(11);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10307b
    public final synchronized void AJC(C10327d c10327d) {
        if (this.A0S) {
            Log.w(A0D(0, 21, 22), A0D(50, 37, 39));
            c10327d.A0A(false);
        } else {
            this.A0f.ACj(14, c10327d).A02();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) throws Throwable {
        String strA0D = A0D(0, 21, 22);
        try {
        } catch (AD e) {
            Log.e(strA0D, A0D(110, 15, 65), e);
            A12(false, false);
            this.A0a.obtainMessage(2, e).sendToTarget();
            A0H();
        } catch (IOException e2) {
            Log.e(strA0D, A0D(195, 13, 40), e2);
            A12(false, false);
            this.A0a.obtainMessage(2, AD.A01(e2, 2000)).sendToTarget();
            A0H();
        } catch (RuntimeException e3) {
            Log.e(strA0D, A0D(87, 23, 19), e3);
            A12(false, false);
            this.A0a.obtainMessage(2, AD.A02(e3)).sendToTarget();
            A0H();
        }
        switch (message.what) {
            case 0:
                A0r((InterfaceC1163Cx) message.obj, message.arg1 != 0, message.arg2 != 0);
                A0H();
                return true;
            case 1:
                A0z(message.arg1 != 0);
                A0H();
                return true;
            case 2:
                A0F();
                A0H();
                return true;
            case 3:
                A0f((C10166n) message.obj);
                A0H();
                return true;
            case 4:
                A0b((C2704px) message.obj);
                A0H();
                return true;
            case 5:
                A0n((C10497u) message.obj);
                A0H();
                return true;
            case 6:
                A12(message.arg1 != 0, true);
                A0H();
                return true;
            case 7:
                A0K();
                return true;
            case 8:
                A0e((C10136k) message.obj);
                A0H();
                return true;
            case 9:
                A0p((InterfaceC2574np) message.obj);
                A0H();
                return true;
            case 10:
                A0o((InterfaceC2574np) message.obj);
                A0H();
                return true;
            case 11:
                A0L();
                A0H();
                return true;
            case 12:
                A0U(message.arg1);
                A0H();
                return true;
            case 13:
                A11(message.arg1 != 0);
                A0H();
                return true;
            case 14:
                A0i((C10327d) message.obj);
                A0H();
                return true;
            case 15:
                A0k((C10327d) message.obj);
                A0H();
                return true;
            case 16:
                A0H();
                return true;
            case 17:
                A0d(null, false);
                throw null;
            case 18:
                A0c(null);
                throw null;
            case 19:
                A0u((String) message.obj);
                A0H();
                return true;
            default:
                return false;
        }
    }
}
