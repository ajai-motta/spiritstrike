package com.facebook.ads.redexgen.core;

import java.io.IOException;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5d, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class AbstractC09805d {
    public static void A00(InterfaceC2661pF interfaceC2661pF) {
        if (interfaceC2661pF != null) {
            try {
                interfaceC2661pF.close();
            } catch (IOException unused) {
            }
        }
    }
}
