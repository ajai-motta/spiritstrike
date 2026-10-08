package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakr extends zzacf implements zzadm {
    private static final zzakr zza;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private int zzh;
    private int zzi;

    static {
        zzakr zzakrVar = new zzakr();
        zza = zzakrVar;
        zzacf.zzao(zzakr.class, zzakrVar);
    }

    private zzakr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003င\u0002\u0004င\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzakq.zza, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzakr();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzakp(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
