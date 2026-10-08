package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zziff implements zzifh {
    private zzifq zza;

    public static void zza(zzifq zzifqVar, zzifq zzifqVar2) {
        zziff zziffVar = (zziff) zzifqVar;
        if (zziffVar.zza != null) {
            throw new IllegalStateException();
        }
        zziffVar.zza = zzifqVar2;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        zzifq zzifqVar = this.zza;
        if (zzifqVar != null) {
            return zzifqVar.zzb();
        }
        throw new IllegalStateException();
    }
}
