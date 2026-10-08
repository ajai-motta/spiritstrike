package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzsi extends zzacf implements zzadm {
    private static final zzsi zza;
    private String zzd = "";
    private String zze = "";

    static {
        zzsi zzsiVar = new zzsi();
        zza = zzsiVar;
        zzacf.zzao(zzsi.class, zzsiVar);
    }

    private zzsi() {
    }

    public static zzsi zzc() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzsi();
        }
        zzsh zzshVar = null;
        if (i2 == 4) {
            return new zzsg(zzshVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
