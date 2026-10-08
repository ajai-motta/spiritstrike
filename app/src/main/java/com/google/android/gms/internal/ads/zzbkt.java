package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbkt implements zzblx {
    zzbkt() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzd;
        zzcgy zzcgyVar = (zzcgy) obj;
        zzbhv zzbhvVarZzar = zzcgyVar.zzar();
        if (zzbhvVarZzar == null || (jSONObjectZzd = zzbhvVarZzar.zzd()) == null) {
            zzcgyVar.zzd("nativeClickMetaReady", new JSONObject());
        } else {
            zzcgyVar.zzd("nativeClickMetaReady", jSONObjectZzd);
        }
    }
}
