package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaak extends zzacf implements zzadm {
    private static final zzaak zza;
    private int zzd;
    private int zze;
    private int zzf;
    private String zzg = "";
    private int zzh;

    static {
        zzaak zzaakVar = new zzaak();
        zza = zzaakVar;
        zzacf.zzao(zzaak.class, zzaakVar);
    }

    private zzaak() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            zzacj zzacjVar = zzzk.zza;
            return new zzadv(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဈ\u0002\u0004᠌\u0003", new Object[]{"zzd", "zze", zzacjVar, "zzf", zzacjVar, "zzg", "zzh", zzacjVar});
        }
        if (i2 == 3) {
            return new zzaak();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzaaj(zzabmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
