package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzeng implements com.google.android.gms.ads.internal.zzg {
    final /* synthetic */ zzdhx zza;

    zzeng(zzenh zzenhVar, zzdhx zzdhxVar) {
        this.zza = zzdhxVar;
        Objects.requireNonNull(zzenhVar);
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zza(View view) {
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzb() {
        this.zza.zzc().onAdClicked();
    }

    @Override // com.google.android.gms.ads.internal.zzg
    public final void zzc() {
        zzdhx zzdhxVar = this.zza;
        zzdhxVar.zzd().zza();
        zzdhxVar.zze().zza();
    }
}
