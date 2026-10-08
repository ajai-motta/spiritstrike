package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamc extends zzacf implements zzadm {
    private static final zzamc zza;
    private int zzd;
    private int zze;

    static {
        zzamc zzamcVar = new zzamc();
        zza = zzamcVar;
        zzacf.zzao(zzamc.class, zzamcVar);
    }

    private zzamc() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzamb.zza});
        }
        if (i2 == 3) {
            return new zzamc();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzama(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
