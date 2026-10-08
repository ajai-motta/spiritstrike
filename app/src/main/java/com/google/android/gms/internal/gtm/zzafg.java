package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzafg extends zzacf implements zzadm {
    private static final zzafg zza;
    private zzacn zzd = zzacf.zzai();
    private zzack zze = zzah();
    private zzack zzf = zzah();
    private zzack zzg = zzah();
    private zzacn zzh = zzacf.zzai();

    static {
        zzafg zzafgVar = new zzafg();
        zza = zzafgVar;
        zzacf.zzao(zzafg.class, zzafgVar);
    }

    private zzafg() {
    }

    public static zzafg zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0005\u0000\u0001\u001a\u0002ࠞ\u0003\u0016\u0004\u001a\u0005ࠬ", new Object[]{"zzd", "zze", zzafj.zza, "zzg", "zzh", "zzf", zzafk.zza});
        }
        if (i2 == 3) {
            return new zzafg();
        }
        zzafh zzafhVar = null;
        if (i2 == 4) {
            return new zzaff(zzafhVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
