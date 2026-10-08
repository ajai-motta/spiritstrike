package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3028i;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final int f = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f2846a;
    public final c b;
    public final List<String> c;
    public final List<String> d;
    public final C3028i e;

    public a(f linear, c cVar, List<String> impressionTracking, List<String> errorTracking, C3028i c3028i) {
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(impressionTracking, "impressionTracking");
        Intrinsics.checkNotNullParameter(errorTracking, "errorTracking");
        this.f2846a = linear;
        this.b = cVar;
        this.c = impressionTracking;
        this.d = errorTracking;
        this.e = c3028i;
    }

    public final f a() {
        return this.f2846a;
    }

    public final c b() {
        return this.b;
    }

    public final List<String> c() {
        return this.c;
    }

    public final List<String> d() {
        return this.d;
    }

    public final C3028i e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return Intrinsics.areEqual(this.f2846a, aVar.f2846a) && Intrinsics.areEqual(this.b, aVar.b) && Intrinsics.areEqual(this.c, aVar.c) && Intrinsics.areEqual(this.d, aVar.d) && Intrinsics.areEqual(this.e, aVar.e);
    }

    public final c f() {
        return this.b;
    }

    public final C3028i g() {
        return this.e;
    }

    public final List<String> h() {
        return this.d;
    }

    public int hashCode() {
        int iHashCode = this.f2846a.hashCode() * 31;
        c cVar = this.b;
        int iHashCode2 = (((((iHashCode + (cVar == null ? 0 : cVar.hashCode())) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        C3028i c3028i = this.e;
        return iHashCode2 + (c3028i != null ? c3028i.hashCode() : 0);
    }

    public final List<String> i() {
        return this.c;
    }

    public final f j() {
        return this.f2846a;
    }

    public String toString() {
        return "Ad(linear=" + this.f2846a + ", companion=" + this.b + ", impressionTracking=" + this.c + ", errorTracking=" + this.d + ", dec=" + this.e + ')';
    }

    public final a a(f linear, c cVar, List<String> impressionTracking, List<String> errorTracking, C3028i c3028i) {
        Intrinsics.checkNotNullParameter(linear, "linear");
        Intrinsics.checkNotNullParameter(impressionTracking, "impressionTracking");
        Intrinsics.checkNotNullParameter(errorTracking, "errorTracking");
        return new a(linear, cVar, impressionTracking, errorTracking, c3028i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ a a(a aVar, f fVar, c cVar, List list, List list2, C3028i c3028i, int i, Object obj) {
        if ((i & 1) != 0) {
            fVar = aVar.f2846a;
        }
        if ((i & 2) != 0) {
            cVar = aVar.b;
        }
        c cVar2 = cVar;
        if ((i & 4) != 0) {
            list = aVar.c;
        }
        List list3 = list;
        if ((i & 8) != 0) {
            list2 = aVar.d;
        }
        List list4 = list2;
        if ((i & 16) != 0) {
            c3028i = aVar.e;
        }
        return aVar.a(fVar, cVar2, list3, list4, c3028i);
    }

    public /* synthetic */ a(f fVar, c cVar, List list, List list2, C3028i c3028i, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(fVar, cVar, list, list2, (i & 16) != 0 ? null : c3028i);
    }
}
