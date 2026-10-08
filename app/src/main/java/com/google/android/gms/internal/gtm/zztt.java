package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zztt extends zztp {
    private final transient zzto zza;
    private final transient Object[] zzb;
    private final transient int zzc = 6;

    zztt(zzto zztoVar, Object[] objArr, int i, int i2) {
        this.zza = zztoVar;
        this.zzb = objArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzti, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
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

    @Override // com.google.android.gms.internal.gtm.zztp, com.google.android.gms.internal.gtm.zzti, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzti
    final int zza(Object[] objArr, int i) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.gtm.zztp, com.google.android.gms.internal.gtm.zzti
    /* JADX INFO: renamed from: zzd */
    public final zzua iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.gtm.zztp
    final zztl zzh() {
        return new zzts(this);
    }
}
