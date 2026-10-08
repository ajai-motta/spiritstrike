package com.fyber.inneractive.sdk.protobuf;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public final class t extends w {
    public final byte[] e;
    public int f;
    public int g;
    public int h;
    public final int i;
    public int j;
    public int k = Integer.MAX_VALUE;

    public t(byte[] bArr, int i, int i2, boolean z) {
        this.e = bArr;
        this.f = i2 + i;
        this.h = i;
        this.i = i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i) throws n1 {
        if (this.j != i) {
            throw new n1("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int b() {
        return this.h - this.i;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void c(int i) {
        this.k = i;
        z();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean d() {
        return y() != 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final double f() {
        return Double.longBitsToDouble(x());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int g() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int h() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long i() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final float j() {
        return Float.intBitsToFloat(w());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int k() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long l() {
        return y();
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00a2 A[PHI: r3
  0x00a2: PHI (r3v11 int) = (r3v10 int), (r3v13 int) binds: [B:25:0x0053, B:29:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            r6 = this;
            int r0 = r6.h
            int r1 = r6.f
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r6.e
            int r3 = r0 + 1
            r4 = r2[r0]
            if (r4 < 0) goto L12
            r6.h = r3
            return r4
        L12:
            int r1 = r1 - r3
            r5 = 9
            if (r1 >= r5) goto L18
            goto L6d
        L18:
            int r1 = r0 + 2
            r3 = r2[r3]
            int r3 = r3 << 7
            r3 = r3 ^ r4
            if (r3 >= 0) goto L25
            r0 = r3 ^ (-128(0xffffffffffffff80, float:NaN))
            goto La5
        L25:
            int r4 = r0 + 3
            r1 = r2[r1]
            int r1 = r1 << 14
            r1 = r1 ^ r3
            if (r1 < 0) goto L33
            r0 = r1 ^ 16256(0x3f80, float:2.278E-41)
        L30:
            r1 = r4
            goto La5
        L33:
            int r3 = r0 + 4
            r4 = r2[r4]
            int r4 = r4 << 21
            r1 = r1 ^ r4
            if (r1 >= 0) goto L42
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            r1 = r3
            goto La5
        L42:
            int r4 = r0 + 5
            r3 = r2[r3]
            int r5 = r3 << 28
            r1 = r1 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r1 = r1 ^ r5
            if (r3 >= 0) goto La3
            int r3 = r0 + 6
            r4 = r2[r4]
            if (r4 >= 0) goto La2
            int r4 = r0 + 7
            r3 = r2[r3]
            if (r3 >= 0) goto La3
            int r3 = r0 + 8
            r4 = r2[r4]
            if (r4 >= 0) goto La2
            int r4 = r0 + 9
            r3 = r2[r3]
            if (r3 >= 0) goto La3
            int r0 = r0 + 10
            r2 = r2[r4]
            if (r2 >= 0) goto La0
        L6d:
            r0 = 0
            r2 = 0
        L70:
            r3 = 64
            if (r2 >= r3) goto L98
            int r3 = r6.h
            int r4 = r6.f
            if (r3 == r4) goto L90
            byte[] r4 = r6.e
            int r5 = r3 + 1
            r6.h = r5
            r3 = r4[r3]
            r4 = r3 & 127(0x7f, float:1.78E-43)
            long r4 = (long) r4
            long r4 = r4 << r2
            long r0 = r0 | r4
            r3 = r3 & 128(0x80, float:1.8E-43)
            if (r3 != 0) goto L8d
            int r0 = (int) r0
            return r0
        L8d:
            int r2 = r2 + 7
            goto L70
        L90:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r0.<init>(r1)
            throw r0
        L98:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "CodedInputStream encountered a malformed varint."
            r0.<init>(r1)
            throw r0
        La0:
            r4 = r0
            goto La3
        La2:
            r4 = r3
        La3:
            r0 = r1
            goto L30
        La5:
            r6.h = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.t.m():int");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int n() {
        return w();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long o() {
        return x();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int p() {
        return w.b(m());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long q() {
        return w.a(y());
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final String r() throws n1 {
        int iM = m();
        if (iM > 0) {
            int i = this.f;
            int i2 = this.h;
            if (iM <= i - i2) {
                String str = new String(this.e, i2, iM, l1.f1565a);
                this.h += iM;
                return str;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final String s() throws n1 {
        int iM = m();
        if (iM > 0) {
            int i = this.f;
            int i2 = this.h;
            if (iM <= i - i2) {
                String strA = d4.f1547a.a(this.e, i2, iM);
                this.h += iM;
                return strA;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM <= 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int t() throws n1 {
        if (c()) {
            this.j = 0;
            return 0;
        }
        int iM = m();
        this.j = iM;
        if ((iM >>> 3) != 0) {
            return iM;
        }
        throw new n1("Protocol message contained an invalid tag (zero).");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int u() {
        return m();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final long v() {
        return y();
    }

    public final int w() throws n1 {
        int i = this.h;
        if (this.f - i < 4) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.e;
        this.h = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long x() throws n1 {
        int i = this.h;
        if (this.f - i < 8) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        byte[] bArr = this.e;
        this.h = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final long y() throws n1 {
        long j;
        long j2;
        long j3;
        int i = this.h;
        int i2 = this.f;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.e;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.h = i3;
                return b;
            }
            if (i2 - i3 >= 9) {
                int i4 = i + 2;
                int i5 = (bArr[i3] << 7) ^ b;
                if (i5 < 0) {
                    j = i5 ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                } else {
                    int i6 = i + 3;
                    int i7 = (bArr[i4] << Ascii.SO) ^ i5;
                    if (i7 >= 0) {
                        j = i7 ^ 16256;
                        i4 = i6;
                    } else {
                        int i8 = i + 4;
                        int i9 = i7 ^ (bArr[i6] << Ascii.NAK);
                        if (i9 < 0) {
                            j = (-2080896) ^ i9;
                            i4 = i8;
                        } else {
                            long j5 = i9;
                            i4 = i + 5;
                            long j6 = j5 ^ (((long) bArr[i8]) << 28);
                            if (j6 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i10 = i + 6;
                                long j7 = j6 ^ (((long) bArr[i4]) << 35);
                                if (j7 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i4 = i + 7;
                                    j6 = j7 ^ (((long) bArr[i10]) << 42);
                                    if (j6 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i10 = i + 8;
                                        j7 = j6 ^ (((long) bArr[i4]) << 49);
                                        if (j7 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            i4 = i + 9;
                                            long j8 = (j7 ^ (((long) bArr[i10]) << 56)) ^ 71499008037633920L;
                                            if (j8 < 0) {
                                                int i11 = i + 10;
                                                if (bArr[i4] >= 0) {
                                                    i4 = i11;
                                                }
                                            }
                                            j = j8;
                                        }
                                    }
                                }
                                j = j7 ^ j2;
                                i4 = i10;
                            }
                            j = j3 ^ j6;
                        }
                    }
                }
                this.h = i4;
                return j;
            }
        }
        for (int i12 = 0; i12 < 64; i12 += 7) {
            int i13 = this.h;
            if (i13 == this.f) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            byte[] bArr2 = this.e;
            this.h = i13 + 1;
            byte b2 = bArr2[i13];
            j4 |= ((long) (b2 & 127)) << i12;
            if ((b2 & 128) == 0) {
                return j4;
            }
        }
        throw new n1("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        int i = this.f + this.g;
        this.f = i;
        int i2 = i - this.i;
        int i3 = this.k;
        if (i2 <= i3) {
            this.g = 0;
            return;
        }
        int i4 = i2 - i3;
        this.g = i4;
        this.f = i - i4;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int d(int i) {
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = (this.h - this.i) + i;
        int i3 = this.k;
        if (i2 > i3) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = i2;
        z();
        return i3;
    }

    public final void f(int i) throws n1 {
        if (i >= 0) {
            int i2 = this.f;
            int i3 = this.h;
            if (i <= i2 - i3) {
                this.h = i3 + i;
                return;
            }
        }
        if (i >= 0) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean c() {
        return this.h == this.f;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i, c2 c2Var, h0 h0Var) throws IOException {
        int i2 = this.f1584a;
        if (i2 < this.b) {
            this.f1584a = i2 + 1;
            ((t0) c2Var).a(this, h0Var);
            a((i << 3) | 4);
            this.f1584a--;
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean e(int i) throws n1 {
        int iT;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.f - this.h >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.e;
                    int i4 = this.h;
                    this.h = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw new n1("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                int i5 = this.h;
                if (i5 == this.f) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                byte[] bArr2 = this.e;
                this.h = i5 + 1;
                if (bArr2[i5] < 0) {
                    i3++;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            f(8);
            return true;
        }
        if (i2 == 2) {
            f(m());
            return true;
        }
        if (i2 == 3) {
            do {
                iT = t();
                if (iT == 0) {
                    break;
                }
            } while (e(iT));
            a(((i >>> 3) << 3) | 4);
            return true;
        }
        if (i2 == 4) {
            return false;
        }
        if (i2 == 5) {
            f(4);
            return true;
        }
        int i6 = n1.f1569a;
        throw new m1();
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(c2 c2Var, h0 h0Var) throws IOException {
        int iM = m();
        if (this.f1584a < this.b) {
            int iD = d(iM);
            this.f1584a++;
            ((t0) c2Var).a(this, h0Var);
            a(0);
            this.f1584a--;
            this.k = iD;
            z();
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0040  */
    @Override // com.fyber.inneractive.sdk.protobuf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.fyber.inneractive.sdk.protobuf.q e() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            r5 = this;
            int r0 = r5.m()
            if (r0 <= 0) goto L28
            int r1 = r5.f
            int r2 = r5.h
            int r1 = r1 - r2
            if (r0 > r1) goto L28
            byte[] r1 = r5.e
            com.fyber.inneractive.sdk.protobuf.q r3 = com.fyber.inneractive.sdk.protobuf.s.b
            int r3 = r2 + r0
            int r4 = r1.length
            com.fyber.inneractive.sdk.protobuf.s.a(r2, r3, r4)
            com.fyber.inneractive.sdk.protobuf.q r3 = new com.fyber.inneractive.sdk.protobuf.q
            com.fyber.inneractive.sdk.protobuf.o r4 = com.fyber.inneractive.sdk.protobuf.s.c
            byte[] r1 = r4.a(r1, r2, r0)
            r3.<init>(r1)
            int r1 = r5.h
            int r1 = r1 + r0
            r5.h = r1
            return r3
        L28:
            if (r0 != 0) goto L2d
            com.fyber.inneractive.sdk.protobuf.q r0 = com.fyber.inneractive.sdk.protobuf.s.b
            return r0
        L2d:
            if (r0 <= 0) goto L40
            int r1 = r5.f
            int r2 = r5.h
            int r1 = r1 - r2
            if (r0 > r1) goto L40
            int r0 = r0 + r2
            r5.h = r0
            byte[] r1 = r5.e
            byte[] r0 = java.util.Arrays.copyOfRange(r1, r2, r0)
            goto L46
        L40:
            if (r0 > 0) goto L56
            if (r0 != 0) goto L4e
            byte[] r0 = com.fyber.inneractive.sdk.protobuf.l1.b
        L46:
            com.fyber.inneractive.sdk.protobuf.q r1 = com.fyber.inneractive.sdk.protobuf.s.b
            com.fyber.inneractive.sdk.protobuf.q r1 = new com.fyber.inneractive.sdk.protobuf.q
            r1.<init>(r0)
            return r1
        L4e:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "CodedInputStream encountered an embedded string or message which claimed to have negative size."
            r0.<init>(r1)
            throw r0
        L56:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length."
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.t.e():com.fyber.inneractive.sdk.protobuf.q");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int a() {
        int i = this.k;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.h - this.i);
    }
}
