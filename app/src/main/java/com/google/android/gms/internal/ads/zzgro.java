package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.SortedSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgro {
    public static zzgrn zza(Set set, Set set2) {
        zzgmd.zzk(set, "set1");
        zzgmd.zzk(set2, "set2");
        return new zzgrj(set, set2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Set zzb(Set set, zzgme zzgmeVar) {
        if (!(set instanceof SortedSet)) {
            if (!(set instanceof zzgrk)) {
                set.getClass();
                return new zzgrk(set, zzgmeVar);
            }
            zzgrk zzgrkVar = (zzgrk) set;
            return new zzgrk((Set) zzgrkVar.zza, zzgmh.zzb(zzgrkVar.zzb, zzgmeVar));
        }
        SortedSet sortedSet = (SortedSet) set;
        if (!(sortedSet instanceof zzgrk)) {
            sortedSet.getClass();
            return new zzgrl(sortedSet, zzgmeVar);
        }
        zzgrk zzgrkVar2 = (zzgrk) sortedSet;
        return new zzgrl((SortedSet) zzgrkVar2.zza, zzgmh.zzb(zzgrkVar2.zzb, zzgmeVar));
    }

    static int zzc(Set set) {
        Iterator it = set.iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    static boolean zzd(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    static boolean zze(Set set, Iterator it) {
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= set.remove(it.next());
        }
        return zRemove;
    }

    static boolean zzf(Set set, Collection collection) {
        collection.getClass();
        if (collection instanceof zzgqv) {
            collection = ((zzgqv) collection).zza();
        }
        if (!(collection instanceof Set) || collection.size() <= set.size()) {
            return zze(set, collection.iterator());
        }
        Iterator it = set.iterator();
        collection.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }
}
