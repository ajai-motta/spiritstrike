package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhmh extends zzhwo implements zzhya {
    private static final zzhmh zzd;
    private static volatile zzhyh zze;
    private int zza;
    private int zzb;
    private int zzc;

    static {
        zzhmh zzhmhVar = new zzhmh();
        zzd = zzhmhVar;
        zzhwo.zzbu(zzhmh.class, zzhmhVar);
    }

    private zzhmh() {
    }

    public static zzhmg zzd() {
        return (zzhmg) zzd.zzbn();
    }

    public static zzhmh zze() {
        return zzd;
    }

    public final zzhko zza() {
        zzhko zzhkoVarZzb = zzhko.zzb(this.zza);
        return zzhkoVarZzb == null ? zzhko.UNRECOGNIZED : zzhkoVarZzb;
    }

    public final zzhko zzb() {
        zzhko zzhkoVarZzb = zzhko.zzb(this.zzb);
        return zzhkoVarZzb == null ? zzhko.UNRECOGNIZED : zzhkoVarZzb;
    }

    public final int zzc() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u0003\u0004", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhmh();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhmg(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzhmh.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zzg(zzhko zzhkoVar) {
        this.zza = zzhkoVar.zza();
    }

    final /* synthetic */ void zzh(zzhko zzhkoVar) {
        this.zzb = zzhkoVar.zza();
    }

    final /* synthetic */ void zzi(int i) {
        this.zzc = i;
    }
}
