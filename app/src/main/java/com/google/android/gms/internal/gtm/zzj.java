package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzj extends zzacf implements zzadm {
    private static final zzj zza;
    private int zzd;
    private zzap zzk;
    private byte zzl = 2;
    private zzacn zze = zzai();
    private zzacn zzf = zzai();
    private zzacn zzg = zzai();
    private zzacn zzh = zzai();
    private zzacn zzi = zzai();
    private zzacn zzj = zzai();

    static {
        zzj zzjVar = new zzj();
        zza = zzjVar;
        zzacf.zzao(zzj.class, zzjVar);
    }

    private zzj() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0006\u0007\u0001Л\u0002Л\u0003Л\u0004Л\u0005Л\u0006Л\u0007ᐉ\u0000", new Object[]{"zzd", "zze", zzf.class, "zzf", zzf.class, "zzg", zzf.class, "zzh", zzf.class, "zzi", zzf.class, "zzj", zzf.class, "zzk"});
        }
        if (i2 == 3) {
            return new zzj();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzi(zzmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
