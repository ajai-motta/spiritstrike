package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfce implements zzguf {
    final /* synthetic */ zzflm zza;
    final /* synthetic */ zzflc zzb;
    final /* synthetic */ zzcsl zzc;
    final /* synthetic */ zzfci zzd;

    zzfce(zzfci zzfciVar, zzflm zzflmVar, zzflc zzflcVar, zzcsl zzcslVar) {
        this.zza = zzflmVar;
        this.zzb = zzflcVar;
        this.zzc = zzcslVar;
        Objects.requireNonNull(zzfciVar);
        this.zzd = zzfciVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflm zzflmVar;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzbd.zzc().zzd(zzbeu.zzgq)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zze.zzb("Banner ad failed to load", th);
        }
        zzfci zzfciVar = this.zzd;
        synchronized (zzfciVar) {
            zzcsl zzcslVar = this.zzc;
            com.google.android.gms.ads.internal.client.zze zzeVarZzg = zzcslVar.zzc().zzg(th);
            zzfciVar.zzs(zzeVarZzg);
            zzcslVar.zzb().zzdN(zzeVarZzg);
            zzfhk.zza(zzeVarZzg.zza, th, "BannerAdLoader.onFailure");
            if (zzfciVar.zzr()) {
                zzfciVar.zzn();
                zzfciVar.zzo().zzd(zzfciVar.zzq().zzc());
            }
            if (!((Boolean) zzbgn.zzc.zze()).booleanValue() || (zzflmVar = this.zza) == null) {
                zzflp zzflpVarZzp = zzfciVar.zzp();
                zzflc zzflcVar = this.zzb;
                zzflcVar.zzh(zzeVarZzg);
                zzflcVar.zzj(th);
                zzflcVar.zzd(false);
                zzflpVarZzp.zzb(zzflcVar.zzm());
            } else {
                zzflmVar.zzf(zzeVarZzg);
                zzflc zzflcVar2 = this.zzb;
                zzflcVar2.zzj(th);
                zzflcVar2.zzd(false);
                zzflmVar.zza(zzflcVar2);
                zzflmVar.zzh();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0046 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0010 A[Catch: all -> 0x006c, TryCatch #0 {, blocks: (B:5:0x0007, B:6:0x000a, B:8:0x0010, B:9:0x0013, B:11:0x0022, B:13:0x0026, B:15:0x006a, B:14:0x0046), top: B:20:0x0007 }] */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r6) {
        /*
            r5 = this;
            com.google.android.gms.internal.ads.zzfci r0 = r5.zzd
            com.google.android.gms.internal.ads.zzcrg r6 = (com.google.android.gms.internal.ads.zzcrg) r6
            monitor-enter(r0)
            if (r6 == 0) goto La
            r6.zzt()     // Catch: java.lang.Throwable -> L6c
        La:
            boolean r1 = r0.zzr()     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L13
            r0.zzc()     // Catch: java.lang.Throwable -> L6c
        L13:
            com.google.android.gms.internal.ads.zzbge r1 = com.google.android.gms.internal.ads.zzbgn.zzc     // Catch: java.lang.Throwable -> L6c
            java.lang.Object r1 = r1.zze()     // Catch: java.lang.Throwable -> L6c
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.Throwable -> L6c
            boolean r1 = r1.booleanValue()     // Catch: java.lang.Throwable -> L6c
            r2 = 1
            if (r1 == 0) goto L46
            com.google.android.gms.internal.ads.zzflm r1 = r5.zza     // Catch: java.lang.Throwable -> L6c
            if (r1 == 0) goto L46
            com.google.android.gms.internal.ads.zzfgf r3 = r6.zzr()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfge r3 = r3.zzb     // Catch: java.lang.Throwable -> L6c
            r1.zze(r3)     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L6c
            r1.zzg(r6)     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzflc r6 = r5.zzb     // Catch: java.lang.Throwable -> L6c
            r6.zzd(r2)     // Catch: java.lang.Throwable -> L6c
            r1.zza(r6)     // Catch: java.lang.Throwable -> L6c
            r1.zzh()     // Catch: java.lang.Throwable -> L6c
            goto L6a
        L46:
            com.google.android.gms.internal.ads.zzflp r1 = r0.zzp()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzflc r3 = r5.zzb     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfgf r4 = r6.zzr()     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzfge r4 = r4.zzb     // Catch: java.lang.Throwable -> L6c
            r3.zzg(r4)     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzcyh r6 = r6.zzn()     // Catch: java.lang.Throwable -> L6c
            java.lang.String r6 = r6.zze()     // Catch: java.lang.Throwable -> L6c
            r3.zzi(r6)     // Catch: java.lang.Throwable -> L6c
            r3.zzd(r2)     // Catch: java.lang.Throwable -> L6c
            com.google.android.gms.internal.ads.zzflf r6 = r3.zzm()     // Catch: java.lang.Throwable -> L6c
            r1.zzb(r6)     // Catch: java.lang.Throwable -> L6c
        L6a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
            return
        L6c:
            r6 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L6c
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfce.zzb(java.lang.Object):void");
    }
}
