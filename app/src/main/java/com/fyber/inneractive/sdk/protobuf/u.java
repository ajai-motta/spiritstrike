package com.fyber.inneractive.sdk.protobuf;

import androidx.work.WorkInfo;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends w {
    public final InputStream e;
    public final byte[] f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l = Integer.MAX_VALUE;

    public u(InputStream inputStream) {
        Charset charset = l1.f1565a;
        if (inputStream == null) {
            throw new NullPointerException("input");
        }
        this.e = inputStream;
        this.f = new byte[4096];
        this.g = 0;
        this.i = 0;
        this.k = 0;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final void a(int i) throws n1 {
        if (this.j != i) {
            throw new n1("Protocol message end-group tag did not match expected tag.");
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int b() {
        return this.k + this.i;
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

    /* JADX WARN: Removed duplicated region for block: B:48:0x00a0 A[PHI: r3
  0x00a0: PHI (r3v13 int) = (r3v12 int), (r3v15 int) binds: [B:25:0x0053, B:29:0x005f] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.fyber.inneractive.sdk.protobuf.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m() throws com.fyber.inneractive.sdk.protobuf.n1 {
        /*
            r6 = this;
            int r0 = r6.i
            int r1 = r6.g
            if (r1 != r0) goto L7
            goto L6d
        L7:
            byte[] r2 = r6.f
            int r3 = r0 + 1
            r4 = r2[r0]
            if (r4 < 0) goto L12
            r6.i = r3
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
            goto La3
        L25:
            int r4 = r0 + 3
            r1 = r2[r1]
            int r1 = r1 << 14
            r1 = r1 ^ r3
            if (r1 < 0) goto L33
            r0 = r1 ^ 16256(0x3f80, float:2.278E-41)
        L30:
            r1 = r4
            goto La3
        L33:
            int r3 = r0 + 4
            r4 = r2[r4]
            int r4 = r4 << 21
            r1 = r1 ^ r4
            if (r1 >= 0) goto L42
            r0 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            r1 = r3
            goto La3
        L42:
            int r4 = r0 + 5
            r3 = r2[r3]
            int r5 = r3 << 28
            r1 = r1 ^ r5
            r5 = 266354560(0xfe03f80, float:2.2112565E-29)
            r1 = r1 ^ r5
            if (r3 >= 0) goto La1
            int r3 = r0 + 6
            r4 = r2[r4]
            if (r4 >= 0) goto La0
            int r4 = r0 + 7
            r3 = r2[r3]
            if (r3 >= 0) goto La1
            int r3 = r0 + 8
            r4 = r2[r4]
            if (r4 >= 0) goto La0
            int r4 = r0 + 9
            r3 = r2[r3]
            if (r3 >= 0) goto La1
            int r0 = r0 + 10
            r2 = r2[r4]
            if (r2 >= 0) goto L9e
        L6d:
            r0 = 0
            r2 = 0
        L70:
            r3 = 64
            if (r2 >= r3) goto L96
            int r3 = r6.i
            int r4 = r6.g
            if (r3 != r4) goto L7e
            r3 = 1
            r6.i(r3)
        L7e:
            byte[] r3 = r6.f
            int r4 = r6.i
            int r5 = r4 + 1
            r6.i = r5
            r3 = r3[r4]
            r4 = r3 & 127(0x7f, float:1.78E-43)
            long r4 = (long) r4
            long r4 = r4 << r2
            long r0 = r0 | r4
            r3 = r3 & 128(0x80, float:1.8E-43)
            if (r3 != 0) goto L93
            int r0 = (int) r0
            return r0
        L93:
            int r2 = r2 + 7
            goto L70
        L96:
            com.fyber.inneractive.sdk.protobuf.n1 r0 = new com.fyber.inneractive.sdk.protobuf.n1
            java.lang.String r1 = "CodedInputStream encountered a malformed varint."
            r0.<init>(r1)
            throw r0
        L9e:
            r4 = r0
            goto La1
        La0:
            r4 = r3
        La1:
            r0 = r1
            goto L30
        La3:
            r6.i = r1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fyber.inneractive.sdk.protobuf.u.m():int");
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
            int i = this.g;
            int i2 = this.i;
            if (iM <= i - i2) {
                String str = new String(this.f, i2, iM, l1.f1565a);
                this.i += iM;
                return str;
            }
        }
        if (iM == 0) {
            return "";
        }
        if (iM > this.g) {
            return new String(f(iM), l1.f1565a);
        }
        i(iM);
        String str2 = new String(this.f, this.i, iM, l1.f1565a);
        this.i += iM;
        return str2;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final String s() throws IOException {
        byte[] bArrF;
        int iM = m();
        int i = this.i;
        int i2 = this.g;
        if (iM <= i2 - i && iM > 0) {
            bArrF = this.f;
            this.i = i + iM;
        } else {
            if (iM == 0) {
                return "";
            }
            i = 0;
            if (iM <= i2) {
                i(iM);
                bArrF = this.f;
                this.i = iM;
            } else {
                bArrF = f(iM);
            }
        }
        return d4.f1547a.a(bArrF, i, iM);
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
        int i = this.i;
        if (this.g - i < 4) {
            i(4);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    public final long x() throws n1 {
        int i = this.i;
        if (this.g - i < 8) {
            i(8);
            i = this.i;
        }
        byte[] bArr = this.f;
        this.i = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    public final long y() throws n1 {
        long j;
        long j2;
        long j3;
        int i = this.i;
        int i2 = this.g;
        long j4 = 0;
        if (i2 != i) {
            byte[] bArr = this.f;
            int i3 = i + 1;
            byte b = bArr[i];
            if (b >= 0) {
                this.i = i3;
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
                this.i = i4;
                return j;
            }
        }
        for (int i12 = 0; i12 < 64; i12 += 7) {
            if (this.i == this.g) {
                i(1);
            }
            byte[] bArr2 = this.f;
            int i13 = this.i;
            this.i = i13 + 1;
            byte b2 = bArr2[i13];
            j4 |= ((long) (b2 & 127)) << i12;
            if ((b2 & 128) == 0) {
                return j4;
            }
        }
        throw new n1("CodedInputStream encountered a malformed varint.");
    }

    public final void z() {
        int i = this.g + this.h;
        this.g = i;
        int i2 = this.k + i;
        int i3 = this.l;
        if (i2 <= i3) {
            this.h = 0;
            return;
        }
        int i4 = i2 - i3;
        this.h = i4;
        this.g = i - i4;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int d(int i) throws n1 {
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.k + this.i + i;
        int i3 = this.l;
        if (i2 > i3) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.l = i2;
        z();
        return i3;
    }

    public final byte[] f(int i) throws IOException {
        byte[] bArrG = g(i);
        if (bArrG != null) {
            return bArrG;
        }
        int i2 = this.i;
        int i3 = this.g;
        int length = i3 - i2;
        this.k += i3;
        this.i = 0;
        this.g = 0;
        ArrayList<byte[]> arrayListH = h(i - length);
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, i2, bArr, 0, length);
        for (byte[] bArr2 : arrayListH) {
            System.arraycopy(bArr2, 0, bArr, length, bArr2.length);
            length += bArr2.length;
        }
        return bArr;
    }

    public final byte[] g(int i) throws IOException {
        if (i == 0) {
            return l1.b;
        }
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i2 = this.k;
        int i3 = this.i;
        int i4 = i2 + i3 + i;
        if (i4 - this.c > 0) {
            throw new n1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
        }
        int i5 = this.l;
        if (i4 > i5) {
            j((i5 - i2) - i3);
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i6 = this.g - i3;
        int i7 = i - i6;
        if (i7 >= 4096 && i7 > this.e.available()) {
            return null;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(this.f, this.i, bArr, 0, i6);
        this.k += this.g;
        this.i = 0;
        this.g = 0;
        while (i6 < i) {
            int i8 = this.e.read(bArr, i6, i - i6);
            if (i8 == -1) {
                throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            this.k += i8;
            i6 += i8;
        }
        return bArr;
    }

    public final ArrayList h(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int iMin = Math.min(i, 4096);
            byte[] bArr = new byte[iMin];
            int i2 = 0;
            while (i2 < iMin) {
                int i3 = this.e.read(bArr, i2, iMin - i2);
                if (i3 == -1) {
                    throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                }
                this.k += i3;
                i2 += i3;
            }
            i -= iMin;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    public final void i(int i) throws n1 {
        if (k(i)) {
            return;
        }
        if (i <= (this.c - this.k) - this.i) {
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        throw new n1("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    public final void j(int i) throws n1 {
        int i2 = this.g;
        int i3 = this.i;
        int i4 = i2 - i3;
        if (i <= i4 && i >= 0) {
            this.i = i3 + i;
            return;
        }
        if (i < 0) {
            throw new n1("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        int i5 = this.k;
        int i6 = i5 + i3;
        int i7 = i6 + i;
        int i8 = this.l;
        if (i7 > i8) {
            j((i8 - i5) - i3);
            throw new n1("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        this.k = i6;
        this.g = 0;
        this.i = 0;
        while (i4 < i) {
            try {
                long j = i - i4;
                long jSkip = this.e.skip(j);
                if (jSkip < 0 || jSkip > j) {
                    throw new IllegalStateException(this.e.getClass() + "#skip returned invalid result: " + jSkip + "\nThe InputStream implementation is buggy.");
                }
                if (jSkip == 0) {
                    break;
                } else {
                    i4 += (int) jSkip;
                }
            } finally {
                this.k += i4;
                z();
            }
        }
        if (i4 >= i) {
            return;
        }
        int i9 = this.g;
        int i10 = i9 - this.i;
        this.i = i9;
        i(1);
        while (true) {
            int i11 = i - i10;
            int i12 = this.g;
            if (i11 <= i12) {
                this.i = i11;
                return;
            } else {
                i10 += i12;
                this.i = i12;
                i(1);
            }
        }
    }

    public final boolean k(int i) throws IOException {
        int i2 = this.i;
        int i3 = i2 + i;
        int i4 = this.g;
        if (i3 <= i4) {
            throw new IllegalStateException("refillBuffer() called when " + i + " bytes were already available in buffer");
        }
        int i5 = this.c;
        int i6 = this.k;
        if (i > (i5 - i6) - i2 || i6 + i2 + i > this.l) {
            return false;
        }
        if (i2 > 0) {
            if (i4 > i2) {
                byte[] bArr = this.f;
                System.arraycopy(bArr, i2, bArr, 0, i4 - i2);
            }
            this.k += i2;
            this.g -= i2;
            this.i = 0;
        }
        InputStream inputStream = this.e;
        byte[] bArr2 = this.f;
        int i7 = this.g;
        int i8 = inputStream.read(bArr2, i7, Math.min(bArr2.length - i7, (this.c - this.k) - i7));
        if (i8 == 0 || i8 < -1 || i8 > this.f.length) {
            throw new IllegalStateException(this.e.getClass() + "#read(byte[]) returned invalid result: " + i8 + "\nThe InputStream implementation is buggy.");
        }
        if (i8 <= 0) {
            return false;
        }
        this.g += i8;
        z();
        if (this.g >= i) {
            return true;
        }
        return k(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final boolean c() {
        return this.i == this.g && !k(1);
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
            if (this.g - this.i >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.f;
                    int i4 = this.i;
                    this.i = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw new n1("CodedInputStream encountered a malformed varint.");
            }
            while (i3 < 10) {
                if (this.i == this.g) {
                    i(1);
                }
                byte[] bArr2 = this.f;
                int i5 = this.i;
                this.i = i5 + 1;
                if (bArr2[i5] < 0) {
                    i3++;
                }
            }
            throw new n1("CodedInputStream encountered a malformed varint.");
            return true;
        }
        if (i2 == 1) {
            j(8);
            return true;
        }
        if (i2 == 2) {
            j(m());
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
            j(4);
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
            this.l = iD;
            z();
            return;
        }
        throw new n1("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final q e() throws IOException {
        int iM = m();
        int i = this.g;
        int i2 = this.i;
        if (iM <= i - i2 && iM > 0) {
            byte[] bArr = this.f;
            q qVar = s.b;
            s.a(i2, i2 + iM, bArr.length);
            q qVar2 = new q(s.c.a(bArr, i2, iM));
            this.i += iM;
            return qVar2;
        }
        if (iM == 0) {
            return s.b;
        }
        byte[] bArrG = g(iM);
        if (bArrG != null) {
            int length = bArrG.length;
            s.a(0, length, bArrG.length);
            return new q(s.c.a(bArrG, 0, length));
        }
        int i3 = this.i;
        int i4 = this.g;
        int length2 = i4 - i3;
        this.k += i4;
        this.i = 0;
        this.g = 0;
        ArrayList<byte[]> arrayListH = h(iM - length2);
        byte[] bArr2 = new byte[iM];
        System.arraycopy(this.f, i3, bArr2, 0, length2);
        for (byte[] bArr3 : arrayListH) {
            System.arraycopy(bArr3, 0, bArr2, length2, bArr3.length);
            length2 += bArr3.length;
        }
        q qVar3 = s.b;
        return new q(bArr2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.w
    public final int a() {
        int i = this.l;
        if (i == Integer.MAX_VALUE) {
            return -1;
        }
        return i - (this.k + this.i);
    }
}
