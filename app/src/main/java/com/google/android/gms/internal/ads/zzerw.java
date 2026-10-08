package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzerw implements zzifh {
    private final zzifq zza;

    private zzerw(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
    }

    public static zzerw zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzerw(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeru zzb() {
        return new zzeru(((zzckk) this.zza).zza(), zzfjn.zzc());
    }
}
