package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzafs extends zzafr {
    private final zzeg zzb;
    private final zzeg zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private int zzg;

    public zzafs(zzaem zzaemVar) {
        super(zzaemVar);
        this.zzb = new zzeg(zzfm.zza);
        this.zzc = new zzeg(4);
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zza(zzeg zzegVar) throws zzafq {
        int iZzs = zzegVar.zzs();
        int i = iZzs >> 4;
        int i2 = iZzs & 15;
        if (i2 == 7) {
            this.zzg = i;
            return i != 5;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 28);
        sb.append("Video format not supported: ");
        sb.append(i2);
        throw new zzafq(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzafr
    protected final boolean zzb(zzeg zzegVar, long j) throws zzat {
        int i;
        int iZzs = zzegVar.zzs();
        long jZzy = zzegVar.zzy();
        if (iZzs == 0) {
            if (!this.zze) {
                zzeg zzegVar2 = new zzeg(new byte[zzegVar.zzd()]);
                zzegVar.zzm(zzegVar2.zzi(), 0, zzegVar.zzd());
                zzacf zzacfVarZza = zzacf.zza(zzegVar2);
                this.zzd = zzacfVarZza.zzb;
                zzt zztVar = new zzt();
                zztVar.zzl(MimeTypes.VIDEO_FLV);
                zztVar.zzm("video/avc");
                zztVar.zzj(zzacfVarZza.zzl);
                zztVar.zzt(zzacfVarZza.zzc);
                zztVar.zzu(zzacfVarZza.zzd);
                zztVar.zzz(zzacfVarZza.zzk);
                zztVar.zzp(zzacfVarZza.zza);
                this.zza.zzu(zztVar.zzM());
                this.zze = true;
                return false;
            }
        } else if (iZzs == 1 && this.zze) {
            int i2 = this.zzg == 1 ? 1 : 0;
            if (this.zzf) {
                i = i2;
            } else if (i2 != 0) {
                i = 1;
            }
            zzeg zzegVar3 = this.zzc;
            byte[] bArrZzi = zzegVar3.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 0;
            bArrZzi[2] = 0;
            int i3 = 4 - this.zzd;
            int i4 = 0;
            while (zzegVar.zzd() > 0) {
                zzegVar.zzm(zzegVar3.zzi(), i3, this.zzd);
                zzegVar3.zzh(0);
                zzeg zzegVar4 = this.zzb;
                int iZzH = zzegVar3.zzH();
                zzegVar4.zzh(0);
                zzaem zzaemVar = this.zza;
                zzaemVar.zzz(zzegVar4, 4);
                zzaemVar.zzz(zzegVar, iZzH);
                i4 = i4 + 4 + iZzH;
            }
            this.zza.zzx(j + (jZzy * 1000), i, i4, 0, null);
            this.zzf = true;
            return true;
        }
        return false;
    }
}
