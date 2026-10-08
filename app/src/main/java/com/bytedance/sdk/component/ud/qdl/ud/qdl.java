package com.bytedance.sdk.component.ud.qdl.ud;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.EOFException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: loaded from: classes3.dex */
public final class qdl implements lnr, ud, Cloneable, ByteChannel {
    private static final byte[] lnr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102};
    mzz qdl;
    long ud;

    @Override // java.io.Closeable, java.lang.AutoCloseable, java.nio.channels.Channel
    public void close() {
    }

    @Override // java.io.Flushable
    public void flush() {
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return true;
    }

    public boolean qdl() {
        return this.ud == 0;
    }

    public byte ud() {
        if (this.ud == 0) {
            throw new IllegalStateException("size == 0");
        }
        mzz mzzVar = this.qdl;
        int i = mzzVar.ud;
        int i2 = mzzVar.lnr;
        int i3 = i + 1;
        byte b = mzzVar.qdl[i];
        this.ud--;
        if (i3 == i2) {
            this.qdl = mzzVar.ud();
            mo.qdl(mzzVar);
        } else {
            mzzVar.ud = i3;
        }
        return b;
    }

    public String lnr() {
        try {
            return qdl(this.ud, tvp.qdl);
        } catch (EOFException e) {
            throw new AssertionError(e);
        }
    }

    public String qdl(long j, Charset charset) throws EOFException {
        tvp.qdl(this.ud, 0L, j);
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        if (j == 0) {
            return "";
        }
        mzz mzzVar = this.qdl;
        if (((long) mzzVar.ud) + j > mzzVar.lnr) {
            return new String(qdl(j), charset);
        }
        String str = new String(mzzVar.qdl, mzzVar.ud, (int) j, charset);
        mzzVar.ud = (int) (((long) mzzVar.ud) + j);
        this.ud -= j;
        if (mzzVar.ud == mzzVar.lnr) {
            this.qdl = mzzVar.ud();
            mo.qdl(mzzVar);
        }
        return str;
    }

    public byte[] qdl(long j) throws EOFException {
        tvp.qdl(this.ud, 0L, j);
        if (j > 2147483647L) {
            throw new IllegalArgumentException("byteCount > Integer.MAX_VALUE: ".concat(String.valueOf(j)));
        }
        byte[] bArr = new byte[(int) j];
        qdl(bArr);
        return bArr;
    }

    public void qdl(byte[] bArr) throws EOFException {
        int i = 0;
        while (i < bArr.length) {
            int iQdl = qdl(bArr, i, bArr.length - i);
            if (iQdl == -1) {
                throw new EOFException();
            }
            i += iQdl;
        }
    }

    public int qdl(byte[] bArr, int i, int i2) {
        tvp.qdl(bArr.length, i, i2);
        mzz mzzVar = this.qdl;
        if (mzzVar == null) {
            return -1;
        }
        int iMin = Math.min(i2, mzzVar.lnr - mzzVar.ud);
        System.arraycopy(mzzVar.qdl, mzzVar.ud, bArr, i, iMin);
        mzzVar.ud += iMin;
        this.ud -= (long) iMin;
        if (mzzVar.ud == mzzVar.lnr) {
            this.qdl = mzzVar.ud();
            mo.qdl(mzzVar);
        }
        return iMin;
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(ByteBuffer byteBuffer) throws IOException {
        mzz mzzVar = this.qdl;
        if (mzzVar == null) {
            return -1;
        }
        int iMin = Math.min(byteBuffer.remaining(), mzzVar.lnr - mzzVar.ud);
        byteBuffer.put(mzzVar.qdl, mzzVar.ud, iMin);
        mzzVar.ud += iMin;
        this.ud -= (long) iMin;
        if (mzzVar.ud == mzzVar.lnr) {
            this.qdl = mzzVar.ud();
            mo.qdl(mzzVar);
        }
        return iMin;
    }

    public qdl qdl(String str) {
        return qdl(str, 0, str.length());
    }

    public qdl qdl(String str, int i, int i2) {
        char cCharAt;
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        while (i < i2) {
            char cCharAt2 = str.charAt(i);
            if (cCharAt2 < 128) {
                mzz mzzVarLnr = lnr(1);
                byte[] bArr = mzzVarLnr.qdl;
                int i3 = mzzVarLnr.lnr - i;
                int iMin = Math.min(i2, 8192 - i3);
                int i4 = i + 1;
                bArr[i + i3] = (byte) cCharAt2;
                while (true) {
                    i = i4;
                    if (i >= iMin || (cCharAt = str.charAt(i)) >= 128) {
                        break;
                    }
                    i4 = i + 1;
                    bArr[i + i3] = (byte) cCharAt;
                }
                int i5 = (i3 + i) - mzzVarLnr.lnr;
                mzzVarLnr.lnr += i5;
                this.ud += (long) i5;
            } else {
                if (cCharAt2 < 2048) {
                    ud((cCharAt2 >> 6) | PsExtractor.AUDIO_STREAM);
                    ud((cCharAt2 & '?') | 128);
                } else if (cCharAt2 < 55296 || cCharAt2 > 57343) {
                    ud((cCharAt2 >> '\f') | 224);
                    ud(((cCharAt2 >> 6) & 63) | 128);
                    ud((cCharAt2 & '?') | 128);
                } else {
                    int i6 = i + 1;
                    char cCharAt3 = i6 < i2 ? str.charAt(i6) : (char) 0;
                    if (cCharAt2 > 56319 || cCharAt3 < 56320 || cCharAt3 > 57343) {
                        ud(63);
                        i = i6;
                    } else {
                        int i7 = (((cCharAt2 & 10239) << 10) | (9215 & cCharAt3)) + 65536;
                        ud((i7 >> 18) | PsExtractor.VIDEO_STREAM_MASK);
                        ud(((i7 >> 12) & 63) | 128);
                        ud(((i7 >> 6) & 63) | 128);
                        ud((i7 & 63) | 128);
                        i += 2;
                    }
                }
                i++;
            }
        }
        return this;
    }

    public qdl qdl(int i) {
        if (i < 128) {
            ud(i);
        } else if (i < 2048) {
            ud((i >> 6) | PsExtractor.AUDIO_STREAM);
            ud((i & 63) | 128);
        } else if (i < 65536) {
            if (i >= 55296 && i <= 57343) {
                ud(63);
            } else {
                ud((i >> 12) | 224);
                ud(((i >> 6) & 63) | 128);
                ud((i & 63) | 128);
            }
        } else if (i <= 1114111) {
            ud((i >> 18) | PsExtractor.VIDEO_STREAM_MASK);
            ud(((i >> 12) & 63) | 128);
            ud(((i >> 6) & 63) | 128);
            ud((i & 63) | 128);
        } else {
            throw new IllegalArgumentException("Unexpected code point: " + Integer.toHexString(i));
        }
        return this;
    }

    public qdl qdl(String str, int i, int i2, Charset charset) {
        if (str == null) {
            throw new IllegalArgumentException("string == null");
        }
        if (i < 0) {
            throw new IllegalAccessError("beginIndex < 0: ".concat(String.valueOf(i)));
        }
        if (i2 < i) {
            throw new IllegalArgumentException("endIndex < beginIndex: " + i2 + " < " + i);
        }
        if (i2 > str.length()) {
            throw new IllegalArgumentException("endIndex > string.length: " + i2 + " > " + str.length());
        }
        if (charset == null) {
            throw new IllegalArgumentException("charset == null");
        }
        if (charset.equals(tvp.qdl)) {
            return qdl(str, i, i2);
        }
        byte[] bytes = str.substring(i, i2).getBytes(charset);
        return ud(bytes, 0, bytes.length);
    }

    public qdl ud(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            throw new IllegalArgumentException("source == null");
        }
        long j = i2;
        tvp.qdl(bArr.length, i, j);
        int i3 = i2 + i;
        while (i < i3) {
            mzz mzzVarLnr = lnr(1);
            int iMin = Math.min(i3 - i, 8192 - mzzVarLnr.lnr);
            System.arraycopy(bArr, i, mzzVarLnr.qdl, mzzVarLnr.lnr, iMin);
            i += iMin;
            mzzVarLnr.lnr += iMin;
        }
        this.ud += j;
        return this;
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            throw new IllegalArgumentException("source == null");
        }
        int iRemaining = byteBuffer.remaining();
        int i = iRemaining;
        while (i > 0) {
            mzz mzzVarLnr = lnr(1);
            int iMin = Math.min(i, 8192 - mzzVarLnr.lnr);
            byteBuffer.get(mzzVarLnr.qdl, mzzVarLnr.lnr, iMin);
            i -= iMin;
            mzzVarLnr.lnr += iMin;
        }
        this.ud += (long) iRemaining;
        return iRemaining;
    }

    public qdl ud(int i) {
        mzz mzzVarLnr = lnr(1);
        byte[] bArr = mzzVarLnr.qdl;
        int i2 = mzzVarLnr.lnr;
        mzzVarLnr.lnr = i2 + 1;
        bArr[i2] = (byte) i;
        this.ud++;
        return this;
    }

    public qdl ud(long j) {
        if (j == 0) {
            return ud(48);
        }
        int iNumberOfTrailingZeros = (Long.numberOfTrailingZeros(Long.highestOneBit(j)) / 4) + 1;
        mzz mzzVarLnr = lnr(iNumberOfTrailingZeros);
        byte[] bArr = mzzVarLnr.qdl;
        int i = mzzVarLnr.lnr;
        for (int i2 = (mzzVarLnr.lnr + iNumberOfTrailingZeros) - 1; i2 >= i; i2--) {
            bArr[i2] = lnr[(int) (15 & j)];
            j >>>= 4;
        }
        mzzVarLnr.lnr += iNumberOfTrailingZeros;
        this.ud += (long) iNumberOfTrailingZeros;
        return this;
    }

    mzz lnr(int i) {
        if (i <= 0 || i > 8192) {
            throw new IllegalArgumentException();
        }
        mzz mzzVar = this.qdl;
        if (mzzVar == null) {
            mzz mzzVarQdl = mo.qdl();
            this.qdl = mzzVarQdl;
            mzzVarQdl.wd = mzzVarQdl;
            mzzVarQdl.mo = mzzVarQdl;
            return mzzVarQdl;
        }
        mzz mzzVar2 = mzzVar.wd;
        return (mzzVar2.lnr + i > 8192 || !mzzVar2.mzz) ? mzzVar2.qdl(mo.qdl()) : mzzVar2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof qdl)) {
            return false;
        }
        qdl qdlVar = (qdl) obj;
        long j = this.ud;
        if (j != qdlVar.ud) {
            return false;
        }
        long j2 = 0;
        if (j == 0) {
            return true;
        }
        mzz mzzVar = this.qdl;
        mzz mzzVar2 = qdlVar.qdl;
        int i = mzzVar.ud;
        int i2 = mzzVar2.ud;
        while (j2 < this.ud) {
            long jMin = Math.min(mzzVar.lnr - i, mzzVar2.lnr - i2);
            int i3 = 0;
            while (i3 < jMin) {
                int i4 = i + 1;
                int i5 = i2 + 1;
                if (mzzVar.qdl[i] != mzzVar2.qdl[i2]) {
                    return false;
                }
                i3++;
                i = i4;
                i2 = i5;
            }
            if (i == mzzVar.lnr) {
                mzzVar = mzzVar.mo;
                i = mzzVar.ud;
            }
            if (i2 == mzzVar2.lnr) {
                mzzVar2 = mzzVar2.mo;
                i2 = mzzVar2.ud;
            }
            j2 += jMin;
        }
        return true;
    }

    public int hashCode() {
        mzz mzzVar = this.qdl;
        if (mzzVar == null) {
            return 0;
        }
        int i = 1;
        do {
            int i2 = mzzVar.lnr;
            for (int i3 = mzzVar.ud; i3 < i2; i3++) {
                i = (i * 31) + mzzVar.qdl[i3];
            }
            mzzVar = mzzVar.mo;
        } while (mzzVar != this.qdl);
        return i;
    }

    public String toString() {
        return mzz().toString();
    }

    /* JADX INFO: renamed from: mml, reason: merged with bridge method [inline-methods] */
    public qdl clone() {
        qdl qdlVar = new qdl();
        if (this.ud == 0) {
            return qdlVar;
        }
        mzz mzzVarQdl = this.qdl.qdl();
        qdlVar.qdl = mzzVarQdl;
        mzzVarQdl.wd = mzzVarQdl;
        mzzVarQdl.mo = mzzVarQdl;
        mzz mzzVar = this.qdl;
        while (true) {
            mzzVar = mzzVar.mo;
            if (mzzVar != this.qdl) {
                qdlVar.qdl.wd.qdl(mzzVar.qdl());
            } else {
                qdlVar.ud = this.ud;
                return qdlVar;
            }
        }
    }

    public final mml mzz() {
        long j = this.ud;
        if (j > 2147483647L) {
            throw new IllegalArgumentException("size > Integer.MAX_VALUE: " + this.ud);
        }
        return mml((int) j);
    }

    public final mml mml(int i) {
        if (i == 0) {
            return mml.lnr;
        }
        return new wd(this, i);
    }
}
