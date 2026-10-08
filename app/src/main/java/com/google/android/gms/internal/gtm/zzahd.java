package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahd extends zzacf implements zzadm {
    private static final zzahd zza;
    private Object zze;
    private Object zzg;
    private int zzd = 0;
    private int zzf = 0;
    private byte zzh = 2;

    static {
        zzahd zzahdVar = new zzahd();
        zza = zzahdVar;
        zzacf.zzao(zzahd.class, zzahdVar);
    }

    private zzahd() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0004\u0002\u0000\u0001\u0006\u0004\u0000\u0000\u0002\u0001м\u0000\u0002м\u0000\u00037\u0001\u0006<\u0001", new Object[]{"zze", "zzd", "zzg", "zzf", zzxo.class, zzxm.class, zzaha.class});
        }
        if (i2 == 3) {
            return new zzahd();
        }
        zzahc zzahcVar = null;
        if (i2 == 4) {
            return new zzahb(zzahcVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
