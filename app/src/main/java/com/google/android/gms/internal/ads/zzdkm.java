package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdkm {
    private final JSONObject zza;
    private final zzdqt zzb;
    private final com.google.android.gms.ads.internal.zzb zzc;
    private final zzbzt zzd;

    public zzdkm(JSONObject jSONObject, zzdqt zzdqtVar, com.google.android.gms.ads.internal.zzb zzbVar, zzbzt zzbztVar) {
        this.zza = jSONObject;
        this.zzb = zzdqtVar;
        this.zzc = zzbVar;
        this.zzd = zzbztVar;
    }

    final com.google.android.gms.ads.internal.zzb zza() {
        return this.zzc;
    }

    final zzbzt zzb() {
        return this.zzd;
    }

    public final JSONObject zzc() {
        return this.zza;
    }

    public final zzdqt zzd() {
        return this.zzb;
    }
}
