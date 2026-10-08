package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaix extends zzacf implements zzadm {
    private static final zzaix zza;
    private int zzd;
    private long zze;
    private int zzf;

    static {
        zzaix zzaixVar = new zzaix();
        zza = zzaixVar;
        zzacf.zzao(zzaix.class, zzaixVar);
    }

    private zzaix() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဂ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzaiw.zza});
        }
        if (i2 == 3) {
            return new zzaix();
        }
        zzaiy zzaiyVar = null;
        if (i2 == 4) {
            return new zzaiv(zzaiyVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
