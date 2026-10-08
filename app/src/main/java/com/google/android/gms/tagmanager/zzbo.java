package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbo extends zzbp {
    private static final String zza = com.google.android.gms.internal.gtm.zza.EVENT.toString();
    private final zzep zzb;

    public zzbo(zzep zzepVar) {
        super(zza, new String[0]);
        this.zzb = zzepVar;
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        String strZzb = this.zzb.zzb();
        return strZzb == null ? zzfp.zza() : zzfp.zzb(strZzb);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final boolean zzb() {
        return false;
    }
}
