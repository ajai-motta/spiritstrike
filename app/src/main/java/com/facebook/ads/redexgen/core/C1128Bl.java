package com.facebook.ads.redexgen.core;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Bl, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1128Bl<K, V> extends C2566nh<K, V>.Itr<Map.Entry<K, V>> {
    public final /* synthetic */ C2566nh A00;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1128Bl(final C2566nh this$0) {
        super(this$0, null);
        this.A00 = this$0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final Map.Entry<K, V> A03(int entry) {
        return new C1125Bi(this.A00, entry);
    }
}
