package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxz extends zzacf implements zzadm {
    private static final zzxz zza;
    private int zzd;
    private String zze = "";
    private boolean zzf = true;
    private String zzg = "";

    static {
        zzxz zzxzVar = new zzxz();
        zza = zzxzVar;
        zzacf.zzao(zzxz.class, zzxzVar);
    }

    private zzxz() {
    }

    public static zzxz zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဈ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzxz();
        }
        zzxy zzxyVar = null;
        if (i2 == 4) {
            return new zzxx(zzxyVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
