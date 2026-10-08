package com.google.android.gms.internal.gtm;

import java.util.AbstractList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzacm extends AbstractList {
    private final zzack zza;

    public zzacm(zzack zzackVar, zzacl zzaclVar) {
        this.zza = zzackVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i) {
        zzam zzamVarZzb = zzam.zzb(this.zza.zze(i));
        return zzamVarZzb == null ? zzam.ESCAPE_HTML : zzamVarZzb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
