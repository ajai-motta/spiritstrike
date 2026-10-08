package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhjh extends zzhwo implements zzhya {
    private static final zzhjh zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private zzhjl zzc;
    private zzhvi zzd = zzhvi.zzb;

    static {
        zzhjh zzhjhVar = new zzhjh();
        zze = zzhjhVar;
        zzhwo.zzbu(zzhjh.class, zzhjhVar);
    }

    private zzhjh() {
    }

    public static zzhjh zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhjh) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhjg zze() {
        return (zzhjg) zze.zzbn();
    }

    public static zzhyh zzg() {
        return zze.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhjl zzb() {
        zzhjl zzhjlVar = this.zzc;
        return zzhjlVar == null ? zzhjl.zzc() : zzhjlVar;
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
            return new zzhjh();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhjg(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzhjh.class) {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzh(zzhjl zzhjlVar) {
        zzhjlVar.getClass();
        this.zzc = zzhjlVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzi(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }
}
