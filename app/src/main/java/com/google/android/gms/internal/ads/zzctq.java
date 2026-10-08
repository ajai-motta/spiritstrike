package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzctq implements zzctr {
    private final Map zza;

    zzctq(Map map) {
        this.zza = map;
    }

    @Override // com.google.android.gms.internal.ads.zzctr
    public final zzehk zza(int i, String str) {
        return (zzehk) this.zza.get(str);
    }
}
