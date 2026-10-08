package com.google.android.gms.internal.ads;

import androidx.core.view.ViewCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzand implements zzamq {
    private String zzf;
    private zzaem zzg;
    private boolean zzj;
    private int zzl;
    private int zzm;
    private int zzo;
    private int zzp;
    private int zzt;
    private boolean zzv;
    private final String zza = MimeTypes.VIDEO_MP2T;
    private int zze = 0;
    private final zzeg zzb = new zzeg(new byte[15], 2);
    private final zzef zzc = new zzef();
    private final zzeg zzd = new zzeg();
    private final zzane zzq = new zzane();
    private int zzr = C.RATE_UNSET_INT;
    private int zzs = -1;
    private long zzu = -1;
    private boolean zzk = true;
    private boolean zzn = true;
    private double zzh = -9.223372036854776E18d;
    private double zzi = -9.223372036854776E18d;

    public zzand(String str) {
    }

    private static final void zzf(zzeg zzegVar, zzeg zzegVar2, boolean z) {
        int iZzg = zzegVar.zzg();
        int iMin = Math.min(zzegVar.zzd(), zzegVar2.zzd());
        zzegVar.zzm(zzegVar2.zzi(), zzegVar2.zzg(), iMin);
        zzegVar2.zzk(iMin);
        if (z) {
            zzegVar.zzh(iZzg);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zze = 0;
        this.zzm = 0;
        this.zzb.zza(2);
        this.zzo = 0;
        this.zzp = 0;
        this.zzr = C.RATE_UNSET_INT;
        this.zzs = -1;
        this.zzt = 0;
        this.zzu = -1L;
        this.zzv = false;
        this.zzj = false;
        this.zzn = true;
        this.zzk = true;
        this.zzh = -9.223372036854776E18d;
        this.zzi = -9.223372036854776E18d;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzl = i;
        if (!this.zzk && (this.zzp != 0 || !this.zzn)) {
            this.zzj = true;
        }
        if (j != C.TIME_UNSET) {
            double d = j;
            if (this.zzj) {
                this.zzi = d;
            } else {
                this.zzh = d;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) throws zzat {
        int i;
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i2 = this.zze;
            int iZzj = 0;
            if (i2 == 0) {
                int i3 = this.zzl;
                if ((i3 & 2) != 0) {
                    if ((i3 & 4) == 0) {
                        while (zzegVar.zzd() > 0) {
                            int i4 = this.zzm << 8;
                            this.zzm = i4;
                            int iZzs = i4 | zzegVar.zzs();
                            this.zzm = iZzs;
                            if ((iZzs & ViewCompat.MEASURED_SIZE_MASK) == 12583333) {
                                zzegVar.zzh(zzegVar.zzg() - 3);
                                this.zzm = 0;
                            }
                        }
                    }
                    this.zze = 1;
                    break;
                }
                zzegVar.zzh(zzegVar.zze());
            } else if (i2 != 1) {
                zzane zzaneVar = this.zzq;
                int i5 = zzaneVar.zza;
                if (i5 == 1 || i5 == 17) {
                    zzf(zzegVar, this.zzd, true);
                }
                int iMin = Math.min(zzegVar.zzd(), zzaneVar.zzc - this.zzo);
                this.zzg.zzz(zzegVar, iMin);
                int i6 = this.zzo + iMin;
                this.zzo = i6;
                if (i6 == zzaneVar.zzc) {
                    int i7 = zzaneVar.zza;
                    if (i7 == 1) {
                        byte[] bArrZzi = this.zzd.zzi();
                        zzanf zzanfVarZzb = zzang.zzb(new zzef(bArrZzi, bArrZzi.length));
                        this.zzr = zzanfVarZzb.zzb;
                        this.zzs = zzanfVarZzb.zzc;
                        long j = this.zzu;
                        long j2 = zzaneVar.zzb;
                        if (j != j2) {
                            this.zzu = j2;
                            int i8 = zzanfVarZzb.zza;
                            String strConcat = "mhm1";
                            if (i8 != -1) {
                                String str = String.format(".%02X", Integer.valueOf(i8));
                                String.valueOf(str);
                                strConcat = "mhm1".concat(String.valueOf(str));
                            }
                            byte[] bArr = zzanfVarZzb.zzd;
                            zzgpe zzgpeVarZzk = null;
                            if (bArr != null && bArr.length > 0) {
                                zzgpeVarZzk = zzgpe.zzk(zzep.zzb, bArr);
                            }
                            zzt zztVar = new zzt();
                            zztVar.zza(this.zzf);
                            zztVar.zzl(this.zza);
                            zztVar.zzm(MimeTypes.AUDIO_MPEGH_MHM1);
                            zztVar.zzF(this.zzr);
                            zztVar.zzj(strConcat);
                            zztVar.zzp(zzgpeVarZzk);
                            this.zzg.zzu(zztVar.zzM());
                        }
                        this.zzv = true;
                    } else if (i7 == 17) {
                        byte[] bArrZzi2 = this.zzd.zzi();
                        zzef zzefVar = new zzef(bArrZzi2, bArrZzi2.length);
                        if (zzefVar.zzi()) {
                            zzefVar.zzh(2);
                            iZzj = zzefVar.zzj(13);
                        }
                        this.zzt = iZzj;
                    } else if (i7 == 2) {
                        if (this.zzv) {
                            this.zzk = false;
                            i = 1;
                        } else {
                            i = 0;
                        }
                        int i9 = this.zzs - this.zzt;
                        double d = this.zzr;
                        long jRound = Math.round(this.zzh);
                        if (this.zzj) {
                            this.zzj = false;
                            this.zzh = this.zzi;
                        } else {
                            this.zzh += (((double) i9) * 1000000.0d) / d;
                        }
                        this.zzg.zzx(jRound, i, this.zzp, 0, null);
                        this.zzv = false;
                        this.zzt = 0;
                        this.zzp = 0;
                    }
                    this.zze = 1;
                }
            } else {
                zzeg zzegVar2 = this.zzb;
                zzf(zzegVar, zzegVar2, false);
                if (zzegVar2.zzd() == 0) {
                    zzef zzefVar2 = this.zzc;
                    int iZze = zzegVar2.zze();
                    zzefVar2.zzb(zzegVar2.zzi(), iZze);
                    zzane zzaneVar2 = this.zzq;
                    if (zzang.zza(zzefVar2, zzaneVar2)) {
                        this.zzo = 0;
                        this.zzp += zzaneVar2.zzc + iZze;
                        zzegVar2.zzh(0);
                        this.zzg.zzz(zzegVar2, zzegVar2.zze());
                        zzegVar2.zza(2);
                        this.zzd.zza(zzaneVar2.zzc);
                        this.zzn = true;
                        this.zze = 2;
                    } else if (zzegVar2.zze() < 15) {
                        zzegVar2.zzf(zzegVar2.zze() + 1);
                    }
                }
                this.zzn = false;
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
