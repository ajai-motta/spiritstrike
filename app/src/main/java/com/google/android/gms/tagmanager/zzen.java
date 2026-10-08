package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzen {
    private final zzdn zza;
    private final com.google.android.gms.internal.gtm.zzap zzb;

    public zzen(zzdn zzdnVar, com.google.android.gms.internal.gtm.zzap zzapVar) {
        this.zza = zzdnVar;
        this.zzb = zzapVar;
    }

    public final int zza() {
        int iZzY = ((com.google.android.gms.internal.gtm.zzap) this.zza.zza()).zzY();
        com.google.android.gms.internal.gtm.zzap zzapVar = this.zzb;
        return iZzY + (zzapVar == null ? 0 : zzapVar.zzY());
    }

    public final com.google.android.gms.internal.gtm.zzap zzb() {
        return this.zzb;
    }

    public final zzdn zzc() {
        return this.zza;
    }
}
