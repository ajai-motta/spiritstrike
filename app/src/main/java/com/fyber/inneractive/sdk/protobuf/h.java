package com.fyber.inneractive.sdk.protobuf;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public final class h extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f1555a = true;
    public final byte[] b;
    public int c;
    public int d;
    public int e;
    public int f;

    public h(ByteBuffer byteBuffer) {
        this.b = byteBuffer.array();
        this.c = byteBuffer.position() + byteBuffer.arrayOffset();
        this.d = byteBuffer.limit() + byteBuffer.arrayOffset();
    }

    public final String a(boolean z) throws n1 {
        c(2);
        int iX = x();
        if (iX == 0) {
            return "";
        }
        a(iX);
        if (z) {
            byte[] bArr = this.b;
            int i = this.c;
            if (!d4.f1547a.b(bArr, i, i + iX)) {
                throw new n1("Protocol message had invalid UTF-8.");
            }
        }
        String str = new String(this.b, this.c, iX, l1.f1565a);
        this.c += iX;
        return str;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(Class cls, h0 h0Var) throws m1 {
        c(2);
        return d(p2.c.a(cls), h0Var);
    }

    public final Object c(t2 t2Var, h0 h0Var) {
        int i = this.f;
        this.f = ((this.e >>> 3) << 3) | 4;
        try {
            Object objA = t2Var.a();
            t2Var.a(objA, this, h0Var);
            t2Var.c(objA);
            if (this.e == this.f) {
                return objA;
            }
            throw new n1("Failed to parse the message.");
        } finally {
            this.f = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int d() throws m1 {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int e() {
        return this.e;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long f() throws m1 {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long g() throws n1 {
        c(1);
        a(8);
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final double h() throws n1 {
        c(1);
        a(8);
        return Double.longBitsToDouble(w());
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x008b  */
    @Override // com.fyber.inneractive.sdk.protobuf.s2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean i() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            r7 = this;
            boolean r0 = r7.u()
            r1 = 0
            if (r0 != 0) goto Laf
            int r0 = r7.e
            int r2 = r7.f
            if (r0 != r2) goto Lf
            goto Laf
        Lf:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L6e
            if (r3 == r4) goto L63
            r1 = 2
            if (r3 == r1) goto L56
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L31
            r0 = 5
            if (r3 != r0) goto L29
            r7.a(r1)
            int r0 = r7.c
            int r0 = r0 + r1
            r7.c = r0
            return r4
        L29:
            int r0 = com.fyber.inneractive.sdk.protobuf.n1.f1569a
            com.fyber.inneractive.sdk.protobuf.m1 r0 = new com.fyber.inneractive.sdk.protobuf.m1
            r0.<init>()
            throw r0
        L31:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.f = r0
        L36:
            int r0 = r7.s()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L45
            boolean r0 = r7.i()
            if (r0 != 0) goto L36
        L45:
            int r0 = r7.e
            int r1 = r7.f
            if (r0 != r1) goto L4e
            r7.f = r2
            return r4
        L4e:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "Failed to parse the message."
            r0.<init>(r1)
            throw r0
        L56:
            int r0 = r7.x()
            r7.a(r0)
            int r1 = r7.c
            int r1 = r1 + r0
            r7.c = r1
            return r4
        L63:
            r0 = 8
            r7.a(r0)
            int r1 = r7.c
            int r1 = r1 + r0
            r7.c = r1
            return r4
        L6e:
            int r0 = r7.d
            int r2 = r7.c
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L89
            byte[] r0 = r7.b
            r5 = r1
        L7a:
            if (r5 >= r3) goto L89
            int r6 = r2 + 1
            r2 = r0[r2]
            if (r2 < 0) goto L85
            r7.c = r6
            goto L9b
        L85:
            int r5 = r5 + 1
            r2 = r6
            goto L7a
        L89:
            if (r1 >= r3) goto La7
            int r0 = r7.c
            int r2 = r7.d
            if (r0 == r2) goto L9f
            byte[] r2 = r7.b
            int r5 = r0 + 1
            r7.c = r5
            r0 = r2[r0]
            if (r0 < 0) goto L9c
        L9b:
            return r4
        L9c:
            int r1 = r1 + 1
            goto L89
        L9f:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r0.<init>(r1)
            throw r0
        La7:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "CodedInputStream encountered a malformed varint."
            r0.<init>(r1)
            throw r0
        Laf:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.h.i():boolean");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int j() throws m1 {
        c(0);
        return w.b(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final float k() throws n1 {
        c(5);
        a(4);
        return Float.intBitsToFloat(v());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long l() throws m1 {
        c(0);
        return w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int m() throws n1 {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String n() {
        return a(false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long o() throws m1 {
        c(0);
        return y();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final String p() {
        return a(true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int q() throws n1 {
        c(5);
        a(4);
        return v();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final boolean r() throws m1 {
        c(0);
        return x() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int s() throws n1 {
        if (u()) {
            return Integer.MAX_VALUE;
        }
        int iX = x();
        this.e = iX;
        if (iX == this.f) {
            return Integer.MAX_VALUE;
        }
        return iX >>> 3;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final long t() throws n1 {
        c(1);
        a(8);
        return w();
    }

    public final boolean u() {
        return this.c == this.d;
    }

    public final int v() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long w() {
        int i = this.c;
        byte[] bArr = this.b;
        this.c = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a4 A[PHI: r2
  0x00a4: PHI (r2v7 int) = (r2v6 int), (r2v9 int) binds: [B:37:0x0082, B:41:0x008e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int x() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            r9 = this;
            int r0 = r9.c
            int r1 = r9.d
            java.lang.String r2 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            if (r1 == r0) goto Laa
            byte[] r3 = r9.b
            int r4 = r0 + 1
            r5 = r3[r0]
            if (r5 < 0) goto L13
            r9.c = r4
            return r5
        L13:
            int r1 = r1 - r4
            java.lang.String r6 = "CodedInputStream encountered a malformed varint."
            r7 = 9
            if (r1 >= r7) goto L49
            r0 = 0
            r3 = 0
        L1d:
            r4 = 64
            if (r3 >= r4) goto L43
            int r4 = r9.c
            int r5 = r9.d
            if (r4 == r5) goto L3d
            byte[] r5 = r9.b
            int r7 = r4 + 1
            r9.c = r7
            r4 = r5[r4]
            r5 = r4 & 127(0x7f, float:1.78E-43)
            long r7 = (long) r5
            long r7 = r7 << r3
            long r0 = r0 | r7
            r4 = r4 & 128(0x80, float:1.8E-43)
            if (r4 != 0) goto L3a
            int r0 = (int) r0
            return r0
        L3a:
            int r3 = r3 + 7
            goto L1d
        L3d:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            r0.<init>(r2)
            throw r0
        L43:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            r0.<init>(r6)
            throw r0
        L49:
            int r1 = r0 + 2
            r2 = r3[r4]
            int r2 = r2 << 7
            r2 = r2 ^ r5
            if (r2 >= 0) goto L55
            r0 = r2 ^ (-128(0xffffffffffffff80, float:NaN))
            goto La7
        L55:
            int r4 = r0 + 3
            r1 = r3[r1]
            int r1 = r1 << 14
            r1 = r1 ^ r2
            if (r1 < 0) goto L62
            r0 = r1 ^ 16256(0x3f80, float:2.278E-41)
        L60:
            r1 = r4
            goto La7
        L62:
            int r2 = r0 + 4
            r4 = r3[r4]
            int r4 = r4 << 21
            r1 = r1 ^ r4
            if (r1 >= 0) goto L71
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            r1 = r2
            goto La7
        L71:
            int r4 = r0 + 5
            r2 = r3[r2]
            int r5 = r2 << 28
            r1 = r1 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r1 = r1 ^ r5
            if (r2 >= 0) goto La5
            int r2 = r0 + 6
            r4 = r3[r4]
            if (r4 >= 0) goto La4
            int r4 = r0 + 7
            r2 = r3[r2]
            if (r2 >= 0) goto La5
            int r2 = r0 + 8
            r4 = r3[r4]
            if (r4 >= 0) goto La4
            int r4 = r0 + 9
            r2 = r3[r2]
            if (r2 >= 0) goto La5
            int r0 = r0 + 10
            r2 = r3[r4]
            if (r2 < 0) goto L9e
            r4 = r0
            goto La5
        L9e:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            r0.<init>(r6)
            throw r0
        La4:
            r4 = r2
        La5:
            r0 = r1
            goto L60
        La7:
            r9.c = r1
            return r0
        Laa:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.h.x():int");
    }

    public final long y() throws n1 {
        long j;
        long j2;
        long j3;
        long j4;
        int i = this.c;
        int i2 = this.d;
        if (i2 == i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.b;
        int i3 = i + 1;
        byte b = bArr[i];
        if (b >= 0) {
            this.c = i3;
            return b;
        }
        long j5 = 0;
        if (i2 - i3 < 9) {
            for (int i4 = 0; i4 < 64; i4 += 7) {
                int i5 = this.c;
                if (i5 == this.d) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.b;
                this.c = i5 + 1;
                byte b2 = bArr2[i5];
                j5 |= ((long) (b2 & 127)) << i4;
                if ((b2 & 128) == 0) {
                    return j5;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
        }
        int i6 = i + 2;
        int i7 = (bArr[i3] << 7) ^ b;
        if (i7 < 0) {
            j = i7 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
        } else {
            int i8 = i + 3;
            int i9 = (bArr[i6] << Ascii.SO) ^ i7;
            if (i9 >= 0) {
                j = i9 ^ 16256;
                i6 = i8;
            } else {
                int i10 = i + 4;
                int i11 = i9 ^ (bArr[i8] << Ascii.NAK);
                if (i11 < 0) {
                    j4 = (-2080896) ^ i11;
                } else {
                    long j6 = i11;
                    i6 = i + 5;
                    long j7 = j6 ^ (((long) bArr[i10]) << 28);
                    if (j7 >= 0) {
                        j3 = 266354560;
                    } else {
                        i10 = i + 6;
                        long j8 = j7 ^ (((long) bArr[i6]) << 35);
                        if (j8 < 0) {
                            j2 = -34093383808L;
                        } else {
                            i6 = i + 7;
                            j7 = j8 ^ (((long) bArr[i10]) << 42);
                            if (j7 >= 0) {
                                j3 = 4363953127296L;
                            } else {
                                i10 = i + 8;
                                j8 = j7 ^ (((long) bArr[i6]) << 49);
                                if (j8 < 0) {
                                    j2 = -558586000294016L;
                                } else {
                                    i6 = i + 9;
                                    long j9 = (j8 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                    if (j9 < 0) {
                                        int i12 = i + 10;
                                        if (bArr[i6] < 0) {
                                            throw new n1("CodedInputStream encountered a malformed varint.");
                                        }
                                        i6 = i12;
                                    }
                                    j = j9;
                                }
                            }
                        }
                        j4 = j2 ^ j8;
                    }
                    j = j3 ^ j7;
                }
                i6 = i10;
                j = j4;
            }
        }
        this.c = i6;
        return j;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void e(List list) throws n1 {
        int i;
        int i2;
        if (!(list instanceof a1)) {
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    list.add(Integer.valueOf(v()));
                }
                return;
            }
            if (i3 != 5) {
                int i5 = n1.f1569a;
                throw new m1();
            }
            do {
                list.add(Integer.valueOf(q()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        a1 a1Var = (a1) list;
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                a1Var.c(v());
            }
            return;
        }
        if (i6 != 5) {
            int i8 = n1.f1569a;
            throw new m1();
        }
        do {
            a1Var.c(q());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void n(List list) throws n1 {
        int i;
        int i2;
        if (!(list instanceof u1)) {
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    list.add(Long.valueOf(g()));
                    if (u()) {
                        return;
                    } else {
                        i = this.c;
                    }
                } while (x() == this.e);
                this.c = i;
                return;
            }
            if (i3 != 2) {
                int i4 = n1.f1569a;
                throw new m1();
            }
            int iX = x();
            e(iX);
            int i5 = this.c + iX;
            while (this.c < i5) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        u1 u1Var = (u1) list;
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                u1Var.a(g());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        if (i6 != 2) {
            int i7 = n1.f1569a;
            throw new m1();
        }
        int iX2 = x();
        e(iX2);
        int i8 = this.c + iX2;
        while (this.c < i8) {
            u1Var.a(w());
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void p(List list) throws n1 {
        int i;
        int i2;
        if (!(list instanceof a1)) {
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 != 2) {
                    int i4 = n1.f1569a;
                    throw new m1();
                }
                int iX = this.c + x();
                while (this.c < iX) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        a1 a1Var = (a1) list;
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 != 2) {
                int i6 = n1.f1569a;
                throw new m1();
            }
            int iX2 = this.c + x();
            while (this.c < iX2) {
                a1Var.c(x());
            }
            return;
        }
        do {
            c(0);
            a1Var.c(x());
            if (u()) {
                return;
            } else {
                i2 = this.c;
            }
        } while (x() == this.e);
        this.c = i2;
    }

    public final Object d(t2 t2Var, h0 h0Var) throws n1 {
        int iX = x();
        a(iX);
        int i = this.d;
        int i2 = this.c + iX;
        this.d = i2;
        try {
            Object objA = t2Var.a();
            t2Var.a(objA, this, h0Var);
            t2Var.c(objA);
            if (this.c == i2) {
                return objA;
            }
            throw new n1("Failed to parse the message.");
        } finally {
            this.d = i;
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void f(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    a1Var.c(v());
                }
                return;
            }
            if (i3 == 5) {
                do {
                    a1Var.c(m());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = n1.f1569a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Integer.valueOf(v()));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Integer.valueOf(m()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void j(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof d0) {
            d0 d0Var = (d0) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    d0Var.a(h());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = x();
                e(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    d0Var.a(Double.longBitsToDouble(w()));
                }
                return;
            }
            int i5 = n1.f1569a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Double.valueOf(h()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int iX2 = x();
            e(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Double.valueOf(Double.longBitsToDouble(w())));
            }
            return;
        }
        int i8 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void l(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof j) {
            j jVar = (j) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    jVar.a(r());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    jVar.a(x() != 0);
                }
                b(iX);
                return;
            }
            int i4 = n1.f1569a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                list.add(Boolean.valueOf(r()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Boolean.valueOf(x() != 0));
            }
            b(iX2);
            return;
        }
        int i6 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void o(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    a1Var.c(x());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    a1Var.c(x());
                }
                b(iX);
                return;
            }
            int i4 = n1.f1569a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Integer.valueOf(x()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Integer.valueOf(x()));
            }
            b(iX2);
            return;
        }
        int i6 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object b(t2 t2Var, h0 h0Var) throws m1 {
        c(2);
        return d(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void g(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        u1Var.a(w.a(y()));
                    }
                    return;
                }
                int i4 = n1.f1569a;
                throw new m1();
            }
            do {
                c(0);
                u1Var.a(w.a(y()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Long.valueOf(w.a(y())));
                }
                return;
            }
            int i6 = n1.f1569a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Long.valueOf(w.a(y())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void m(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 1) {
                do {
                    u1Var.a(t());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = x();
                e(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    u1Var.a(w());
                }
                return;
            }
            int i5 = n1.f1569a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 1) {
            do {
                list.add(Long.valueOf(t()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i6 == 2) {
            int iX2 = x();
            e(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Long.valueOf(w()));
            }
            return;
        }
        int i8 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void q(List list) throws m1 {
        a(list, false);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void h(List list) throws m1 {
        int i;
        if ((this.e & 7) == 2) {
            do {
                list.add(a());
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i2 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void k(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    u1Var.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    u1Var.a(y());
                }
                b(iX);
                return;
            }
            int i4 = n1.f1569a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Long.valueOf(y()));
            }
            b(iX2);
            return;
        }
        int i6 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int b() throws m1 {
        c(0);
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list) throws m1 {
        a(list, true);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void b(List list, t2 t2Var, h0 h0Var) throws m1 {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 2) {
            do {
                list.add(d(t2Var, h0Var));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(Class cls, h0 h0Var) throws m1 {
        c(3);
        return c(p2.c.a(cls), h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final Object a(t2 t2Var, h0 h0Var) throws m1 {
        c(3);
        return c(t2Var, h0Var);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final s a() throws n1 {
        s qVar;
        c(2);
        int iX = x();
        if (iX == 0) {
            return s.b;
        }
        a(iX);
        if (this.f1555a) {
            byte[] bArr = this.b;
            int i = this.c;
            q qVar2 = s.b;
            qVar = new n(bArr, i, iX);
        } else {
            byte[] bArr2 = this.b;
            int i2 = this.c;
            q qVar3 = s.b;
            s.a(i2, i2 + iX, bArr2.length);
            qVar = new q(s.c.a(bArr2, i2, iX));
        }
        this.c += iX;
        return qVar;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final int c() throws m1 {
        c(0);
        return x();
    }

    public final void b(int i) throws n1 {
        if (this.c != i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void c(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        a1Var.c(w.b(x()));
                    }
                    return;
                }
                int i4 = n1.f1569a;
                throw new m1();
            }
            do {
                c(0);
                a1Var.c(w.b(x()));
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Integer.valueOf(w.b(x())));
                }
                return;
            }
            int i6 = n1.f1569a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Integer.valueOf(w.b(x())));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void d(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof q0) {
            q0 q0Var = (q0) list;
            int i3 = this.e & 7;
            if (i3 == 2) {
                int iX = x();
                d(iX);
                int i4 = this.c + iX;
                while (this.c < i4) {
                    q0Var.a(Float.intBitsToFloat(v()));
                }
                return;
            }
            if (i3 == 5) {
                do {
                    q0Var.a(k());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            int i5 = n1.f1569a;
            throw new m1();
        }
        int i6 = this.e & 7;
        if (i6 == 2) {
            int iX2 = x();
            d(iX2);
            int i7 = this.c + iX2;
            while (this.c < i7) {
                list.add(Float.valueOf(Float.intBitsToFloat(v())));
            }
            return;
        }
        if (i6 == 5) {
            do {
                list.add(Float.valueOf(k()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i8 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof u1) {
            u1 u1Var = (u1) list;
            int i3 = this.e & 7;
            if (i3 == 0) {
                do {
                    c(0);
                    u1Var.a(y());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            if (i3 == 2) {
                int iX = this.c + x();
                while (this.c < iX) {
                    u1Var.a(y());
                }
                b(iX);
                return;
            }
            int i4 = n1.f1569a;
            throw new m1();
        }
        int i5 = this.e & 7;
        if (i5 == 0) {
            do {
                c(0);
                list.add(Long.valueOf(y()));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        if (i5 == 2) {
            int iX2 = this.c + x();
            while (this.c < iX2) {
                list.add(Long.valueOf(y()));
            }
            b(iX2);
            return;
        }
        int i6 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void i(List list) throws n1 {
        int i;
        int i2;
        if (list instanceof a1) {
            a1 a1Var = (a1) list;
            int i3 = this.e & 7;
            if (i3 != 0) {
                if (i3 == 2) {
                    int iX = this.c + x();
                    while (this.c < iX) {
                        a1Var.c(x());
                    }
                    return;
                }
                int i4 = n1.f1569a;
                throw new m1();
            }
            do {
                c(0);
                a1Var.c(x());
                if (u()) {
                    return;
                } else {
                    i2 = this.c;
                }
            } while (x() == this.e);
            this.c = i2;
            return;
        }
        int i5 = this.e & 7;
        if (i5 != 0) {
            if (i5 == 2) {
                int iX2 = this.c + x();
                while (this.c < iX2) {
                    list.add(Integer.valueOf(x()));
                }
                return;
            }
            int i6 = n1.f1569a;
            throw new m1();
        }
        do {
            c(0);
            list.add(Integer.valueOf(x()));
            if (u()) {
                return;
            } else {
                i = this.c;
            }
        } while (x() == this.e);
        this.c = i;
    }

    public final void e(int i) throws n1 {
        a(i);
        if ((i & 7) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    public final void c(int i) throws m1 {
        if ((this.e & 7) == i) {
            return;
        }
        int i2 = n1.f1569a;
        throw new m1();
    }

    public final void d(int i) throws n1 {
        a(i);
        if ((i & 3) != 0) {
            throw new n1("Failed to parse the message.");
        }
    }

    public final void a(List list, boolean z) throws m1 {
        int i;
        int i2;
        if ((this.e & 7) == 2) {
            if ((list instanceof q1) && !z) {
                q1 q1Var = (q1) list;
                do {
                    q1Var.a(a());
                    if (u()) {
                        return;
                    } else {
                        i2 = this.c;
                    }
                } while (x() == this.e);
                this.c = i2;
                return;
            }
            do {
                list.add(a(z));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == this.e);
            this.c = i;
            return;
        }
        int i3 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.s2
    public final void a(List list, t2 t2Var, h0 h0Var) throws m1 {
        int i;
        int i2 = this.e;
        if ((i2 & 7) == 3) {
            do {
                list.add(c(t2Var, h0Var));
                if (u()) {
                    return;
                } else {
                    i = this.c;
                }
            } while (x() == i2);
            this.c = i;
            return;
        }
        int i3 = n1.f1569a;
        throw new m1();
    }

    public final void a(int i) throws n1 {
        if (i < 0 || i > this.d - this.c) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
    }
}
