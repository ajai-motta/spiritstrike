package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.p, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3035p {
    public static final int f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Float f2605a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;

    public C3035p(Float f2, String foregroundColor, String backgroundColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(foregroundColor, "foregroundColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        this.f2605a = f2;
        this.b = foregroundColor;
        this.c = backgroundColor;
        this.d = i;
        this.e = i2;
    }

    public final Float a() {
        return this.f2605a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final int e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3035p)) {
            return false;
        }
        C3035p c3035p = (C3035p) obj;
        return Intrinsics.areEqual((Object) this.f2605a, (Object) c3035p.f2605a) && Intrinsics.areEqual(this.b, c3035p.b) && Intrinsics.areEqual(this.c, c3035p.c) && this.d == c3035p.d && this.e == c3035p.e;
    }

    public final String f() {
        return this.c;
    }

    public final int g() {
        return this.e;
    }

    public final String h() {
        return this.b;
    }

    public int hashCode() {
        Float f2 = this.f2605a;
        return ((((((((f2 == null ? 0 : f2.hashCode()) * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e;
    }

    public final int i() {
        return this.d;
    }

    public final Float j() {
        return this.f2605a;
    }

    public String toString() {
        return "DECRating(value=" + this.f2605a + ", foregroundColor=" + this.b + ", backgroundColor=" + this.c + ", size=" + this.d + ", fontSize=" + this.e + ')';
    }

    public final C3035p a(Float f2, String foregroundColor, String backgroundColor, int i, int i2) {
        Intrinsics.checkNotNullParameter(foregroundColor, "foregroundColor");
        Intrinsics.checkNotNullParameter(backgroundColor, "backgroundColor");
        return new C3035p(f2, foregroundColor, backgroundColor, i, i2);
    }

    public static /* synthetic */ C3035p a(C3035p c3035p, Float f2, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f2 = c3035p.f2605a;
        }
        if ((i3 & 2) != 0) {
            str = c3035p.b;
        }
        String str3 = str;
        if ((i3 & 4) != 0) {
            str2 = c3035p.c;
        }
        String str4 = str2;
        if ((i3 & 8) != 0) {
            i = c3035p.d;
        }
        int i4 = i;
        if ((i3 & 16) != 0) {
            i2 = c3035p.e;
        }
        return c3035p.a(f2, str3, str4, i4, i2);
    }
}
