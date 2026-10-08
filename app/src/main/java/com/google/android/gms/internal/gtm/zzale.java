package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzale extends zzacf implements zzadm {
    private static final zzale zza;
    private int zzd;
    private int zze;

    static {
        zzale zzaleVar = new zzale();
        zza = zzaleVar;
        zzacf.zzao(zzale.class, zzaleVar);
    }

    private zzale() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzald.zza});
        }
        if (i2 == 3) {
            return new zzale();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalc(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
