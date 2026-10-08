package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzanc implements zzamq {
    private final zzeg zza;
    private final zzadw zzb;
    private final String zzc;
    private final int zzd;
    private final String zze;
    private zzaem zzf;
    private String zzg;
    private int zzh = 0;
    private int zzi;
    private boolean zzj;
    private boolean zzk;
    private long zzl;
    private int zzm;
    private long zzn;

    public zzanc(String str, int i, String str2) {
        zzeg zzegVar = new zzeg(4);
        this.zza = zzegVar;
        zzegVar.zzi()[0] = -1;
        this.zzb = new zzadw();
        this.zzn = C.TIME_UNSET;
        this.zzc = str;
        this.zzd = i;
        this.zze = str2;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzk = false;
        this.zzn = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzg = zzaoeVar.zzc();
        this.zzf = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzn = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) {
        this.zzf.getClass();
        while (zzegVar.zzd() > 0) {
            int i = this.zzh;
            if (i == 0) {
                byte[] bArrZzi = zzegVar.zzi();
                int iZzg = zzegVar.zzg();
                int iZze = zzegVar.zze();
                while (true) {
                    if (iZzg >= iZze) {
                        zzegVar.zzh(iZze);
                        break;
                    }
                    int i2 = iZzg + 1;
                    byte b = bArrZzi[iZzg];
                    boolean z = (b & 255) == 255;
                    boolean z2 = this.zzk && (b & 224) == 224;
                    this.zzk = z;
                    if (z2) {
                        zzegVar.zzh(i2);
                        this.zzk = false;
                        this.zza.zzi()[1] = bArrZzi[iZzg];
                        this.zzi = 2;
                        this.zzh = 1;
                        break;
                    }
                    iZzg = i2;
                }
            } else if (i != 1) {
                int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                this.zzf.zzz(zzegVar, iMin);
                int i3 = this.zzi + iMin;
                this.zzi = i3;
                if (i3 >= this.zzm) {
                    zzgmd.zzh(this.zzn != C.TIME_UNSET);
                    this.zzf.zzx(this.zzn, 1, this.zzm, 0, null);
                    this.zzn += this.zzl;
                    this.zzi = 0;
                    this.zzh = 0;
                }
            } else {
                int iMin2 = Math.min(zzegVar.zzd(), 4 - this.zzi);
                zzeg zzegVar2 = this.zza;
                zzegVar.zzm(zzegVar2.zzi(), this.zzi, iMin2);
                int i4 = this.zzi + iMin2;
                this.zzi = i4;
                if (i4 >= 4) {
                    zzegVar2.zzh(0);
                    zzadw zzadwVar = this.zzb;
                    if (zzadwVar.zza(zzegVar2.zzB())) {
                        this.zzm = zzadwVar.zzc;
                        if (!this.zzj) {
                            this.zzl = (((long) zzadwVar.zzg) * 1000000) / ((long) zzadwVar.zzd);
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzg);
                            zztVar.zzl(this.zze);
                            zztVar.zzm(zzadwVar.zzb);
                            zztVar.zzn(4096);
                            zztVar.zzE(zzadwVar.zze);
                            zztVar.zzF(zzadwVar.zzd);
                            zztVar.zze(this.zzc);
                            zztVar.zzg(this.zzd);
                            this.zzf.zzu(zztVar.zzM());
                            this.zzj = true;
                        }
                        zzegVar2.zzh(0);
                        this.zzf.zzz(zzegVar2, 4);
                        this.zzh = 2;
                    } else {
                        this.zzi = 0;
                        this.zzh = 1;
                    }
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
