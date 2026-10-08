package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhux {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzhuw zzhuwVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzb(b, bArr, i2, zzhuwVar);
        }
        zzhuwVar.zza = b;
        return i2;
    }

    static int zzb(int i, byte[] bArr, int i2, zzhuw zzhuwVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzhuwVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzhuwVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzhuwVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzhuwVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzhuwVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzc(byte[] bArr, int i, zzhuw zzhuwVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzhuwVar.zzb = j;
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
        zzhuwVar.zzb = j2;
        return i3;
    }

    static int zzd(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static long zze(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    static int zzf(byte[] bArr, int i, zzhuw zzhuwVar) throws zzhxd {
        int iZza = zza(bArr, i, zzhuwVar);
        int i2 = zzhuwVar.zza;
        if (i2 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzhuwVar.zzc = "";
            return iZza;
        }
        zzhuwVar.zzc = zzhzo.zzf(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzg(byte[] bArr, int i, zzhuw zzhuwVar) throws zzhxd {
        int iZza = zza(bArr, i, zzhuwVar);
        int i2 = zzhuwVar.zza;
        if (i2 < 0) {
            throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZza) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzhuwVar.zzc = zzhvi.zzb;
            return iZza;
        }
        zzhuwVar.zzc = zzhvi.zzr(bArr, iZza, i2);
        return iZza + i2;
    }

    static int zzh(zzhyr zzhyrVar, byte[] bArr, int i, int i2, zzhuw zzhuwVar) throws IOException {
        Object objZza = zzhyrVar.zza();
        int iZzj = zzj(objZza, zzhyrVar, bArr, i, i2, zzhuwVar);
        zzhyrVar.zzk(objZza);
        zzhuwVar.zzc = objZza;
        return iZzj;
    }

    static int zzi(zzhyr zzhyrVar, byte[] bArr, int i, int i2, int i3, zzhuw zzhuwVar) throws IOException {
        Object objZza = zzhyrVar.zza();
        int iZzk = zzk(objZza, zzhyrVar, bArr, i, i2, i3, zzhuwVar);
        zzhyrVar.zzk(objZza);
        zzhuwVar.zzc = objZza;
        return iZzk;
    }

    static int zzj(Object obj, zzhyr zzhyrVar, byte[] bArr, int i, int i2, zzhuw zzhuwVar) throws IOException {
        int iZzb = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzb = zzb(i3, bArr, iZzb, zzhuwVar);
            i3 = zzhuwVar.zza;
        }
        int i4 = iZzb;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i5;
        zzq(i5);
        int i6 = i3 + i4;
        zzhyrVar.zzj(obj, bArr, i4, i6, zzhuwVar);
        zzhuwVar.zze--;
        zzhuwVar.zzc = obj;
        return i6;
    }

    static int zzk(Object obj, zzhyr zzhyrVar, byte[] bArr, int i, int i2, int i3, zzhuw zzhuwVar) throws IOException {
        zzhyc zzhycVar = (zzhyc) zzhyrVar;
        int i4 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i4;
        zzq(i4);
        int iZzi = zzhycVar.zzi(obj, bArr, i, i2, i3, zzhuwVar);
        zzhuwVar.zze--;
        zzhuwVar.zzc = obj;
        return iZzi;
    }

    static int zzl(int i, byte[] bArr, int i2, int i3, zzhxa zzhxaVar, zzhuw zzhuwVar) {
        zzhwp zzhwpVar = (zzhwp) zzhxaVar;
        int iZza = zza(bArr, i2, zzhuwVar);
        zzhwpVar.zzi(zzhuwVar.zza);
        while (iZza < i3) {
            int iZza2 = zza(bArr, iZza, zzhuwVar);
            if (i != zzhuwVar.zza) {
                break;
            }
            iZza = zza(bArr, iZza2, zzhuwVar);
            zzhwpVar.zzi(zzhuwVar.zza);
        }
        return iZza;
    }

    static int zzm(byte[] bArr, int i, zzhxa zzhxaVar, zzhuw zzhuwVar) throws IOException {
        zzhwp zzhwpVar = (zzhwp) zzhxaVar;
        int iZza = zza(bArr, i, zzhuwVar);
        int i2 = zzhuwVar.zza + iZza;
        while (iZza < i2) {
            iZza = zza(bArr, iZza, zzhuwVar);
            zzhwpVar.zzi(zzhuwVar.zza);
        }
        if (iZza == i2) {
            return iZza;
        }
        throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzn(zzhyr zzhyrVar, int i, byte[] bArr, int i2, int i3, zzhxa zzhxaVar, zzhuw zzhuwVar) throws IOException {
        int iZzh = zzh(zzhyrVar, bArr, i2, i3, zzhuwVar);
        zzhxaVar.add(zzhuwVar.zzc);
        while (iZzh < i3) {
            int iZza = zza(bArr, iZzh, zzhuwVar);
            if (i != zzhuwVar.zza) {
                break;
            }
            iZzh = zzh(zzhyrVar, bArr, iZza, i3, zzhuwVar);
            zzhxaVar.add(zzhuwVar.zzc);
        }
        return iZzh;
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzhzd zzhzdVar, zzhuw zzhuwVar) throws zzhxd {
        if ((i >>> 3) == 0) {
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzc = zzc(bArr, i2, zzhuwVar);
            zzhzdVar.zzk(i, Long.valueOf(zzhuwVar.zzb));
            return iZzc;
        }
        if (i4 == 1) {
            zzhzdVar.zzk(i, Long.valueOf(zze(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZza = zza(bArr, i2, zzhuwVar);
            int i5 = zzhuwVar.zza;
            if (i5 < 0) {
                throw new zzhxd("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZza) {
                throw new zzhxd("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzhzdVar.zzk(i, zzhvi.zzb);
            } else {
                zzhzdVar.zzk(i, zzhvi.zzr(bArr, iZza, i5));
            }
            return iZza + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzhxd("Protocol message contained an invalid tag (zero).");
            }
            zzhzdVar.zzk(i, Integer.valueOf(zzd(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzhzd zzhzdVarZzb = zzhzd.zzb();
        int i7 = zzhuwVar.zze + 1;
        zzhuwVar.zze = i7;
        zzq(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZza2 = zza(bArr, i2, zzhuwVar);
            i8 = zzhuwVar.zza;
            if (i8 == i6) {
                i2 = iZza2;
                break;
            }
            i2 = zzo(i8, bArr, iZza2, i3, zzhzdVarZzb, zzhuwVar);
        }
        zzhuwVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzhxd("Failed to parse the message.");
        }
        zzhzdVar.zzk(i, zzhzdVarZzb);
        return i2;
    }

    static int zzp(int i, byte[] bArr, int i2, int i3, zzhuw zzhuwVar) throws zzhxd {
        if ((i >>> 3) == 0) {
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzc(bArr, i2, zzhuwVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zza(bArr, i2, zzhuwVar) + zzhuwVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzhxd("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zza(bArr, i2, zzhuwVar);
            i6 = zzhuwVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzp(i6, bArr, i2, i3, zzhuwVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzhxd("Failed to parse the message.");
        }
        return i2;
    }

    private static void zzq(int i) throws zzhxd {
        if (i >= zzb) {
            throw new zzhxd("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
