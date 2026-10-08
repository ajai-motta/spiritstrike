package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzhjd extends zzhwo implements zzhya {
    private static final zzhjd zzd;
    private static volatile zzhyh zze;
    private int zza;
    private zzhjf zzb;
    private int zzc;

    static {
        zzhjd zzhjdVar = new zzhjd();
        zzd = zzhjdVar;
        zzhwo.zzbu(zzhjd.class, zzhjdVar);
    }

    private zzhjd() {
    }

    public static zzhjc zzc() {
        return (zzhjc) zzd.zzbn();
    }

    public static zzhjd zzd() {
        return zzd;
    }

    public final zzhjf zza() {
        zzhjf zzhjfVar = this.zzb;
        return zzhjfVar == null ? zzhjf.zzc() : zzhjfVar;
    }

    public final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzd, "\u0000\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002\u000b", new Object[]{"zza", "zzb", "zzc"});
        }
        if (iOrdinal == 3) {
            return new zzhjd();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzhjc(bArr);
        }
        if (iOrdinal == 5) {
            return zzd;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zze;
        if (zzhwjVar == null) {
            synchronized (zzhjd.class) {
                zzhwjVar = zze;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzd);
                    zze = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(zzhjf zzhjfVar) {
        zzhjfVar.getClass();
        this.zzb = zzhjfVar;
        this.zza |= 1;
    }

    final /* synthetic */ void zzg(int i) {
        this.zzc = i;
    }
}
