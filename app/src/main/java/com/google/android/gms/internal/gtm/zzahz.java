package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahz extends zzacf implements zzadm {
    private static final zzahz zza;
    private int zzd;
    private int zze;
    private boolean zzf;

    static {
        zzahz zzahzVar = new zzahz();
        zza = zzahzVar;
        zzacf.zzao(zzahz.class, zzahzVar);
    }

    private zzahz() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0002\u0000\u0001\r\u0018\u0002\u0000\u0000\u0000\rင\u0000\u0018ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzahz();
        }
        zzahy zzahyVar = null;
        if (i2 == 4) {
            return new zzahx(zzahyVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }
}
