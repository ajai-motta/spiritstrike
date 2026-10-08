package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvy implements Iterator {
    final /* synthetic */ zzvz zza;
    private int zzb = 0;

    zzvy(zzvz zzvzVar) {
        this.zza = zzvzVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zzb;
        zzvz zzvzVar = this.zza;
        return i < zzvzVar.zza() - zzvzVar.zzb();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zzb;
        zzvz zzvzVar = this.zza;
        if (i >= zzvzVar.zza() - zzvzVar.zzb()) {
            throw new NoSuchElementException();
        }
        zzvz zzvzVar2 = this.zza;
        Object obj = zzvzVar2.zzb.zzb[zzvzVar2.zzb() + i];
        this.zzb = i + 1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
