package com.moloco.sdk.internal.services;

import kotlin.UByte$$ExternalSyntheticBackport0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
public final class x {
    public static final int n = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f2401a;
    public final String b;
    public final String c;
    public final boolean d;
    public final String e;
    public final String f;
    public final int g;
    public final String h;
    public final String i;
    public final float j;
    public final long k;
    public final String l;
    public final String m;

    public x(String manufacturer, String model, String hwVersion, boolean z, String os, String osVersion, int i, String language, String mobileCarrier, float f, long j, String hardware, String brand) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(mobileCarrier, "mobileCarrier");
        Intrinsics.checkNotNullParameter(hardware, "hardware");
        Intrinsics.checkNotNullParameter(brand, "brand");
        this.f2401a = manufacturer;
        this.b = model;
        this.c = hwVersion;
        this.d = z;
        this.e = os;
        this.f = osVersion;
        this.g = i;
        this.h = language;
        this.i = mobileCarrier;
        this.j = f;
        this.k = j;
        this.l = hardware;
        this.m = brand;
    }

    public final String a() {
        return this.f2401a;
    }

    public final float b() {
        return this.j;
    }

    public final long c() {
        return this.k;
    }

    public final String d() {
        return this.l;
    }

    public final String e() {
        return this.m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof x)) {
            return false;
        }
        x xVar = (x) obj;
        return Intrinsics.areEqual(this.f2401a, xVar.f2401a) && Intrinsics.areEqual(this.b, xVar.b) && Intrinsics.areEqual(this.c, xVar.c) && this.d == xVar.d && Intrinsics.areEqual(this.e, xVar.e) && Intrinsics.areEqual(this.f, xVar.f) && this.g == xVar.g && Intrinsics.areEqual(this.h, xVar.h) && Intrinsics.areEqual(this.i, xVar.i) && Float.compare(this.j, xVar.j) == 0 && this.k == xVar.k && Intrinsics.areEqual(this.l, xVar.l) && Intrinsics.areEqual(this.m, xVar.m);
    }

    public final String f() {
        return this.b;
    }

    public final String g() {
        return this.c;
    }

    public final boolean h() {
        return this.d;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f2401a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + UByte$$ExternalSyntheticBackport0.m(this.d)) * 31) + this.e.hashCode()) * 31) + this.f.hashCode()) * 31) + this.g) * 31) + this.h.hashCode()) * 31) + this.i.hashCode()) * 31) + Float.floatToIntBits(this.j)) * 31) + UByte$$ExternalSyntheticBackport0.m(this.k)) * 31) + this.l.hashCode()) * 31) + this.m.hashCode();
    }

    public final String i() {
        return this.e;
    }

    public final String j() {
        return this.f;
    }

    public final int k() {
        return this.g;
    }

    public final String l() {
        return this.h;
    }

    public final String m() {
        return this.i;
    }

    public final int n() {
        return this.g;
    }

    public final String o() {
        return this.m;
    }

    public final long p() {
        return this.k;
    }

    public final String q() {
        return this.l;
    }

    public final String r() {
        return this.c;
    }

    public final String s() {
        return this.h;
    }

    public final String t() {
        return this.f2401a;
    }

    public String toString() {
        return "DeviceInfo(manufacturer=" + this.f2401a + ", model=" + this.b + ", hwVersion=" + this.c + ", isTablet=" + this.d + ", os=" + this.e + ", osVersion=" + this.f + ", apiLevel=" + this.g + ", language=" + this.h + ", mobileCarrier=" + this.i + ", screenDensity=" + this.j + ", dbtMs=" + this.k + ", hardware=" + this.l + ", brand=" + this.m + ')';
    }

    public final String u() {
        return this.i;
    }

    public final String v() {
        return this.b;
    }

    public final String w() {
        return this.e;
    }

    public final String x() {
        return this.f;
    }

    public final float y() {
        return this.j;
    }

    public final boolean z() {
        return this.d;
    }

    public final x a(String manufacturer, String model, String hwVersion, boolean z, String os, String osVersion, int i, String language, String mobileCarrier, float f, long j, String hardware, String brand) {
        Intrinsics.checkNotNullParameter(manufacturer, "manufacturer");
        Intrinsics.checkNotNullParameter(model, "model");
        Intrinsics.checkNotNullParameter(hwVersion, "hwVersion");
        Intrinsics.checkNotNullParameter(os, "os");
        Intrinsics.checkNotNullParameter(osVersion, "osVersion");
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(mobileCarrier, "mobileCarrier");
        Intrinsics.checkNotNullParameter(hardware, "hardware");
        Intrinsics.checkNotNullParameter(brand, "brand");
        return new x(manufacturer, model, hwVersion, z, os, osVersion, i, language, mobileCarrier, f, j, hardware, brand);
    }
}
