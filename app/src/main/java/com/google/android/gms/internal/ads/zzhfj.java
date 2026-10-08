package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhfj implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    zzhfj(zzhfm zzhfmVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzhfmVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzhfl(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
