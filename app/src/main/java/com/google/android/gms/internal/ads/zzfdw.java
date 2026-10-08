package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfdw implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjd zzd;
    final /* synthetic */ zzfdy zze;

    zzfdw(zzfdy zzfdyVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjd zzdjdVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjdVar;
        Objects.requireNonNull(zzfdyVar);
        this.zze = zzfdyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Interstitial ad failed to load", th);
        }
        zzdjd zzdjdVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjdVar.zzb().zzg(th);
        zzfdy zzfdyVar = this.zze;
        synchronized (zzfdyVar) {
            zzfdyVar.zzi(null);
            zzdjdVar.zza().zzdN(zzeVarZzg);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzjb)).booleanValue()) {
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzf().zzdN(zzeVarZzg);
                    }
                });
                zzfdyVar.zze().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzfdu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        this.zza.zze.zzg().zzdN(zzeVarZzg);
                    }
                });
            }
            zzfhk.zza(zzeVarZzg.zza, th, "InterstitialAdLoader.onFailure");
            this.zza.zza();
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
                zzflp zzflpVarZzh = zzfdyVar.zzh();
                zzflc zzflcVar = this.zzc;
                zzflcVar.zzh(zzeVarZzg);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzh.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzg);
                zzflc zzflcVar2 = this.zzc;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0092 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020 A[Catch: all -> 0x00b8, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0020, B:9:0x0032, B:11:0x0047, B:12:0x005f, B:14:0x006e, B:16:0x0072, B:18:0x00b6, B:17:0x0092), top: B:23:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzfdy r0 = r5.zze
            com.google.android.gms.internal.ads.zzdhw r6 = (com.google.android.gms.internal.ads.zzdhw) r6
            monitor-enter(r0)
            if (r6 == 0) goto La
            r6.zzt()     // Catch: java.lang.Throwable -> Lb8
        La:
            r1 = 0
            r0.zzi(r1)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzbel r1 = com.google.android.gms.internal.ads.zzbeu.zzjb     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r2 = r2.zzd(r1)     // Catch: java.lang.Throwable -> Lb8
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch: java.lang.Throwable -> Lb8
            boolean r2 = r2.booleanValue()     // Catch: java.lang.Throwable -> Lb8
            if (r2 == 0) goto L32
            com.google.android.gms.internal.ads.zzdce r2 = r6.zzq()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzeot r3 = r0.zzf()     // Catch: java.lang.Throwable -> Lb8
            r2.zza(r3)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfey r3 = r0.zzg()     // Catch: java.lang.Throwable -> Lb8
            r2.zzd(r3)     // Catch: java.lang.Throwable -> Lb8
        L32:
            com.google.android.gms.internal.ads.zzepi r2 = r5.zza     // Catch: java.lang.Throwable -> Lb8
            r2.zzb(r6)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzbes r2 = com.google.android.gms.ads.internal.client.zzbd.zzc()     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r1 = r2.zzd(r1)     // Catch: java.lang.Throwable -> Lb8
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> Lb8
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Lb8
            if (r1 == 0) goto L5f
            java.util.concurrent.Executor r1 = r0.zze()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfdv r2 = new com.google.android.gms.internal.ads.zzfdv     // Catch: java.lang.Throwable -> Lb8
            r2.<init>()     // Catch: java.lang.Throwable -> Lb8
            r1.execute(r2)     // Catch: java.lang.Throwable -> Lb8
            java.util.concurrent.Executor r1 = r0.zze()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfds r2 = new com.google.android.gms.internal.ads.zzfds     // Catch: java.lang.Throwable -> Lb8
            r2.<init>()     // Catch: java.lang.Throwable -> Lb8
            r1.execute(r2)     // Catch: java.lang.Throwable -> Lb8
        L5f:
            com.google.android.gms.internal.ads.zzbge r1 = com.google.android.gms.internal.ads.zzbgn.zzc     // Catch: java.lang.Throwable -> Lb8
            java.lang.Object r1 = r1.zze()     // Catch: java.lang.Throwable -> Lb8
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> Lb8
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> Lb8
            r2 = 1
            if (r1 == 0) goto L92
            com.google.android.gms.internal.ads.zzflm r1 = r5.zzb     // Catch: java.lang.Throwable -> Lb8
            if (r1 == 0) goto L92
            com.google.android.gms.internal.ads.zzfgf r3 = r6.zzr()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfge r3 = r3.zzb     // Catch: java.lang.Throwable -> Lb8
            r1.zze(r3)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> Lb8
            r1.zzg(r6)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzflc r6 = r5.zzc     // Catch: java.lang.Throwable -> Lb8
            r6.zzd(r2)     // Catch: java.lang.Throwable -> Lb8
            r1.zza(r6)     // Catch: java.lang.Throwable -> Lb8
            r1.zzh()     // Catch: java.lang.Throwable -> Lb8
            goto Lb6
        L92:
            com.google.android.gms.internal.ads.zzflp r1 = r0.zzh()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzflc r3 = r5.zzc     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfgf r4 = r6.zzr()     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzfge r4 = r4.zzb     // Catch: java.lang.Throwable -> Lb8
            r3.zzg(r4)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> Lb8
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> Lb8
            r3.zzi(r6)     // Catch: java.lang.Throwable -> Lb8
            r3.zzd(r2)     // Catch: java.lang.Throwable -> Lb8
            com.google.android.gms.internal.ads.zzflf r6 = r3.zzm()     // Catch: java.lang.Throwable -> Lb8
            r1.zzb(r6)     // Catch: java.lang.Throwable -> Lb8
        Lb6:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb8
            return
        Lb8:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lb8
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdw.zzb(java.lang.Object):void");
    }
}
