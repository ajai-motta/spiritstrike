package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcyd implements zzifh {
    private final zzcxx zza;

    private zzcyd(zzcxx zzcxxVar) {
        this.zza = zzcxxVar;
    }

    public static zzcyd zza(zzcxx zzcxxVar) {
        return new zzcyd(zzcxxVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return Integer.valueOf(this.zza.zzh());
    }
}
