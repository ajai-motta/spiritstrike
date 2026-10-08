package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgtr extends zzgtt {
    zzgtr(zzgpa zzgpaVar, boolean z) {
        super(zzgpaVar, z);
        zze();
    }

    @Override // com.google.android.gms.internal.ads.zzgtt
    public final /* bridge */ /* synthetic */ Object zzD(List list) {
        ArrayList arrayListZzb = zzgqe.zzb(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzgts zzgtsVar = (zzgts) it.next();
            arrayListZzb.add(zzgtsVar != null ? zzgtsVar.zza : null);
        }
        return Collections.unmodifiableList(arrayListZzb);
    }
}
