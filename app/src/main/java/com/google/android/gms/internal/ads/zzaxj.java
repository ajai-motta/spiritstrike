package com.google.android.gms.internal.ads;

import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaxj extends zzavs {
    public long zza;
    public long zzb;

    public zzaxj() {
        this.zza = -1L;
        this.zzb = -1L;
    }

    public zzaxj(String str) {
        this.zza = -1L;
        this.zzb = -1L;
        HashMap mapZzb = zzb(str);
        if (mapZzb != null) {
            this.zza = ((Long) mapZzb.get(0)).longValue();
            this.zzb = ((Long) mapZzb.get(1)).longValue();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavs
    protected final HashMap zza() {
        HashMap map = new HashMap();
        map.put(0, Long.valueOf(this.zza));
        map.put(1, Long.valueOf(this.zzb));
        return map;
    }
}
