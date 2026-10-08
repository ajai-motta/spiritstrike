package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.l, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3031l {
    public static final int h = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Integer f2533a;
    public final String b;
    public final Integer c;
    public final Integer d;
    public final C3030k e;
    public final String f;
    public final String g;

    public C3031l(Integer num, String str, Integer num2, Integer num3, C3030k c3030k, String str2, String str3) {
        this.f2533a = num;
        this.b = str;
        this.c = num2;
        this.d = num3;
        this.e = c3030k;
        this.f = str2;
        this.g = str3;
    }

    public final Integer a() {
        return this.f2533a;
    }

    public final String b() {
        return this.b;
    }

    public final Integer c() {
        return this.c;
    }

    public final Integer d() {
        return this.d;
    }

    public final C3030k e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3031l)) {
            return false;
        }
        C3031l c3031l = (C3031l) obj;
        return Intrinsics.areEqual(this.f2533a, c3031l.f2533a) && Intrinsics.areEqual(this.b, c3031l.b) && Intrinsics.areEqual(this.c, c3031l.c) && Intrinsics.areEqual(this.d, c3031l.d) && Intrinsics.areEqual(this.e, c3031l.e) && Intrinsics.areEqual(this.f, c3031l.f) && Intrinsics.areEqual(this.g, c3031l.g);
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final String h() {
        return this.g;
    }

    public int hashCode() {
        Integer num = this.f2533a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.c;
        int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.d;
        int iHashCode4 = (iHashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        C3030k c3030k = this.e;
        int iHashCode5 = (iHashCode4 + (c3030k == null ? 0 : c3030k.hashCode())) * 31;
        String str2 = this.f;
        int iHashCode6 = (iHashCode5 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.g;
        return iHashCode6 + (str3 != null ? str3.hashCode() : 0);
    }

    public final C3030k i() {
        return this.e;
    }

    public final Integer j() {
        return this.c;
    }

    public final String k() {
        return this.b;
    }

    public final Integer l() {
        return this.d;
    }

    public final String m() {
        return this.f;
    }

    public final Integer n() {
        return this.f2533a;
    }

    public String toString() {
        return "DECCta(verticalSpacing=" + this.f2533a + ", ctaText=" + this.b + ", buttonWidth=" + this.c + ", fontSize=" + this.d + ", border=" + this.e + ", foregroundColor=" + this.f + ", backgroundColor=" + this.g + ')';
    }

    public final C3031l a(Integer num, String str, Integer num2, Integer num3, C3030k c3030k, String str2, String str3) {
        return new C3031l(num, str, num2, num3, c3030k, str2, str3);
    }

    public static /* synthetic */ C3031l a(C3031l c3031l, Integer num, String str, Integer num2, Integer num3, C3030k c3030k, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            num = c3031l.f2533a;
        }
        if ((i & 2) != 0) {
            str = c3031l.b;
        }
        String str4 = str;
        if ((i & 4) != 0) {
            num2 = c3031l.c;
        }
        Integer num4 = num2;
        if ((i & 8) != 0) {
            num3 = c3031l.d;
        }
        Integer num5 = num3;
        if ((i & 16) != 0) {
            c3030k = c3031l.e;
        }
        C3030k c3030k2 = c3030k;
        if ((i & 32) != 0) {
            str2 = c3031l.f;
        }
        String str5 = str2;
        if ((i & 64) != 0) {
            str3 = c3031l.g;
        }
        return c3031l.a(num, str4, num4, num5, c3030k2, str5, str3);
    }
}
