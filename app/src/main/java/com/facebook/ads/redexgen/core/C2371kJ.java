package com.facebook.ads.redexgen.core;

import java.util.Collection;
import org.json.JSONObject;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.kJ, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C2371kJ implements InterfaceC1420Mw {
    public final /* synthetic */ C2165gi A00;
    public final /* synthetic */ String A01;
    public final /* synthetic */ JSONObject A02;

    public C2371kJ(JSONObject jSONObject, C2165gi c2165gi, String str) {
        this.A02 = jSONObject;
        this.A00 = c2165gi;
        this.A01 = str;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final String A7O() {
        return this.A01;
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final Collection<String> A7p() {
        return AbstractC1421Mx.A03(this.A00, this.A02);
    }

    @Override // com.facebook.ads.redexgen.core.InterfaceC1420Mw
    public final EnumC1419Mv A8K() {
        return AbstractC1421Mx.A00(this.A02);
    }
}
