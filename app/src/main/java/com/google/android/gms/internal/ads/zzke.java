package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzke {
    public zzlf zza;
    public int zzb;
    public boolean zzc;
    public int zzd;
    private boolean zze;

    public zzke(zzlf zzlfVar) {
        this.zza = zzlfVar;
    }

    public final void zza(int i) {
        this.zze = 1 == ((this.zze ? 1 : 0) | i);
        this.zzb += i;
    }

    public final void zzb(zzlf zzlfVar) {
        this.zze |= this.zza != zzlfVar;
        this.zza = zzlfVar;
    }

    public final void zzc(int i) {
        if (this.zzc && this.zzd != 5) {
            zzgmd.zza(i == 5);
            return;
        }
        this.zze = true;
        this.zzc = true;
        this.zzd = i;
    }

    final /* synthetic */ boolean zzd() {
        return this.zze;
    }
}
