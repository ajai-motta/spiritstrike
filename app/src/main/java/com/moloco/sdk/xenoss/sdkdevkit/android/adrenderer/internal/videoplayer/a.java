package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.videoplayer;

import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes6.dex */
public final class a {
    public static final int d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f2990a;
    public final boolean b;
    public final boolean c;

    public a(boolean z, boolean z2, boolean z3) {
        this.f2990a = z;
        this.b = z2;
        this.c = z3;
    }

    public final boolean a() {
        return this.f2990a;
    }

    public final boolean b() {
        return this.b;
    }

    public final boolean c() {
        return this.c;
    }

    public final boolean d() {
        return this.c;
    }

    public final boolean e() {
        return this.f2990a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f2990a == aVar.f2990a && this.b == aVar.b && this.c == aVar.c;
    }

    public final boolean f() {
        return this.b;
    }

    public int hashCode() {
        return (((UByte$$ExternalSyntheticBackport0.m(this.f2990a) * 31) + UByte$$ExternalSyntheticBackport0.m(this.b)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.c);
    }

    public String toString() {
        return "PlayingState(isPlaying=" + this.f2990a + ", isVisible=" + this.b + ", hasMore=" + this.c + ')';
    }

    public final a a(boolean z, boolean z2, boolean z3) {
        return new a(z, z2, z3);
    }

    public static /* synthetic */ a a(a aVar, boolean z, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            z = aVar.f2990a;
        }
        if ((i & 2) != 0) {
            z2 = aVar.b;
        }
        if ((i & 4) != 0) {
            z3 = aVar.c;
        }
        return aVar.a(z, z2, z3);
    }

    public /* synthetic */ a(boolean z, boolean z2, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? true : z2, (i & 4) != 0 ? true : z3);
    }
}
