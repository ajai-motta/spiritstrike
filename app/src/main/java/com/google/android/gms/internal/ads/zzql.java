package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import com.google.android.exoplayer2.C;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzql {
    private long zzA;
    private boolean zzB;
    private long zzC;
    private zzdc zzD;
    boolean zza;
    private final zzqk zzb;
    private final long[] zzc;
    private AudioTrack zzd;
    private zzqj zze;
    private int zzf;
    private long zzg;
    private float zzh;
    private boolean zzi;
    private long zzj;
    private long zzk;
    private long zzl;
    private Method zzm;
    private long zzn;
    private boolean zzo;
    private long zzp;
    private long zzq;
    private long zzr;
    private long zzs;
    private int zzt;
    private int zzu;
    private long zzv;
    private long zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzql(zzqk zzqkVar) {
        this.zzb = zzqkVar;
        try {
            this.zzm = AudioTrack.class.getMethod("getLatency", null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzc = new long[10];
        this.zzA = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzD = zzdc.zza;
    }

    private final void zzj(long j) {
        if (this.zza) {
            long j2 = this.zzj;
            if (j2 == C.TIME_UNSET || j < j2) {
                return;
            }
            long jZza = this.zzD.zza() - zzep.zzp(zzep.zzw(j - j2, this.zzh));
            this.zzj = C.TIME_UNSET;
            this.zzb.zza(jZza);
        }
    }

    private final long zzk(long j) {
        long jMax = Math.max(0L, (this.zzu == 0 ? this.zzv != C.TIME_UNSET ? zzep.zzr(zzo(), this.zzf) : zzm() : zzep.zzv(j + this.zzk, this.zzh)) - this.zzn);
        return this.zzv != C.TIME_UNSET ? Math.min(zzep.zzr(this.zzy, this.zzf), jMax) : jMax;
    }

    private final void zzl() {
        this.zzk = 0L;
        this.zzu = 0;
        this.zzt = 0;
        this.zzl = 0L;
        this.zzz = C.TIME_UNSET;
        this.zzA = C.TIME_UNSET;
        this.zzi = false;
    }

    private final long zzm() {
        return zzep.zzr(zzn(), this.zzf);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0067  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzn() {
        /*
            r12 = this;
            long r0 = r12.zzv
            r2 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 == 0) goto L16
            long r0 = r12.zzo()
            long r2 = r12.zzy
            long r0 = java.lang.Math.min(r2, r0)
            return r0
        L16:
            com.google.android.gms.internal.ads.zzdc r0 = r12.zzD
            long r0 = r0.zzb()
            long r4 = r12.zzq
            long r4 = r0 - r4
            r6 = 5
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 < 0) goto L72
            android.media.AudioTrack r4 = r12.zzd
            r4.getClass()
            r5 = r4
            android.media.AudioTrack r5 = (android.media.AudioTrack) r5
            int r5 = r4.getPlayState()
            r6 = 1
            if (r5 != r6) goto L36
            goto L70
        L36:
            int r4 = r4.getPlaybackHeadPosition()
            long r6 = (long) r4
            int r4 = android.os.Build.VERSION.SDK_INT
            r8 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r6 = r6 & r8
            r8 = 29
            if (r4 > r8) goto L61
            r8 = 0
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 != 0) goto L5f
            long r10 = r12.zzr
            int r4 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r4 <= 0) goto L5f
            r4 = 3
            if (r5 != r4) goto L5f
            long r4 = r12.zzw
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L70
            r12.zzw = r0
            goto L70
        L5f:
            r12.zzw = r2
        L61:
            long r2 = r12.zzr
            int r2 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r2 <= 0) goto L6e
            long r2 = r12.zzs
            r4 = 1
            long r2 = r2 + r4
            r12.zzs = r2
        L6e:
            r12.zzr = r6
        L70:
            r12.zzq = r0
        L72:
            long r0 = r12.zzr
            long r2 = r12.zzC
            long r0 = r0 + r2
            long r2 = r12.zzs
            r4 = 32
            long r2 = r2 << r4
            long r0 = r0 + r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzql.zzn():long");
    }

    private final long zzo() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 2) {
            return this.zzx;
        }
        return this.zzx + zzep.zzs(zzep.zzv(zzep.zzq(this.zzD.zzb()) - this.zzv, this.zzh), this.zzf);
    }

    public final void zza(AudioTrack audioTrack, int i, int i2, int i3, boolean z) {
        this.zzd = audioTrack;
        this.zze = new zzqj(audioTrack, this.zzb);
        this.zzf = audioTrack.getSampleRate();
        boolean zZzA = zzep.zzA(i);
        this.zzo = zZzA;
        this.zzg = zZzA ? zzep.zzr(i3 / i2, this.zzf) : -9223372036854775807L;
        this.zzr = 0L;
        this.zzs = 0L;
        this.zzB = false;
        this.zzC = 0L;
        this.zzv = C.TIME_UNSET;
        this.zzw = C.TIME_UNSET;
        this.zzp = 0L;
        this.zzn = 0L;
        this.zzh = 1.0f;
        this.zzj = C.TIME_UNSET;
        this.zza = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8 A[Catch: Exception -> 0x00b0, TRY_LEAVE, TryCatch #0 {Exception -> 0x00b0, blocks: (B:22:0x007c, B:24:0x0081, B:26:0x00a8), top: B:63:0x007c }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long zzb() {
        /*
            Method dump skipped, instruction units count: 374
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzql.zzb():long");
    }

    public final void zzc() {
        if (this.zzv != C.TIME_UNSET) {
            this.zzv = zzep.zzq(this.zzD.zzb());
        }
        this.zzj = zzm();
        zzqj zzqjVar = this.zze;
        zzqjVar.getClass();
        zzqjVar.zzd();
    }

    public final boolean zzd() {
        AudioTrack audioTrack = this.zzd;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zze(long j) {
        return this.zzw != C.TIME_UNSET && j > 0 && this.zzD.zzb() - this.zzw >= 200;
    }

    public final void zzf(long j) {
        this.zzx = zzn();
        this.zzv = zzep.zzq(this.zzD.zzb());
        this.zzy = j;
    }

    public final void zzg() {
        zzl();
        if (this.zzv == C.TIME_UNSET) {
            zzqj zzqjVar = this.zze;
            zzqjVar.getClass();
            zzqjVar.zzd();
        }
        this.zzx = zzn();
    }

    public final void zzh() {
        zzl();
        this.zzd = null;
        this.zze = null;
    }

    public final void zzi(zzdc zzdcVar) {
        this.zzD = zzdcVar;
    }
}
