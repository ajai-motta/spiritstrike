package com.moloco.sdk.internal.services.bidtoken;

import kotlin.UByte$$ExternalSyntheticBackport0;

/* JADX INFO: loaded from: classes6.dex */
public final class f {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2302a;

    public f(boolean z) {
        this.f2302a = z;
    }

    public final boolean a() {
        return this.f2302a;
    }

    public final boolean b() {
        return this.f2302a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof f) && this.f2302a == ((f) obj).f2302a;
    }

    public int hashCode() {
        return UByte$$ExternalSyntheticBackport0.m(this.f2302a);
    }

    public String toString() {
        return "BidTokenConfig(dbtEnabled=" + this.f2302a + ')';
    }

    public final f a(boolean z) {
        return new f(z);
    }

    public static /* synthetic */ f a(f fVar, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fVar.f2302a;
        }
        return fVar.a(z);
    }
}
