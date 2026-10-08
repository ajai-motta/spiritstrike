package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaiq {
    public final zzaem zza;
    public zzaji zzd;
    public zzail zze;
    public int zzf;
    public int zzg;
    public int zzh;
    public int zzi;
    private final zzv zzj;
    private boolean zzm;
    public final zzajh zzb = new zzajh();
    public final zzeg zzc = new zzeg();
    private final zzeg zzk = new zzeg(1);
    private final zzeg zzl = new zzeg();

    public zzaiq(zzaem zzaemVar, zzaji zzajiVar, zzail zzailVar, zzv zzvVar) {
        this.zza = zzaemVar;
        this.zzd = zzajiVar;
        this.zze = zzailVar;
        this.zzj = zzvVar;
        zza(zzajiVar, zzailVar);
    }

    public final void zza(zzaji zzajiVar, zzail zzailVar) {
        this.zzd = zzajiVar;
        this.zze = zzailVar;
        this.zza.zzu(this.zzj);
        zzc();
    }

    public final void zzb(zzq zzqVar) {
        zzajf zzajfVar = this.zzd.zza;
        zzail zzailVar = this.zzb.zza;
        String str = zzep.zza;
        zzajg zzajgVarZza = zzajfVar.zza(zzailVar.zza);
        zzq zzqVarZzb = zzqVar.zzb(zzajgVarZza != null ? zzajgVarZza.zzb : null);
        zzt zztVarZza = this.zzj.zza();
        zztVarZza.zzq(zzqVarZzb);
        this.zza.zzu(zztVarZza.zzM());
    }

    public final void zzc() {
        zzajh zzajhVar = this.zzb;
        zzajhVar.zzd = 0;
        zzajhVar.zzp = 0L;
        zzajhVar.zzq = false;
        zzajhVar.zzk = false;
        zzajhVar.zzo = false;
        zzajhVar.zzm = null;
        this.zzf = 0;
        this.zzh = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzm = false;
    }

    public final long zzd() {
        if (!this.zzm) {
            return this.zzd.zzf[this.zzf];
        }
        zzajh zzajhVar = this.zzb;
        return zzajhVar.zzi[this.zzf];
    }

    public final long zze() {
        return !this.zzm ? this.zzd.zzc[this.zzf] : this.zzb.zzf[this.zzh];
    }

    public final int zzf() {
        return !this.zzm ? this.zzd.zzd[this.zzf] : this.zzb.zzh[this.zzf];
    }

    public final int zzg() {
        int i = !this.zzm ? this.zzd.zzg[this.zzf] : this.zzb.zzj[this.zzf] ? 1 : 0;
        return zzj() != null ? i | 1073741824 : i;
    }

    public final boolean zzh() {
        this.zzf++;
        if (!this.zzm) {
            return false;
        }
        int i = this.zzg + 1;
        this.zzg = i;
        int[] iArr = this.zzb.zzg;
        int i2 = this.zzh;
        if (i != iArr[i2]) {
            return true;
        }
        this.zzh = i2 + 1;
        this.zzg = 0;
        return false;
    }

    public final int zzi(int i, int i2) {
        zzeg zzegVar;
        zzajg zzajgVarZzj = zzj();
        if (zzajgVarZzj == null) {
            return 0;
        }
        int i3 = zzajgVarZzj.zzd;
        if (i3 != 0) {
            zzegVar = this.zzb.zzn;
        } else {
            byte[] bArr = zzajgVarZzj.zze;
            String str = zzep.zza;
            zzeg zzegVar2 = this.zzl;
            byte[] bArr2 = bArr;
            int length = bArr2.length;
            zzegVar2.zzb(bArr2, length);
            zzegVar = zzegVar2;
            i3 = length;
        }
        zzajh zzajhVar = this.zzb;
        boolean zZzb = zzajhVar.zzb(this.zzf);
        boolean z = zZzb || i2 != 0;
        zzeg zzegVar3 = this.zzk;
        zzegVar3.zzi()[0] = (byte) ((true != z ? 0 : 128) | i3);
        zzegVar3.zzh(0);
        zzaem zzaemVar = this.zza;
        zzaemVar.zzw(zzegVar3, 1, 1);
        zzaemVar.zzw(zzegVar, i3, 1);
        if (!z) {
            return i3 + 1;
        }
        if (!zZzb) {
            zzeg zzegVar4 = this.zzc;
            zzegVar4.zza(8);
            byte[] bArrZzi = zzegVar4.zzi();
            bArrZzi[0] = 0;
            bArrZzi[1] = 1;
            bArrZzi[2] = 0;
            bArrZzi[3] = (byte) i2;
            bArrZzi[4] = (byte) ((i >> 24) & 255);
            bArrZzi[5] = (byte) ((i >> 16) & 255);
            bArrZzi[6] = (byte) ((i >> 8) & 255);
            bArrZzi[7] = (byte) (i & 255);
            zzaemVar.zzw(zzegVar4, 8, 1);
            return i3 + 9;
        }
        int i4 = i3 + 1;
        zzeg zzegVar5 = zzajhVar.zzn;
        int iZzt = zzegVar5.zzt();
        zzegVar5.zzk(-2);
        int i5 = (iZzt * 6) + 2;
        if (i2 != 0) {
            zzeg zzegVar6 = this.zzc;
            zzegVar6.zza(i5);
            byte[] bArrZzi2 = zzegVar6.zzi();
            zzegVar5.zzm(bArrZzi2, 0, i5);
            int i6 = (((bArrZzi2[2] & 255) << 8) | (bArrZzi2[3] & 255)) + i2;
            bArrZzi2[2] = (byte) ((i6 >> 8) & 255);
            bArrZzi2[3] = (byte) (i6 & 255);
            zzegVar5 = zzegVar6;
        }
        zzaemVar.zzw(zzegVar5, i5, 1);
        return i4 + i5;
    }

    public final zzajg zzj() {
        if (!this.zzm) {
            return null;
        }
        zzajh zzajhVar = this.zzb;
        zzail zzailVar = zzajhVar.zza;
        String str = zzep.zza;
        int i = zzailVar.zza;
        zzajg zzajgVarZza = zzajhVar.zzm;
        if (zzajgVarZza == null) {
            zzajgVarZza = this.zzd.zza.zza(i);
        }
        if (zzajgVarZza == null || !zzajgVarZza.zza) {
            return null;
        }
        return zzajgVarZza;
    }

    final /* synthetic */ boolean zzk() {
        return this.zzm;
    }

    final /* synthetic */ void zzl(boolean z) {
        this.zzm = true;
    }
}
