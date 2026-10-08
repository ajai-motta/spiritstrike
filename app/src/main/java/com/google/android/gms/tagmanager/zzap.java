package com.google.android.gms.tagmanager;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-tagmanager-v4-impl@@18.1.1 */
/* JADX INFO: loaded from: classes5.dex */
final class zzap {
    public final String zza;
    public final Object zzb;

    zzap(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzap)) {
            return false;
        }
        zzap zzapVar = (zzap) obj;
        if (!this.zza.equals(zzapVar.zza)) {
            return false;
        }
        Object obj2 = this.zzb;
        if (obj2 == null && zzapVar.zzb == null) {
            return true;
        }
        return obj2 != null && obj2.equals(zzapVar.zzb);
    }

    public final int hashCode() {
        Preconditions.checkNotNull(this.zzb);
        return Arrays.hashCode(new Integer[]{Integer.valueOf(this.zza.hashCode()), Integer.valueOf(this.zzb.hashCode())});
    }

    public final String toString() {
        return "Key: " + this.zza + " value: " + String.valueOf(this.zzb);
    }
}
