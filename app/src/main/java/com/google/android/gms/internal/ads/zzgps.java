package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgps {
    public static boolean zza(Iterable iterable, zzgme zzgmeVar) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            zzgmeVar.getClass();
            return zzc((List) iterable, zzgmeVar);
        }
        Iterator it = iterable.iterator();
        zzgmeVar.getClass();
        boolean z = false;
        while (it.hasNext()) {
            if (zzgmeVar.zza(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static Object zzb(Iterable iterable, Object obj) {
        zzgrs it = ((zzgrj) iterable).iterator();
        return it.hasNext() ? it.next() : obj;
    }

    private static boolean zzc(List list, zzgme zzgmeVar) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            Object obj = list.get(i);
            if (!zzgmeVar.zza(obj)) {
                if (i > i2) {
                    try {
                        list.set(i2, obj);
                    } catch (IllegalArgumentException unused) {
                        zzd(list, zzgmeVar, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        zzd(list, zzgmeVar, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    private static void zzd(List list, zzgme zzgmeVar, int i, int i2) {
        int size = list.size();
        while (true) {
            size--;
            if (size <= i2) {
                break;
            } else if (zzgmeVar.zza(list.get(size))) {
                list.remove(size);
            }
        }
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            } else {
                list.remove(i2);
            }
        }
    }
}
