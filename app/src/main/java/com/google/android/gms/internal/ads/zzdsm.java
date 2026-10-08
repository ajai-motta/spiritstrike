package com.google.android.gms.internal.ads;

import android.content.Context;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzdsm implements zzczj {
    private final zzcgy zza;

    zzdsm(zzcgy zzcgyVar) {
        this.zza = zzcgyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zza(Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.onPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzb(Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.onResume();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzczj
    public final void zzc(Context context) {
        zzcgy zzcgyVar = this.zza;
        if (zzcgyVar != null) {
            zzcgyVar.destroy();
        }
    }
}
