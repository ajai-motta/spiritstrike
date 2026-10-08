package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhva extends zzhvb {
    final /* synthetic */ zzhvi zza;
    private int zzb;
    private final int zzc;

    zzhva(zzhvi zzhviVar) {
        Objects.requireNonNull(zzhviVar);
        this.zza = zzhviVar;
        this.zzb = 0;
        this.zzc = zzhviVar.zzc();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvd
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
