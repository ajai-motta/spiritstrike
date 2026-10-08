package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzeqq implements zzifh {
    private final zzifq zza;

    private zzeqq(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzeqq zza(zzifq zzifqVar) {
        return new zzeqq(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzeqp((Set) this.zza.zzb());
    }
}
