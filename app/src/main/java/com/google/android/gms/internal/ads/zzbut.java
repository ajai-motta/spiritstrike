package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbut extends zzbjl {
    final /* synthetic */ zzbuv zza;

    /* synthetic */ zzbut(zzbuv zzbuvVar, byte[] bArr) {
        Objects.requireNonNull(zzbuvVar);
        this.zza = zzbuvVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbjm
    public final void zze(zzbjc zzbjcVar, String str) {
        zzbuv zzbuvVar = this.zza;
        if (zzbuvVar.zze() == null) {
            return;
        }
        zzbuvVar.zze().onCustomClick(zzbuvVar.zzc(zzbjcVar), str);
    }
}
