package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzey implements zzcy {
    final /* synthetic */ Runnable zza;
    final /* synthetic */ zzfa zzb;

    zzey(zzfa zzfaVar, Runnable runnable) {
        this.zza = runnable;
        this.zzb = zzfaVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzcy
    public final void zza(Throwable th) {
        this.zzb.zzb.post(this.zza);
    }
}
