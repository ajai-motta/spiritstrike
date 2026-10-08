package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsq extends zzacf implements zzadm {
    private static final zzsq zza;
    private zzacn zzd = zzai();

    static {
        zzsq zzsqVar = new zzsq();
        zza = zzsqVar;
        zzacf.zzao(zzsq.class, zzsqVar);
    }

    private zzsq() {
    }

    public static zzsq zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzsp.class});
        }
        if (i2 == 3) {
            return new zzsq();
        }
        zzsv zzsvVar = null;
        if (i2 == 4) {
            return new zzsn(zzsvVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
