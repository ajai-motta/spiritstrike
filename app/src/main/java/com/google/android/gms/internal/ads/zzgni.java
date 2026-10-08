package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgni implements Iterator {
    final Iterator zza;
    Collection zzb;
    final /* synthetic */ zzgnj zzc;

    zzgni(zzgnj zzgnjVar) {
        Objects.requireNonNull(zzgnjVar);
        this.zzc = zzgnjVar;
        this.zza = zzgnjVar.zza.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Map.Entry entry = (Map.Entry) this.zza.next();
        this.zzb = (Collection) entry.getValue();
        return this.zzc.zzb(entry);
    }

    @Override // java.util.Iterator
    public final void remove() {
        zzgmd.zzi(this.zzb != null, "no calls to next() since the last call to remove()");
        this.zza.remove();
        int size = this.zzb.size();
        zzgnw zzgnwVar = this.zzc.zzb;
        zzgnwVar.zzq(zzgnwVar.zzp() - size);
        this.zzb.clear();
        this.zzb = null;
    }
}
