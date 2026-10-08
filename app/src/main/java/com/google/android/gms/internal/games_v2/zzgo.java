package com.google.android.gms.internal.games_v2;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@21.0.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgo extends zzgq {
    zzgo() {
        super(null);
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final zzgq zza(Comparable comparable, Comparable comparable2) {
        int iCompareTo = comparable.compareTo(comparable2);
        return iCompareTo < 0 ? zzgq.zzb : iCompareTo > 0 ? zzgq.zzc : zzgq.zza;
    }

    @Override // com.google.android.gms.internal.games_v2.zzgq
    public final int zzb() {
        return 0;
    }
}
