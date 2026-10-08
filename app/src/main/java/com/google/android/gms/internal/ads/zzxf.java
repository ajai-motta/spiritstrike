package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzxf extends zzya implements Comparable {
    private final int zze;
    private final boolean zzf;
    private final String zzg;
    private final zzxt zzh;
    private final boolean zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;
    private final int zzo;
    private final int zzp;
    private final boolean zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final boolean zzv;
    private final boolean zzw;
    private final boolean zzx;

    /* JADX WARN: Removed duplicated region for block: B:27:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00b5 A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public zzxf(int r8, com.google.android.gms.internal.ads.zzbg r9, int r10, com.google.android.gms.internal.ads.zzxt r11, int r12, boolean r13, com.google.android.gms.internal.ads.zzgme r14, int r15) {
        /*
            Method dump skipped, instruction units count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxf.<init>(int, com.google.android.gms.internal.ads.zzbg, int, com.google.android.gms.internal.ads.zzxt, int, boolean, com.google.android.gms.internal.ads.zzgme, int):void");
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final int zza() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzya
    public final /* bridge */ /* synthetic */ boolean zzc(zzya zzyaVar) {
        String str;
        zzxt zzxtVar = this.zzh;
        zzxf zzxfVar = (zzxf) zzyaVar;
        boolean z = zzxtVar.zzR;
        zzv zzvVar = this.zzd;
        int i = zzvVar.zzG;
        if (i == -1) {
            return false;
        }
        zzv zzvVar2 = zzxfVar.zzd;
        if (i != zzvVar2.zzG || (str = zzvVar.zzo) == null || !TextUtils.equals(str, zzvVar2.zzo)) {
            return false;
        }
        boolean z2 = zzxtVar.zzQ;
        int i2 = zzvVar.zzH;
        if (i2 == -1 || i2 != zzvVar2.zzH) {
            return false;
        }
        boolean z3 = zzxtVar.zzS;
        return this.zzv == zzxfVar.zzv && this.zzw == zzxfVar.zzw;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final int compareTo(zzxf zzxfVar) {
        boolean z = this.zzf;
        zzgqy zzgqyVarZza = (z && this.zzi) ? zzyi.zzc : zzyi.zzc.zza();
        zzgot zzgotVarZza = zzgot.zzg().zzd(this.zzi, zzxfVar.zzi).zza(Integer.valueOf(this.zzk), Integer.valueOf(zzxfVar.zzk), zzgqy.zzb().zza()).zzb(this.zzj, zzxfVar.zzj).zzb(this.zzl, zzxfVar.zzl).zza(Integer.valueOf(this.zzm), Integer.valueOf(zzxfVar.zzm), zzgqy.zzb().zza()).zzd(this.zzq, zzxfVar.zzq).zzd(this.zzn, zzxfVar.zzn).zza(Integer.valueOf(this.zzo), Integer.valueOf(zzxfVar.zzo), zzgqy.zzb().zza()).zzb(this.zzp, zzxfVar.zzp).zzd(z, zzxfVar.zzf).zza(Integer.valueOf(this.zzu), Integer.valueOf(zzxfVar.zzu), zzgqy.zzb().zza());
        boolean z2 = this.zzh.zzF;
        zzgot zzgotVarZza2 = zzgotVarZza.zzd(this.zzv, zzxfVar.zzv).zzd(this.zzw, zzxfVar.zzw).zzd(this.zzx, zzxfVar.zzx).zza(Integer.valueOf(this.zzr), Integer.valueOf(zzxfVar.zzr), zzgqyVarZza).zza(Integer.valueOf(this.zzs), Integer.valueOf(zzxfVar.zzs), zzgqyVarZza);
        if (Objects.equals(this.zzg, zzxfVar.zzg)) {
            zzgotVarZza2 = zzgotVarZza2.zza(Integer.valueOf(this.zzt), Integer.valueOf(zzxfVar.zzt), zzgqyVarZza);
        }
        return zzgotVarZza2.zze();
    }
}
