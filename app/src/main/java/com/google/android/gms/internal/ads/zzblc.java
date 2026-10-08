package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzblc implements zzblx {
    zzblc() {
    }

    @Override // com.google.android.gms.internal.ads.zzblx
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcgy zzcgyVar = (zzcgy) obj;
        try {
            JSONObject jSONObject = new JSONObject((String) map.get("args"));
            Iterator<String> itKeys = jSONObject.keys();
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(zzcgyVar.getContext()).edit();
            while (itKeys.hasNext()) {
                String next = itKeys.next();
                Object obj2 = jSONObject.get(next);
                if (obj2 instanceof Integer) {
                    editorEdit.putInt(next, ((Integer) obj2).intValue());
                } else if (obj2 instanceof Long) {
                    editorEdit.putLong(next, ((Long) obj2).longValue());
                } else if (obj2 instanceof Double) {
                    editorEdit.putFloat(next, ((Double) obj2).floatValue());
                } else if (obj2 instanceof Float) {
                    editorEdit.putFloat(next, ((Float) obj2).floatValue());
                } else if (obj2 instanceof Boolean) {
                    editorEdit.putBoolean(next, ((Boolean) obj2).booleanValue());
                } else if (obj2 instanceof String) {
                    editorEdit.putString(next, (String) obj2);
                }
            }
            editorEdit.apply();
        } catch (JSONException e) {
            com.google.android.gms.ads.internal.zzt.zzh().zzg(e, "GMSG write local storage KV pairs handler");
        }
    }
}
