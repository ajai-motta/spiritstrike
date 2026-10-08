package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaic extends zzacf implements zzadm {
    private static final zzaic zza;
    private int zzd;
    private zzahz zze;

    static {
        zzaic zzaicVar = new zzaic();
        zza = zzaicVar;
        zzacf.zzao(zzaic.class, zzaicVar);
    }

    private zzaic() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0002\u0002\u0001\u0000\u0000\u0000\u0002ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaic();
        }
        zzaib zzaibVar = null;
        if (i2 == 4) {
            return new zzaia(zzaibVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
