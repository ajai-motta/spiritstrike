package com.google.android.recaptcha.internal;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzop extends AbstractMap {
    private static final Comparator zza = new zzom();
    private final Object[] zzb;
    private final int[] zzc;
    private final Set zzd = new zzoo(this, -1);
    private Integer zze = null;
    private String zzf = null;

    zzop(List list) {
        Iterator it = list.iterator();
        if (it.hasNext()) {
            zzol.zza((zzol) it.next());
            throw null;
        }
        int size = list.size();
        Object[] objArrCopyOf = new Object[size];
        int[] iArr = new int[1];
        Iterator it2 = list.iterator();
        if (it2.hasNext()) {
            zzol.zza((zzol) it2.next());
            throw null;
        }
        iArr[0] = 0;
        if (size > 16 && size * 9 > 0) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, 0);
        }
        this.zzb = objArrCopyOf;
        this.zzc = iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return this.zzd;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }
}
