package com.facebook.ads.redexgen.core;

import android.net.Uri;
import android.view.Surface;
import com.google.common.base.Ascii;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fX, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2092fX {
    public static byte[] A02;
    public final AA A00;
    public final C2533nA A01 = new C2533nA();

    static {
        A02();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 50);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{-64, -54, -66, -64, 1, -1, 19, 17, 3, -64, -66, -40, -66, -64, -74, -64, -76, -74, 6, -7, 2, -8, -7, 6, -7, 6, -35, 2, -8, -7, Ascii.FF, -74, -76, -50, -76, -74, -54, 37, -9, -6, 9, Ascii.DLE, -73, 2, -6, 8, 8, -10, -4, -6, -73, -75, -49, -75, -73, -75, 92, -82, -77, -86, -97, 92, 90, 116, 90, 92};
    }

    public C2092fX(C2165gi c2165gi) {
        InterfaceC1204Em trackSelectionFactory = new C2550nR(this.A01);
        C10829h c10829h = new C10829h(trackSelectionFactory);
        AnonymousClass74 loadControl = new C2643ox();
        this.A00 = AbstractC10046b.A00(new C2640ou(c2165gi), c10829h, loadControl, this.A01);
    }

    public static String A01(C2706pz c2706pz) {
        boolean z = c2706pz instanceof AD;
        String strA00 = A00(36, 2, 118);
        String strA002 = A00(0, 14, 108);
        if (z) {
            AD ad = (AD) c2706pz;
            return A00(55, 11, 8) + ad.A03 + A00(14, 22, 98) + ad.A02 + strA002 + ad.getCause() + strA00;
        }
        return A00(41, 14, 99) + c2706pz.getMessage() + strA002 + c2706pz.getCause() + strA00;
    }

    public static boolean A03() {
        return true;
    }

    public final int A04() {
        return this.A00.A0I();
    }

    public final int A05() {
        return this.A00.A00();
    }

    public final long A06() {
        return this.A00.A7e();
    }

    public final long A07() {
        return this.A00.A7s();
    }

    public final C2090fV A08() {
        C2725qI vf = this.A00.A0K();
        if (vf == null) {
            return null;
        }
        return new C2090fV(vf.A0L, vf.A0A);
    }

    public final void A09() {
        this.A00.A0L();
    }

    public final void A0A() {
        this.A00.A02();
    }

    public final void A0B() {
        this.A00.A01();
    }

    public final void A0C(float f) {
        this.A00.A0M(f);
    }

    public final void A0D(long j) {
        this.A00.A04(j);
    }

    public final void A0E(Surface surface) {
        this.A00.A0N(surface);
    }

    public final void A0F(C2161ge c2161ge, Uri uri) {
        if (C1615Up.A2z(c2161ge, A03())) {
            C2096fb cacheManager = C2096fb.A06(c2161ge);
            C5Y cachedDataSourceFactory = cacheManager.A0H(c2161ge);
            this.A00.A0Q(new C10879o(cachedDataSourceFactory).A04(uri));
            return;
        }
        InterfaceC1163Cx mediaSource = new C10879o(new C2660pE(c2161ge, C5C.A0j(c2161ge, A00(38, 3, 100)), this.A01)).A04(uri);
        this.A00.A0Q(mediaSource);
    }

    public final void A0G(InterfaceC2089fU interfaceC2089fU) {
        this.A00.A0O(new D6(this, interfaceC2089fU));
    }

    public final void A0H(final InterfaceC2091fW interfaceC2091fW) {
        this.A00.A0P(new InterfaceC2631ol() { // from class: com.facebook.ads.redexgen.X.2s
            @Override // com.facebook.ads.redexgen.core.C5L
            public final void AGa(int i, int i2, int i3, float f) {
                interfaceC2091fW.AGa(i, i2, i3, f);
            }
        });
    }

    public final void A0I(boolean z) {
        this.A00.A0S(z);
    }

    public final boolean A0J() {
        return this.A00.A0T();
    }

    public final boolean A0K() {
        return this.A00.A0J() != null;
    }
}
