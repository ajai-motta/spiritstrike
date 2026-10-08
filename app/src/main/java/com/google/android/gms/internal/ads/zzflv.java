package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzflv extends zzhwo implements zzhya {
    private static final zzflv zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzfls zzb;

    static {
        zzflv zzflvVar = new zzflv();
        zzc = zzflvVar;
        zzhwo.zzbu(zzflv.class, zzflvVar);
    }

    private zzflv() {
    }

    public static zzflu zza() {
        return (zzflu) zzc.zzbn();
    }

    final /* synthetic */ void zzb(zzfls zzflsVar) {
        zzflsVar.getClass();
        this.zzb = zzflsVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0004\u0001\u0000\u0001\u0006\u0006\u0001\u0000\u0000\u0000\u0006ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzflv();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzflu(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzflv.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
