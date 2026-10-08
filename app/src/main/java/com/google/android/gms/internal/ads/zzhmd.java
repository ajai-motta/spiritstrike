package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmd extends zzhwo implements zzhya {
    private static final zzhmd zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private int zzb;
    private zzhlz zzc;
    private zzhvi zzd;
    private zzhvi zze;

    static {
        zzhmd zzhmdVar = new zzhmd();
        zzf = zzhmdVar;
        zzhwo.zzbu(zzhmd.class, zzhmdVar);
    }

    private zzhmd() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzd = zzhviVar;
        this.zze = zzhviVar;
    }

    public static zzhmd zze(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhmd) zzhwo.zzbT(zzf, zzhviVar, zzhvyVar);
    }

    public static zzhmc zzg() {
        return (zzhmc) zzf.zzbn();
    }

    public static zzhmd zzh() {
        return zzf;
    }

    public static zzhyh zzi() {
        return zzf.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhlz zzb() {
        zzhlz zzhlzVar = this.zzc;
        return zzhlzVar == null ? zzhlz.zzc() : zzhlzVar;
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
            return zzbv(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhmd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhmc(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzhmd.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzj(zzhlz zzhlzVar) {
        zzhlzVar.getClass();
        this.zzc = zzhlzVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzk(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }

    final /* synthetic */ void zzl(zzhvi zzhviVar) {
        this.zze = zzhviVar;
    }
}
