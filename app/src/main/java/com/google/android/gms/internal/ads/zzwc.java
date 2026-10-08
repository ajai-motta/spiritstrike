package com.google.android.gms.internal.ads;

import android.os.Looper;
import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwc extends zztt implements zzvq {
    private final zzga zza;
    private final zzvm zzb;
    private final zzrz zzc;
    private final int zzd;
    private boolean zze = true;
    private long zzf = C.TIME_UNSET;
    private boolean zzg;
    private boolean zzh;
    private zzgz zzi;
    private zzak zzj;
    private final zzze zzk;

    /* synthetic */ zzwc(zzak zzakVar, zzga zzgaVar, zzvm zzvmVar, zzrz zzrzVar, zzze zzzeVar, int i, int i2, zzv zzvVar, zzgmv zzgmvVar, byte[] bArr) {
        this.zzj = zzakVar;
        this.zza = zzgaVar;
        this.zzb = zzvmVar;
        this.zzc = zzrzVar;
        this.zzk = zzzeVar;
        this.zzd = i;
    }

    private final void zzu() {
        long j = this.zzf;
        boolean z = this.zzg;
        boolean z2 = this.zzh;
        zzak zzakVarZzJ = zzJ();
        zzwo zzwoVar = new zzwo(C.TIME_UNSET, C.TIME_UNSET, C.TIME_UNSET, j, j, 0L, 0L, z, false, false, null, zzakVarZzJ, z2 ? zzakVarZzJ.zzc : null);
        zze(this.zze ? new zzvz(this, zzwoVar) : zzwoVar);
    }

    @Override // com.google.android.gms.internal.ads.zztt, com.google.android.gms.internal.ads.zzuw
    public final synchronized void zzA(zzak zzakVar) {
        this.zzj = zzakVar;
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzD(zzus zzusVar) {
        ((zzvy) zzusVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final zzus zzG(zzuu zzuuVar, zzyv zzyvVar, long j) {
        zzgb zzgbVarZza = this.zza.zza();
        zzgz zzgzVar = this.zzi;
        if (zzgzVar != null) {
            zzgbVarZza.zze(zzgzVar);
        }
        zzag zzagVar = zzJ().zzb;
        zzagVar.getClass();
        return new zzvy(zzagVar.zza, zzgbVarZza, this.zzb.zza(zzk()), this.zzc, zzh(zzuuVar), this.zzk, zzf(zzuuVar), this, zzyvVar, null, this.zzd, 0, null, zzep.zzq(C.TIME_UNSET), null);
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final synchronized zzak zzJ() {
        return this.zzj;
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected final void zza(zzgz zzgzVar) {
        this.zzi = zzgzVar;
        Looper.myLooper().getClass();
        zzk();
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zzvq
    public final void zzb(long j, zzaed zzaedVar, boolean z) {
        if (j == C.TIME_UNSET) {
            j = this.zzf;
        }
        boolean zZzb = zzaedVar.zzb();
        if (!this.zze && this.zzf == j && this.zzg == zZzb && this.zzh == z) {
            return;
        }
        this.zzf = j;
        this.zzg = zZzb;
        this.zzh = z;
        this.zze = false;
        zzu();
    }

    @Override // com.google.android.gms.internal.ads.zztt
    protected final void zzd() {
    }

    @Override // com.google.android.gms.internal.ads.zzuw
    public final void zzt() {
    }
}
