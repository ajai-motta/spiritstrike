package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfne implements zzguf {
    final /* synthetic */ zzflc zza;
    final /* synthetic */ zzflm zzb;
    final /* synthetic */ zzdbd zzc;
    final /* synthetic */ zzfng zzd;

    zzfne(zzfng zzfngVar, zzflc zzflcVar, zzflm zzflmVar, zzdbd zzdbdVar) {
        this.zza = zzflcVar;
        this.zzb = zzflmVar;
        this.zzc = zzdbdVar;
        Objects.requireNonNull(zzfngVar);
        this.zzd = zzfngVar;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzflc zzflcVar = this.zza;
        if (zzflcVar == null) {
            return;
        }
        zzflcVar.zzd(false);
        zzflm zzflmVar = this.zzb;
        if (zzflmVar != null) {
            zzflmVar.zza(zzflcVar);
            zzflmVar.zzh();
        } else {
            zzfng zzfngVar = this.zzd;
            zzfngVar.zze().zzb(zzflcVar.zzm());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00e6  */
    @Override // com.google.android.gms.internal.ads.zzguf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ void zzb(java.lang.Object r14) {
        /*
            Method dump skipped, instruction units count: 253
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfne.zzb(java.lang.Object):void");
    }
}
