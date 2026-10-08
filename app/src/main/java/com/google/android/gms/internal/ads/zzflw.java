package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzflw extends zzhwo implements zzhya {
    private static final zzflw zzb;
    private static volatile zzhyh zzc;
    private zzhxa zza = zzbM();

    static {
        zzflw zzflwVar = new zzflw();
        zzb = zzflwVar;
        zzhwo.zzbu(zzflw.class, zzflwVar);
    }

    private zzflw() {
    }

    public static zzflt zzb() {
        return (zzflt) zzb.zzbn();
    }

    public final int zza() {
        return this.zza.size();
    }

    final /* synthetic */ void zzc(zzflv zzflvVar) {
        zzflvVar.getClass();
        zzhxa zzhxaVar = this.zza;
        if (!zzhxaVar.zza()) {
            this.zza = zzhwo.zzbN(zzhxaVar);
        }
        this.zza.add(zzflvVar);
    }

    final /* synthetic */ void zzd() {
        this.zza = zzbM();
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzb, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zza", zzflv.class});
        }
        if (iOrdinal == 3) {
            return new zzflw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzflt(bArr);
        }
        if (iOrdinal == 5) {
            return zzb;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzc;
        if (zzhwjVar == null) {
            synchronized (zzflw.class) {
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
