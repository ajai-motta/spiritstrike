package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zzri;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzek implements zzem {
    final /* synthetic */ Map zza;
    final /* synthetic */ Map zzb;
    final /* synthetic */ Map zzc;
    final /* synthetic */ Map zzd;

    zzek(zzep zzepVar, Map map, Map map2, Map map3, Map map4) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = map3;
        this.zzd = map4;
    }

    @Override // com.google.android.gms.tagmanager.zzem
    public final void zza(zzri zzriVar, Set set, Set set2, zzdj zzdjVar) {
        List list = (List) this.zza.get(zzriVar);
        if (list != null) {
            set.addAll(list);
        }
        List list2 = (List) this.zzc.get(zzriVar);
        if (list2 != null) {
            set2.addAll(list2);
        }
    }
}
