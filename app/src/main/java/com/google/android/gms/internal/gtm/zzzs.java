package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzs extends zzacf implements zzadm {
    private static final zzzs zza;
    private int zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private boolean zzi;

    static {
        zzzs zzzsVar = new zzzs();
        zza = zzzsVar;
        zzacf.zzao(zzzs.class, zzzsVar);
    }

    private zzzs() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzadv(zza, "\u0001\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0005ဇ\u0003\u0006ဇ\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzzs();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzzr(zzabmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
