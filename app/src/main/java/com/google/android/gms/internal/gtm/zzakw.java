package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakw extends zzacf implements zzadm {
    private static final zzakw zza;
    private int zzd;
    private boolean zzf;
    private zzacn zze = zzai();
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";

    static {
        zzakw zzakwVar = new zzakw();
        zza = zzakwVar;
        zzacf.zzao(zzakw.class, zzakwVar);
    }

    private zzakw() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဈ\u0003\u0006ဈ\u0004\u0007ဈ\u0005\bဈ\u0006", new Object[]{"zzd", "zze", zzaku.class, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzakw();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzakv(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
