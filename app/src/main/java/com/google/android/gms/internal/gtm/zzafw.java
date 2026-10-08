package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafw extends zzacf implements zzadm {
    private static final zzafw zza;
    private int zzd;
    private zzack zze = zzah();
    private zzafq zzf;
    private zzafq zzg;

    static {
        zzafw zzafwVar = new zzafw();
        zza = zzafwVar;
        zzacf.zzao(zzafw.class, zzafwVar);
    }

    private zzafw() {
    }

    public static zzafw zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ࠞ\u0002ဉ\u0000\u0003ဉ\u0001", new Object[]{"zzd", "zze", zzage.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzafw();
        }
        zzagg zzaggVar = null;
        if (i2 == 4) {
            return new zzafv(zzaggVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
