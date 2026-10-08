package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzpl {
    public static final zzpl zza = new zzpk().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzpl(zzpk zzpkVar, byte[] bArr) {
        this.zzb = zzpkVar.zze();
        this.zzc = zzpkVar.zzf();
        this.zzd = zzpkVar.zzg();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpl zzplVar = (zzpl) obj;
            if (this.zzb == zzplVar.zzb && this.zzc == zzplVar.zzc && this.zzd == zzplVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z = this.zzb;
        boolean z2 = this.zzc;
        return ((z ? 1 : 0) << 2) + (z2 ? 1 : 0) + (z2 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
