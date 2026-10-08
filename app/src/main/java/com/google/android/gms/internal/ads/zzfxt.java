package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzfxt extends zzhwo implements zzhya {
    private static final zzfxt zzx;
    private static volatile zzhyh zzy;
    private int zza;
    private int zzb;
    private boolean zze;
    private zzfyl zzf;
    private boolean zzg;
    private zzfyn zzj;
    private boolean zzv;
    private boolean zzw;
    private boolean zzc = true;
    private String zzd = "unknown_host";
    private long zzh = 100;
    private long zzi = ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS;
    private long zzk = 200;
    private long zzl = 200;
    private long zzm = SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US;
    private String zzn = "";
    private String zzo = "";
    private long zzp = 500;
    private long zzu = 3000;

    static {
        zzfxt zzfxtVar = new zzfxt();
        zzx = zzfxtVar;
        zzhwo.zzbu(zzfxt.class, zzfxtVar);
    }

    private zzfxt() {
    }

    public static zzfxs zzs() {
        return (zzfxs) zzx.zzbn();
    }

    final /* synthetic */ void zzA(boolean z) {
        this.zza |= 65536;
        this.zzv = z;
    }

    public final int zzC() {
        int iZza = zzfxv.zza(this.zzb);
        if (iZza == 0) {
            return 1;
        }
        return iZza;
    }

    final /* synthetic */ void zzD(int i) {
        this.zzb = i - 1;
        this.zza |= 1;
    }

    public final boolean zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final boolean zzc() {
        return this.zze;
    }

    public final zzfyl zzd() {
        zzfyl zzfylVar = this.zzf;
        return zzfylVar == null ? zzfyl.zzg() : zzfylVar;
    }

    @Override // com.google.android.gms.internal.ads.zzhwo
    protected final Object zzdh(zzhwn zzhwnVar, Object obj, Object obj2) {
        int iOrdinal = zzhwnVar.ordinal();
        if (iOrdinal == 0) {
            return (byte) 1;
        }
        if (iOrdinal == 2) {
            return zzbv(zzx, "\u0004\u0012\u0000\u0001\u0001\u0013\u0012\u0000\u0000\u0000\u0001᠌\u0000\u0003ဈ\u0002\u0004ဇ\u0003\u0005ဉ\u0004\u0006ဇ\u0005\u0007ဂ\u0007\bဉ\b\tဇ\u0001\nဂ\t\u000bဂ\n\fဂ\u000b\rဈ\f\u000eဈ\r\u000fဂ\u000e\u0010ဂ\u000f\u0011ဇ\u0010\u0012ဂ\u0006\u0013ဇ\u0011", new Object[]{"zza", "zzb", zzfxu.zza, "zzd", "zze", "zzf", "zzg", "zzi", "zzj", "zzc", "zzk", "zzl", "zzm", "zzn", "zzo", "zzp", "zzu", "zzv", "zzh", "zzw"});
        }
        if (iOrdinal == 3) {
            return new zzfxt();
        }
        byte[] bArr = null;
        if (iOrdinal == 4) {
            return new zzfxs(bArr);
        }
        if (iOrdinal == 5) {
            return zzx;
        }
        if (iOrdinal != 6) {
            throw null;
        }
        zzhyh zzhwjVar = zzy;
        if (zzhwjVar == null) {
            synchronized (zzfxt.class) {
                zzhwjVar = zzy;
                if (zzhwjVar == null) {
                    zzhwjVar = new zzhwj(zzx);
                    zzy = zzhwjVar;
                }
            }
        }
        return zzhwjVar;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final long zzg() {
        return this.zzh;
    }

    public final long zzh() {
        return this.zzi;
    }

    public final zzfyn zzi() {
        zzfyn zzfynVar = this.zzj;
        return zzfynVar == null ? zzfyn.zzg() : zzfynVar;
    }

    public final long zzj() {
        return this.zzk;
    }

    public final long zzk() {
        return this.zzl;
    }

    public final long zzl() {
        return this.zzm;
    }

    public final String zzm() {
        return this.zzn;
    }

    public final String zzn() {
        return this.zzo;
    }

    public final long zzo() {
        return this.zzp;
    }

    public final long zzp() {
        return this.zzu;
    }

    public final boolean zzq() {
        return this.zzv;
    }

    public final boolean zzr() {
        return this.zzw;
    }

    final /* synthetic */ void zzt(boolean z) {
        this.zza |= 2;
        this.zzc = z;
    }

    final /* synthetic */ void zzu(String str) {
        str.getClass();
        this.zza |= 4;
        this.zzd = str;
    }

    final /* synthetic */ void zzv(zzfyl zzfylVar) {
        zzfylVar.getClass();
        this.zzf = zzfylVar;
        this.zza |= 16;
    }

    final /* synthetic */ void zzw(long j) {
        this.zza |= 64;
        this.zzh = j;
    }

    final /* synthetic */ void zzx(long j) {
        this.zza |= 128;
        this.zzi = j;
    }

    final /* synthetic */ void zzy(zzfyn zzfynVar) {
        zzfynVar.getClass();
        this.zzj = zzfynVar;
        this.zza |= 256;
    }

    final /* synthetic */ void zzz(long j) {
        this.zza |= 32768;
        this.zzu = j;
    }
}
