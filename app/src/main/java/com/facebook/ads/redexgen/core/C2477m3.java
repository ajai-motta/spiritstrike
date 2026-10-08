package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.ads.androidx.media3.common.Metadata;
import com.facebook.ads.androidx.media3.extractor.metadata.mp4.MotionPhotoMetadata;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.mp4.Sniffer;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.m3, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2477m3 implements H9, HY {
    public static byte[] A0Q;
    public static String[] A0R = {"uzhMW", "LbToze1ZyMStOzMPMggUyU89k761Fydj", "roznHbdGo", "zeOiwqyw9G80TO", "hwgMtT9WWej", "AZ5CtgA3jsgDmrh", "c4g75mNjYzBkznfgxB8HcDFPfSogi", "Prtl1ARtkjOsoD"};
    public static final HD A0S;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public int A05;
    public int A06;
    public int A07;
    public int A08;
    public long A09;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0A;
    public long A0B;

    @MetaExoPlayerCustomization(type = {"NEW_CLASS_ARG"}, value = "D54927862 get video/audio duration for progressive")
    public long A0C;
    public C09724v A0D;
    public HA A0E;
    public MotionPhotoMetadata A0F;
    public JE[] A0G;
    public long[][] A0H;
    public final int A0I;
    public final C09724v A0J;
    public final C09724v A0K;
    public final C09724v A0L;
    public final C09724v A0M;
    public final JL A0N;
    public final ArrayDeque<C2488mE> A0O;
    public final List<Metadata.Entry> A0P;

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 25 out of bounds for length 24
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A03(com.facebook.ads.redexgen.core.InterfaceC2516ms r22, com.facebook.ads.redexgen.core.HV r23) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2477m3.A03(com.facebook.ads.redexgen.X.ms, com.facebook.ads.redexgen.X.HV):int");
    }

    public static String A09(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0Q, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 83);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0C() {
        A0Q = new byte[]{-47, 4, -1, -3, -80, 3, -7, 10, -11, -80, -4, -11, 3, 3, -80, 4, -8, -15, -2, -80, -8, -11, -15, -12, -11, 2, -80, -4, -11, -2, -9, 4, -8, -80, -72, 5, -2, 3, 5, 0, 0, -1, 2, 4, -11, -12, -71, -66, Ascii.DC2, 55, 63, 42, 53, 50, 45, -23, Ascii.ETB, 10, Ascii.NAK, -23, 53, 46, 55, 48, Base64.padSymbol, 49, -8, Ascii.FF, -5, 0, 6, -58, -8, -6, -53, 49, 69, 52, 57, 63, -1, 68, 66, 69, 53, -3, 56, 52};
    }

    static {
        A0C();
        A0S = new HD() { // from class: com.facebook.ads.redexgen.X.m4
            @Override // com.facebook.ads.redexgen.core.HD
            public final H9[] A5N() {
                return C2477m3.A0M();
            }

            @Override // com.facebook.ads.redexgen.core.HD
            public final /* synthetic */ H9[] A5O(Uri uri, Map map) {
                return HC.A01(this, uri, map);
            }
        };
    }

    public C2477m3() {
        this(0);
    }

    public C2477m3(int i) {
        this.A0I = i;
        this.A04 = (i & 4) != 0 ? 3 : 0;
        this.A0N = new JL();
        this.A0P = new ArrayList();
        this.A0J = new C09724v(16);
        this.A0O = new ArrayDeque<>();
        this.A0L = new C09724v(HS.A03);
        this.A0K = new C09724v(4);
        this.A0M = new C09724v();
        this.A08 = -1;
        this.A0E = HA.A00;
        this.A0G = new JE[0];
    }

    public static int A00(int i) {
        switch (i) {
            case Sniffer.BRAND_HEIC /* 1751476579 */:
                return 2;
            case Sniffer.BRAND_QUICKTIME /* 1903435808 */:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[1] = "rbgKKZbH0NS3XFJda55b1nN6iCZjcLPR";
                return 1;
            default:
                if (A0R[6].length() != 29) {
                    throw new RuntimeException();
                }
                A0R[4] = "05jGjYjRxbz";
                return 0;
        }
    }

    private int A01(long j) {
        long j2 = Long.MAX_VALUE;
        int preferredTrackIndex = 1;
        int i = -1;
        long sampleOffset = Long.MAX_VALUE;
        long j3 = Long.MAX_VALUE;
        int i2 = 1;
        int trackIndex = -1;
        int i3 = 0;
        while (true) {
            JE[] jeArr = this.A0G;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            A0R[6] = "Fcko3uaud46cO6nUcug7HhLZFNYBY";
            if (i3 >= jeArr.length) {
                if (j3 == Long.MAX_VALUE || i2 == 0) {
                    return i;
                }
                long j4 = 10485760 + j3;
                if (A0R[1].charAt(1) == 'b') {
                    A0R[1] = "AbIM1W3wiFJMRqsWOI3P0CqvLybO2M00";
                    if (sampleOffset < j4) {
                        return i;
                    }
                } else if (sampleOffset < j4) {
                    return i;
                }
                return trackIndex;
            }
            JE je = this.A0G[i3];
            int i4 = je.A00;
            if (i4 != je.A04.A01) {
                long j5 = je.A04.A06[i4];
                long minAccumulatedBytes = ((long[][]) C5C.A0f(this.A0H))[i3][i4];
                long j6 = j5 - j;
                int i5 = (j6 < 0 || j6 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) ? 1 : 0;
                if ((i5 == 0 && preferredTrackIndex != 0) || (i5 == preferredTrackIndex && j6 < j2)) {
                    preferredTrackIndex = i5;
                    j2 = j6;
                    i = i3;
                    if (A0R[6].length() != 29) {
                        String[] strArr2 = A0R;
                        strArr2[5] = "nNk7RawiIyahd9Y";
                        strArr2[0] = "017pL";
                        sampleOffset = minAccumulatedBytes;
                    } else {
                        A0R[1] = "1bC0in6G1ApWSL3PegJBmoVzHl6EE3tw";
                        sampleOffset = minAccumulatedBytes;
                    }
                }
                if (minAccumulatedBytes < j3) {
                    j3 = minAccumulatedBytes;
                    i2 = i5;
                    trackIndex = i3;
                }
            }
            i3++;
        }
    }

    public static int A02(C09724v c09724v) {
        c09724v.A0f(8);
        int majorBrand = A00(c09724v.A0C());
        if (majorBrand != 0) {
            return majorBrand;
        }
        c09724v.A0g(4);
        while (c09724v.A07() > 0) {
            int majorBrand2 = A00(c09724v.A0C());
            if (majorBrand2 != 0) {
                return majorBrand2;
            }
        }
        return 0;
    }

    private int A04(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        int iA07 = this.A0N.A07(interfaceC2516ms, hv, this.A0P);
        if (iA07 == 1 && hv.A00 == 0) {
            A0A();
        }
        return iA07;
    }

    public static int A05(JR jr, long j) {
        int iA00 = jr.A00(j);
        if (iA00 == -1) {
            return jr.A01(j);
        }
        return iA00;
    }

    public static long A06(JR jr, long j, long j2) {
        int iA05 = A05(jr, j);
        if (iA05 == -1) {
            return j2;
        }
        return Math.min(jr.A06[iA05], j2);
    }

    private final HX A07(long j, int i) {
        long jA06;
        long j2;
        int mainTrackIndex;
        if (this.A0G.length == 0) {
            return new HX(HZ.A04);
        }
        long j3 = C.TIME_UNSET;
        long jA062 = -1;
        int i2 = i != -1 ? i : this.A03;
        if (i2 != -1) {
            JR jr = this.A0G[i2].A04;
            int iA05 = A05(jr, j);
            if (iA05 == -1) {
                return new HX(HZ.A04);
            }
            j2 = jr.A07[iA05];
            jA06 = jr.A06[iA05];
            if (A0R[6].length() != 29) {
                throw new RuntimeException();
            }
            A0R[1] = "zbT5rN6sguJCvWwII8HLCHwSkH7sQNQT";
            if (j2 < j && iA05 < jr.A01 - 1 && (mainTrackIndex = jr.A01(j)) != -1 && mainTrackIndex != iA05) {
                j3 = jr.A07[mainTrackIndex];
                jA062 = jr.A06[mainTrackIndex];
            }
        } else {
            jA06 = Long.MAX_VALUE;
            if (A0R[4].length() != 11) {
                j2 = j;
            } else {
                A0R[2] = "SenK5aC";
                j2 = j;
            }
        }
        if (i == -1) {
            for (int i3 = 0; i3 < this.A0G.length; i3++) {
                if (i3 != this.A03) {
                    JR sampleTable = this.A0G[i3].A04;
                    jA06 = A06(sampleTable, j2, jA06);
                    if (j3 != C.TIME_UNSET) {
                        jA062 = A06(sampleTable, j3, jA062);
                    }
                }
            }
        }
        HZ hz = new HZ(j2, jA06);
        if (j3 == C.TIME_UNSET) {
            return new HX(hz);
        }
        return new HX(hz, new HZ(j3, jA062));
    }

    public static /* synthetic */ JO A08(JO jo) {
        return jo;
    }

    private void A0A() {
        this.A04 = 0;
        this.A00 = 0;
    }

    private void A0B() {
        if (this.A02 == 2 && (this.A0I & 2) != 0) {
            this.A0E.AKS(0, 4).A6e(new C09162p().A0v(this.A0F == null ? null : new Metadata(this.A0F)).A14());
            this.A0E.A6O();
            this.A0E.AJ7(new C2511mn(C.TIME_UNSET));
        }
    }

    private void A0D(long j) throws C3K {
        while (!this.A0O.isEmpty() && this.A0O.peek().A00 == j) {
            C2488mE c2488mEPop = this.A0O.pop();
            if (((AbstractC1314Iu) c2488mEPop).A00 == 1836019574) {
                A0G(c2488mEPop);
                this.A0O.clear();
                this.A04 = 2;
            } else if (!this.A0O.isEmpty()) {
                C2488mE containerAtom = this.A0O.peek();
                containerAtom.A08(c2488mEPop);
            }
        }
        if (this.A04 != 2) {
            A0A();
        }
    }

    private void A0E(long j) {
        if (this.A01 == 1836086884) {
            this.A0F = new MotionPhotoMetadata(0L, j, C.TIME_UNSET, j + ((long) this.A00), this.A09 - ((long) this.A00));
        }
    }

    private void A0F(InterfaceC2516ms interfaceC2516ms) throws IOException {
        this.A0M.A0d(8);
        interfaceC2516ms.AGt(this.A0M.A0l(), 0, 8);
        J0.A0Q(this.A0M);
        interfaceC2516ms.AK3(this.A0M.A09());
        interfaceC2516ms.AIl();
    }

    /* JADX WARN: Incorrect condition in loop: B:58:0x0138 */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization(type = {"FEATURE_LOGIC"}, value = "Adding average bitrate calculation logic")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0G(com.facebook.ads.redexgen.core.C2488mE r36) throws com.facebook.ads.redexgen.core.C3K {
        /*
            Method dump skipped, instruction units count: 462
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2477m3.A0G(com.facebook.ads.redexgen.X.mE):void");
    }

    private void A0H(JE je, long j) {
        JR jr = je.A04;
        int sampleIndex = jr.A00(j);
        if (sampleIndex == -1) {
            sampleIndex = jr.A01(j);
        }
        je.A00 = sampleIndex;
        if (A0R[2].length() == 19) {
            throw new RuntimeException();
        }
        A0R[2] = "DxqZc2lJMNLNZhW19Xb8kO";
    }

    public static boolean A0I(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1701082227 || i == 1835365473;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean A0J(int r4) {
        /*
            r0 = 1835296868(0x6d646864, float:4.418049E27)
            if (r4 == r0) goto L8d
            r0 = 1836476516(0x6d766864, float:4.7662196E27)
            if (r4 == r0) goto L8d
            r3 = 1751411826(0x68646c72, float:4.3148E24)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2477m3.A0R
            r0 = 4
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 11
            if (r1 == r0) goto L20
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L20:
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2477m3.A0R
            java.lang.String r1 = "UHuXZ9PGVGxrhu"
            r0 = 3
            r2[r0] = r1
            java.lang.String r1 = "Sv1JTBT1egKeuo"
            r0 = 7
            r2[r0] = r1
            if (r4 == r3) goto L8d
            r0 = 1937011556(0x73747364, float:1.9367383E31)
            if (r4 == r0) goto L8d
            r0 = 1937011827(0x73747473, float:1.9367711E31)
            if (r4 == r0) goto L8d
            r0 = 1937011571(0x73747373, float:1.9367401E31)
            if (r4 == r0) goto L8d
            r0 = 1668576371(0x63747473, float:4.5093966E21)
            if (r4 == r0) goto L8d
            r0 = 1701606260(0x656c7374, float:6.9788014E22)
            if (r4 == r0) goto L8d
            r0 = 1937011555(0x73747363, float:1.9367382E31)
            if (r4 == r0) goto L8d
            r0 = 1937011578(0x7374737a, float:1.936741E31)
            if (r4 == r0) goto L8d
            r0 = 1937013298(0x73747a32, float:1.9369489E31)
            if (r4 == r0) goto L8d
            r3 = 1937007471(0x7374636f, float:1.9362445E31)
            java.lang.String[] r1 = com.facebook.ads.redexgen.core.C2477m3.A0R
            r0 = 2
            r0 = r1[r0]
            int r1 = r0.length()
            r0 = 19
            if (r1 == r0) goto L91
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2477m3.A0R
            java.lang.String r1 = "0EWWhWMRQ7MgS85x4CKboIorprSqD"
            r0 = 6
            r2[r0] = r1
            if (r4 == r3) goto L8d
        L6f:
            r0 = 1668232756(0x636f3634, float:4.4126776E21)
            if (r4 == r0) goto L8d
            r0 = 1953196132(0x746b6864, float:7.46037E31)
            if (r4 == r0) goto L8d
            r0 = 1718909296(0x66747970, float:2.8862439E23)
            if (r4 == r0) goto L8d
            r0 = 1969517665(0x75647461, float:2.8960062E32)
            if (r4 == r0) goto L8d
            r0 = 1801812339(0x6b657973, float:2.7741754E26)
            if (r4 == r0) goto L8d
            r0 = 1768715124(0x696c7374, float:1.7865732E25)
            if (r4 != r0) goto L8f
        L8d:
            r0 = 1
        L8e:
            return r0
        L8f:
            r0 = 0
            goto L8e
        L91:
            if (r4 == r3) goto L8d
            goto L6f
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2477m3.A0J(int):boolean");
    }

    private boolean A0K(InterfaceC2516ms interfaceC2516ms) throws IOException {
        C2488mE containerAtom;
        if (this.A00 == 0) {
            if (!interfaceC2516ms.AHR(this.A0J.A0l(), 0, 8, true)) {
                A0B();
                return false;
            }
            this.A00 = 8;
            this.A0J.A0f(0);
            this.A09 = this.A0J.A0Q();
            this.A01 = this.A0J.A0C();
        }
        if (this.A09 == 1) {
            if (A0R[2].length() == 19) {
                throw new RuntimeException();
            }
            A0R[2] = "uEfPCG8cZZkUCN4sq";
            interfaceC2516ms.readFully(this.A0J.A0l(), 8, 8);
            int headerBytesRemaining = this.A00;
            this.A00 = headerBytesRemaining + 8;
            this.A09 = this.A0J.A0R();
        } else if (this.A09 == 0) {
            long jA8O = interfaceC2516ms.A8O();
            if (jA8O == -1 && (containerAtom = this.A0O.peek()) != null) {
                jA8O = containerAtom.A00;
            }
            if (jA8O != -1) {
                this.A09 = (jA8O - interfaceC2516ms.A8n()) + ((long) this.A00);
            }
        }
        if (this.A09 >= this.A00) {
            if (A0I(this.A01)) {
                long jA8n = (interfaceC2516ms.A8n() + this.A09) - ((long) this.A00);
                if (this.A09 != this.A00 && this.A01 == 1835365473) {
                    A0F(interfaceC2516ms);
                }
                this.A0O.push(new C2488mE(this.A01, jA8n));
                if (this.A09 == this.A00) {
                    A0D(jA8n);
                } else {
                    A0A();
                }
            } else if (A0J(this.A01)) {
                AbstractC09493y.A08(this.A00 == 8);
                AbstractC09493y.A08(this.A09 <= 2147483647L);
                C09724v c09724v = new C09724v((int) this.A09);
                C09724v atomData = this.A0J;
                System.arraycopy(atomData.A0l(), 0, c09724v.A0l(), 0, 8);
                this.A0D = c09724v;
                this.A04 = 1;
            } else {
                A0E(interfaceC2516ms.A8n() - ((long) this.A00));
                this.A0D = null;
                this.A04 = 1;
            }
            return true;
        }
        throw C3K.A00(A09(0, 48, 61));
    }

    private boolean A0L(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        long j = this.A09 - ((long) this.A00);
        long atomEndPosition = interfaceC2516ms.A8n() + j;
        boolean z = false;
        C09724v c09724v = this.A0D;
        if (c09724v != null) {
            interfaceC2516ms.readFully(c09724v.A0l(), this.A00, (int) j);
            if (this.A01 == 1718909296) {
                this.A02 = A02(c09724v);
            } else if (!this.A0O.isEmpty()) {
                this.A0O.peek().A09(new C2487mD(this.A01, c09724v));
            }
        } else if (j < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            interfaceC2516ms.AK3((int) j);
        } else {
            long atomPayloadSize = interfaceC2516ms.A8n();
            hv.A00 = atomPayloadSize + j;
            z = true;
        }
        A0D(atomEndPosition);
        return z && this.A04 != 2;
    }

    public static /* synthetic */ H9[] A0M() {
        return new H9[]{new C2477m3()};
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long[][] A0N(com.facebook.ads.redexgen.core.JE[] r16) {
        /*
            Method dump skipped, instruction units count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2477m3.A0N(com.facebook.ads.redexgen.X.JE[]):long[][]");
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final long A7t() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final HX A91(long j) {
        return A07(j, -1);
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AAC(HA ha) {
        this.A0E = ha;
    }

    @Override // com.facebook.ads.redexgen.core.HY
    public final boolean AAj() {
        return true;
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final int AHL(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        while (true) {
            switch (this.A04) {
                case 0:
                    if (!A0K(interfaceC2516ms)) {
                        return -1;
                    }
                    break;
                    break;
                case 1:
                    if (A0L(interfaceC2516ms, hv)) {
                        return 1;
                    }
                    break;
                case 2:
                    return A03(interfaceC2516ms, hv);
                case 3:
                    return A04(interfaceC2516ms, hv);
                default:
                    throw new IllegalStateException();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AHb() {
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final void AJ6(long j, long j2) {
        this.A0O.clear();
        this.A00 = 0;
        this.A08 = -1;
        this.A05 = 0;
        this.A06 = 0;
        this.A07 = 0;
        if (j == 0) {
            int i = this.A04;
            String[] strArr = A0R;
            if (strArr[3].length() != strArr[7].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0R;
            strArr2[3] = "BBO5nGzNDCjhdG";
            strArr2[7] = "Qq9RZt6cBQ724Z";
            if (i != 3) {
                A0A();
                return;
            } else {
                this.A0N.A08();
                this.A0P.clear();
                return;
            }
        }
        for (JE je : this.A0G) {
            A0H(je, j2);
            if (je.A02 != null) {
                je.A02.A02();
            }
        }
    }

    @Override // com.facebook.ads.redexgen.core.H9
    public final boolean AK5(InterfaceC2516ms interfaceC2516ms) throws IOException {
        return JM.A02(interfaceC2516ms, (this.A0I & 2) != 0);
    }
}
