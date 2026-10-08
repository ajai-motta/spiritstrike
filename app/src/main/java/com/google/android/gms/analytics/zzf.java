package com.google.android.gms.analytics;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzf implements Comparator {
    zzf(zzg zzgVar) {
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        return ((zzj) obj).getClass().getCanonicalName().compareTo(((zzj) obj2).getClass().getCanonicalName());
    }
}
