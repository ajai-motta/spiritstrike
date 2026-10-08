package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzq extends zzhwo implements zzhya {
    private static final zzfzq zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private zzatg zzb;

    static {
        zzfzq zzfzqVar = new zzfzq();
        zzc = zzfzqVar;
        zzhwo.zzbu(zzfzq.class, zzfzqVar);
    }

    private zzfzq() {
    }

    public static zzfzp zza() {
        return (zzfzp) zzc.zzbn();
    }

    final /* synthetic */ void zzb(zzatg zzatgVar) {
        zzatgVar.getClass();
        this.zzb = zzatgVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0004\u0001\u0000\u0001\u0012\u0012\u0001\u0000\u0000\u0000\u0012ဉ\u0000", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfzq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfzp(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzfzq.class) {
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
