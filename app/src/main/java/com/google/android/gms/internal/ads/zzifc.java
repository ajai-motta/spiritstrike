package com.google.android.gms.internal.ads;

import java.util.LinkedHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzifc {
    final LinkedHashMap zza;

    zzifc(int i) {
        this.zza = zzife.zzc(i);
    }

    final zzifc zza(Object obj, zzifq zzifqVar) {
        zzifp.zza(obj, "key");
        zzifp.zza(zzifqVar, "provider");
        this.zza.put(obj, zzifqVar);
        return this;
    }
}
