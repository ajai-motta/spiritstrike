package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgqe {
    public static ArrayList zza(Iterator it) {
        ArrayList arrayList = new ArrayList();
        it.getClass();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static ArrayList zzb(int i) {
        zzgoc.zzb(i, "initialArraySize");
        return new ArrayList(i);
    }

    public static List zzc(List list, zzglu zzgluVar) {
        return list instanceof RandomAccess ? new zzgqb(list, zzgluVar) : new zzgqd(list, zzgluVar);
    }
}
