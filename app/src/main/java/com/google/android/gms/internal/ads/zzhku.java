package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhku extends zzhwo implements zzhya {
    private static final zzhku zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private int zzb;

    static {
        zzhku zzhkuVar = new zzhku();
        zzc = zzhkuVar;
        zzhwo.zzbu(zzhku.class, zzhkuVar);
    }

    private zzhku() {
    }

    public static zzhkt zzc() {
        return (zzhkt) zzc.zzbn();
    }

    public static zzhku zzd() {
        return zzc;
    }

    public final zzhko zza() {
        zzhko zzhkoVarZzb = zzhko.zzb(this.zza);
        return zzhkoVarZzb == null ? zzhko.UNRECOGNIZED : zzhkoVarZzb;
    }

    public final int zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002\u000b", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzhku();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhkt(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzhku.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(zzhko zzhkoVar) {
        this.zza = zzhkoVar.zza();
    }

    final /* synthetic */ void zzg(int i) {
        this.zzb = i;
    }
}
