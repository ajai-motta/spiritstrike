package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbki {
    private final com.google.android.gms.ads.formats.zze zza;
    private final com.google.android.gms.ads.formats.zzd zzb;
    private zzbjd zzc;

    public zzbki(com.google.android.gms.ads.formats.zze zzeVar, com.google.android.gms.ads.formats.zzd zzdVar) {
        this.zza = zzeVar;
        this.zzb = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final synchronized zzbjd zze(zzbjc zzbjcVar) {
        zzbjd zzbjdVar = this.zzc;
        if (zzbjdVar != null) {
            return zzbjdVar;
        }
        zzbjd zzbjdVar2 = new zzbjd(zzbjcVar);
        this.zzc = zzbjdVar2;
        return zzbjdVar2;
    }

    public final zzbjp zza() {
        return new zzbkh(this, null);
    }

    public final zzbjm zzb() {
        if (this.zzb == null) {
            return null;
        }
        return new zzbkg(this, null);
    }

    final /* synthetic */ com.google.android.gms.ads.formats.zze zzc() {
        return this.zza;
    }

    final /* synthetic */ com.google.android.gms.ads.formats.zzd zzd() {
        return this.zzb;
    }
}
