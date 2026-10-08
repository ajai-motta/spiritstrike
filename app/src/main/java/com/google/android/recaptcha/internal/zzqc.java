package com.google.android.recaptcha.internal;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzqc {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzqb zzqbVar) throws zzsx {
        int iZzi = zzi(bArr, i, zzqbVar);
        int i2 = zzqbVar.zza;
        if (i2 < 0) {
            throw new zzsx("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzi) {
            throw new zzsx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzqbVar.zzc = zzqm.zzb;
            return iZzi;
        }
        zzqbVar.zzc = zzqm.zzl(bArr, iZzi, i2);
        return iZzi + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzug zzugVar, byte[] bArr, int i, int i2, int i3, zzqb zzqbVar) throws IOException {
        Object objZze = zzugVar.zze();
        int iZzm = zzm(objZze, zzugVar, bArr, i, i2, i3, zzqbVar);
        zzugVar.zzf(objZze);
        zzqbVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzug zzugVar, byte[] bArr, int i, int i2, zzqb zzqbVar) throws IOException {
        Object objZze = zzugVar.zze();
        int iZzn = zzn(objZze, zzugVar, bArr, i, i2, zzqbVar);
        zzugVar.zzf(objZze);
        zzqbVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzug zzugVar, int i, byte[] bArr, int i2, int i3, zzsu zzsuVar, zzqb zzqbVar) throws IOException {
        int iZzd = zzd(zzugVar, bArr, i2, i3, zzqbVar);
        zzsuVar.add(zzqbVar.zzc);
        while (iZzd < i3) {
            int iZzi = zzi(bArr, iZzd, zzqbVar);
            if (i != zzqbVar.zza) {
                break;
            }
            iZzd = zzd(zzugVar, bArr, iZzi, i3, zzqbVar);
            zzsuVar.add(zzqbVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzsu zzsuVar, zzqb zzqbVar) throws IOException {
        zzso zzsoVar = (zzso) zzsuVar;
        int iZzi = zzi(bArr, i, zzqbVar);
        int i2 = zzqbVar.zza + iZzi;
        while (iZzi < i2) {
            iZzi = zzi(bArr, iZzi, zzqbVar);
            zzsoVar.zzh(zzqbVar.zza);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw new zzsx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(byte[] bArr, int i, zzqb zzqbVar) throws zzsx {
        int iZzi = zzi(bArr, i, zzqbVar);
        int i2 = zzqbVar.zza;
        if (i2 < 0) {
            throw new zzsx("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzqbVar.zzc = "";
            return iZzi;
        }
        zzqbVar.zzc = new String(bArr, iZzi, i2, zzsv.zza);
        return iZzi + i2;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3, zzuw zzuwVar, zzqb zzqbVar) throws zzsx {
        if ((i >>> 3) == 0) {
            throw new zzsx("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzl = zzl(bArr, i2, zzqbVar);
            zzuwVar.zzj(i, Long.valueOf(zzqbVar.zzb));
            return iZzl;
        }
        if (i4 == 1) {
            zzuwVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzi = zzi(bArr, i2, zzqbVar);
            int i5 = zzqbVar.zza;
            if (i5 < 0) {
                throw new zzsx("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzi) {
                throw new zzsx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzuwVar.zzj(i, zzqm.zzb);
            } else {
                zzuwVar.zzj(i, zzqm.zzl(bArr, iZzi, i5));
            }
            return iZzi + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzsx("Protocol message contained an invalid tag (zero).");
            }
            zzuwVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzuw zzuwVarZzf = zzuw.zzf();
        int i7 = zzqbVar.zze + 1;
        zzqbVar.zze = i7;
        zzq(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzi2 = zzi(bArr, i2, zzqbVar);
            i8 = zzqbVar.zza;
            if (i8 == i6) {
                i2 = iZzi2;
                break;
            }
            i2 = zzh(i8, bArr, iZzi2, i3, zzuwVarZzf, zzqbVar);
        }
        zzqbVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzsx("Failed to parse the message.");
        }
        zzuwVar.zzj(i, zzuwVarZzf);
        return i2;
    }

    static int zzi(byte[] bArr, int i, zzqb zzqbVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzqbVar);
        }
        zzqbVar.zza = b;
        return i2;
    }

    static int zzj(int i, byte[] bArr, int i2, zzqb zzqbVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzqbVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzqbVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzqbVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzqbVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzqbVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzsu zzsuVar, zzqb zzqbVar) {
        zzso zzsoVar = (zzso) zzsuVar;
        int iZzi = zzi(bArr, i2, zzqbVar);
        zzsoVar.zzh(zzqbVar.zza);
        while (iZzi < i3) {
            int iZzi2 = zzi(bArr, iZzi, zzqbVar);
            if (i != zzqbVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzqbVar);
            zzsoVar.zzh(zzqbVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i, zzqb zzqbVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzqbVar.zzb = j;
            return i2;
        }
        int i3 = i + 2;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & 127)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & 127)) << i4;
            b = b2;
            i3 = i5;
        }
        zzqbVar.zzb = j2;
        return i3;
    }

    static int zzm(Object obj, zzug zzugVar, byte[] bArr, int i, int i2, int i3, zzqb zzqbVar) throws IOException {
        zztv zztvVar = (zztv) zzugVar;
        int i4 = zzqbVar.zze + 1;
        zzqbVar.zze = i4;
        zzq(i4);
        int iZzc = zztvVar.zzc(obj, bArr, i, i2, i3, zzqbVar);
        zzqbVar.zze--;
        zzqbVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzug zzugVar, byte[] bArr, int i, int i2, zzqb zzqbVar) throws IOException {
        int iZzj = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzj = zzj(i3, bArr, iZzj, zzqbVar);
            i3 = zzqbVar.zza;
        }
        int i4 = iZzj;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzsx("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzqbVar.zze + 1;
        zzqbVar.zze = i5;
        zzq(i5);
        int i6 = i3 + i4;
        zzugVar.zzi(obj, bArr, i4, i6, zzqbVar);
        zzqbVar.zze--;
        zzqbVar.zzc = obj;
        return i6;
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzqb zzqbVar) throws zzsx {
        if ((i >>> 3) == 0) {
            throw new zzsx("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzl(bArr, i2, zzqbVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzi(bArr, i2, zzqbVar) + zzqbVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzsx("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzi(bArr, i2, zzqbVar);
            i6 = zzqbVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzo(i6, bArr, i2, i3, zzqbVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzsx("Failed to parse the message.");
        }
        return i2;
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzq(int i) throws zzsx {
        if (i >= zzb) {
            throw new zzsx("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
