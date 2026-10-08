package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbn {
    public static final zzbn zza = new zzbn(zzgpe.zzi());
    private final zzgpe zzb;

    static {
        String str = zzep.zza;
        Integer.toString(0, 36);
    }

    public zzbn(List list) {
        this.zzb = zzgpe.zzq(list);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.zzb.equals(((zzbn) obj).zzb);
    }

    public final int hashCode() {
        return this.zzb.hashCode();
    }

    public final zzgpe zza() {
        return this.zzb;
    }

    public final boolean zzb(int i) {
        int i2 = 0;
        while (true) {
            zzgpe zzgpeVar = this.zzb;
            if (i2 >= zzgpeVar.size()) {
                return false;
            }
            zzbm zzbmVar = (zzbm) zzgpeVar.get(i2);
            if (zzbmVar.zzb() && zzbmVar.zzd() == i) {
                return true;
            }
            i2++;
        }
    }
}
