package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzffd implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzffg zzd;
    final /* synthetic */ zzffh zze;

    zzffd(zzffh zzffhVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzffg zzffgVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzffgVar;
        Objects.requireNonNull(zzffhVar);
        this.zze = zzffhVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Rewarded ad failed to load", th);
        }
        zzffh zzffhVar = this.zze;
        zzdrn zzdrnVar = (zzdrn) zzffhVar.zzh().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzdrnVar == null ? zzfhp.zzb(th, null) : zzdrnVar.zza().zzg(th);
        synchronized (zzffhVar) {
            if (zzdrnVar != null) {
                zzdrnVar.zze().zzdN(zzeVarZzb);
                zzffhVar.zzf().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzffc
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzg().zzdN(zzeVarZzb);
                    }
                });
            } else {
                zzffhVar.zzg().zzdN(zzeVarZzb);
                zzffhVar.zze(this.zzd).zzh().zza().zzd().zzo();
            }
            zzfhk.zza(zzeVarZzb.zza, th, "RewardedAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzi = zzffhVar.zzi();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzh(zzeVarZzb);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzi.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzb);
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0067 A[Catch: all -> 0x008d, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0043, B:10:0x0047, B:12:0x008b, B:11:0x0067), top: B:17:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzffh r0 = r5.zze
            com.google.android.gms.internal.ads.zzdri r6 = (com.google.android.gms.internal.ads.zzdri) r6
            monitor-enter(r0)
            if (r6 == 0) goto La
            r6.zzt()     // Catch: java.lang.Throwable -> L8d
        La:
            com.google.android.gms.internal.ads.zzdce r1 = r6.zzq()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfey r2 = r0.zzg()     // Catch: java.lang.Throwable -> L8d
            r1.zzd(r2)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzepi r1 = r5.zza     // Catch: java.lang.Throwable -> L8d
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L8d
            java.util.concurrent.Executor r1 = r0.zzf()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfey r2 = r0.zzg()     // Catch: java.lang.Throwable -> L8d
            java.util.Objects.requireNonNull(r2)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzffb r3 = new com.google.android.gms.internal.ads.zzffb     // Catch: java.lang.Throwable -> L8d
            r3.<init>()     // Catch: java.lang.Throwable -> L8d
            r1.execute(r3)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfey r1 = r0.zzg()     // Catch: java.lang.Throwable -> L8d
            r1.onAdMetadataChanged()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzbge r1 = com.google.android.gms.internal.ads.zzbgn.zzc     // Catch: java.lang.Throwable -> L8d
            java.lang.Object r1 = r1.zze()     // Catch: java.lang.Throwable -> L8d
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L8d
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L8d
            r2 = 1
            if (r1 == 0) goto L67
            com.google.android.gms.internal.ads.zzflm r1 = r5.zzb     // Catch: java.lang.Throwable -> L8d
            if (r1 == 0) goto L67
            com.google.android.gms.internal.ads.zzfgf r3 = r6.zzr()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfge r3 = r3.zzb     // Catch: java.lang.Throwable -> L8d
            r1.zze(r3)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L8d
            r1.zzg(r6)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzflc r6 = r5.zzc     // Catch: java.lang.Throwable -> L8d
            r6.zzd(r2)     // Catch: java.lang.Throwable -> L8d
            r1.zza(r6)     // Catch: java.lang.Throwable -> L8d
            r1.zzh()     // Catch: java.lang.Throwable -> L8d
            goto L8b
        L67:
            com.google.android.gms.internal.ads.zzflp r1 = r0.zzi()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzflc r3 = r5.zzc     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfgf r4 = r6.zzr()     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzfge r4 = r4.zzb     // Catch: java.lang.Throwable -> L8d
            r3.zzg(r4)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L8d
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L8d
            r3.zzi(r6)     // Catch: java.lang.Throwable -> L8d
            r3.zzd(r2)     // Catch: java.lang.Throwable -> L8d
            com.google.android.gms.internal.ads.zzflf r6 = r3.zzm()     // Catch: java.lang.Throwable -> L8d
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L8d
        L8b:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8d
            return
        L8d:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L8d
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzffd.zzb(java.lang.Object):void");
    }
}
