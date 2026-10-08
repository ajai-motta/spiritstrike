package com.facebook.ads.redexgen.core;

import android.net.Uri;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.pF, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public interface InterfaceC2661pF extends InterfaceC09052c {
    void A43(InterfaceC09965t interfaceC09965t);

    Map<String, List<String>> A8t();

    Uri A9P();

    long AGi(C09855i c09855i) throws IOException;

    void close() throws IOException;
}
