package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaap extends zzacf implements zzadm {
    private static final zzaap zza;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzaap zzaapVar = new zzaap();
        zza = zzaapVar;
        zzacf.zzao(zzaap.class, zzaapVar);
    }

    private zzaap() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzadv(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzaap();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzaao(zzabmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
