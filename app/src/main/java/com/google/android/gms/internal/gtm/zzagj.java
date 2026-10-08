package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagj extends zzacf implements zzadm {
    private static final zzagj zza;
    private int zzd;
    private zzacn zze = zzacf.zzai();
    private String zzf = "";

    static {
        zzagj zzagjVar = new zzagj();
        zza = zzagjVar;
        zzacf.zzao(zzagj.class, zzagjVar);
    }

    private zzagj() {
    }

    public static zzagj zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001a\u0002ဈ\u0000", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzagj();
        }
        zzagk zzagkVar = null;
        if (i2 == 4) {
            return new zzagi(zzagkVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
