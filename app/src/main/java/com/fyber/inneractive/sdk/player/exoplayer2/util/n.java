package com.fyber.inneractive.sdk.player.exoplayer2.util;

import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f1472a;
    public int b;
    public int c;

    public n() {
    }

    public final int a() {
        byte[] bArr = this.f1472a;
        if (bArr == null) {
            return 0;
        }
        return bArr.length;
    }

    public final int b() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 16) | ((bArr[i] & 255) << 24);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 8);
        this.b = i + 4;
        return (bArr[i3] & 255) | i4;
    }

    public final void c(int i) {
        this.f1472a = a() < i ? new byte[i] : this.f1472a;
        this.c = i;
        this.b = 0;
    }

    public final void d(int i) {
        if (i < 0 || i > this.f1472a.length) {
            throw new IllegalArgumentException();
        }
        this.c = i;
    }

    public final void e(int i) {
        if (i < 0 || i > this.c) {
            throw new IllegalArgumentException();
        }
        this.b = i;
    }

    public final int f() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = bArr[i] & 255;
        this.b = i + 2;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    public final long g() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 7;
        long j = ((((long) bArr[i]) & 255) << 56) | ((((long) bArr[i + 1]) & 255) << 48) | ((((long) bArr[i + 2]) & 255) << 40) | ((((long) bArr[i + 3]) & 255) << 32) | ((((long) bArr[i + 4]) & 255) << 24) | ((((long) bArr[i + 5]) & 255) << 16) | ((((long) bArr[i + 6]) & 255) << 8);
        this.b = i + 8;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final void h() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return;
        }
        while (i2 < this.c && this.f1472a[i2] != 0) {
            i2++;
        }
        byte[] bArr = this.f1472a;
        int i3 = this.b;
        new String(bArr, i3, i2 - i3);
        this.b = i2;
        if (i2 < this.c) {
            this.b = i2 + 1;
        }
    }

    public final int i() {
        return (j() << 21) | (j() << 14) | (j() << 7) | j();
    }

    public final int j() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        this.b = i + 1;
        return bArr[i] & 255;
    }

    public final long k() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 3;
        long j = ((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16) | ((((long) bArr[i + 2]) & 255) << 8);
        this.b = i + 4;
        return (((long) bArr[i2]) & 255) | j;
    }

    public final int l() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 2;
        int i3 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
        this.b = i + 3;
        return (bArr[i2] & 255) | i3;
    }

    public final int m() {
        int iB = b();
        if (iB >= 0) {
            return iB;
        }
        throw new IllegalStateException(com.fyber.inneractive.sdk.player.exoplayer2.m.a("Top bit not zero: ", iB));
    }

    public final long n() {
        long jG = g();
        if (jG >= 0) {
            return jG;
        }
        throw new IllegalStateException("Top bit not zero: " + jG);
    }

    public final int o() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 1;
        int i3 = (bArr[i] & 255) << 8;
        this.b = i + 2;
        return (bArr[i2] & 255) | i3;
    }

    public n(int i) {
        this.f1472a = new byte[i];
        this.c = i;
    }

    public final void a(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f1472a, this.b, bArr, i, i2);
        this.b += i2;
    }

    public final String b(int i) {
        String str = new String(this.f1472a, this.b, i, Charset.defaultCharset());
        this.b += i;
        return str;
    }

    public final String a(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.b;
        int i3 = (i2 + i) - 1;
        String str = new String(this.f1472a, i2, (i3 >= this.c || this.f1472a[i3] != 0) ? i : i - 1);
        this.b += i;
        return str;
    }

    public final int d() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = ((bArr[i + 1] & 255) << 8) | (bArr[i] & 255);
        int i3 = i + 3;
        int i4 = i2 | ((bArr[i + 2] & 255) << 16);
        this.b = i + 4;
        return ((bArr[i3] & 255) << 24) | i4;
    }

    public final long e() {
        byte[] bArr = this.f1472a;
        int i = this.b;
        int i2 = i + 3;
        long j = (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16);
        this.b = i + 4;
        return ((((long) bArr[i2]) & 255) << 24) | j;
    }

    public n(byte[] bArr) {
        this.f1472a = bArr;
        this.c = bArr.length;
    }

    public final String c() {
        int i = this.c;
        int i2 = this.b;
        if (i - i2 == 0) {
            return null;
        }
        while (i2 < this.c) {
            byte b = this.f1472a[i2];
            int i3 = z.f1480a;
            if (b == 10 || b == 13) {
                break;
            }
            i2++;
        }
        int i4 = this.b;
        if (i2 - i4 >= 3) {
            byte[] bArr = this.f1472a;
            if (bArr[i4] == -17 && bArr[i4 + 1] == -69 && bArr[i4 + 2] == -65) {
                this.b = i4 + 3;
            }
        }
        byte[] bArr2 = this.f1472a;
        int i5 = this.b;
        String str = new String(bArr2, i5, i2 - i5);
        this.b = i2;
        int i6 = this.c;
        if (i2 == i6) {
            return str;
        }
        byte[] bArr3 = this.f1472a;
        if (bArr3[i2] == 13) {
            int i7 = i2 + 1;
            this.b = i7;
            if (i7 == i6) {
                return str;
            }
        }
        int i8 = this.b;
        if (bArr3[i8] == 10) {
            this.b = i8 + 1;
        }
        return str;
    }

    public n(int i, byte[] bArr) {
        this.f1472a = bArr;
        this.c = i;
    }
}
