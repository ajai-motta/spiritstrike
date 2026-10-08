package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzied extends zzhwo implements zzhya {
    private static final zzied zzl;
    private static volatile zzhyh zzm;
    private int zza;
    private long zzd;
    private zzief zzi;
    private zzieh zzj;
    private zzhtd zzk;
    private zzhvi zzb = zzhvi.zzb;
    private zzhww zzc = zzbC();
    private zzhww zze = zzbC();
    private zzhxa zzf = zzhwo.zzbM();
    private String zzg = "";
    private zzhxa zzh = zzbM();

    static {
        zzied zziedVar = new zzied();
        zzl = zziedVar;
        zzhwo.zzbu(zzied.class, zziedVar);
    }

    private zzied() {
    }

    public static zzied zzc(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzied) zzhwo.zzbV(zzl, bArr, zzhvyVar);
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzl, "\u0001\n\u0000\u0001\u0001\u000f\n\u0000\u0004\u0000\u0001'\u0002ဂ\u0001\u0003'\u0004\u001b\u0005ဉ\u0003\u0007ဈ\u0002\tဉ\u0004\n\u001a\rည\u0000\u000fဉ\u0005", new Object[]{"zza", "zzc", "zzd", "zze", "zzh", zzids.class, "zzi", "zzg", "zzj", "zzf", "zzb", "zzk"});
        }
        if (iOrdinal == 3) {
            return new zzied();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zziec(bArr);
        }
        if (iOrdinal == 5) {
            return zzl;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzm;
        if (zzhwjVar == null) {
            synchronized (zzied.class) {
                zzhwjVar = zzm;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzl);
                    zzm = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
