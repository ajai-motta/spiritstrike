package com.facebook.ads.redexgen.core;

import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Be, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
public class C1121Be extends AbstractC2577ns {
    public C1121Be() {
        super(null);
    }

    private final AbstractC2577ns A00(int result) {
        if (result < 0) {
            return AbstractC2577ns.A02;
        }
        if (result > 0) {
            return AbstractC2577ns.A01;
        }
        return AbstractC2577ns.A00;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final int A05() {
        return 0;
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final AbstractC2577ns A06(int left, int right) {
        return A00(Integer.compare(left, right));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final AbstractC2577ns A07(long left, long right) {
        return A00(Long.compare(left, right));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final <T> AbstractC2577ns A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator) {
        return A00(comparator.compare(left, right));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final AbstractC2577ns A09(boolean left, boolean right) {
        return A00(Boolean.compare(left, right));
    }

    @Override // com.facebook.ads.redexgen.core.AbstractC2577ns
    public final AbstractC2577ns A0A(boolean left, boolean right) {
        return A00(Boolean.compare(right, left));
    }
}
