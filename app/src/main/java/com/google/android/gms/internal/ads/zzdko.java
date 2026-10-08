package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdko implements zzifh {
    private final zzdkm zza;

    private zzdko(zzdkm zzdkmVar) {
        this.zza = zzdkmVar;
    }

    public static zzdko zzc(zzdkm zzdkmVar) {
        return new zzdko(zzdkmVar);
    }

    public static JSONObject zzd(zzdkm zzdkmVar) {
        JSONObject jSONObjectZzc = zzdkmVar.zzc();
        zzifp.zzb(jSONObjectZzc);
        return jSONObjectZzc;
    }

    public final JSONObject zza() {
        return zzd(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return zzd(this.zza);
    }
}
