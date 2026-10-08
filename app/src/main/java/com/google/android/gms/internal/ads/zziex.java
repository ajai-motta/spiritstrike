package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zziex implements Iterator {
    int zza = 0;
    final /* synthetic */ zziey zzb;

    zziex(zziey zzieyVar) {
        this.zzb = zzieyVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.zza;
        zziey zzieyVar = this.zzb;
        return i < zzieyVar.zza.size() || zzieyVar.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.zza;
        zziey zzieyVar = this.zzb;
        List list = zzieyVar.zza;
        if (i >= list.size()) {
            list.add(zzieyVar.zzb.next());
            return next();
        }
        int i2 = this.zza;
        this.zza = i2 + 1;
        return list.get(i2);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
