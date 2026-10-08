package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzwz extends zzsn implements zztt {
    private static final zzwz zzb;
    private static volatile zzua zzd;
    private int zze;
    private zzwd zzg;
    private zzvu zzh;
    private zzwg zzi;
    private String zzf = "";
    private String zzj = "";
    private String zzk = "";

    static {
        zzwz zzwzVar = new zzwz();
        zzb = zzwzVar;
        zzsn.zzI(zzwz.class, zzwzVar);
    }

    private zzwz() {
    }

    public static zzwx zzf() {
        return (zzwx) zzb.zzq();
    }

    static /* synthetic */ void zzi(zzwz zzwzVar, zzvu zzvuVar) {
        zzvuVar.getClass();
        zzwzVar.zzh = zzvuVar;
        zzwzVar.zze |= 2;
    }

    static /* synthetic */ void zzj(zzwz zzwzVar, String str) {
        str.getClass();
        zzwzVar.zzk = str;
    }

    static /* synthetic */ void zzk(zzwz zzwzVar, String str) {
        str.getClass();
        zzwzVar.zzj = str;
    }

    static /* synthetic */ void zzl(zzwz zzwzVar, String str) {
        str.getClass();
        zzwzVar.zzf = str;
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzF(zzb, "\u0000\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002ဉ\u0000\u0003ဉ\u0001\u0004ဉ\u0002\u0005Ȉ\u0006Ȉ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzwz();
        }
        zzwy zzwyVar = null;
        if (i2 == 4) {
            return new zzwx(zzwyVar);
        }
        if (i2 == 5) {
            return zzb;
        }
        if (i2 != 6) {
            throw null;
        }
        zzua zzsiVar = zzd;
        if (zzsiVar == null) {
            synchronized (zzwz.class) {
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
