package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcnw implements zzcnu {
    private final com.google.android.gms.ads.internal.util.zzg zza;

    public zzcnw(com.google.android.gms.ads.internal.util.zzg zzgVar) {
        this.zza = zzgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcnu
    public final void zza(Map map) {
        this.zza.zzb(Boolean.parseBoolean((String) map.get("content_url_opted_out")));
    }
}
