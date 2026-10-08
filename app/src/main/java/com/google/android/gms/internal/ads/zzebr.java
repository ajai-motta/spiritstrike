package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzebr implements zzguf {
    final /* synthetic */ Context zza;

    zzebr(Context context) {
        this.zza = context;
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        if (((Boolean) zzbgm.zzh.zze()).booleanValue() && (th instanceof com.google.android.gms.ads.internal.util.zzaz)) {
            zzbef.zze(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        if (((Boolean) zzbgm.zzj.zze()).booleanValue()) {
            zzbef.zze(this.zza);
        }
    }
}
