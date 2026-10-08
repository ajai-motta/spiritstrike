package com.facebook.ads.redexgen.core;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.fq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public final class C2111fq {
    public float A00;
    public EnumC1389Lr A01;
    public Map<String, String> A02;

    public C2111fq(EnumC1389Lr enumC1389Lr) {
        this(enumC1389Lr, 0.0f);
    }

    public C2111fq(EnumC1389Lr enumC1389Lr, float f) {
        this(enumC1389Lr, f, null);
    }

    public C2111fq(@Nullable EnumC1389Lr enumC1389Lr, float f, Map<String, String> windowParams) {
        this.A01 = enumC1389Lr;
        this.A00 = f;
        if (windowParams != null) {
            this.A02 = windowParams;
        } else {
            this.A02 = new HashMap();
        }
    }

    public final float A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01.A03();
    }

    public final EnumC1389Lr A02() {
        return this.A01;
    }

    public final Map<String, String> A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A01 == EnumC1389Lr.A0I;
    }
}
