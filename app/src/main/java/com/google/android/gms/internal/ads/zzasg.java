package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzasg {
    public static final zzasg zzb = new zzasg(new byte[0]);
    public static final Comparator zzc = new zzasf();
    public final byte[] zza;

    public zzasg(byte[] bArr) {
        this.zza = bArr;
    }

    public static zzasg zze(byte[] bArr) {
        return new zzasg(zzh(bArr, 0, bArr.length));
    }

    public static zzasg zzf(String str) {
        return zze(str.getBytes(Charset.forName(zzase.zza("Hn2H4l0="))));
    }

    public static int zzg(byte b) {
        int[] iArr = {2107654819, 15074090, 1957914693, -2142502098, -1902504939, -100121615, 100669, 1835342733, 837626799};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        return b & ((iArr[7] % 837626799) ^ (i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6)));
    }

    public static byte[] zzh(byte[] bArr, int i, int i2) {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return bArr2;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzasg) {
            return Arrays.equals(this.zza, ((zzasg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zza);
    }

    public final String toString() {
        int[] iArr = {936621968, 262671172, 1099388327, 506341952, 1363551406, -1491858486, 110389885, 989492335, 981766422};
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        int i4 = iArr[3];
        int i5 = iArr[4];
        int i6 = iArr[5];
        int i7 = iArr[6];
        int i8 = iArr[7];
        int i9 = i7 + ((((i2 & (~i)) | i3) + ((i & i4) | i5)) - i6);
        String string = Arrays.toString(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + ((i8 % 981766422) ^ i9));
        sb.append(zzase.zza("CVC1qiQNJHikW0iU1TIPZA=="));
        sb.append(string);
        sb.append(zzase.zza("Ng=="));
        return sb.toString();
    }

    public final byte[] zza() {
        byte[] bArr = this.zza;
        int length = bArr.length;
        return length == 0 ? new byte[0] : zzh(bArr, 0, length);
    }

    public final byte zzb(int i) {
        int[] iArr = {2106914653, 587408197, 1537377410, 536945509, 443419704, -2054635237, 102375994, 2013725218, 1633938701};
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        int i5 = iArr[3];
        int i6 = iArr[4];
        int i7 = iArr[5];
        int i8 = iArr[6];
        int i9 = iArr[7];
        int i10 = i8 + ((((i3 & (~i2)) | i4) + ((i2 & i5) | i6)) - i7);
        int i11 = i9 % 1633938701;
        iArr[0] = 1287859999;
        iArr[1] = 62941354;
        iArr[2] = 437464817;
        iArr[3] = 1639989262;
        iArr[4] = 1644309956;
        iArr[5] = -2044289941;
        iArr[6] = 189699559;
        iArr[7] = 1442767057;
        iArr[8] = 63299708;
        int i12 = ((((~1287859999) & 62941354) | 437464817) + ((1287859999 & 1639989262) | 1644309956)) - 2060977796;
        int i13 = 1442767057 % 63299708;
        byte[] bArr = this.zza;
        int length = bArr.length;
        if (((length - (i + 1)) | i) >= 0) {
            return bArr[i];
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + (i10 ^ i11));
            sb.append(zzase.zza("Akelqh1fajntGgo="));
            sb.append(i);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(i).length() + (i12 ^ i13) + String.valueOf(length).length());
        sb2.append(zzase.zza("Akelqh1faDmxRUSK1T9GeQ=="));
        sb2.append(i);
        sb2.append(zzase.zza("Zwk="));
        sb2.append(length);
        throw new ArrayIndexOutOfBoundsException(sb2.toString());
    }

    public final String zzc() {
        Charset charsetForName = Charset.forName(zzase.zza("Hn2H4l0="));
        byte[] bArr = this.zza;
        return new String(bArr, 0, bArr.length, charsetForName);
    }

    public final zzasg zzd(zzasg zzasgVar) {
        byte[] bArr = zzasgVar.zza;
        int length = bArr.length;
        byte[] bArr2 = this.zza;
        int length2 = bArr2.length;
        byte[] bArr3 = new byte[length2 + length];
        System.arraycopy(bArr2, 0, bArr3, 0, length2);
        System.arraycopy(bArr, 0, bArr3, length2, length);
        return zze(bArr3);
    }
}
