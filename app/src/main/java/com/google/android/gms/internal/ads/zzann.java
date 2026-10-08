package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzann {
    private final zzamq zza;
    private final zzem zzb;
    private final zzef zzc = new zzef(new byte[64], 64);
    private boolean zzd;
    private boolean zze;
    private boolean zzf;

    public zzann(zzamq zzamqVar, zzem zzemVar) {
        this.zza = zzamqVar;
        this.zzb = zzemVar;
    }

    public final void zza() {
        this.zzf = false;
        this.zza.zza();
    }

    public final void zzb(zzeg zzegVar) throws zzat {
        long jZze;
        long j;
        zzef zzefVar = this.zzc;
        zzegVar.zzm(zzefVar.zza, 0, 3);
        zzefVar.zzf(0);
        zzefVar.zzh(8);
        this.zzd = zzefVar.zzi();
        this.zze = zzefVar.zzi();
        zzefVar.zzh(6);
        zzegVar.zzm(zzefVar.zza, 0, zzefVar.zzj(8));
        zzefVar.zzf(0);
        if (this.zzd) {
            zzefVar.zzh(4);
            long jZzj = zzefVar.zzj(3);
            zzefVar.zzh(1);
            int iZzj = zzefVar.zzj(15) << 15;
            zzefVar.zzh(1);
            long jZzj2 = zzefVar.zzj(15);
            zzefVar.zzh(1);
            if (this.zzf || !this.zze) {
                j = jZzj;
            } else {
                zzefVar.zzh(4);
                long jZzj3 = ((long) zzefVar.zzj(3)) << 30;
                zzefVar.zzh(1);
                int iZzj2 = zzefVar.zzj(15) << 15;
                zzefVar.zzh(1);
                j = jZzj;
                long jZzj4 = zzefVar.zzj(15);
                zzefVar.zzh(1);
                this.zzb.zze(jZzj3 | ((long) iZzj2) | jZzj4);
                this.zzf = true;
            }
            jZze = this.zzb.zze((j << 30) | ((long) iZzj) | jZzj2);
        } else {
            jZze = 0;
        }
        zzamq zzamqVar = this.zza;
        zzamqVar.zzc(jZze, 4);
        zzamqVar.zzd(zzegVar);
        zzamqVar.zze(false);
    }
}
