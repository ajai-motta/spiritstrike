package com.google.android.gms.tagmanager;

import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzy implements zzv {
    final /* synthetic */ zzag zza;

    zzy(zzag zzagVar) {
        this.zza = zzagVar;
    }

    @Override // com.google.android.gms.tagmanager.zzv
    public final String zza() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.tagmanager.zzv
    public final void zzb() {
        Log.w("GoogleTagManager", "Refresh ignored: container loaded as default only.");
    }

    @Override // com.google.android.gms.tagmanager.zzv
    public final void zzc(String str) {
        this.zza.zzo(str);
    }
}
