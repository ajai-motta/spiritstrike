package com.google.android.gms.internal.ads;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbks implements zzblx {
    zzbks() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        JSONObject jSONObjectZzc;
        zzcgy zzcgyVar = (zzcgy) obj;
        zzbhv zzbhvVarZzar = zzcgyVar.zzar();
        if (zzbhvVarZzar == null || (jSONObjectZzc = zzbhvVarZzar.zzc()) == null) {
            zzcgyVar.zzd("nativeAdViewSignalsReady", new JSONObject());
        } else {
            zzcgyVar.zzd("nativeAdViewSignalsReady", jSONObjectZzc);
        }
    }
}
