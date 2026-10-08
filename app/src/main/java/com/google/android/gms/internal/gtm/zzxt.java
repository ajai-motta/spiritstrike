package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxt extends zzacf implements zzadm {
    private static final zzxt zza;
    private int zzd;
    private String zze = "";

    static {
        zzxt zzxtVar = new zzxt();
        zza = zzxtVar;
        zzacf.zzao(zzxt.class, zzxtVar);
    }

    private zzxt() {
    }

    public static zzxt zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzxt();
        }
        zzxs zzxsVar = null;
        if (i2 == 4) {
            return new zzxr(zzxsVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
