package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzakm extends zzacf implements zzadm {
    private static final zzakm zza;
    private int zzd;
    private long zzn;
    private int zzo;
    private zzwv zzq;
    private zzaek zzr;
    private String zze = "";
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";
    private String zzk = "";
    private String zzl = "";
    private String zzm = "";
    private String zzp = "";

    static {
        zzakm zzakmVar = new zzakm();
        zza = zzakmVar;
        zzacf.zzao(zzakm.class, zzakmVar);
    }

    private zzakm() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u000e\u0000\u0001\u0001\u000e\u000e\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဈ\u0006\u0007ဈ\u0007\bဈ\b\tဂ\t\nင\n\u000bဈ\u000b\fဈ\u0005\rဉ\f\u000eဉ\r", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzj", "zzq", "zzr"});
        }
        if (i2 == 3) {
            return new zzakm();
        }
        zzamq zzamqVar = null;
        if (i2 == 4) {
            return new zzakl(zzamqVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
