package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzad extends zzacf implements zzadm {
    public static final zzace zza;
    private static final zzad zzd;
    private int zze;
    private int zzi;
    private int zzk;
    private int zzl;
    private zzack zzf = zzah();
    private zzack zzg = zzah();
    private zzack zzh = zzah();
    private zzack zzj = zzah();

    static {
        zzad zzadVar = new zzad();
        zzd = zzadVar;
        zzacf.zzao(zzad.class, zzadVar);
        zza = zzacf.zzac(zzap.zzi(), zzadVar, zzadVar, null, 101, zzaex.MESSAGE, zzad.class);
    }

    private zzad() {
    }

    public final int zza() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zzd, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0004\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004င\u0000\u0005\u0016\u0006င\u0001\u0007င\u0002", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl"});
        }
        if (i2 == 3) {
            return new zzad();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzac(zzaiVar);
        }
        if (i2 == 5) {
            return zzd;
        }
        throw null;
    }

    public final int zzc() {
        return this.zzg.size();
    }

    public final int zzd() {
        return this.zzh.size();
    }

    public final List zzf() {
        return this.zzf;
    }

    public final List zzg() {
        return this.zzg;
    }

    public final List zzh() {
        return this.zzh;
    }

    public final List zzi() {
        return this.zzj;
    }
}
