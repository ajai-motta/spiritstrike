package com.facebook.ads.redexgen.core;

import com.facebook.ads.androidx.media3.extractor.mkv.MatroskaExtractor;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mK, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2493mK implements InterfaceC1305Ik {
    public final /* synthetic */ MatroskaExtractor A00;

    public C2493mK(MatroskaExtractor matroskaExtractor) {
        this.A00 = matroskaExtractor;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void A4i(int i, int i2, InterfaceC2516ms interfaceC2516ms) throws IOException {
        this.A00.A0U(i, i2, interfaceC2516ms);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void A6N(int i) throws C3K {
        this.A00.A0S(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void A6a(int i, double d) throws C3K {
        this.A00.A0T(i, d);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final int A7u(int i) {
        return this.A00.A0R(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void AAH(int i, long j) throws C3K {
        this.A00.A0V(i, j);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final boolean AAW(int i) {
        return this.A00.A0Y(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void AK9(int i, long j, long j2) throws C3K {
        this.A00.A0W(i, j, j2);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1305Ik
    public final void AKK(int i, String str) throws C3K {
        this.A00.A0X(i, str);
    }
}
