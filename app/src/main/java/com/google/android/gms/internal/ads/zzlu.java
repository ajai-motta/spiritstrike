package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzlu {
    public static final zzlu zza = new zzlu(new zzlt());
    public final zzgpo zzb;
    public final Double zzc = null;
    public final Double zzd = null;
    public final boolean zze = true;
    public final boolean zzf = true;
    public final boolean zzi = true;
    public final boolean zzg = true;
    public final boolean zzh = true;

    private zzlu(zzlt zzltVar) {
        this.zzb = zzltVar.zza();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzlu)) {
            return false;
        }
        zzlu zzluVar = (zzlu) obj;
        if (!this.zzb.equals(zzluVar.zzb)) {
            return false;
        }
        boolean z = zzluVar.zzf;
        boolean z2 = zzluVar.zzi;
        Double d = zzluVar.zzc;
        Double d2 = zzluVar.zzd;
        boolean z3 = zzluVar.zze;
        boolean z4 = zzluVar.zzg;
        boolean z5 = zzluVar.zzh;
        return true;
    }

    public final int hashCode() {
        return Objects.hash(this.zzb, null, null, true, true, true, true, true);
    }
}
