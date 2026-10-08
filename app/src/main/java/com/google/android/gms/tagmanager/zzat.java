package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzat extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CUSTOM_VAR.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.NAME.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.DEFAULT_VALUE.toString();
    private final DataLayer zzd;

    public zzat(DataLayer dataLayer) {
        super(zza, zzb);
        this.zzd = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        Object obj = this.zzd.get(zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzb))));
        if (obj != null) {
            return zzfp.zzb(obj);
        }
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        return zzapVar != null ? zzapVar : zzfp.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
