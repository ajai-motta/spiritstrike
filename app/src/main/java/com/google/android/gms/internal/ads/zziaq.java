package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zziaq extends zzhwo implements zzhya {
    private static final zziaq zze;
    private static volatile zzhyh zzf;
    private int zza;
    private int zzb;
    private long zzc;
    private zzhvi zzd = zzhvi.zzb;

    static {
        zziaq zziaqVar = new zziaq();
        zze = zziaqVar;
        zzhwo.zzbu(zziaq.class, zziaqVar);
    }

    private zziaq() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zze, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001\u0003ည\u0002", new Object[]{"zza", "zzb", zziap.zza, "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zziaq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziao(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zziaq.class) {
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
