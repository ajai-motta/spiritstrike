package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafy extends zzacf implements zzadm {
    private static final zzafy zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        zzafy zzafyVar = new zzafy();
        zza = zzafyVar;
        zzacf.zzao(zzafy.class, zzafyVar);
    }

    private zzafy() {
    }

    public static zzafy zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0003\u0003ဇ\u0004\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzd", "zze", "zzh", "zzi", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzafy();
        }
        zzagg zzaggVar = null;
        if (i2 == 4) {
            return new zzafx(zzaggVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
