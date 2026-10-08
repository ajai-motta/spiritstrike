package com.google.android.gms.internal.ads;

import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzhde {
    final long[] zza;
    final long[] zzb;
    final long[] zzc;

    zzhde() {
        this(new long[10], new long[10], new long[10]);
    }

    zzhde(long[] jArr, long[] jArr2, long[] jArr3) {
        this.zza = jArr;
        this.zzb = jArr2;
        this.zzc = jArr3;
    }

    void zza(long[] jArr, long[] jArr2) {
        System.arraycopy(jArr2, 0, jArr, 0, 10);
    }

    final void zzb(zzhde zzhdeVar, int i) {
        zzhdd.zza(this.zza, zzhdeVar.zza, i);
        zzhdd.zza(this.zzb, zzhdeVar.zzb, i);
        zzhdd.zza(this.zzc, zzhdeVar.zzc, i);
    }

    zzhde(zzhde zzhdeVar) {
        this.zza = Arrays.copyOf(zzhdeVar.zza, 10);
        this.zzb = Arrays.copyOf(zzhdeVar.zzb, 10);
        this.zzc = Arrays.copyOf(zzhdeVar.zzc, 10);
    }
}
