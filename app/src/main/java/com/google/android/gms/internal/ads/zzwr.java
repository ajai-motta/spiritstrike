package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzwr implements zzwk {
    private final zzwk zza;
    private final long zzb;

    public zzwr(zzwk zzwkVar, long j) {
        this.zza = zzwkVar;
        this.zzb = j;
    }

    public final zzwk zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final boolean zzb() {
        return this.zza.zzb();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final void zzc() throws IOException {
        this.zza.zzc();
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zzd(zzkj zzkjVar, zzhh zzhhVar, int i) {
        int iZzd = this.zza.zzd(zzkjVar, zzhhVar, i);
        if (iZzd != -4) {
            return iZzd;
        }
        zzhhVar.zze += this.zzb;
        return -4;
    }

    @Override // com.google.android.gms.internal.ads.zzwk
    public final int zze(long j) {
        return this.zza.zze(j - this.zzb);
    }
}
