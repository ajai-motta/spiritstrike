package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzazy extends zzhwo implements zzhya {
    private static final zzazy zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzbae zzb;

    static {
        zzazy zzazyVar = new zzazy();
        zzc = zzazyVar;
        zzhwo.zzbu(zzazy.class, zzazyVar);
    }

    private zzazy() {
    }

    public static zzazy zzb(byte[] bArr, zzhvy zzhvyVar) throws zzhxd {
        return (zzazy) zzhwo.zzbV(zzc, bArr, zzhvyVar);
    }

    public final zzbae zza() {
        zzbae zzbaeVar = this.zzb;
        return zzbaeVar == null ? zzbae.zze() : zzbaeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0004\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzazy();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzazx(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzazy.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
