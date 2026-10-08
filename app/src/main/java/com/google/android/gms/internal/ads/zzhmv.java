package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmv extends zzhwo implements zzhya {
    private static final zzhmv zzb;
    private static volatile zzhyh zzc;
    private int zza;

    static {
        zzhmv zzhmvVar = new zzhmv();
        zzb = zzhmvVar;
        zzhwo.zzbu(zzhmv.class, zzhmvVar);
    }

    private zzhmv() {
    }

    public static zzhmv zzb(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhmv) zzhwo.zzbT(zzb, zzhviVar, zzhvyVar);
    }

    public static zzhmv zzc() {
        return zzb;
    }

    public final int zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhmv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhmu(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzc;
        if (zzhwjVar == null) {
            synchronized (zzhmv.class) {
                zzhwjVar = zzc;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzb);
                    zzc = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
