package com.moloco.sdk.internal.services.bidtoken.providers;

import com.moloco.sdk.internal.services.A;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class t {
    public static final int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2324a;
    public final Integer b;
    public final Boolean c;
    public final A d;

    public t() {
        this(null, null, null, null, 15, null);
    }

    public final Integer a() {
        return this.f2324a;
    }

    public final Integer b() {
        return this.b;
    }

    public final Boolean c() {
        return this.c;
    }

    public final A d() {
        return this.d;
    }

    public final Integer e() {
        return this.f2324a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return Intrinsics.areEqual(this.f2324a, tVar.f2324a) && Intrinsics.areEqual(this.b, tVar.b) && Intrinsics.areEqual(this.c, tVar.c) && Intrinsics.areEqual(this.d, tVar.d);
    }

    public final Integer f() {
        return this.b;
    }

    public final Boolean g() {
        return this.c;
    }

    public final A h() {
        return this.d;
    }

    public int hashCode() {
        Integer num = this.f2324a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.b;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Boolean bool = this.c;
        int iHashCode3 = (iHashCode2 + (bool == null ? 0 : bool.hashCode())) * 31;
        A a2 = this.d;
        return iHashCode3 + (a2 != null ? a2.hashCode() : 0);
    }

    public String toString() {
        return "NetworkInfoSignal(mobileCountryCode=" + this.f2324a + ", mobileNetworkCode=" + this.b + ", networkRestricted=" + this.c + ", networkType=" + this.d + ')';
    }

    public t(Integer num, Integer num2, Boolean bool, A a2) {
        this.f2324a = num;
        this.b = num2;
        this.c = bool;
        this.d = a2;
    }

    public final t a(Integer num, Integer num2, Boolean bool, A a2) {
        return new t(num, num2, bool, a2);
    }

    public static /* synthetic */ t a(t tVar, Integer num, Integer num2, Boolean bool, A a2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = tVar.f2324a;
        }
        if ((i & 2) != 0) {
            num2 = tVar.b;
        }
        if ((i & 4) != 0) {
            bool = tVar.c;
        }
        if ((i & 8) != 0) {
            a2 = tVar.d;
        }
        return tVar.a(num, num2, bool, a2);
    }

    public /* synthetic */ t(Integer num, Integer num2, Boolean bool, A a2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : num, (i & 2) != 0 ? null : num2, (i & 4) != 0 ? null : bool, (i & 8) != 0 ? null : a2);
    }
}
