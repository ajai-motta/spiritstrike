package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhtb {
    private final zzhsz zza;

    private zzhtb(zzhsz zzhszVar) {
        this.zza = zzhszVar;
    }

    public static zzhtb zza(byte[] bArr, zzgwn zzgwnVar) {
        return new zzhtb(zzhsz.zza(bArr));
    }

    public static zzhtb zzb(int i) {
        return new zzhtb(zzhsz.zza(zzhfz.zza(i)));
    }

    public final byte[] zzc(zzgwn zzgwnVar) {
        return this.zza.zzc();
    }

    public final int zzd() {
        return this.zza.zzd();
    }
}
