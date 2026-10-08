package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzdd extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.LOWERCASE_STRING.toString();
    private static final String zzb = com.google.android.gms.internal.gtm.zzb.ARG0.toString();

    public zzdd() {
        super(zza, zzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        return zzfp.zzb(zzfp.zzm(zzfp.zzk((com.google.android.gms.internal.gtm.zzap) map.get(zzb))).toLowerCase());
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
