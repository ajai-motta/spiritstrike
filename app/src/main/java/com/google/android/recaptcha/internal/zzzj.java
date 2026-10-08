package com.google.android.recaptcha.internal;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzj extends zzsn implements zztt {
    private static final zzzj zzb;
    private static volatile zzua zzd;
    private int zze;
    private int zzf;
    private int zzg;

    static {
        zzzj zzzjVar = new zzzj();
        zzb = zzzjVar;
        zzsn.zzI(zzzj.class, zzzjVar);
    }

    private zzzj() {
    }

    public static zzzj zzg(InputStream inputStream) throws IOException {
        return (zzzj) zzsn.zzw(zzb, inputStream);
    }

    public final zzzk zzi() {
        zzzk zzzkVarZzb = zzzk.zzb(this.zzg);
        return zzzkVarZzb == null ? zzzk.UNRECOGNIZED : zzzkVarZzb;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzzj();
        }
        zzzv zzzvVar = null;
        if (i2 == 4) {
            return new zzzi(zzzvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzzj.class) {
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
