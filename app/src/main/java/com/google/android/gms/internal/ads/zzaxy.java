package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxy extends zzavs {
    public Long zza;
    public Long zzb;

    public zzaxy() {
    }

    public zzaxy(String str) {
        HashMap mapZzb = zzb(str);
        if (mapZzb != null) {
            this.zza = (Long) mapZzb.get(0);
            this.zzb = (Long) mapZzb.get(1);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavs
    protected final HashMap zza() {
        HashMap map = new HashMap();
        map.put(0, this.zza);
        map.put(1, this.zzb);
        return map;
    }
}
