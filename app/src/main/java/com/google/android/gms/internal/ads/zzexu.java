package com.google.android.gms.internal.ads;

import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzexu implements zzexy {
    private final Bundle zza;

    public zzexu(Bundle bundle) {
        this.zza = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        Bundle bundle = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (bundle.isEmpty()) {
            return;
        }
        zzcxqVar.zza.putBundle("shared_pref", bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzexy
    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        Bundle bundle = this.zza;
        zzcxq zzcxqVar = (zzcxq) obj;
        if (bundle.isEmpty()) {
            return;
        }
        zzcxqVar.zzb.putBundle("shared_pref", bundle);
    }
}
