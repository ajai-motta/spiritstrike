package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzals extends zzacf implements zzadm {
    private static final zzals zza;
    private int zzd;
    private int zzf;
    private String zze = "";
    private String zzg = "";

    static {
        zzals zzalsVar = new zzals();
        zza = zzalsVar;
        zzacf.zzao(zzals.class, zzalsVar);
    }

    private zzals() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", zzalr.zza, "zzg"});
        }
        if (i2 == 3) {
            return new zzals();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalq(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
