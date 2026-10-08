package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaez implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;

    private zzaez(int i, int i2, int i3, int i4) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = i3;
    }

    public static zzaez zzb(zzeg zzegVar) {
        int iZzC = zzegVar.zzC();
        zzegVar.zzk(8);
        int iZzC2 = zzegVar.zzC();
        int iZzC3 = zzegVar.zzC();
        zzegVar.zzk(4);
        int iZzC4 = zzegVar.zzC();
        zzegVar.zzk(12);
        return new zzaez(iZzC, iZzC2, iZzC3, iZzC4);
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return AviExtractor.FOURCC_avih;
    }
}
