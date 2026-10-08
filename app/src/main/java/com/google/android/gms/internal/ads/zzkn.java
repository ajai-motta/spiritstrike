package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzkn {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzkn(zzkm zzkmVar, byte[] bArr) {
        this.zza = zzkmVar.zze();
        this.zzb = zzkmVar.zzf();
        this.zzc = zzkmVar.zzg();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzkn)) {
            return false;
        }
        zzkn zzknVar = (zzkn) obj;
        return this.zza == zzknVar.zza && this.zzb == zzknVar.zzb && this.zzc == zzknVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzkm zza() {
        return new zzkm(this, null);
    }
}
