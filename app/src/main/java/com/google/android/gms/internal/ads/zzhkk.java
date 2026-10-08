package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhkk extends zzhwo implements zzhya {
    private static final zzhkk zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private zzhvi zzc = zzhvi.zzb;
    private zzhkm zzd;

    static {
        zzhkk zzhkkVar = new zzhkk();
        zze = zzhkkVar;
        zzhwo.zzbu(zzhkk.class, zzhkkVar);
    }

    private zzhkk() {
    }

    public static zzhkk zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhkk) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhkj zze() {
        return (zzhkj) zze.zzbn();
    }

    public static zzhyh zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhvi zzb() {
        return this.zzc;
    }

    public final zzhkm zzc() {
        zzhkm zzhkmVar = this.zzd;
        return zzhkmVar == null ? zzhkm.zze() : zzhkmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\n\u0003ဉ\u0000", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhkk();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhkj(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzhkk.class) {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzh(zzhvi zzhviVar) {
        this.zzc = zzhviVar;
    }

    final /* synthetic */ void zzi(zzhkm zzhkmVar) {
        zzhkmVar.getClass();
        this.zzd = zzhkmVar;
        this.zza |= 1;
    }
}
