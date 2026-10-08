package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaek extends zzacf implements zzadm {
    private static final zzaek zza;
    private long zzd;
    private int zze;

    static {
        zzaek zzaekVar = new zzaek();
        zza = zzaekVar;
        zzacf.zzao(zzaek.class, zzaekVar);
    }

    private zzaek() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzadv(zza, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzaek();
        }
        zzaej zzaejVar = null;
        if (i2 == 4) {
            return new zzaei(zzaejVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
