package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzgwc {
    private static final zzgwa zza = zzgwb.zza;
    private final zzgvt zzb;
    private final zzgvv zzc;
    private final int zzd;
    private final boolean zze;
    private final boolean zzf;
    private final zzgwa zzg;
    private final int zzh;

    /* synthetic */ zzgwc(zzgvt zzgvtVar, int i, int i2, boolean z, boolean z2, zzgwa zzgwaVar, byte[] bArr) {
        this.zzb = zzgvtVar;
        this.zzh = i;
        int i3 = i - 2;
        this.zzc = i3 != 1 ? i3 != 3 ? zzgvv.zzb : zzgvv.zzc : zzgvv.zza;
        this.zzd = i2;
        this.zze = z;
        this.zzf = z2;
        this.zzg = zzgwaVar;
    }

    public final zzgvt zza() {
        this.zzg.zza(this);
        return this.zzb;
    }

    public final zzgvv zzb() {
        return this.zzc;
    }

    public final int zzc() {
        return this.zzd;
    }

    public final boolean zzd() {
        return this.zze;
    }

    final /* synthetic */ zzgvt zzf() {
        return this.zzb;
    }

    final /* synthetic */ int zzg() {
        return this.zzd;
    }

    final /* synthetic */ boolean zzh() {
        return this.zze;
    }

    final /* synthetic */ boolean zzi() {
        return this.zzf;
    }

    final /* synthetic */ int zzj() {
        return this.zzh;
    }
}
