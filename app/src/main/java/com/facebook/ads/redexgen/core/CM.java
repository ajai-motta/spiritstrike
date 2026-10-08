package com.facebook.ads.redexgen.core;

import com.facebook.ads.sync.SyncModifiableBundle;
import java.util.Map;

/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public abstract class CM implements InterfaceC2159gc {
    public final EnumC2151gU A00;
    public final AbstractC09062d A01;

    public CM(AbstractC09062d abstractC09062d, EnumC2151gU enumC2151gU) {
        this.A01 = abstractC09062d;
        this.A00 = enumC2151gU;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC2159gc
    public void A4D(Map<InterfaceC2141gK, EnumC2164gh> map, Map<SyncModifiableBundle, EnumC2151gU> map2) {
        map2.put(null, this.A00);
    }
}
