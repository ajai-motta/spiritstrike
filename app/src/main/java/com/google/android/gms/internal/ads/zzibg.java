package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzibg extends zzhwo implements zzhya {
    private static final zzibg zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private int zzb;
    private int zzc;
    private boolean zzd;
    private long zze;

    static {
        zzibg zzibgVar = new zzibg();
        zzf = zzibgVar;
        zzhwo.zzbu(zzibg.class, zzibgVar);
    }

    private zzibg() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003ဇ\u0002\u0004ဂ\u0003", new Object[]{"zza", "zzb", zzibf.zza, "zzc", zzibd.zza, "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzibg();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzibe(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzibg.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
