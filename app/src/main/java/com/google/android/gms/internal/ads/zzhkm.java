package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhkm extends zzhwo implements zzhya {
    private static final zzhkm zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzhvi zzb = zzhvi.zzb;

    static {
        zzhkm zzhkmVar = new zzhkm();
        zzc = zzhkmVar;
        zzhwo.zzbu(zzhkm.class, zzhkmVar);
    }

    private zzhkm() {
    }

    public static zzhkm zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhkm) zzhwo.zzbT(zzc, zzhviVar, zzhvyVar);
    }

    public static zzhkl zzd() {
        return (zzhkl) zzc.zzbn();
    }

    public static zzhkm zze() {
        return zzc;
    }

    public static zzhyh zzg() {
        return zzc.zzbd();
    }

    public final int zza() {
        return this.zza;
    }

    public final zzhvi zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhkm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhkl(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzhkm.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzh(zzhvi zzhviVar) {
        this.zzb = zzhviVar;
    }
}
