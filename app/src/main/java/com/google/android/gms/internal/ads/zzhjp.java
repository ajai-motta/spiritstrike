package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhjp extends zzhwo implements zzhya {
    private static final zzhjp zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private int zzb;

    static {
        zzhjp zzhjpVar = new zzhjp();
        zzc = zzhjpVar;
        zzhwo.zzbu(zzhjp.class, zzhjpVar);
    }

    private zzhjp() {
    }

    public static zzhjp zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhjp) zzhwo.zzbT(zzc, zzhviVar, zzhvyVar);
    }

    public static zzhjo zzd() {
        return (zzhjo) zzc.zzbn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhjp();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhjo(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzhjp.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zza = i;
    }
}
