package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzddu implements zzdbu {
    private int zza = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzby)).intValue();
    private int zzb = ((Integer) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zznT)).intValue();

    public final synchronized int zzc() {
        return this.zza;
    }

    public final synchronized int zzd() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final void zzdT(zzbxj zzbxjVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzdbu
    public final synchronized void zzdU(zzfgf zzfgfVar) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzbz)).booleanValue()) {
            try {
                zzffx zzffxVar = zzfgfVar.zzb.zzb;
                this.zza = zzffxVar.zzc;
                this.zzb = zzffxVar.zzd;
            } catch (NullPointerException unused) {
            }
        }
    }
}
