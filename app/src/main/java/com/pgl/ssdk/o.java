package com.pgl.ssdk;

/* JADX INFO: loaded from: classes6.dex */
public final class o<A, B> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final A f3087a;
    private final B b;

    public o(A a2, B b) {
        this.f3087a = a2;
        this.b = b;
    }

    public static <A, B> o<A, B> a(A a2, B b) {
        return new o<>(a2, b);
    }

    public B b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || o.class != obj.getClass()) {
            return false;
        }
        o oVar = (o) obj;
        A a2 = this.f3087a;
        if (a2 == null) {
            if (oVar.f3087a != null) {
                return false;
            }
        } else if (!a2.equals(oVar.f3087a)) {
            return false;
        }
        B b = this.b;
        if (b == null) {
            if (oVar.b != null) {
                return false;
            }
        } else if (!b.equals(oVar.b)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        A a2 = this.f3087a;
        int iHashCode = ((a2 == null ? 0 : a2.hashCode()) + 31) * 31;
        B b = this.b;
        return iHashCode + (b != null ? b.hashCode() : 0);
    }

    public A a() {
        return this.f3087a;
    }
}
