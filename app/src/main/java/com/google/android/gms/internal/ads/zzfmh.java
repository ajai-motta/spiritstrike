package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfmh extends zzhwo implements zzhya {
    private static final zzfmh zzc;
    private static volatile zzhyh zzd;
    private zzhxa zza = zzbM();
    private long zzb;

    static {
        zzfmh zzfmhVar = new zzfmh();
        zzc = zzfmhVar;
        zzhwo.zzbu(zzfmh.class, zzfmhVar);
    }

    private zzfmh() {
    }

    public static zzfmg zza() {
        return (zzfmg) zzc.zzbn();
    }

    final /* synthetic */ void zzb(zzflb zzflbVar) {
        zzflbVar.getClass();
        zzhxa zzhxaVar = this.zza;
        if (!zzhxaVar.zza()) {
            this.zza = zzhwo.zzbN(zzhxaVar);
        }
        this.zza.add(zzflbVar);
    }

    final /* synthetic */ void zzc(long j) {
        this.zzb = j;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzc, "\u0004\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002\u0002", new Object[]{"zza", zzflb.class, "zzb"});
        }
        if (iOrdinal == 3) {
            return new zzfmh();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfmg(bArr);
        }
        if (iOrdinal == 5) {
            return zzc;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzd;
        if (zzhwjVar == null) {
            synchronized (zzfmh.class) {
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
