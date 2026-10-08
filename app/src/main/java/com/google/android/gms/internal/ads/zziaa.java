package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zziaa extends zzhwo implements zzhya {
    private static final zziaa zzc;
    private static volatile zzhyh zzd;
    private int zza;
    private String zzb = "";

    static {
        zziaa zziaaVar = new zziaa();
        zzc = zziaaVar;
        zzhwo.zzbu(zziaa.class, zziaaVar);
    }

    private zziaa() {
    }

    public static zzhzz zzc() {
        return (zzhzz) zzc.zzbn();
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"zza", "zzb"});
        }
        if (iOrdinal == 3) {
            return new zziaa();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhzz(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zziaa.class) {
                zzhwjVar = zzd;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzc);
                    zzd = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zza = 15;
    }
}
