package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzavd extends zzhwo implements zzhya {
    private static final zzavd zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private zzhvi zzb;
    private zzhvi zzc;
    private zzhvi zzd;
    private zzhvi zze;

    static {
        zzavd zzavdVar = new zzavd();
        zzf = zzavdVar;
        zzhwo.zzbu(zzavd.class, zzavdVar);
    }

    private zzavd() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzb = zzhviVar;
        this.zzc = zzhviVar;
        this.zzd = zzhviVar;
        this.zze = zzhviVar;
    }

    public static zzavd zze(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzavd) zzhwo.zzbV(zzf, bArr, zzhvyVar);
    }

    public static zzavc zzg() {
        return (zzavc) zzf.zzbn();
    }

    public final zzhvi zza() {
        return this.zzb;
    }

    public final zzhvi zzb() {
        return this.zzc;
    }

    public final zzhvi zzc() {
        return this.zzd;
    }

    public final zzhvi zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002\u0004ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzavd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzavc(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzavd.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzh(zzhvi zzhviVar) {
        this.zza |= 1;
        this.zzb = zzhviVar;
    }

    final /* synthetic */ void zzi(zzhvi zzhviVar) {
        this.zza |= 2;
        this.zzc = zzhviVar;
    }

    final /* synthetic */ void zzj(zzhvi zzhviVar) {
        this.zza |= 4;
        this.zzd = zzhviVar;
    }

    final /* synthetic */ void zzk(zzhvi zzhviVar) {
        this.zza |= 8;
        this.zze = zzhviVar;
    }
}
