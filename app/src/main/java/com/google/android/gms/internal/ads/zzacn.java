package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacn {
    public static void zza(long j, zzeg zzegVar, zzaem[] zzaemVarArr) {
        int iZzB;
        while (true) {
            if (zzegVar.zzd() <= 1) {
                return;
            }
            int iZzc = zzc(zzegVar);
            int iZzc2 = zzc(zzegVar);
            int iZzg = zzegVar.zzg() + iZzc2;
            if (iZzc2 == -1 || iZzc2 > zzegVar.zzd()) {
                zzdt.zzc("CeaUtil", "Skipping remainder of malformed SEI NAL unit.");
                iZzg = zzegVar.zze();
            } else if (iZzc == 4 && iZzc2 >= 8) {
                int iZzs = zzegVar.zzs();
                int iZzt = zzegVar.zzt();
                if (iZzt == 49) {
                    iZzB = zzegVar.zzB();
                    iZzt = 49;
                } else {
                    iZzB = 0;
                }
                int iZzs2 = zzegVar.zzs();
                if (iZzt == 47) {
                    zzegVar.zzk(1);
                    iZzt = 47;
                }
                boolean z = iZzs == 181 && (iZzt == 49 || iZzt == 47) && iZzs2 == 3;
                if (iZzt == 49) {
                    z &= iZzB == 1195456820;
                }
                if (z) {
                    zzb(j, zzegVar, zzaemVarArr);
                }
            }
            zzegVar.zzh(iZzg);
        }
    }

    public static void zzb(long j, zzeg zzegVar, zzaem[] zzaemVarArr) {
        int iZzs = zzegVar.zzs();
        if ((iZzs & 64) != 0) {
            int i = iZzs & 31;
            zzegVar.zzk(1);
            int iZzg = zzegVar.zzg();
            for (zzaem zzaemVar : zzaemVarArr) {
                int i2 = i * 3;
                zzegVar.zzh(iZzg);
                zzaemVar.zzz(zzegVar, i2);
                zzgmd.zzh(j != C.TIME_UNSET);
                zzaemVar.zzx(j, 1, i2, 0, null);
            }
        }
    }

    private static int zzc(zzeg zzegVar) {
        int i = 0;
        while (zzegVar.zzd() != 0) {
            int iZzs = zzegVar.zzs();
            i += iZzs;
            if (iZzs != 255) {
                return i;
            }
        }
        return -1;
    }
}
