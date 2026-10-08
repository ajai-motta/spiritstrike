package com.google.android.gms.internal.gtm;

import com.google.common.base.Ascii;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzym {
    public static final /* synthetic */ int zza = 0;
    private static volatile int zzb = 100;

    static int zza(byte[] bArr, int i, zzyl zzylVar) throws zzacq {
        int iZzi = zzi(bArr, i, zzylVar);
        int i2 = zzylVar.zza;
        if (i2 < 0) {
            throw new zzacq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 > bArr.length - iZzi) {
            throw new zzacq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        if (i2 == 0) {
            zzylVar.zzc = zzyx.zzb;
            return iZzi;
        }
        zzylVar.zzc = zzyx.zzj(bArr, iZzi, i2);
        return iZzi + i2;
    }

    static int zzb(byte[] bArr, int i) {
        int i2 = bArr[i] & 255;
        int i3 = bArr[i + 1] & 255;
        int i4 = bArr[i + 2] & 255;
        return ((bArr[i + 3] & 255) << 24) | (i3 << 8) | i2 | (i4 << 16);
    }

    static int zzc(zzadx zzadxVar, byte[] bArr, int i, int i2, int i3, zzyl zzylVar) throws IOException {
        Object objZze = zzadxVar.zze();
        int iZzm = zzm(objZze, zzadxVar, bArr, i, i2, i3, zzylVar);
        zzadxVar.zzf(objZze);
        zzylVar.zzc = objZze;
        return iZzm;
    }

    static int zzd(zzadx zzadxVar, byte[] bArr, int i, int i2, zzyl zzylVar) throws IOException {
        Object objZze = zzadxVar.zze();
        int iZzn = zzn(objZze, zzadxVar, bArr, i, i2, zzylVar);
        zzadxVar.zzf(objZze);
        zzylVar.zzc = objZze;
        return iZzn;
    }

    static int zze(zzadx zzadxVar, int i, byte[] bArr, int i2, int i3, zzacn zzacnVar, zzyl zzylVar) throws IOException {
        int iZzd = zzd(zzadxVar, bArr, i2, i3, zzylVar);
        zzacnVar.add(zzylVar.zzc);
        while (iZzd < i3) {
            int iZzi = zzi(bArr, iZzd, zzylVar);
            if (i != zzylVar.zza) {
                break;
            }
            iZzd = zzd(zzadxVar, bArr, iZzi, i3, zzylVar);
            zzacnVar.add(zzylVar.zzc);
        }
        return iZzd;
    }

    static int zzf(byte[] bArr, int i, zzacn zzacnVar, zzyl zzylVar) throws IOException {
        zzacg zzacgVar = (zzacg) zzacnVar;
        int iZzi = zzi(bArr, i, zzylVar);
        int i2 = zzylVar.zza + iZzi;
        while (iZzi < i2) {
            iZzi = zzi(bArr, iZzi, zzylVar);
            zzacgVar.zzh(zzylVar.zza);
        }
        if (iZzi == i2) {
            return iZzi;
        }
        throw new zzacq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static int zzg(byte[] bArr, int i, zzyl zzylVar) throws zzacq {
        int iZzi = zzi(bArr, i, zzylVar);
        int i2 = zzylVar.zza;
        if (i2 < 0) {
            throw new zzacq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
        }
        if (i2 == 0) {
            zzylVar.zzc = "";
            return iZzi;
        }
        zzylVar.zzc = new String(bArr, iZzi, i2, zzaco.zza);
        return iZzi + i2;
    }

    static int zzh(int i, byte[] bArr, int i2, int i3, zzaen zzaenVar, zzyl zzylVar) throws zzacq {
        if ((i >>> 3) == 0) {
            throw new zzacq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            int iZzl = zzl(bArr, i2, zzylVar);
            zzaenVar.zzj(i, Long.valueOf(zzylVar.zzb));
            return iZzl;
        }
        if (i4 == 1) {
            zzaenVar.zzj(i, Long.valueOf(zzp(bArr, i2)));
            return i2 + 8;
        }
        if (i4 == 2) {
            int iZzi = zzi(bArr, i2, zzylVar);
            int i5 = zzylVar.zza;
            if (i5 < 0) {
                throw new zzacq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
            }
            if (i5 > bArr.length - iZzi) {
                throw new zzacq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
            }
            if (i5 == 0) {
                zzaenVar.zzj(i, zzyx.zzb);
            } else {
                zzaenVar.zzj(i, zzyx.zzj(bArr, iZzi, i5));
            }
            return iZzi + i5;
        }
        if (i4 != 3) {
            if (i4 != 5) {
                throw new zzacq("Protocol message contained an invalid tag (zero).");
            }
            zzaenVar.zzj(i, Integer.valueOf(zzb(bArr, i2)));
            return i2 + 4;
        }
        int i6 = (i & (-8)) | 4;
        zzaen zzaenVarZzf = zzaen.zzf();
        int i7 = zzylVar.zze + 1;
        zzylVar.zze = i7;
        zzq(i7);
        int i8 = 0;
        while (true) {
            if (i2 >= i3) {
                break;
            }
            int iZzi2 = zzi(bArr, i2, zzylVar);
            i8 = zzylVar.zza;
            if (i8 == i6) {
                i2 = iZzi2;
                break;
            }
            i2 = zzh(i8, bArr, iZzi2, i3, zzaenVarZzf, zzylVar);
        }
        zzylVar.zze--;
        if (i2 > i3 || i8 != i6) {
            throw new zzacq("Failed to parse the message.");
        }
        zzaenVar.zzj(i, zzaenVarZzf);
        return i2;
    }

    static int zzi(byte[] bArr, int i, zzyl zzylVar) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zzj(b, bArr, i2, zzylVar);
        }
        zzylVar.zza = b;
        return i2;
    }

    static int zzj(int i, byte[] bArr, int i2, zzyl zzylVar) {
        byte b = bArr[i2];
        int i3 = i2 + 1;
        int i4 = i & 127;
        if (b >= 0) {
            zzylVar.zza = i4 | (b << 7);
            return i3;
        }
        int i5 = i4 | ((b & 127) << 7);
        int i6 = i2 + 2;
        byte b2 = bArr[i3];
        if (b2 >= 0) {
            zzylVar.zza = i5 | (b2 << Ascii.SO);
            return i6;
        }
        int i7 = i5 | ((b2 & 127) << 14);
        int i8 = i2 + 3;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzylVar.zza = i7 | (b3 << Ascii.NAK);
            return i8;
        }
        int i9 = i7 | ((b3 & 127) << 21);
        int i10 = i2 + 4;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzylVar.zza = i9 | (b4 << Ascii.FS);
            return i10;
        }
        int i11 = i9 | ((b4 & 127) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzylVar.zza = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzk(int i, byte[] bArr, int i2, int i3, zzacn zzacnVar, zzyl zzylVar) {
        zzacg zzacgVar = (zzacg) zzacnVar;
        int iZzi = zzi(bArr, i2, zzylVar);
        zzacgVar.zzh(zzylVar.zza);
        while (iZzi < i3) {
            int iZzi2 = zzi(bArr, iZzi, zzylVar);
            if (i != zzylVar.zza) {
                break;
            }
            iZzi = zzi(bArr, iZzi2, zzylVar);
            zzacgVar.zzh(zzylVar.zza);
        }
        return iZzi;
    }

    static int zzl(byte[] bArr, int i, zzyl zzylVar) {
        long j = bArr[i];
        int i2 = i + 1;
        if (j >= 0) {
            zzylVar.zzb = j;
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
        zzylVar.zzb = j2;
        return i3;
    }

    static int zzm(Object obj, zzadx zzadxVar, byte[] bArr, int i, int i2, int i3, zzyl zzylVar) throws IOException {
        zzado zzadoVar = (zzado) zzadxVar;
        int i4 = zzylVar.zze + 1;
        zzylVar.zze = i4;
        zzq(i4);
        int iZzc = zzadoVar.zzc(obj, bArr, i, i2, i3, zzylVar);
        zzylVar.zze--;
        zzylVar.zzc = obj;
        return iZzc;
    }

    static int zzn(Object obj, zzadx zzadxVar, byte[] bArr, int i, int i2, zzyl zzylVar) throws IOException {
        int iZzj = i + 1;
        int i3 = bArr[i];
        if (i3 < 0) {
            iZzj = zzj(i3, bArr, iZzj, zzylVar);
            i3 = zzylVar.zza;
        }
        int i4 = iZzj;
        if (i3 < 0 || i3 > i2 - i4) {
            throw new zzacq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        }
        int i5 = zzylVar.zze + 1;
        zzylVar.zze = i5;
        zzq(i5);
        int i6 = i3 + i4;
        zzadxVar.zzi(obj, bArr, i4, i6, zzylVar);
        zzylVar.zze--;
        zzylVar.zzc = obj;
        return i6;
    }

    static int zzo(int i, byte[] bArr, int i2, int i3, zzyl zzylVar) throws zzacq {
        if ((i >>> 3) == 0) {
            throw new zzacq("Protocol message contained an invalid tag (zero).");
        }
        int i4 = i & 7;
        if (i4 == 0) {
            return zzl(bArr, i2, zzylVar);
        }
        if (i4 == 1) {
            return i2 + 8;
        }
        if (i4 == 2) {
            return zzi(bArr, i2, zzylVar) + zzylVar.zza;
        }
        if (i4 != 3) {
            if (i4 == 5) {
                return i2 + 4;
            }
            throw new zzacq("Protocol message contained an invalid tag (zero).");
        }
        int i5 = (i & (-8)) | 4;
        int i6 = 0;
        while (i2 < i3) {
            i2 = zzi(bArr, i2, zzylVar);
            i6 = zzylVar.zza;
            if (i6 == i5) {
                break;
            }
            i2 = zzo(i6, bArr, i2, i3, zzylVar);
        }
        if (i2 > i3 || i6 != i5) {
            throw new zzacq("Failed to parse the message.");
        }
        return i2;
    }

    static long zzp(byte[] bArr, int i) {
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    private static void zzq(int i) throws zzacq {
        if (i >= zzb) {
            throw new zzacq("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
        }
    }
}
