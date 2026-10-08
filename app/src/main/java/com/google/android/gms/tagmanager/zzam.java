package com.google.android.gms.tagmanager;

import android.util.Log;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzam extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.FUNCTION_CALL.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.FUNCTION_CALL_NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.ADDITIONAL_PARAMS.toString();
    private final zzal zzd;

    public zzam(zzal zzalVar) {
        super(zza, zzb);
        this.zzd = zzalVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        String strZzm = zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzb)));
        HashMap map2 = new HashMap();
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        if (zzapVar != null) {
            Object objZzk = zzfp.zzk(zzapVar);
            if (!(objZzk instanceof Map)) {
                Log.w("GoogleTagManager", "FunctionCallMacro: expected ADDITIONAL_PARAMS to be a map.");
                return zzfp.zza();
            }
            for (Map.Entry entry : ((Map) objZzk).entrySet()) {
                map2.put(entry.getKey().toString(), entry.getValue());
            }
        }
        try {
            return zzfp.zzb(this.zzd.zza(strZzm, map2));
        } catch (Exception e) {
            Log.w("GoogleTagManager", "Custom macro/tag " + strZzm + " threw exception " + e.getMessage());
            return zzfp.zza();
        }
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
