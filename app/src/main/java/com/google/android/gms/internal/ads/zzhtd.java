package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhtd extends zzhwo implements zzhya {
    private static final zzhtd zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private zzhvi zzb = zzhvi.zzb;
    private String zzc = "";
    private zzhxa zzd = zzbM();
    private boolean zze;

    static {
        zzhtd zzhtdVar = new zzhtd();
        zzf = zzhtdVar;
        zzhwo.zzbu(zzhtd.class, zzhtdVar);
    }

    private zzhtd() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ည\u0000\u0002\u001c\u0003ဇ\u0002\u0004ဈ\u0001", new Object[]{"zza", "zzb", "zzd", "zze", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhtd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhtc(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzhtd.class) {
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
