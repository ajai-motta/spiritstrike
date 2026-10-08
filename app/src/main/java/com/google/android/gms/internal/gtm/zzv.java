package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzv extends zzacf implements zzadm {
    private static final zzv zza;
    private byte zzg = 2;
    private zzacn zzd = zzai();
    private zzacn zze = zzai();
    private zzacn zzf = zzai();

    static {
        zzv zzvVar = new zzv();
        zza = zzvVar;
        zzacf.zzao(zzv.class, zzvVar);
    }

    private zzv() {
    }

    public static zzv zzc() {
        return zza;
    }

    public final List zzd() {
        return this.zzf;
    }

    public final List zze() {
        return this.zze;
    }

    public final List zzf() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0003\u0002\u0001Л\u0002Л\u0003\u001b", new Object[]{"zzd", zzap.class, "zze", zzap.class, "zzf", zzt.class});
        }
        if (i2 == 3) {
            return new zzv();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzu(zzaiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
