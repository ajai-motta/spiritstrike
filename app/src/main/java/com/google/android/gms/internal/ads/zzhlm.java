package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhlm extends zzhwo implements zzhya {
    private static final zzhlm zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private zzhlo zzc;

    static {
        zzhlm zzhlmVar = new zzhlm();
        zzd = zzhlmVar;
        zzhwo.zzbu(zzhlm.class, zzhlmVar);
    }

    private zzhlm() {
    }

    public static zzhlm zzc(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlm) zzhwo.zzbT(zzd, zzhviVar, zzhvyVar);
    }

    public static zzhll zzd() {
        return (zzhll) zzd.zzbn();
    }

    public static zzhyh zze() {
        return zzd.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhlo zzb() {
        zzhlo zzhloVar = this.zzc;
        return zzhloVar == null ? zzhlo.zzd() : zzhloVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhlm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhll(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzhlm.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzg(zzhlo zzhloVar) {
        zzhloVar.getClass();
        this.zzc = zzhloVar;
        this.zza |= 1;
    }
}
