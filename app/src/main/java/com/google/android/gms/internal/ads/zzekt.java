package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzekt implements zzguf {
    final /* synthetic */ long zza;
    final /* synthetic */ zzffx zzb;
    final /* synthetic */ zzffu zzc;
    final /* synthetic */ String zzd;
    final /* synthetic */ zzfnc zze;
    final /* synthetic */ zzfgf zzf;
    final /* synthetic */ zzekv zzg;

    zzekt(zzekv zzekvVar, long j, zzffx zzffxVar, zzffu zzffuVar, String str, zzfnc zzfncVar, zzfgf zzfgfVar) {
        this.zza = j;
        this.zzb = zzffxVar;
        this.zzc = zzffuVar;
        this.zzd = str;
        this.zze = zzfncVar;
        this.zzf = zzfgfVar;
        Objects.requireNonNull(zzekvVar);
        this.zzg = zzekvVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[PHI: r8
  0x0061: PHI (r8v1 int) = (r8v0 int), (r8v3 int), (r8v3 int), (r8v3 int) binds: [B:16:0x002f, B:21:0x004a, B:23:0x004e, B:25:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void zza(java.lang.Throwable r17) {
        /*
            Method dump skipped, instruction units count: 251
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzekt.zza(java.lang.Throwable):void");
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        zzekv zzekvVar = this.zzg;
        long jElapsedRealtime = zzekvVar.zzj().elapsedRealtime() - this.zza;
        synchronized (zzekvVar) {
            if (zzekvVar.zzn()) {
                zzekvVar.zzk().zza(this.zzb, this.zzc, 0, null, jElapsedRealtime);
            }
            if (zzekvVar.zzp()) {
                return;
            }
            zzffu zzffuVar = this.zzc;
            if (zzekvVar.zzi(zzffuVar)) {
                ((zzeku) zzekvVar.zzm().get(zzffuVar)).zzd = jElapsedRealtime;
            } else {
                zzekvVar.zzm().put(zzffuVar, new zzeku(this.zzd, zzffuVar.zzaf, 0, jElapsedRealtime, null));
            }
            zzekvVar.zzo().zzd(zzffuVar, jElapsedRealtime, null);
        }
    }
}
