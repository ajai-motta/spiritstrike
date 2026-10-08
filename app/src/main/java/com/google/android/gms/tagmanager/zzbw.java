package com.google.android.gms.tagmanager;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbw implements Runnable {
    final /* synthetic */ long zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ zzbx zzc;
    final /* synthetic */ zzbx zzd;

    zzbw(zzbx zzbxVar, zzbx zzbxVar2, long j, String str) {
        this.zzd = zzbxVar2;
        this.zza = j;
        this.zzb = str;
        this.zzc = zzbxVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzc.zze == null) {
            zzbx zzbxVar = this.zzc;
            zzbx zzbxVar2 = this.zzd;
            zzfa zzfaVarZzg = zzfa.zzg();
            zzfaVarZzg.zzl(zzbxVar.zzf, zzbxVar2);
            this.zzc.zze = zzfaVarZzg.zzf();
        }
        zzbx zzbxVar3 = this.zzc;
        zzbxVar3.zze.zzb(this.zza, this.zzb);
    }
}
