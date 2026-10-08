package com.google.android.gms.internal.gtm;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zztr extends zztl {
    static final zztl zza = new zztr(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zztr(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zztd.zza(i, this.zzc, FirebaseAnalytics.Param.INDEX);
        return Objects.requireNonNull(this.zzb[i]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zztl, com.google.android.gms.internal.gtm.zzti
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzti
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzti
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzti
    final Object[] zze() {
        return this.zzb;
    }
}
