package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzaad {
    private boolean zzc;
    private int zze;
    private zzaac zza = new zzaac();
    private zzaac zzb = new zzaac();
    private long zzd = C.TIME_UNSET;

    public final void zza() {
        this.zza.zza();
        this.zzb.zza();
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
        this.zze = 0;
    }

    public final void zzb(long j) {
        this.zza.zzf(j);
        if (this.zza.zzb()) {
            this.zzc = false;
        } else if (this.zzd != C.TIME_UNSET) {
            if (!this.zzc || this.zzb.zzc()) {
                this.zzb.zza();
                this.zzb.zzf(this.zzd);
            }
            this.zzc = true;
            this.zzb.zzf(j);
        }
        if (this.zzc && this.zzb.zzb()) {
            zzaac zzaacVar = this.zza;
            this.zza = this.zzb;
            this.zzb = zzaacVar;
            this.zzc = false;
        }
        this.zzd = j;
        this.zze = this.zza.zzb() ? 0 : this.zze + 1;
    }

    public final boolean zzc() {
        return this.zza.zzb();
    }

    public final int zzd() {
        return this.zze;
    }

    public final long zze() {
        return this.zza.zzb() ? this.zza.zzd() : C.TIME_UNSET;
    }

    public final long zzf() {
        return this.zza.zzb() ? this.zza.zze() : C.TIME_UNSET;
    }

    public final float zzg() {
        if (this.zza.zzb()) {
            return (float) (1.0E9d / this.zza.zze());
        }
        return -1.0f;
    }
}
