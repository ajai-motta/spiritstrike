package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzais extends zzacf implements zzadm {
    private static final zzais zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;

    static {
        zzais zzaisVar = new zzais();
        zza = zzaisVar;
        zzacf.zzao(zzais.class, zzaisVar);
    }

    private zzais() {
    }

    public static zzais zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzais();
        }
        zzait zzaitVar = null;
        if (i2 == 4) {
            return new zzair(zzaitVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
