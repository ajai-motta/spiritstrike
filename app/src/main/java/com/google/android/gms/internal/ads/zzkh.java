package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaPeriodQueue;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzkh implements Handler.Callback, zzur, zzyq, zzld, zzhy, zzlh, zzhp, zzaax {
    private static final long zza = zzep.zzp(10000);
    private zzlv zzA;
    private boolean zzC;
    private boolean zzD;
    private zzkg zzE;
    private int zzF;
    private zzlf zzG;
    private zzke zzH;
    private boolean zzI;
    private boolean zzK;
    private boolean zzL;
    private boolean zzN;
    private boolean zzQ;
    private int zzR;
    private zzkg zzS;
    private long zzT;
    private long zzU;
    private int zzV;
    private boolean zzW;
    private zzib zzX;
    private zzil zzZ;
    private boolean zzab;
    private final zzhu zzad;
    private final zzlr[] zzb;
    private final zzlp[] zzc;
    private final boolean[] zzd;
    private final zzyr zze;
    private final zzys zzf;
    private final zzkl zzg;
    private final zzza zzh;
    private final zzdm zzi;
    private final zzlg zzj;
    private final Looper zzk;
    private final zzbe zzl;
    private final zzbd zzm;
    private final long zzn;
    private final zzhz zzo;
    private final ArrayList zzp;
    private final zzdc zzq;
    private final zzkf zzr;
    private final zzks zzs;
    private final zzle zzt;
    private final long zzu;
    private final zzpc zzv;
    private final zzmi zzw;
    private final zzdm zzx;
    private final boolean zzy;
    private final zzhq zzz;
    private long zzaa = C.TIME_UNSET;
    private int zzO = 0;
    private boolean zzP = false;
    private boolean zzJ = false;
    private float zzac = 1.0f;
    private zzlu zzB = zzlu.zza;
    private long zzY = C.TIME_UNSET;
    private long zzM = C.TIME_UNSET;

    public zzkh(Context context, zzln[] zzlnVarArr, zzln[] zzlnVarArr2, zzyr zzyrVar, zzys zzysVar, zzkl zzklVar, zzza zzzaVar, int i, boolean z, zzmi zzmiVar, zzlv zzlvVar, zzhu zzhuVar, long j, boolean z2, boolean z3, Looper looper, zzdc zzdcVar, zzkf zzkfVar, zzpc zzpcVar, zzlg zzlgVar, zzil zzilVar, final zzaax zzaaxVar) {
        this.zzr = zzkfVar;
        this.zze = zzyrVar;
        this.zzf = zzysVar;
        this.zzg = zzklVar;
        this.zzh = zzzaVar;
        int i2 = 0;
        this.zzA = zzlvVar;
        this.zzad = zzhuVar;
        this.zzu = j;
        this.zzq = zzdcVar;
        this.zzv = zzpcVar;
        this.zzZ = zzilVar;
        this.zzw = zzmiVar;
        this.zzn = zzklVar.zzf(zzpcVar);
        zzklVar.zzg(zzpcVar);
        zzbf zzbfVar = zzbf.zza;
        zzlf zzlfVarZza = zzlf.zza(zzysVar);
        this.zzG = zzlfVarZza;
        this.zzH = new zzke(zzlfVarZza);
        int length = zzlnVarArr.length;
        this.zzc = new zzlp[2];
        this.zzd = new boolean[2];
        zzlo zzloVarZzg = zzyrVar.zzg();
        this.zzb = new zzlr[2];
        boolean z4 = false;
        while (true) {
            int length2 = zzlnVarArr.length;
            if (i2 >= 2) {
                this.zzy = z4;
                this.zzo = new zzhz(this, zzdcVar);
                this.zzp = new ArrayList();
                this.zzl = new zzbe();
                this.zzm = new zzbd();
                zzyrVar.zzr(this, zzzaVar);
                this.zzW = true;
                zzdm zzdmVarZzd = zzdcVar.zzd(looper, null);
                this.zzx = zzdmVarZzd;
                this.zzs = new zzks(zzmiVar, zzdmVarZzd, new zzka(this), zzilVar);
                this.zzt = new zzle(this, zzmiVar, zzdmVarZzd, zzpcVar);
                zzlg zzlgVar2 = new zzlg(null);
                this.zzj = zzlgVar2;
                Looper looperZza = zzlgVar2.zza();
                this.zzk = looperZza;
                zzdm zzdmVarZzd2 = zzdcVar.zzd(looperZza, this);
                this.zzi = zzdmVarZzd2;
                this.zzz = new zzhq(context, looperZza, this);
                zzdmVarZzd2.zzd(35, new zzaax() { // from class: com.google.android.gms.internal.ads.zzjw
                    @Override // com.google.android.gms.internal.ads.zzaax
                    public final /* synthetic */ void zzcS(long j2, long j3, zzv zzvVar, MediaFormat mediaFormat) {
                        this.zza.zzcS(j2, j3, zzvVar, mediaFormat);
                    }
                }).zza();
                return;
            }
            zzlnVarArr[i2].zzc(i2, zzpcVar, zzdcVar);
            this.zzc[i2] = zzlnVarArr[i2].zzb();
            this.zzc[i2].zzv(zzloVarZzg);
            zzln zzlnVar = zzlnVarArr2[i2];
            if (zzlnVar != null) {
                zzlnVar.zzc(i2, zzpcVar, zzdcVar);
                z4 = true;
            }
            this.zzb[i2] = new zzlr(zzlnVarArr[i2], zzlnVarArr2[i2], i2);
            i2++;
        }
    }

    private final void zzA(IOException iOException, int i) {
        zzks zzksVar = this.zzs;
        zzib zzibVarZza = zzib.zza(iOException, i);
        zzkp zzkpVarZzm = zzksVar.zzm();
        if (zzkpVarZzm != null) {
            zzibVarZza = zzibVarZza.zzd(zzkpVarZzm.zzg.zza);
        }
        zzdt.zzf("ExoPlayerImplInternal", "Playback error", zzibVarZza);
        zzW(false, false);
        this.zzG = this.zzG.zzf(zzibVarZza);
    }

    private final void zzB(int i) {
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zze != i) {
            if (i != 2) {
                this.zzY = C.TIME_UNSET;
            }
            if (i != 3) {
                boolean z = zzlfVar.zzp;
            }
            this.zzG = this.zzG.zze(i);
        }
    }

    private final void zzC() {
        this.zzH.zzb(this.zzG);
        if (this.zzH.zzd()) {
            this.zzr.zza(this.zzH);
            this.zzH = new zzke(this.zzG);
        }
    }

    private final void zzD(float f) throws zzib {
        this.zzac = f;
        float fZza = f * this.zzz.zza();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzL(fZza);
            i++;
        }
    }

    private final void zzE(boolean z, int i, boolean z2, int i2) throws zzib {
        this.zzH.zza(z2 ? 1 : 0);
        zzG(z, i, i2);
    }

    private final void zzF() throws zzib {
        zzlf zzlfVar = this.zzG;
        zzG(zzlfVar.zzl, zzlfVar.zzn, zzlfVar.zzm);
    }

    private final void zzG(boolean z, int i, int i2) throws zzib {
        zzH(z, this.zzz.zzc(z, this.zzG.zze), i, i2);
    }

    private final void zzH(boolean z, int i, int i2, int i3) throws zzib {
        boolean z2;
        if (!z) {
            z2 = false;
        } else if (i != -1) {
            z2 = true;
        } else {
            i = -1;
            z2 = false;
        }
        if (i == -1) {
            i3 = 2;
        } else if (i3 == 2) {
            i3 = 1;
        }
        boolean z3 = this.zzC;
        if (i == 0) {
            i2 = 1;
        } else if (i2 == 1) {
            i2 = z3 ? 4 : 0;
        }
        zzlf zzlfVar = this.zzG;
        if (zzlfVar.zzl == z2 && zzlfVar.zzn == i2 && zzlfVar.zzm == i3) {
            return;
        }
        this.zzG = zzlfVar.zzi(z2, i3, i2);
        zzaC(false, false);
        zzks zzksVar = this.zzs;
        for (zzkp zzkpVarZzm = zzksVar.zzm(); zzkpVarZzm != null; zzkpVarZzm = zzkpVarZzm.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm.zzr().zzc) {
            }
        }
        if (!zzax()) {
            zzK();
            zzL();
            boolean z4 = this.zzG.zzp;
            zzksVar.zzf(this.zzT);
            return;
        }
        int i4 = this.zzG.zze;
        if (i4 == 3) {
            this.zzo.zza();
            zzJ();
            this.zzi.zzh(2);
        } else if (i4 == 2) {
            this.zzi.zzh(2);
        }
    }

    private final void zzI(boolean z) throws zzib {
        zzuu zzuuVar = this.zzs.zzm().zzg.zza;
        long jZzT = zzT(zzuuVar, this.zzG.zzs, true, false);
        if (jZzT != this.zzG.zzs) {
            zzlf zzlfVar = this.zzG;
            this.zzG = zzao(zzuuVar, jZzT, zzlfVar.zzc, zzlfVar.zzd, z, 5);
        }
    }

    private final void zzJ() throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        if (zzkpVarZzm == null) {
            return;
        }
        zzys zzysVarZzr = zzkpVarZzm.zzr();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            if (zzysVarZzr.zza(i)) {
                zzlrVarArr[i].zzv();
            }
            i++;
        }
    }

    private final void zzK() throws zzib {
        this.zzo.zzb();
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzw();
            i++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a9, code lost:
    
        r13 = null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzL() throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 368
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzL():void");
    }

    private final void zzM(zzav zzavVar) {
        this.zzi.zzk(16);
        this.zzo.zzi(zzavVar);
    }

    private final void zzN(final int i, final boolean z) {
        boolean[] zArr = this.zzd;
        if (zArr[i] != z) {
            zArr[i] = z;
            this.zzx.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzjx
                @Override // java.lang.Runnable
                public final /* synthetic */ void run() {
                    this.zza.zzu(i, z);
                }
            });
        }
    }

    private final long zzO(zzbf zzbfVar, Object obj, long j) {
        int i = zzbfVar.zzo(obj, this.zzm).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        if (zzbeVar.zzf == C.TIME_UNSET || !zzbeVar.zzb() || !zzbeVar.zzi) {
            return C.TIME_UNSET;
        }
        long j2 = zzbeVar.zzg;
        String str = zzep.zza;
        return zzep.zzq((j2 == C.TIME_UNSET ? System.currentTimeMillis() : j2 + SystemClock.elapsedRealtime()) - zzbeVar.zzf) - j;
    }

    private final boolean zzP(zzbf zzbfVar, zzuu zzuuVar) {
        if (!zzuuVar.zzb() && !zzbfVar.zzg()) {
            int i = zzbfVar.zzo(zzuuVar.zza, this.zzm).zzc;
            zzbe zzbeVar = this.zzl;
            zzbfVar.zzb(i, zzbeVar, 0L);
            if (zzbeVar.zzb() && zzbeVar.zzi && zzbeVar.zzf != C.TIME_UNSET) {
                return true;
            }
        }
        return false;
    }

    private final void zzQ(long j) {
        if (zzw()) {
            jMin = this.zzG.zze != 3 ? zza : 1000L;
            zzlr[] zzlrVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                jMin = Math.min(jMin, zzep.zzp(zzlrVarArr[i].zzk(this.zzT, this.zzU)));
            }
            if (this.zzG.zzj()) {
                zzks zzksVar = this.zzs;
                if ((zzksVar.zzm() != null ? zzksVar.zzm().zzp() : null) != null) {
                    if (this.zzT + (zzep.zzq(jMin) * this.zzG.zzo.zzb) >= r0.zzc()) {
                        jMin = Math.min(jMin, zza);
                    }
                }
            }
        } else if (this.zzG.zze != 3 || zzax()) {
            jMin = zza;
        }
        this.zzi.zzj(2, j + jMin);
    }

    private final void zzR(zzkg zzkgVar, boolean z) throws Throwable {
        long jLongValue;
        long j;
        boolean z2;
        zzuu zzuuVar;
        boolean z3;
        long j2;
        long jZzk;
        long jZzS;
        long j3;
        zzlf zzlfVar;
        int i;
        this.zzH.zza(z ? 1 : 0);
        if (this.zzD) {
            if (this.zzE != null) {
                this.zzF++;
            }
            this.zzE = zzkgVar;
            return;
        }
        zzbf zzbfVar = this.zzG.zza;
        int i2 = this.zzO;
        boolean z4 = this.zzP;
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzaD = zzaD(zzbfVar, zzkgVar, true, i2, z4, zzbeVar, zzbdVar);
        if (pairZzaD == null) {
            Pair pairZzY = zzY(this.zzG.zza);
            zzuuVar = (zzuu) pairZzY.first;
            jLongValue = ((Long) pairZzY.second).longValue();
            z2 = !this.zzG.zza.zzg();
            j = -9223372036854775807L;
        } else {
            Object obj = pairZzaD.first;
            jLongValue = ((Long) pairZzaD.second).longValue();
            long j4 = zzkgVar.zzc;
            j = j4 == C.TIME_UNSET ? -9223372036854775807L : jLongValue;
            zzuu zzuuVarZzy = this.zzs.zzy(this.zzG.zza, obj, jLongValue);
            if (zzuuVarZzy.zzb()) {
                this.zzG.zza.zzo(zzuuVarZzy.zza, zzbdVar);
                if (zzbdVar.zzd(zzuuVarZzy.zzb) == zzuuVarZzy.zzc) {
                    zzbdVar.zzj();
                }
                jLongValue = 0;
                zzuuVar = zzuuVarZzy;
                z2 = true;
            } else {
                z2 = j4 == C.TIME_UNSET;
                zzuuVar = zzuuVarZzy;
            }
        }
        try {
            if (this.zzG.zza.zzg()) {
                this.zzS = zzkgVar;
            } else if (pairZzaD == null) {
                if (this.zzG.zze != 1) {
                    zzB(4);
                }
                zzX(false, true, false, true);
            } else {
                try {
                    if (zzuuVar.equals(this.zzG.zzb)) {
                        zzkp zzkpVarZzm = this.zzs.zzm();
                        if (zzkpVarZzm == null || !zzkpVarZzm.zze || jLongValue == 0) {
                            jZzk = jLongValue;
                        } else {
                            zzus zzusVar = zzkpVarZzm.zza;
                            long j5 = zzbeVar.zzm;
                            if (this.zzC && j5 != C.TIME_UNSET) {
                                Double d = this.zzB.zzc;
                            }
                            jZzk = zzusVar.zzk(jLongValue, this.zzA);
                        }
                        if (zzep.zzp(jZzk) == zzep.zzp(this.zzG.zzs) && ((i = (zzlfVar = this.zzG).zze) == 2 || i == 3)) {
                            z3 = z2;
                            j3 = zzlfVar.zzs;
                        }
                        this.zzG = zzao(zzuuVar, j3, j, j3, z3, 2);
                    }
                    jZzk = jLongValue;
                    zzlf zzlfVar2 = this.zzG;
                    zzbf zzbfVar2 = zzlfVar2.zza;
                    zzag(zzbfVar2, zzuuVar, zzbfVar2, zzlfVar2.zzb, j, true);
                    j3 = jZzS;
                    this.zzG = zzao(zzuuVar, j3, j, j3, z3, 2);
                } catch (Throwable th) {
                    th = th;
                    j2 = jZzS;
                    this.zzG = zzao(zzuuVar, j2, j, j2, z3, 2);
                    throw th;
                }
                this.zzD = this.zzC;
                jZzS = zzS(zzuuVar, jZzk, this.zzG.zze == 4);
                z3 = z2 | (jLongValue != jZzS);
            }
            z3 = z2;
            j3 = jLongValue;
            this.zzG = zzao(zzuuVar, j3, j, j3, z3, 2);
        } catch (Throwable th2) {
            th = th2;
            z3 = z2;
            j2 = jLongValue;
        }
    }

    private final long zzS(zzuu zzuuVar, long j, boolean z) throws zzib {
        zzks zzksVar = this.zzs;
        return zzT(zzuuVar, j, zzksVar.zzm() != zzksVar.zzn(), z);
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final long zzT(com.google.android.gms.internal.ads.zzuu r10, long r11, boolean r13, boolean r14) throws com.google.android.gms.internal.ads.zzib {
        /*
            Method dump skipped, instruction units count: 233
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzT(com.google.android.gms.internal.ads.zzuu, long, boolean, boolean):long");
    }

    private final void zzU(long j, boolean z) throws zzib {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long jZza = j + (zzkpVarZzm == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : zzkpVarZzm.zza());
        this.zzT = jZza;
        this.zzo.zzc(jZza);
        zzlr[] zzlrVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            zzlrVarArr[i].zzE(zzkpVarZzm, this.zzT, z);
        }
        for (zzkp zzkpVarZzm2 = r0.zzm(); zzkpVarZzm2 != null; zzkpVarZzm2 = zzkpVarZzm2.zzp()) {
            for (zzyk zzykVar : zzkpVarZzm2.zzr().zzc) {
            }
        }
    }

    private final void zzV() throws zzib {
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                return;
            }
            zzlrVarArr[i].zzz(this.zzC ? this.zzB : null);
            i++;
        }
    }

    private final void zzW(boolean z, boolean z2) {
        zzX(z || !this.zzQ, false, true, false);
        this.zzH.zza(z2 ? 1 : 0);
        this.zzg.zzc(this.zzv);
        this.zzz.zzc(this.zzG.zzl, 1);
        zzB(1);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0093 A[PHI: r2 r7 r9
  0x0093: PHI (r2v2 com.google.android.gms.internal.ads.zzuu) = (r2v1 com.google.android.gms.internal.ads.zzuu), (r2v6 com.google.android.gms.internal.ads.zzuu) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]
  0x0093: PHI (r7v3 long) = (r7v2 long), (r7v11 long) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]
  0x0093: PHI (r9v2 long) = (r9v1 long), (r9v5 long) binds: [B:25:0x006b, B:27:0x0090] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00da A[PHI: r3
  0x00da: PHI (r3v3 com.google.android.gms.internal.ads.zzbf) = 
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v2 com.google.android.gms.internal.ads.zzbf)
  (r3v19 com.google.android.gms.internal.ads.zzbf)
  (r3v19 com.google.android.gms.internal.ads.zzbf)
 binds: [B:31:0x00a2, B:33:0x00a6, B:35:0x00b7, B:37:0x00cd] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzX(boolean r35, boolean r36, boolean r37, boolean r38) {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzX(boolean, boolean, boolean, boolean):void");
    }

    private final Pair zzY(zzbf zzbfVar) {
        long j = 0;
        if (zzbfVar.zzg()) {
            return Pair.create(zzlf.zzb(), 0L);
        }
        int iZzk = zzbfVar.zzk(this.zzP);
        zzbe zzbeVar = this.zzl;
        zzbd zzbdVar = this.zzm;
        Pair pairZzm = zzbfVar.zzm(zzbeVar, zzbdVar, iZzk, C.TIME_UNSET);
        zzuu zzuuVarZzy = this.zzs.zzy(zzbfVar, pairZzm.first, 0L);
        long jLongValue = ((Long) pairZzm.second).longValue();
        if (zzuuVarZzy.zzb()) {
            zzbfVar.zzo(zzuuVarZzy.zza, zzbdVar);
            if (zzuuVarZzy.zzc == zzbdVar.zzd(zzuuVarZzy.zzb)) {
                zzbdVar.zzj();
            }
        } else {
            j = jLongValue;
        }
        return Pair.create(zzuuVarZzy, Long.valueOf(j));
    }

    private final void zzZ(zzbf zzbfVar, zzbf zzbfVar2) {
        if (zzbfVar.zzg() && zzbfVar2.zzg()) {
            return;
        }
        ArrayList arrayList = this.zzp;
        int size = arrayList.size() - 1;
        if (size < 0) {
            Collections.sort(arrayList);
            return;
        }
        zzkd zzkdVar = (zzkd) arrayList.get(size);
        Object obj = zzkdVar.zzb;
        zzlj zzljVar = zzkdVar.zza;
        String str = zzep.zza;
        throw null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaA, reason: merged with bridge method [inline-methods] */
    public final boolean zzw() {
        if (!this.zzC) {
            return false;
        }
        boolean z = this.zzB.zzg;
        return true;
    }

    private static boolean zzaB(zzlf zzlfVar, zzbd zzbdVar) {
        zzuu zzuuVar = zzlfVar.zzb;
        zzbf zzbfVar = zzlfVar.zza;
        return zzbfVar.zzg() || zzbfVar.zzo(zzuuVar.zza, zzbdVar).zzf;
    }

    private final void zzaC(boolean z, boolean z2) {
        this.zzL = z;
        long jElapsedRealtime = C.TIME_UNSET;
        if (z && !z2) {
            jElapsedRealtime = SystemClock.elapsedRealtime();
        }
        this.zzM = jElapsedRealtime;
    }

    private static Pair zzaD(zzbf zzbfVar, zzkg zzkgVar, boolean z, int i, boolean z2, zzbe zzbeVar, zzbd zzbdVar) {
        Pair pairZzm;
        zzbf zzbfVar2 = zzkgVar.zza;
        if (zzbfVar.zzg()) {
            return null;
        }
        zzbf zzbfVar3 = true == zzbfVar2.zzg() ? zzbfVar : zzbfVar2;
        try {
            pairZzm = zzbfVar3.zzm(zzbeVar, zzbdVar, zzkgVar.zzb, zzkgVar.zzc);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (zzbfVar.equals(zzbfVar3)) {
            return pairZzm;
        }
        if (zzbfVar.zze(pairZzm.first) != -1) {
            return (zzbfVar3.zzo(pairZzm.first, zzbdVar).zzf && zzbfVar3.zzb(zzbdVar.zzc, zzbeVar, 0L).zzn == zzbfVar3.zze(pairZzm.first)) ? zzbfVar.zzm(zzbeVar, zzbdVar, zzbfVar.zzo(pairZzm.first, zzbdVar).zzc, zzkgVar.zzc) : pairZzm;
        }
        int iZzr = zzr(zzbeVar, zzbdVar, i, z2, pairZzm.first, zzbfVar3, zzbfVar);
        if (iZzr != -1) {
            return zzbfVar.zzm(zzbeVar, zzbdVar, iZzr, C.TIME_UNSET);
        }
        return null;
    }

    private static final void zzaE(zzlj zzljVar) throws zzib {
        zzljVar.zzh();
        try {
            zzljVar.zza().zzx(zzljVar.zzc(), zzljVar.zze());
        } finally {
            zzljVar.zzi(true);
        }
    }

    private static final boolean zzaF(zzkp zzkpVar) {
        if (zzkpVar != null) {
            try {
                if (zzkpVar.zze) {
                    zzwk[] zzwkVarArr = zzkpVar.zzc;
                    for (int i = 0; i < 2; i++) {
                        zzwk zzwkVar = zzwkVarArr[i];
                        if (zzwkVar != null) {
                            zzwkVar.zzc();
                        }
                    }
                } else {
                    zzkpVar.zza.zzc();
                }
                if (zzkpVar.zzg() != Long.MIN_VALUE) {
                    return true;
                }
            } catch (IOException unused) {
            }
        }
        return false;
    }

    private final void zzaa() throws zzib {
        int i = 0;
        while (true) {
            zzlr[] zzlrVarArr = this.zzb;
            if (i >= 2) {
                this.zzaa = C.TIME_UNSET;
                return;
            }
            int iZzd = zzlrVarArr[i].zzd();
            zzlrVarArr[i].zzA(this.zzo);
            zzN(i, false);
            this.zzR -= iZzd;
            i++;
        }
    }

    private final void zzab() {
        if (this.zzy && zzaz()) {
            zzlr[] zzlrVarArr = this.zzb;
            for (int i = 0; i < 2; i++) {
                zzlr zzlrVar = zzlrVarArr[i];
                int iZzd = zzlrVar.zzd();
                zzlrVar.zzC(this.zzo);
                this.zzR -= iZzd - zzlrVar.zzd();
            }
            this.zzaa = C.TIME_UNSET;
        }
    }

    private final void zzac() throws zzib {
        zzad();
        zzI(true);
    }

    private final void zzad() throws zzib {
        zzhz zzhzVar = this.zzo;
        float f = zzhzVar.zzj().zzb;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzm = zzksVar.zzm();
        zzkp zzkpVarZzn = zzksVar.zzn();
        zzys zzysVar = null;
        boolean z = true;
        while (zzkpVarZzm != null && zzkpVarZzm.zze) {
            zzlf zzlfVar = this.zzG;
            zzys zzysVarZzk = zzkpVarZzm.zzk(f, zzlfVar.zza, zzlfVar.zzl);
            zzys zzysVar2 = zzkpVarZzm == zzksVar.zzm() ? zzysVarZzk : zzysVar;
            zzys zzysVarZzr = zzkpVarZzm.zzr();
            boolean z2 = false;
            if (zzysVarZzr != null) {
                zzyk[] zzykVarArr = zzysVarZzk.zzc;
                if (zzysVarZzr.zzc.length == zzykVarArr.length) {
                    for (int i = 0; i < zzykVarArr.length; i++) {
                        if (zzysVarZzk.zzb(zzysVarZzr, i)) {
                        }
                    }
                    if (zzkpVarZzm != zzkpVarZzn) {
                        z2 = true;
                    }
                    z &= z2;
                    zzkpVarZzm = zzkpVarZzm.zzp();
                    zzysVar = zzysVar2;
                }
            }
            int i2 = 2;
            if (z) {
                zzkp zzkpVarZzm2 = zzksVar.zzm();
                int iZzs = zzksVar.zzs(zzkpVarZzm2) & 1;
                zzlr[] zzlrVarArr = this.zzb;
                boolean[] zArr = new boolean[2];
                zzysVar2.getClass();
                long jZzm = zzkpVarZzm2.zzm(zzysVar2, this.zzG.zzs, 1 == iZzs, zArr);
                zzlf zzlfVar2 = this.zzG;
                boolean z3 = (zzlfVar2.zze == 4 || jZzm == zzlfVar2.zzs) ? false : true;
                zzlf zzlfVar3 = this.zzG;
                zzkp zzkpVar = zzkpVarZzm2;
                this.zzG = zzao(zzlfVar3.zzb, jZzm, zzlfVar3.zzc, zzlfVar3.zzd, z3, 5);
                if (z3) {
                    zzU(jZzm, true);
                }
                zzab();
                i2 = 2;
                boolean[] zArr2 = new boolean[2];
                int i3 = 0;
                while (i3 < 2) {
                    int iZzd = zzlrVarArr[i3].zzd();
                    zArr2[i3] = zzlrVarArr[i3].zzM();
                    zzkp zzkpVar2 = zzkpVar;
                    zzlrVarArr[i3].zzD(zzkpVar2.zzc[i3], zzhzVar, this.zzT, zArr[i3]);
                    if (iZzd - zzlrVarArr[i3].zzd() > 0) {
                        zzN(i3, false);
                    }
                    this.zzR -= iZzd - zzlrVarArr[i3].zzd();
                    i3++;
                    zzkpVar = zzkpVar2;
                }
                zzaq(zArr2, this.zzT);
                zzkpVar.zzh = true;
            } else {
                zzksVar.zzs(zzkpVarZzm);
                if (zzkpVarZzm.zze) {
                    long jMax = Math.max(zzkpVarZzm.zzg.zzb, this.zzT - zzkpVarZzm.zza());
                    if (this.zzy && zzaz() && zzksVar.zzo() == zzkpVarZzm) {
                        zzab();
                    }
                    zzkpVarZzm.zzl(zzysVarZzk, jMax, false);
                }
            }
            zzas(true);
            if (this.zzG.zze != 4) {
                zzam();
                zzL();
                this.zzi.zzh(i2);
                return;
            }
            return;
        }
    }

    private final boolean zzae() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        long j = zzkpVarZzm.zzg.zze;
        if (!zzkpVarZzm.zze) {
            return false;
        }
        if (j == C.TIME_UNSET || this.zzG.zzs < j) {
            return true;
        }
        return !zzax();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:203:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x03cd  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01f6  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x022f  */
    /* JADX WARN: Type inference failed for: r1v75 */
    /* JADX WARN: Type inference failed for: r1v76, types: [int] */
    /* JADX WARN: Type inference failed for: r1v89 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzaf(com.google.android.gms.internal.ads.zzbf r31, boolean r32) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1072
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.zzaf(com.google.android.gms.internal.ads.zzbf, boolean):void");
    }

    private final void zzag(zzbf zzbfVar, zzuu zzuuVar, zzbf zzbfVar2, zzuu zzuuVar2, long j, boolean z) throws zzib {
        if (!zzP(zzbfVar, zzuuVar)) {
            zzav zzavVar = zzuuVar.zzb() ? zzav.zza : this.zzG.zzo;
            if (this.zzo.zzj().equals(zzavVar)) {
                return;
            }
            zzM(zzavVar);
            zzal(this.zzG.zzo, zzavVar.zzb, false, false);
            return;
        }
        Object obj = zzuuVar.zza;
        zzbd zzbdVar = this.zzm;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        zzbe zzbeVar = this.zzl;
        zzbfVar.zzb(i, zzbeVar, 0L);
        zzhu zzhuVar = this.zzad;
        zzaf zzafVar = zzbeVar.zzj;
        String str = zzep.zza;
        zzhuVar.zza(zzafVar);
        if (j != C.TIME_UNSET) {
            zzhuVar.zzb(zzO(zzbfVar, obj, j));
            return;
        }
        if (!Objects.equals(!zzbfVar2.zzg() ? zzbfVar2.zzb(zzbfVar2.zzo(zzuuVar2.zza, zzbdVar).zzc, zzbeVar, 0L).zzb : null, zzbeVar.zzb) || z) {
            zzhuVar.zzb(C.TIME_UNSET);
        }
    }

    private final long zzah(zzkp zzkpVar) {
        if (zzkpVar == null) {
            return 0L;
        }
        long jZza = zzkpVar.zza();
        if (zzkpVar.zze) {
            int i = 0;
            while (true) {
                zzlr[] zzlrVarArr = this.zzb;
                if (i >= 2) {
                    break;
                }
                if (zzlrVarArr[i].zzp(zzkpVar)) {
                    long jZzf = zzlrVarArr[i].zzf(zzkpVar);
                    if (jZzf == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    jZza = Math.max(jZzf, jZza);
                }
                i++;
            }
        }
        return jZza;
    }

    private final void zzai() {
        zzks zzksVar = this.zzs;
        zzksVar.zzt();
        zzkp zzkpVarZzl = zzksVar.zzl();
        if (zzkpVarZzl != null) {
            if (!zzkpVarZzl.zzd || zzkpVarZzl.zze) {
                zzus zzusVar = zzkpVarZzl.zza;
                if (zzusVar.zzn()) {
                    return;
                }
                if (this.zzg.zzj(this.zzv, this.zzG.zza, zzkpVarZzl.zzg.zza, zzkpVarZzl.zze ? zzusVar.zzi() : 0L)) {
                    if (!zzkpVarZzl.zzd) {
                        zzkpVarZzl.zzt(this, zzkpVarZzl.zzg.zzb);
                        return;
                    }
                    zzkm zzkmVar = new zzkm();
                    zzkmVar.zza(this.zzT - zzkpVarZzl.zza());
                    zzkmVar.zzb(this.zzo.zzj().zzb);
                    zzkmVar.zzc(this.zzM);
                    zzkpVarZzl.zzj(new zzkn(zzkmVar, null));
                }
            }
        }
    }

    private final void zzaj() {
        zzkp zzkpVarZzm = this.zzs.zzm();
        boolean z = false;
        if (zzkpVarZzm != null && zzkpVarZzm.zzg.zzi && this.zzJ) {
            z = true;
        }
        this.zzK = z;
    }

    private final void zzak(zzav zzavVar, boolean z) throws zzib {
        zzal(zzavVar, zzavVar.zzb, true, z);
    }

    private final void zzal(zzav zzavVar, float f, boolean z, boolean z2) throws zzib {
        int i;
        if (z) {
            if (z2) {
                this.zzH.zza(1);
            }
            zzlf zzlfVar = this.zzG;
            zzbf zzbfVar = zzlfVar.zza;
            zzuu zzuuVar = zzlfVar.zzb;
            long j = zzlfVar.zzc;
            long j2 = zzlfVar.zzd;
            int i2 = zzlfVar.zze;
            zzib zzibVar = zzlfVar.zzf;
            boolean z3 = zzlfVar.zzg;
            zzwv zzwvVar = zzlfVar.zzh;
            zzys zzysVar = zzlfVar.zzi;
            List list = zzlfVar.zzj;
            zzuu zzuuVar2 = zzlfVar.zzk;
            boolean z4 = zzlfVar.zzl;
            int i3 = zzlfVar.zzm;
            int i4 = zzlfVar.zzn;
            long j3 = zzlfVar.zzq;
            long j4 = zzlfVar.zzr;
            long j5 = zzlfVar.zzs;
            long j6 = zzlfVar.zzt;
            boolean z5 = zzlfVar.zzp;
            this.zzG = new zzlf(zzbfVar, zzuuVar, j, j2, i2, zzibVar, z3, zzwvVar, zzysVar, list, zzuuVar2, z4, i3, i4, zzavVar, j3, j4, j5, j6, false);
        }
        float f2 = zzavVar.zzb;
        zzkp zzkpVarZzm = this.zzs.zzm();
        while (true) {
            i = 0;
            if (zzkpVarZzm == null) {
                break;
            }
            zzyk[] zzykVarArr = zzkpVarZzm.zzr().zzc;
            int length = zzykVarArr.length;
            while (i < length) {
                zzyk zzykVar = zzykVarArr[i];
                i++;
            }
            zzkpVarZzm = zzkpVarZzm.zzp();
        }
        zzlr[] zzlrVarArr = this.zzb;
        while (i < 2) {
            zzlrVarArr[i].zzm(f, f2);
            i++;
        }
    }

    private final void zzam() {
        long jZza;
        long jZza2;
        zzks zzksVar;
        boolean zZzh;
        zzks zzksVar2 = this.zzs;
        if (zzaF(zzksVar2.zzk())) {
            zzkp zzkpVarZzk = zzksVar2.zzk();
            long jZzau = zzau(zzkpVarZzk.zzg());
            if (zzkpVarZzk == zzksVar2.zzm()) {
                jZza = this.zzT;
                jZza2 = zzkpVarZzk.zza();
            } else {
                jZza = this.zzT - zzkpVarZzk.zza();
                jZza2 = zzkpVarZzk.zzg.zzb;
            }
            zzksVar = zzksVar2;
            zzkk zzkkVar = new zzkk(this.zzv, this.zzG.zza, zzkpVarZzk.zzg.zza, jZza - jZza2, jZzau, this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : C.TIME_UNSET, this.zzM);
            zzkl zzklVar = this.zzg;
            zZzh = zzklVar.zzh(zzkkVar);
            zzkp zzkpVarZzm = zzksVar.zzm();
            if (!zZzh && zzkpVarZzm.zze && jZzau < 500000 && this.zzn > 0) {
                zzkpVarZzm.zza.zzf(this.zzG.zzs, false);
                zZzh = zzklVar.zzh(zzkkVar);
            }
        } else {
            zzksVar = zzksVar2;
            zZzh = false;
        }
        this.zzN = zZzh;
        if (zZzh) {
            zzkp zzkpVarZzk2 = zzksVar.zzk();
            zzkpVarZzk2.getClass();
            zzkm zzkmVar = new zzkm();
            zzkmVar.zza(this.zzT - zzkpVarZzk2.zza());
            zzkmVar.zzb(this.zzo.zzj().zzb);
            zzkmVar.zzc(this.zzM);
            zzkpVarZzk2.zzj(new zzkn(zzkmVar, null));
        }
        zzan();
    }

    private final void zzan() {
        zzkp zzkpVarZzk = this.zzs.zzk();
        boolean z = true;
        if (!this.zzN && (zzkpVarZzk == null || !zzkpVarZzk.zza.zzn())) {
            z = false;
        }
        zzlf zzlfVar = this.zzG;
        if (z != zzlfVar.zzg) {
            this.zzG = zzlfVar.zzg(z);
        }
    }

    private final zzlf zzao(zzuu zzuuVar, long j, long j2, long j3, boolean z, int i) {
        List listZzi;
        zzwv zzwvVar;
        zzys zzysVar;
        zzkp zzkpVarZzm;
        int i2 = 0;
        this.zzW = (!this.zzW && j == this.zzG.zzs && zzuuVar.equals(this.zzG.zzb)) ? false : true;
        zzaj();
        zzlf zzlfVar = this.zzG;
        zzwv zzwvVar2 = zzlfVar.zzh;
        zzys zzysVar2 = zzlfVar.zzi;
        List list = zzlfVar.zzj;
        if (this.zzt.zzb()) {
            zzks zzksVar = this.zzs;
            zzkp zzkpVarZzm2 = zzksVar.zzm();
            zzwv zzwvVarZzq = zzkpVarZzm2 == null ? zzwv.zza : zzkpVarZzm2.zzq();
            zzys zzysVarZzr = zzkpVarZzm2 == null ? this.zzf : zzkpVarZzm2.zzr();
            zzyk[] zzykVarArr = zzysVarZzr.zzc;
            zzgpb zzgpbVar = new zzgpb();
            boolean z2 = false;
            for (zzyk zzykVar : zzykVarArr) {
                if (zzykVar != null) {
                    zzap zzapVar = zzykVar.zzb(0).zzl;
                    if (zzapVar == null) {
                        zzgpbVar.zzf(new zzap(C.TIME_UNSET, new zzao[0]));
                    } else {
                        zzgpbVar.zzf(zzapVar);
                        z2 = true;
                    }
                }
            }
            zzgpe zzgpeVarZzi = z2 ? zzgpbVar.zzi() : zzgpe.zzi();
            if (zzkpVarZzm2 != null) {
                zzkq zzkqVar = zzkpVarZzm2.zzg;
                if (zzkqVar.zzc != j2) {
                    zzkpVarZzm2.zzg = zzkqVar.zzb(j2);
                }
            }
            if (zzksVar.zzm() == zzksVar.zzn() && (zzkpVarZzm = zzksVar.zzm()) != null) {
                zzys zzysVarZzr2 = zzkpVarZzm.zzr();
                while (true) {
                    zzlr[] zzlrVarArr = this.zzb;
                    if (i2 >= 2) {
                        break;
                    }
                    if (zzysVarZzr2.zza(i2)) {
                        if (zzlrVarArr[i2].zze() != 1) {
                            break;
                        }
                        int i3 = zzysVarZzr2.zzb[i2].zzb;
                    }
                    i2++;
                }
            }
            listZzi = zzgpeVarZzi;
            zzwvVar = zzwvVarZzq;
            zzysVar = zzysVarZzr;
        } else if (zzuuVar.equals(this.zzG.zzb)) {
            listZzi = list;
            zzwvVar = zzwvVar2;
            zzysVar = zzysVar2;
        } else {
            zzysVar = this.zzf;
            zzwvVar = zzwv.zza;
            listZzi = zzgpe.zzi();
        }
        if (z) {
            this.zzH.zzc(i);
        }
        return this.zzG.zzc(zzuuVar, j, j2, j3, zzat(), zzwvVar, zzysVar, listZzi);
    }

    private final void zzap() throws zzib {
        zzaq(new boolean[2], this.zzs.zzn().zzc());
    }

    private final void zzaq(boolean[] zArr, long j) throws zzib {
        zzlr[] zzlrVarArr;
        zzkp zzkpVarZzn = this.zzs.zzn();
        zzys zzysVarZzr = zzkpVarZzn.zzr();
        int i = 0;
        while (true) {
            zzlrVarArr = this.zzb;
            if (i >= 2) {
                break;
            }
            if (!zzysVarZzr.zza(i)) {
                zzlrVarArr[i].zzG();
            }
            i++;
        }
        for (int i2 = 0; i2 < 2; i2++) {
            if (zzysVarZzr.zza(i2) && !zzlrVarArr[i2].zzp(zzkpVarZzn)) {
                zzar(zzkpVarZzn, i2, zArr[i2], j);
            }
        }
    }

    private final void zzar(zzkp zzkpVar, int i, boolean z, long j) throws zzib {
        zzlr zzlrVar = this.zzb[i];
        if (zzlrVar.zzM()) {
            return;
        }
        boolean z2 = zzkpVar == this.zzs.zzm();
        zzys zzysVarZzr = zzkpVar.zzr();
        zzlq zzlqVar = zzysVarZzr.zzb[i];
        zzyk zzykVar = zzysVarZzr.zzc[i];
        boolean z3 = zzax() && this.zzG.zze == 3;
        boolean z4 = !z && z3;
        this.zzR++;
        zzlrVar.zzx(zzlqVar, zzykVar, zzkpVar.zzc[i], this.zzT, z4, z2, j, zzkpVar.zza(), zzkpVar.zzg.zza, this.zzo);
        zzlrVar.zzy(11, new zzjv(this), zzkpVar);
        if (z3 && z2) {
            zzlrVar.zzv();
        }
    }

    private final void zzas(boolean z) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        zzuu zzuuVar = zzkpVarZzk == null ? this.zzG.zzb : zzkpVarZzk.zzg.zza;
        boolean z2 = !this.zzG.zzk.equals(zzuuVar);
        if (z2) {
            this.zzG = this.zzG.zzh(zzuuVar);
        }
        zzlf zzlfVar = this.zzG;
        zzlfVar.zzq = zzkpVarZzk == null ? zzlfVar.zzs : zzkpVarZzk.zzf();
        this.zzG.zzr = zzat();
        if ((z2 || z) && zzkpVarZzk != null && zzkpVarZzk.zze) {
            zzaw(zzkpVarZzk.zzg.zza, zzkpVarZzk.zzq(), zzkpVarZzk.zzr());
        }
    }

    private final long zzat() {
        return zzau(this.zzG.zzq);
    }

    private final long zzau(long j) {
        zzkp zzkpVarZzk = this.zzs.zzk();
        if (zzkpVarZzk == null) {
            return 0L;
        }
        return Math.max(0L, j - (this.zzT - zzkpVarZzk.zza()));
    }

    private final long zzav(zzkp zzkpVar) {
        zzgmd.zzh(zzkpVar.zze);
        return (long) ((zzkpVar.zzc() - this.zzT) / this.zzo.zzj().zzb);
    }

    private final void zzaw(zzuu zzuuVar, zzwv zzwvVar, zzys zzysVar) {
        long jZza;
        long jZza2;
        zzks zzksVar = this.zzs;
        zzkp zzkpVarZzk = zzksVar.zzk();
        zzkpVarZzk.getClass();
        if (zzkpVarZzk == zzksVar.zzm()) {
            jZza = this.zzT;
            jZza2 = zzkpVarZzk.zza();
        } else {
            jZza = this.zzT - zzkpVarZzk.zza();
            jZza2 = zzkpVarZzk.zzg.zzb;
        }
        this.zzg.zzb(new zzkk(this.zzv, this.zzG.zza, zzuuVar, jZza - jZza2, zzau(zzkpVarZzk.zzf()), this.zzo.zzj().zzb, this.zzG.zzl, this.zzL, zzP(this.zzG.zza, zzkpVarZzk.zzg.zza) ? this.zzad.zze() : C.TIME_UNSET, this.zzM), zzwvVar, zzysVar.zzc);
    }

    private final boolean zzax() {
        zzlf zzlfVar = this.zzG;
        return zzlfVar.zzl && zzlfVar.zzn == 0;
    }

    private final void zzay(int i) throws zzib, IOException {
        zzlr zzlrVar = this.zzb[i];
        try {
            zzkp zzkpVarZzm = this.zzs.zzm();
            zzkpVarZzm.getClass();
            zzkp zzkpVar = zzkpVarZzm;
            zzlrVar.zzu(zzkpVarZzm);
        } catch (IOException | RuntimeException e) {
            zzlrVar.zze();
            throw e;
        }
    }

    private final boolean zzaz() {
        if (!this.zzy) {
            return false;
        }
        zzlr[] zzlrVarArr = this.zzb;
        for (int i = 0; i < 2; i++) {
            if (zzlrVarArr[i].zzc()) {
                return true;
            }
        }
        return false;
    }

    static int zzr(zzbe zzbeVar, zzbd zzbdVar, int i, boolean z, Object obj, zzbf zzbfVar, zzbf zzbfVar2) {
        Object obj2 = zzbfVar.zzb(zzbfVar.zzo(obj, zzbdVar).zzc, zzbeVar, 0L).zzb;
        for (int i2 = 0; i2 < zzbfVar2.zza(); i2++) {
            if (zzbfVar2.zzb(i2, zzbeVar, 0L).zzb.equals(obj2)) {
                return i2;
            }
        }
        int iZze = zzbfVar.zze(obj);
        int iZzc = zzbfVar.zzc();
        int iZzl = iZze;
        int i3 = 0;
        int iZze2 = -1;
        while (true) {
            if (i3 >= iZzc || iZze2 != -1) {
                break;
            }
            iZzl = zzbfVar.zzl(iZzl, zzbdVar, zzbeVar, i, z);
            if (iZzl == -1) {
                iZze2 = -1;
                break;
            }
            iZze2 = zzbfVar2.zze(zzbfVar.zzf(iZzl));
            i3++;
        }
        if (iZze2 == -1) {
            return -1;
        }
        return zzbfVar2.zzd(iZze2, zzbdVar, false).zzc;
    }

    static final /* synthetic */ void zzz(zzlj zzljVar) {
        try {
            zzaE(zzljVar);
        } catch (zzib e) {
            zzdt.zzf("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:250:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0592  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x059d A[Catch: zzib -> 0x0898, RuntimeException -> 0x0b41, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TRY_LEAVE, TryCatch #14 {zzib -> 0x0898, blocks: (B:189:0x0476, B:192:0x0480, B:206:0x04c2, B:211:0x04d7, B:251:0x058c, B:254:0x059d, B:210:0x04d4), top: B:696:0x0476 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x065a A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:311:0x0695 A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, LOOP:20: B:309:0x0692->B:311:0x0695, LOOP_END, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x06a3 A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:334:0x06ea A[Catch: RuntimeException -> 0x088f, zzib -> 0x0892, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TRY_ENTER, TRY_LEAVE, TryCatch #5 {RuntimeException -> 0x088f, blocks: (B:351:0x071a, B:387:0x07a9, B:390:0x07b6, B:392:0x07ba, B:394:0x07c0, B:396:0x07c6, B:398:0x07d0, B:403:0x07da, B:405:0x07e3, B:415:0x0811, B:327:0x06dc, B:334:0x06ea), top: B:686:0x06dc }] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x06f0 A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TRY_ENTER, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:385:0x07a6  */
    /* JADX WARN: Removed duplicated region for block: B:401:0x07d6 A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TRY_ENTER, TRY_LEAVE, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:407:0x07f8 A[Catch: zzib -> 0x06e7, RuntimeException -> 0x0799, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TRY_ENTER, TryCatch #8 {zzib -> 0x06e7, blocks: (B:362:0x073b, B:373:0x077e, B:375:0x0786, B:378:0x078f, B:401:0x07d6, B:407:0x07f8, B:409:0x0800, B:411:0x0808, B:283:0x0628, B:285:0x062f, B:287:0x0633, B:291:0x0644, B:320:0x06bd, B:293:0x064e, B:295:0x0652, B:300:0x065a, B:302:0x0662, B:304:0x067f, B:307:0x0688, B:308:0x068d, B:311:0x0695, B:312:0x069d, B:314:0x06a3, B:329:0x06e2, B:338:0x06f0, B:341:0x06f9, B:343:0x06ff, B:347:0x070d, B:349:0x0714), top: B:690:0x0590 }] */
    /* JADX WARN: Removed duplicated region for block: B:414:0x0810  */
    /* JADX WARN: Removed duplicated region for block: B:423:0x0849 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, LOOP:12: B:422:0x0847->B:423:0x0849, LOOP_END, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:426:0x0858 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0868 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:447:0x08af  */
    /* JADX WARN: Removed duplicated region for block: B:492:0x0973 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:523:0x0a29 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:524:0x0a36 A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:526:0x0a3d A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:534:0x0a5a A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:544:0x0a83  */
    /* JADX WARN: Removed duplicated region for block: B:567:0x0adf A[Catch: RuntimeException -> 0x0b37, zzib -> 0x0b39, IOException -> 0x0b6f, zztu -> 0x0b77, zzgc -> 0x0b7f, zzat -> 0x0b87, zzrr -> 0x0b9e, TryCatch #32 {zzib -> 0x0b39, RuntimeException -> 0x0b37, blocks: (B:435:0x0883, B:445:0x08a8, B:450:0x08b4, B:452:0x08bc, B:453:0x08c3, B:455:0x08d1, B:456:0x08eb, B:458:0x08ef, B:460:0x08f7, B:475:0x0929, B:461:0x08fc, B:463:0x0907, B:467:0x0914, B:473:0x0924, B:478:0x093a, B:480:0x0940, B:484:0x094d, B:486:0x0955, B:488:0x0959, B:489:0x0964, B:491:0x096a, B:542:0x0a7c, B:545:0x0a84, B:547:0x0a88, B:549:0x0a90, B:550:0x0a93, B:551:0x0a97, B:553:0x0a9d, B:555:0x0aa6, B:557:0x0ab0, B:559:0x0ab6, B:561:0x0ac1, B:568:0x0ae6, B:570:0x0aec, B:574:0x0af6, B:585:0x0b11, B:582:0x0b0a, B:584:0x0b0e, B:562:0x0ac8, B:565:0x0ad6, B:566:0x0ade, B:567:0x0adf, B:492:0x0973, B:494:0x0979, B:496:0x097d, B:521:0x0a1c, B:523:0x0a29, B:499:0x0987, B:501:0x098b, B:503:0x099d, B:505:0x09ab, B:507:0x09b5, B:511:0x09be, B:513:0x09c8, B:519:0x09d3, B:524:0x0a36, B:526:0x0a3d, B:528:0x0a41, B:532:0x0a4a, B:534:0x0a5a, B:536:0x0a60, B:538:0x0a6a, B:539:0x0a6f, B:540:0x0a74, B:541:0x0a79, B:477:0x0932, B:417:0x082c, B:419:0x083e, B:421:0x0844, B:423:0x0849, B:424:0x0851, B:426:0x0858, B:427:0x085b, B:428:0x0864, B:430:0x0868, B:432:0x086e, B:433:0x0873, B:589:0x0b1f, B:593:0x0b2a), top: B:685:0x0012 }] */
    /* JADX WARN: Removed duplicated region for block: B:586:0x0b16  */
    /* JADX WARN: Removed duplicated region for block: B:605:0x0b4d  */
    /* JADX WARN: Removed duplicated region for block: B:609:0x0b55  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0bb4  */
    /* JADX WARN: Removed duplicated region for block: B:640:0x0bcd  */
    /* JADX WARN: Removed duplicated region for block: B:659:0x0c2f  */
    /* JADX WARN: Removed duplicated region for block: B:661:0x0c33  */
    /* JADX WARN: Removed duplicated region for block: B:664:0x0c3e  */
    /* JADX WARN: Removed duplicated region for block: B:698:0x0720 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // android.os.Handler.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean handleMessage(android.os.Message r48) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 3334
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkh.handleMessage(android.os.Message):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zza(float f) {
        this.zzi.zzh(34);
    }

    @Override // com.google.android.gms.internal.ads.zzhp
    public final void zzb(int i) {
        this.zzi.zze(33, i, 0).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzhy
    public final void zzc(zzav zzavVar) {
        this.zzi.zzd(16, zzavVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzaax
    public final void zzcS(long j, long j2, zzv zzvVar, MediaFormat mediaFormat) {
        if (this.zzD) {
            this.zzi.zzc(37).zza();
        }
    }

    public final void zzd() {
        this.zzi.zzc(29).zza();
    }

    public final void zze(boolean z, int i, int i2) {
        this.zzi.zze(1, z ? 1 : 0, (i2 << 4) | 1).zza();
    }

    public final void zzf(zzbf zzbfVar, int i, long j) {
        this.zzi.zzd(3, new zzkg(zzbfVar, i, j)).zza();
    }

    public final void zzg(zzlu zzluVar) {
        this.zzi.zzd(38, zzluVar).zza();
    }

    public final void zzh() {
        this.zzi.zzc(6).zza();
    }

    public final void zzi(zzd zzdVar, boolean z) {
        this.zzi.zzf(31, 0, 0, zzdVar).zza();
    }

    public final void zzj(float f) {
        this.zzi.zzd(32, Float.valueOf(f)).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzlh
    public final void zzk(zzlj zzljVar) {
        if (!this.zzI && this.zzk.getThread().isAlive()) {
            this.zzi.zzd(14, zzljVar).zza();
        } else {
            zzdt.zzc("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            zzljVar.zzi(false);
        }
    }

    public final boolean zzl(Object obj, long j) {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(30, new Pair(obj, zzdfVar)).zza();
        if (j != C.TIME_UNSET) {
            return zzdfVar.zze(j);
        }
        return true;
    }

    public final boolean zzm() {
        if (this.zzI || !this.zzk.getThread().isAlive()) {
            return true;
        }
        this.zzI = true;
        zzdf zzdfVar = new zzdf(this.zzq);
        this.zzi.zzd(7, zzdfVar).zza();
        return zzdfVar.zze(this.zzu);
    }

    public final Looper zzn() {
        return this.zzk;
    }

    @Override // com.google.android.gms.internal.ads.zzld
    public final void zzo() {
        zzdm zzdmVar = this.zzi;
        zzdmVar.zzk(2);
        zzdmVar.zzh(22);
    }

    @Override // com.google.android.gms.internal.ads.zzur
    public final void zzp(zzus zzusVar) {
        this.zzi.zzd(8, zzusVar).zza();
    }

    @Override // com.google.android.gms.internal.ads.zzyq
    public final void zzq() {
        this.zzi.zzh(10);
    }

    @Override // com.google.android.gms.internal.ads.zzwl
    public final /* bridge */ /* synthetic */ void zzs(zzwm zzwmVar) {
        this.zzi.zzd(9, (zzus) zzwmVar).zza();
    }

    final /* synthetic */ zzkp zzt(zzkq zzkqVar, long j) {
        zzyv zzyvVarZze = this.zzg.zze(this.zzv);
        long j2 = this.zzZ.zzb;
        zzys zzysVar = this.zzf;
        zzle zzleVar = this.zzt;
        return new zzkp(this.zzc, j, this.zze, zzyvVarZze, zzleVar, zzkqVar, zzysVar, C.TIME_UNSET);
    }

    final /* synthetic */ void zzu(int i, boolean z) {
        this.zzw.zzB(i, this.zzb[i].zze(), z);
    }

    final /* synthetic */ void zzv(int i) {
        this.zzw.zzW(i);
    }

    final /* synthetic */ zzdm zzx() {
        return this.zzi;
    }

    public final void zzy(List list, int i, long j, zzwn zzwnVar) {
        this.zzi.zzd(17, new zzkb(list, zzwnVar, i, j, null)).zza();
    }
}
