package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzfj extends zzfq {
    private String zza;
    private byte zzb;
    private int zzc;
    private int zzd;

    zzfj() {
    }

    public final zzfq zza(String str) {
        this.zza = "";
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzfq
    public final zzfq zzb(boolean z) {
        this.zzb = (byte) 1;
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzfq
    public final zzfr zzc() {
        if (this.zzb == 1 && this.zza != null && this.zzc != 0 && this.zzd != 0) {
            return new zzfl(this.zza, false, this.zzc, null, null, this.zzd, null);
        }
        StringBuilder sb = new StringBuilder();
        if (this.zza == null) {
            sb.append(" fileOwner");
        }
        if (this.zzb == 0) {
            sb.append(" hasDifferentDmaOwner");
        }
        if (this.zzc == 0) {
            sb.append(" fileChecks");
        }
        if (this.zzd == 0) {
            sb.append(" filePurpose");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }

    @Override // com.google.android.gms.internal.gtm.zzfq
    final zzfq zzd(int i) {
        this.zzc = i;
        return this;
    }

    @Override // com.google.android.gms.internal.gtm.zzfq
    public final zzfq zze(int i) {
        this.zzd = 1;
        return this;
    }
}
