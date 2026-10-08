package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdw extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.RANDOM.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.MIN.toString();
    private static final String zzc = com.google.android.gms.internal.gtm.zzb.MAX.toString();

    public zzdw() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        com.google.android.gms.internal.gtm.zzap zzapVar = (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
        com.google.android.gms.internal.gtm.zzap zzapVar2 = (com.google.android.gms.internal.gtm.zzap) map.get(zzc);
        double d = 0.0d;
        double d2 = 2.147483647E9d;
        if (zzapVar != null && zzapVar != zzfp.zza() && zzapVar2 != null && zzapVar2 != zzfp.zza()) {
            zzfo zzfoVarZzd = zzfp.zzd(zzfp.zzk(zzapVar));
            zzfo zzfoVarZzd2 = zzfp.zzd(zzfp.zzk(zzapVar2));
            if (zzfoVarZzd != zzfp.zzc() && zzfoVarZzd2 != zzfp.zzc()) {
                double dDoubleValue = zzfoVarZzd.doubleValue();
                double dDoubleValue2 = zzfoVarZzd2.doubleValue();
                if (dDoubleValue <= dDoubleValue2) {
                    d = dDoubleValue;
                    d2 = dDoubleValue2;
                }
            }
        }
        return zzfp.zzb(Long.valueOf(Math.round((Math.random() * (d2 - d)) + d)));
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
