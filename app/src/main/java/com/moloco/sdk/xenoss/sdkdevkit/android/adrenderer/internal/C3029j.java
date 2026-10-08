package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.j, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3029j {
    public static final int d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2531a;
    public final String b;
    public final C3030k c;

    public C3029j(Integer num, String str, C3030k c3030k) {
        this.f2531a = num;
        this.b = str;
        this.c = c3030k;
    }

    public final Integer a() {
        return this.f2531a;
    }

    public final String b() {
        return this.b;
    }

    public final C3030k c() {
        return this.c;
    }

    public final String d() {
        return this.b;
    }

    public final C3030k e() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3029j)) {
            return false;
        }
        C3029j c3029j = (C3029j) obj;
        return Intrinsics.areEqual(this.f2531a, c3029j.f2531a) && Intrinsics.areEqual(this.b, c3029j.b) && Intrinsics.areEqual(this.c, c3029j.c);
    }

    public final Integer f() {
        return this.f2531a;
    }

    public int hashCode() {
        Integer num = this.f2531a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        C3030k c3030k = this.c;
        return iHashCode2 + (c3030k != null ? c3030k.hashCode() : 0);
    }

    public String toString() {
        return "DECAppIcon(size=" + this.f2531a + ", appIconUri=" + this.b + ", border=" + this.c + ')';
    }

    public final C3029j a(Integer num, String str, C3030k c3030k) {
        return new C3029j(num, str, c3030k);
    }

    public static /* synthetic */ C3029j a(C3029j c3029j, Integer num, String str, C3030k c3030k, int i, Object obj) {
        if ((i & 1) != 0) {
            num = c3029j.f2531a;
        }
        if ((i & 2) != 0) {
            str = c3029j.b;
        }
        if ((i & 4) != 0) {
            c3030k = c3029j.c;
        }
        return c3029j.a(num, str, c3030k);
    }
}
