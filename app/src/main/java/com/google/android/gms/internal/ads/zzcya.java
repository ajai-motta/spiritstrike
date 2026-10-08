package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcya implements zzifh {
    private final zzcxx zza;

    private zzcya(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    public static zzcya zzc(zzcxx zzcxxVar) {
        return new zzcya(zzcxxVar);
    }

    public final Bundle zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
