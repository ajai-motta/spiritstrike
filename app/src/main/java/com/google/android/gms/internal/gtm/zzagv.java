package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagv extends zzacf implements zzadm {
    private static final zzagv zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private zzack zzi = zzah();
    private String zzj = "";

    static {
        zzagv zzagvVar = new zzagv();
        zza = zzagvVar;
        zzacf.zzao(zzagv.class, zzagvVar);
    }

    private zzagv() {
    }

    public static zzagv zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ࠞ\u0006ဈ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzagu.zza, "zzj"});
        }
        if (i2 == 3) {
            return new zzagv();
        }
        zzagw zzagwVar = null;
        if (i2 == 4) {
            return new zzagt(zzagwVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
