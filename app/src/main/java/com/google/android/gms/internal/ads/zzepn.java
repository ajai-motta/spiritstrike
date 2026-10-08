package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzepn implements zzguf {
    final /* synthetic */ zzepi zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzflc zzc;
    final /* synthetic */ zzdjz zzd;
    final /* synthetic */ zzepq zze;

    zzepn(zzepq zzepqVar, zzepi zzepiVar, zzflm zzflmVar, zzflc zzflcVar, zzdjz zzdjzVar) {
        this.zza = zzepiVar;
        this.zzb = zzflmVar;
        this.zzc = zzflcVar;
        this.zzd = zzdjzVar;
        Objects.requireNonNull(zzepqVar);
        this.zze = zzepqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Native ad failed to load", th);
        }
        zzdjz zzdjzVar = this.zzd;
        final com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzdjzVar.zza().zzg(th);
        zzdjzVar.zzb().zzdN(zzeVarZzg);
        zzepq zzepqVar = this.zze;
        zzepqVar.zze().zzb().execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzepl
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zze.zzf().zze().zzdN(zzeVarZzg);
            }
        });
        zzfhk.zza(zzeVarZzg.zza, th, "NativeAdLoader.onFailure");
        this.zza.zza();
        if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zzb) == null) {
            zzflp zzflpVarZzg = zzepqVar.zzg();
            zzflc zzflcVar = this.zzc;
            zzflcVar.zzh(zzeVarZzg);
            zzflcVar.zzj(th);
            zzflcVar.zzd(false);
            zzflpVarZzg.zzb(zzflcVar.zzm());
            return;
        }
        zzflmVar.zzf(zzeVarZzg);
        zzflc zzflcVar2 = this.zzc;
        zzflcVar2.zzj(th);
        zzflcVar2.zzd(false);
        zzflmVar.zza(zzflcVar2);
        zzflmVar.zzh();
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0061 A[Catch: all -> 0x0087, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x003d, B:10:0x0041, B:12:0x0085, B:11:0x0061), top: B:17:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzepq r0 = r5.zze
            com.google.android.gms.internal.ads.zzcto r6 = (com.google.android.gms.internal.ads.zzcto) r6
            monitor-enter(r0)
            if (r6 == 0) goto La
            r6.zzt()     // Catch: java.lang.Throwable -> L87
        La:
            com.google.android.gms.internal.ads.zzdce r1 = r6.zzq()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzepg r2 = r0.zzf()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzeot r2 = r2.zzc()     // Catch: java.lang.Throwable -> L87
            r1.zza(r2)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzepi r1 = r5.zza     // Catch: java.lang.Throwable -> L87
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzcjn r1 = r0.zze()     // Catch: java.lang.Throwable -> L87
            java.util.concurrent.Executor r1 = r1.zzb()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzepm r2 = new com.google.android.gms.internal.ads.zzepm     // Catch: java.lang.Throwable -> L87
            r2.<init>()     // Catch: java.lang.Throwable -> L87
            r1.execute(r2)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzbge r1 = com.google.android.gms.internal.ads.zzbgn.zzc     // Catch: java.lang.Throwable -> L87
            java.lang.Object r1 = r1.zze()     // Catch: java.lang.Throwable -> L87
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L87
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L87
            r2 = 1
            if (r1 == 0) goto L61
            com.google.android.gms.internal.ads.zzflm r1 = r5.zzb     // Catch: java.lang.Throwable -> L87
            if (r1 == 0) goto L61
            com.google.android.gms.internal.ads.zzfgf r3 = r6.zzr()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfge r3 = r3.zzb     // Catch: java.lang.Throwable -> L87
            r1.zze(r3)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L87
            r1.zzg(r6)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzflc r6 = r5.zzc     // Catch: java.lang.Throwable -> L87
            r6.zzd(r2)     // Catch: java.lang.Throwable -> L87
            r1.zza(r6)     // Catch: java.lang.Throwable -> L87
            r1.zzh()     // Catch: java.lang.Throwable -> L87
            goto L85
        L61:
            com.google.android.gms.internal.ads.zzflp r1 = r0.zzg()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzflc r3 = r5.zzc     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfgf r4 = r6.zzr()     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzfge r4 = r4.zzb     // Catch: java.lang.Throwable -> L87
            r3.zzg(r4)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L87
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L87
            r3.zzi(r6)     // Catch: java.lang.Throwable -> L87
            r3.zzd(r2)     // Catch: java.lang.Throwable -> L87
            com.google.android.gms.internal.ads.zzflf r6 = r3.zzm()     // Catch: java.lang.Throwable -> L87
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L87
        L85:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            return
        L87:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L87
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzepn.zzb(java.lang.Object):void");
    }
}
