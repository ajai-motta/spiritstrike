package com.google.android.gms.internal.ads;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtm extends zzgtl {
    private static final AtomicReferenceFieldUpdater zza = AtomicReferenceFieldUpdater.newUpdater(zzgto.class, Set.class, "seenExceptionsField");
    private static final AtomicIntegerFieldUpdater zzb = AtomicIntegerFieldUpdater.newUpdater(zzgto.class, "remainingField");

    private zzgtm() {
        throw null;
    }

    /* synthetic */ zzgtm(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    final void zza(zzgto zzgtoVar, Set set, Set set2) {
        AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(zza, zzgtoVar, null, set2);
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    final int zzb(zzgto zzgtoVar) {
        return zzb.decrementAndGet(zzgtoVar);
    }
}
