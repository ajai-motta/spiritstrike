package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcvx implements zzifh {
    private final zzifq zza;
    private final zzifq zzb;

    private zzcvx(zzcvw zzcvwVar, zzifq zzifqVar, zzifq zzifqVar2) {
        this.zza = zzifqVar;
        this.zzb = zzifqVar2;
    }

    public static zzcvx zza(zzcvw zzcvwVar, zzifq zzifqVar, zzifq zzifqVar2) {
        return new zzcvx(zzcvwVar, zzifqVar, zzifqVar2);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        return new com.google.android.gms.ads.internal.zzb((Context) this.zza.zzb(), (zzbzt) this.zzb.zzb(), null);
    }
}
