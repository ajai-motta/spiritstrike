package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzicz extends zzhwo implements zzhya {
    private static final zzicz zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private String zzc = "";

    static {
        zzicz zziczVar = new zzicz();
        zzd = zziczVar;
        zzhwo.zzbu(zzicz.class, zziczVar);
    }

    private zzicz() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဈ\u0001", new Object[]{"zza", "zzb", zzicy.zza, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzicz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzicx(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzicz.class) {
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
