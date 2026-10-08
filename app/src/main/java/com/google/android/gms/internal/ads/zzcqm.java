package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcqm implements zzifh {
    private final zzifq zza;

    private zzcqm(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcqm zza(zzifq zzifqVar) {
        return new zzcqm(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        try {
            return new JSONObject(((zzcuf) this.zza).zza().zzz);
        } catch (JSONException unused) {
            return null;
        }
    }
}
