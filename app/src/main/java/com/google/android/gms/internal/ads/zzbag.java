package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbag extends zzhwo implements zzhya {
    private static final zzbag zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private zzbak zzb;
    private zzhvi zzc = zzhvi.zzb;
    private long zzd;
    private long zze;

    static {
        zzbag zzbagVar = new zzbag();
        zzf = zzbagVar;
        zzhwo.zzbu(zzbag.class, zzbagVar);
    }

    private zzbag() {
    }

    public static zzbag zzc() {
        return zzf;
    }

    public final zzhvi zza() {
        return this.zzc;
    }

    public final long zzb() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ဂ\u0002\u0004ဂ\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzbag();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbaf(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzbag.class) {
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
