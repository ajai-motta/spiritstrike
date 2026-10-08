package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzict extends zzhwo implements zzhya {
    private static final zzict zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzict zzictVar = new zzict();
        zzd = zzictVar;
        zzhwo.zzbu(zzict.class, zzictVar);
    }

    private zzict() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzhwu zzhwuVar = zzics.zza;
            return zzbv(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zza", "zzb", zzhwuVar, "zzc", zzhwuVar});
        }
        if (iOrdinal == 3) {
            return new zzict();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzicr(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzict.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
