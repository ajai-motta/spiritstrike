package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabl extends zzacf implements zzadm {
    private static final zzabl zza;
    private int zzd;
    private long zzg;
    private long zzh;
    private double zzi;
    private byte zzl = 2;
    private zzacn zze = zzadu.zze();
    private String zzf = "";
    private zzyx zzj = zzyx.zzb;
    private String zzk = "";

    static {
        zzabl zzablVar = new zzabl();
        zza = zzablVar;
        zzacf.zzao(zzabl.class, zzablVar);
    }

    private zzabl() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzl);
        }
        if (i2 == 2) {
            return new zzadv(zza, "\u0001\u0007\u0000\u0001\u0002\b\u0007\u0000\u0001\u0001\u0002Л\u0003ဈ\u0000\u0004ဃ\u0001\u0005ဂ\u0002\u0006က\u0003\u0007ည\u0004\bဈ\u0005", new Object[]{"zzd", "zze", zzabk.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new zzabl();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzabi(zzabmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzl = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
