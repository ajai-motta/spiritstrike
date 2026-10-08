package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbmh implements com.google.android.gms.ads.internal.overlay.zzaa {
    final /* synthetic */ zzbmk zza;

    zzbmh(zzbmk zzbmkVar) {
        Objects.requireNonNull(zzbmkVar);
        this.zza = zzbmkVar;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zza(boolean z) {
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzaa
    public final void zzb(int i) {
        this.zza.zzg(i);
    }
}
