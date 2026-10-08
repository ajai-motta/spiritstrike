package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzp extends zzacf implements zzadm {
    private static final zzp zza;
    private int zzd;
    private int zze = 1;
    private int zzf;
    private int zzg;

    static {
        zzp zzpVar = new zzp();
        zza = zzpVar;
        zzacf.zzao(zzp.class, zzpVar);
    }

    private zzp() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002င\u0001\u0003င\u0002", new Object[]{"zzd", "zze", zzo.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzp();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzn(zzaiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
