package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxo extends zzacf implements zzadm {
    public static final zzace zza;
    private static final zzxo zzd;
    private int zze;
    private long zzf;
    private int zzg;
    private int zzh;
    private byte zzi = 2;

    static {
        zzxo zzxoVar = new zzxo();
        zzd = zzxoVar;
        zzacf.zzao(zzxo.class, zzxoVar);
        zza = zzacf.zzac(zzaii.zze(), zzxoVar, zzxoVar, null, 4156379, zzaex.MESSAGE, zzxo.class);
    }

    private zzxo() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzi);
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0003\u0001ᔂ\u0000\u0002ᔆ\u0001\u0003ᔆ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzxo();
        }
        zzxp zzxpVar = null;
        if (i2 == 4) {
            return new zzxn(zzxpVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzi = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
