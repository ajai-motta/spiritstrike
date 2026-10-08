package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwr extends zzacf implements zzadm {
    private static final zzwr zza;
    private Object zze;
    private Object zzg;
    private int zzd = 0;
    private int zzf = 0;
    private byte zzh = 2;

    static {
        zzwr zzwrVar = new zzwr();
        zza = zzwrVar;
        zzacf.zzao(zzwr.class, zzwrVar);
    }

    private zzwr() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0005\u0002\u0000\u0001\u0005\u0005\u0000\u0000\u0003\u0001м\u0000\u0002м\u0001\u0003м\u0000\u0004;\u0000\u0005;\u0001", new Object[]{"zze", "zzd", "zzg", "zzf", zzxo.class, zzxj.class, zzxm.class});
        }
        if (i2 == 3) {
            return new zzwr();
        }
        zzws zzwsVar = null;
        if (i2 == 4) {
            return new zzwq(zzwsVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
