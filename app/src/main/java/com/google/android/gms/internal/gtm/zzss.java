package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzss extends zzacf implements zzadm {
    private static final zzss zza;
    private int zzd;
    private int zze = 1;
    private int zzf;

    static {
        zzss zzssVar = new zzss();
        zza = zzssVar;
        zzacf.zzao(zzss.class, zzssVar);
    }

    private zzss() {
    }

    public static zzss zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzss();
        }
        zzsv zzsvVar = null;
        if (i2 == 4) {
            return new zzsr(zzsvVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
