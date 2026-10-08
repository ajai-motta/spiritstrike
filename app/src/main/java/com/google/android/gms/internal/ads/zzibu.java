package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzibu extends zzhwo implements zzhya {
    private static final zzibu zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private boolean zzc;
    private int zzd;

    static {
        zzibu zzibuVar = new zzibu();
        zze = zzibuVar;
        zzhwo.zzbu(zzibu.class, zzibuVar);
    }

    private zzibu() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzhwu zzhwuVar = zzibs.zza;
            return zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002", new Object[]{"zza", "zzb", zzhwuVar, "zzc", "zzd", zzhwuVar});
        }
        if (iOrdinal == 3) {
            return new zzibu();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzibt(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzibu.class) {
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
