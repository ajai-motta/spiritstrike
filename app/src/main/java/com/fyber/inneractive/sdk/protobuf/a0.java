package com.fyber.inneractive.sdk.protobuf;

import androidx.work.WorkInfo;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 extends b0 {
    public final byte[] d;
    public final int e;
    public int f;
    public final OutputStream g;

    public a0(OutputStream outputStream, int i) {
        if (i < 0) {
            throw new IllegalArgumentException("bufferSize must be >= 0");
        }
        int iMax = Math.max(i, 20);
        this.d = new byte[iMax];
        this.e = iMax;
        if (outputStream == null) {
            throw new NullPointerException("out");
        }
        this.g = outputStream;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, int i2) {
        j(14);
        e(i, 5);
        h(i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, int i2) {
        j(20);
        e(i, 0);
        if (i2 >= 0) {
            i(i2);
        } else {
            f(i2);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void c(int i, int i2) {
        j(5);
        i((i << 3) | i2);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void d(int i, int i2) {
        j(20);
        e(i, 0);
        i(i2);
    }

    public final void e(int i, int i2) {
        i((i << 3) | i2);
    }

    public final void f(long j) {
        if (!b0.c) {
            while ((j & (-128)) != 0) {
                byte[] bArr = this.d;
                int i = this.f;
                this.f = i + 1;
                bArr[i] = (byte) ((((int) j) & 127) | 128);
                j >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr2[i2] = (byte) j;
            return;
        }
        while ((j & (-128)) != 0) {
            byte[] bArr3 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            x3.c.a((Object) bArr3, x3.f + ((long) i3), (byte) ((((int) j) & 127) | 128));
            j >>>= 7;
        }
        byte[] bArr4 = this.d;
        int i4 = this.f;
        this.f = i4 + 1;
        x3.c.a((Object) bArr4, x3.f + ((long) i4), (byte) j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void g(int i) {
        j(5);
        i(i);
    }

    public final void h(int i) {
        byte[] bArr = this.d;
        int i2 = this.f;
        bArr[i2] = (byte) (i & 255);
        bArr[i2 + 1] = (byte) ((i >> 8) & 255);
        bArr[i2 + 2] = (byte) ((i >> 16) & 255);
        this.f = i2 + 4;
        bArr[i2 + 3] = (byte) ((i >> 24) & 255);
    }

    public final void i(int i) {
        if (!b0.c) {
            while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
                byte[] bArr = this.d;
                int i2 = this.f;
                this.f = i2 + 1;
                bArr[i2] = (byte) ((i & 127) | 128);
                i >>>= 7;
            }
            byte[] bArr2 = this.d;
            int i3 = this.f;
            this.f = i3 + 1;
            bArr2[i3] = (byte) i;
            return;
        }
        while ((i & WorkInfo.STOP_REASON_FOREGROUND_SERVICE_TIMEOUT) != 0) {
            byte[] bArr3 = this.d;
            int i4 = this.f;
            this.f = i4 + 1;
            x3.c.a((Object) bArr3, x3.f + ((long) i4), (byte) ((i & 127) | 128));
            i >>>= 7;
        }
        byte[] bArr4 = this.d;
        int i5 = this.f;
        this.f = i5 + 1;
        x3.c.a((Object) bArr4, x3.f + ((long) i5), (byte) i);
    }

    public final void j(int i) {
        if (this.e - this.f < i) {
            a();
        }
    }

    public final void e(long j) {
        byte[] bArr = this.d;
        int i = this.f;
        bArr[i] = (byte) (j & 255);
        bArr[i + 1] = (byte) ((j >> 8) & 255);
        bArr[i + 2] = (byte) ((j >> 16) & 255);
        bArr[i + 3] = (byte) (255 & (j >> 24));
        bArr[i + 4] = (byte) (((int) (j >> 32)) & 255);
        bArr[i + 5] = (byte) (((int) (j >> 40)) & 255);
        bArr[i + 6] = (byte) (((int) (j >> 48)) & 255);
        this.f = i + 8;
        bArr[i + 7] = (byte) (((int) (j >> 56)) & 255);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void c(long j) {
        j(8);
        e(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, long j) {
        j(18);
        e(i, 1);
        e(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void d(long j) {
        j(10);
        f(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, boolean z) {
        j(11);
        e(i, 0);
        byte b = z ? (byte) 1 : (byte) 0;
        byte[] bArr = this.d;
        int i2 = this.f;
        this.f = i2 + 1;
        bArr[i2] = b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, long j) {
        j(20);
        e(i, 0);
        f(j);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(String str, int i) throws IOException {
        c(i, 2);
        b(str);
    }

    public final void b(s sVar) {
        int size = sVar.size();
        j(5);
        i(size);
        sVar.a(this);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void e(int i) {
        j(4);
        h(i);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void f(int i) {
        if (i >= 0) {
            j(5);
            i(i);
        } else {
            j(10);
            f(i);
        }
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, s sVar) {
        c(i, 2);
        b(sVar);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, d2 d2Var, t2 t2Var) {
        c(i, 2);
        int serializedSize = ((b) d2Var).getSerializedSize(t2Var);
        j(5);
        i(serializedSize);
        t2Var.a((Object) d2Var, this.f1540a);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void b(int i, s sVar) {
        c(1, 3);
        d(2, i);
        c(3, 2);
        b(sVar);
        c(1, 4);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(int i, d2 d2Var) {
        c(1, 3);
        d(2, i);
        c(3, 2);
        a(d2Var);
        c(1, 4);
    }

    public final void b(String str) throws IOException {
        try {
            int length = str.length() * 3;
            int iC = b0.c(length);
            int i = iC + length;
            int i2 = this.e;
            if (i > i2) {
                byte[] bArr = new byte[length];
                int iA = d4.f1547a.a(str, bArr, 0, length);
                j(5);
                i(iA);
                b(bArr, 0, iA);
                return;
            }
            if (i > i2 - this.f) {
                a();
            }
            int iC2 = b0.c(str.length());
            int i3 = this.f;
            try {
                if (iC2 == iC) {
                    int i4 = i3 + iC2;
                    this.f = i4;
                    int iA2 = d4.f1547a.a(str, this.d, i4, this.e - i4);
                    this.f = i3;
                    i((iA2 - i3) - iC2);
                    this.f = iA2;
                } else {
                    int iA3 = d4.a(str);
                    i(iA3);
                    this.f = d4.f1547a.a(str, this.d, this.f, iA3);
                }
            } catch (b4 e) {
                this.f = i3;
                throw e;
            } catch (ArrayIndexOutOfBoundsException e2) {
                throw new z(e2);
            }
        } catch (b4 e3) {
            a(str, e3);
        }
    }

    public final void a(d2 d2Var) {
        int serializedSize = d2Var.getSerializedSize();
        j(5);
        i(serializedSize);
        d2Var.writeTo(this);
    }

    @Override // com.fyber.inneractive.sdk.protobuf.b0
    public final void a(byte b) {
        if (this.f == this.e) {
            a();
        }
        byte[] bArr = this.d;
        int i = this.f;
        this.f = i + 1;
        bArr[i] = b;
    }

    @Override // com.fyber.inneractive.sdk.protobuf.k
    public final void a(byte[] bArr, int i, int i2) throws IOException {
        b(bArr, i, i2);
    }

    public final void a() {
        this.g.write(this.d, 0, this.f);
        this.f = 0;
    }

    public final void b(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.e;
        int i4 = this.f;
        int i5 = i3 - i4;
        if (i5 >= i2) {
            System.arraycopy(bArr, i, this.d, i4, i2);
            this.f += i2;
            return;
        }
        System.arraycopy(bArr, i, this.d, i4, i5);
        int i6 = i + i5;
        int i7 = i2 - i5;
        this.f = this.e;
        a();
        if (i7 <= this.e) {
            System.arraycopy(bArr, i6, this.d, 0, i7);
            this.f = i7;
        } else {
            this.g.write(bArr, i6, i7);
        }
    }
}
