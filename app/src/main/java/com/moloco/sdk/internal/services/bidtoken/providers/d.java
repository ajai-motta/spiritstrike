package com.moloco.sdk.internal.services.bidtoken.providers;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class d {
    public static final int b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Long f2315a;

    public d(Long l) {
        this.f2315a = l;
    }

    public final Long a() {
        return this.f2315a;
    }

    public final Long b() {
        return this.f2315a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && Intrinsics.areEqual(this.f2315a, ((d) obj).f2315a);
    }

    public int hashCode() {
        Long l = this.f2315a;
        if (l == null) {
            return 0;
        }
        return l.hashCode();
    }

    public String toString() {
        return "AppDirInfo(appDirSize=" + this.f2315a + ')';
    }

    public final d a(Long l) {
        return new d(l);
    }

    public static /* synthetic */ d a(d dVar, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = dVar.f2315a;
        }
        return dVar.a(l);
    }
}
