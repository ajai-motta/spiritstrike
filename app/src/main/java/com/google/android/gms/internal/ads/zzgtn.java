package com.google.android.gms.internal.ads;

import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtn extends zzgtl {
    private zzgtn() {
        throw null;
    }

    /* synthetic */ zzgtn(byte[] bArr) {
        super(null);
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    final void zza(zzgto zzgtoVar, Set set, Set set2) {
        synchronized (zzgtoVar) {
            if (zzgtoVar.seenExceptionsField == null) {
                zzgtoVar.seenExceptionsField = set2;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtl
    final int zzb(zzgto zzgtoVar) {
        int i;
        synchronized (zzgtoVar) {
            i = zzgtoVar.remainingField - 1;
            zzgtoVar.remainingField = i;
        }
        return i;
    }
}
