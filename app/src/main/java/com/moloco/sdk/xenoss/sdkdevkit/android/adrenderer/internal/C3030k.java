package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.k, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3030k {
    public static final int c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2532a;
    public final List<String> b;

    public C3030k(Integer num, List<String> gradient) {
        Intrinsics.checkNotNullParameter(gradient, "gradient");
        this.f2532a = num;
        this.b = gradient;
    }

    public final Integer a() {
        return this.f2532a;
    }

    public final List<String> b() {
        return this.b;
    }

    public final Integer c() {
        return this.f2532a;
    }

    public final List<String> d() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3030k)) {
            return false;
        }
        C3030k c3030k = (C3030k) obj;
        return Intrinsics.areEqual(this.f2532a, c3030k.f2532a) && Intrinsics.areEqual(this.b, c3030k.b);
    }

    public int hashCode() {
        Integer num = this.f2532a;
        return ((num == null ? 0 : num.hashCode()) * 31) + this.b.hashCode();
    }

    public String toString() {
        return "DECBorder(borderWidth=" + this.f2532a + ", gradient=" + this.b + ')';
    }

    public final C3030k a(Integer num, List<String> gradient) {
        Intrinsics.checkNotNullParameter(gradient, "gradient");
        return new C3030k(num, gradient);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ C3030k a(C3030k c3030k, Integer num, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            num = c3030k.f2532a;
        }
        if ((i & 2) != 0) {
            list = c3030k.b;
        }
        return c3030k.a(num, list);
    }

    public /* synthetic */ C3030k(Integer num, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(num, (i & 2) != 0 ? CollectionsKt.emptyList() : list);
    }
}
