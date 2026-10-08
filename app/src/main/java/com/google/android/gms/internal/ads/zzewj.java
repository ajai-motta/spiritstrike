package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.internal.ads.zzexy;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzewj implements zzexy {
    private final Map zza;

    public zzewj(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Map map = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (map.isEmpty()) {
            return;
        }
        Bundle bundle = zzcxqVar.zza;
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : map.entrySet()) {
            ArrayDeque arrayDeque = (ArrayDeque) entry.getValue();
            if (!arrayDeque.isEmpty()) {
                zzdwo zzdwoVar = (zzdwo) entry.getKey();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("id", zzdwoVar.zza());
                    jSONObject.put("event_type", zzdwoVar.zzb());
                    JSONArray jSONArray2 = new JSONArray();
                    Iterator it = arrayDeque.iterator();
                    while (it.hasNext()) {
                        jSONArray2.put((Long) it.next());
                    }
                    jSONObject.put("timestamps", jSONArray2);
                    jSONArray.put(jSONObject);
                } catch (JSONException e) {
                    com.google.android.gms.ads.internal.util.zze.zzb("Failed putting the on-device storage record.", e);
                }
            }
        }
        if (jSONArray.length() > 0) {
            bundle.putString("on_device_storage_records", jSONArray.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public /* synthetic */ void zzb(Object obj) {
        zzexy.CC.$default$zzb(this, obj);
    }
}
