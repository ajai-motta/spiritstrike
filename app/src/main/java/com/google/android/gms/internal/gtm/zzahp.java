package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahp extends zzacc implements zzadm {
    private static final zzahp zzd;
    private int zze;
    private zzahr zzf;
    private byte zzg = 2;

    static {
        zzahp zzahpVar = new zzahp();
        zzd = zzahpVar;
        zzacf.zzao(zzahp.class, zzahpVar);
    }

    private zzahp() {
    }

    public static zzahp zze() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzahp();
        }
        zzahs zzahsVar = null;
        if (i2 == 4) {
            return new zzaho(zzahsVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
