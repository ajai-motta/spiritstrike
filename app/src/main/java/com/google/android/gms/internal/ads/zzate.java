package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzate extends zzhwo implements zzhya {
    private static final zzate zzj;
    private static volatile zzhyh zzk;
    private int zza;
    private int zzb;
    private boolean zze;
    private zzatv zzg;
    private zzaub zzh;
    private boolean zzi;
    private boolean zzc = true;
    private String zzd = "unknown_host";
    private boolean zzf = true;

    static {
        zzate zzateVar = new zzate();
        zzj = zzateVar;
        zzhwo.zzbu(zzate.class, zzateVar);
    }

    private zzate() {
    }

    public static zzatd zze() {
        return (zzatd) zzj.zzbn();
    }

    public final String zza() {
        return this.zzd;
    }

    @Deprecated
    public final boolean zzb() {
        return this.zze;
    }

    public final zzatv zzc() {
        zzatv zzatvVar = this.zzg;
        return zzatvVar == null ? zzatv.zzg() : zzatvVar;
    }

    public final zzaub zzd() {
        zzaub zzaubVar = this.zzh;
        return zzaubVar == null ? zzaub.zza() : zzaubVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzj, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဉ\u0005\u0007ဉ\u0006\bဇ\u0007", new Object[]{"zza", "zzb", zzath.zza, "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (iOrdinal == 3) {
            return new zzate();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzatd(bArr);
        }
        if (iOrdinal == 5) {
            return zzj;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzk;
        if (zzhwjVar == null) {
            synchronized (zzate.class) {
                zzhwjVar = zzk;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzj);
                    zzk = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzg(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    final /* synthetic */ void zzh(boolean z) {
        this.zza |= 8;
        this.zze = z;
    }
}
