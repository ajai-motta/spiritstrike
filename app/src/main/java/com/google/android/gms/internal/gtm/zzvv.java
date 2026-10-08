package com.google.android.gms.internal.gtm;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzvv implements Comparator {
    zzvv() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzwb zzwbVarZza = zzwb.zza(obj);
        zzwb zzwbVarZza2 = zzwb.zza(obj2);
        if (zzwbVarZza != zzwbVarZza2) {
            return zzwbVarZza.compareTo(zzwbVarZza2);
        }
        int iOrdinal = zzwbVarZza.ordinal();
        if (iOrdinal == 0) {
            return ((Boolean) obj).compareTo((Boolean) obj2);
        }
        if (iOrdinal == 1) {
            return ((String) obj).compareTo((String) obj2);
        }
        if (iOrdinal == 2) {
            return ((Long) obj).compareTo((Long) obj2);
        }
        if (iOrdinal == 3) {
            return ((Double) obj).compareTo((Double) obj2);
        }
        throw null;
    }
}
