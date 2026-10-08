package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.common.primitives.SignedBytes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamj implements zzamq {
    private final zzef zza;
    private final zzeg zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private String zzf;
    private zzaem zzg;
    private int zzh;
    private int zzi;
    private boolean zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private long zzn;

    public zzamj(String str, int i, String str2) {
        zzef zzefVar = new zzef(new byte[16], 16);
        this.zza = zzefVar;
        this.zzb = new zzeg(zzefVar.zza);
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = false;
        this.zzn = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i = this.zzh;
            if (i == 0) {
                while (zzegVar.zzd() > 0) {
                    if (this.zzj) {
                        int iZzs = zzegVar.zzs();
                        this.zzj = iZzs == 172;
                        byte b = SignedBytes.MAX_POWER_OF_TWO;
                        if (iZzs != 64) {
                            if (iZzs == 65) {
                                iZzs = 65;
                            }
                        }
                        this.zzh = 1;
                        zzeg zzegVar2 = this.zzb;
                        zzegVar2.zzi()[0] = -84;
                        if (iZzs == 65) {
                            b = 65;
                        }
                        zzegVar2.zzi()[1] = b;
                        this.zzi = 2;
                    } else {
                        this.zzj = zzegVar.zzs() == 172;
                    }
                }
            } else if (i != 1) {
                int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                this.zzg.zzz(zzegVar, iMin);
                int i2 = this.zzi + iMin;
                this.zzi = i2;
                if (i2 == this.zzm) {
                    zzgmd.zzh(this.zzn != C.TIME_UNSET);
                    this.zzg.zzx(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzk;
                    this.zzh = 0;
                }
            } else {
                zzeg zzegVar3 = this.zzb;
                byte[] bArrZzi = zzegVar3.zzi();
                int iMin2 = Math.min(zzegVar.zzd(), 16 - this.zzi);
                zzegVar.zzm(bArrZzi, this.zzi, iMin2);
                int i3 = this.zzi + iMin2;
                this.zzi = i3;
                if (i3 == 16) {
                    zzef zzefVar = this.zza;
                    zzefVar.zzf(0);
                    zzacd zzacdVarZzb = zzace.zzb(zzefVar);
                    zzv zzvVar = this.zzl;
                    if (zzvVar == null || zzvVar.zzG != 2 || zzacdVarZzb.zza != zzvVar.zzH || !MimeTypes.AUDIO_AC4.equals(zzvVar.zzo)) {
                        zzt zztVar = new zzt();
                        zztVar.zza(this.zzf);
                        zztVar.zzl(this.zze);
                        zztVar.zzm(MimeTypes.AUDIO_AC4);
                        zztVar.zzE(2);
                        zztVar.zzF(zzacdVarZzb.zza);
                        zztVar.zze(this.zzc);
                        zztVar.zzg(this.zzd);
                        zzv zzvVarZzM = zztVar.zzM();
                        this.zzl = zzvVarZzM;
                        this.zzg.zzu(zzvVarZzM);
                    }
                    this.zzm = zzacdVarZzb.zzb;
                    this.zzk = (((long) zzacdVarZzb.zzc) * 1000000) / ((long) this.zzl.zzH);
                    zzegVar3.zzh(0);
                    this.zzg.zzz(zzegVar3, 16);
                    this.zzh = 2;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
