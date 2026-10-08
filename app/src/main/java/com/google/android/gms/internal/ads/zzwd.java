package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzwd implements zzyu {
    public long zza;
    public long zzb;
    public zzyt zzc;
    public zzwd zzd;

    public zzwd(long j, int i) {
        zza(j, 65536);
    }

    public final void zza(long j, int i) {
        zzgmd.zzh(this.zzc == null);
        this.zza = j;
        this.zzb = j + PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH;
    }

    public final int zzb(long j) {
        long j2 = j - this.zza;
        int i = this.zzc.zzb;
        return (int) j2;
    }

    public final zzwd zzc() {
        this.zzc = null;
        zzwd zzwdVar = this.zzd;
        this.zzd = null;
        return zzwdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final zzyu zze() {
        zzwd zzwdVar = this.zzd;
        if (zzwdVar == null || zzwdVar.zzc == null) {
            return null;
        }
        return zzwdVar;
    }

    @Override // com.google.android.gms.internal.ads.zzyu
    public final zzyt zzd() {
        zzyt zzytVar = this.zzc;
        zzytVar.getClass();
        return zzytVar;
    }
}
