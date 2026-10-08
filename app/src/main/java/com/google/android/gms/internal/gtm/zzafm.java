package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafm extends zzacf implements zzadm {
    private static final zzafm zza;
    private int zzd;
    private int zze;
    private String zzf = "*";

    static {
        zzafm zzafmVar = new zzafm();
        zza = zzafmVar;
        zzacf.zzao(zzafm.class, zzafmVar);
    }

    private zzafm() {
    }

    public static zzafm zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", zzafn.zza, "zzf"});
        }
        if (i2 == 3) {
            return new zzafm();
        }
        zzafo zzafoVar = null;
        if (i2 == 4) {
            return new zzafl(zzafoVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
