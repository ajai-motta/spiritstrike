package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzalx extends zzacf implements zzadm {
    private static final zzalx zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzalx zzalxVar = new zzalx();
        zza = zzalxVar;
        zzacf.zzao(zzalx.class, zzalxVar);
    }

    private zzalx() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0007\u0000\u0001\u0001\b\u0007\u0000\u0000\u0000\u0001ဈ\u0000\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0001\bဈ\u0006", new Object[]{"zzd", "zze", "zzg", "zzh", "zzi", "zzj", "zzf", "zzk"});
        }
        if (i2 == 3) {
            return new zzalx();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalw(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
