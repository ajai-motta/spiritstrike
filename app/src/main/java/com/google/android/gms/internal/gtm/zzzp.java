package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzp extends zzacc implements zzadm {
    private static final zzzp zzd;
    private int zze;
    private boolean zzf;
    private zzaae zzg;
    private boolean zzh;
    private zzaak zzi;
    private byte zzk = 2;
    private zzacn zzj = zzadu.zze();

    static {
        zzzp zzzpVar = new zzzp();
        zzd = zzzpVar;
        zzacf.zzao(zzzp.class, zzzpVar);
    }

    private zzzp() {
    }

    public static zzzp zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0001\u0002\u0001ဇ\u0000\u0002ᐉ\u0001\u0003ဇ\u0002\u0004ဉ\u0003ϧЛ", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzabl.class});
        }
        if (i2 == 3) {
            return new zzzp();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzzo(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
