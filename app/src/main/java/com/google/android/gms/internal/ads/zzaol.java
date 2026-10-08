package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.math.RoundingMode;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaol implements zzaok {
    private final zzadd zza;
    private final zzaem zzb;
    private final zzaoo zzc;
    private final zzv zzd;
    private final int zze;
    private long zzf;
    private int zzg;
    private long zzh;

    public zzaol(zzadd zzaddVar, zzaem zzaemVar, zzaoo zzaooVar, String str, int i) throws zzat {
        this.zza = zzaddVar;
        this.zzb = zzaemVar;
        this.zzc = zzaooVar;
        int i2 = zzaooVar.zzb * zzaooVar.zze;
        int i3 = zzaooVar.zzd;
        int i4 = i2 / 8;
        if (i3 != i4) {
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 28 + String.valueOf(i3).length());
            sb.append("Expected block size: ");
            sb.append(i4);
            sb.append("; got: ");
            sb.append(i3);
            throw zzat.zzb(sb.toString(), null);
        }
        int i5 = zzaooVar.zzc * i4;
        int i6 = i5 * 8;
        int iMax = Math.max(i4, i5 / 10);
        this.zze = iMax;
        zzt zztVar = new zzt();
        zztVar.zzl(MimeTypes.AUDIO_WAV);
        zztVar.zzm(str);
        zztVar.zzh(i6);
        zztVar.zzi(i6);
        zztVar.zzn(iMax);
        zztVar.zzE(zzaooVar.zzb);
        zztVar.zzF(zzaooVar.zzc);
        zztVar.zzG(i);
        this.zzd = zztVar.zzM();
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zza(long j) {
        this.zzf = j;
        this.zzg = 0;
        this.zzh = 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final void zzb(int i, long j) {
        this.zza.zzw(new zzaor(this.zzc, 1, i, j));
        this.zzb.zzu(this.zzd);
    }

    @Override // com.google.android.gms.internal.ads.zzaok
    public final boolean zzc(zzadb zzadbVar, long j) throws IOException {
        int i;
        int i2;
        long j2 = j;
        while (j2 > 0 && (i = this.zzg) < (i2 = this.zze)) {
            int iZzy = this.zzb.zzy(zzadbVar, (int) Math.min(i2 - i, j2), true);
            if (iZzy == -1) {
                j2 = 0;
            } else {
                this.zzg += iZzy;
                j2 -= (long) iZzy;
            }
        }
        zzaoo zzaooVar = this.zzc;
        int i3 = this.zzg;
        int i4 = zzaooVar.zzd;
        int i5 = i3 / i4;
        if (i5 > 0) {
            long jZzt = this.zzf + zzep.zzt(this.zzh, 1000000L, zzaooVar.zzc, RoundingMode.DOWN);
            int i6 = i5 * i4;
            int i7 = this.zzg - i6;
            this.zzb.zzx(jZzt, 1, i6, i7, null);
            this.zzh += (long) i5;
            this.zzg = i7;
        }
        return j2 <= 0;
    }
}
