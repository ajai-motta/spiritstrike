package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdvu implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzdvu(zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzdvu zza(zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzdvu(zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdvt((String) this.zza.zzb(), (zzdvn) this.zzb.zzb());
    }
}
