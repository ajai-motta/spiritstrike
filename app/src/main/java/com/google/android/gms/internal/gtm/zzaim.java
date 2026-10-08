package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaim extends zzacf implements zzadm {
    private static final zzaim zza;
    private zzack zzd = zzah();

    static {
        zzaim zzaimVar = new zzaim();
        zza = zzaimVar;
        zzacf.zzao(zzaim.class, zzaimVar);
    }

    private zzaim() {
    }

    public static zzaim zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001ࠞ", new Object[]{"zzd", zzaij.zza});
        }
        if (i2 == 3) {
            return new zzaim();
        }
        zzail zzailVar = null;
        if (i2 == 4) {
            return new zzaik(zzailVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
