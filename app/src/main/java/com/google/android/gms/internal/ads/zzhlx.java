package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhlx extends zzhwo implements zzhya {
    private static final zzhlx zze;
    private static volatile zzhyh zzf;
    private int zza;
    private zzhlz zzb;
    private int zzc;
    private zzhvi zzd = zzhvi.zzb;

    static {
        zzhlx zzhlxVar = new zzhlx();
        zze = zzhlxVar;
        zzhwo.zzbu(zzhlx.class, zzhlxVar);
    }

    private zzhlx() {
    }

    public static zzhlx zzd(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhlx) zzhwo.zzbT(zze, zzhviVar, zzhvyVar);
    }

    public static zzhlw zze() {
        return (zzhlw) zze.zzbn();
    }

    public final zzhlz zza() {
        zzhlz zzhlzVar = this.zzb;
        return zzhlzVar == null ? zzhlz.zzc() : zzhlzVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final zzhvi zzc() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zze, "\u0000\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b\u0003\n", new Object[]{"zza", "zzb", "zzc", "zzd"});
        }
        if (iOrdinal == 3) {
            return new zzhlx();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhlw(bArr);
        }
        if (iOrdinal == 5) {
            return zze;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzf;
        if (zzhwjVar == null) {
            synchronized (zzhlx.class) {
                zzhwjVar = zzf;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zze);
                    zzf = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzg(zzhlz zzhlzVar) {
        zzhlzVar.getClass();
        this.zzb = zzhlzVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzh(int i) {
        this.zzc = i;
    }

    final /* synthetic */ void zzi(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }
}
