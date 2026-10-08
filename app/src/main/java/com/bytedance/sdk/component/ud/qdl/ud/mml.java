package com.bytedance.sdk.component.ud.qdl.ud;

import com.google.common.base.Ascii;
import io.ktor.util.date.GMTDateParser;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class mml implements Serializable, Comparable<mml> {
    final byte[] mml;
    transient String mo;
    transient int mzz;
    static final char[] qdl = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', GMTDateParser.DAY_OF_MONTH, 'e', 'f'};
    public static final Charset ud = Charset.forName("UTF-8");
    public static final mml lnr = qdl(new byte[0]);

    mml(byte[] bArr) {
        this.mml = bArr;
    }

    public static mml qdl(byte... bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("data == null");
        }
        return new mml((byte[]) bArr.clone());
    }

    public String qdl() {
        String str = this.mo;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.mml, ud);
        this.mo = str2;
        return str2;
    }

    public String ud() {
        byte[] bArr = this.mml;
        char[] cArr = new char[bArr.length * 2];
        int i = 0;
        for (byte b : bArr) {
            int i2 = i + 1;
            char[] cArr2 = qdl;
            cArr[i] = cArr2[(b >> 4) & 15];
            i += 2;
            cArr[i2] = cArr2[b & Ascii.SI];
        }
        return new String(cArr);
    }

    public mml qdl(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("beginIndex < 0");
        }
        byte[] bArr = this.mml;
        if (i2 > bArr.length) {
            throw new IllegalArgumentException("endIndex > length(" + this.mml.length + ")");
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        if (i == 0 && i2 == bArr.length) {
            return this;
        }
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i, bArr2, 0, i3);
        return new mml(bArr2);
    }

    public byte qdl(int i) {
        return this.mml[i];
    }

    public int lnr() {
        return this.mml.length;
    }

    public byte[] mml() {
        return (byte[]) this.mml.clone();
    }

    public boolean qdl(int i, mml mmlVar, int i2, int i3) {
        return mmlVar.qdl(i2, this.mml, i, i3);
    }

    public boolean qdl(int i, byte[] bArr, int i2, int i3) {
        if (i < 0) {
            return false;
        }
        byte[] bArr2 = this.mml;
        return i <= bArr2.length - i3 && i2 >= 0 && i2 <= bArr.length - i3 && tvp.qdl(bArr2, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof mml) {
            mml mmlVar = (mml) obj;
            int iLnr = mmlVar.lnr();
            byte[] bArr = this.mml;
            if (iLnr == bArr.length && mmlVar.qdl(0, bArr, 0, bArr.length)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = this.mzz;
        if (i != 0) {
            return i;
        }
        int iHashCode = Arrays.hashCode(this.mml);
        this.mzz = iHashCode;
        return iHashCode;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: qdl, reason: merged with bridge method [inline-methods] */
    public int compareTo(mml mmlVar) {
        int iLnr = lnr();
        int iLnr2 = mmlVar.lnr();
        int iMin = Math.min(iLnr, iLnr2);
        for (int i = 0; i < iMin; i++) {
            int iQdl = qdl(i) & 255;
            int iQdl2 = mmlVar.qdl(i) & 255;
            if (iQdl != iQdl2) {
                return iQdl < iQdl2 ? -1 : 1;
            }
        }
        if (iLnr == iLnr2) {
            return 0;
        }
        return iLnr < iLnr2 ? -1 : 1;
    }

    public String toString() {
        if (this.mml.length == 0) {
            return "[size=0]";
        }
        String strQdl = qdl();
        int iQdl = qdl(strQdl, 64);
        if (iQdl == -1) {
            if (this.mml.length <= 64) {
                return "[hex=" + ud() + "]";
            }
            return "[size=" + this.mml.length + " hex=" + qdl(0, 64).ud() + "…]";
        }
        String strReplace = strQdl.substring(0, iQdl).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
        if (iQdl >= strQdl.length()) {
            return "[text=" + strReplace + "]";
        }
        return "[size=" + this.mml.length + " text=" + strReplace + "…]";
    }

    static int qdl(String str, int i) {
        int length = str.length();
        int iCharCount = 0;
        int i2 = 0;
        while (iCharCount < length) {
            if (i2 == i) {
                return iCharCount;
            }
            int iCodePointAt = str.codePointAt(iCharCount);
            if ((Character.isISOControl(iCodePointAt) && iCodePointAt != 10 && iCodePointAt != 13) || iCodePointAt == 65533) {
                return -1;
            }
            i2++;
            iCharCount += Character.charCount(iCodePointAt);
        }
        return str.length();
    }
}
