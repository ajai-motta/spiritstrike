package com.google.android.gms.internal.ads;

import java.io.Serializable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgmz {
    public static zzgmv zza(zzgmv zzgmvVar) {
        return ((zzgmvVar instanceof zzgmy) || (zzgmvVar instanceof zzgmw)) ? zzgmvVar : zzgmvVar instanceof Serializable ? new zzgmw(zzgmvVar) : new zzgmy(zzgmvVar);
    }
}
