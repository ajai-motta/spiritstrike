package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgpg {
    Object[] zza;
    int zzb;
    zzgpf zzc;

    public zzgpg() {
        this(4);
    }

    private final void zzd(int i) {
        Object[] objArr = this.zza;
        int length = objArr.length;
        int i2 = i + i;
        if (i2 > length) {
            this.zza = Arrays.copyOf(objArr, zzgoz.zze(length, i2));
        }
    }

    public final zzgpg zza(Object obj, Object obj2) {
        zzd(this.zzb + 1);
        zzgoc.zza(obj, obj2);
        Object[] objArr = this.zza;
        int i = this.zzb;
        int i2 = i + i;
        objArr[i2] = obj;
        objArr[i2 + 1] = obj2;
        this.zzb = i + 1;
        return this;
    }

    public final zzgpg zzb(Iterable iterable) {
        if (iterable instanceof Collection) {
            zzd(this.zzb + ((Collection) iterable).size());
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            zza(entry.getKey(), entry.getValue());
        }
        return this;
    }

    public final zzgph zzc() {
        zzgpf zzgpfVar = this.zzc;
        if (zzgpfVar != null) {
            throw zzgpfVar.zza();
        }
        zzgre zzgreVarZzk = zzgre.zzk(this.zzb, this.zza, this);
        zzgpf zzgpfVar2 = this.zzc;
        if (zzgpfVar2 == null) {
            return zzgreVarZzk;
        }
        throw zzgpfVar2.zza();
    }

    zzgpg(int i) {
        this.zza = new Object[i + i];
        this.zzb = 0;
    }
}
