package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.gms.internal.ads.zzkl;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzcfq implements zzkl {
    private final zzzb zza = new zzzb(true, 65536);
    private long zzb = 15000000;
    private long zzc = 30000000;
    private long zzd = 2500000;
    private long zze = 5000000;
    private int zzf;
    private boolean zzg;

    zzcfq() {
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zza(zzpc zzpcVar) {
        zzo(false);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzb(zzkk zzkkVar, zzwv zzwvVar, zzyk[] zzykVarArr) {
        int i;
        this.zzf = 0;
        for (zzyk zzykVar : zzykVarArr) {
            if (zzykVar != null) {
                int i2 = this.zzf;
                int i3 = zzykVar.zza().zzc;
                if (i3 == 0) {
                    i = DefaultLoadControl.DEFAULT_MUXED_BUFFER_SIZE;
                } else if (i3 == 1) {
                    i = 13107200;
                } else if (i3 != 2) {
                    i = 131072;
                    if (i3 != 3 && i3 != 5 && i3 != 6) {
                        throw new IllegalArgumentException();
                    }
                } else {
                    i = DefaultLoadControl.DEFAULT_VIDEO_BUFFER_SIZE;
                }
                this.zzf = i2 + i;
            }
        }
        this.zza.zzf(this.zzf);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzc(zzpc zzpcVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final void zzd(zzpc zzpcVar) {
        zzo(true);
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final zzyv zze(zzpc zzpcVar) {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final long zzf(zzpc zzpcVar) {
        return 0L;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzg(zzpc zzpcVar) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzh(zzkk zzkkVar) {
        long j = zzkkVar.zze;
        boolean z = true;
        char c = j > this.zzc ? (char) 0 : j < this.zzb ? (char) 2 : (char) 1;
        int iZzg = this.zza.zzg();
        int i = this.zzf;
        if (c != 2 && (c != 1 || !this.zzg || iZzg >= i)) {
            z = false;
        }
        this.zzg = z;
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public final boolean zzi(zzkk zzkkVar) {
        long j = zzkkVar.zzg ? this.zze : this.zzd;
        return j <= 0 || zzkkVar.zze >= j;
    }

    @Override // com.google.android.gms.internal.ads.zzkl
    public /* synthetic */ boolean zzj(zzpc zzpcVar, zzbf zzbfVar, zzuu zzuuVar, long j) {
        return zzkl.CC.$default$zzj(this, zzpcVar, zzbfVar, zzuuVar, j);
    }

    public final synchronized void zzk(int i) {
        this.zzb = ((long) i) * 1000;
    }

    public final synchronized void zzl(int i) {
        this.zzc = ((long) i) * 1000;
    }

    public final synchronized void zzm(int i) {
        this.zzd = ((long) i) * 1000;
    }

    public final synchronized void zzn(int i) {
        this.zze = ((long) i) * 1000;
    }

    final void zzo(boolean z) {
        this.zzf = 0;
        this.zzg = false;
        if (z) {
            this.zza.zze();
        }
    }
}
