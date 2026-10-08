package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxw extends zzacf implements zzadm {
    private static final zzxw zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private zzye zzh;

    static {
        zzxw zzxwVar = new zzxw();
        zza = zzxwVar;
        zzacf.zzao(zzxw.class, zzxwVar);
    }

    private zzxw() {
    }

    public static zzxw zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzxw();
        }
        zzxv zzxvVar = null;
        if (i2 == 4) {
            return new zzxu(zzxvVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
