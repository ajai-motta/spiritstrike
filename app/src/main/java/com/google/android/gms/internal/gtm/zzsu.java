package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsu extends zzacf implements zzadm {
    private static final zzsu zza;
    private zzacn zzd = zzai();

    static {
        zzsu zzsuVar = new zzsu();
        zza = zzsuVar;
        zzacf.zzao(zzsu.class, zzsuVar);
    }

    private zzsu() {
    }

    public static zzsu zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzss.class});
        }
        if (i2 == 3) {
            return new zzsu();
        }
        zzsv zzsvVar = null;
        if (i2 == 4) {
            return new zzst(zzsvVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
