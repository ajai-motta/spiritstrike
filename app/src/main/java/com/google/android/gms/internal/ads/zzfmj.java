package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfmj extends zzhwo implements zzhya {
    private static final zzfmj zzg;
    private static volatile zzhyh zzh;
    private int zzb;
    private int zzc;
    private boolean zzd;
    private boolean zzf;
    private String zza = "";
    private String zze = "";

    static {
        zzfmj zzfmjVar = new zzfmj();
        zzg = zzfmjVar;
        zzhwo.zzbu(zzfmj.class, zzfmjVar);
    }

    private zzfmj() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzg, "\u0004\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004\u0007\u0005Ȉ\u0006\u0007", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzfmj();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfmi(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzh;
        if (zzhwjVar == null) {
            synchronized (zzfmj.class) {
                zzhwjVar = zzh;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzg);
                    zzh = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
