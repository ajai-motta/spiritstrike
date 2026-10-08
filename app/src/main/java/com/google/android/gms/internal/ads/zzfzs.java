package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfzs extends zzhwo implements zzhya {
    private static final zzfzs zzd;
    private static volatile zzhyh zze;
    private int zza;
    private zzhxa zzb = zzbM();
    private zziaa zzc;

    static {
        zzfzs zzfzsVar = new zzfzs();
        zzd = zzfzsVar;
        zzhwo.zzbu(zzfzs.class, zzfzsVar);
    }

    private zzfzs() {
    }

    public static zzfzr zza() {
        return (zzfzr) zzd.zzbn();
    }

    final /* synthetic */ void zzb(zzfzq zzfzqVar) {
        zzfzqVar.getClass();
        zzhxa zzhxaVar = this.zzb;
        if (!zzhxaVar.zza()) {
            this.zzb = zzhwo.zzbN(zzhxaVar);
        }
        this.zzb.add(zzfzqVar);
    }

    final /* synthetic */ void zzc(zziaa zziaaVar) {
        zziaaVar.getClass();
        this.zzc = zziaaVar;
        this.zza |= 1;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zza", "zzb", zzfzq.class, "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzfzs();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfzr(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzfzs.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }
}
