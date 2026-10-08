package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzo extends zzsn implements zztt {
    private static final zzzo zzb;
    private static volatile zzua zzd;
    private zzsu zze = zzB();

    static {
        zzzo zzzoVar = new zzzo();
        zzb = zzzoVar;
        zzsn.zzI(zzzo.class, zzzoVar);
    }

    private zzzo() {
    }

    public static zzzo zzg(byte[] bArr) throws zzsx {
        return (zzzo) zzsn.zzx(zzb, bArr);
    }

    public final List zzi() {
        return this.zze;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", zzzu.class});
        }
        if (i2 == 3) {
            return new zzzo();
        }
        zzzv zzzvVar = null;
        if (i2 == 4) {
            return new zzzn(zzzvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzzo.class) {
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
