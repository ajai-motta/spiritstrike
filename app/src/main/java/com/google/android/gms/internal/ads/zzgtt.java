package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzgtt extends zzgtk {
    private List zza;

    zzgtt(zzgpa zzgpaVar, boolean z) {
        super(zzgpaVar, z, true);
        List listEmptyList = zzgpaVar.isEmpty() ? Collections.emptyList() : zzgqe.zzb(zzgpaVar.size());
        for (int i = 0; i < zzgpaVar.size(); i++) {
            listEmptyList.add(null);
        }
        this.zza = listEmptyList;
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzA(int i) {
        super.zzA(i);
        this.zza = null;
    }

    abstract Object zzD(List list);

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzw(int i, Object obj) {
        List list = this.zza;
        if (list != null) {
            list.set(i, new zzgts(obj));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzgtk
    final void zzx() {
        List list = this.zza;
        if (list != null) {
            zza(zzD(list));
        }
    }
}
