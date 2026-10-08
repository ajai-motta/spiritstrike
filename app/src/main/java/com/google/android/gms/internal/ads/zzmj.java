package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzmj {
    public final long zza;
    public final zzbf zzb;
    public final int zzc;
    public final zzuu zzd;
    public final long zze;
    public final zzbf zzf;
    public final int zzg;
    public final zzuu zzh;
    public final long zzi;
    public final long zzj;

    public zzmj(long j, zzbf zzbfVar, int i, zzuu zzuuVar, long j2, zzbf zzbfVar2, int i2, zzuu zzuuVar2, long j3, long j4) {
        this.zza = j;
        this.zzb = zzbfVar;
        this.zzc = i;
        this.zzd = zzuuVar;
        this.zze = j2;
        this.zzf = zzbfVar2;
        this.zzg = i2;
        this.zzh = zzuuVar2;
        this.zzi = j3;
        this.zzj = j4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmj zzmjVar = (zzmj) obj;
            if (this.zza == zzmjVar.zza && this.zzc == zzmjVar.zzc && this.zze == zzmjVar.zze && this.zzg == zzmjVar.zzg && this.zzi == zzmjVar.zzi && this.zzj == zzmjVar.zzj && Objects.equals(this.zzb, zzmjVar.zzb) && Objects.equals(this.zzd, zzmjVar.zzd) && Objects.equals(this.zzf, zzmjVar.zzf) && Objects.equals(this.zzh, zzmjVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
