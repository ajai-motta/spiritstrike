package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzuz {
    private static final zzuu zza = new zzux();
    private static final zzut zzb = new zzuy();

    public static zzur zza(Set set) {
        zzur zzurVar = new zzur(zza, null);
        zzut zzutVar = zzb;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            zzurVar.zzd((zzui) it.next());
        }
        return zzurVar;
    }
}
