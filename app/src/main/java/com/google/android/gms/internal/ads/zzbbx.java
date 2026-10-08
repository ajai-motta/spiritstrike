package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzbbx implements Comparator {
    zzbbx(zzbbz zzbbzVar) {
        Objects.requireNonNull(zzbbzVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbcc zzbccVar = (zzbcc) obj;
        zzbcc zzbccVar2 = (zzbcc) obj2;
        int i = zzbccVar.zzc - zzbccVar2.zzc;
        return i != 0 ? i : Long.compare(zzbccVar.zza, zzbccVar2.zza);
    }
}
