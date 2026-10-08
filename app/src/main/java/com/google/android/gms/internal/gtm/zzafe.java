package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafe extends zzacf implements zzadm {
    private static final zzafe zza;
    private zzacn zzd = zzacf.zzai();
    private zzack zze = zzah();
    private zzack zzf = zzah();

    static {
        zzafe zzafeVar = new zzafe();
        zza = zzafeVar;
        zzacf.zzao(zzafe.class, zzafeVar);
    }

    private zzafe() {
    }

    public static zzafe zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0003\u0000\u0000\u0001\u0005\u0003\u0000\u0003\u0000\u0001\u001a\u0002ࠞ\u0005ࠬ", new Object[]{"zzd", "zze", zzafj.zza, "zzf", zzafk.zza});
        }
        if (i2 == 3) {
            return new zzafe();
        }
        zzafh zzafhVar = null;
        if (i2 == 4) {
            return new zzafd(zzafhVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
