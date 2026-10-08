package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzamn extends zzacf implements zzadm {
    private static final zzamn zza;
    private int zzd;
    private int zze;
    private long zzh;
    private int zzi;
    private int zzj;
    private boolean zzs;
    private zzamh zzt;
    private int zzu;
    private String zzf = "";
    private String zzg = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzn = "";
    private String zzo = "";
    private String zzp = "";
    private zzacn zzq = zzai();
    private zzacn zzr = zzai();

    static {
        zzamn zzamnVar = new zzamn();
        zza = zzamnVar;
        zzacf.zzao(zzamn.class, zzamnVar);
    }

    private zzamn() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0011\u0000\u0001\u0001\u0011\u0011\u0000\u0002\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005င\u0004\u0006င\u0005\u0007ဈ\u0006\bဈ\u0007\tဈ\b\nဈ\t\u000bဈ\n\fဈ\u000b\r\u001b\u000e\u001b\u000fဇ\f\u0010ဉ\r\u0011᠌\u000e", new Object[]{"zzd", "zze", zzamj.zza, "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzq", zzaml.class, "zzr", zzaml.class, "zzs", "zzt", "zzu", zzamm.zza});
        }
        if (i2 == 3) {
            return new zzamn();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzami(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
