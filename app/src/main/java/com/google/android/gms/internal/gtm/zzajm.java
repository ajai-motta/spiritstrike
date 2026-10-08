package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzajm extends zzacf implements zzadm {
    private static final zzajm zza;
    private int zzd;
    private boolean zze;

    static {
        zzajm zzajmVar = new zzajm();
        zza = zzajmVar;
        zzacf.zzao(zzajm.class, zzajmVar);
    }

    private zzajm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဇ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzajm();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzajl(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
