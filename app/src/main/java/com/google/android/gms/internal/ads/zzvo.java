package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvo extends zzadp {
    final /* synthetic */ zzvy zza;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzvo(zzvy zzvyVar, zzaed zzaedVar) {
        super(zzaedVar);
        Objects.requireNonNull(zzvyVar);
        this.zza = zzvyVar;
    }

    @Override // com.google.android.gms.internal.ads.zzadp, com.google.android.gms.internal.ads.zzaed
    public final long zza() {
        return this.zza.zzQ();
    }
}
