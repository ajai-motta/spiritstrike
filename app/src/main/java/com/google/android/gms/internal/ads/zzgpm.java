package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzgpm<K, V> extends zzgoa<K, V> implements Serializable {
    final transient zzgph<K, ? extends zzgpa<V>> map;
    final transient int size;

    zzgpm(zzgph zzgphVar, int i) {
        this.map = zzgphVar;
        this.size = i;
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    public final int zzd() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    @Deprecated
    public final boolean zze(Object obj, Object obj2) {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgqm
    @Deprecated
    public final void zzf() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    final Set zzh() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    final /* synthetic */ Collection zzj() {
        return new zzgpl(this);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    final Map zzl() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.ads.zzgnz
    public final boolean zzr(Object obj) {
        return obj != null && super.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    public final /* bridge */ /* synthetic */ Collection zzt() {
        throw null;
    }

    @Override // com.google.android.gms.internal.ads.zzgnz, com.google.android.gms.internal.ads.zzgqm
    public /* synthetic */ Map zzu() {
        return this.map;
    }
}
