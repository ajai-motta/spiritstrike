package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgjr extends zzgkt {
    private String zza;
    private String zzb;

    zzgjr() {
    }

    @Override // com.google.android.gms.internal.ads.zzgkt
    public final zzgkt zza(String str) {
        this.zza = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkt
    public final zzgkt zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkt
    public final zzgku zzc() {
        return new zzgjs(this.zza, this.zzb, null);
    }
}
