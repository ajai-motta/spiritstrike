package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzkm {
    private long zza;
    private float zzb;
    private long zzc;

    public zzkm() {
        this.zza = C.TIME_UNSET;
        this.zzb = -3.4028235E38f;
        this.zzc = C.TIME_UNSET;
    }

    /* synthetic */ zzkm(zzkn zzknVar, byte[] bArr) {
        this.zza = zzknVar.zza;
        this.zzb = zzknVar.zzb;
        this.zzc = zzknVar.zzc;
    }

    public final zzkm zza(long j) {
        this.zza = j;
        return this;
    }

    public final zzkm zzb(float f) {
        boolean z = true;
        if (f <= 0.0f && f != -3.4028235E38f) {
            z = false;
        }
        zzgmd.zza(z);
        this.zzb = f;
        return this;
    }

    public final zzkm zzc(long j) {
        boolean z = true;
        if (j < 0) {
            if (j == C.TIME_UNSET) {
                j = -9223372036854775807L;
            } else {
                z = false;
            }
        }
        zzgmd.zza(z);
        this.zzc = j;
        return this;
    }

    public final zzkn zzd() {
        return new zzkn(this, null);
    }

    final /* synthetic */ long zze() {
        return this.zza;
    }

    final /* synthetic */ float zzf() {
        return this.zzb;
    }

    final /* synthetic */ long zzg() {
        return this.zzc;
    }
}
