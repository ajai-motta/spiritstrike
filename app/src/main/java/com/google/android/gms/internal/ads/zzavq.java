package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzavq extends zzhwo implements zzhya {
    private static final zzavq zzf;
    private static volatile zzhyh zzg;
    private int zza;
    private zzhxa zzb = zzbM();
    private zzhvi zzc = zzhvi.zzb;
    private int zzd = 1;
    private int zze = 1;

    static {
        zzavq zzavqVar = new zzavq();
        zzf = zzavqVar;
        zzhwo.zzbu(zzavq.class, zzavqVar);
    }

    private zzavq() {
    }

    public static zzavp zza() {
        return (zzavp) zzf.zzbn();
    }

    final /* synthetic */ void zzb(zzhvi zzhviVar) {
        zzhxa zzhxaVar = this.zzb;
        if (!zzhxaVar.zza()) {
            this.zzb = zzhwo.zzbN(zzhxaVar);
        }
        this.zzb.add(zzhviVar);
    }

    final /* synthetic */ void zzc(zzhvi zzhviVar) {
        this.zza |= 1;
        this.zzc = zzhviVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzf, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001c\u0002ည\u0000\u0003᠌\u0001\u0004᠌\u0002", new Object[]{"zza", "zzb", "zzc", "zzd", zzavk.zza, "zze", zzavg.zza});
        }
        if (iOrdinal == 3) {
            return new zzavq();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzavp(bArr);
        }
        if (iOrdinal == 5) {
            return zzf;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzg;
        if (zzhwjVar == null) {
            synchronized (zzavq.class) {
                zzhwjVar = zzg;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzf);
                    zzg = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(int i) {
        this.zzd = 4;
        this.zza |= 2;
    }

    final /* synthetic */ void zzg(int i) {
        this.zze = i - 1;
        this.zza |= 4;
    }
}
