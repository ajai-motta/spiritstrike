package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzh extends zzacf implements zzadm {
    private static final zzh zza;
    private int zzd;
    private zzap zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzh zzhVar = new zzh();
        zza = zzhVar;
        zzacf.zzao(zzh.class, zzhVar);
    }

    private zzh() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ဈ\u0000\u0002ᐉ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzh();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzg(zzmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
