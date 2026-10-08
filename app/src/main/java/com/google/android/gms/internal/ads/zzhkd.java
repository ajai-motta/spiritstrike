package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhkd extends zzhwo implements zzhya {
    private static final zzhkd zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private zzhkf zzc;
    private zzhvi zzd = zzhvi.zzb;

    static {
        zzhkd zzhkdVar = new zzhkd();
        zze = zzhkdVar;
        zzhwo.zzbu(zzhkd.class, zzhkdVar);
    }

    private zzhkd() {
    }

    public static zzhkd zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhkd) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhkc zze() {
        return (zzhkc) zze.zzbn();
    }

    public static zzhyh zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhkf zzb() {
        zzhkf zzhkfVar = this.zzc;
        return zzhkfVar == null ? zzhkf.zzh() : zzhkfVar;
    }

    public final zzhvi zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhkd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhkc(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzhkd.class) {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzh(zzhkf zzhkfVar) {
        zzhkfVar.getClass();
        this.zzc = zzhkfVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzi(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }
}
