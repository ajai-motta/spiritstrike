package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzxj implements Comparator {
    static final /* synthetic */ zzxj zza = new zzxj();

    private /* synthetic */ zzxj() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        List list = (List) obj2;
        List list2 = (List) obj;
        return zzgot.zzg().zza((zzyh) Collections.max(list2, zzyg.zza), (zzyh) Collections.max(list, zzyb.zza), zzyc.zza).zzb(list2.size(), list.size()).zza((zzyh) Collections.max(list2, zzyd.zza), (zzyh) Collections.max(list, zzye.zza), zzyf.zza).zze();
    }
}
