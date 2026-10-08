package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzali extends zzacf implements zzadm {
    private static final zzali zza;
    private int zzd;
    private int zze;
    private long zzh;
    private int zzi;
    private int zzj;
    private zzalk zzp;
    private String zzf = "";
    private String zzg = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";

    static {
        zzali zzaliVar = new zzali();
        zza = zzaliVar;
        zzacf.zzao(zzali.class, zzaliVar);
    }

    private zzali() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\f\u0000\u0001\u0001\f\f\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဉ\u000b", new Object[]{"zzd", "zze", zzalg.zza, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzali();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzalh(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
