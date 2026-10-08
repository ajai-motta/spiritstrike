package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzf extends zzacf implements zzadm {
    private static final zzf zza;
    private int zzd;
    private zzap zzf;
    private byte zzh = 2;
    private zzacn zze = zzai();
    private String zzg = "";

    static {
        zzf zzfVar = new zzf();
        zza = zzfVar;
        zzacf.zzao(zzf.class, zzfVar);
    }

    private zzf() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0002\u0001Л\u0002ᐉ\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", zzh.class, "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzf();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zze(zzmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
