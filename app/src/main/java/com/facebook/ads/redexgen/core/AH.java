package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class AH implements InterfaceC2661pF {
    public static byte[] A03;
    public final int A00;
    public final AbstractC09303d A01;
    public final InterfaceC2661pF A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 41);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{1, 3, 0, -12, -10, -10, -11, -32, 3, -27, -7, 3, 0, 8};
    }

    public AH(InterfaceC2661pF interfaceC2661pF, AbstractC09303d abstractC09303d, int i) {
        this.A02 = (InterfaceC2661pF) AbstractC09493y.A01(interfaceC2661pF);
        AbstractC09493y.A01(abstractC09303d);
        this.A01 = null;
        this.A00 = i;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final void A43(InterfaceC09965t interfaceC09965t) {
        AbstractC09493y.A01(interfaceC09965t);
        this.A02.A43(interfaceC09965t);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final Map<String, List<String>> A8t() {
        return this.A02.A8t();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final Uri A9P() {
        return this.A02.A9P();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final long AGi(C09855i c09855i) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2661pF
    public final void close() throws IOException {
        this.A02.close();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC09052c
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        throw new NullPointerException(A00(0, 14, 104));
    }
}
