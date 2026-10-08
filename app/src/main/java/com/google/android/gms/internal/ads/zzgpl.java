package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgpl extends zzgpa {
    private final transient zzgpm zza;

    zzgpl(zzgpm zzgpmVar) {
        this.zza = zzgpmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgpj(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return new zzgpj(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    final boolean zzf() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgpa
    final int zzg(Object[] objArr, int i) {
        zzgrt zzgrtVarListIterator = ((zzgpe) this.zza.map.values()).listIterator(0);
        while (zzgrtVarListIterator.hasNext()) {
            i = ((zzgpa) zzgrtVarListIterator.next()).zzg(objArr, i);
        }
        return i;
    }
}
