package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdif implements zzifh {
    private final zzdia zza;

    private zzdif(zzdia zzdiaVar) {
        this.zza = zzdiaVar;
    }

    public static zzdif zzc(zzdia zzdiaVar) {
        return new zzdif(zzdiaVar);
    }

    public final View zza() {
        return this.zza.zzd();
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* synthetic */ Object zzb() {
        return this.zza.zzd();
    }
}
