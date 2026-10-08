package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrz extends zzacf implements zzadm {
    private static final zzrz zza;
    private int zzd;
    private int zze;

    static {
        zzrz zzrzVar = new zzrz();
        zza = zzrzVar;
        zzacf.zzao(zzrz.class, zzrzVar);
    }

    private zzrz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", zzry.zza});
        }
        if (i2 == 3) {
            return new zzrz();
        }
        zzsa zzsaVar = null;
        if (i2 == 4) {
            return new zzrx(zzsaVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
