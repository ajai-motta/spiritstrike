package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgnu extends zzgns implements ListIterator {
    final /* synthetic */ zzgnv zzd;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgnu(zzgnv zzgnvVar) {
        super(zzgnvVar);
        Objects.requireNonNull(zzgnvVar);
        this.zzd = zzgnvVar;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        zzgnv zzgnvVar = this.zzd;
        boolean zIsEmpty = zzgnvVar.isEmpty();
        zza();
        ((ListIterator) this.zza).add(obj);
        zzgnw zzgnwVar = zzgnvVar.zzf;
        zzgnwVar.zzq(zzgnwVar.zzp() + 1);
        if (zIsEmpty) {
            zzgnvVar.zzc();
        }
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        zza();
        return ((ListIterator) this.zza).hasPrevious();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        zza();
        return ((ListIterator) this.zza).nextIndex();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        zza();
        return ((ListIterator) this.zza).previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        zza();
        return ((ListIterator) this.zza).previousIndex();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        zza();
        ((ListIterator) this.zza).set(obj);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgnu(zzgnv zzgnvVar, int i) {
        super(zzgnvVar, ((List) zzgnvVar.zzb).listIterator(i));
        Objects.requireNonNull(zzgnvVar);
        this.zzd = zzgnvVar;
    }
}
