package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmb extends zzhwo implements zzhya {
    private static final zzhmb zzj;
    private static volatile zzhyh zzk;
    private int zza;
    private int zzb;
    private zzhmd zzc;
    private zzhvi zzd;
    private zzhvi zze;
    private zzhvi zzf;
    private zzhvi zzg;
    private zzhvi zzh;
    private zzhvi zzi;

    static {
        zzhmb zzhmbVar = new zzhmb();
        zzj = zzhmbVar;
        zzhwo.zzbu(zzhmb.class, zzhmbVar);
    }

    private zzhmb() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzd = zzhviVar;
        this.zze = zzhviVar;
        this.zzf = zzhviVar;
        this.zzg = zzhviVar;
        this.zzh = zzhviVar;
        this.zzi = zzhviVar;
    }

    public static zzhmb zzj(zzhvi zzhviVar, zzhvy zzhvyVar) throws zzhxd {
        return (zzhmb) zzhwo.zzbT(zzj, zzhviVar, zzhvyVar);
    }

    public static zzhma zzk() {
        return (zzhma) zzj.zzbn();
    }

    public static zzhyh zzl() {
        return zzj.zzbd();
    }

    public final int zza() {
        return this.zzb;
    }

    public final zzhmd zzb() {
        zzhmd zzhmdVar = this.zzc;
        return zzhmdVar == null ? zzhmd.zzh() : zzhmdVar;
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
            return zzbv(zzj, "\u0000\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001\u000b\u0002ဉ\u0000\u0003\n\u0004\n\u0005\n\u0006\n\u0007\n\b\n", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzhmb();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhma(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzk;
        if (zzhwjVar == null) {
            synchronized (zzhmb.class) {
                zzhwjVar = zzk;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzj);
                    zzk = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    public final zzhvi zze() {
        return this.zzf;
    }

    public final zzhvi zzg() {
        return this.zzg;
    }

    public final zzhvi zzh() {
        return this.zzh;
    }

    public final zzhvi zzi() {
        return this.zzi;
    }

    final /* synthetic */ void zzm(int i) {
        this.zzb = 0;
    }

    final /* synthetic */ void zzn(zzhmd zzhmdVar) {
        zzhmdVar.getClass();
        this.zzc = zzhmdVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzo(zzhvi zzhviVar) {
        this.zzd = zzhviVar;
    }

    final /* synthetic */ void zzp(zzhvi zzhviVar) {
        this.zze = zzhviVar;
    }

    final /* synthetic */ void zzq(zzhvi zzhviVar) {
        this.zzf = zzhviVar;
    }

    final /* synthetic */ void zzr(zzhvi zzhviVar) {
        this.zzg = zzhviVar;
    }

    final /* synthetic */ void zzs(zzhvi zzhviVar) {
        this.zzh = zzhviVar;
    }

    final /* synthetic */ void zzt(zzhvi zzhviVar) {
        this.zzi = zzhviVar;
    }
}
