package com.google.android.gms.internal.ads;

import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrj implements zzqo {
    protected zzrj(zzri zzriVar) {
    }

    protected static int zza(int i, int i2, int i3) {
        return zzgst.zza(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    private static int zzc(int i) {
        int iZzf = zzade.zzf(i);
        zzgmd.zzh(iZzf != -2147483647);
        return iZzf;
    }

    protected static final int zzb(int i, int i2, int i3, int i4, int i5, int i6) {
        int i7 = 250000;
        if (i3 == 0) {
            int iZza = zza(250000, i5, i4);
            int iZza2 = zza(750000, i5, i4);
            String str = zzep.zza;
            return Math.max(iZza, Math.min(i * 4, iZza2));
        }
        if (i3 == 1) {
            return zzgst.zza((((long) zzc(i2)) * 50000000) / 1000000);
        }
        if (i2 == 5) {
            i7 = 500000;
        } else if (i2 == 8) {
            i7 = 1000000;
            i2 = 8;
        }
        return zzgst.zza((((long) i7) * ((long) (i6 != -1 ? zzgsm.zzb(i6, 8, RoundingMode.CEILING) : zzc(i2)))) / 1000000);
    }
}
