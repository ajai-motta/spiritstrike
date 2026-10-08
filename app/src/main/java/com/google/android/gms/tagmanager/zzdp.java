package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdp implements zzfc {
    final /* synthetic */ zzdr zza;

    zzdp(zzdr zzdrVar) {
        this.zza = zzdrVar;
    }

    @Override // com.google.android.gms.tagmanager.zzfc
    public final void zza(zzbv zzbvVar) {
        long jZza = zzbvVar.zza();
        if (jZza == 0) {
            zzdr.zzi(this.zza, zzbvVar.zzb(), this.zza.zzg.currentTimeMillis());
            return;
        }
        if (jZza + 14400000 < this.zza.zzg.currentTimeMillis()) {
            this.zza.zzl(zzbvVar.zzb());
            zzdc.zzb.zzd("Giving up on failed hitId: " + zzbvVar.zzb());
        }
    }
}
