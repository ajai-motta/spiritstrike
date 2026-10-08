package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.media.AudioTrack;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.Ac3Util;
import com.google.android.exoplayer2.util.MimeTypes;
import java.math.RoundingMode;
import java.nio.ByteBuffer;
import java.util.ArrayDeque;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzrh implements zzqh {
    private static final Object zza = new Object();
    private static ScheduledExecutorService zzb;
    private static int zzc;
    private zzqx zzA;
    private zzav zzB;
    private boolean zzC;
    private long zzD;
    private long zzE;
    private long zzF;
    private long zzG;
    private int zzH;
    private boolean zzI;
    private boolean zzJ;
    private long zzK;
    private float zzL;
    private ByteBuffer zzM;
    private int zzN;
    private ByteBuffer zzO;
    private boolean zzP;
    private boolean zzQ;
    private boolean zzR;
    private boolean zzS;
    private int zzT;
    private boolean zzU;
    private zze zzV;
    private AudioDeviceInfo zzW;
    private long zzX;
    private boolean zzY;
    private boolean zzZ;
    private Looper zzaa;
    private long zzab;
    private long zzac;
    private Handler zzad;
    private Context zzae;
    private boolean zzaf;
    private int zzag;
    private boolean zzah;
    private final zzqr zzai;
    private final zzqn zzaj;
    private final Context zzd;
    private final zzqm zze;
    private final zzrp zzf;
    private final zzck zzg;
    private final zzro zzh;
    private final zzgpe zzi;
    private final zzql zzj;
    private final ArrayDeque zzk;
    private zzrg zzl;
    private final zzrc zzm;
    private final zzrc zzn;
    private final int zzo;
    private zzpc zzp;
    private zzqe zzq;
    private zzqq zzr;
    private zzqq zzs;
    private zzcc zzt;
    private AudioTrack zzu;
    private zzpe zzv;
    private zzpj zzw;
    private zzrb zzx;
    private zzd zzy;
    private zzqx zzz;

    static /* synthetic */ void zzE(AudioTrack audioTrack, final zzqe zzqeVar, Handler handler, final zzqb zzqbVar) {
        try {
            audioTrack.flush();
            audioTrack.release();
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqu
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                int i = zzc - 1;
                zzc = i;
                if (i == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
            }
        } catch (Throwable th) {
            if (zzqeVar != null && handler.getLooper().getThread().isAlive()) {
                handler.post(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqv
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzqeVar.zzc(zzqbVar);
                    }
                });
            }
            synchronized (zza) {
                int i2 = zzc - 1;
                zzc = i2;
                if (i2 == 0) {
                    zzb.shutdown();
                    zzb = null;
                }
                throw th;
            }
        }
    }

    static /* synthetic */ boolean zzH() {
        boolean z;
        synchronized (zza) {
            z = zzc > 0;
        }
        return z;
    }

    private final void zzM() {
        zzcc zzccVar = this.zzs.zzi;
        this.zzt = zzccVar;
        zzccVar.zzb(zzce.zza);
    }

    private final AudioTrack zzN(zzqq zzqqVar) throws zzqd {
        Context context;
        try {
            int i = this.zzT;
            int i2 = this.zzo;
            Context context2 = null;
            if (i2 != -1 && (context = this.zzd) != null && Build.VERSION.SDK_INT >= 34) {
                if (this.zzae == null) {
                    this.zzae = context.createDeviceContext(i2);
                }
                context2 = this.zzae;
                i = 0;
            }
            return zzaf(zzqqVar.zza(), this.zzy, i, zzqqVar.zza, context2);
        } catch (zzqd e) {
            zzqe zzqeVar = this.zzq;
            if (zzqeVar != null) {
                zzqeVar.zzb(e);
            }
            throw e;
        }
    }

    private final void zzO(long j) throws Exception {
        zzR(j);
        if (this.zzO != null) {
            return;
        }
        if (!this.zzt.zzc()) {
            ByteBuffer byteBuffer = this.zzM;
            if (byteBuffer != null) {
                zzQ(byteBuffer);
                zzR(j);
                return;
            }
            return;
        }
        while (!this.zzt.zzg()) {
            do {
                ByteBuffer byteBufferZze = this.zzt.zze();
                if (byteBufferZze.hasRemaining()) {
                    zzQ(byteBufferZze);
                    zzR(j);
                } else {
                    ByteBuffer byteBuffer2 = this.zzM;
                    if (byteBuffer2 == null || !byteBuffer2.hasRemaining()) {
                        return;
                    } else {
                        this.zzt.zzd(this.zzM);
                    }
                }
            } while (this.zzO == null);
            return;
        }
    }

    private final boolean zzP() throws Exception {
        ByteBuffer byteBuffer;
        if (!this.zzt.zzc()) {
            zzR(Long.MIN_VALUE);
            return this.zzO == null;
        }
        this.zzt.zzf();
        zzO(Long.MIN_VALUE);
        return this.zzt.zzg() && ((byteBuffer = this.zzO) == null || !byteBuffer.hasRemaining());
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01ea A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x004b A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzQ(java.nio.ByteBuffer r17) {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzQ(java.nio.ByteBuffer):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzR(long r8) throws java.lang.Exception {
        /*
            r7 = this;
            java.nio.ByteBuffer r8 = r7.zzO
            if (r8 != 0) goto L6
            goto Lbb
        L6:
            com.google.android.gms.internal.ads.zzrc r8 = r7.zzn
            boolean r9 = r8.zzb()
            if (r9 != 0) goto Lbb
            java.nio.ByteBuffer r9 = r7.zzO
            int r9 = r9.remaining()
            android.media.AudioTrack r0 = r7.zzu
            java.nio.ByteBuffer r1 = r7.zzO
            r2 = 1
            int r0 = r0.write(r1, r9, r2)
            long r3 = android.os.SystemClock.elapsedRealtime()
            r7.zzX = r3
            r3 = 0
            r1 = 0
            if (r0 >= 0) goto L72
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 24
            if (r9 < r5) goto L31
            r9 = -6
            if (r0 == r9) goto L35
        L31:
            r9 = -32
            if (r0 != r9) goto L4a
        L35:
            long r5 = r7.zzG()
            int r9 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r9 <= 0) goto L3e
            goto L4b
        L3e:
            android.media.AudioTrack r9 = r7.zzu
            boolean r9 = zzab(r9)
            if (r9 == 0) goto L4a
            r7.zzS()
            goto L4b
        L4a:
            r2 = r1
        L4b:
            com.google.android.gms.internal.ads.zzqg r9 = new com.google.android.gms.internal.ads.zzqg
            com.google.android.gms.internal.ads.zzqq r1 = r7.zzs
            com.google.android.gms.internal.ads.zzv r1 = r1.zza
            r9.<init>(r0, r1, r2)
            com.google.android.gms.internal.ads.zzqe r0 = r7.zzq
            if (r0 == 0) goto L5b
            r0.zzb(r9)
        L5b:
            boolean r0 = r9.zzb
            if (r0 == 0) goto L6e
            android.content.Context r0 = r7.zzd
            if (r0 != 0) goto L64
            goto L6e
        L64:
            com.google.android.gms.internal.ads.zzpe r8 = com.google.android.gms.internal.ads.zzpe.zza
            r7.zzv = r8
            com.google.android.gms.internal.ads.zzpj r0 = r7.zzw
            r0.zza(r8)
            throw r9
        L6e:
            r8.zza(r9)
            return
        L72:
            r8.zzc()
            android.media.AudioTrack r8 = r7.zzu
            boolean r8 = zzab(r8)
            if (r8 == 0) goto L91
            long r5 = r7.zzG
            int r8 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r8 <= 0) goto L85
            r7.zzZ = r1
        L85:
            boolean r8 = r7.zzS
            if (r8 == 0) goto L91
            com.google.android.gms.internal.ads.zzqe r8 = r7.zzq
            if (r8 == 0) goto L91
            if (r0 >= r9) goto L91
            com.google.android.gms.internal.ads.zzrk r8 = (com.google.android.gms.internal.ads.zzrk) r8
        L91:
            com.google.android.gms.internal.ads.zzqq r8 = r7.zzs
            int r8 = r8.zzc
            if (r8 != 0) goto L9d
            long r3 = r7.zzF
            long r5 = (long) r0
            long r3 = r3 + r5
            r7.zzF = r3
        L9d:
            if (r0 != r9) goto Lbb
            if (r8 == 0) goto Lb8
            java.nio.ByteBuffer r8 = r7.zzO
            java.nio.ByteBuffer r9 = r7.zzM
            if (r8 != r9) goto La8
            goto La9
        La8:
            r2 = r1
        La9:
            com.google.android.gms.internal.ads.zzgmd.zzh(r2)
            long r8 = r7.zzG
            int r0 = r7.zzH
            long r0 = (long) r0
            int r2 = r7.zzN
            long r2 = (long) r2
            long r0 = r0 * r2
            long r8 = r8 + r0
            r7.zzG = r8
        Lb8:
            r8 = 0
            r7.zzO = r8
        Lbb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzR(long):void");
    }

    private final void zzS() {
        if (this.zzs.zzc == 1) {
            this.zzY = true;
        }
    }

    private final void zzT() {
        if (zzX()) {
            this.zzu.setVolume(this.zzL);
        }
    }

    private final void zzU(zzav zzavVar) {
        zzqx zzqxVar = new zzqx(zzavVar, C.TIME_UNSET, C.TIME_UNSET, null);
        if (zzX()) {
            this.zzz = zzqxVar;
        } else {
            this.zzA = zzqxVar;
        }
    }

    private final void zzV(long j) {
        zzav zzavVar;
        boolean z;
        if (zzW()) {
            zzqr zzqrVar = this.zzai;
            zzavVar = this.zzB;
            zzqrVar.zzb(zzavVar);
        } else {
            zzavVar = zzav.zza;
        }
        zzav zzavVar2 = zzavVar;
        this.zzB = zzavVar2;
        if (zzW()) {
            zzqr zzqrVar2 = this.zzai;
            z = this.zzC;
            zzqrVar2.zzc(z);
        } else {
            z = false;
        }
        this.zzC = z;
        this.zzk.add(new zzqx(zzavVar2, Math.max(0L, j), zzep.zzr(zzG(), this.zzs.zze), null));
        zzM();
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzaw().zzh(this.zzC);
        }
    }

    private final boolean zzW() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return false;
        }
        int i = zzqqVar.zza.zzI;
        return true;
    }

    private final boolean zzX() {
        return this.zzu != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzY, reason: merged with bridge method [inline-methods] */
    public final long zzF() {
        zzqq zzqqVar = this.zzs;
        return zzqqVar.zzc == 0 ? this.zzD / ((long) zzqqVar.zzb) : this.zzE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzZ, reason: merged with bridge method [inline-methods] */
    public final long zzG() {
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc != 0) {
            return this.zzG;
        }
        long j = this.zzF;
        long j2 = zzqqVar.zzd;
        String str = zzep.zza;
        return ((j + j2) - 1) / j2;
    }

    @EnsuresNonNull({"audioCapabilities"})
    private final void zzaa() {
        Context context;
        Looper looperMyLooper = Looper.myLooper();
        boolean z = true;
        if (this.zzw != null && this.zzaa != looperMyLooper) {
            z = false;
        }
        zzgmd.zzj(z, "DefaultAudioSink accessed on multiple threads: %s and %s", zzae(this.zzaa), zzae(looperMyLooper));
        if (this.zzw == null && (context = this.zzd) != null) {
            this.zzaa = looperMyLooper;
            zzpj zzpjVar = new zzpj(context, new zzpi() { // from class: com.google.android.gms.internal.ads.zzqs
                @Override // com.google.android.gms.internal.ads.zzpi
                public final /* synthetic */ void zza(zzpe zzpeVar) {
                    this.zza.zzC(zzpeVar);
                }
            }, this.zzy, this.zzW);
            this.zzw = zzpjVar;
            this.zzv = zzpjVar.zzd();
        }
        this.zzv.getClass();
    }

    private static boolean zzab(AudioTrack audioTrack) {
        return Build.VERSION.SDK_INT >= 29 && audioTrack.isOffloadedPlayback();
    }

    private final void zzac() {
        if (this.zzQ) {
            return;
        }
        this.zzQ = true;
        this.zzj.zzf(zzG());
        if (zzab(this.zzu)) {
            this.zzR = false;
        }
        this.zzu.stop();
    }

    private final boolean zzad(long j) {
        long jZzb = this.zzj.zzb();
        AudioTrack audioTrack = this.zzu;
        audioTrack.getClass();
        return j > zzep.zzs(jZzb, audioTrack.getSampleRate());
    }

    private static String zzae(Looper looper) {
        return looper == null ? AbstractJsonLexerKt.NULL : looper.getThread().getName();
    }

    private static final AudioTrack zzaf(zzqb zzqbVar, zzd zzdVar, int i, zzv zzvVar, Context context) throws zzqd {
        try {
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(zzdVar.zza()).setAudioFormat(zzep.zzC(zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza)).setTransferMode(1).setBufferSizeInBytes(zzqbVar.zze).setSessionId(i);
            if (Build.VERSION.SDK_INT >= 29) {
                sessionId.setOffloadedPlayback(zzqbVar.zzd);
            }
            if (Build.VERSION.SDK_INT >= 34 && context != null) {
                sessionId.setContext(context);
            }
            AudioTrack audioTrackBuild = sessionId.build();
            int state = audioTrackBuild.getState();
            if (state == 1) {
                return audioTrackBuild;
            }
            try {
                audioTrackBuild.release();
            } catch (Exception unused) {
            }
            throw new zzqd(state, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar, zzqbVar.zzd, null);
        } catch (IllegalArgumentException | UnsupportedOperationException e) {
            throw new zzqd(0, zzqbVar.zzb, zzqbVar.zzc, zzqbVar.zza, zzqbVar.zze, zzvVar, zzqbVar.zzd, e);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzA() {
        zzz();
        zzgpe zzgpeVar = this.zzi;
        int size = zzgpeVar.size();
        for (int i = 0; i < size; i++) {
            ((zzcg) zzgpeVar.get(i)).zzj();
        }
        this.zzg.zzj();
        this.zzh.zzj();
        zzcc zzccVar = this.zzt;
        if (zzccVar != null) {
            zzccVar.zzh();
        }
        this.zzS = false;
        this.zzY = false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzB() {
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zze();
        }
    }

    public final void zzC(zzpe zzpeVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.zzaa;
        zzgmd.zzj(looper == looperMyLooper, "Current looper (%s) is not the playback looper (%s)", zzae(looperMyLooper), zzae(this.zzaa));
        zzpe zzpeVar2 = this.zzv;
        if (zzpeVar2 == null || zzpeVar.equals(zzpeVar2)) {
            return;
        }
        this.zzv = zzpeVar;
        zzqe zzqeVar = this.zzq;
        if (zzqeVar != null) {
            ((zzrk) zzqeVar).zza.zzR();
        }
    }

    final /* synthetic */ void zzD() {
        if (this.zzac >= 300000) {
            ((zzrk) this.zzq).zza.zzay(true);
            this.zzac = 0L;
        }
    }

    final /* synthetic */ zzqe zzI() {
        return this.zzq;
    }

    final /* synthetic */ AudioTrack zzJ() {
        return this.zzu;
    }

    final /* synthetic */ void zzK(boolean z) {
        this.zzR = true;
    }

    final /* synthetic */ boolean zzL() {
        return this.zzS;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zza(zzqe zzqeVar) {
        this.zzq = zzqeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzb(zzpc zzpcVar) {
        this.zzp = zzpcVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzc(zzdc zzdcVar) {
        this.zzj.zzi(zzdcVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzd(zzv zzvVar) {
        return zze(zzvVar) != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final int zze(zzv zzvVar) {
        zzaa();
        if (!MimeTypes.AUDIO_RAW.equals(zzvVar.zzo)) {
            return this.zzv.zzd(zzvVar, this.zzy) != null ? 2 : 0;
        }
        int i = zzvVar.zzI;
        if (zzep.zzA(i)) {
            return i != 2 ? 1 : 2;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 22);
        sb.append("Invalid PCM encoding: ");
        sb.append(i);
        zzdt.zzc("DefaultAudioSink", sb.toString());
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzpl zzf(zzv zzvVar) {
        return this.zzY ? zzpl.zza : this.zzaj.zza(zzvVar, this.zzy);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzg(boolean z) {
        ArrayDeque arrayDeque;
        long j;
        if (!zzX() || this.zzJ) {
            return Long.MIN_VALUE;
        }
        long jMin = Math.min(this.zzj.zzb(), zzep.zzr(zzG(), this.zzs.zze));
        while (true) {
            arrayDeque = this.zzk;
            if (arrayDeque.isEmpty() || jMin < ((zzqx) arrayDeque.getFirst()).zzc) {
                break;
            }
            this.zzA = (zzqx) arrayDeque.remove();
        }
        zzqx zzqxVar = this.zzA;
        long j2 = jMin - zzqxVar.zzc;
        long jZzv = zzep.zzv(j2, zzqxVar.zza.zzb);
        if (arrayDeque.isEmpty()) {
            long jZzd = this.zzai.zzd(j2);
            zzqx zzqxVar2 = this.zzA;
            j = zzqxVar2.zzb + jZzd;
            zzqxVar2.zzd = jZzd - jZzv;
        } else {
            zzqx zzqxVar3 = this.zzA;
            j = zzqxVar3.zzb + jZzv + zzqxVar3.zzd;
        }
        long jZze = this.zzai.zze();
        long jZzr = j + zzep.zzr(jZze, this.zzs.zze);
        long j3 = this.zzab;
        if (jZze > j3) {
            long jZzr2 = zzep.zzr(jZze - j3, this.zzs.zze);
            this.zzab = jZze;
            this.zzac += jZzr2;
            if (this.zzad == null) {
                this.zzad = new Handler(Looper.myLooper());
            }
            this.zzad.removeCallbacksAndMessages(null);
            this.zzad.postDelayed(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqw
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzD();
                }
            }, 100L);
        }
        return jZzr;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzh(zzv zzvVar, int i, int[] iArr) throws zzqc {
        zzcc zzccVar;
        int iZzE;
        int i2;
        int iIntValue;
        int i3;
        int i4;
        int iZzE2;
        zzaa();
        if (MimeTypes.AUDIO_RAW.equals(zzvVar.zzo)) {
            int i5 = zzvVar.zzI;
            zzgmd.zza(zzep.zzA(i5));
            int i6 = zzvVar.zzG;
            iZzE2 = zzep.zzE(i5) * i6;
            zzgpb zzgpbVar = new zzgpb();
            zzgpbVar.zzh(this.zzi);
            zzgpbVar.zzf(this.zzg);
            zzgpbVar.zzg(this.zzai.zza());
            zzcc zzccVar2 = new zzcc(zzgpbVar.zzi());
            if (zzccVar2.equals(this.zzt)) {
                zzccVar2 = this.zzt;
            }
            this.zzf.zzq(zzvVar.zzJ, zzvVar.zzK);
            this.zze.zzq(iArr);
            try {
                zzcd zzcdVarZza = zzccVar2.zza(new zzcd(zzvVar.zzH, i6, i5));
                int i7 = zzcdVarZza.zzd;
                int i8 = zzcdVarZza.zzb;
                int i9 = zzcdVarZza.zzc;
                i3 = i7;
                i2 = i8;
                zzccVar = zzccVar2;
                iIntValue = zzep.zzB(i9);
                iZzE = zzep.zzE(i7) * i9;
                i4 = 0;
            } catch (zzcf e) {
                throw new zzqc(e, zzvVar);
            }
        } else {
            zzcc zzccVar3 = new zzcc(zzgpe.zzi());
            int i10 = zzvVar.zzH;
            zzpl zzplVar = zzpl.zza;
            Pair pairZzd = this.zzv.zzd(zzvVar, this.zzy);
            if (pairZzd == null) {
                String strValueOf = String.valueOf(zzvVar);
                String.valueOf(strValueOf);
                throw new zzqc("Unable to configure passthrough for: ".concat(String.valueOf(strValueOf)), zzvVar);
            }
            int iIntValue2 = ((Integer) pairZzd.first).intValue();
            zzccVar = zzccVar3;
            iZzE = -1;
            i2 = i10;
            iIntValue = ((Integer) pairZzd.second).intValue();
            i3 = iIntValue2;
            i4 = 2;
            iZzE2 = -1;
        }
        if (i3 == 0) {
            String strValueOf2 = String.valueOf(zzvVar);
            StringBuilder sb = new StringBuilder(String.valueOf(i4).length() + 37 + String.valueOf(strValueOf2).length());
            sb.append("Invalid output encoding (mode=");
            sb.append(i4);
            sb.append(") for: ");
            sb.append(strValueOf2);
            throw new zzqc(sb.toString(), zzvVar);
        }
        if (iIntValue == 0) {
            String strValueOf3 = String.valueOf(zzvVar);
            StringBuilder sb2 = new StringBuilder(String.valueOf(i4).length() + 43 + String.valueOf(strValueOf3).length());
            sb2.append("Invalid output channel config (mode=");
            sb2.append(i4);
            sb2.append(") for: ");
            sb2.append(strValueOf3);
            throw new zzqc(sb2.toString(), zzvVar);
        }
        int i11 = zzvVar.zzj;
        if (MimeTypes.AUDIO_DTS_EXPRESS.equals(zzvVar.zzo) && i11 == -1) {
            i11 = Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
        }
        int i12 = i11;
        zzgmd.zzh(AudioTrack.getMinBufferSize(i2, iIntValue, i3) != -2);
        int i13 = iZzE != -1 ? iZzE : 1;
        this.zzY = false;
        zzqq zzqqVar = new zzqq(zzvVar, iZzE2, i4, iZzE, i2, iIntValue, i3, (((Math.max(r11, zzrj.zzb(r11, i3, i4, i13, i2, i12)) + i13) - 1) / i13) * i13, zzccVar, false, false, false);
        if (zzX()) {
            this.zzr = zzqqVar;
        } else {
            this.zzs = zzqqVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzi() {
        this.zzS = true;
        if (zzX()) {
            this.zzj.zzc();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.play();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzj() {
        this.zzI = true;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0322  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f4  */
    @Override // com.google.android.gms.internal.ads.zzqh
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzk(java.nio.ByteBuffer r28, long r29, int r31) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 1202
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrh.zzk(java.nio.ByteBuffer, long, int):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzl() throws zzqg {
        if (!this.zzP && zzX() && zzP()) {
            zzac();
            this.zzP = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzm() {
        if (zzX()) {
            return this.zzP && !zzn();
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final boolean zzn() {
        if (zzX()) {
            return !(Build.VERSION.SDK_INT >= 29 && this.zzu.isOffloadedPlayback() && this.zzR) && zzad(zzG());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzo(zzav zzavVar) {
        float f = zzavVar.zzb;
        String str = zzep.zza;
        this.zzB = new zzav(Math.max(0.1f, Math.min(f, 8.0f)), Math.max(0.1f, Math.min(zzavVar.zzc, 8.0f)));
        zzU(zzavVar);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final zzav zzp() {
        return this.zzB;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzq(boolean z) {
        this.zzC = z;
        zzU(this.zzB);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzr(zzd zzdVar) {
        if (this.zzy.equals(zzdVar)) {
            return;
        }
        this.zzy = zzdVar;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzb(zzdVar);
        }
        zzz();
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzs(int i) {
        if (this.zzU) {
            if (this.zzT != i) {
                return;
            } else {
                this.zzU = false;
            }
        }
        if (this.zzT != i) {
            this.zzT = i;
            zzz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzt(zze zzeVar) {
        if (this.zzV.equals(zzeVar)) {
            return;
        }
        if (this.zzu != null) {
            int i = this.zzV.zza;
        }
        this.zzV = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzu(AudioDeviceInfo audioDeviceInfo) {
        this.zzW = audioDeviceInfo;
        zzpj zzpjVar = this.zzw;
        if (zzpjVar != null) {
            zzpjVar.zzc(audioDeviceInfo);
        }
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            audioTrack.setPreferredDevice(this.zzW);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final long zzv() {
        if (!zzX()) {
            return C.TIME_UNSET;
        }
        zzqq zzqqVar = this.zzs;
        if (zzqqVar.zzc == 0) {
            return zzep.zzr(this.zzu.getBufferSizeInFrames(), zzqqVar.zze);
        }
        long bufferSizeInFrames = this.zzu.getBufferSizeInFrames();
        int iZzf = zzade.zzf(this.zzs.zzg);
        zzgmd.zzh(iZzf != -2147483647);
        return zzep.zzt(bufferSizeInFrames, 1000000L, iZzf, RoundingMode.DOWN);
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzw(int i, int i2) {
        AudioTrack audioTrack = this.zzu;
        if (audioTrack != null) {
            zzab(audioTrack);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzx(float f) {
        if (this.zzL != f) {
            this.zzL = f;
            zzT();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzy() {
        this.zzS = false;
        if (zzX()) {
            this.zzj.zzg();
            if (!this.zzQ || zzab(this.zzu)) {
                this.zzu.pause();
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzqh
    public final void zzz() {
        zzrb zzrbVar;
        if (zzX()) {
            this.zzD = 0L;
            this.zzE = 0L;
            this.zzF = 0L;
            this.zzG = 0L;
            this.zzZ = false;
            this.zzH = 0;
            this.zzA = new zzqx(this.zzB, 0L, 0L, null);
            this.zzK = 0L;
            this.zzz = null;
            this.zzk.clear();
            this.zzM = null;
            this.zzN = 0;
            this.zzO = null;
            this.zzQ = false;
            this.zzP = false;
            this.zzR = false;
            this.zzf.zzr();
            zzM();
            zzql zzqlVar = this.zzj;
            if (zzqlVar.zzd()) {
                this.zzu.pause();
            }
            if (zzab(this.zzu)) {
                zzrg zzrgVar = this.zzl;
                zzrgVar.getClass();
                zzrgVar.zzb(this.zzu);
            }
            final zzqb zzqbVarZza = this.zzs.zza();
            zzqq zzqqVar = this.zzr;
            if (zzqqVar != null) {
                this.zzs = zzqqVar;
                this.zzr = null;
            }
            zzqlVar.zzh();
            if (Build.VERSION.SDK_INT >= 24 && (zzrbVar = this.zzx) != null) {
                zzrbVar.zza();
                this.zzx = null;
            }
            final AudioTrack audioTrack = this.zzu;
            final zzqe zzqeVar = this.zzq;
            final Handler handler = new Handler(Looper.myLooper());
            synchronized (zza) {
                if (zzb == null) {
                    zzb = zzep.zzg("ExoPlayer:AudioTrackReleaseThread");
                }
                zzc++;
                zzb.schedule(new Runnable() { // from class: com.google.android.gms.internal.ads.zzqt
                    @Override // java.lang.Runnable
                    public final /* synthetic */ void run() {
                        zzrh.zzE(audioTrack, zzqeVar, handler, zzqbVarZza);
                    }
                }, 20L, TimeUnit.MILLISECONDS);
            }
            this.zzu = null;
        }
        this.zzn.zzc();
        this.zzm.zzc();
        this.zzab = 0L;
        this.zzac = 0L;
        Handler handler2 = this.zzad;
        if (handler2 != null) {
            handler2.removeCallbacksAndMessages(null);
        }
    }

    /* synthetic */ zzrh(zzqp zzqpVar, byte[] bArr) {
        int deviceId;
        byte[] bArr2 = null;
        Context applicationContext = zzqpVar.zzb() == null ? null : zzqpVar.zzb().getApplicationContext();
        this.zzd = applicationContext;
        this.zzy = zzd.zza;
        this.zzv = applicationContext != null ? null : zzqpVar.zzc();
        this.zzai = zzqpVar.zzd();
        zzqn zzqnVarZze = zzqpVar.zze();
        zzqnVarZze.getClass();
        this.zzaj = zzqnVarZze;
        this.zzj = new zzql(new zzrd(this, bArr2));
        zzqm zzqmVar = new zzqm();
        this.zze = zzqmVar;
        zzrp zzrpVar = new zzrp();
        this.zzf = zzrpVar;
        this.zzg = new zzck();
        this.zzh = new zzro();
        this.zzi = zzgpe.zzk(zzrpVar, zzqmVar);
        this.zzL = 1.0f;
        this.zzT = 0;
        this.zzV = new zze(0, 0.0f);
        zzav zzavVar = zzav.zza;
        this.zzA = new zzqx(zzavVar, 0L, 0L, null);
        this.zzB = zzavVar;
        this.zzC = false;
        this.zzk = new ArrayDeque();
        this.zzm = new zzrc();
        this.zzn = new zzrc();
        int i = -1;
        if (Build.VERSION.SDK_INT >= 34 && zzqpVar.zzb() != null && (deviceId = zzqpVar.zzb().getDeviceId()) != 0 && deviceId != -1) {
            i = deviceId;
        }
        this.zzo = i;
        this.zzaf = true;
    }
}
