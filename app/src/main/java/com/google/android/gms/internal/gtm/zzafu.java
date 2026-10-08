package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafu extends zzacf implements zzadm {
    private static final zzafu zza;
    private int zzd;
    private zzafq zze;

    static {
        zzafu zzafuVar = new zzafu();
        zza = zzafuVar;
        zzacf.zzao(zzafu.class, zzafuVar);
    }

    private zzafu() {
    }

    public static zzafu zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzafu();
        }
        zzagg zzaggVar = null;
        if (i2 == 4) {
            return new zzaft(zzaggVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
