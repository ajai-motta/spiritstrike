package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyo extends zzsn implements zztt {
    private static final zzyo zzb;
    private static volatile zzua zzd;
    private int zze;
    private String zzf = "";
    private zzsu zzg = zzB();

    static {
        zzyo zzyoVar = new zzyo();
        zzb = zzyoVar;
        zzsn.zzI(zzyo.class, zzyoVar);
    }

    private zzyo() {
    }

    public static zzyn zzf() {
        return (zzyn) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzyo zzyoVar, Iterable iterable) {
        zzyoVar.zzl();
        zzpw.zzc(iterable, zzyoVar.zzg);
    }

    static /* synthetic */ void zzj(zzyo zzyoVar, zzym zzymVar) {
        zzymVar.getClass();
        zzyoVar.zzl();
        zzyoVar.zzg.add(zzymVar);
    }

    static /* synthetic */ void zzk(zzyo zzyoVar, String str) {
        str.getClass();
        zzyoVar.zze |= 1;
        zzyoVar.zzf = str;
    }

    private final void zzl() {
        zzsu zzsuVar = this.zzg;
        if (zzsuVar.zzc()) {
            return;
        }
        this.zzg = zzsn.zzC(zzsuVar);
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", new Object[]{"zze", "zzg", zzym.class, "zzf"});
        }
        if (i2 == 3) {
            return new zzyo();
        }
        zzyp zzypVar = null;
        if (i2 == 4) {
            return new zzyn(zzypVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzyo.class) {
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
