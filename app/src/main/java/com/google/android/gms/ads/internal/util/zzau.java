package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.internal.client.zzdm;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzau extends zzdm {
    final /* synthetic */ Context zza;
    final /* synthetic */ zzax zzb;

    zzau(zzax zzaxVar, Context context) {
        this.zza = context;
        Objects.requireNonNull(zzaxVar);
        this.zzb = zzaxVar;
    }

    @Override // com.google.android.gms.ads.internal.client.zzdn
    public final void zze(com.google.android.gms.ads.internal.client.zze zzeVar) {
        if (zzeVar == null) {
            return;
        }
        this.zzb.zzn(this.zza, zzeVar.zzb, true, true);
    }
}
