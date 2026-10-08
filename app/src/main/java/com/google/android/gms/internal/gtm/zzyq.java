package com.google.android.gms.internal.gtm;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzyq extends zzyr {
    final /* synthetic */ zzyx zza;
    private int zzb = 0;
    private final int zzc;

    zzyq(zzyx zzyxVar) {
        this.zza = zzyxVar;
        this.zzc = zzyxVar.zzd();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzyt
    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
