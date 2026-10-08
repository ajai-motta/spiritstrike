package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcns {
    private final Map zza;
    private final Map zzb;

    zzcns(Map map, Map map2) {
        this.zza = map;
        this.zzb = map2;
    }

    public final void zza(zzfgf zzfgfVar) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        for (zzfgd zzfgdVar : zzfgfVar.zzb.zzc) {
            Map map = this.zza;
            String str = zzfgdVar.zza;
            if (!map.containsKey(str) || (jSONObject2 = zzfgdVar.zzb) == null) {
                Map map2 = this.zzb;
                if (map2.containsKey(str) && (jSONObject = zzfgdVar.zzb) != null) {
                    zzcnu zzcnuVar = (zzcnu) map2.get(str);
                    HashMap map3 = new HashMap();
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String strOptString = jSONObject.optString(next);
                        if (strOptString != null) {
                            map3.put(next, strOptString);
                        }
                    }
                    zzcnuVar.zza(map3);
                }
            } else {
                ((zzcnv) map.get(str)).zza(jSONObject2);
            }
        }
    }
}
