package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
abstract class zzya {
    public final int zza;
    public final zzbg zzb;
    public final int zzc;
    public final zzv zzd;

    public zzya(int i, zzbg zzbgVar, int i2) {
        this.zza = i;
        this.zzb = zzbgVar;
        this.zzc = i2;
        this.zzd = zzbgVar.zza(i2);
    }

    public abstract int zza();

    public abstract boolean zzc(zzya zzyaVar);
}
