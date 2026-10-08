package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final /* synthetic */ class zzdpc implements zzglu {
    static final /* synthetic */ zzdpc zza = new zzdpc();

    private /* synthetic */ zzdpc() {
    }

    @Override // com.google.android.gms.internal.ads.zzglu
    public final /* synthetic */ Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzdpa zzdpaVar : (List) obj) {
            if (zzdpaVar != null) {
                arrayList.add(zzdpaVar);
            }
        }
        return arrayList;
    }
}
