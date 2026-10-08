package com.google.android.gms.internal.gtm;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zztv extends zztl {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc = 6;

    zztv(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zztd.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zza[i + i + this.zzb]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
