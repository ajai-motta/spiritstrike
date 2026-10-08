package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzvq extends zzsn implements zztt {
    private static final zzvq zzb;
    private static volatile zzua zzd;
    private int zze;
    private zzrv zzf;
    private int zzg;

    static {
        zzvq zzvqVar = new zzvq();
        zzb = zzvqVar;
        zzsn.zzI(zzvq.class, zzvqVar);
    }

    private zzvq() {
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u0004", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzvq();
        }
        zzvp zzvpVar = null;
        if (i2 == 4) {
            return new zzvo(zzvpVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzvq.class) {
                zzsiVar = zzd;
                if (zzsiVar == null) {
                    zzsiVar = new zzsi(zzb);
                    zzd = zzsiVar;
                }
            }
        }
        return zzsiVar;
    }
}
