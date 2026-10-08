package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzxd extends zzacc implements zzadm {
    private static final zzxd zzd;
    private int zze;
    private int zzf;
    private int zzj;
    private zzahd zzk;
    private int zzl;
    private boolean zzn;
    private zzwo zzp;
    private byte zzq = 2;
    private int zzg = -1;
    private zzack zzh = zzah();
    private String zzi = "";
    private String zzm = "";
    private int zzo = -1;

    static {
        zzxd zzxdVar = new zzxd();
        zzd = zzxdVar;
        zzacf.zzao(zzxd.class, zzxdVar);
    }

    private zzxd() {
    }

    public static zzxd zzc() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzq);
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0001\u000b\u0000\u0001\u0001è\u000b\u0000\u0001\u0002\u0001င\u0000\u0003င\u0001\u0004\u0016\u0005ဈ\u0002\u0006᠌\u0005\u0007င\u0003\u000bᐉ\u0004\u0011ဈ\u0006\u0082ဇ\u0007\u0095င\bèᐉ\t", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzl", zzxc.zza, "zzj", "zzk", "zzm", "zzn", "zzo", "zzp"});
        }
        if (i2 == 3) {
            return new zzxd();
        }
        zzxe zzxeVar = null;
        if (i2 == 4) {
            return new zzxb(zzxeVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzq = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
