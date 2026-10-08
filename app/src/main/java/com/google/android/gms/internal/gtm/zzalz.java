package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzalz extends zzacf implements zzadm {
    private static final zzalz zza;
    private int zzd = 0;
    private Object zze;

    static {
        zzalz zzalzVar = new zzalz();
        zza = zzalzVar;
        zzacf.zzao(zzalz.class, zzalzVar);
    }

    private zzalz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0006\u0001\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001<\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006<\u0000", new Object[]{"zze", "zzd", zzajo.class, zzake.class, zzakh.class, zzale.class, zzamn.class, zzakb.class});
        }
        if (i2 == 3) {
            return new zzalz();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzaly(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
