package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.mt, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2517mt implements InterfaceC1272Hd {
    public final byte[] A00 = new byte[4096];

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final /* synthetic */ int AIp(InterfaceC09052c interfaceC09052c, int i, boolean z) {
        return AbstractC1269Ha.A00(this, interfaceC09052c, i, z);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final /* synthetic */ void AIr(C09724v c09724v, int i) {
        AbstractC1269Ha.A01(this, c09724v, i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final void A6e(C2725qI c2725qI) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final int AIq(InterfaceC09052c interfaceC09052c, int i, boolean z, int i2) throws IOException {
        int bytesSkipped = interfaceC09052c.read(this.A00, 0, Math.min(this.A00.length, i));
        if (bytesSkipped == -1) {
            if (z) {
                return -1;
            }
            throw new EOFException();
        }
        return bytesSkipped;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final void AIs(C09724v c09724v, int i, int i2) {
        c09724v.A0g(i);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    public final void AIu(long j, int i, int i2, int i3, C1270Hb c1270Hb) {
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1272Hd
    @MetaExoPlayerCustomization("New API added for Meta")
    public final void AKf(Uri uri) {
    }
}
