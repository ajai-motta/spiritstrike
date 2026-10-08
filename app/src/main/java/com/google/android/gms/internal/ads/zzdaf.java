package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdaf implements zzifh {
    private final zzifq zza;

    private zzdaf(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzdaf zzc(zzifq zzifqVar) {
        return new zzdaf(zzifqVar);
    }

    public static zzdae zzd(Set set) {
        return new zzdae(set);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final zzdae zzb() {
        return new zzdae(((zzift) this.zza).zzb());
    }
}
