package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhiz extends zzhwo implements zzhya {
    private static final zzhiz zzd;
    private static volatile zzhyh zze;
    private int zza;
    private zzhjd zzb;
    private zzhks zzc;

    static {
        zzhiz zzhizVar = new zzhiz();
        zzd = zzhizVar;
        zzhwo.zzbu(zzhiz.class, zzhizVar);
    }

    private zzhiz() {
    }

    public static zzhiz zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhiz) zzhwo.zzbT(zzd, zzhviVar, zzhvyVar);
    }

    public static zzhiy zzd() {
        return (zzhiy) zzd.zzbn();
    }

    public final zzhjd zza() {
        zzhjd zzhjdVar = this.zzb;
        return zzhjdVar == null ? zzhjd.zzd() : zzhjdVar;
    }

    public final zzhks zzb() {
        zzhks zzhksVar = this.zzc;
        return zzhksVar == null ? zzhks.zzg() : zzhksVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhiz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhiy(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzhiz.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(zzhjd zzhjdVar) {
        zzhjdVar.getClass();
        this.zzb = zzhjdVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(zzhks zzhksVar) {
        zzhksVar.getClass();
        this.zzc = zzhksVar;
        this.zza |= 2;
    }
}
