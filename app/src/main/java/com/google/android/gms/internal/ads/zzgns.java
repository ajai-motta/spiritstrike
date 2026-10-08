package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
class zzgns implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzgnt zzc;

    zzgns(zzgnt zzgntVar) {
        Objects.requireNonNull(zzgntVar);
        this.zzc = zzgntVar;
        this.zzb = zzgntVar.zzb;
        Collection collection = zzgntVar.zzb;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzgnt zzgntVar = this.zzc;
        zzgntVar.zze.zzq(r1.zzp() - 1);
        zzgntVar.zzb();
    }

    final void zza() {
        zzgnt zzgntVar = this.zzc;
        zzgntVar.zza();
        if (zzgntVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    zzgns(zzgnt zzgntVar, Iterator it) {
        Objects.requireNonNull(zzgntVar);
        this.zzc = zzgntVar;
        this.zzb = zzgntVar.zzb;
        this.zza = it;
    }
}
