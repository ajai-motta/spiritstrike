package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.facebook.ads.androidx.media3.exoplayer.offline.Download;
import com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2 extends Handler {
    public static byte[] A0D;
    public static String[] A0E = {"iNmXvBj9FTihCrbZiC4S7zhCL1s9H33W", "EvGedAo1NbwIZrU2eJLjABwCKULHNO", "OhLMnivBPD1ct3YE1XOZQ5ppblACA0SV", "Bbpc8NZfeBPLrlsLcOoRpsaFZoo07Ukk", "cYMMpvUaIb0CtoOD5hU2j4Ih7c76pz", "QlCwnx", "3GDIv0eUOBpBneHy6OJWPXV1MBWevv42", "cGd21R9dzjO1"};
    public boolean A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public boolean A05;
    public boolean A06;
    public final Handler A07;
    public final HandlerThread A08;
    public final CJ A09;
    public final InterfaceC2581nw A0A;
    public final ArrayList<C1127Bk> A0B;
    public final HashMap<String, C2585o0> A0C;

    public static String A08(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 73);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0D() {
        A0D = new byte[]{-42, -54, -9, 34, 42, 33, Ascii.US, 34, Ascii.DC4, Ascii.ETB, 0, Ascii.DC4, 33, Ascii.DC4, Ascii.SUB, Ascii.CAN, 37, -61, -34, -26, -23, -30, -31, -99, -15, -20, -99, -23, -20, -34, -31, -99, -31, -20, -12, -21, -23, -20, -34, -31, -73, -99, -109, -82, -74, -71, -78, -79, 109, -63, -68, 109, -71, -68, -82, -79, 109, -79, -68, -60, -69, -71, -68, -82, -79, -64, 123, -99, -72, -64, -61, -68, -69, 119, -53, -58, 119, -61, -58, -72, -69, 119, -64, -59, -69, -68, -49, -123, -87, -60, -52, -49, -56, -57, -125, -41, -46, -125, -43, -56, -48, -46, -39, -56, -125, -55, -43, -46, -48, -125, -57, -60, -41, -60, -59, -60, -42, -56, -109, -82, -74, -71, -78, -79, 109, -63, -68, 109, -65, -78, -70, -68, -61, -78, 109, -69, -68, -69, -78, -59, -74, -64, -63, -78, -69, -63, 109, -79, -68, -60, -69, -71, -68, -82, -79, -121, 109, -12, Ascii.SI, Ascii.ETB, Ascii.SUB, 19, Ascii.DC2, -50, 34, Ascii.GS, -50, 33, 19, 34, -50, Ascii.ESC, Ascii.SI, Ascii.FS, 35, Ascii.SI, Ascii.SUB, -50, 33, 34, Ascii.GS, Ascii.RS, -50, 32, 19, Ascii.SI, 33, Ascii.GS, Ascii.FS, -113, -86, -78, -75, -82, -83, 105, -67, -72, 105, -68, -82, -67, 105, -74, -86, -73, -66, -86, -75, 105, -68, -67, -72, -71, 105, -69, -82, -86, -68, -72, -73, -125, 105, -67, -40, -32, -29, -36, -37, -105, -21, -26, -105, -20, -25, -37, -40, -21, -36, -105, -32, -27, -37, -36, -17, -91, -13, 0, Ascii.DC2, 10, -65, 5, 0, 8, Ascii.VT, 4, 3, -39, -65};
    }

    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException: Index 17 out of bounds for length 17
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.startVar(DebugInfoParser.java:203)
    	at jadx.plugins.input.dex.sections.debuginfo.DebugInfoParser.process(DebugInfoParser.java:125)
    	at jadx.plugins.input.dex.sections.DexCodeReader.getDebugInfo(DexCodeReader.java:122)
    	at jadx.core.dex.nodes.MethodNode.getDebugInfo(MethodNode.java:645)
    	at jadx.core.dex.visitors.debuginfo.DebugInfoAttachVisitor.visit(DebugInfoAttachVisitor.java:38)
     */
    private void A0Q(DownloadRequest downloadRequest, int i) {
        C1127Bk c1127BkA06 = A06(downloadRequest.A02, true);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (c1127BkA06 != null) {
            A03(C5.A00(c1127BkA06, downloadRequest, i, jCurrentTimeMillis));
        } else {
            A03(new C1127Bk(downloadRequest, i != 0 ? 1 : 0, jCurrentTimeMillis, jCurrentTimeMillis, -1L, i, 0));
        }
        A0B();
    }

    static {
        A0D();
    }

    public C2(HandlerThread handlerThread, InterfaceC2581nw interfaceC2581nw, CJ cj, Handler handler, int i, int i2, boolean z) {
        super(handlerThread.getLooper());
        this.A08 = handlerThread;
        this.A0A = interfaceC2581nw;
        this.A09 = cj;
        this.A07 = handler;
        this.A02 = i;
        this.A03 = i2;
        this.A05 = z;
        this.A0B = new ArrayList<>();
        this.A0C = new HashMap<>();
    }

    public static int A00(C1127Bk c1127Bk, C1127Bk c1127Bk2) {
        return C5C.A08(c1127Bk.A05, c1127Bk2.A05);
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int A02(java.lang.String r6) {
        /*
            r5 = this;
            r4 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r5.A0B
            int r0 = r0.size()
            if (r4 >= r0) goto L3e
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r5.A0B
            java.lang.Object r0 = r0.get(r4)
            com.facebook.ads.redexgen.X.Bk r0 = (com.facebook.ads.redexgen.core.C1127Bk) r0
            com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest r3 = r0.A07
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2.A0E
            r0 = 4
            r1 = r2[r0]
            r0 = 2
            r0 = r2[r0]
            int r1 = r1.length()
            int r0 = r0.length()
            if (r1 == r0) goto L38
            java.lang.String[] r2 = com.facebook.ads.redexgen.core.C2.A0E
            java.lang.String r1 = "id4WW5MNYn317aHfBDbhwYGK6MIHb4Bm"
            r0 = 6
            r2[r0] = r1
            java.lang.String r0 = r3.A02
            boolean r0 = r0.equals(r6)
            if (r0 == 0) goto L35
            return r4
        L35:
            int r4 = r4 + 1
            goto L1
        L38:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L3e:
            r0 = -1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2.A02(java.lang.String):int");
    }

    private C1127Bk A03(C1127Bk c1127Bk) {
        AbstractC09493y.A08((c1127Bk.A02 == 3 || c1127Bk.A02 == 4) ? false : true);
        int iA02 = A02(c1127Bk.A07.A02);
        if (iA02 == -1) {
            this.A0B.add(c1127Bk);
            Collections.sort(this.A0B, new C1());
        } else {
            boolean z = c1127Bk.A05 != this.A0B.get(iA02).A05;
            this.A0B.set(iA02, c1127Bk);
            if (z) {
                Collections.sort(this.A0B, new C1());
            }
        }
        try {
            this.A0A.AHF(c1127Bk);
        } catch (IOException e) {
            AbstractC09574g.A08(A08(2, 15, 106), A08(223, 23, 46), e);
        }
        this.A07.obtainMessage(2, new C0(c1127Bk, false, new ArrayList(this.A0B), null)).sendToTarget();
        return c1127Bk;
    }

    private C1127Bk A04(C1127Bk c1127Bk, int i, int i2) {
        AbstractC09493y.A08((i == 3 || i == 4) ? false : true);
        return A03(A05(c1127Bk, i, i2));
    }

    public static C1127Bk A05(C1127Bk c1127Bk, int i, int i2) {
        return new C1127Bk(c1127Bk.A07, i, c1127Bk.A05, System.currentTimeMillis(), c1127Bk.A04, i2, 0, c1127Bk.A00);
    }

    private C1127Bk A06(String str, boolean z) {
        int iA02 = A02(str);
        if (iA02 != -1) {
            return this.A0B.get(iA02);
        }
        if (z) {
            try {
                return this.A0A.A7q(str);
            } catch (IOException e) {
                AbstractC09574g.A08(A08(2, 15, 106), A08(17, 25, 52) + str, e);
                return null;
            }
        }
        return null;
    }

    private C2585o0 A07(C2585o0 c2585o0, C1127Bk c1127Bk) {
        if (c2585o0 == null) {
            if (A0U() && this.A01 < this.A02) {
                C1127Bk c1127BkA04 = A04(c1127Bk, 2, 0);
                C2585o0 c2585o02 = new C2585o0(c1127BkA04.A07, this.A09.A5M(c1127BkA04.A07), c1127BkA04.A00, false, this.A03, this);
                this.A0C.put(c1127BkA04.A07.A02, c2585o02);
                int i = this.A01;
                this.A01 = i + 1;
                if (i == 0) {
                    sendEmptyMessageDelayed(11, 5000L);
                }
                c2585o02.start();
                return c2585o02;
            }
            return null;
        }
        AbstractC09493y.A08(!c2585o0.A06);
        c2585o0.A05(false);
        return c2585o0;
    }

    private void A09() {
        Iterator<C2585o0> it = this.A0C.values().iterator();
        while (it.hasNext()) {
            it.next().A05(true);
        }
        try {
            this.A0A.AJO();
        } catch (IOException e) {
            AbstractC09574g.A08(A08(2, 15, 106), A08(223, 23, 46), e);
        }
        this.A0B.clear();
        this.A08.quit();
        synchronized (this) {
            this.A00 = true;
            notifyAll();
        }
    }

    private void A0A() {
        String strA08 = A08(2, 15, 106);
        ArrayList arrayList = new ArrayList();
        try {
            C2588o4 c2588o4A7r = this.A0A.A7r(3, 4);
            while (c2588o4A7r.A01()) {
                try {
                    arrayList.add(c2588o4A7r.A00());
                } finally {
                }
            }
            if (c2588o4A7r != null) {
                c2588o4A7r.close();
            }
        } catch (IOException unused) {
            AbstractC09574g.A05(strA08, A08(42, 25, 4));
        }
        for (int i = 0; i < this.A0B.size(); i++) {
            this.A0B.set(i, A05(this.A0B.get(i), 5, 0));
        }
        int i2 = 0;
        while (true) {
            int size = arrayList.size();
            if (A0E[6].charAt(14) != 'H') {
                break;
            }
            String[] strArr = A0E;
            strArr[1] = "XqOejHHacjjZLx98zpLnY1LZJhfsrk";
            strArr[7] = "zG4BgrMO4aUj";
            if (i2 < size) {
                ArrayList<C1127Bk> arrayList2 = this.A0B;
                C1127Bk c1127Bk = (C1127Bk) arrayList.get(i2);
                String[] strArr2 = A0E;
                if (strArr2[4].length() == strArr2[2].length()) {
                    break;
                }
                A0E[3] = "KT3y83B5rUupwCjllTydcOADIPFLf4ae";
                arrayList2.add(A05(c1127Bk, 5, 0));
                i2++;
            } else {
                List<Download> terminalDownloads = this.A0B;
                Collections.sort(terminalDownloads, new C1());
                try {
                    this.A0A.AJp();
                } catch (IOException e) {
                    AbstractC09574g.A08(strA08, A08(223, 23, 46), e);
                }
                ArrayList arrayList3 = new ArrayList(this.A0B);
                for (int i3 = 0; i3 < this.A0B.size(); i3++) {
                    this.A07.obtainMessage(2, new C0(this.A0B.get(i3), false, arrayList3, null)).sendToTarget();
                }
                A0B();
                return;
            }
        }
        throw new RuntimeException();
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0008 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0B() {
        /*
            r5 = this;
            r4 = 0
            r3 = 0
        L2:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r5.A0B
            int r0 = r0.size()
            if (r3 >= r0) goto L49
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r5.A0B
            java.lang.Object r2 = r0.get(r3)
            com.facebook.ads.redexgen.X.Bk r2 = (com.facebook.ads.redexgen.core.C1127Bk) r2
            java.util.HashMap<java.lang.String, com.facebook.ads.redexgen.X.o0> r1 = r5.A0C
            com.facebook.ads.androidx.media3.exoplayer.offline.DownloadRequest r0 = r2.A07
            java.lang.String r0 = r0.A02
            java.lang.Object r1 = r1.get(r0)
            com.facebook.ads.redexgen.X.o0 r1 = (com.facebook.ads.redexgen.core.C2585o0) r1
            int r0 = r2.A02
            switch(r0) {
                case 0: goto L38;
                case 1: goto L34;
                case 2: goto L2d;
                case 3: goto L23;
                case 4: goto L23;
                case 5: goto L29;
                case 6: goto L23;
                case 7: goto L29;
                default: goto L23;
            }
        L23:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r0.<init>()
            throw r0
        L29:
            r5.A0O(r1, r2)
            goto L3c
        L2d:
            com.facebook.ads.redexgen.core.AbstractC09493y.A01(r1)
            r5.A0P(r1, r2, r4)
            goto L3c
        L34:
            r5.A0M(r1)
            goto L3c
        L38:
            com.facebook.ads.redexgen.X.o0 r1 = r5.A07(r1, r2)
        L3c:
            if (r1 == 0) goto L46
            boolean r0 = com.facebook.ads.redexgen.core.C2585o0.A03(r1)
            if (r0 != 0) goto L46
            int r4 = r4 + 1
        L46:
            int r3 = r3 + 1
            goto L2
        L49:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2.A0B():void");
    }

    /* JADX WARN: Incorrect condition in loop: B:4:0x0007 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void A0C() {
        /*
            r6 = this;
            r5 = 0
        L1:
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r6.A0B
            int r0 = r0.size()
            if (r5 >= r0) goto L36
            java.util.ArrayList<com.facebook.ads.redexgen.X.Bk> r0 = r6.A0B
            java.lang.Object r2 = r0.get(r5)
            com.facebook.ads.redexgen.X.Bk r2 = (com.facebook.ads.redexgen.core.C1127Bk) r2
            int r1 = r2.A02
            r0 = 2
            if (r1 != r0) goto L33
            com.facebook.ads.redexgen.X.nw r0 = r6.A0A     // Catch: java.io.IOException -> L1c
            r0.AHF(r2)     // Catch: java.io.IOException -> L1c
            goto L33
        L1c:
            r4 = move-exception
            r2 = 2
            r1 = 15
            r0 = 106(0x6a, float:1.49E-43)
            java.lang.String r3 = A08(r2, r1, r0)
            r2 = 223(0xdf, float:3.12E-43)
            r1 = 23
            r0 = 46
            java.lang.String r0 = A08(r2, r1, r0)
            com.facebook.ads.redexgen.core.AbstractC09574g.A08(r3, r0, r4)
        L33:
            int r5 = r5 + 1
            goto L1
        L36:
            r2 = 11
            r0 = 5000(0x1388, double:2.4703E-320)
            r6.sendEmptyMessageDelayed(r2, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C2.A0C():void");
    }

    private void A0E(int i) {
        this.A04 = i;
        C2588o4 c2588o4A7r = null;
        try {
            try {
                this.A0A.AJO();
                c2588o4A7r = this.A0A.A7r(0, 1, 2, 5, 7);
                while (c2588o4A7r.A01()) {
                    this.A0B.add(c2588o4A7r.A00());
                }
            } catch (IOException e) {
                AbstractC09574g.A08(A08(2, 15, 106), A08(67, 21, 14), e);
                this.A0B.clear();
            }
            C5C.A10(c2588o4A7r);
            this.A07.obtainMessage(0, new ArrayList(this.A0B)).sendToTarget();
            A0B();
        } catch (Throwable th) {
            C5C.A10(c2588o4A7r);
            throw th;
        }
    }

    private void A0F(int i) {
        this.A02 = i;
        A0B();
    }

    private void A0G(int i) {
        this.A03 = i;
    }

    private void A0H(int i) {
        this.A04 = i;
        A0B();
    }

    private void A0I(C1127Bk c1127Bk) {
        if (c1127Bk.A02 == 7) {
            int i = c1127Bk.A03 == 0 ? 0 : 1;
            int state = c1127Bk.A03;
            A04(c1127Bk, i, state);
            A0B();
            return;
        }
        this.A0B.remove(A02(c1127Bk.A07.A02));
        try {
            this.A0A.AIR(c1127Bk.A07.A02);
        } catch (IOException unused) {
            String strA08 = A08(2, 15, 106);
            String[] strArr = A0E;
            String str = strArr[1];
            String str2 = strArr[7];
            int length = str.length();
            int removeIndex = str2.length();
            if (length == removeIndex) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0E;
            strArr2[4] = "0mOws7zeqclkbY70VWtV8amCVjdjwc";
            strArr2[2] = "5byiBwQrvMTmrLaxdcHCyvzuNe0iHvcw";
            AbstractC09574g.A05(strA08, A08(88, 30, 26));
        }
        this.A07.obtainMessage(2, new C0(c1127Bk, true, new ArrayList(this.A0B), null)).sendToTarget();
    }

    private void A0J(C1127Bk c1127Bk, int i) {
        if (i == 0) {
            if (c1127Bk.A02 == 1) {
                A04(c1127Bk, 0, 0);
                return;
            }
            return;
        }
        int i2 = c1127Bk.A03;
        if (A0E[6].charAt(14) != 'H') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[4] = "qDoL4xVSTO8RDQU7ZVoZcH2BhkCOc4";
        strArr[2] = "ugBXxeG19GlyVlR2WcoXaVyqVtSsbrKH";
        if (i == i2) {
            return;
        }
        int i3 = c1127Bk.A02;
        if (i3 == 0 || i3 == 2) {
            i3 = 1;
        }
        A03(new C1127Bk(c1127Bk.A07, i3, c1127Bk.A05, System.currentTimeMillis(), c1127Bk.A04, i, 0, c1127Bk.A00));
    }

    private void A0K(C1127Bk c1127Bk, Exception exc) {
        int i;
        DownloadRequest downloadRequest = c1127Bk.A07;
        int i2 = exc == null ? 3 : 4;
        long j = c1127Bk.A05;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j2 = c1127Bk.A04;
        int i3 = c1127Bk.A03;
        if (exc == null) {
            i = 0;
        } else {
            i = 1;
        }
        C1127Bk c1127Bk2 = new C1127Bk(downloadRequest, i2, j, jCurrentTimeMillis, j2, i3, i, c1127Bk.A00);
        this.A0B.remove(A02(c1127Bk2.A07.A02));
        try {
            this.A0A.AHF(c1127Bk2);
        } catch (IOException e) {
            AbstractC09574g.A08(A08(2, 15, 106), A08(223, 23, 46), e);
        }
        this.A07.obtainMessage(2, new C0(c1127Bk2, false, new ArrayList(this.A0B), exc)).sendToTarget();
    }

    private void A0L(C2585o0 c2585o0) {
        String str = c2585o0.A04.A02;
        this.A0C.remove(str);
        boolean z = c2585o0.A06;
        if (z) {
            this.A06 = false;
        } else {
            int i = this.A01 - 1;
            this.A01 = i;
            if (i == 0) {
                removeMessages(11);
            }
        }
        if (c2585o0.A08) {
            A0B();
            return;
        }
        Exception finalException = c2585o0.A01;
        if (finalException != null) {
            StringBuilder sb = new StringBuilder();
            String downloadId = A08(246, 13, 86);
            StringBuilder sbAppend = sb.append(downloadId).append(c2585o0.A04);
            String downloadId2 = A08(0, 2, 97);
            String string = sbAppend.append(downloadId2).append(z).toString();
            String downloadId3 = A08(2, 15, 106);
            AbstractC09574g.A08(downloadId3, string, finalException);
        }
        C1127Bk c1127BkA06 = A06(str, false);
        if (A0E[3].charAt(4) != '8') {
            throw new RuntimeException();
        }
        String[] strArr = A0E;
        strArr[4] = "ylCSlCHYxJLig8GFragBjcnbyuXWai";
        strArr[2] = "OMWcFhgpmCCD5KtgAO70M2kgxcAld7fK";
        C1127Bk c1127Bk = (C1127Bk) AbstractC09493y.A01(c1127BkA06);
        switch (c1127Bk.A02) {
            case 2:
                AbstractC09493y.A08(!z);
                A0K(c1127Bk, finalException);
                break;
            case 3:
            case 4:
            case 6:
            default:
                throw new IllegalStateException();
            case 5:
            case 7:
                AbstractC09493y.A08(z);
                A0I(c1127Bk);
                break;
        }
        A0B();
    }

    private void A0M(C2585o0 c2585o0) {
        if (c2585o0 == null) {
            return;
        }
        AbstractC09493y.A08(!c2585o0.A06);
        c2585o0.A05(false);
    }

    private void A0N(C2585o0 c2585o0, long j) {
        C1127Bk c1127Bk = (C1127Bk) AbstractC09493y.A01(A06(c2585o0.A04.A02, false));
        if (j == c1127Bk.A04 || j == -1) {
            return;
        }
        A03(new C1127Bk(c1127Bk.A07, c1127Bk.A02, c1127Bk.A05, System.currentTimeMillis(), j, c1127Bk.A03, c1127Bk.A01, c1127Bk.A00));
    }

    private void A0O(C2585o0 c2585o0, C1127Bk c1127Bk) {
        if (c2585o0 == null) {
            boolean z = this.A06;
            if (A0E[3].charAt(4) != '8') {
                throw new RuntimeException();
            }
            A0E[0] = "e4XXQnURg6mIpThj5jyh4wOBvzx0EgPt";
            if (z) {
                return;
            }
            C2585o0 c2585o02 = new C2585o0(c1127Bk.A07, this.A09.A5M(c1127Bk.A07), c1127Bk.A00, true, this.A03, this);
            this.A0C.put(c1127Bk.A07.A02, c2585o02);
            this.A06 = true;
            c2585o02.start();
            return;
        }
        if (!c2585o0.A06) {
            c2585o0.A05(false);
        }
    }

    private void A0P(C2585o0 c2585o0, C1127Bk c1127Bk, int i) {
        AbstractC09493y.A08(!c2585o0.A06);
        if (!A0U() || i >= this.A02) {
            A04(c1127Bk, 0, 0);
            c2585o0.A05(false);
        }
    }

    private void A0R(String str) {
        C1127Bk c1127BkA06 = A06(str, true);
        if (c1127BkA06 == null) {
            AbstractC09574g.A05(A08(2, 15, 106), A08(118, 39, 4) + str);
        } else {
            A04(c1127BkA06, 5, 0);
            A0B();
        }
    }

    private void A0S(String str, int i) {
        String strA08 = A08(2, 15, 106);
        if (str == null) {
            for (int i2 = 0; i2 < this.A0B.size(); i2++) {
                A0J(this.A0B.get(i2), i);
            }
            try {
                this.A0A.AJq(i);
            } catch (IOException e) {
                AbstractC09574g.A08(strA08, A08(157, 32, 101), e);
            }
        } else {
            C1127Bk c1127BkA06 = A06(str, false);
            if (c1127BkA06 != null) {
                A0J(c1127BkA06, i);
            } else {
                try {
                    this.A0A.AJr(str, i);
                } catch (IOException e2) {
                    AbstractC09574g.A08(strA08, A08(PsExtractor.PRIVATE_STREAM_1, 34, 0) + str, e2);
                }
            }
        }
        A0B();
    }

    private void A0T(boolean z) {
        this.A05 = z;
        A0B();
    }

    private boolean A0U() {
        if (!this.A05) {
            int i = this.A04;
            if (A0E[6].charAt(14) != 'H') {
                throw new RuntimeException();
            }
            A0E[5] = "cfwXoVsCs";
            if (i == 0) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (WU.A02(this)) {
            return;
        }
        boolean z = true;
        try {
            switch (message.what) {
                case 0:
                    A0E(message.arg1);
                    break;
                case 1:
                    A0T(message.arg1 != 0);
                    break;
                case 2:
                    A0H(message.arg1);
                    break;
                case 3:
                    A0S((String) message.obj, message.arg1);
                    break;
                case 4:
                    A0F(message.arg1);
                    break;
                case 5:
                    A0G(message.arg1);
                    break;
                case 6:
                    A0Q((DownloadRequest) message.obj, message.arg1);
                    break;
                case 7:
                    A0R((String) message.obj);
                    break;
                case 8:
                    A0A();
                    break;
                case 9:
                    A0L((C2585o0) message.obj);
                    z = false;
                    break;
                case 10:
                    A0N((C2585o0) message.obj, C5C.A0N(message.arg1, message.arg2));
                    return;
                case 11:
                    A0C();
                    return;
                case 12:
                    A09();
                    return;
                default:
                    throw new IllegalStateException();
            }
            this.A07.obtainMessage(1, z ? 1 : 0, this.A0C.size()).sendToTarget();
        } catch (Throwable th) {
            WU.A00(th, this);
        }
    }
}
