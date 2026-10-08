package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzagc extends zzacf implements zzadm {
    private static final zzagc zza;
    private int zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    private int zzl;
    private boolean zzm;
    private boolean zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private boolean zzu;
    private boolean zzv;
    private boolean zzw;

    static {
        zzagc zzagcVar = new zzagc();
        zza = zzagcVar;
        zzacf.zzao(zzagc.class, zzagcVar);
    }

    private zzagc() {
    }

    public static zzagc zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0013\u0000\u0001\u0001\u0013\u0013\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006\bင\u0007\tဇ\b\nဇ\t\u000bဇ\u000b\fဇ\r\rဇ\f\u000eဇ\n\u000fဇ\u000e\u0010ဇ\u000f\u0011ဇ\u0010\u0012ဇ\u0011\u0013ဇ\u0012", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", "zzn", "zzp", "zzr", "zzq", "zzo", "zzs", "zzt", "zzu", "zzv", "zzw"});
        }
        if (i2 == 3) {
            return new zzagc();
        }
        zzagg zzaggVar = null;
        if (i2 == 4) {
            return new zzagb(zzaggVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
