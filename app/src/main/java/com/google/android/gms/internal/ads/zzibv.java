package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class zzibv extends zzhwo implements zzhya {
    private static final zzibv zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private zzibu zzc;
    private zzibu zzd;

    static {
        zzibv zzibvVar = new zzibv();
        zze = zzibvVar;
        zzhwo.zzbu(zzibv.class, zzibvVar);
    }

    private zzibv() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0003ဉ\u0002", new Object[]{"zza", "zzb", zzibs.zza, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzibv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzibr(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzibv.class) {
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
