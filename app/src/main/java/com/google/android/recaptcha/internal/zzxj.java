package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzxj extends zzsn implements zztt {
    private static final zzxj zzb;
    private static volatile zzua zzd;
    private int zze;
    private String zzf = "";

    static {
        zzxj zzxjVar = new zzxj();
        zzb = zzxjVar;
        zzsn.zzI(zzxj.class, zzxjVar);
    }

    private zzxj() {
    }

    public static zzxi zzf() {
        return (zzxi) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzxj zzxjVar, String str) {
        zzxjVar.zze |= 1;
        zzxjVar.zzf = str;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ለ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzxj();
        }
        zzyc zzycVar = null;
        if (i2 == 4) {
            return new zzxi(zzycVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzxj.class) {
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
