package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzafm extends zzafr {
    private static final int[] zzb = {5512, 11025, 22050, 44100};
    private boolean zzc;
    private boolean zzd;
    private int zze;

    public zzafm(zzaem zzaemVar) {
        super(zzaemVar);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zza(zzeg zzegVar) throws zzafq {
        if (this.zzc) {
            zzegVar.zzk(1);
        } else {
            int iZzs = zzegVar.zzs();
            int i = iZzs >> 4;
            this.zze = i;
            if (i == 2) {
                int i2 = zzb[(iZzs >> 2) & 3];
                zzt zztVar = new zzt();
                zztVar.zzl(MimeTypes.VIDEO_FLV);
                zztVar.zzm(MimeTypes.AUDIO_MPEG);
                zztVar.zzE(1);
                zztVar.zzF(i2);
                this.zza.zzu(zztVar.zzM());
                this.zzd = true;
            } else if (i == 7 || i == 8) {
                zzt zztVar2 = new zzt();
                zztVar2.zzl(MimeTypes.VIDEO_FLV);
                zztVar2.zzm(i == 7 ? MimeTypes.AUDIO_ALAW : MimeTypes.AUDIO_MLAW);
                zztVar2.zzE(1);
                zztVar2.zzF(8000);
                this.zza.zzu(zztVar2.zzM());
                this.zzd = true;
            } else if (i != 10) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 28);
                sb.append("Audio format not supported: ");
                sb.append(i);
                throw new zzafq(sb.toString());
            }
            this.zzc = true;
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zzb(zzeg zzegVar, long j) throws zzat {
        if (this.zze == 2) {
            int iZzd = zzegVar.zzd();
            zzaem zzaemVar = this.zza;
            zzaemVar.zzz(zzegVar, iZzd);
            zzaemVar.zzx(j, 1, iZzd, 0, null);
            return true;
        }
        int iZzs = zzegVar.zzs();
        if (iZzs != 0 || this.zzd) {
            if (this.zze == 10 && iZzs != 1) {
                return false;
            }
            int iZzd2 = zzegVar.zzd();
            zzaem zzaemVar2 = this.zza;
            zzaemVar2.zzz(zzegVar, iZzd2);
            zzaemVar2.zzx(j, 1, iZzd2, 0, null);
            return true;
        }
        int iZzd3 = zzegVar.zzd();
        byte[] bArr = new byte[iZzd3];
        zzegVar.zzm(bArr, 0, iZzd3);
        zzaby zzabyVarZza = zzabz.zza(bArr);
        zzt zztVar = new zzt();
        zztVar.zzl(MimeTypes.VIDEO_FLV);
        zztVar.zzm(MimeTypes.AUDIO_AAC);
        zztVar.zzj(zzabyVarZza.zzc);
        zztVar.zzE(zzabyVarZza.zzb);
        zztVar.zzF(zzabyVarZza.zza);
        zztVar.zzp(Collections.singletonList(bArr));
        this.zza.zzu(zztVar.zzM());
        this.zzd = true;
        return false;
    }
}
