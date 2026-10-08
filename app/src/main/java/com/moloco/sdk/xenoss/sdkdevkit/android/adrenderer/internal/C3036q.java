package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.q, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3036q {
    public static final int e = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2606a;
    public final C3031l b;
    public final C3029j c;
    public final C3035p d;

    public C3036q(Integer num, C3031l c3031l, C3029j c3029j, C3035p c3035p) {
        this.f2606a = num;
        this.b = c3031l;
        this.c = c3029j;
        this.d = c3035p;
    }

    public final Integer a() {
        return this.f2606a;
    }

    public final C3031l b() {
        return this.b;
    }

    public final C3029j c() {
        return this.c;
    }

    public final C3035p d() {
        return this.d;
    }

    public final Integer e() {
        return this.f2606a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3036q)) {
            return false;
        }
        C3036q c3036q = (C3036q) obj;
        return Intrinsics.areEqual(this.f2606a, c3036q.f2606a) && Intrinsics.areEqual(this.b, c3036q.b) && Intrinsics.areEqual(this.c, c3036q.c) && Intrinsics.areEqual(this.d, c3036q.d);
    }

    public final C3029j f() {
        return this.c;
    }

    public final C3031l g() {
        return this.b;
    }

    public final C3035p h() {
        return this.d;
    }

    public int hashCode() {
        Integer num = this.f2606a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        C3031l c3031l = this.b;
        int iHashCode2 = (iHashCode + (c3031l == null ? 0 : c3031l.hashCode())) * 31;
        C3029j c3029j = this.c;
        int iHashCode3 = (iHashCode2 + (c3029j == null ? 0 : c3029j.hashCode())) * 31;
        C3035p c3035p = this.d;
        return iHashCode3 + (c3035p != null ? c3035p.hashCode() : 0);
    }

    public String toString() {
        return "DECRenderingData(appNameFontSize=" + this.f2606a + ", decCTA=" + this.b + ", decAppIcon=" + this.c + ", decRating=" + this.d + ')';
    }

    public final C3036q a(Integer num, C3031l c3031l, C3029j c3029j, C3035p c3035p) {
        return new C3036q(num, c3031l, c3029j, c3035p);
    }

    public static /* synthetic */ C3036q a(C3036q c3036q, Integer num, C3031l c3031l, C3029j c3029j, C3035p c3035p, int i, Object obj) {
        if ((i & 1) != 0) {
            num = c3036q.f2606a;
        }
        if ((i & 2) != 0) {
            c3031l = c3036q.b;
        }
        if ((i & 4) != 0) {
            c3029j = c3036q.c;
        }
        if ((i & 8) != 0) {
            c3035p = c3036q.d;
        }
        return c3036q.a(num, c3031l, c3029j, c3035p);
    }
}
