package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhts extends AbstractSet {
    final /* synthetic */ zzhtx zza;

    zzhts(zzhtx zzhtxVar) {
        Objects.requireNonNull(zzhtxVar);
        this.zza = zzhtxVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.zza.zzc((Map.Entry) obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new zzhtr(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        zzhtx zzhtxVar;
        zzhtw zzhtwVarZzc;
        if (!(obj instanceof Map.Entry) || (zzhtwVarZzc = (zzhtxVar = this.zza).zzc((Map.Entry) obj)) == null) {
            return false;
        }
        zzhtxVar.zzd(zzhtwVarZzc, true);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.zzb;
    }
}
