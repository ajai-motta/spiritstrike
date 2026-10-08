package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbac extends zzhwo implements zzhya {
    private static final zzbac zze;
    private static volatile zzhyh zzf;
    private int zza;
    private zzbai zzb;
    private zzhvi zzc;
    private zzhvi zzd;

    static {
        zzbac zzbacVar = new zzbac();
        zze = zzbacVar;
        zzhwo.zzbu(zzbac.class, zzbacVar);
    }

    private zzbac() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzc = zzhviVar;
        this.zzd = zzhviVar;
    }

    public static zzbac zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzbac) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzbac zze(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzbac) zzhwo.zzbV(zze, bArr, zzhvyVar);
    }

    public final zzbai zza() {
        zzbai zzbaiVar = this.zzb;
        return zzbaiVar == null ? zzbai.zzj() : zzbaiVar;
    }

    public final zzhvi zzb() {
        return this.zzc;
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
            return zzbv(zze, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzbac();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbab(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzbac.class) {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
