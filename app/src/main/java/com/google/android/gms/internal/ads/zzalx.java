package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzalx implements Comparable {
    public final int zza;
    public final zzals zzb;

    public zzalx(int i, zzals zzalsVar) {
        this.zza = i;
        this.zzb = zzalsVar;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Integer.compare(this.zza, ((zzalx) obj).zza);
    }
}
