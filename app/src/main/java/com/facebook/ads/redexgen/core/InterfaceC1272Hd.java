package com.facebook.ads.redexgen.core;

import android.net.Uri;
import com.facebook.video.heroplayer.exocustom.MetaExoPlayerCustomization;
import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Hd, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC1272Hd {
    void A6e(C2725qI c2725qI);

    int AIp(InterfaceC09052c interfaceC09052c, int i, boolean z) throws IOException;

    int AIq(InterfaceC09052c interfaceC09052c, int i, boolean z, int i2) throws IOException;

    void AIr(C09724v c09724v, int i);

    void AIs(C09724v c09724v, int i, int i2);

    void AIu(long j, int i, int i2, int i3, C1270Hb c1270Hb);

    @MetaExoPlayerCustomization("New Meta API")
    void AKf(Uri uri);
}
