package com.tnkfactory.framework.crypto;

/* JADX INFO: loaded from: classes6.dex */
public class RC4Cryptor implements Cryptor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f3239a;
    public int[] b = new int[256];
    public int c = 0;
    public int d = 0;

    public RC4Cryptor(byte[] bArr) {
        this.f3239a = bArr;
    }

    public final void a(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }

    @Override // com.tnkfactory.framework.crypto.Cryptor
    public int decrypt(int i) {
        int i2 = (this.c + 1) & 255;
        this.c = i2;
        int[] iArr = this.b;
        int i3 = (iArr[i2] + this.d) & 255;
        this.d = i3;
        a(iArr, i2, i3);
        int[] iArr2 = this.b;
        return i ^ ((byte) iArr2[(iArr2[this.c] + iArr2[this.d]) & 255]);
    }

    @Override // com.tnkfactory.framework.crypto.Cryptor
    public void decrypt(byte[] bArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = (this.c + 1) & 255;
            this.c = i4;
            int[] iArr = this.b;
            int i5 = (iArr[i4] + this.d) & 255;
            this.d = i5;
            a(iArr, i4, i5);
            int[] iArr2 = this.b;
            int i6 = (iArr2[this.c] + iArr2[this.d]) & 255;
            int i7 = i + i3;
            bArr[i7] = (byte) (((byte) iArr2[i6]) ^ bArr[i7]);
        }
    }

    @Override // com.tnkfactory.framework.crypto.Cryptor
    public int encrypt(int i) {
        int i2 = (this.c + 1) & 255;
        this.c = i2;
        int[] iArr = this.b;
        int i3 = (iArr[i2] + this.d) & 255;
        this.d = i3;
        a(iArr, i2, i3);
        int[] iArr2 = this.b;
        return i ^ ((byte) iArr2[(iArr2[this.c] + iArr2[this.d]) & 255]);
    }

    @Override // com.tnkfactory.framework.crypto.Cryptor
    public void encrypt(byte[] bArr, int i, int i2) {
        decrypt(bArr, i, i2);
    }

    @Override // com.tnkfactory.framework.crypto.Cryptor
    public Cryptor init() {
        int i = 0;
        this.c = 0;
        this.d = 0;
        byte[] bArr = this.f3239a;
        if (bArr.length < 1 || bArr.length > 32) {
            throw new IllegalArgumentException("number of bytes must be between 1 and 32");
        }
        int i2 = 0;
        while (true) {
            int[] iArr = this.b;
            if (i2 >= iArr.length) {
                break;
            }
            iArr[i2] = i2;
            i2++;
        }
        int length = 0;
        int i3 = 0;
        while (true) {
            int[] iArr2 = this.b;
            if (i >= iArr2.length) {
                return this;
            }
            int i4 = this.f3239a[length];
            if (i4 < 0) {
                i4 += 256;
            }
            i3 = ((i4 + iArr2[i]) + i3) % 256;
            a(iArr2, i, i3);
            length = (length + 1) % this.f3239a.length;
            i++;
        }
    }
}
