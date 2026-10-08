package com.google.android.gms.tagmanager;

import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzba extends zzfn {
    private static final String zza = com.google.android.gms.internal.gtm.zza.DATA_LAYER_WRITE.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.VALUE.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer zzd;

    public zzba(DataLayer dataLayer) {
        super(zza, zzb);
        this.zzd = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzfn
    public final void zzc(Map map) {
        String strZzm;
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        if (zzapVar != null) {
            Object objZzk = zzfp.zzk(zzapVar);
            if (objZzk instanceof List) {
                for (Object obj : (List) objZzk) {
                    if (obj instanceof Map) {
                        this.zzd.push((Map) obj);
                    }
                }
            }
        }
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        if (zzapVar2 == null || (strZzm = zzfp.zzm(zzfp.zzk(zzapVar2))) == zzfp.zzl()) {
            return;
        }
        this.zzd.zzd(strZzm);
    }
}
