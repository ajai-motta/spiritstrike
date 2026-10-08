package com.google.android.gms.internal.ads;

import android.content.pm.ApplicationInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcju implements zzifh {
    private final zzifq zza;

    private zzcju(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcju zza(zzifq zzifqVar) {
        return new zzcju(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        ApplicationInfo applicationInfo = ((zzcjv) this.zza).zza().getApplicationInfo();
        zzifp.zzb(applicationInfo);
        return applicationInfo;
    }
}
