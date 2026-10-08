package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdbi implements zzifh {
    private final zzifq zza;

    private zzdbi(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdbi zza(zzifq zzifqVar) {
        return new zzdbi(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzdbh(((zzift) this.zza).zzb());
    }
}
