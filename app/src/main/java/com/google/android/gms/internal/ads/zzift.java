package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzift implements zzifh {
    private final List zza;
    private final List zzb;

    static {
        zzifi.zza(Collections.emptySet());
    }

    /* synthetic */ zzift(List list, List list2, zzifr zzifrVar) {
        this.zza = list;
        this.zzb = list2;
    }

    public static zzifs zza(int i, int i2) {
        return new zzifs(i, i2, null);
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    /* JADX INFO: renamed from: zzc, reason: merged with bridge method [inline-methods] */
    public final Set zzb() {
        List list = this.zza;
        int size = list.size();
        List list2 = this.zzb;
        ArrayList arrayList = new ArrayList(list2.size());
        int size2 = list2.size();
        for (int i = 0; i < size2; i++) {
            Collection collection = (Collection) ((zzifq) list2.get(i)).zzb();
            size += collection.size();
            arrayList.add(collection);
        }
        HashSet hashSetZzb = zzife.zzb(size);
        int size3 = list.size();
        for (int i2 = 0; i2 < size3; i2++) {
            Object objZzb = ((zzifq) list.get(i2)).zzb();
            objZzb.getClass();
            hashSetZzb.add(objZzb);
        }
        int size4 = arrayList.size();
        for (int i3 = 0; i3 < size4; i3++) {
            for (Object obj : (Collection) arrayList.get(i3)) {
                obj.getClass();
                hashSetZzb.add(obj);
            }
        }
        return Collections.unmodifiableSet(hashSetZzb);
    }
}
