package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzgjp extends zzgkq {
    private int zza;
    private String zzb;
    private int zzc;
    private byte zzd;

    zzgjp() {
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zza(int i) {
        this.zza = i;
        this.zzd = (byte) (this.zzd | 1);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zzb(String str) {
        this.zzb = str;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkq zzc(int i) {
        this.zzc = i;
        this.zzd = (byte) (this.zzd | 2);
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzgkq
    public final zzgkr zzd() {
        if (this.zzd == 3) {
            return new zzgjq(this.zza, this.zzb, this.zzc, null);
        }
        StringBuilder sb = new StringBuilder();
        if ((this.zzd & 1) == 0) {
            sb.append(" statusCode");
        }
        if ((this.zzd & 2) == 0) {
            sb.append(" uiMode");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
