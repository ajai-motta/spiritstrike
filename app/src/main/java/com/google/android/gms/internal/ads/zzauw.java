package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzauw extends zzhwo implements zzhya {
    private static final zzauw zzA;
    private static volatile zzhyh zzB;
    private int zza;
    private long zzu;
    private long zzv;
    private long zzb = -1;
    private long zzc = -1;
    private long zzd = -1;
    private long zze = -1;
    private long zzf = -1;
    private long zzg = -1;
    private int zzh = 1000;
    private long zzi = -1;
    private long zzj = -1;
    private long zzk = -1;
    private int zzl = 1000;
    private long zzm = -1;
    private long zzn = -1;
    private long zzo = -1;
    private long zzp = -1;
    private long zzw = -1;
    private long zzx = -1;
    private long zzy = -1;
    private long zzz = -1;

    static {
        zzauw zzauwVar = new zzauw();
        zzA = zzauwVar;
        zzhwo.zzbu(zzauw.class, zzauwVar);
    }

    private zzauw() {
    }

    public static zzauv zza() {
        return (zzauv) zzA.zzbn();
    }

    final /* synthetic */ void zzb(long j) {
        this.zza |= 1;
        this.zzb = j;
    }

    final /* synthetic */ void zzc(long j) {
        this.zza |= 2;
        this.zzc = j;
    }

    final /* synthetic */ void zzd(long j) {
        this.zza |= 4;
        this.zzd = j;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            zzhwu zzhwuVar = zzavh.zza;
            return zzbv(zzA, "\u0001\u0015\u0000\u0001\u0001\u0015\u0015\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဂ\u0003\u0005ဂ\u0004\u0006ဂ\u0005\u0007᠌\u0006\bဂ\u0007\tဂ\b\nဂ\t\u000b᠌\n\fဂ\u000b\rဂ\f\u000eဂ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဂ\u0010\u0012ဂ\u0011\u0013ဂ\u0012\u0014ဂ\u0013\u0015ဂ\u0014", new Object[]{"zza", "zzb", "zzc", "zzd", "zze", "zzf", "zzg", "zzh", zzhwuVar, "zzi", "zzj", "zzk", "zzl", zzhwuVar, "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzw", "zzx", "zzy", "zzz"});
        }
        if (iOrdinal == 3) {
            return new zzauw();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzauv(bArr);
        }
        if (iOrdinal == 5) {
            return zzA;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzB;
        if (zzhwjVar == null) {
            synchronized (zzauw.class) {
                zzhwjVar = zzB;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzA);
                    zzB = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    final /* synthetic */ void zze(long j) {
        this.zza |= 8;
        this.zze = j;
    }

    final /* synthetic */ void zzg() {
        this.zza &= -9;
        this.zze = -1L;
    }

    final /* synthetic */ void zzh(long j) {
        this.zza |= 16;
        this.zzf = j;
    }

    final /* synthetic */ void zzi(long j) {
        this.zza |= 32;
        this.zzg = j;
    }

    final /* synthetic */ void zzj(long j) {
        this.zza |= 128;
        this.zzi = j;
    }

    final /* synthetic */ void zzk(long j) {
        this.zza |= 256;
        this.zzj = j;
    }

    final /* synthetic */ void zzl(long j) {
        this.zza |= 512;
        this.zzk = j;
    }

    final /* synthetic */ void zzm(long j) {
        this.zza |= 2048;
        this.zzm = j;
    }

    final /* synthetic */ void zzn(long j) {
        this.zza |= 4096;
        this.zzn = j;
    }

    final /* synthetic */ void zzo(long j) {
        this.zza |= 8192;
        this.zzo = j;
    }

    final /* synthetic */ void zzp(long j) {
        this.zza |= 16384;
        this.zzp = j;
    }

    final /* synthetic */ void zzq(long j) {
        this.zza |= 32768;
        this.zzu = j;
    }

    final /* synthetic */ void zzr(long j) {
        this.zza |= 65536;
        this.zzv = j;
    }

    final /* synthetic */ void zzs(long j) {
        this.zza |= 131072;
        this.zzw = j;
    }

    final /* synthetic */ void zzt(long j) {
        this.zza |= 262144;
        this.zzx = j;
    }

    final /* synthetic */ void zzv(int i) {
        this.zzh = i - 1;
        this.zza |= 64;
    }

    final /* synthetic */ void zzw(int i) {
        this.zzl = i - 1;
        this.zza |= 1024;
    }
}
