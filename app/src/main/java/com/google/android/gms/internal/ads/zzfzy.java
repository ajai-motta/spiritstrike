package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzy extends zzhwo implements zzhya {
    private static final zzfzy zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private zzgaa zzb;
    private zzhvi zzc;
    private zzhvi zzd;
    private int zze;

    static {
        zzfzy zzfzyVar = new zzfzy();
        zzf = zzfzyVar;
        zzhwo.zzbu(zzfzy.class, zzfzyVar);
    }

    private zzfzy() {
        zzhvi zzhviVar = zzhvi.zzb;
        this.zzc = zzhviVar;
        this.zzd = zzhviVar;
    }

    public static zzfzx zzd() {
        return (zzfzx) zzf.zzbn();
    }

    public final zzgaa zza() {
        zzgaa zzgaaVar = this.zzb;
        return zzgaaVar == null ? zzgaa.zze() : zzgaaVar;
    }

    public final zzhvi zzb() {
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
            return zzbv(zzf, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002\u0004᠌\u0003", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", zzgao.zza});
        }
        if (iOrdinal == 3) {
            return new zzfzy();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfzx(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzfzy.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(zzgaa zzgaaVar) {
        zzgaaVar.getClass();
        this.zzb = zzgaaVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(zzhvi zzhviVar) {
        zzhviVar.getClass();
        this.zza |= 2;
        this.zzc = zzhviVar;
    }

    final /* synthetic */ void zzh(zzhvi zzhviVar) {
        zzhviVar.getClass();
        this.zza |= 4;
        this.zzd = zzhviVar;
    }

    public final int zzj() {
        int iZza = zzgap.zza(this.zze);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    final /* synthetic */ void zzk(int i) {
        this.zze = i - 1;
        this.zza |= 8;
    }
}
