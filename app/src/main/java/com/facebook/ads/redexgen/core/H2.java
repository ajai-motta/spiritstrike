package com.facebook.ads.redexgen.core;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;
import java.util.Arrays;
import kotlin.io.encoding.Base64;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class H2 {
    public static byte[] A04;
    public static String[] A05 = {"uP2VmRjmPrkQ", "gRGWgf4lLYF9Rif8PQPDNbGokb9BUMtV", "bSjOyzwe8Lqn79dPeHIi8kfJVgfNJaEZ", "7R1XMZQjg8S2TiXm1wE8kLqT1leJFKD3", "sD", "qKJRf3b", "Q40N8hoONMcQBFaHNU", "iAP6W7CwppN1UlUQVXHbR"};
    public C1265Gw A00;
    public final int A01;
    public final C2523n0 A02;
    public final H1 A03;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 35);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A04 = new byte[]{7, 32, 56, 47, 34, 39, 42, 110, 45, 47, Base64.padSymbol, 43};
    }

    static {
        A03();
    }

    public H2(InterfaceC1266Gx interfaceC1266Gx, H1 h1, long j, long j2, long j3, long j4, long j5, long j6, int i) {
        this.A03 = h1;
        this.A01 = i;
        this.A02 = new C2523n0(interfaceC1266Gx, j, j2, j3, j4, j5, j6);
    }

    private final int A00(InterfaceC2516ms interfaceC2516ms, long j, HV hv) {
        if (j != interfaceC2516ms.A8n()) {
            hv.A00 = j;
            return 1;
        }
        if (A05[5].length() != 7) {
            throw new RuntimeException();
        }
        A05[4] = "eb0wJDSKJb6zWnRAqReB9UTGfXv";
        return 0;
    }

    private final C1265Gw A01(long j) {
        return new C1265Gw(j, this.A02.A05(j), this.A02.A05, this.A02.A02, this.A02.A04, this.A02.A01, this.A02.A00);
    }

    private final void A04(boolean z, long j) {
        this.A00 = null;
        this.A03.AFs();
    }

    private final boolean A05(InterfaceC2516ms interfaceC2516ms, long j) throws IOException {
        long jA8n = j - interfaceC2516ms.A8n();
        if (jA8n >= 0 && jA8n <= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            interfaceC2516ms.AK3((int) jA8n);
            return true;
        }
        return false;
    }

    public final int A06(InterfaceC2516ms interfaceC2516ms, HV hv) throws IOException {
        while (true) {
            C1265Gw c1265Gw = (C1265Gw) AbstractC09493y.A02(this.A00);
            long jA01 = c1265Gw.A01();
            long jA00 = c1265Gw.A00();
            long jA02 = c1265Gw.A02();
            if (jA00 - jA01 <= this.A01) {
                A04(false, jA01);
                String[] strArr = A05;
                if (strArr[3].charAt(1) != strArr[1].charAt(1)) {
                    throw new RuntimeException();
                }
                A05[5] = "cjf3Phs";
                return A00(interfaceC2516ms, jA01, hv);
            }
            if (!A05(interfaceC2516ms, jA02)) {
                return A00(interfaceC2516ms, jA02, hv);
            }
            interfaceC2516ms.AIl();
            C1268Gz c1268GzAIw = this.A03.AIw(interfaceC2516ms, c1265Gw.A04());
            switch (c1268GzAIw.A00) {
                case -3:
                    A04(false, jA02);
                    return A00(interfaceC2516ms, jA02, hv);
                case -2:
                    c1265Gw.A0D(c1268GzAIw.A02, c1268GzAIw.A01);
                    break;
                case -1:
                    c1265Gw.A0C(c1268GzAIw.A02, c1268GzAIw.A01);
                    break;
                case 0:
                    A05(interfaceC2516ms, c1268GzAIw.A01);
                    long floorPosition = c1268GzAIw.A01;
                    A04(true, floorPosition);
                    return A00(interfaceC2516ms, c1268GzAIw.A01, hv);
                default:
                    throw new IllegalStateException(A02(0, 12, 109));
            }
        }
    }

    public final C2523n0 A07() {
        return this.A02;
    }

    public final void A08(long j) {
        if (this.A00 != null && this.A00.A03() == j) {
            return;
        }
        this.A00 = A01(j);
    }

    public final boolean A09() {
        return this.A00 != null;
    }
}
