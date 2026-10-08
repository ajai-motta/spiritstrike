package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: com.google.android.recaptcha:recaptcha@@18.7.1 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrk extends zzsk implements zztt {
    private static final zzrk zzd;
    private static volatile zzua zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private int zzn;
    private byte zzo = 2;

    static {
        zzrk zzrkVar = new zzrk();
        zzd = zzrkVar;
        zzsn.zzI(zzrk.class, zzrkVar);
    }

    private zzrk() {
    }

    @Override // com.google.android.recaptcha.internal.zzsn
    protected final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzo);
        }
        if (i2 == 2) {
            return new zzue(zzd, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005\u0007᠌\u0006\b᠌\u0007", new Object[]{"zzf", "zzg", zzre.zza, "zzh", zzrd.zza, "zzi", zzrh.zza, "zzj", zzri.zza, "zzk", zzrg.zza, "zzl", zzrf.zza, "zzm", zzrc.zza, "zzn", zzrj.zza});
        }
        if (i2 == 3) {
            return new zzrk();
        }
        zzrr zzrrVar = null;
        if (i2 == 4) {
            return new zzrb(zzrrVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        if (i2 != 6) {
            this.zzo = obj == null ? (byte) 0 : (byte) 1;
            return null;
        }
        zzua zzsiVar = zze;
        if (zzsiVar == null) {
            synchronized (zzrk.class) {
                zzsiVar = zze;
                if (zzsiVar == null) {
                    zzsiVar = new zzsi(zzd);
                    zze = zzsiVar;
                }
            }
        }
        return zzsiVar;
    }
}
