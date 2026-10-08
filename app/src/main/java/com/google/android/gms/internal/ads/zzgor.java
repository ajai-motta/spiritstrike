package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgor extends zzgot {
    zzgor() {
        super(null);
    }

    static final zzgot zzf(int i) {
        return i < 0 ? zzgot.zzb : i > 0 ? zzgot.zzc : zzgot.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zza(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzb(int i, int i2) {
        return zzf(Integer.compare(i, i2));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzc(boolean z, boolean z2) {
        return zzf(Boolean.compare(z2, z));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final zzgot zzd(boolean z, boolean z2) {
        return zzf(Boolean.compare(z, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzgot
    public final int zze() {
        return 0;
    }
}
