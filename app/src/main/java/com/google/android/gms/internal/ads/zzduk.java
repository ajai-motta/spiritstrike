package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzduk implements zzfkt {
    private final Map zza;
    private final zzbdt zzb;

    zzduk(zzbdt zzbdtVar, Map map) {
        this.zza = map;
        this.zzb = zzbdtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdP(zzfkm zzfkmVar, String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdQ(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdR(zzfkm zzfkmVar, String str, Throwable th) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zzc);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzfkt
    public final void zzdS(zzfkm zzfkmVar, String str) {
        Map map = this.zza;
        if (map.containsKey(zzfkmVar)) {
            this.zzb.zzc(((zzduj) map.get(zzfkmVar)).zzb);
        }
    }
}
