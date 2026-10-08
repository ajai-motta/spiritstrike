package com.google.android.gms.internal.gtm;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-analytics-impl@@18.2.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzab extends zzacf implements zzadm {
    private static final zzab zza;
    private zzack zzd = zzah();
    private zzack zze = zzah();
    private zzack zzf = zzah();
    private zzack zzg = zzah();
    private zzack zzh = zzah();
    private zzack zzi = zzah();
    private zzack zzj = zzah();
    private zzack zzk = zzah();
    private zzack zzl = zzah();
    private zzack zzm = zzah();

    static {
        zzab zzabVar = new zzab();
        zza = zzabVar;
        zzacf.zzao(zzab.class, zzabVar);
    }

    private zzab() {
    }

    @Override // com.google.android.gms.internal.gtm.zzacf
    protected final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzal(zza, "\u0004\n\u0000\u0000\u0001\n\n\u0000\n\u0000\u0001\u0016\u0002\u0016\u0003\u0016\u0004\u0016\u0005\u0016\u0006\u0016\u0007\u0016\b\u0016\t\u0016\n\u0016", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzab();
        }
        zzai zzaiVar = null;
        if (i2 == 4) {
            return new zzaa(zzaiVar);
        }
        if (i2 == 5) {
            return zza;
        }
        throw null;
    }

    public final List zzc() {
        return this.zzj;
    }

    public final List zzd() {
        return this.zzl;
    }

    public final List zze() {
        return this.zzf;
    }

    public final List zzf() {
        return this.zzh;
    }

    public final List zzg() {
        return this.zze;
    }

    public final List zzh() {
        return this.zzd;
    }

    public final List zzi() {
        return this.zzk;
    }

    public final List zzj() {
        return this.zzm;
    }

    public final List zzk() {
        return this.zzg;
    }

    public final List zzl() {
        return this.zzi;
    }
}
