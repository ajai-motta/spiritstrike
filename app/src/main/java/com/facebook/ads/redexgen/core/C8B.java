package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.util.Log;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlin.io.encoding.Base64;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8B, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C8B implements InterfaceC2661pF {
    public static byte[] A0M;
    public static String[] A0N = {"gtbAICrdQ5OiLd8QtlGJkysA4GOuQAyl", "NB4BeTTq5ijHDPStUBIG2cd4hjVw3Rms", "uuMr3aWTfRr6VJnGuPPVK2CIrmsp3XMP", "Eb6am5ksZvZ5Hz0HFQHbX0NWivmHdCO7", "qnDH", "QayiUw4ouBPhcoxDO7fR8OixzHh3DuJf", "V84YazX1IDZHbq2m95FMlzDl0u9g04ST", "S22pIk311xlkEmMZRooVtOw4dNPxaWRF"};
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public Uri A05;
    public InterfaceC2661pF A06;
    public C09855i A07;
    public C09855i A08;

    @MetaExoPlayerCustomization
    public ML A09;
    public MZ A0A;
    public boolean A0B;
    public boolean A0C;
    public final InterfaceC2661pF A0D;
    public final InterfaceC2661pF A0E;
    public final InterfaceC2661pF A0F;
    public final MP A0G;
    public final MS A0H;
    public final MY A0I;
    public final boolean A0J;
    public final boolean A0K;
    public final boolean A0L;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0M, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A0N[4].length() == 12) {
                throw new RuntimeException();
            }
            A0N[4] = "VXYuEglycDYgl";
            bArrCopyOfRange[i4] = (byte) ((b ^ i3) ^ 28);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A0M = new byte[]{Ascii.EM, 59, 57, 50, 63, Ascii.RS, 59, 46, 59, 9, 53, 47, 40, 57, 63, Ascii.SYN, 58, 32, 57, 49, 59, 114, 33, 117, 32, 37, 49, 52, 33, 48, 117, 39, 48, 49, 60, 39, 48, 54, 33, 48, 49, 117, 0, 7, Ascii.FS, 123, 117, 1, Base64.padSymbol, 60, 38, 117, 56, 60, 50, Base64.padSymbol, 33, 117, 54, 52, 32, 38, 48, 117, 39, 48, 57, 52, 33, 60, 35, 48, 117, 0, 7, Ascii.FS, 38, 117, 50, 48, 33, 117, 39, 48, 38, 58, 57, 35, 48, 49, 117, 60, 59, 54, 58, 39, 39, 48, 54, 33, 57, 44, 123, 95, 94, 115, 81, 83, 88, 85, 84, 114, 73, 68, 85, 67, 98, 85, 81, 84};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 15 out of bounds for length 13
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.restartVar(DebugInfoParser.java:193)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:141)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    @MetaExoPlayerCustomization("usage of fbDataSpecExtension and the check for isInitSegment")
    public final long AGi(C09855i c09855i) throws IOException {
        try {
            String strA4l = this.A0I.A4l(c09855i);
            C09855i c09855iA09 = c09855i.A04().A08(strA4l).A09();
            this.A08 = c09855iA09;
            this.A05 = A01(this.A0G, strA4l, c09855iA09.A06);
            this.A03 = c09855i.A04;
            this.A09 = new ML(c09855i.A07);
            this.A0B = A00(c09855i) != -1;
            boolean z = this.A0B;
            if (this.A0B) {
                this.A00 = -1L;
            } else {
                this.A00 = AbstractC1407Mj.A00(this.A0G.A7S(strA4l));
                if (this.A00 != -1) {
                    this.A00 -= c09855i.A04;
                    if (this.A00 < 0) {
                        throw new C09785b(2008);
                    }
                }
            }
            boolean z2 = c09855i.A07.A08 <= 0 && c09855i.A07.A07 <= 0;
            if (c09855i.A03 != -1) {
                this.A00 = this.A00 == -1 ? c09855i.A03 : Math.min(this.A00, c09855i.A03);
            }
            if (this.A00 > 0 || this.A00 == -1) {
                A06(c09855iA09, false, z2);
            }
            return c09855i.A03 != -1 ? c09855i.A03 : this.A00;
        } catch (Throwable th) {
            A09(th);
            throw th;
        }
    }

    static {
        A05();
    }

    public C8B(MP mp, InterfaceC2661pF interfaceC2661pF, InterfaceC2661pF interfaceC2661pF2, C5W c5w, MY my, int i, AbstractC09303d abstractC09303d, int i2, MS ms) {
        this.A0G = mp;
        this.A0D = interfaceC2661pF2;
        this.A0I = my == null ? MY.A00 : my;
        this.A0J = (i & 1) != 0;
        this.A0L = (i & 2) != 0;
        this.A0K = (i & 4) != 0;
        if (interfaceC2661pF != null) {
            interfaceC2661pF = abstractC09303d != null ? new AH(interfaceC2661pF, abstractC09303d, i2) : interfaceC2661pF;
            this.A0F = interfaceC2661pF;
            this.A0E = c5w != null ? new AF(interfaceC2661pF, c5w) : null;
        } else {
            this.A0F = AI.A02;
            this.A0E = null;
        }
        this.A0H = ms;
    }

    private int A00(C09855i c09855i) {
        if (this.A0L && this.A0C) {
            return 0;
        }
        if (this.A0K && c09855i.A03 == -1) {
            return 1;
        }
        return -1;
    }

    public static Uri A01(MP mp, String str, Uri redirectedUri) {
        Uri redirectedUri2 = AbstractC1407Mj.A01(mp.A7S(str));
        return redirectedUri2 != null ? redirectedUri2 : redirectedUri;
    }

    private void A03() throws IOException {
        if (this.A06 == null) {
            return;
        }
        try {
            this.A06.close();
            this.A07 = null;
            this.A06 = null;
            if (A0N[5].charAt(3) == 'i') {
                String[] strArr = A0N;
                strArr[2] = "vHGwoIowQcJHPzt2zHibHrQYTuNv4ZzT";
                strArr[1] = "k7MJrtNgTHKuOTKhmFADSg5K1rHaIFar";
                if (this.A0A != null) {
                    MP mp = this.A0G;
                    if (A0N[6].charAt(29) == '4') {
                        String[] strArr2 = A0N;
                        strArr2[2] = "npCyc8crYVBLSlKGvChDlZdzdxvHOR7S";
                        strArr2[1] = "yWpl1AKn1flVHx0rOJ2JJIdMQnxjFkRn";
                        mp.AHg(this.A0A);
                        this.A0A = null;
                        return;
                    }
                } else {
                    return;
                }
            }
            throw new RuntimeException();
        } catch (Throwable th) {
            this.A07 = null;
            this.A06 = null;
            if (this.A0A != null) {
                this.A0G.AHg(this.A0A);
                this.A0A = null;
            }
            throw th;
        }
    }

    private void A04() {
        if (0 != 0 && this.A04 > 0) {
            this.A0G.A7A();
            throw new NullPointerException(A02(103, 17, 44));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cb  */
    @com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization("Parameter isInitSegment and all ot is usages. Setting mFbDataSpecExtension in nextDataSpec. Call to maybeUpdateRedirectedUriMetadata at the end")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A06(com.facebook.ads.redexgen.core.C09855i r22, boolean r23, boolean r24) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 555
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C8B.A06(com.facebook.ads.redexgen.X.5i, boolean, boolean):void");
    }

    private void A07(String str) throws IOException {
        this.A00 = 0L;
        if (A0D()) {
            C1409Ml c1409Ml = new C1409Ml();
            C1409Ml.A00(c1409Ml, this.A03);
            this.A0G.A4E(str, c1409Ml);
        }
    }

    @MetaExoPlayerCustomization
    private void A08(String str, Uri uri) {
        if (!A0D()) {
            return;
        }
        C1409Ml c1409Ml = new C1409Ml();
        if (!uri.equals(this.A05)) {
            Uri uri2 = this.A05;
            if (A0N[6].charAt(29) != '4') {
                throw new RuntimeException();
            }
            String[] strArr = A0N;
            strArr[0] = "HwBuIJEC6JIKumxqgSDJ0pUKIwQFYzQv";
            strArr[7] = "1FgFIXgVQckXZ73NbznNhujKeCbi6Slt";
            C1409Ml.A01(c1409Ml, uri2);
        } else {
            C1409Ml.A01(c1409Ml, null);
        }
        try {
            this.A0G.A4E(str, c1409Ml);
        } catch (MM e) {
            String message = A02(15, 88, 73);
            Log.w(A02(0, 15, 70), message, e);
        }
    }

    private void A09(Throwable th) {
        if (A0B() || (th instanceof MM)) {
            this.A0C = true;
        }
    }

    private boolean A0A() {
        return this.A06 == this.A0F;
    }

    private boolean A0B() {
        return this.A06 == this.A0D;
    }

    private boolean A0C() {
        return !A0B();
    }

    private boolean A0D() {
        return this.A06 == this.A0E;
    }

    public final MP A0E() {
        return this.A0G;
    }

    public final MY A0F() {
        return this.A0I;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final void A43(InterfaceC09965t interfaceC09965t) {
        AbstractC09493y.A01(interfaceC09965t);
        this.A0D.A43(interfaceC09965t);
        this.A0F.A43(interfaceC09965t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final Map<String, List<String>> A8t() {
        if (A0C()) {
            return this.A0F.A8t();
        }
        return Collections.emptyMap();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final Uri A9P() {
        return this.A05;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final void close() throws IOException {
        this.A08 = null;
        this.A05 = null;
        this.A03 = 0L;
        A04();
        try {
            A03();
        } catch (Throwable e) {
            A09(e);
            throw e;
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09052c
    public final int read(byte[] bArr, int i, int i2) throws Throwable {
        if (i2 == 0) {
            return 0;
        }
        if (this.A00 == 0) {
            return -1;
        }
        C09855i currentDataSpec = (C09855i) AbstractC09493y.A01(this.A08);
        C09855i c09855i = (C09855i) AbstractC09493y.A01(this.A07);
        try {
            if (this.A03 >= this.A01) {
                A06(currentDataSpec, true, false);
            }
        } catch (Throwable th) {
            e = th;
        }
        try {
            int bytesRead = ((InterfaceC2661pF) AbstractC09493y.A01(this.A06)).read(bArr, i, i2);
            if (bytesRead != -1) {
                if (A0B()) {
                    this.A04 += (long) bytesRead;
                }
                this.A03 += (long) bytesRead;
                this.A02 += (long) bytesRead;
                if (this.A00 != -1) {
                    this.A00 -= (long) bytesRead;
                }
            } else if (A0C() && (c09855i.A03 == -1 || this.A02 < c09855i.A03)) {
                A07((String) C5C.A0f(currentDataSpec.A08));
            } else if (this.A00 > 0 || this.A00 == -1) {
                A03();
                A06(currentDataSpec, false, false);
                return read(bArr, i, i2);
            }
            return bytesRead;
        } catch (Throwable th2) {
            e = th2;
            A09(e);
            throw e;
        }
    }
}
