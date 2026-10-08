package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaae extends zzacc implements zzadm {
    private static final zzaae zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private byte zzl = 2;

    static {
        zzaae zzaaeVar = new zzaae();
        zzd = zzaaeVar;
        zzacf.zzao(zzaae.class, zzaaeVar);
    }

    private zzaae() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002\u0004᠌\u0003\u0005᠌\u0004\u0006᠌\u0005", new Object[]{"zze", "zzf", zzzz.zza, "zzg", zzzy.zza, "zzh", zzaac.zza, "zzi", zzaad.zza, "zzj", zzaab.zza, "zzk", zzaaa.zza});
        }
        if (i2 == 3) {
            return new zzaae();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzzx(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
