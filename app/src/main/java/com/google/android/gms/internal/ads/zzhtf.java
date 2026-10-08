package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhtf extends zzhtg implements Iterable {
    private final ArrayList zza = new ArrayList();

    public final boolean equals(Object obj) {
        if (obj != this) {
            return (obj instanceof zzhtf) && ((zzhtf) obj).zza.equals(this.zza);
        }
        return true;
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return this.zza.iterator();
    }

    public final void zza(zzhtg zzhtgVar) {
        this.zza.add(zzhtgVar);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final zzhtg zzc(int i) {
        return (zzhtg) this.zza.get(i);
    }

    @Override // com.google.android.gms.internal.ads.zzhtg
    public final String zzd() {
        ArrayList arrayList = this.zza;
        int size = arrayList.size();
        if (size == 1) {
            return ((zzhtg) arrayList.get(0)).zzd();
        }
        StringBuilder sb = new StringBuilder(String.valueOf(size).length() + 37);
        sb.append("Array must have size 1, but has size ");
        sb.append(size);
        throw new IllegalStateException(sb.toString());
    }
}
