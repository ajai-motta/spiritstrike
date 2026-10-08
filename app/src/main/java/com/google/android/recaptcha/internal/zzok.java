package com.google.android.recaptcha.internal;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzok implements Comparator {
    zzok() {
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        zzoq zzoqVarZza = zzoq.zza(obj);
        zzoq zzoqVarZza2 = zzoq.zza(obj2);
        if (zzoqVarZza != zzoqVarZza2) {
            return zzoqVarZza.compareTo(zzoqVarZza2);
        }
        int iOrdinal = zzoqVarZza.ordinal();
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
