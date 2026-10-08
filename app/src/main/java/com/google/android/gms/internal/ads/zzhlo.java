package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhlo extends zzhwo implements zzhya {
    private static final zzhlo zzb;
    private static volatile zzhyh zzc;
    private String zza = "";

    static {
        zzhlo zzhloVar = new zzhlo();
        zzb = zzhloVar;
        zzhwo.zzbu(zzhlo.class, zzhloVar);
    }

    private zzhlo() {
    }

    public static zzhlo zzb(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlo) zzhwo.zzbT(zzb, zzhviVar, zzhvyVar);
    }

    public static zzhln zzc() {
        return (zzhln) zzb.zzbn();
    }

    public static zzhlo zzd() {
        return zzb;
    }

    public final String zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhlo();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhln(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzc;
        if (zzhwjVar == null) {
            synchronized (zzhlo.class) {
                zzhwjVar = zzc;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzb);
                    zzc = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza = str;
    }
}
