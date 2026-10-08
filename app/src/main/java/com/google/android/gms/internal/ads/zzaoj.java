package com.google.android.gms.internal.ads;

import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaoj implements zzaok {
    private static final int[] zza = {-1, -1, -1, -1, 2, 4, 6, 8, -1, -1, -1, -1, 2, 4, 6, 8};
    private static final int[] zzb = {7, 8, 9, 10, 11, 12, 13, 14, 16, 17, 19, 21, 23, 25, 28, 31, 34, 37, 41, 45, 50, 55, 60, 66, 73, 80, 88, 97, 107, 118, TsExtractor.TS_STREAM_TYPE_HDMV_DTS, 143, 157, TTAdConstant.IMAGE_MODE_VERTICAL_IMG_173, FacebookRequestErrorClassification.EC_INVALID_TOKEN, 209, 230, 253, 279, 307, 337, 371, TTAdConstant.DOWNLOAD_URL_CODE, 449, 494, 544, 598, 658, 724, 796, 876, 963, 1060, 1166, 1282, 1411, 1552, 1707, 1878, 2066, 2272, 2499, 2749, 3024, 3327, 3660, 4026, 4428, 4871, 5358, 5894, 6484, 7132, 7845, 8630, 9493, 10442, 11487, 12635, 13899, 15289, 16818, 18500, 20350, 22385, 24623, 27086, 29794, 32767};
    private final zzadd zzc;
    private final zzaem zzd;
    private final zzaoo zze;
    private final int zzf;
    private final byte[] zzg;
    private final zzeg zzh;
    private final int zzi;
    private final zzv zzj;
    private int zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzaoj(zzadd zzaddVar, zzaem zzaemVar, zzaoo zzaooVar) throws zzat {
        this.zzc = zzaddVar;
        this.zzd = zzaemVar;
        this.zze = zzaooVar;
        int iMax = Math.max(1, zzaooVar.zzc / 10);
        this.zzi = iMax;
        zzeg zzegVar = new zzeg(zzaooVar.zzf);
        zzegVar.zzu();
        int iZzu = zzegVar.zzu();
        this.zzf = iZzu;
        int i = zzaooVar.zzb;
        int i2 = (((zzaooVar.zzd - (i * 4)) * 8) / (zzaooVar.zze * i)) + 1;
        if (iZzu != i2) {
            StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 34 + String.valueOf(iZzu).length());
            sb.append("Expected frames per block: ");
            sb.append(i2);
            sb.append("; got: ");
            sb.append(iZzu);
            throw zzat.zzb(sb.toString(), null);
        }
        String str = zzep.zza;
        int i3 = ((iMax + iZzu) - 1) / iZzu;
        this.zzg = new byte[zzaooVar.zzd * i3];
        this.zzh = new zzeg(i3 * (iZzu + iZzu) * i);
        int i4 = ((zzaooVar.zzc * zzaooVar.zzd) * 8) / iZzu;
        zzt zztVar = new zzt();
        zztVar.zzm(MimeTypes.AUDIO_RAW);
        zztVar.zzh(i4);
        zztVar.zzi(i4);
        zztVar.zzn((iMax + iMax) * i);
        zztVar.zzE(zzaooVar.zzb);
        zztVar.zzF(zzaooVar.zzc);
        zztVar.zzG(2);
        this.zzj = zztVar.zzM();
    }

    private final void zzd(int i) {
        long jZzt = this.zzl + zzep.zzt(this.zzn, 1000000L, this.zze.zzc, RoundingMode.DOWN);
        int iZzf = zzf(i);
        this.zzd.zzx(jZzt, 1, iZzf, this.zzm - iZzf, null);
        this.zzn += (long) i;
        this.zzm -= iZzf;
    }

    private final int zze(int i) {
        int i2 = this.zze.zzb;
        return i / (i2 + i2);
    }

    private final int zzf(int i) {
        return (i + i) * this.zze.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zza(long j) {
        this.zzk = 0;
        this.zzl = j;
        this.zzm = 0;
        this.zzn = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zzb(int i, long j) {
        this.zzc.zzw(new zzaor(this.zze, this.zzf, i, j));
        this.zzd.zzu(this.zzj);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0026  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:10:0x003c -> B:4:0x0021). Please report as a decompilation issue!!! */
    @Override // com.google.android.gms.internal.ads.zzaok
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzc(com.google.android.gms.internal.ads.zzadb r26, long r27) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 349
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoj.zzc(com.google.android.gms.internal.ads.zzadb, long):boolean");
    }
}
