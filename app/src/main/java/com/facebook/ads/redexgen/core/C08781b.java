package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import com.google.android.exoplayer2.C;
import com.google.common.base.Ascii;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;
import org.checkerframework.dataflow.qual.SideEffectFree;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C08781b extends AE implements Handler.Callback {
    public static byte[] A0H;
    public static String[] A0I = {"58lW15hp88fFpLaSxErp", "56QScXrV6I", "DwEmmtKo2ODeTiA17rxauXwet98Z4", "A4aLtxZMLOPLaVE6SeDzXnpOLTGefetw", "FhOKuZuvLBWd8lghoK1mwxVLtzQRZ", "h1d8vpIJ83Cnf8DVjx4Ui7av1xQxYsFL", "y1YT0hSXczs7bGZDGpuR", "alxZNjekiwxoo3ZSsAAxphzspQJfVEZr"};
    public int A00;
    public int A01;
    public long A02;
    public long A03;
    public long A04;
    public C2725qI A05;
    public InterfaceC2464lq A06;
    public C8S A07;
    public C8P A08;
    public C8P A09;
    public boolean A0A;
    public boolean A0B;
    public boolean A0C;
    public final Handler A0D;
    public final C10286z A0E;
    public final EP A0F;
    public final ES A0G;

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0H, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            String[] strArr = A0I;
            if (strArr[6].length() != strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0I;
            strArr2[2] = "1YRuRVntTKbD5w1SSS8awuyRss3tM";
            strArr2[4] = "HmFGzdsys3t1iPkkAdwtO8Q44Z9aJ";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 122);
            i4++;
        }
    }

    public static void A09() {
        A0H = new byte[]{89, 127, 104, 126, 99, 126, 102, 111, 42, 110, 111, 105, 101, 110, 99, 100, 109, 42, 108, 107, 99, 102, 111, 110, 36, 42, 121, 126, 120, 111, 107, 103, 76, 101, 120, 103, 107, 126, 55, 57, 8, Ascii.NAK, Ascii.EM, 63, 8, 3, 9, 8, Ascii.US, 8, Ascii.US};
    }

    static {
        A09();
    }

    public C08781b(ES es, Looper looper, EP ep) {
        super(3);
        this.A0G = (ES) AbstractC09493y.A01(es);
        this.A0D = looper == null ? null : C5C.A0c(looper, this);
        this.A0F = ep;
        this.A0E = new C10286z();
        this.A02 = C.TIME_UNSET;
        this.A04 = C.TIME_UNSET;
        this.A03 = C.TIME_UNSET;
    }

    private long A00() {
        if (this.A01 == -1) {
            return Long.MAX_VALUE;
        }
        AbstractC09493y.A01(this.A09);
        if (this.A01 >= this.A09.A84()) {
            return Long.MAX_VALUE;
        }
        return this.A09.A83(this.A01);
    }

    @RequiresNonNull({"subtitle"})
    @SideEffectFree
    private long A01(long j) {
        int iA8a = this.A09.A8a(j);
        if (iA8a != 0) {
            int nextEventTimeIndex = this.A09.A84();
            if (nextEventTimeIndex != 0) {
                String[] strArr = A0I;
                String str = strArr[6];
                String str2 = strArr[0];
                int length = str.length();
                int nextEventTimeIndex2 = str2.length();
                if (length != nextEventTimeIndex2) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0I;
                strArr2[2] = "dWbBH4lKinuUlTA8CpNFonpmnzuPl";
                strArr2[4] = "MDue3s6tkJ65MZJ0TxYFZvpfeIb1w";
                if (iA8a == -1) {
                    C8P c8p = this.A09;
                    if (A0I[1].length() != 10) {
                        int nextEventTimeIndex3 = this.A09.A84();
                        return c8p.A83(nextEventTimeIndex3 - 1);
                    }
                    A0I[3] = "us0wUp64B7rq5nQeuQUWAOSOIfPFOl8I";
                    int nextEventTimeIndex4 = this.A09.A84();
                    return c8p.A83(nextEventTimeIndex4 - 1);
                }
                int nextEventTimeIndex5 = iA8a - 1;
                return this.A09.A83(nextEventTimeIndex5);
            }
        }
        return ((AbstractC2645oz) this.A09).A01;
    }

    @SideEffectFree
    private long A02(long j) {
        boolean z = true;
        AbstractC09493y.A08(j != C.TIME_UNSET);
        if (this.A04 == C.TIME_UNSET) {
            z = false;
        }
        AbstractC09493y.A08(z);
        return j - this.A04;
    }

    private void A04() {
        A0B(new C2673pR(MetaExoPlayerCustomizedCollections.A01(), A02(this.A03)));
    }

    private void A05() {
        this.A0C = true;
        this.A06 = this.A0F.A5K((C2725qI) AbstractC09493y.A01(this.A05));
    }

    private void A06() {
        this.A07 = null;
        this.A01 = -1;
        if (this.A09 != null) {
            this.A09.A0B();
            this.A09 = null;
        }
        if (this.A08 != null) {
            this.A08.A0B();
            this.A08 = null;
        }
    }

    private void A07() {
        A06();
        ((InterfaceC2464lq) AbstractC09493y.A01(this.A06)).AHb();
        this.A06 = null;
        this.A00 = 0;
    }

    private void A08() {
        A07();
        A05();
    }

    private void A0A(C2673pR c2673pR) {
        this.A0G.ADa(c2673pR.A01);
        this.A0G.ADZ(c2673pR);
    }

    private void A0B(C2673pR c2673pR) {
        if (this.A0D != null) {
            this.A0D.obtainMessage(0, c2673pR).sendToTarget();
        } else {
            A0A(c2673pR);
        }
    }

    @MetaExoPlayerCustomization(type = {"NEW_METHOD"}, value = "Method to propagate any SubtitleDecoder Error upwards")
    private void A0C(ER er) {
        if (this.A0D != null) {
            this.A0D.obtainMessage(1, er).sendToTarget();
        }
    }

    private void A0D(C2457lj c2457lj) {
        AbstractC09574g.A08(A03(39, 12, 23), A03(0, 39, 112) + this.A05, c2457lj);
        A0C(new ER(this.A05, c2457lj));
        A04();
        A08();
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1Z() {
        this.A05 = null;
        this.A02 = C.TIME_UNSET;
        A04();
        this.A04 = C.TIME_UNSET;
        this.A03 = C.TIME_UNSET;
        A07();
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1a(long j, boolean z) {
        this.A03 = j;
        A04();
        this.A0A = false;
        this.A0B = false;
        this.A02 = C.TIME_UNSET;
        if (this.A00 != 0) {
            A08();
        } else {
            A06();
            ((InterfaceC2464lq) AbstractC09493y.A01(this.A06)).flush();
        }
    }

    @Override // com.facebook.ads.redexgen.core.AE
    public final void A1c(C2725qI[] c2725qIArr, long j, long j2) {
        this.A04 = j2;
        this.A05 = c2725qIArr[0];
        if (this.A06 != null) {
            this.A00 = 1;
        } else {
            A05();
        }
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final boolean AAP() {
        return this.A0B;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    public final boolean AAe() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00ea  */
    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void AIX(long r10, long r12) throws com.facebook.ads.redexgen.core.AnonymousClass61 {
        /*
            Method dump skipped, instruction units count: 404
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.core.C08781b.AIX(long, long):void");
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC10447p
    public final int AKM(C2725qI c2725qI) {
        if (this.A0F.AKN(c2725qI)) {
            return AbstractC10377i.A00(4);
        }
        if (C3J.A0E(c2725qI.A0W)) {
            return AbstractC10377i.A00(1);
        }
        return AbstractC10377i.A00(0);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2634oo, com.facebook.ads.redexgen.core.InterfaceC10447p
    public final String getName() {
        return A03(39, 12, 23);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.what) {
            case 0:
                A0A((C2673pR) message.obj);
                return true;
            case 1:
                return true;
            default:
                throw new IllegalStateException();
        }
    }
}
