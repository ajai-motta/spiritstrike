package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzfk extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.TIME.toString();

    public zzfk() {
        super(zza, new String[0]);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        return zzfp.zzb(Long.valueOf(System.currentTimeMillis()));
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
