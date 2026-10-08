package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzl extends zzacf implements zzadm {
    private static final zzl zza;
    private byte zzf = 2;
    private zzacn zzd = zzai();
    private zzacn zze = zzai();

    static {
        zzl zzlVar = new zzl();
        zza = zzlVar;
        zzacf.zzao(zzl.class, zzlVar);
    }

    private zzl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzf);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0002\u0001Л\u0002Л", new Object[]{"zzd", zzj.class, "zze", zzf.class});
        }
        if (i2 == 3) {
            return new zzl();
        }
        zzm zzmVar = null;
        if (i2 == 4) {
            return new zzk(zzmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzf = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
