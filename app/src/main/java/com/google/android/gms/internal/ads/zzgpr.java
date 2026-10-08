package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzgpr<K, V> extends zzgpm<K, V> implements zzgqm<K, V> {
    private final transient zzgpo<V> emptySet;
    private transient zzgpo zza;

    zzgpr(zzgph zzgphVar, int i, Comparator comparator) {
        super(zzgphVar, i);
        this.emptySet = zzgrf.zza;
    }

    public final zzgpo zza() {
        zzgpo zzgpoVar = this.zza;
        if (zzgpoVar != null) {
            return zzgpoVar;
        }
        zzgpq zzgpqVar = new zzgpq(this);
        this.zza = zzgpqVar;
        return zzgpqVar;
    }
}
