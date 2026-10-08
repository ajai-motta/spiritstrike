package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzai extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.CONTAINER_VERSION.toString();
    private final String zzb;

    public zzai(String str) {
        super(zza, new String[0]);
        this.zzb = str;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        String str = this.zzb;
        return str == null ? zzfp.zza() : zzfp.zzb(str);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return true;
    }
}
