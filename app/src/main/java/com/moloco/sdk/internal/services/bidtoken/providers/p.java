package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class p {
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2322a;
    public final long b;
    public final long c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public p(String sessionId, long j, long j2, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        this.f2322a = sessionId;
        this.b = j;
        this.c = j2;
        this.d = i2;
        this.e = i3;
        this.f = i4;
        this.g = i5;
        this.h = i6;
    }

    public final String a() {
        return this.f2322a;
    }

    public final long b() {
        return this.b;
    }

    public final long c() {
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
        if (!(obj instanceof p)) {
            return false;
        }
        p pVar = (p) obj;
        return Intrinsics.areEqual(this.f2322a, pVar.f2322a) && this.b == pVar.b && this.c == pVar.c && this.d == pVar.d && this.e == pVar.e && this.f == pVar.f && this.g == pVar.g && this.h == pVar.h;
    }

    public final int f() {
        return this.f;
    }

    public final int g() {
        return this.g;
    }

    public final int h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((this.f2322a.hashCode() * 31) + UByte$$ExternalSyntheticBackport0.m(this.b)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.c)) * 31) + this.d) * 31) + this.e) * 31) + this.f) * 31) + this.g) * 31) + this.h;
    }

    public final int i() {
        return this.d;
    }

    public final int j() {
        return this.g;
    }

    public final long k() {
        return this.c;
    }

    public final int l() {
        return this.e;
    }

    public final int m() {
        return this.f;
    }

    public final int n() {
        return this.h;
    }

    public final String o() {
        return this.f2322a;
    }

    public final long p() {
        return this.b;
    }

    public final boolean q() {
        return this.f2322a.length() > 0;
    }

    public String toString() {
        return "IlrdSignal(sessionId=" + this.f2322a + ", sessionStartTs=" + this.b + ", lastImpressionTs=" + this.c + ", bannerImpressionCount=" + this.d + ", mrecImpressionCount=" + this.e + ", nativeImpressionCount=" + this.f + ", interstitialImpressionCount=" + this.g + ", rewardedImpressionCount=" + this.h + ')';
    }

    public final p a(String sessionId, long j, long j2, int i2, int i3, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(sessionId, "sessionId");
        return new p(sessionId, j, j2, i2, i3, i4, i5, i6);
    }
}
