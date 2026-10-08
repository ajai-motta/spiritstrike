package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzr extends zzacf implements zzadm {
    private static final zzr zza;
    private int zzd;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private byte zzj = 2;
    private zzack zze = zzah();

    static {
        zzr zzrVar = new zzr();
        zza = zzrVar;
        zzacf.zzao(zzr.class, zzrVar);
    }

    private zzr() {
    }

    public final List zzc() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzj);
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\u0005\u0000\u0001\u0001\u0006\u0005\u0000\u0001\u0001\u0001ဇ\u0003\u0002ᔄ\u0000\u0003\u0016\u0004င\u0001\u0006ဇ\u0002", new Object[]{"zzd", "zzi", "zzf", "zze", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzr();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzq(zzaiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        this.zzj = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
