package com.facebook.ads.redexgen.core;

import android.view.View;
import java.util.Arrays;
import java.util.LinkedHashMap;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ao, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C1105Ao implements SharedViewpointManager {
    public static boolean A07;
    public static byte[] A08;
    public InterfaceC2781rY A00;
    public InterfaceC2769rI A01;
    public C2757r5 A02;
    public final InterfaceC2770rJ A04;
    public final ViewpointQeConfig A05;
    public final LinkedHashMap<Integer, Runnable> A06 = new LinkedHashMap<>();
    public final InterfaceC2769rI A03 = new C1106Ap(this);

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 106);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A08 = new byte[]{-28};
    }

    static {
        A04();
        A07 = false;
    }

    public C1105Ao(ViewpointQeConfig viewpointQeConfig, InterfaceC2781rY interfaceC2781rY, InterfaceC2770rJ interfaceC2770rJ) {
        this.A05 = viewpointQeConfig;
        this.A00 = interfaceC2781rY;
        this.A04 = interfaceC2770rJ;
    }

    public static C1105Ao A01() {
        return new C1105Ao(new ViewpointQeConfig(), new C1108Ar(), null);
    }

    private void A05(AbstractC2772rL abstractC2772rL, InterfaceC2777rQ interfaceC2777rQ, InterfaceC1103Al interfaceC1103Al, ViewpointAutoOcclusion viewpointAutoOcclusion) {
        this.A02 = C2757r5.A01(this.A05, abstractC2772rL, interfaceC2777rQ, interfaceC1103Al, viewpointAutoOcclusion);
        if (0 != 0) {
            this.A02.A04(null);
        }
        this.A02.A05(this.A03);
    }

    private void A06(DspViewableNode dspViewableNode, C2778rU c2778rU) {
        C2757r5 c2757r5 = this.A02;
        if (c2757r5 != null && dspViewableNode != null) {
            if (this.A05.A00 && c2778rU != null) {
                c2757r5.A07(dspViewableNode, c2778rU);
            } else {
                c2757r5.A06(dspViewableNode);
            }
        }
    }

    private void A07(DspViewableNode dspViewableNode, C2778rU c2778rU, C2774rN c2774rN) {
        C2757r5 c2757r5 = this.A02;
        if (c2757r5 != null && dspViewableNode != null && c2774rN != null) {
            if (this.A05.A00 && c2778rU != null) {
                c2774rN.A02 = dspViewableNode.hashCode() + A02(0, 1, 27) + c2774rN.A08 + c2778rU;
                c2757r5.A08(dspViewableNode, c2778rU, c2774rN);
            } else {
                c2757r5.A09(dspViewableNode, c2774rN);
            }
        }
    }

    public final void A08(View view) {
        A06(view != null ? ViewpointViewNode.A00(view) : null, null);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.rN != com.instagram.common.viewpoint.core.ViewpointData<?, ?> */
    public final void A09(View view, C2774rN<?, ?> c2774rN) {
        A07(view != null ? ViewpointViewNode.A00(view) : null, null, c2774rN);
    }

    public final void A0A(AbstractC2772rL abstractC2772rL, View view) {
        if (abstractC2772rL != null && view != null) {
            A05(abstractC2772rL, new C1107Aq(view, this.A00), new C08971u(null), null);
        }
    }
}
