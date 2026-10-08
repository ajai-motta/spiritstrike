package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgrb extends zzgpo {
    private final transient zzgph zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzgrb(zzgph zzgphVar, Object[] objArr, int i, int i2) {
        this.zza = zzgphVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo, com.google.android.gms.internal.ads.zzgpa, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgpo, com.google.android.gms.internal.ads.zzgpa
    /* JADX INFO: renamed from: zza */
    public final zzgrs iterator() {
        return zze().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgpa
    final int zzg(Object[] objArr, int i) {
        return zze().zzg(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzgpo
    final zzgpe zzr() {
        return new zzgra(this);
    }

    final /* synthetic */ Object[] zzv() {
        return this.zzb;
    }

    final /* synthetic */ int zzw() {
        return this.zzc;
    }
}
