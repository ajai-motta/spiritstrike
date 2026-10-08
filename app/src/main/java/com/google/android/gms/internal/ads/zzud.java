package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzud implements zzwm {
    private final zzwm zza;
    private final zzgpe zzb;

    public zzud(zzwm zzwmVar, List list) {
        this.zza = zzwmVar;
        this.zzb = zzgpe.zzq(list);
    }

    public final zzgpe zza() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final void zzg(long j) {
        this.zza.zzg(j);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzi() {
        return this.zza.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final long zzl() {
        return this.zza.zzl();
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzm(zzkn zzknVar) {
        return this.zza.zzm(zzknVar);
    }

    @Override // com.google.android.gms.internal.ads.zzwm
    public final boolean zzn() {
        return this.zza.zzn();
    }
}
