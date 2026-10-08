package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzees implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzees(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzees zzc(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzees(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzeer zzb() {
        return new zzeer(((zzeeo) this.zza).zzb(), (zzgus) this.zzb.zzb());
    }
}
