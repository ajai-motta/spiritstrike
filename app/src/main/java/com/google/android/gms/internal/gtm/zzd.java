package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzd extends zzacf implements zzadm {
    public static final zzace zza;
    private static final zzd zzd;
    private int zze;
    private zzl zzf;
    private zzf zzg;
    private byte zzh = 2;

    static {
        zzd zzdVar = new zzd();
        zzd = zzdVar;
        zzacf.zzao(zzd.class, zzdVar);
        zza = zzacf.zzac(zzap.zzi(), zzdVar, zzdVar, null, 47497405, zzaex.MESSAGE, zzd.class);
    }

    private zzd() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0004\u0002\u0000\u0001\u0001\u0003\u0002\u0000\u0000\u0002\u0001ᐉ\u0000\u0003ᐉ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzd();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzc(zzmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
