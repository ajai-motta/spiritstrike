package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzifg implements zzifq, zzifb {
    private static final Object zza = new Object();
    private volatile zzifq zzb;
    private volatile Object zzc = zza;

    private zzifg(zzifq zzifqVar) {
        this.zzb = zzifqVar;
    }

    public static zzifq zza(zzifq zzifqVar) {
        return zzifqVar instanceof zzifg ? zzifqVar : new zzifg(zzifqVar);
    }

    public static zzifb zzc(zzifq zzifqVar) {
        if (zzifqVar instanceof zzifb) {
            return (zzifb) zzifqVar;
        }
        zzifqVar.getClass();
        return new zzifg(zzifqVar);
    }

    private final synchronized Object zzd() {
        Object obj = this.zzc;
        Object obj2 = zza;
        if (obj != obj2) {
            return obj;
        }
        Object objZzb = this.zzb.zzb();
        Object obj3 = this.zzc;
        if (obj3 != obj2 && obj3 != objZzb) {
            throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj3 + " & " + objZzb + ". This is likely due to a circular dependency.");
        }
        this.zzc = objZzb;
        this.zzb = null;
        return objZzb;
    }

    @Override // com.google.android.gms.internal.ads.zzifw, com.google.android.gms.internal.ads.zzifv
    public final Object zzb() {
        Object obj = this.zzc;
        return obj == zza ? zzd() : obj;
    }
}
