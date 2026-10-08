package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzawp implements zzfsq {
    final /* synthetic */ zzfrs zza;

    zzawp(zzfrs zzfrsVar) {
        this.zza = zzfrsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zza(int i, long j) {
        this.zza.zzb(i, System.currentTimeMillis() - j);
    }

    @Override // com.google.android.gms.internal.ads.zzfsq
    public final void zzb(int i, long j, String str) {
        this.zza.zzf(i, System.currentTimeMillis() - j, str);
    }
}
