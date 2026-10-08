package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckh implements zzifh {
    private final zzifq zza;

    private zzckh(zzcjp zzcjpVar, zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzckh zzc(zzcjp zzcjpVar, zzifq zzifqVar) {
        return new zzckh(zzcjpVar, zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzcnr zzb() {
        zzcjn zzcjnVar = (zzcjn) this.zza.zzb();
        zzifp.zzb(zzcjnVar);
        return zzcjnVar;
    }
}
