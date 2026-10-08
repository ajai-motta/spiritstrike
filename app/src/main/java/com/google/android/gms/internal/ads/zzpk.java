package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpk {
    private boolean zza;
    private boolean zzb;
    private boolean zzc;

    public final zzpk zza(boolean z) {
        this.zza = true;
        return this;
    }

    public final zzpk zzb(boolean z) {
        this.zzb = z;
        return this;
    }

    public final zzpk zzc(boolean z) {
        this.zzc = z;
        return this;
    }

    final /* synthetic */ boolean zze() {
        return this.zza;
    }

    final /* synthetic */ boolean zzf() {
        return this.zzb;
    }

    final /* synthetic */ boolean zzg() {
        return this.zzc;
    }

    public final zzpl zzd() {
        if (this.zza || !(this.zzb || this.zzc)) {
            return new zzpl(this, null);
        }
        throw new IllegalStateException("Secondary offload attribute fields are true but primary isFormatSupported is false");
    }
}
