package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhlz extends zzhwo implements zzhya {
    private static final zzhlz zzb;
    private static volatile zzhyh zzc;
    private int zza;

    static {
        zzhlz zzhlzVar = new zzhlz();
        zzb = zzhlzVar;
        zzhwo.zzbu(zzhlz.class, zzhlzVar);
    }

    private zzhlz() {
    }

    public static zzhly zzb() {
        return (zzhly) zzb.zzbn();
    }

    public static zzhlz zzc() {
        return zzb;
    }

    public final zzhko zza() {
        zzhko zzhkoVarZzb = zzhko.zzb(this.zza);
        return zzhkoVarZzb == null ? zzhko.UNRECOGNIZED : zzhkoVarZzb;
    }

    final /* synthetic */ void zzd(zzhko zzhkoVar) {
        this.zza = zzhkoVar.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zza"});
        }
        if (iOrdinal == 3) {
            return new zzhlz();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhly(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzc;
        if (zzhwjVar == null) {
            synchronized (zzhlz.class) {
                zzhwjVar = zzc;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzb);
                    zzc = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
