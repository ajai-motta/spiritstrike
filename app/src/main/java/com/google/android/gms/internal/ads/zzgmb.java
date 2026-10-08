package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public abstract class zzgmb implements Serializable {
    zzgmb() {
    }

    public static zzgmb zzc() {
        return zzglk.zza;
    }

    public static zzgmb zzd(Object obj) {
        return obj == null ? zzglk.zza : new zzgmi(obj);
    }

    public abstract Object zza(Object obj);

    public abstract zzgmb zzb(zzglu zzgluVar);
}
