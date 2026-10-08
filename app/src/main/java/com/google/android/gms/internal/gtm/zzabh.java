package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabh extends zzacc implements zzadm {
    private static final zzabh zzd;
    private int zze;
    private boolean zzf;
    private zzaae zzh;
    private boolean zzi;
    private byte zzk = 2;
    private double zzg = -1.0d;
    private zzacn zzj = zzadu.zze();

    static {
        zzabh zzabhVar = new zzabh();
        zzd = zzabhVar;
        zzacf.zzao(zzabh.class, zzabhVar);
    }

    private zzabh() {
    }

    public static zzabh zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzk);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\u0005\u0000\u0001\u0010ϧ\u0005\u0000\u0001\u0002\u0010က\u0001\u0014ဇ\u0000!ဇ\u0003\"ᐉ\u0002ϧЛ", new Object[]{"zze", "zzg", "zzf", "zzi", "zzh", "zzj", zzabl.class});
        }
        if (i2 == 3) {
            return new zzabh();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzabg(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzk = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
