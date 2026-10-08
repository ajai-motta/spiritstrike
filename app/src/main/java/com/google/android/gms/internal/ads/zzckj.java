package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzckj implements zzifh {
    private final zzcjp zza;

    private zzckj(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
    }

    public static zzckj zza(zzcjp zzcjpVar) {
        return new zzckj(zzcjpVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        String strZze = this.zza.zze();
        zzifp.zzb(strZze);
        return strZze;
    }
}
