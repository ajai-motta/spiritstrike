package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzclk {
    private zzcjp zza;
    private zzcmh zzb;
    private zzfkw zzc;
    private zzcmu zzd;
    private zzfhq zze;

    private zzclk() {
        throw null;
    }

    /* synthetic */ zzclk(byte[] bArr) {
    }

    public final zzclk zza(zzcjp zzcjpVar) {
        this.zza = zzcjpVar;
        return this;
    }

    public final zzclk zzb(zzcmh zzcmhVar) {
        this.zzb = zzcmhVar;
        return this;
    }

    public final zzcjn zzc() {
        zzifp.zzc(this.zza, zzcjp.class);
        zzifp.zzc(this.zzb, zzcmh.class);
        if (this.zzc == null) {
            this.zzc = new zzfkw();
        }
        if (this.zzd == null) {
            this.zzd = new zzcmu();
        }
        if (this.zze == null) {
            this.zze = new zzfhq();
        }
        return new zzckz(this.zza, this.zzb, this.zzc, this.zzd, this.zze);
    }
}
