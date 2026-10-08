package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzlp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzxr implements Comparable {
    private final boolean zza;
    private final boolean zzb;

    public zzxr(zzv zzvVar, int i) {
        this.zza = 1 == (zzvVar.zze & 1);
        this.zzb = zzlp.CC.zzaa(i, false);
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxr zzxrVar) {
        return zzgot.zzg().zzd(this.zzb, zzxrVar.zzb).zzd(this.zza, zzxrVar.zza).zze();
    }
}
