package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
@Deprecated
public final class zzhlv extends zzhwo implements zzhya {
    public static final /* synthetic */ int zza = 0;
    private static final zzhlv zzd;
    private static volatile zzhyh zze;
    private String zzb = "";
    private zzhxa zzc = zzbM();

    static {
        zzhlv zzhlvVar = new zzhlv();
        zzd = zzhlvVar;
        zzhwo.zzbu(zzhlv.class, zzhlvVar);
    }

    private zzhlv() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002\u001b", new Object[]{"zzb", "zzc", zzhlc.class});
        }
        if (iOrdinal == 3) {
            return new zzhlv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhlu(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzhlv.class) {
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
