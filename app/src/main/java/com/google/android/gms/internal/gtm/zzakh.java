package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakh extends zzacf implements zzadm {
    private static final zzakh zza;
    private int zzd;
    private String zze = "";
    private int zzf;

    static {
        zzakh zzakhVar = new zzakh();
        zza = zzakhVar;
        zzacf.zzao(zzakh.class, zzakhVar);
    }

    private zzakh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001", new Object[]{"zzd", "zze", "zzf", zzakg.zza});
        }
        if (i2 == 3) {
            return new zzakh();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzakf(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
