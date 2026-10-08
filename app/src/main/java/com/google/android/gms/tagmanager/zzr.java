package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzr extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CONSTANT.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.VALUE.toString();

    public zzr() {
        super(zza, zzb);
    }

    public static String zzc() {
        return zza;
    }

    public static String zzd() {
        return zzb;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        return (com.google.android.gms.internal.gtm.zzap) map.get(zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
