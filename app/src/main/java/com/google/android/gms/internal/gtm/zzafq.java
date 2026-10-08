package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafq extends zzacf implements zzadm {
    private static final zzafq zza;
    private int zzd;
    private zzack zze = zzah();
    private zzagc zzf;

    static {
        zzafq zzafqVar = new zzafq();
        zza = zzafqVar;
        zzacf.zzao(zzafq.class, zzafqVar);
    }

    private zzafq() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ࠬ\u0002ဉ\u0000", new Object[]{"zzd", "zze", zzage.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzafq();
        }
        zzagg zzaggVar = null;
        if (i2 == 4) {
            return new zzafp(zzaggVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
