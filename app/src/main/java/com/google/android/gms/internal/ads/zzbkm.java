package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbkm implements zzblx {
    private final zzbkn zza;

    public zzbkm(zzbkn zzbknVar) {
        this.zza = zzbknVar;
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final void zza(Object obj, Map map) {
        if (this.zza == null) {
            return;
        }
        String str = (String) map.get("name");
        if (str == null) {
            int i = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzh("Ad metadata with no name parameter.");
            str = "";
        }
        Bundle bundleZzl = null;
        if (map.containsKey("info")) {
            try {
                bundleZzl = com.google.android.gms.ads.internal.util.zzbp.zzl(new JSONObject((String) map.get("info")));
            } catch (JSONException e) {
                int i2 = com.google.android.gms.ads.internal.util.zze.zza;
                com.google.android.gms.ads.internal.util.client.zzo.zzg("Failed to convert ad metadata to JSON.", e);
            }
        }
        if (bundleZzl != null) {
            this.zza.zza(str, bundleZzl);
        } else {
            int i3 = com.google.android.gms.ads.internal.util.zze.zza;
            com.google.android.gms.ads.internal.util.client.zzo.zzf("Failed to convert ad metadata to Bundle.");
        }
    }
}
