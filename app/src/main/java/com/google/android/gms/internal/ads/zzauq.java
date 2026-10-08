package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzauq extends zzhwo implements zzhya {
    private static final zzauq zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private long zzc = -1;

    static {
        zzauq zzauqVar = new zzauq();
        zzd = zzauqVar;
        zzhwo.zzbu(zzauq.class, zzauqVar);
    }

    private zzauq() {
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002ဂ\u0001", new Object[]{"zza", "zzb", zzaug.zza, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzauq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzaup(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzauq.class) {
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
