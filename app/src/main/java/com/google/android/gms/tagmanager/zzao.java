package com.google.android.gms.tagmanager;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzao implements zzar {
    final /* synthetic */ DataLayer zza;

    zzao(DataLayer dataLayer) {
        this.zza = dataLayer;
    }

    @Override // com.google.android.gms.tagmanager.zzar
    public final void zza(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzap zzapVar = (zzap) it.next();
            DataLayer dataLayer = this.zza;
            dataLayer.zzi(dataLayer.zza(zzapVar.zza, zzapVar.zzb));
        }
        this.zza.zzh.countDown();
    }
}
