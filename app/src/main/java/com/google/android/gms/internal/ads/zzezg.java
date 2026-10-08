package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzexy;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzezg implements zzexy {
    private final String zza;

    public zzezg(String str) {
        this.zza = str;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        try {
            ((JSONObject) obj).put("ms", this.zza);
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.util.zze.zzb("Failed putting Ad ID.", e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public /* synthetic */ void zzb(Object obj) {
        zzexy.CC.$default$zzb(this, obj);
    }
}
