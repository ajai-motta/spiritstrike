package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsd extends zzacf implements zzadm {
    private static final zzsd zza;
    private zzacn zzd = zzacf.zzai();

    static {
        zzsd zzsdVar = new zzsd();
        zza = zzsdVar;
        zzacf.zzao(zzsd.class, zzsdVar);
    }

    private zzsd() {
    }

    public static zzsd zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001Ț", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzsd();
        }
        zzsc zzscVar = null;
        if (i2 == 4) {
            return new zzsb(zzscVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
