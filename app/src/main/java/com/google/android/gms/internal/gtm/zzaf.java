package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzaf extends zzacf implements zzadm {
    private static final zzaf zza;
    private int zzd;
    private zzap zzf;
    private zzv zzg;
    private byte zzh = 2;
    private String zze = "";

    static {
        zzaf zzafVar = new zzaf();
        zza = zzafVar;
        zzacf.zzao(zzaf.class, zzafVar);
    }

    private zzaf() {
    }

    public final zzv zza() {
        zzv zzvVar = this.zzg;
        return zzvVar == null ? zzv.zzc() : zzvVar;
    }

    public final String zzd() {
        return this.zze;
    }

    public final boolean zze() {
        return (this.zzd & 4) != 0;
    }

    public final boolean zzf() {
        return (this.zzd & 1) != 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0002\u0001ဈ\u0000\u0002ᐉ\u0001\u0003ᐉ\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzaf();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzae(zzaiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
