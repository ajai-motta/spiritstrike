package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzabf extends zzacc implements zzadm {
    private static final zzabf zzd;
    private int zze;
    private zzaae zzf;
    private byte zzh = 2;
    private zzacn zzg = zzadu.zze();

    static {
        zzabf zzabfVar = new zzabf();
        zzd = zzabfVar;
        zzacf.zzao(zzabf.class, zzabfVar);
    }

    private zzabf() {
    }

    public static zzabf zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return new zzadv(zzd, "\u0001\u0002\u0000\u0001\u0001ϧ\u0002\u0000\u0001\u0002\u0001ᐉ\u0000ϧЛ", new Object[]{"zze", "zzf", "zzg", zzabl.class});
        }
        if (i2 == 3) {
            return new zzabf();
        }
        zzabm zzabmVar = null;
        if (i2 == 4) {
            return new zzabe(zzabmVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
