package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CL implements InterfaceC2159gc {
    public final C1143Cb A00;
    public final EnumC2164gh A01;

    public CL(C1143Cb c1143Cb, EnumC2164gh enumC2164gh) {
        this.A00 = c1143Cb;
        this.A01 = enumC2164gh;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2159gc
    public void A4D(Map<InterfaceC2141gK, EnumC2164gh> map, Map<SyncModifiableBundle, EnumC2151gU> map2) {
        map.put(this.A00, this.A01);
    }
}
