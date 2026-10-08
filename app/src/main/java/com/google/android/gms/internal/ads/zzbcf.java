package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbcf implements Comparator {
    public zzbcf(zzbcg zzbcgVar) {
        Objects.requireNonNull(zzbcgVar);
    }

    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        zzbbv zzbbvVar = (zzbbv) obj;
        zzbbv zzbbvVar2 = (zzbbv) obj2;
        if (zzbbvVar.zzb() < zzbbvVar2.zzb()) {
            return -1;
        }
        if (zzbbvVar.zzb() <= zzbbvVar2.zzb()) {
            if (zzbbvVar.zza() < zzbbvVar2.zza()) {
                return -1;
            }
            if (zzbbvVar.zza() <= zzbbvVar2.zza()) {
                float fZzd = (zzbbvVar.zzd() - zzbbvVar.zzb()) * (zzbbvVar.zzc() - zzbbvVar.zza());
                float fZzd2 = (zzbbvVar2.zzd() - zzbbvVar2.zzb()) * (zzbbvVar2.zzc() - zzbbvVar2.zza());
                if (fZzd > fZzd2) {
                    return -1;
                }
                if (fZzd >= fZzd2) {
                    return 0;
                }
            }
        }
        return 1;
    }
}
