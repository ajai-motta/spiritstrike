package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhwy extends AbstractList {
    private final zzhww zza;
    private final zzhwx zzb;

    public zzhwy(zzhww zzhwwVar, zzhwx zzhwxVar) {
        this.zza = zzhwwVar;
        this.zzb = zzhwxVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        return this.zzb.zzb(this.zza.zzf(i));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
