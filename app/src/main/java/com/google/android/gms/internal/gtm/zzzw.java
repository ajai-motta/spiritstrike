package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzzw extends zzacc implements zzadm {
    private static final zzzw zzd;
    private int zze;
    private zzzu zzg;
    private zzaae zzi;
    private byte zzk = 2;
    private zzacn zzf = zzadu.zze();
    private zzacn zzh = zzadu.zze();
    private int zzj = 1;

    static {
        zzzw zzzwVar = new zzzw();
        zzd = zzzwVar;
        zzacf.zzao(zzzw.class, zzzwVar);
    }

    private zzzw() {
    }

    public static zzzw zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\u0005\u0000\u0001\u0001ϧ\u0005\u0000\u0002\u0002\u0001ဉ\u0000\u0002\u001b\u0003᠌\u00022ᐉ\u0001ϧЛ", new Object[]{"zze", "zzg", "zzh", zzzs.class, "zzj", zzzv.zza, "zzi", "zzf", zzabl.class});
        }
        if (i2 == 3) {
            return new zzzw();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzzq(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
