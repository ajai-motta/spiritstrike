package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzbai extends zzhwo implements zzhya {
    private static final zzbai zzg;
    private static volatile zzhyh zzh;
    private int zza;
    private String zzb = "";
    private String zzc = "";
    private long zzd;
    private long zze;
    private long zzf;

    static {
        zzbai zzbaiVar = new zzbai();
        zzg = zzbaiVar;
        zzhwo.zzbu(zzbai.class, zzbaiVar);
    }

    private zzbai() {
    }

    public static zzbai zzg(zzhvi zzhviVar) throws zzhxd {
        return (zzbai) zzhwo.zzbS(zzg, zzhviVar);
    }

    public static zzbai zzh(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzbai) zzhwo.zzbT(zzg, zzhviVar, zzhvyVar);
    }

    public static zzbah zzi() {
        return (zzbah) zzg.zzbn();
    }

    public static zzbai zzj() {
        return zzg;
    }

    public final String zza() {
        return this.zzb;
    }

    public final String zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzd;
    }

    public final long zzd() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzg, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf"});
        }
        if (iOrdinal == 3) {
            return new zzbai();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzbah(bArr);
        }
        if (iOrdinal == 5) {
            return zzg;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzh;
        if (zzhwjVar == null) {
            synchronized (zzbai.class) {
                zzhwjVar = zzh;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzg);
                    zzh = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    public final long zze() {
        return this.zzf;
    }

    final /* synthetic */ void zzk(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzb = str;
    }

    final /* synthetic */ void zzl(String str) {
        str.getClass();
        this.zza |= 2;
        this.zzc = str;
    }

    final /* synthetic */ void zzm(long j) {
        this.zza |= 4;
        this.zzd = j;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 8;
        this.zze = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 16;
        this.zzf = j;
    }
}
