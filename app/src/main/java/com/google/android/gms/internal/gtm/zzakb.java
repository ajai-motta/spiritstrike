package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakb extends zzacf implements zzadm {
    private static final zzakb zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzakb zzakbVar = new zzakb();
        zza = zzakbVar;
        zzacf.zzao(zzakb.class, zzakbVar);
    }

    private zzakb() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", new Object[]{"zzd", "zze", zzaka.zza, "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzakb();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzajz(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
