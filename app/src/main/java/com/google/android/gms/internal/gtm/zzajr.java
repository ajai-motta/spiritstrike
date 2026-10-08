package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzajr extends zzacf implements zzadm {
    private static final zzajr zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        zzajr zzajrVar = new zzajr();
        zza = zzajrVar;
        zzacf.zzao(zzajr.class, zzajrVar);
    }

    private zzajr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", zzajq.zza, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzajr();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzajp(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
