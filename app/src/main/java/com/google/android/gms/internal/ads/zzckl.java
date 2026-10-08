package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckl implements zzifh {
    private final zzcjp zza;

    private zzckl(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzckl zza(zzcjp zzcjpVar) {
        return new zzckl(zzcjpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return Long.valueOf(this.zza.zzi());
    }
}
