package com.facebook.ads.redexgen.core;

import com.google.common.collect.ElementTypesAreNonnullByDefault;
import com.google.common.collect.ParametricNullness;
import java.util.Comparator;

/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.ns, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network/classes2.dex */
@ElementTypesAreNonnullByDefault
public abstract class AbstractC2577ns {
    public static final AbstractC2577ns A00 = new C1121Be();
    public static final AbstractC2577ns A02 = new C1119Bc(-1);
    public static final AbstractC2577ns A01 = new C1119Bc(1);

    public abstract int A05();

    public abstract AbstractC2577ns A06(int left, int right);

    public abstract AbstractC2577ns A07(long left, long right);

    public abstract <T> AbstractC2577ns A08(@ParametricNullness T left, @ParametricNullness T right, Comparator<T> comparator);

    public abstract AbstractC2577ns A09(boolean left, boolean right);

    public abstract AbstractC2577ns A0A(boolean left, boolean right);

    public AbstractC2577ns() {
    }

    public /* synthetic */ AbstractC2577ns(C1121Be c1121Be) {
        this();
    }

    public static AbstractC2577ns A01() {
        return A00;
    }
}
