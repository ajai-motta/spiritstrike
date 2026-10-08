package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgpt extends zzgne {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ zzgme zzb;

    zzgpt(Iterator it, zzgme zzgmeVar) {
        this.zza = it;
        this.zzb = zzgmeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgne
    protected final Object zza() {
        zzgme zzgmeVar;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            zzgmeVar = this.zzb;
            next = it.next();
        } while (!zzgmeVar.zza(next));
        return next;
    }
}
