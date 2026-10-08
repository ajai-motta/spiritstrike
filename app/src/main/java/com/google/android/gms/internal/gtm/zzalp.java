package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzalp extends zzacf implements zzadm {
    private static final zzalp zza;
    private int zzd;
    private zzalo zze;
    private zzali zzf;

    static {
        zzalp zzalpVar = new zzalp();
        zza = zzalpVar;
        zzacf.zzao(zzalp.class, zzalpVar);
    }

    private zzalp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzalp();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalf(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
