package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhkf extends zzhwo implements zzhya {
    private static final zzhkf zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private int zzb;
    private zzhkb zzc;
    private zzhvi zzd;
    private zzhvi zze;

    static {
        zzhkf zzhkfVar = new zzhkf();
        zzf = zzhkfVar;
        zzhwo.zzbu(zzhkf.class, zzhkfVar);
    }

    private zzhkf() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzd = zzhviVar;
        this.zze = zzhviVar;
    }

    public static zzhkf zze(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhkf) zzhwo.zzbT(zzf, zzhviVar, zzhvyVar);
    }

    public static zzhke zzg() {
        return (zzhke) zzf.zzbn();
    }

    public static zzhkf zzh() {
        return zzf;
    }

    public static zzhyh zzi() {
        return zzf.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhkb zzb() {
        zzhkb zzhkbVar = this.zzc;
        return zzhkbVar == null ? zzhkb.zzc() : zzhkbVar;
    }

    public final zzhvi zzc() {
        return this.zzd;
    }

    public final zzhvi zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0000\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze"});
        }
        if (iOrdinal == 3) {
            return new zzhkf();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhke(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzhkf.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzj(zzhkb zzhkbVar) {
        zzhkbVar.getClass();
        this.zzc = zzhkbVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzk(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }

    final /* synthetic */ void zzl(zzhvi zzhviVar) {
        this.zze = zzhviVar;
    }
}
