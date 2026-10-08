package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzalv extends zzacf implements zzadm {
    private static final zzalv zza;
    private int zzd;
    private int zzf;
    private String zze = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzalv zzalvVar = new zzalv();
        zza = zzalvVar;
        zzacf.zzao(zzalv.class, zzalvVar);
    }

    private zzalv() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", "zzf", zzalu.zza, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzalv();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalt(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
