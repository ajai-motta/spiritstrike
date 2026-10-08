package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzh extends zzsn implements zztt {
    private static final zzzh zzb;
    private static volatile zzua zzd;
    private int zze;

    static {
        zzzh zzzhVar = new zzzh();
        zzb = zzzhVar;
        zzsn.zzI(zzzh.class, zzzhVar);
    }

    private zzzh() {
    }

    public static zzzh zzg(byte[] bArr) throws zzsx {
        return (zzzh) zzsn.zzx(zzb, bArr);
    }

    public final zzzk zzi() {
        zzzk zzzkVarZzb = zzzk.zzb(this.zze);
        return zzzkVarZzb == null ? zzzk.UNRECOGNIZED : zzzkVarZzb;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zze"});
        }
        if (i2 == 3) {
            return new zzzh();
        }
        zzzv zzzvVar = null;
        if (i2 == 4) {
            return new zzzg(zzzvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzzh.class) {
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
