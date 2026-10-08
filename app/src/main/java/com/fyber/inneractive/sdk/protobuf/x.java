package com.fyber.inneractive.sdk.protobuf;

import java.nio.charset.Charset;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class x implements s2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final w f1589a;
    public int b;
    public int c;
    public int d = 0;

    public x(w wVar) {
        Charset charset = l1.f1565a;
        if (wVar == null) {
            throw new NullPointerException("input");
        }
        this.f1589a = wVar;
        wVar.d = this;
    }

    public static void c(int i) throws n1 {
        if ((i & 3) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(Class cls, h0 h0Var) throws m1 {
        b(3);
        return c(p2.c.a(cls), h0Var);
    }

    public final void b(int i) throws m1 {
        if ((this.b & 7) == i) {
            return;
        }
        int i2 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int d() throws m1 {
        b(0);
        return this.f1589a.k();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int e() {
        return this.b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long f() throws m1 {
        b(0);
        return this.f1589a.v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long g() throws m1 {
        b(1);
        return this.f1589a.i();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final double h() throws m1 {
        b(1);
        return this.f1589a.f();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final boolean i() {
        int i;
        if (this.f1589a.c() || (i = this.b) == this.c) {
            return false;
        }
        return this.f1589a.e(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int j() throws m1 {
        b(0);
        return this.f1589a.p();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final float k() throws m1 {
        b(5);
        return this.f1589a.j();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long l() throws m1 {
        b(0);
        return this.f1589a.q();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int m() throws m1 {
        b(5);
        return this.f1589a.n();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String n() throws m1 {
        b(2);
        return this.f1589a.r();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long o() throws m1 {
        b(0);
        return this.f1589a.l();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String p() throws m1 {
        b(2);
        return this.f1589a.s();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int q() throws m1 {
        b(5);
        return this.f1589a.h();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final boolean r() throws m1 {
        b(0);
        return this.f1589a.d();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int s() {
        int i = this.d;
        if (i != 0) {
            this.b = i;
            this.d = 0;
        } else {
            this.b = this.f1589a.t();
        }
        int i2 = this.b;
        if (i2 == 0 || i2 == this.c) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long t() throws m1 {
        b(1);
        return this.f1589a.o();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void e(List list) throws n1 {
        int iT;
        int iT2;
        if (!(list instanceof a1)) {
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f1589a.u();
                c(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    list.add(Integer.valueOf(this.f1589a.h()));
                } while (this.f1589a.b() < iB);
                return;
            }
            if (i != 5) {
                int i2 = n1.f1569a;
                throw new m1();
            }
            do {
                list.add(Integer.valueOf(this.f1589a.h()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        a1 a1Var = (a1) list;
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            c(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                a1Var.c(this.f1589a.h());
            } while (this.f1589a.b() < iB2);
            return;
        }
        if (i3 != 5) {
            int i4 = n1.f1569a;
            throw new m1();
        }
        do {
            a1Var.c(this.f1589a.h());
            if (this.f1589a.c()) {
                return;
            } else {
                iT2 = this.f1589a.t();
            }
        } while (iT2 == this.b);
        this.d = iT2;
    }

    public static void d(int i) throws n1 {
        if ((i & 7) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    public final Object c(t2 t2Var, h0 h0Var) {
        int i = this.c;
        this.c = ((this.b >>> 3) << 3) | 4;
        try {
            Object objA = t2Var.a();
            t2Var.a(objA, this, h0Var);
            t2Var.c(objA);
            if (this.b == this.c) {
                return objA;
            }
            throw new n1("Failed to parse the message.");
        } finally {
            this.c = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void f(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f1589a.u();
                c(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    a1Var.c(this.f1589a.n());
                } while (this.f1589a.b() < iB);
                return;
            }
            if (i == 5) {
                do {
                    a1Var.c(this.f1589a.n());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            c(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                list.add(Integer.valueOf(this.f1589a.n()));
            } while (this.f1589a.b() < iB2);
            return;
        }
        if (i3 == 5) {
            do {
                list.add(Integer.valueOf(this.f1589a.n()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void g(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    u1Var.a(this.f1589a.q());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    u1Var.a(this.f1589a.q());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f1589a.q()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Long.valueOf(this.f1589a.q()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void h(List list) throws m1 {
        int iT;
        if ((this.b & 7) == 2) {
            do {
                b(2);
                list.add(this.f1589a.e());
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void j(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    d0Var.a(this.f1589a.f());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f1589a.u();
                d(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    d0Var.a(this.f1589a.f());
                } while (this.f1589a.b() < iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Double.valueOf(this.f1589a.f()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            d(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                list.add(Double.valueOf(this.f1589a.f()));
            } while (this.f1589a.b() < iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void k(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    u1Var.a(this.f1589a.l());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    u1Var.a(this.f1589a.l());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f1589a.l()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Long.valueOf(this.f1589a.l()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void l(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof j) {
            j jVar = (j) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    jVar.a(this.f1589a.d());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    jVar.a(this.f1589a.d());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Boolean.valueOf(this.f1589a.d()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Boolean.valueOf(this.f1589a.d()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void m(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    u1Var.a(this.f1589a.o());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f1589a.u();
                d(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    u1Var.a(this.f1589a.o());
                } while (this.f1589a.b() < iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.f1589a.o()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            d(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                list.add(Long.valueOf(this.f1589a.o()));
            } while (this.f1589a.b() < iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void n(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i = this.b & 7;
            if (i == 1) {
                do {
                    u1Var.a(this.f1589a.i());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iU = this.f1589a.u();
                d(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    u1Var.a(this.f1589a.i());
                } while (this.f1589a.b() < iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 1) {
            do {
                list.add(Long.valueOf(this.f1589a.i()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            d(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                list.add(Long.valueOf(this.f1589a.i()));
            } while (this.f1589a.b() < iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void o(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a1Var.c(this.f1589a.k());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    a1Var.c(this.f1589a.k());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f1589a.k()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Integer.valueOf(this.f1589a.k()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void p(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a1Var.c(this.f1589a.g());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    a1Var.c(this.f1589a.g());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f1589a.g()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Integer.valueOf(this.f1589a.g()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void q(List list) throws m1 {
        a(list, false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(t2 t2Var, h0 h0Var) throws m1 {
        b(3);
        return c(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(Class cls, h0 h0Var) throws m1 {
        b(2);
        return d(p2.c.a(cls), h0Var);
    }

    public final Object d(t2 t2Var, h0 h0Var) throws n1 {
        int iU = this.f1589a.u();
        w wVar = this.f1589a;
        if (wVar.f1584a < wVar.b) {
            int iD = wVar.d(iU);
            Object objA = t2Var.a();
            this.f1589a.f1584a++;
            t2Var.a(objA, this, h0Var);
            t2Var.c(objA);
            this.f1589a.a(0);
            r5.f1584a--;
            this.f1589a.c(iD);
            return objA;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void i(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a1Var.c(this.f1589a.u());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    a1Var.c(this.f1589a.u());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f1589a.u()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Integer.valueOf(this.f1589a.u()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final s a() throws m1 {
        b(2);
        return this.f1589a.e();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    u1Var.a(this.f1589a.v());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    u1Var.a(this.f1589a.v());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Long.valueOf(this.f1589a.v()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Long.valueOf(this.f1589a.v()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(t2 t2Var, h0 h0Var) throws m1 {
        b(2);
        return d(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int b() throws m1 {
        b(0);
        return this.f1589a.g();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list) throws m1 {
        a(list, true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list, t2 t2Var, h0 h0Var) throws m1 {
        int iT;
        int i = this.b;
        if ((i & 7) == 2) {
            do {
                list.add(d(t2Var, h0Var));
                if (this.f1589a.c() || this.d != 0) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == i);
            this.d = iT;
            return;
        }
        int i2 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void d(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof q0) {
            q0 q0Var = (q0) list;
            int i = this.b & 7;
            if (i == 2) {
                int iU = this.f1589a.u();
                c(iU);
                int iB = this.f1589a.b() + iU;
                do {
                    q0Var.a(this.f1589a.j());
                } while (this.f1589a.b() < iB);
                return;
            }
            if (i == 5) {
                do {
                    q0Var.a(this.f1589a.j());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 2) {
            int iU2 = this.f1589a.u();
            c(iU2);
            int iB2 = this.f1589a.b() + iU2;
            do {
                list.add(Float.valueOf(this.f1589a.j()));
            } while (this.f1589a.b() < iB2);
            return;
        }
        if (i3 == 5) {
            do {
                list.add(Float.valueOf(this.f1589a.j()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int c() throws m1 {
        b(0);
        return this.f1589a.u();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void c(List list) throws n1 {
        int iT;
        int iT2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i = this.b & 7;
            if (i == 0) {
                do {
                    a1Var.c(this.f1589a.p());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            if (i == 2) {
                int iB = this.f1589a.b() + this.f1589a.u();
                do {
                    a1Var.c(this.f1589a.p());
                } while (this.f1589a.b() < iB);
                a(iB);
                return;
            }
            int i2 = n1.f1569a;
            throw new m1();
        }
        int i3 = this.b & 7;
        if (i3 == 0) {
            do {
                list.add(Integer.valueOf(this.f1589a.p()));
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        if (i3 == 2) {
            int iB2 = this.f1589a.b() + this.f1589a.u();
            do {
                list.add(Integer.valueOf(this.f1589a.p()));
            } while (this.f1589a.b() < iB2);
            a(iB2);
            return;
        }
        int i4 = n1.f1569a;
        throw new m1();
    }

    public final void a(List list, boolean z) throws m1 {
        String strR;
        int iT;
        int iT2;
        if ((this.b & 7) == 2) {
            if ((list instanceof q1) && !z) {
                q1 q1Var = (q1) list;
                do {
                    b(2);
                    q1Var.a(this.f1589a.e());
                    if (this.f1589a.c()) {
                        return;
                    } else {
                        iT2 = this.f1589a.t();
                    }
                } while (iT2 == this.b);
                this.d = iT2;
                return;
            }
            do {
                if (z) {
                    b(2);
                    strR = this.f1589a.s();
                } else {
                    b(2);
                    strR = this.f1589a.r();
                }
                list.add(strR);
                if (this.f1589a.c()) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == this.b);
            this.d = iT;
            return;
        }
        int i = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list, t2 t2Var, h0 h0Var) throws m1 {
        int iT;
        int i = this.b;
        if ((i & 7) == 3) {
            do {
                list.add(c(t2Var, h0Var));
                if (this.f1589a.c() || this.d != 0) {
                    return;
                } else {
                    iT = this.f1589a.t();
                }
            } while (iT == i);
            this.d = iT;
            return;
        }
        int i2 = n1.f1569a;
        throw new m1();
    }

    public final void a(int i) throws n1 {
        if (this.f1589a.b() != i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
