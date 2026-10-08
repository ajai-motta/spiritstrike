package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: renamed from: com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.i, reason: case insensitive filesystem */
/* JADX INFO: loaded from: classes6.dex */
public final class C3028i {
    public static final int j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2530a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final Integer f;
    public final C3031l g;
    public final C3029j h;
    public final C3035p i;

    public C3028i(String str, String str2, String str3, String str4, String str5, Integer num, C3031l c3031l, C3029j c3029j, C3035p c3035p) {
        this.f2530a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = num;
        this.g = c3031l;
        this.h = c3029j;
        this.i = c3035p;
    }

    public final String a() {
        return this.f2530a;
    }

    public final String b() {
        return this.b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3028i)) {
            return false;
        }
        C3028i c3028i = (C3028i) obj;
        return Intrinsics.areEqual(this.f2530a, c3028i.f2530a) && Intrinsics.areEqual(this.b, c3028i.b) && Intrinsics.areEqual(this.c, c3028i.c) && Intrinsics.areEqual(this.d, c3028i.d) && Intrinsics.areEqual(this.e, c3028i.e) && Intrinsics.areEqual(this.f, c3028i.f) && Intrinsics.areEqual(this.g, c3028i.g) && Intrinsics.areEqual(this.h, c3028i.h) && Intrinsics.areEqual(this.i, c3028i.i);
    }

    public final Integer f() {
        return this.f;
    }

    public final C3031l g() {
        return this.g;
    }

    public final C3029j h() {
        return this.h;
    }

    public int hashCode() {
        String str = this.f2530a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.b;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.c;
        int iHashCode3 = (iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.d;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.e;
        int iHashCode5 = (iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.f;
        int iHashCode6 = (iHashCode5 + (num == null ? 0 : num.hashCode())) * 31;
        C3031l c3031l = this.g;
        int iHashCode7 = (iHashCode6 + (c3031l == null ? 0 : c3031l.hashCode())) * 31;
        C3029j c3029j = this.h;
        int iHashCode8 = (iHashCode7 + (c3029j == null ? 0 : c3029j.hashCode())) * 31;
        C3035p c3035p = this.i;
        return iHashCode8 + (c3035p != null ? c3035p.hashCode() : 0);
    }

    public final C3035p i() {
        return this.i;
    }

    public final String j() {
        return this.f2530a;
    }

    public final Integer k() {
        return this.f;
    }

    public final String l() {
        return this.c;
    }

    public final String m() {
        return this.b;
    }

    public final C3029j n() {
        return this.h;
    }

    public final C3031l o() {
        return this.g;
    }

    public final C3035p p() {
        return this.i;
    }

    public final String q() {
        return this.d;
    }

    public final String r() {
        return this.e;
    }

    public String toString() {
        return "DEC(appName=" + this.f2530a + ", ctaUrl=" + this.b + ", ctaTrackingUrl=" + this.c + ", impressionTrackingUrl=" + this.d + ", skipToDECTrackingUrl=" + this.e + ", appNameFontSize=" + this.f + ", decCta=" + this.g + ", decAppIcon=" + this.h + ", decRating=" + this.i + ')';
    }

    public final C3028i a(String str, String str2, String str3, String str4, String str5, Integer num, C3031l c3031l, C3029j c3029j, C3035p c3035p) {
        return new C3028i(str, str2, str3, str4, str5, num, c3031l, c3029j, c3035p);
    }
}
