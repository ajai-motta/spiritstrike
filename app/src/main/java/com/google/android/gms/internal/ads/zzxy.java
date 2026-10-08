package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzlp;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzxy extends zzya implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    public zzxy(int i, zzbg zzbgVar, int i2, zzxt zzxtVar, int i3, String str, String str2) {
        int iZzj;
        int i4;
        boolean z;
        super(i, zzbgVar, i2);
        int i5 = 0;
        this.zzf = zzlp.CC.zzaa(i3, false);
        int i6 = this.zzd.zze;
        int i7 = zzxtVar.zzC;
        this.zzg = 1 == (i6 & 1);
        this.zzh = (i6 & 2) != 0;
        zzgpe zzgpeVarZzj = str2 != null ? zzgpe.zzj(str2) : zzxtVar.zzy.isEmpty() ? zzgpe.zzj("") : zzxtVar.zzy;
        int i8 = 0;
        while (true) {
            if (i8 >= zzgpeVarZzj.size()) {
                iZzj = 0;
                i8 = Integer.MAX_VALUE;
                break;
            }
            zzv zzvVar = this.zzd;
            String str3 = (String) zzgpeVarZzj.get(i8);
            boolean z2 = zzxtVar.zzD;
            iZzj = zzyi.zzj(zzvVar, str3, false);
            if (iZzj > 0) {
                break;
            } else {
                i8++;
            }
        }
        this.zzi = i8;
        this.zzj = iZzj;
        if (str2 != null) {
            i4 = 1088;
        } else {
            int i9 = zzxtVar.zzA;
            i4 = 0;
        }
        int iZzm = zzyi.zzm(this.zzd.zzf, i4);
        this.zzk = iZzm;
        zzv zzvVar2 = this.zzd;
        this.zzn = (1088 & zzvVar2.zzf) != 0;
        int iZzn = zzyi.zzn(zzvVar2, zzxtVar.zzz);
        this.zzl = iZzn;
        int iZzj2 = zzyi.zzj(this.zzd, str, zzyi.zzi(str) == null);
        this.zzm = iZzj2;
        if (iZzj > 0 || ((zzxtVar.zzy.isEmpty() && iZzm > 0) || ((zzxtVar.zzy.isEmpty() && iZzn != Integer.MAX_VALUE) || this.zzg || (this.zzh && iZzj2 > 0)))) {
            z = true;
        } else {
            boolean z3 = zzxtVar.zzx;
            z = false;
        }
        if (zzlp.CC.zzaa(i3, zzxtVar.zzV) && z) {
            i5 = 1;
        }
        this.zze = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zze;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxy zzxyVar) {
        zzgot zzgotVarZza = zzgot.zzg().zzd(this.zzf, zzxyVar.zzf).zza(Integer.valueOf(this.zzi), Integer.valueOf(zzxyVar.zzi), zzgqy.zzb().zza());
        int i = this.zzj;
        zzgot zzgotVarZzb = zzgotVarZza.zzb(i, zzxyVar.zzj);
        int i2 = this.zzk;
        zzgot zzgotVarZzb2 = zzgotVarZzb.zzb(i2, zzxyVar.zzk).zza(Integer.valueOf(this.zzl), Integer.valueOf(zzxyVar.zzl), zzgqy.zzb().zza()).zzd(this.zzg, zzxyVar.zzg).zza(Boolean.valueOf(this.zzh), Boolean.valueOf(zzxyVar.zzh), i == 0 ? zzgqy.zzb() : zzgqy.zzb().zza()).zzb(this.zzm, zzxyVar.zzm);
        if (i2 == 0) {
            zzgotVarZzb2 = zzgotVarZzb2.zzc(this.zzn, zzxyVar.zzn);
        }
        return zzgotVarZzb2.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        return false;
    }
}
