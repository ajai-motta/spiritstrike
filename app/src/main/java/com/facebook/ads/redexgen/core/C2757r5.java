package com.facebook.ads.redexgen.core;

import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.r5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2757r5 {
    public static C2757r5 A03;
    public static InterfaceC2780rX A04;
    public static byte[] A05;
    public static String[] A06 = {"5DKKU3xZINN65fryyoBt5QQPLIMTkohn", "LFzimA69beWaSFXyztzupLxdNfHOQ", "XSuolM5aqTyza3oApgyv2R2QmsMDCJc3", "zWK24MgLV", "4", "qJClZMWv8", "0fmkfxUqb1vnRdlz6H0UDHtVT1WIbpOa", "oRXxD"};
    public final ViewpointQeConfig A00;
    public final ViewpointRegistry A01;
    public final C2767rF A02;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            byte b = bArrCopyOfRange[i4];
            if (A06[4].length() == 19) {
                throw new RuntimeException();
            }
            A06[6] = "At1Zr1oMV19x7NxsOWFoG9shzyjt72Ks";
            bArrCopyOfRange[i4] = (byte) ((b - i3) - 7);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A05 = new byte[]{-89, -74, -87, -91, -72, -87};
    }

    static {
        A03();
        A03 = null;
        A04 = null;
    }

    public C2757r5(ViewpointQeConfig viewpointQeConfig, AbstractC2772rL abstractC2772rL, C2767rF c2767rF, ViewpointRegistry viewpointRegistry) {
        this.A00 = viewpointQeConfig;
        this.A01 = viewpointRegistry;
        this.A02 = c2767rF;
        abstractC2772rL.A03(new C1102Aj(c2767rF));
    }

    public static ScanDelayController A00(int i) {
        if (0 == 0) {
            return null;
        }
        throw new NullPointerException(A02(0, 6, 61));
    }

    public static C2757r5 A01(ViewpointQeConfig viewpointQeConfig, AbstractC2772rL abstractC2772rL, InterfaceC2777rQ interfaceC2777rQ, InterfaceC1103Al interfaceC1103Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        C2757r5 c2757r5 = A03;
        if (c2757r5 != null) {
            return c2757r5;
        }
        ViewpointRegistry viewpointRegistry = new ViewpointRegistry(viewpointQeConfig);
        CK ck = CK.A00;
        Handler handler = new Handler(Looper.getMainLooper());
        A00(100);
        return new C2757r5(viewpointQeConfig, abstractC2772rL, new C2767rF(viewpointQeConfig, interfaceC2777rQ, ck, interfaceC1103Al, viewpointRegistry, viewpointAutoOcclusion, handler, null), viewpointRegistry);
    }

    public final void A04(InterfaceC2771rK interfaceC2771rK) {
        this.A02.A0H(interfaceC2771rK);
    }

    public final void A05(InterfaceC2769rI interfaceC2769rI) {
        this.A02.A0I(interfaceC2769rI);
    }

    public final void A06(DspViewableNode dspViewableNode) {
        A07(dspViewableNode, null);
    }

    public final void A07(DspViewableNode dspViewableNode, C2778rU c2778rU) {
        if (this.A00.A00 && c2778rU != null) {
            this.A01.A06(dspViewableNode, c2778rU);
        } else {
            this.A01.A05(dspViewableNode);
        }
    }

    public final void A08(DspViewableNode dspViewableNode, C2778rU c2778rU, C2774rN c2774rN) {
        if (this.A00.A00 && c2778rU != null) {
            this.A01.A07(dspViewableNode, c2778rU, c2774rN);
        } else {
            this.A01.A08(dspViewableNode, c2774rN);
        }
    }

    public final void A09(DspViewableNode dspViewableNode, C2774rN c2774rN) {
        A08(dspViewableNode, null, c2774rN);
    }
}
