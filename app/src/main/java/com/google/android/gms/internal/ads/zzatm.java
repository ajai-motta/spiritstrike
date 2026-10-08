package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzatm extends zzhwo implements zzhya {
    private static final zzatm zzo;
    private static volatile zzhyh zzp;
    private int zza;
    private long zzc;
    private long zzg;
    private long zzh;
    private long zzj;
    private int zzn;
    private String zzb = "";
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzi = "";
    private String zzk = "";
    private String zzl = "";
    private zzhxa zzm = zzbM();

    static {
        zzatm zzatmVar = new zzatm();
        zzo = zzatmVar;
        zzhwo.zzbu(zzatm.class, zzatmVar);
    }

    private zzatm() {
    }

    public static zzati zza() {
        return (zzati) zzo.zzbn();
    }

    final /* synthetic */ void zzb(String str) {
        str.getClass();
        this.zza |= 1;
        this.zzb = str;
    }

    final /* synthetic */ void zzc(long j) {
        this.zza |= 2;
        this.zzc = j;
    }

    final /* synthetic */ void zzd(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzo, "\u0004\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\r᠌\u000b", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", "zzm", zzatk.class, "zzn", zzatl.zza});
        }
        if (iOrdinal == 3) {
            return new zzatm();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzati(bArr);
        }
        if (iOrdinal == 5) {
            return zzo;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzp;
        if (zzhwjVar == null) {
            synchronized (zzatm.class) {
                zzhwjVar = zzp;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzo);
                    zzp = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(String str) {
        str.getClass();
        this.zza |= 8;
        this.zze = str;
    }

    final /* synthetic */ void zzg(String str) {
        this.zza |= 16;
        this.zzf = str;
    }

    final /* synthetic */ void zzh(String str) {
        this.zza |= 1024;
        this.zzl = str;
    }

    final /* synthetic */ void zzj(int i) {
        this.zzn = i - 1;
        this.zza |= 2048;
    }
}
