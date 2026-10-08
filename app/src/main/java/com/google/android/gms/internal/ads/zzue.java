package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzue implements zzwm {
    private final zzgpe zza;
    private long zzb;

    public zzue(List list, List list2) {
        int i = zzgpe.zzd;
        zzgpb zzgpbVar = new zzgpb();
        zzgmd.zza(list.size() == list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzgpbVar.zzf(new zzud((zzwm) list.get(i2), (List) list2.get(i2)));
        }
        this.zza = zzgpbVar.zzi();
        this.zzb = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        int i = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i >= zzgpeVar.size()) {
                return;
            }
            ((zzud) zzgpeVar.get(i)).zzg(j);
            i++;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        long jMin2 = Long.MAX_VALUE;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i >= zzgpeVar.size()) {
                break;
            }
            zzud zzudVar = (zzud) zzgpeVar.get(i);
            long jZzi = zzudVar.zzi();
            if ((zzudVar.zza().contains(1) || zzudVar.zza().contains(2) || zzudVar.zza().contains(4)) && jZzi != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzi);
            }
            if (jZzi != Long.MIN_VALUE) {
                jMin2 = Math.min(jMin2, jZzi);
            }
            i++;
        }
        if (jMin != Long.MAX_VALUE) {
            this.zzb = jMin;
            return jMin;
        }
        if (jMin2 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        long j = this.zzb;
        return j != C.TIME_UNSET ? j : jMin2;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        int i = 0;
        long jMin = Long.MAX_VALUE;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i >= zzgpeVar.size()) {
                break;
            }
            long jZzl = ((zzud) zzgpeVar.get(i)).zzl();
            if (jZzl != Long.MIN_VALUE) {
                jMin = Math.min(jMin, jZzl);
            }
            i++;
        }
        if (jMin == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return jMin;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        boolean zZzm;
        boolean z = false;
        do {
            long jZzl = zzl();
            if (jZzl == Long.MIN_VALUE) {
                break;
            }
            int i = 0;
            zZzm = false;
            while (true) {
                zzgpe zzgpeVar = this.zza;
                if (i >= zzgpeVar.size()) {
                    break;
                }
                long jZzl2 = ((zzud) zzgpeVar.get(i)).zzl();
                boolean z2 = jZzl2 != Long.MIN_VALUE && jZzl2 <= zzknVar.zza;
                if (jZzl2 == jZzl || z2) {
                    zZzm |= ((zzud) zzgpeVar.get(i)).zzm(zzknVar);
                }
                i++;
            }
            z |= zZzm;
        } while (zZzm);
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        int i = 0;
        while (true) {
            zzgpe zzgpeVar = this.zza;
            if (i >= zzgpeVar.size()) {
                return false;
            }
            if (((zzud) zzgpeVar.get(i)).zzn()) {
                return true;
            }
            i++;
        }
    }
}
