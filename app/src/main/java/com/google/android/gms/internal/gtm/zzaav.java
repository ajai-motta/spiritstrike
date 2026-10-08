package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaav extends zzacc implements zzadm {
    private static final zzaav zzd;
    private int zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzk;
    private zzaae zzl;
    private byte zzn = 2;
    private String zzj = "";
    private zzacn zzm = zzadu.zze();

    static {
        zzaav zzaavVar = new zzaav();
        zzd = zzaavVar;
        zzacf.zzao(zzaav.class, zzaavVar);
    }

    private zzaav() {
    }

    public static zzaav zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzn);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\b\u0000\u0001\u0001ϧ\b\u0000\u0001\u0002\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0007ဇ\u0003\nဈ\u0004\u000bဇ\u0005\fᐉ\u0006ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzabl.class});
        }
        if (i2 == 3) {
            return new zzaav();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzaau(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzn = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
