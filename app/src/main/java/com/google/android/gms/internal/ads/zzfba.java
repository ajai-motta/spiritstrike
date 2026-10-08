package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfba implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzfbb zzd;
    final /* synthetic */ zzfbe zze;

    zzfba(zzfbe zzfbeVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzfbb zzfbbVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzfbbVar;
        Objects.requireNonNull(zzfbeVar);
        this.zze = zzfbeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("App open ad failed to load", th);
        }
        zzfbe zzfbeVar = this.zze;
        zzcqq zzcqqVar = (zzcqq) zzfbeVar.zzj().zzd();
        final com.google.android.gms.ads.internal.client.zze zzeVarZzb = zzcqqVar == null ? zzfhp.zzb(th, null) : zzcqqVar.zza().zzg(th);
        synchronized (zzfbeVar) {
            zzfbeVar.zzl(null);
            if (zzcqqVar != null) {
                zzcqqVar.zze().zzdN(zzeVarZzb);
                if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzja)).booleanValue()) {
                    zzfbeVar.zzh().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfaz
                        @Override // java.lang.Runnable
                        public final /* synthetic */ void run() {
                            this.zza.zze.zzi().zzdN(zzeVarZzb);
                        }
                    });
                }
            } else {
                zzfbeVar.zzi().zzdN(zzeVarZzb);
                ((zzcqq) zzfbeVar.zzg(this.zzd).zzh()).zza().zzd().zzo();
            }
            zzfhk.zza(zzeVarZzb.zza, th, "AppOpenAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzk = zzfbeVar.zzk();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzh(zzeVarZzb);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzk.zzb(zzflcVar.zzm());
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

    /* JADX WARN: Removed duplicated region for block: B:14:0x0063 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020 A[Catch: all -> 0x0089, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x002b, B:11:0x003f, B:13:0x0043, B:15:0x0087, B:14:0x0063), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzfbe r0 = r5.zze
            com.google.android.gms.internal.ads.zzcto r6 = (com.google.android.gms.internal.ads.zzcto) r6
            monitor-enter(r0)
            if (r6 == 0) goto La
            r6.zzt()     // Catch: java.lang.Throwable -> L89
        La:
            r1 = 0
            r0.zzl(r1)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzja     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> L89
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> L89
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L89
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L2b
            com.google.android.gms.internal.ads.zzdce r1 = r6.zzq()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzfbu r2 = r0.zzi()     // Catch: java.lang.Throwable -> L89
            r1.zzc(r2)     // Catch: java.lang.Throwable -> L89
        L2b:
            com.google.android.gms.internal.ads.zzepi r1 = r5.zza     // Catch: java.lang.Throwable -> L89
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzbge r1 = com.google.android.gms.internal.ads.zzbgn.zzc     // Catch: java.lang.Throwable -> L89
            java.lang.Object r1 = r1.zze()     // Catch: java.lang.Throwable -> L89
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L89
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L89
            r2 = 1
            if (r1 == 0) goto L63
            com.google.android.gms.internal.ads.zzflm r1 = r5.zzb     // Catch: java.lang.Throwable -> L89
            if (r1 == 0) goto L63
            com.google.android.gms.internal.ads.zzfgf r3 = r6.zzr()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzfge r3 = r3.zzb     // Catch: java.lang.Throwable -> L89
            r1.zze(r3)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L89
            r1.zzg(r6)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzflc r6 = r5.zzc     // Catch: java.lang.Throwable -> L89
            r6.zzd(r2)     // Catch: java.lang.Throwable -> L89
            r1.zza(r6)     // Catch: java.lang.Throwable -> L89
            r1.zzh()     // Catch: java.lang.Throwable -> L89
            goto L87
        L63:
            com.google.android.gms.internal.ads.zzflp r1 = r0.zzk()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzflc r3 = r5.zzc     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzfgf r4 = r6.zzr()     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzfge r4 = r4.zzb     // Catch: java.lang.Throwable -> L89
            r3.zzg(r4)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L89
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L89
            r3.zzi(r6)     // Catch: java.lang.Throwable -> L89
            r3.zzd(r2)     // Catch: java.lang.Throwable -> L89
            com.google.android.gms.internal.ads.zzflf r6 = r3.zzm()     // Catch: java.lang.Throwable -> L89
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L89
        L87:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            return
        L89:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L89
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfba.zzb(java.lang.Object):void");
    }
}
