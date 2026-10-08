package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwl extends zzacf implements zzadm {
    private static final zzwl zza;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;

    static {
        zzwl zzwlVar = new zzwl();
        zza = zzwlVar;
        zzacf.zzao(zzwl.class, zzwlVar);
    }

    private zzwl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzacj zzacjVar = zzwk.zza;
            return zzal(zza, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006", new Object[]{"zzd", "zze", zzacjVar, "zzf", zzacjVar, "zzg", zzacjVar, "zzh", zzacjVar, "zzi", zzacjVar, "zzj", zzacjVar, "zzk", zzacjVar});
        }
        if (i2 == 3) {
            return new zzwl();
        }
        zzwm zzwmVar = null;
        if (i2 == 4) {
            return new zzwj(zzwmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
