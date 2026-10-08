package com.google.android.gms.internal.ads;

import android.os.Build;
import android.util.SparseBooleanArray;
import com.google.firebase.analytics.FirebaseAnalytics;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzs {
    private final SparseBooleanArray zza;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzs)) {
            return false;
        }
        zzs zzsVar = (zzs) obj;
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.equals(zzsVar.zza);
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        if (sparseBooleanArray.size() != zzsVar.zza.size()) {
            return false;
        }
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            if (zzc(i) != zzsVar.zzc(i)) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.zza.hashCode();
        }
        SparseBooleanArray sparseBooleanArray = this.zza;
        int size = sparseBooleanArray.size();
        for (int i = 0; i < sparseBooleanArray.size(); i++) {
            size = (size * 31) + zzc(i);
        }
        return size;
    }

    public final boolean zza(int i) {
        return this.zza.get(i);
    }

    public final int zzb() {
        return this.zza.size();
    }

    public final int zzc(int i) {
        SparseBooleanArray sparseBooleanArray = this.zza;
        zzgmd.zzm(i, sparseBooleanArray.size(), FirebaseAnalytics.Param.INDEX);
        return sparseBooleanArray.keyAt(i);
    }
}
