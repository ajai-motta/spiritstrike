package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahu extends zzacf implements zzadm {
    private static final zzahu zza;
    private int zzd;
    private boolean zze;

    static {
        zzahu zzahuVar = new zzahu();
        zza = zzahuVar;
        zzacf.zzao(zzahu.class, zzahuVar);
    }

    private zzahu() {
    }

    public static zzahu zze() {
        return zza;
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
            return new zzahu();
        }
        zzahv zzahvVar = null;
        if (i2 == 4) {
            return new zzaht(zzahvVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
