package com.google.android.recaptcha.internal;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzzq extends zzsn implements zztt {
    private static final zzzq zzb;
    private static volatile zzua zzd;
    private int zze;
    private String zzf = "";
    private zzss zzg = zzy();
    private zzst zzh = zzA();
    private zzza zzi;

    static {
        zzzq zzzqVar = new zzzq();
        zzb = zzzqVar;
        zzsn.zzI(zzzq.class, zzzqVar);
    }

    private zzzq() {
    }

    public static zzzq zzi(byte[] bArr) throws zzsx {
        return (zzzq) zzsn.zzx(zzb, bArr);
    }

    public final zzza zzf() {
        zzza zzzaVar = this.zzi;
        return zzzaVar == null ? zzza.zzg() : zzzaVar;
    }

    public final String zzj() {
        return this.zzf;
    }

    public final List zzk() {
        return this.zzh;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001Ȉ\u0002'\u0003%\u0004ဉ\u0000", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzzq();
        }
        zzzv zzzvVar = null;
        if (i2 == 4) {
            return new zzzp(zzzvVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzzq.class) {
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
