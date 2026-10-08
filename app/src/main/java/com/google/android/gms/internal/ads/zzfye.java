package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfye implements zzifq {
    final /* synthetic */ zzfyf zza;

    zzfye(zzfyf zzfyfVar) {
        Objects.requireNonNull(zzfyfVar);
        this.zza = zzfyfVar;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final /* bridge */ /* synthetic */ Object zzb() {
        zzfyf zzfyfVar = this.zza;
        return new zzfyi(zzfyfVar.zzb(), zzfyfVar.zzc(), null);
    }
}
