package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxm extends zzacf implements zzadm {
    private static final zzxm zza;
    private int zzd;
    private zzxo zze;
    private long zzf;
    private byte zzg = 2;

    static {
        zzxm zzxmVar = new zzxm();
        zza = zzxmVar;
        zzacf.zzao(zzxm.class, zzxmVar);
    }

    private zzxm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᐉ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzxm();
        }
        zzxp zzxpVar = null;
        if (i2 == 4) {
            return new zzxl(zzxpVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
