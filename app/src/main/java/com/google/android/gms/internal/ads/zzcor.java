package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcor implements zzifh {
    private final zzifq zza;

    private zzcor(zzifq zzifqVar) {
        this.zza = zzifqVar;
    }

    public static zzcor zza(zzifq zzifqVar) {
        return new zzcor(zzifqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new zzcoq((Context) this.zza.zzb());
    }
}
