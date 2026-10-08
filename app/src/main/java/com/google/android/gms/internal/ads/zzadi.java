package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzadi {
    public static boolean zza(zzeg zzegVar, zzadn zzadnVar, int i, zzadh zzadhVar) {
        int iZzg = zzegVar.zzg();
        long jZzz = zzegVar.zzz();
        long j = jZzz >>> 16;
        if (j != i) {
            return false;
        }
        boolean z = (j & 1) == 1;
        long j2 = jZzz >> 12;
        long j3 = jZzz >> 8;
        long j4 = jZzz >> 4;
        long j5 = jZzz >> 1;
        long j6 = jZzz & 1;
        int i2 = (int) (j4 & 15);
        if (i2 <= 7) {
            if (i2 != zzadnVar.zzg - 1) {
                return false;
            }
        } else if (i2 > 10 || zzadnVar.zzg != 2) {
            return false;
        }
        int i3 = (int) (j5 & 7);
        if ((i3 != 0 && i3 != zzadnVar.zzi) || j6 == 1 || !zzd(zzegVar, zzadnVar, z, zzadhVar)) {
            return false;
        }
        long j7 = zzadhVar.zza;
        int iZzc = zzc(zzegVar, (int) (j2 & 15));
        long j8 = zzadnVar.zzj;
        boolean z2 = j8 == 0 || j7 + ((long) iZzc) >= j8;
        if (iZzc == -1) {
            return false;
        }
        if ((!z2 && iZzc < zzadnVar.zza) || iZzc > zzadnVar.zzb) {
            return false;
        }
        int i4 = zzadnVar.zze;
        int i5 = (int) (j3 & 15);
        if (i5 != 0) {
            if (i5 <= 11) {
                if (i5 != zzadnVar.zzf) {
                    return false;
                }
            } else if (i5 == 12) {
                if (zzegVar.zzs() * 1000 != i4) {
                    return false;
                }
            } else {
                if (i5 > 14) {
                    return false;
                }
                int iZzt = zzegVar.zzt();
                if (i5 == 14) {
                    iZzt *= 10;
                }
                if (iZzt != i4) {
                    return false;
                }
            }
        }
        if (zzegVar.zzs() != zzep.zzJ(zzegVar.zzi(), iZzg, zzegVar.zzg() - 1, 0)) {
            return false;
        }
        if (zzegVar.zzd() == 0) {
            return true;
        }
        int iZzn = zzegVar.zzn();
        if ((iZzn & 128) != 0) {
            return false;
        }
        int i6 = (iZzn & 126) >> 1;
        if ((i6 < 2 || i6 > 7) && (i6 < 13 || i6 > 31)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i6).length() + 57);
        sb.append("Ignoring frame where first subframe has a reserved type: ");
        sb.append(i6);
        zzdt.zzb("FlacFrameReader", sb.toString());
        return false;
    }

    public static long zzb(zzadb zzadbVar, zzadn zzadnVar) throws IOException {
        zzadbVar.zzl();
        zzadbVar.zzk(1);
        byte[] bArr = new byte[1];
        zzadbVar.zzi(bArr, 0, 1);
        int i = bArr[0] & 1;
        boolean z = 1 == i;
        zzadbVar.zzk(2);
        int i2 = 1 != i ? 6 : 7;
        zzeg zzegVar = new zzeg(i2);
        zzegVar.zzf(zzade.zzb(zzadbVar, zzegVar.zzi(), 0, i2));
        zzadbVar.zzl();
        zzadh zzadhVar = new zzadh();
        if (zzd(zzegVar, zzadnVar, z, zzadhVar)) {
            return zzadhVar.zza;
        }
        throw zzat.zzb(null, null);
    }

    public static int zzc(zzeg zzegVar, int i) {
        switch (i) {
            case 1:
                return PsExtractor.AUDIO_STREAM;
            case 2:
            case 3:
            case 4:
            case 5:
                return 576 << (i - 2);
            case 6:
                return zzegVar.zzs() + 1;
            case 7:
                return zzegVar.zzt() + 1;
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
                return 256 << (i - 8);
            default:
                return -1;
        }
    }

    private static boolean zzd(zzeg zzegVar, zzadn zzadnVar, boolean z, zzadh zzadhVar) {
        try {
            long jZzO = zzegVar.zzO();
            if (!z) {
                jZzO *= (long) zzadnVar.zzb;
            }
            long j = zzadnVar.zzj;
            if (j != 0 && jZzO > j) {
                return false;
            }
            zzadhVar.zza = jZzO;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
