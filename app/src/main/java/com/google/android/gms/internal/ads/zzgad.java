package com.google.android.gms.internal.ads;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgad implements zzgtq {
    final /* synthetic */ zzgai zza;

    zzgad(zzgai zzgaiVar) {
        Objects.requireNonNull(zzgaiVar);
        this.zza = zzgaiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgtq
    public final /* bridge */ /* synthetic */ ListenableFuture zza(Object obj) throws Exception {
        zzgab zzgabVar = (zzgab) obj;
        if (zzgabVar != null) {
            return zzgui.zza(zzgabVar);
        }
        zzgai zzgaiVar = this.zza;
        zzgaiVar.zza().zzb(51);
        return zzgaiVar.zzd(2);
    }
}
