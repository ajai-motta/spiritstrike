package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzide extends zzhwo implements zzhya {
    private static final zzide zzh;
    private static volatile zzhyh zzi;
    private int zza;
    private int zzb;
    private int zze;
    private String zzc = "";
    private zzhww zzd = zzbC();
    private zzhxa zzf = zzbM();
    private zzhvi zzg = zzhvi.zzb;

    static {
        zzide zzideVar = new zzide();
        zzh = zzideVar;
        zzhwo.zzbu(zzide.class, zzideVar);
    }

    private zzide() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzh, "\u0001\u0006\u0000\u0001\u0001\u0007\u0006\u0000\u0002\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u0016\u0005င\u0002\u0006\u001b\u0007ည\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", zzidc.class, "zzg"});
        }
        if (iOrdinal == 3) {
            return new zzide();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzidd(bArr);
        }
        if (iOrdinal == 5) {
            return zzh;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzi;
        if (zzhwjVar == null) {
            synchronized (zzide.class) {
                zzhwjVar = zzi;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzh);
                    zzi = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
