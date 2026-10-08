package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzdt extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zzb.ARG0.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG1.toString();

    public zzdt(String str) {
        super(str, zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        Iterator it = map.values().iterator();
        do {
            boolean zZzd = false;
            if (!it.hasNext()) {
                com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zza);
                com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
                if (zzapVar != null && zzapVar2 != null) {
                    zZzd = zzd(zzapVar, zzapVar2, map);
                }
                return zzfp.zzb(Boolean.valueOf(zZzd));
            }
        } while (((com.google.android.gms.internal.gtm.zzap) it.next()) != zzfp.zza());
        return zzfp.zzb(false);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }

    protected abstract boolean zzd(com.google.android.gms.internal.gtm.zzap zzapVar, com.google.android.gms.internal.gtm.zzap zzapVar2, Map map);
}
