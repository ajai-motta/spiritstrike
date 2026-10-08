package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaha extends zzacf implements zzadm {
    private static final zzaha zza;
    private int zzd;
    private zzack zze = zzah();
    private int zzf;

    static {
        zzaha zzahaVar = new zzaha();
        zza = zzahaVar;
        zzacf.zzao(zzaha.class, zzahaVar);
    }

    private zzaha() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u0016\u0002င\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaha();
        }
        zzagz zzagzVar = null;
        if (i2 == 4) {
            return new zzagy(zzagzVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
