package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrv extends zzacf implements zzadm {
    private static final zzrv zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzrv zzrvVar = new zzrv();
        zza = zzrvVar;
        zzacf.zzao(zzrv.class, zzrvVar);
    }

    private zzrv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzd", "zze", zzrt.zza, "zzf", zzrs.zza, "zzg", zzru.zza});
        }
        if (i2 == 3) {
            return new zzrv();
        }
        zzrw zzrwVar = null;
        if (i2 == 4) {
            return new zzrr(zzrwVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
