package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagq extends zzacf implements zzadm {
    private static final zzagq zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        zzagq zzagqVar = new zzagq();
        zza = zzagqVar;
        zzacf.zzao(zzagq.class, zzagqVar);
    }

    private zzagq() {
    }

    public static zzagq zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzagq();
        }
        zzagr zzagrVar = null;
        if (i2 == 4) {
            return new zzagp(zzagrVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
