package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgjc implements zzguf {
    final /* synthetic */ zzgjb zza;

    zzgjc(zzgjd zzgjdVar, zzgjb zzgjbVar) {
        this.zza = zzgjbVar;
        Objects.requireNonNull(zzgjdVar);
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zza(Throwable th) {
        zzgjb zzgjbVar = this.zza;
        zzgjbVar.zzb(th);
        zzgjbVar.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzguf
    public final void zzb(Object obj) {
        this.zza.zzc();
    }
}
