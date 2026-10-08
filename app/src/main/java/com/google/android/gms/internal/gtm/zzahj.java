package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzahj extends zzacf implements zzadm {
    private static final zzahj zza;
    private byte zze = 2;
    private zzacn zzd = zzai();

    static {
        zzahj zzahjVar = new zzahj();
        zza = zzahjVar;
        zzacf.zzao(zzahj.class, zzahjVar);
    }

    private zzahj() {
    }

    public static zzahj zze() {
        return zza;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zze);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zzd", zzahi.class});
        }
        if (i2 == 3) {
            return new zzahj();
        }
        zzahm zzahmVar = null;
        if (i2 == 4) {
            return new zzahg(zzahmVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zze = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
