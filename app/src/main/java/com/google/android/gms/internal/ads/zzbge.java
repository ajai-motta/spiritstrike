package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-api@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public class zzbge {
    private final String zza;
    private final Object zzb;
    private final int zzc;

    protected zzbge(String str, Object obj, int i) {
        this.zza = str;
        this.zzb = obj;
        this.zzc = i;
    }

    public static zzbge zza(String str, boolean z) {
        return new zzbge(str, Boolean.valueOf(z), 1);
    }

    public static zzbge zzb(String str, long j) {
        return new zzbge(str, Long.valueOf(j), 2);
    }

    public static zzbge zzc(String str, double d) {
        return new zzbge(str, Double.valueOf(d), 3);
    }

    public static zzbge zzd(String str, String str2) {
        return new zzbge("gad:dynamite_module:experiment_id", "", 4);
    }

    public final Object zze() {
        zzbhk zzbhkVarZza = zzbhm.zza();
        if (zzbhkVarZza != null) {
            int i = this.zzc - 1;
            return i != 0 ? i != 1 ? i != 2 ? zzbhkVarZza.zzd(this.zza, (String) this.zzb) : zzbhkVarZza.zzc(this.zza, ((Double) this.zzb).doubleValue()) : zzbhkVarZza.zzb(this.zza, ((Long) this.zzb).longValue()) : zzbhkVarZza.zza(this.zza, ((Boolean) this.zzb).booleanValue());
        }
        if (zzbhm.zzb() != null) {
            zzbhm.zzb().zza();
        }
        return this.zzb;
    }
}
