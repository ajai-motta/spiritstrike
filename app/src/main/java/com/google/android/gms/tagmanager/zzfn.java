package com.google.android.gms.tagmanager;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzfn extends zzbp {
    public zzfn(String str, String... strArr) {
        super(str, strArr);
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public final com.google.android.gms.internal.gtm.zzap zza(Map map) {
        zzc(map);
        return zzfp.zza();
    }

    @Override // com.google.android.gms.tagmanager.zzbp
    public boolean zzb() {
        return false;
    }

    public abstract void zzc(Map map);
}
