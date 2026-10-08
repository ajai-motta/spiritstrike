package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzhvc extends zzhvg {
    private final int zzc;
    private final int zzd;

    zzhvc(byte[] bArr, int i, int i2) {
        super(bArr);
        zzA(i, i + i2, bArr.length);
        this.zzc = i;
        this.zzd = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final byte zza(int i) {
        zzz(i, this.zzd);
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    final byte zzb(int i) {
        return this.zza[this.zzc + i];
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    public final int zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg
    protected final int zzd() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhvg, com.google.android.gms.internal.ads.zzhvi
    protected final void zze(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zza, this.zzc + i, bArr, i2, i3);
    }
}
