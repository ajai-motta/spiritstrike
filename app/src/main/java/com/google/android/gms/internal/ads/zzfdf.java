package com.google.android.gms.internal.ads;

import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfdf implements zzglu {
    final /* synthetic */ zzfdi zza;

    zzfdf(zzfdi zzfdiVar) {
        Objects.requireNonNull(zzfdiVar);
        this.zza = zzfdiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    @NullableDecl
    public final /* bridge */ /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzbxj zzbxjVar = (zzbxj) obj;
        zzfdg zzfdgVar = new zzfdg(zzbxjVar, new zzfio(zzbxjVar.zzj), null);
        zzfdi zzfdiVar = this.zza;
        zzfdiVar.zzd(zzfdgVar);
        return zzfdiVar.zzc();
    }
}
