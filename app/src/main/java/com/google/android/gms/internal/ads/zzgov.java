package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgov extends zzgow implements Map {
    protected zzgov() {
    }

    @Override // java.util.Map
    public final void clear() {
        zza().clear();
    }

    public boolean containsKey(Object obj) {
        return zza().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return zza().containsValue(obj);
    }

    public Set entrySet() {
        return zza().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || zza().equals(obj);
    }

    public Object get(Object obj) {
        return zza().get(obj);
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public boolean isEmpty() {
        return zza().isEmpty();
    }

    public Set keySet() {
        return zza().keySet();
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        return zza().put(obj, obj2);
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        zza().putAll(map);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        return zza().remove(obj);
    }

    public int size() {
        return zza().size();
    }

    @Override // java.util.Map
    public final Collection values() {
        return zza().values();
    }

    protected abstract Map zza();

    @Override // com.google.android.gms.internal.ads.zzgow
    protected /* bridge */ /* synthetic */ Object zzb() {
        throw null;
    }

    protected final boolean zzc(Object obj) {
        zzgqg zzgqgVar = new zzgqg(entrySet().iterator());
        if (obj == null) {
            while (zzgqgVar.hasNext()) {
                if (zzgqgVar.next() == null) {
                    return true;
                }
            }
        } else {
            while (zzgqgVar.hasNext()) {
                if (obj.equals(zzgqgVar.next())) {
                    return true;
                }
            }
        }
        return false;
    }

    protected final boolean zzd(Object obj) {
        return zzgql.zzb(this, obj);
    }

    protected final int zze() {
        return zzgro.zzc(entrySet());
    }
}
