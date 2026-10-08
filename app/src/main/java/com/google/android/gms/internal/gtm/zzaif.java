package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaif extends zzacf implements zzadm {
    public static final zzace zza;
    private static final zzaif zzd;
    private int zze;
    private zzaic zzf;

    static {
        zzaif zzaifVar = new zzaif();
        zzd = zzaifVar;
        zzacf.zzao(zzaif.class, zzaifVar);
        zza = zzacf.zzac(zzaii.zze(), zzaifVar, zzaifVar, null, 525002763, zzaex.MESSAGE, zzaif.class);
    }

    private zzaif() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaif();
        }
        zzaie zzaieVar = null;
        if (i2 == 4) {
            return new zzaid(zzaieVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }
}
