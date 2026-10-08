package com.facebook.ads.redexgen.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ar, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1108Ar implements InterfaceC2781rY {
    public final List<InterfaceC2782rZ> A00 = new ArrayList();

    @Override // com.facebook.ads.redexgen.core.InterfaceC2781rY
    public final InterfaceC2782rZ A6i(int i) {
        this.A00.get(i);
        return null;
    }

    @Override // java.lang.Iterable
    public final Iterator<InterfaceC2782rZ> iterator() {
        return this.A00.iterator();
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2781rY
    public final int size() {
        return this.A00.size();
    }
}
