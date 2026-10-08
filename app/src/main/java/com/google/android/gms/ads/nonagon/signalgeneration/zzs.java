package com.google.android.gms.ads.nonagon.signalgeneration;

import android.util.Pair;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzs extends LinkedHashMap {
    final /* synthetic */ zzv zza;

    zzs(zzv zzvVar) {
        Objects.requireNonNull(zzvVar);
        this.zza = zzvVar;
    }

    @Override // java.util.LinkedHashMap
    protected final boolean removeEldestEntry(Map.Entry entry) {
        zzv zzvVar = this.zza;
        synchronized (zzvVar) {
            if (size() <= zzvVar.zzg()) {
                return false;
            }
            zzvVar.zzh().add(new Pair((String) entry.getKey(), ((zzt) entry.getValue()).zzb));
            return size() > zzvVar.zzg();
        }
    }
}
