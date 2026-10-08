package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakz extends zzacf implements zzadm {
    private static final zzakz zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";

    static {
        zzakz zzakzVar = new zzakz();
        zza = zzakzVar;
        zzacf.zzao(zzakz.class, zzakzVar);
    }

    private zzakz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0002\u0003ဈ\u0001\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzd", "zze", "zzg", "zzf", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzakz();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzaky(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
