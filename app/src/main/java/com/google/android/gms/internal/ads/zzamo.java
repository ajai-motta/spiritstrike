package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamo implements zzamq {
    private final zzeg zza;
    private final String zzc;
    private final int zzd;
    private String zzf;
    private zzaem zzg;
    private int zzi;
    private int zzj;
    private long zzk;
    private zzv zzl;
    private int zzm;
    private int zzn;
    private int zzh = 0;
    private long zzq = C.TIME_UNSET;
    private final AtomicInteger zzb = new AtomicInteger();
    private int zzo = -1;
    private int zzp = -1;
    private final String zze = MimeTypes.VIDEO_MP2T;

    public zzamo(String str, int i, int i2, String str2) {
        this.zza = new zzeg(new byte[i2]);
        this.zzc = str;
        this.zzd = i;
    }

    private final boolean zzf(zzeg zzegVar, byte[] bArr, int i) {
        int iMin = Math.min(zzegVar.zzd(), i - this.zzi);
        zzegVar.zzm(bArr, this.zzi, iMin);
        int i2 = this.zzi + iMin;
        this.zzi = i2;
        return i2 == i;
    }

    @RequiresNonNull({"output"})
    private final void zzg(zzacy zzacyVar) {
        int i;
        int i2 = zzacyVar.zzb;
        if (i2 == -2147483647 || (i = zzacyVar.zzc) == -1) {
            return;
        }
        zzv zzvVar = this.zzl;
        if (zzvVar != null && i == zzvVar.zzG && i2 == zzvVar.zzH && Objects.equals(zzacyVar.zza, zzvVar.zzo)) {
            return;
        }
        zzv zzvVar2 = this.zzl;
        zzt zztVar = zzvVar2 == null ? new zzt() : zzvVar2.zza();
        zztVar.zza(this.zzf);
        zztVar.zzl(this.zze);
        zztVar.zzm(zzacyVar.zza);
        zztVar.zzE(i);
        zztVar.zzF(i2);
        zztVar.zze(this.zzc);
        zztVar.zzg(this.zzd);
        zzv zzvVarZzM = zztVar.zzM();
        this.zzl = zzvVarZzM;
        this.zzg.zzu(zzvVarZzM);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zza() {
        this.zzh = 0;
        this.zzi = 0;
        this.zzj = 0;
        this.zzq = C.TIME_UNSET;
        this.zzb.set(0);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzb(zzadd zzaddVar, zzaoe zzaoeVar) {
        zzaoeVar.zza();
        this.zzf = zzaoeVar.zzc();
        this.zzg = zzaddVar.zzu(zzaoeVar.zzb(), 1);
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzc(long j, int i) {
        this.zzq = j;
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zzd(zzeg zzegVar) throws zzat {
        int i;
        int i2;
        byte b;
        int i3;
        this.zzg.getClass();
        while (zzegVar.zzd() > 0) {
            int i4 = this.zzh;
            if (i4 == 0) {
                while (true) {
                    if (zzegVar.zzd() > 0) {
                        int i5 = this.zzj << 8;
                        this.zzj = i5;
                        int iZzs = i5 | zzegVar.zzs();
                        this.zzj = iZzs;
                        int iZza = zzacz.zza(iZzs);
                        this.zzn = iZza;
                        if (iZza != 0) {
                            byte[] bArrZzi = this.zza.zzi();
                            int i6 = this.zzj;
                            bArrZzi[0] = (byte) ((i6 >> 24) & 255);
                            bArrZzi[1] = (byte) ((i6 >> 16) & 255);
                            bArrZzi[2] = (byte) ((i6 >> 8) & 255);
                            bArrZzi[3] = (byte) (i6 & 255);
                            this.zzi = 4;
                            this.zzj = 0;
                            if (iZza == 3 || iZza == 4) {
                                this.zzh = 4;
                            } else if (iZza == 1) {
                                this.zzh = 1;
                            } else {
                                this.zzh = 2;
                            }
                        }
                    }
                }
            } else if (i4 == 1) {
                zzeg zzegVar2 = this.zza;
                if (zzf(zzegVar, zzegVar2.zzi(), 18)) {
                    byte[] bArrZzi2 = zzegVar2.zzi();
                    if (this.zzl == null) {
                        zzv zzvVarZzb = zzacz.zzb(bArrZzi2, this.zzf, this.zzc, this.zzd, this.zze, null);
                        this.zzl = zzvVarZzb;
                        this.zzg.zzu(zzvVarZzb);
                    }
                    this.zzm = zzacz.zzc(bArrZzi2);
                    byte b2 = bArrZzi2[0];
                    if (b2 != -2) {
                        if (b2 == -1) {
                            i2 = (bArrZzi2[4] & 7) << 4;
                            b = bArrZzi2[7];
                        } else if (b2 != 31) {
                            i2 = (bArrZzi2[4] & 1) << 6;
                            i3 = bArrZzi2[5] & 252;
                            i = (i3 >> 2) | i2;
                        } else {
                            i2 = (7 & bArrZzi2[5]) << 4;
                            b = bArrZzi2[6];
                        }
                        i3 = b & 60;
                        i = (i3 >> 2) | i2;
                    } else {
                        i = ((bArrZzi2[4] & 252) >> 2) | ((bArrZzi2[5] & 1) << 6);
                    }
                    this.zzk = zzgst.zza(zzep.zzr((i + 1) * 32, this.zzl.zzH));
                    zzegVar2.zzh(0);
                    this.zzg.zzz(zzegVar2, 18);
                    this.zzh = 6;
                }
            } else if (i4 != 2) {
                if (i4 == 3) {
                    zzeg zzegVar3 = this.zza;
                    if (zzf(zzegVar, zzegVar3.zzi(), this.zzo)) {
                        zzacy zzacyVarZzd = zzacz.zzd(zzegVar3.zzi());
                        zzg(zzacyVarZzd);
                        this.zzm = zzacyVarZzd.zzd;
                        long j = zzacyVarZzd.zze;
                        this.zzk = j != C.TIME_UNSET ? j : 0L;
                        zzegVar3.zzh(0);
                        this.zzg.zzz(zzegVar3, this.zzo);
                        this.zzh = 6;
                    }
                } else if (i4 == 4) {
                    zzeg zzegVar4 = this.zza;
                    if (zzf(zzegVar, zzegVar4.zzi(), 6)) {
                        int iZzg = zzacz.zzg(zzegVar4.zzi());
                        this.zzp = iZzg;
                        int i7 = this.zzi;
                        if (i7 > iZzg) {
                            int i8 = i7 - iZzg;
                            this.zzi = i7 - i8;
                            zzegVar.zzh(zzegVar.zzg() - i8);
                        }
                        this.zzh = 5;
                    }
                } else if (i4 != 5) {
                    int iMin = Math.min(zzegVar.zzd(), this.zzm - this.zzi);
                    this.zzg.zzz(zzegVar, iMin);
                    int i9 = this.zzi + iMin;
                    this.zzi = i9;
                    if (i9 == this.zzm) {
                        zzgmd.zzh(this.zzq != C.TIME_UNSET);
                        this.zzg.zzx(this.zzq, this.zzn == 4 ? 0 : 1, this.zzm, 0, null);
                        this.zzq += this.zzk;
                        this.zzh = 0;
                    }
                } else {
                    zzeg zzegVar5 = this.zza;
                    if (zzf(zzegVar, zzegVar5.zzi(), this.zzp)) {
                        zzacy zzacyVarZzf = zzacz.zzf(zzegVar5.zzi(), this.zzb);
                        if (this.zzn == 3) {
                            zzg(zzacyVarZzf);
                        }
                        this.zzm = zzacyVarZzf.zzd;
                        long j2 = zzacyVarZzf.zze;
                        this.zzk = j2 != C.TIME_UNSET ? j2 : 0L;
                        zzegVar5.zzh(0);
                        this.zzg.zzz(zzegVar5, this.zzp);
                        this.zzh = 6;
                    }
                }
            } else {
                zzeg zzegVar6 = this.zza;
                if (zzf(zzegVar, zzegVar6.zzi(), 7)) {
                    this.zzo = zzacz.zze(zzegVar6.zzi());
                    this.zzh = 3;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamq
    public final void zze(boolean z) {
    }
}
