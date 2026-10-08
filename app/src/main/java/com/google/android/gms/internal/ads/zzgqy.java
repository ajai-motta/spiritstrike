package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgqy implements Comparator {
    protected zzgqy() {
    }

    public static zzgqy zzb() {
        return zzgqw.zza;
    }

    public static zzgqy zzc(Comparator comparator) {
        return new zzgop(comparator);
    }

    @Override // java.util.Comparator
    public abstract int compare(Object obj, Object obj2);

    public zzgqy zza() {
        return new zzgrh(this);
    }

    public final zzgqy zzd(zzglu zzgluVar) {
        return new zzgob(zzgluVar, this);
    }
}
