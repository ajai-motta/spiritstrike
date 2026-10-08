package com.tnkfactory.framework.crypto;

/* JADX INFO: loaded from: classes6.dex */
public class MD5Hash {
    public static final byte[] d = {-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public MD5State f3237a;
    public MD5State b;
    public int[] c = new int[16];

    public class MD5State {
        public long c;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f3238a = true;
        public int[] b = new int[4];
        public byte[] d = new byte[64];

        public /* synthetic */ MD5State(MD5Hash mD5Hash, AnonymousClass1 anonymousClass1) {
            a();
        }

        public final void a() {
            int[] iArr = this.b;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.c = 0L;
        }

        public final void a(MD5State mD5State) {
            byte[] bArr = mD5State.d;
            byte[] bArr2 = this.d;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int[] iArr = mD5State.b;
            int[] iArr2 = this.b;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.f3238a = mD5State.f3238a;
            this.c = mD5State.c;
        }
    }

    public MD5Hash() {
        AnonymousClass1 anonymousClass1 = null;
        this.f3237a = new MD5State(this, anonymousClass1);
        this.b = new MD5State(this, anonymousClass1);
        reset();
    }

    public static int a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & i2) | (i4 & (~i2))) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public static void a(MD5State mD5State, int[] iArr) {
        int[] iArr2 = mD5State.b;
        int i = iArr2[0];
        int i2 = iArr2[1];
        int i3 = iArr2[2];
        int i4 = iArr2[3];
        int iA = a(i, i2, i3, i4, iArr[0], 7, -680876936);
        int iA2 = a(i4, iA, i2, i3, iArr[1], 12, -389564586);
        int iA3 = a(i3, iA2, iA, i2, iArr[2], 17, 606105819);
        int iA4 = a(i2, iA3, iA2, iA, iArr[3], 22, -1044525330);
        int iA5 = a(iA, iA4, iA3, iA2, iArr[4], 7, -176418897);
        int iA6 = a(iA2, iA5, iA4, iA3, iArr[5], 12, 1200080426);
        int iA7 = a(iA3, iA6, iA5, iA4, iArr[6], 17, -1473231341);
        int iA8 = a(iA4, iA7, iA6, iA5, iArr[7], 22, -45705983);
        int iA9 = a(iA5, iA8, iA7, iA6, iArr[8], 7, 1770035416);
        int iA10 = a(iA6, iA9, iA8, iA7, iArr[9], 12, -1958414417);
        int iA11 = a(iA7, iA10, iA9, iA8, iArr[10], 17, -42063);
        int iA12 = a(iA8, iA11, iA10, iA9, iArr[11], 22, -1990404162);
        int iA13 = a(iA9, iA12, iA11, iA10, iArr[12], 7, 1804603682);
        int iA14 = a(iA10, iA13, iA12, iA11, iArr[13], 12, -40341101);
        int iA15 = a(iA11, iA14, iA13, iA12, iArr[14], 17, -1502002290);
        int iA16 = a(iA12, iA15, iA14, iA13, iArr[15], 22, 1236535329);
        int iB = b(iA13, iA16, iA15, iA14, iArr[1], 5, -165796510);
        int iB2 = b(iA14, iB, iA16, iA15, iArr[6], 9, -1069501632);
        int iB3 = b(iA15, iB2, iB, iA16, iArr[11], 14, 643717713);
        int iB4 = b(iA16, iB3, iB2, iB, iArr[0], 20, -373897302);
        int iB5 = b(iB, iB4, iB3, iB2, iArr[5], 5, -701558691);
        int iB6 = b(iB2, iB5, iB4, iB3, iArr[10], 9, 38016083);
        int iB7 = b(iB3, iB6, iB5, iB4, iArr[15], 14, -660478335);
        int iB8 = b(iB4, iB7, iB6, iB5, iArr[4], 20, -405537848);
        int iB9 = b(iB5, iB8, iB7, iB6, iArr[9], 5, 568446438);
        int iB10 = b(iB6, iB9, iB8, iB7, iArr[14], 9, -1019803690);
        int iB11 = b(iB7, iB10, iB9, iB8, iArr[3], 14, -187363961);
        int iB12 = b(iB8, iB11, iB10, iB9, iArr[8], 20, 1163531501);
        int iB13 = b(iB9, iB12, iB11, iB10, iArr[13], 5, -1444681467);
        int iB14 = b(iB10, iB13, iB12, iB11, iArr[2], 9, -51403784);
        int iB15 = b(iB11, iB14, iB13, iB12, iArr[7], 14, 1735328473);
        int iB16 = b(iB12, iB15, iB14, iB13, iArr[12], 20, -1926607734);
        int iC = c(iB13, iB16, iB15, iB14, iArr[5], 4, -378558);
        int iC2 = c(iB14, iC, iB16, iB15, iArr[8], 11, -2022574463);
        int iC3 = c(iB15, iC2, iC, iB16, iArr[11], 16, 1839030562);
        int iC4 = c(iB16, iC3, iC2, iC, iArr[14], 23, -35309556);
        int iC5 = c(iC, iC4, iC3, iC2, iArr[1], 4, -1530992060);
        int iC6 = c(iC2, iC5, iC4, iC3, iArr[4], 11, 1272893353);
        int iC7 = c(iC3, iC6, iC5, iC4, iArr[7], 16, -155497632);
        int iC8 = c(iC4, iC7, iC6, iC5, iArr[10], 23, -1094730640);
        int iC9 = c(iC5, iC8, iC7, iC6, iArr[13], 4, 681279174);
        int iC10 = c(iC6, iC9, iC8, iC7, iArr[0], 11, -358537222);
        int iC11 = c(iC7, iC10, iC9, iC8, iArr[3], 16, -722521979);
        int iC12 = c(iC8, iC11, iC10, iC9, iArr[6], 23, 76029189);
        int iC13 = c(iC9, iC12, iC11, iC10, iArr[9], 4, -640364487);
        int iC14 = c(iC10, iC13, iC12, iC11, iArr[12], 11, -421815835);
        int iC15 = c(iC11, iC14, iC13, iC12, iArr[15], 16, 530742520);
        int iC16 = c(iC12, iC15, iC14, iC13, iArr[2], 23, -995338651);
        int iD = d(iC13, iC16, iC15, iC14, iArr[0], 6, -198630844);
        int iD2 = d(iC14, iD, iC16, iC15, iArr[7], 10, 1126891415);
        int iD3 = d(iC15, iD2, iD, iC16, iArr[14], 15, -1416354905);
        int iD4 = d(iC16, iD3, iD2, iD, iArr[5], 21, -57434055);
        int iD5 = d(iD, iD4, iD3, iD2, iArr[12], 6, 1700485571);
        int iD6 = d(iD2, iD5, iD4, iD3, iArr[3], 10, -1894986606);
        int iD7 = d(iD3, iD6, iD5, iD4, iArr[10], 15, -1051523);
        int iD8 = d(iD4, iD7, iD6, iD5, iArr[1], 21, -2054922799);
        int iD9 = d(iD5, iD8, iD7, iD6, iArr[8], 6, 1873313359);
        int iD10 = d(iD6, iD9, iD8, iD7, iArr[15], 10, -30611744);
        int iD11 = d(iD7, iD10, iD9, iD8, iArr[6], 15, -1560198380);
        int iD12 = d(iD8, iD11, iD10, iD9, iArr[13], 21, 1309151649);
        int iD13 = d(iD9, iD12, iD11, iD10, iArr[4], 6, -145523070);
        int iD14 = d(iD10, iD13, iD12, iD11, iArr[11], 10, -1120210379);
        int iD15 = d(iD11, iD14, iD13, iD12, iArr[2], 15, 718787259);
        int iD16 = d(iD12, iD15, iD14, iD13, iArr[9], 21, -343485551);
        int[] iArr3 = mD5State.b;
        iArr3[0] = iArr3[0] + iD13;
        iArr3[1] = iArr3[1] + iD16;
        iArr3[2] = iArr3[2] + iD15;
        iArr3[3] = iArr3[3] + iD14;
    }

    public static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & (~i4)) | (i2 & i4)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public static int c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 ^ i2) ^ i4) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public static int d(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + (i3 ^ ((~i4) | i2)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public final int[] a(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 += 4) {
            this.c[i3] = (bArr[i4 + i2] & 255) | ((bArr[(i4 + 1) + i2] & 255) << 8) | ((bArr[(i4 + 2) + i2] & 255) << 16) | ((bArr[(i4 + 3) + i2] & 255) << 24);
            i3++;
        }
        return this.c;
    }

    public byte[] getHash() {
        int i;
        MD5State mD5State = this.b;
        if (mD5State.f3238a) {
            i = 0;
        } else {
            mD5State.a(this.f3237a);
            int i2 = (int) ((this.b.c >>> 3) & 63);
            a(this.b, d, 0, i2 < 56 ? 56 - i2 : 120 - i2);
            i = 0;
            a(this.b, new byte[]{(byte) (r1 & 255), (byte) ((r1 >>> 8) & 255), (byte) ((r1 >>> 16) & 255), (byte) ((r1 >>> 24) & 255), (byte) ((r1 >>> 32) & 255), (byte) ((r1 >>> 40) & 255), (byte) ((r1 >>> 48) & 255), (byte) ((r1 >>> 56) & 255)}, 0, 8);
            this.b.f3238a = true;
        }
        int[] iArr = this.b.b;
        byte[] bArr = new byte[16];
        for (int i3 = i; i3 < 16; i3 += 4) {
            int i4 = iArr[i];
            bArr[i3] = (byte) (i4 & 255);
            bArr[i3 + 1] = (byte) ((i4 >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((i4 >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((i4 >>> 24) & 255);
            i++;
        }
        return bArr;
    }

    public void reset() {
        this.f3237a.a();
        this.b.f3238a = false;
    }

    public void update(byte[] bArr) {
        update(bArr, 0, bArr.length);
    }

    public void update(byte[] bArr, int i, int i2) {
        a(this.f3237a, bArr, i, i2);
    }

    public final void a(MD5State mD5State, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.b.f3238a = false;
        if (i2 + i > bArr.length) {
            i2 = bArr.length - i;
        }
        long j = mD5State.c;
        int i4 = ((int) (j >>> 3)) & 63;
        mD5State.c = j + ((long) (i2 << 3));
        int i5 = 64 - i4;
        if (i2 >= i5) {
            System.arraycopy(bArr, i, mD5State.d, i4, i5);
            a(mD5State, a(mD5State.d, 64, 0));
            while (i5 + 63 < i2) {
                a(mD5State, a(bArr, 64, i5));
                i5 += 64;
            }
            i4 = 0;
            i3 = i5;
        }
        if (i3 < i2) {
            for (int i6 = i3; i6 < i2; i6++) {
                mD5State.d[(i4 + i6) - i3] = bArr[i6 + i];
            }
        }
    }
}
