package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.avi.AviExtractor;
import com.google.android.gms.internal.ads.zzada;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaey implements zzada {
    private final zzeg zza;
    private final zzaex zzb;
    private final boolean zzc;
    private final zzakg zzd;
    private int zze;
    private zzadd zzf;
    private zzaez zzg;
    private long zzh;
    private zzafb[] zzi;
    private long zzj;
    private zzafb zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private int zzo;
    private boolean zzp;

    @Deprecated
    public zzaey() {
        this(1, zzakg.zza);
    }

    private final zzafb zzh(int i) {
        for (zzafb zzafbVar : this.zzi) {
            if (zzafbVar.zzc(i)) {
                return zzafbVar;
            }
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzeg zzegVar = this.zza;
        zzadbVar.zzi(zzegVar.zzi(), 0, 12);
        zzegVar.zzh(0);
        if (zzegVar.zzC() != 1179011410) {
            return false;
        }
        zzegVar.zzk(4);
        return zzegVar.zzC() == 541677121;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ List zzb() {
        return zzgpe.zzi();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        this.zze = 0;
        if (this.zzc) {
            zzaddVar = new zzakj(zzaddVar, this.zzd);
        }
        this.zzf = zzaddVar;
        this.zzj = -1L;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        this.zzj = -1L;
        this.zzk = null;
        for (zzafb zzafbVar : this.zzi) {
            zzafbVar.zzf(j);
        }
        if (j == 0) {
            this.zze = this.zzi.length != 0 ? 3 : 0;
        } else {
            this.zze = 6;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    final /* synthetic */ zzafb[] zzg() {
        return this.zzi;
    }

    public zzaey(int i, zzakg zzakgVar) {
        this.zzd = zzakgVar;
        this.zzc = 1 == (i ^ 1);
        this.zza = new zzeg(12);
        this.zzb = new zzaex(null);
        this.zzf = new zzady();
        this.zzi = new zzafb[0];
        this.zzm = -1L;
        this.zzn = -1L;
        this.zzl = -1;
        this.zzh = C.TIME_UNSET;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final int zzd(zzadb zzadbVar, zzaea zzaeaVar) throws IOException {
        boolean z;
        long j;
        long j2 = this.zzj;
        if (j2 != -1) {
            long jZzn = zzadbVar.zzn();
            if (j2 < jZzn || j2 > PlaybackStateCompat.ACTION_SET_REPEAT_MODE + jZzn) {
                zzaeaVar.zza = j2;
                z = true;
            } else {
                zzadbVar.zzf((int) (j2 - jZzn));
                z = false;
            }
        } else {
            z = false;
        }
        this.zzj = -1L;
        if (z) {
            return 1;
        }
        int i = this.zze;
        zzafb zzafbVar = null;
        if (i == 0) {
            if (!zza(zzadbVar)) {
                throw zzat.zzb("AVI Header List not found", null);
            }
            zzadbVar.zzf(12);
            this.zze = 1;
            return 0;
        }
        if (i == 1) {
            zzeg zzegVar = this.zza;
            zzadbVar.zzc(zzegVar.zzi(), 0, 12);
            zzegVar.zzh(0);
            zzaex zzaexVar = this.zzb;
            zzaexVar.zza(zzegVar);
            int i2 = zzaexVar.zza;
            if (i2 != 1414744396) {
                StringBuilder sb = new StringBuilder(String.valueOf(i2).length() + 22);
                sb.append("LIST expected, found: ");
                sb.append(i2);
                throw zzat.zzb(sb.toString(), null);
            }
            int iZzC = zzegVar.zzC();
            if (iZzC == 1819436136) {
                this.zzl = zzaexVar.zzb;
                this.zze = 2;
                return 0;
            }
            StringBuilder sb2 = new StringBuilder(String.valueOf(iZzC).length() + 22);
            sb2.append("hdrl expected, found: ");
            sb2.append(iZzC);
            throw zzat.zzb(sb2.toString(), null);
        }
        if (i == 2) {
            int i3 = this.zzl - 4;
            zzeg zzegVar2 = new zzeg(i3);
            zzadbVar.zzc(zzegVar2.zzi(), 0, i3);
            zzafc zzafcVarZzb = zzafc.zzb(AviExtractor.FOURCC_hdrl, zzegVar2);
            if (zzafcVarZzb.zza() != 1819436136) {
                int iZza = zzafcVarZzb.zza();
                StringBuilder sb3 = new StringBuilder(String.valueOf(iZza).length() + 28);
                sb3.append("Unexpected header list type ");
                sb3.append(iZza);
                throw zzat.zzb(sb3.toString(), null);
            }
            zzaez zzaezVar = (zzaez) zzafcVarZzb.zzc(zzaez.class);
            if (zzaezVar == null) {
                throw zzat.zzb("AviHeader not found", null);
            }
            this.zzg = zzaezVar;
            this.zzh = ((long) zzaezVar.zzc) * ((long) zzaezVar.zza);
            ArrayList arrayList = new ArrayList();
            zzgpe zzgpeVar = zzafcVarZzb.zza;
            int size = zzgpeVar.size();
            int i4 = 0;
            int i5 = 0;
            while (i4 < size) {
                zzaev zzaevVar = (zzaev) zzgpeVar.get(i4);
                if (zzaevVar.zza() == 1819440243) {
                    zzafc zzafcVar = (zzafc) zzaevVar;
                    int i6 = i5 + 1;
                    zzafa zzafaVar = (zzafa) zzafcVar.zzc(zzafa.class);
                    zzafd zzafdVar = (zzafd) zzafcVar.zzc(zzafd.class);
                    if (zzafaVar == null) {
                        zzdt.zzc("AviExtractor", "Missing Stream Header");
                    } else if (zzafdVar == null) {
                        zzdt.zzc("AviExtractor", "Missing Stream Format");
                    } else {
                        long jZzd = zzafaVar.zzd();
                        zzv zzvVar = zzafdVar.zza;
                        zzt zztVarZza = zzvVar.zza();
                        zztVarZza.zzb(i5);
                        int i7 = zzafaVar.zze;
                        if (i7 != 0) {
                            zztVarZza.zzn(i7);
                        }
                        zzafe zzafeVar = (zzafe) zzafcVar.zzc(zzafe.class);
                        if (zzafeVar != null) {
                            zztVarZza.zzc(zzafeVar.zza);
                        }
                        int iZzg = zzas.zzg(zzvVar.zzo);
                        if (iZzg == 1) {
                            zzaem zzaemVarZzu = this.zzf.zzu(i5, iZzg);
                            zzaemVarZzu.zzu(zztVarZza.zzM());
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzafbVar = new zzafb(i5, zzafaVar, zzaemVarZzu);
                        } else if (iZzg == 2) {
                            iZzg = 2;
                            zzaem zzaemVarZzu2 = this.zzf.zzu(i5, iZzg);
                            zzaemVarZzu2.zzu(zztVarZza.zzM());
                            this.zzh = Math.max(this.zzh, jZzd);
                            zzafbVar = new zzafb(i5, zzafaVar, zzaemVarZzu2);
                        } else {
                            zzafbVar = null;
                        }
                    }
                    if (zzafbVar != null) {
                        arrayList.add(zzafbVar);
                    }
                    i5 = i6;
                }
                i4++;
                zzafbVar = null;
            }
            this.zzi = (zzafb[]) arrayList.toArray(new zzafb[0]);
            this.zzf.zzv();
            this.zze = 3;
            return 0;
        }
        if (i == 3) {
            long j3 = this.zzm;
            if (j3 != -1 && zzadbVar.zzn() != j3) {
                this.zzj = j3;
                return 0;
            }
            zzeg zzegVar3 = this.zza;
            zzadbVar.zzi(zzegVar3.zzi(), 0, 12);
            zzadbVar.zzl();
            zzegVar3.zzh(0);
            zzaex zzaexVar2 = this.zzb;
            zzaexVar2.zza(zzegVar3);
            int iZzC2 = zzegVar3.zzC();
            int i8 = zzaexVar2.zza;
            if (i8 == 1179011410) {
                zzadbVar.zzf(12);
                return 0;
            }
            if (i8 != 1414744396 || iZzC2 != 1769369453) {
                this.zzj = zzadbVar.zzn() + ((long) zzaexVar2.zzb) + 8;
                return 0;
            }
            long jZzn2 = zzadbVar.zzn();
            this.zzm = jZzn2;
            long j4 = jZzn2 + ((long) zzaexVar2.zzb) + 8;
            this.zzn = j4;
            if (!this.zzp) {
                zzaez zzaezVar2 = this.zzg;
                zzaezVar2.getClass();
                if ((zzaezVar2.zzb & 16) == 16) {
                    this.zze = 4;
                    this.zzj = j4;
                    return 0;
                }
                this.zzf.zzw(new zzaec(this.zzh, 0L));
                this.zzp = true;
            }
            this.zzj = zzadbVar.zzn() + 12;
            this.zze = 6;
            return 0;
        }
        if (i == 4) {
            zzeg zzegVar4 = this.zza;
            zzadbVar.zzc(zzegVar4.zzi(), 0, 8);
            zzegVar4.zzh(0);
            int iZzC3 = zzegVar4.zzC();
            int iZzC4 = zzegVar4.zzC();
            if (iZzC3 == 829973609) {
                this.zze = 5;
                this.zzo = iZzC4;
            } else {
                this.zzj = zzadbVar.zzn() + ((long) iZzC4);
            }
            return 0;
        }
        if (i == 5) {
            zzeg zzegVar5 = new zzeg(this.zzo);
            zzadbVar.zzc(zzegVar5.zzi(), 0, this.zzo);
            if (zzegVar5.zzd() < 16) {
                j = 0;
            } else {
                int iZzg2 = zzegVar5.zzg();
                zzegVar5.zzk(8);
                long jZzC = zzegVar5.zzC();
                long j5 = this.zzm;
                j = jZzC > j5 ? 0L : j5 + 8;
                zzegVar5.zzh(iZzg2);
            }
            while (zzegVar5.zzd() >= 16) {
                int iZzC5 = zzegVar5.zzC();
                int iZzC6 = zzegVar5.zzC();
                long jZzC2 = ((long) zzegVar5.zzC()) + j;
                zzegVar5.zzk(4);
                zzafb zzafbVarZzh = zzh(iZzC5);
                if (zzafbVarZzh != null) {
                    zzafbVarZzh.zza(jZzC2, (iZzC6 & 16) == 16);
                }
            }
            for (zzafb zzafbVar2 : this.zzi) {
                zzafbVar2.zzb();
            }
            this.zzp = true;
            if (this.zzi.length == 0) {
                this.zzf.zzw(new zzaec(this.zzh, 0L));
            } else {
                this.zzf.zzw(new zzaew(this, this.zzh));
            }
            this.zze = 6;
            this.zzj = this.zzm;
            return 0;
        }
        if (zzadbVar.zzn() >= this.zzn) {
            return -1;
        }
        zzafb zzafbVar3 = this.zzk;
        if (zzafbVar3 != null) {
            if (!zzafbVar3.zze(zzadbVar)) {
                return 0;
            }
            this.zzk = null;
            return 0;
        }
        if ((zzadbVar.zzn() & 1) == 1) {
            zzadbVar.zzf(1);
        }
        zzeg zzegVar6 = this.zza;
        zzadbVar.zzi(zzegVar6.zzi(), 0, 12);
        zzegVar6.zzh(0);
        int iZzC7 = zzegVar6.zzC();
        if (iZzC7 == 1414744396) {
            zzegVar6.zzh(8);
            zzadbVar.zzf(zzegVar6.zzC() != 1769369453 ? 8 : 12);
            zzadbVar.zzl();
            return 0;
        }
        int iZzC8 = zzegVar6.zzC();
        if (iZzC7 == 1263424842) {
            this.zzj = zzadbVar.zzn() + ((long) iZzC8) + 8;
            return 0;
        }
        zzadbVar.zzf(8);
        zzadbVar.zzl();
        zzafb zzafbVarZzh2 = zzh(iZzC7);
        if (zzafbVarZzh2 == null) {
            this.zzj = zzadbVar.zzn() + ((long) iZzC8);
            return 0;
        }
        zzafbVarZzh2.zzd(iZzC8);
        this.zzk = zzafbVarZzh2;
        return 0;
    }
}
