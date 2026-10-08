package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.C3028i;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class c {
    public static final int b = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final C3028i f2568a;

    public c() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public final C3028i a() {
        return this.f2568a;
    }

    public final C3028i b() {
        return this.f2568a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && Intrinsics.areEqual(this.f2568a, ((c) obj).f2568a);
    }

    public int hashCode() {
        C3028i c3028i = this.f2568a;
        if (c3028i == null) {
            return 0;
        }
        return c3028i.hashCode();
    }

    public String toString() {
        return "MraidAdData(dec=" + this.f2568a + ')';
    }

    public c(C3028i c3028i) {
        this.f2568a = c3028i;
    }

    public final c a(C3028i c3028i) {
        return new c(c3028i);
    }

    public static /* synthetic */ c a(c cVar, C3028i c3028i, int i, Object obj) {
        if ((i & 1) != 0) {
            c3028i = cVar.f2568a;
        }
        return cVar.a(c3028i);
    }

    public /* synthetic */ c(C3028i c3028i, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : c3028i);
    }
}
