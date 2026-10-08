package com.fyber.inneractive.sdk.protobuf;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public final class v extends w {
    public final ByteBuffer e;
    public final long f;
    public long g;
    public long h;
    public final long i;
    public int j;
    public int k;
    public int l = Integer.MAX_VALUE;

    public v(ByteBuffer byteBuffer, boolean z) {
        this.e = byteBuffer;
        w3 w3Var = x3.c;
        long j = w3Var.f1588a.getLong(byteBuffer, x3.g);
        this.f = j;
        this.g = ((long) byteBuffer.limit()) + j;
        long jPosition = j + ((long) byteBuffer.position());
        this.h = jPosition;
        this.i = jPosition;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i) throws n1 {
        if (this.k != i) {
            throw new n1("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int b() {
        return (int) (this.h - this.i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void c(int i) {
        this.l = i;
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

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cc A[PHI: r6
  0x00cc: PHI (r6v9 long) = (r6v8 long), (r6v12 long) binds: [B:22:0x0064, B:26:0x0076] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            Method dump skipped, instruction units count: 209
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.v.m():int");
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
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                byte[] bArr = new byte[iM];
                long j3 = iM;
                x3.c.a(j2, bArr, j3);
                String str = new String(bArr, l1.f1565a);
                this.h += j3;
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
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                int i = (int) (j2 - this.f);
                ByteBuffer byteBuffer = this.e;
                z3 z3Var = d4.f1547a;
                z3Var.getClass();
                String strA = byteBuffer.hasArray() ? z3Var.a(byteBuffer.array(), byteBuffer.arrayOffset() + i, iM) : byteBuffer.isDirect() ? z3Var.b(byteBuffer, i, iM) : z3.a(byteBuffer, i, iM);
                this.h += (long) iM;
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
            this.k = 0;
            return 0;
        }
        int iM = m();
        this.k = iM;
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
        long j = this.h;
        if (this.g - j < 4) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.h = 4 + j;
        w3 w3Var = x3.c;
        return ((w3Var.a(j + 3) & 255) << 24) | (w3Var.a(j) & 255) | ((w3Var.a(1 + j) & 255) << 8) | ((w3Var.a(2 + j) & 255) << 16);
    }

    public final long x() throws n1 {
        long j = this.h;
        if (this.g - j < 8) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.h = 8 + j;
        w3 w3Var = x3.c;
        return ((((long) w3Var.a(j + 7)) & 255) << 56) | (((long) w3Var.a(j)) & 255) | ((((long) w3Var.a(1 + j)) & 255) << 8) | ((((long) w3Var.a(2 + j)) & 255) << 16) | ((((long) w3Var.a(3 + j)) & 255) << 24) | ((((long) w3Var.a(4 + j)) & 255) << 32) | ((((long) w3Var.a(5 + j)) & 255) << 40) | ((((long) w3Var.a(6 + j)) & 255) << 48);
    }

    public final long y() throws n1 {
        long j;
        long j2;
        int i;
        long j3 = this.h;
        long j4 = 0;
        if (this.g != j3) {
            long j5 = j3 + 1;
            w3 w3Var = x3.c;
            byte bA = w3Var.a(j3);
            if (bA >= 0) {
                this.h = j5;
                return bA;
            }
            if (this.g - j5 >= 9) {
                long j6 = 2 + j3;
                int iA = (w3Var.a(j5) << 7) ^ bA;
                if (iA >= 0) {
                    long j7 = 3 + j3;
                    int iA2 = iA ^ (w3Var.a(j6) << Ascii.SO);
                    if (iA2 >= 0) {
                        j = iA2 ^ 16256;
                        j6 = j7;
                    } else {
                        j6 = 4 + j3;
                        int iA3 = iA2 ^ (w3Var.a(j7) << Ascii.NAK);
                        if (iA3 < 0) {
                            i = (-2080896) ^ iA3;
                        } else {
                            long j8 = j3 + 5;
                            long jA = ((long) iA3) ^ (((long) w3Var.a(j6)) << 28);
                            if (jA >= 0) {
                                j = 266354560 ^ jA;
                                j6 = j8;
                            } else {
                                j6 = j3 + 6;
                                long jA2 = (((long) w3Var.a(j8)) << 35) ^ jA;
                                if (jA2 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    long j9 = 7 + j3;
                                    long jA3 = jA2 ^ (((long) w3Var.a(j6)) << 42);
                                    if (jA3 >= 0) {
                                        j = 4363953127296L ^ jA3;
                                        j6 = j9;
                                    } else {
                                        j6 = j3 + 8;
                                        jA2 = jA3 ^ (((long) w3Var.a(j9)) << 49);
                                        if (jA2 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            long j10 = 9 + j3;
                                            long jA4 = (jA2 ^ (((long) w3Var.a(j6)) << 56)) ^ 71499008037633920L;
                                            if (jA4 < 0) {
                                                long j11 = j3 + 10;
                                                if (w3Var.a(j10) >= 0) {
                                                    j6 = j11;
                                                }
                                            } else {
                                                j6 = j10;
                                            }
                                            j = jA4;
                                        }
                                    }
                                }
                                j = j2 ^ jA2;
                            }
                        }
                    }
                    this.h = j6;
                    return j;
                }
                i = iA ^ WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT;
                j = i;
                this.h = j6;
                return j;
            }
        }
        for (int i2 = 0; i2 < 64; i2 += 7) {
            long j12 = this.h;
            if (j12 == this.g) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.h = j12 + 1;
            byte bA2 = x3.c.a(j12);
            j4 |= ((long) (bA2 & 127)) << i2;
            if ((bA2 & 128) == 0) {
                return j4;
            }
        }
        throw new n1("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        long j = this.g + ((long) this.j);
        this.g = j;
        int i = (int) (j - this.i);
        int i2 = this.l;
        if (i <= i2) {
            this.j = 0;
            return;
        }
        int i3 = i - i2;
        this.j = i3;
        this.g = j - ((long) i3);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int d(int i) throws n1 {
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = i + ((int) (this.h - this.i));
        int i3 = this.l;
        if (i2 > i3) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.l = i2;
        z();
        return i3;
    }

    public final void f(int i) throws n1 {
        if (i >= 0) {
            long j = this.g;
            long j2 = this.h;
            if (i <= ((int) (j - j2))) {
                this.h = j2 + ((long) i);
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
        return this.h == this.g;
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
            if (((int) (this.g - this.h)) >= 10) {
                while (i3 < 10) {
                    long j = this.h;
                    this.h = j + 1;
                    if (x3.c.a(j) < 0) {
                        i3++;
                    }
                }
                throw new n1("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                long j2 = this.h;
                if (j2 == this.g) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.h = j2 + 1;
                if (x3.c.a(j2) < 0) {
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
        int i4 = n1.f1569a;
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
            this.l = iD;
            z();
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final q e() throws n1 {
        int iM = m();
        if (iM > 0) {
            long j = this.g;
            long j2 = this.h;
            if (iM <= ((int) (j - j2))) {
                byte[] bArr = new byte[iM];
                long j3 = iM;
                x3.c.a(j2, bArr, j3);
                this.h += j3;
                q qVar = s.b;
                return new q(bArr);
            }
        }
        if (iM == 0) {
            return s.b;
        }
        if (iM < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int a() {
        int i = this.l;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - ((int) (this.h - this.i));
    }
}
