package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzafa implements zzaev {
    public final int zza;
    public final int zzb;
    public final int zzc;
    public final int zzd;
    public final int zze;
    public final int zzf;

    private zzafa(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.zza = i;
        this.zzb = i3;
        this.zzc = i4;
        this.zzd = i5;
        this.zze = i6;
        this.zzf = i7;
    }

    public static zzafa zzb(zzeg zzegVar) {
        int iZzC = zzegVar.zzC();
        zzegVar.zzk(12);
        int iZzC2 = zzegVar.zzC();
        int iZzC3 = zzegVar.zzC();
        int iZzC4 = zzegVar.zzC();
        zzegVar.zzk(4);
        int iZzC5 = zzegVar.zzC();
        int iZzC6 = zzegVar.zzC();
        zzegVar.zzk(4);
        return new zzafa(iZzC, iZzC2, iZzC3, iZzC4, iZzC5, iZzC6, zzegVar.zzC());
    }

    @Override // com.google.android.gms.internal.ads.zzaev
    public final int zza() {
        return AviExtractor.FOURCC_strh;
    }

    public final int zzc() {
        int i = this.zza;
        if (i == 1935960438) {
            return 2;
        }
        if (i == 1935963489) {
            return 1;
        }
        if (i == 1937012852) {
            return 3;
        }
        String hexString = Integer.toHexString(i);
        String.valueOf(hexString);
        zzdt.zzc("AviStreamHeaderChunk", "Found unsupported streamType fourCC: ".concat(String.valueOf(hexString)));
        return -1;
    }

    public final long zzd() {
        return zzep.zzt(this.zzd, ((long) this.zzb) * 1000000, this.zzc, RoundingMode.DOWN);
    }
}
