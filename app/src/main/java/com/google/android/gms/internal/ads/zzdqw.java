package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdqw extends zzdqh implements zzdgv {
    private zzdgv zza;

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final synchronized void zzdV() {
        zzdgv zzdgvVar = this.zza;
        if (zzdgvVar != null) {
            zzdgvVar.zzdV();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdgv
    public final synchronized void zzdz() {
        zzdgv zzdgvVar = this.zza;
        if (zzdgvVar != null) {
            zzdgvVar.zzdz();
        }
    }

    protected final synchronized void zzn(com.google.android.gms.ads.internal.client.zza zzaVar, zzbkn zzbknVar, com.google.android.gms.ads.internal.overlay.zzr zzrVar, zzbkp zzbkpVar, com.google.android.gms.ads.internal.overlay.zzad zzadVar, zzdgv zzdgvVar) {
        super.zzm(zzaVar, zzbknVar, zzrVar, zzbkpVar, zzadVar);
        this.zza = zzdgvVar;
    }
}
