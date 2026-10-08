package com.moloco.sdk.internal.services;

/* JADX INFO: loaded from: classes6.dex */
public final class E {
    public static final int i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f2283a;
    public final float b;
    public final int c;
    public final float d;
    public final float e;
    public final int f;
    public final float g;
    public final float h;

    public E(int i2, float f, int i3, float f2, float f3, int i4, float f4, float f5) {
        this.f2283a = i2;
        this.b = f;
        this.c = i3;
        this.d = f2;
        this.e = f3;
        this.f = i4;
        this.g = f4;
        this.h = f5;
    }

    public final int a() {
        return this.f2283a;
    }

    public final float b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final float d() {
        return this.d;
    }

    public final float e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return false;
        }
        E e = (E) obj;
        return this.f2283a == e.f2283a && Float.compare(this.b, e.b) == 0 && this.c == e.c && Float.compare(this.d, e.d) == 0 && Float.compare(this.e, e.e) == 0 && this.f == e.f && Float.compare(this.g, e.g) == 0 && Float.compare(this.h, e.h) == 0;
    }

    public final int f() {
        return this.f;
    }

    public final float g() {
        return this.g;
    }

    public final float h() {
        return this.h;
    }

    public int hashCode() {
        return (((((((((((((this.f2283a * 31) + Float.floatToIntBits(this.b)) * 31) + this.c) * 31) + Float.floatToIntBits(this.d)) * 31) + Float.floatToIntBits(this.e)) * 31) + this.f) * 31) + Float.floatToIntBits(this.g)) * 31) + Float.floatToIntBits(this.h);
    }

    public final float i() {
        return this.e;
    }

    public final int j() {
        return this.f;
    }

    public final float k() {
        return this.d;
    }

    public final int l() {
        return this.c;
    }

    public final float m() {
        return this.b;
    }

    public final int n() {
        return this.f2283a;
    }

    public final float o() {
        return this.g;
    }

    public final float p() {
        return this.h;
    }

    public String toString() {
        return "ScreenInfo(screenWidthPx=" + this.f2283a + ", screenWidthDp=" + this.b + ", screenHeightPx=" + this.c + ", screenHeightDp=" + this.d + ", density=" + this.e + ", dpi=" + this.f + ", xdpi=" + this.g + ", ydpi=" + this.h + ')';
    }

    public final E a(int i2, float f, int i3, float f2, float f3, int i4, float f4, float f5) {
        return new E(i2, f, i3, f2, f3, i4, f4, f5);
    }
}
