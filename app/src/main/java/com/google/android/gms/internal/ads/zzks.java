package com.google.android.gms.internal.ads;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.MediaPeriodQueue;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
final class zzks {
    private final zzmi zzc;
    private final zzdm zzd;
    private long zze;
    private int zzf;
    private boolean zzg;
    private zzil zzh;
    private zzkp zzi;
    private zzkp zzj;
    private zzkp zzk;
    private zzkp zzl;
    private zzkp zzm;
    private int zzn;
    private Object zzo;
    private long zzp;
    private final zzka zzr;
    private final zzbd zza = new zzbd();
    private final zzbe zzb = new zzbe();
    private List zzq = new ArrayList();

    public zzks(zzmi zzmiVar, zzdm zzdmVar, zzka zzkaVar, zzil zzilVar) {
        this.zzc = zzmiVar;
        this.zzd = zzdmVar;
        this.zzr = zzkaVar;
        this.zzh = zzilVar;
    }

    private static zzuu zzA(zzbf zzbfVar, Object obj, long j, long j2, zzbe zzbeVar, zzbd zzbdVar) {
        zzbfVar.zzo(obj, zzbdVar);
        zzbfVar.zzb(zzbdVar.zzc, zzbeVar, 0L);
        zzbfVar.zze(obj);
        zzbdVar.zzb();
        zzbfVar.zzo(obj, zzbdVar);
        int iZze = zzbdVar.zze(j);
        return iZze == -1 ? new zzuu(obj, j2, zzbdVar.zzf(j)) : new zzuu(obj, iZze, zzbdVar.zzd(iZze), j2);
    }

    private final void zzB() {
        int i = zzgpe.zzd;
        final zzgpb zzgpbVar = new zzgpb();
        for (zzkp zzkpVarZzp = this.zzi; zzkpVarZzp != null; zzkpVarZzp = zzkpVarZzp.zzp()) {
            zzgpbVar.zzf(zzkpVarZzp.zzg.zza);
        }
        zzkp zzkpVar = this.zzj;
        final zzuu zzuuVar = zzkpVar == null ? null : zzkpVar.zzg.zza;
        this.zzd.zzm(new Runnable() { // from class: com.google.android.gms.internal.ads.zzkr
            @Override // java.lang.Runnable
            public final /* synthetic */ void run() {
                this.zza.zzz(zzgpbVar, zzuuVar);
            }
        });
    }

    private final long zzC(Object obj) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkp zzkpVar = (zzkp) this.zzq.get(i);
            if (zzkpVar.zzb.equals(obj)) {
                return zzkpVar.zzg.zza.zzd;
            }
        }
        return -1L;
    }

    private final int zzD(zzbf zzbfVar) {
        zzkp zzkpVarZzp = this.zzi;
        if (zzkpVarZzp == null) {
            return 0;
        }
        int iZze = zzbfVar.zze(zzkpVarZzp.zzb);
        while (true) {
            iZze = zzbfVar.zzl(iZze, this.zza, this.zzb, this.zzf, this.zzg);
            while (true) {
                zzkpVarZzp.getClass();
                if (zzkpVarZzp.zzp() == null || zzkpVarZzp.zzg.zzh) {
                    break;
                }
                zzkpVarZzp = zzkpVarZzp.zzp();
            }
            zzkp zzkpVarZzp2 = zzkpVarZzp.zzp();
            if (iZze == -1 || zzkpVarZzp2 == null || zzbfVar.zze(zzkpVarZzp2.zzb) != iZze) {
                break;
            }
            zzkpVarZzp = zzkpVarZzp2;
        }
        int iZzs = zzs(zzkpVarZzp);
        zzkpVarZzp.zzg = zzx(zzbfVar, zzkpVarZzp.zzg);
        return iZzs;
    }

    private final zzkq zzE(zzbf zzbfVar, zzkp zzkpVar, long j) {
        Object obj;
        int i;
        long j2;
        long j3;
        long j4;
        zzkq zzkqVar = zzkpVar.zzg;
        long jZza = zzkpVar.zza();
        long j5 = zzkqVar.zze;
        long j6 = (jZza + j5) - j;
        if (zzkqVar.zzh) {
            zzuu zzuuVar = zzkqVar.zza;
            Object obj2 = zzuuVar.zza;
            int iZze = zzbfVar.zze(obj2);
            int i2 = this.zzf;
            boolean z = this.zzg;
            zzbe zzbeVar = this.zzb;
            zzbd zzbdVar = this.zza;
            int iZzl = zzbfVar.zzl(iZze, zzbdVar, zzbeVar, i2, z);
            if (iZzl != -1) {
                int i3 = zzbfVar.zzd(iZzl, zzbdVar, true).zzc;
                Object obj3 = zzbdVar.zzb;
                obj3.getClass();
                long jZzC = zzuuVar.zzd;
                if (zzbfVar.zzb(i3, zzbeVar, 0L).zzn == iZzl) {
                    Pair pairZzn = zzbfVar.zzn(zzbeVar, zzbdVar, i3, C.TIME_UNSET, Math.max(0L, j6));
                    if (pairZzn != null) {
                        obj3 = pairZzn.first;
                        long jLongValue = ((Long) pairZzn.second).longValue();
                        zzkp zzkpVarZzp = zzkpVar.zzp();
                        if (zzkpVarZzp == null || !zzkpVarZzp.zzb.equals(obj3)) {
                            jZzC = zzC(obj3);
                            if (jZzC == -1) {
                                jZzC = this.zze;
                                this.zze = 1 + jZzC;
                            }
                        } else {
                            jZzC = zzkpVarZzp.zzg.zza.zzd;
                        }
                        j4 = jLongValue;
                        j3 = C.TIME_UNSET;
                    }
                } else {
                    j3 = 0;
                    j4 = 0;
                }
                zzuu zzuuVarZzA = zzA(zzbfVar, obj3, j4, jZzC, zzbeVar, zzbdVar);
                if (j3 != C.TIME_UNSET && zzkqVar.zzc != C.TIME_UNSET) {
                    zzbfVar.zzo(obj2, zzbdVar).zzb();
                    int i4 = zzbdVar.zzg.zzd;
                }
                return zzF(zzbfVar, zzuuVarZzA, j3, j4);
            }
        } else {
            zzuu zzuuVar2 = zzkqVar.zza;
            Object obj4 = zzuuVar2.zza;
            zzbd zzbdVar2 = this.zza;
            zzbfVar.zzo(obj4, zzbdVar2);
            boolean z2 = zzkqVar.zzg;
            if (!zzuuVar2.zzb()) {
                int i5 = zzuuVar2.zze;
                if (i5 != -1) {
                    zzbdVar2.zzi(i5);
                }
                int iZzd = zzbdVar2.zzd(i5);
                zzbdVar2.zzk(i5);
                if (iZzd != zzbdVar2.zzg(i5)) {
                    return zzG(zzbfVar, obj4, i5, iZzd, j5, zzuuVar2.zzd, false);
                }
                zzK(zzbfVar, obj4, i5);
                return zzH(zzbfVar, obj4, 0L, j5, zzuuVar2.zzd, false);
            }
            int i6 = zzuuVar2.zzb;
            if (zzbdVar2.zzg(i6) != -1) {
                int iZza = zzbdVar2.zzg.zza(i6).zza(zzuuVar2.zzc);
                if (iZza < 0) {
                    return zzG(zzbfVar, obj4, i6, iZza, zzkqVar.zzc, zzuuVar2.zzd, false);
                }
                long jLongValue2 = zzkqVar.zzc;
                if (jLongValue2 == C.TIME_UNSET) {
                    obj = obj4;
                    i = i6;
                    Pair pairZzn2 = zzbfVar.zzn(this.zzb, zzbdVar2, zzbdVar2.zzc, C.TIME_UNSET, Math.max(0L, j6));
                    if (pairZzn2 != null) {
                        jLongValue2 = ((Long) pairZzn2.second).longValue();
                        j2 = -9223372036854775807L;
                    }
                } else {
                    obj = obj4;
                    i = i6;
                    j2 = jLongValue2;
                }
                zzK(zzbfVar, obj, i);
                return zzH(zzbfVar, obj, Math.max(0L, jLongValue2), j2, zzuuVar2.zzd, false);
            }
        }
        return null;
    }

    private final zzkq zzF(zzbf zzbfVar, zzuu zzuuVar, long j, long j2) {
        Object obj = zzuuVar.zza;
        zzbfVar.zzo(obj, this.zza);
        return zzuuVar.zzb() ? zzG(zzbfVar, obj, zzuuVar.zzb, zzuuVar.zzc, j, zzuuVar.zzd, false) : zzH(zzbfVar, obj, j2, j, zzuuVar.zzd, false);
    }

    private final zzkq zzG(zzbf zzbfVar, Object obj, int i, int i2, long j, long j2, boolean z) {
        zzuu zzuuVar = new zzuu(obj, i, i2, j2);
        Object obj2 = zzuuVar.zza;
        int i3 = zzuuVar.zzb;
        int i4 = zzuuVar.zzc;
        zzbd zzbdVar = this.zza;
        long jZzh = zzbfVar.zzo(obj2, zzbdVar).zzh(i3, i4);
        if (i2 == zzbdVar.zzd(i)) {
            zzbdVar.zzj();
        }
        zzbdVar.zzk(i3);
        return new zzkq(zzuuVar, (jZzh == C.TIME_UNSET || jZzh > 0) ? 0L : Math.max(0L, (-1) + jZzh), j, C.TIME_UNSET, jZzh, false, false, false, false, false);
    }

    private final zzkq zzH(zzbf zzbfVar, Object obj, long j, long j2, long j3, boolean z) {
        long j4;
        long j5;
        long j6;
        long jMax = j;
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        int iZzf = zzbdVar.zzf(jMax);
        if (iZzf == -1) {
            zzbdVar.zzb();
        } else {
            zzbdVar.zzk(iZzf);
        }
        zzuu zzuuVar = new zzuu(obj, j3, iZzf);
        boolean zZzL = zzL(zzuuVar);
        boolean zZzI = zzI(zzbfVar, zzuuVar);
        boolean zZzJ = zzJ(zzbfVar, zzuuVar, zZzL);
        if (iZzf != -1) {
            zzbdVar.zzk(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzi(iZzf);
        }
        if (iZzf != -1) {
            zzbdVar.zzc(iZzf);
            j4 = 0;
        } else {
            j4 = -9223372036854775807L;
        }
        if (j4 != C.TIME_UNSET) {
            j6 = j4;
            j5 = j6;
        } else {
            j5 = zzbdVar.zzd;
            j6 = -9223372036854775807L;
        }
        if (j5 != C.TIME_UNSET && jMax >= j5) {
            jMax = Math.max(0L, j5 - 1);
        }
        return new zzkq(zzuuVar, jMax, j2, j6, j5, false, false, zZzL, zZzI, zZzJ);
    }

    private final boolean zzI(zzbf zzbfVar, zzuu zzuuVar) {
        if (!zzL(zzuuVar)) {
            return false;
        }
        Object obj = zzuuVar.zza;
        return zzbfVar.zzb(zzbfVar.zzo(obj, this.zza).zzc, this.zzb, 0L).zzo == zzbfVar.zze(obj);
    }

    private final boolean zzJ(zzbf zzbfVar, zzuu zzuuVar, boolean z) {
        int iZze = zzbfVar.zze(zzuuVar.zza);
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzd(iZze, zzbdVar, false).zzc;
        zzbe zzbeVar = this.zzb;
        return !zzbfVar.zzb(i, zzbeVar, 0L).zzi && zzbfVar.zzl(iZze, zzbdVar, zzbeVar, this.zzf, this.zzg) == -1 && z;
    }

    private final long zzK(zzbf zzbfVar, Object obj, int i) {
        zzbd zzbdVar = this.zza;
        zzbfVar.zzo(obj, zzbdVar);
        zzbdVar.zzc(i);
        long j = zzbdVar.zzg.zza(i).zzi;
        return 0L;
    }

    private static final boolean zzL(zzuu zzuuVar) {
        return !zzuuVar.zzb() && zzuuVar.zze == -1;
    }

    public final int zza(zzbf zzbfVar, int i) {
        this.zzf = i;
        return zzD(zzbfVar);
    }

    public final int zzb(zzbf zzbfVar, boolean z) {
        this.zzg = z;
        return zzD(zzbfVar);
    }

    public final void zzc(zzbf zzbfVar, zzil zzilVar) {
        this.zzh = zzilVar;
        long j = zzilVar.zzb;
        zzj();
    }

    public final boolean zzd(zzus zzusVar) {
        zzkp zzkpVar = this.zzl;
        return zzkpVar != null && zzkpVar.zza == zzusVar;
    }

    public final boolean zze(zzus zzusVar) {
        zzkp zzkpVar = this.zzm;
        return zzkpVar != null && zzkpVar.zza == zzusVar;
    }

    public final void zzf(long j) {
        zzkp zzkpVar = this.zzl;
        if (zzkpVar != null) {
            zzkpVar.zzi(j);
        }
    }

    public final boolean zzg() {
        zzkp zzkpVar = this.zzl;
        if (zzkpVar == null) {
            return true;
        }
        if (zzkpVar.zzg.zzj || !zzkpVar.zzd() || this.zzl.zzg.zze == C.TIME_UNSET) {
            return false;
        }
        return this.zzn < 100;
    }

    public final zzkq zzh(long j, zzlf zzlfVar) {
        zzkp zzkpVar = this.zzl;
        return zzkpVar == null ? zzF(zzlfVar.zza, zzlfVar.zzb, zzlfVar.zzc, zzlfVar.zzs) : zzE(zzlfVar.zza, zzkpVar, j);
    }

    public final void zzj() {
        if (this.zzq.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.zzq.size(); i++) {
            ((zzkp) this.zzq.get(i)).zzn();
        }
        this.zzq = arrayList;
        this.zzm = null;
        zzt();
    }

    public final zzkp zzk() {
        return this.zzl;
    }

    public final zzkp zzl() {
        return this.zzm;
    }

    public final zzkp zzm() {
        return this.zzi;
    }

    public final zzkp zzn() {
        return this.zzj;
    }

    public final zzkp zzo() {
        return this.zzk;
    }

    public final zzkp zzp() {
        zzkp zzkpVar = this.zzk;
        zzkp zzkpVar2 = this.zzj;
        if (zzkpVar == zzkpVar2) {
            zzkpVar2.getClass();
            this.zzk = zzkpVar2.zzp();
        }
        zzkpVar2.getClass();
        this.zzj = zzkpVar2.zzp();
        zzB();
        zzkp zzkpVar3 = this.zzj;
        zzkpVar3.getClass();
        return zzkpVar3;
    }

    public final zzkp zzq() {
        zzkp zzkpVar = this.zzk;
        zzkpVar.getClass();
        this.zzk = zzkpVar.zzp();
        zzB();
        zzkp zzkpVar2 = this.zzk;
        zzkpVar2.getClass();
        return zzkpVar2;
    }

    public final zzkp zzr() {
        zzkp zzkpVar = this.zzi;
        if (zzkpVar == null) {
            return null;
        }
        if (zzkpVar == this.zzj) {
            this.zzj = zzkpVar.zzp();
        }
        if (zzkpVar == this.zzk) {
            this.zzk = zzkpVar.zzp();
        }
        zzkpVar.zzn();
        int i = this.zzn - 1;
        this.zzn = i;
        if (i == 0) {
            this.zzl = null;
            zzkp zzkpVar2 = this.zzi;
            this.zzo = zzkpVar2.zzb;
            this.zzp = zzkpVar2.zzg.zza.zzd;
        }
        this.zzi = this.zzi.zzp();
        zzB();
        return this.zzi;
    }

    public final void zzt() {
        zzkp zzkpVar = this.zzm;
        if (zzkpVar == null || zzkpVar.zze()) {
            this.zzm = null;
            for (int i = 0; i < this.zzq.size(); i++) {
                zzkp zzkpVar2 = (zzkp) this.zzq.get(i);
                if (!zzkpVar2.zze()) {
                    this.zzm = zzkpVar2;
                    return;
                }
            }
        }
    }

    public final zzkp zzu(zzus zzusVar) {
        for (int i = 0; i < this.zzq.size(); i++) {
            zzkp zzkpVar = (zzkp) this.zzq.get(i);
            if (zzkpVar.zza == zzusVar) {
                return zzkpVar;
            }
        }
        return null;
    }

    public final void zzv() {
        if (this.zzn == 0) {
            return;
        }
        zzkp zzkpVarZzp = this.zzi;
        zzkpVarZzp.getClass();
        this.zzo = zzkpVarZzp.zzb;
        this.zzp = zzkpVarZzp.zzg.zza.zzd;
        while (zzkpVarZzp != null) {
            zzkpVarZzp.zzn();
            zzkpVarZzp = zzkpVarZzp.zzp();
        }
        this.zzi = null;
        this.zzl = null;
        this.zzj = null;
        this.zzk = null;
        this.zzn = 0;
        zzB();
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00a5, code lost:
    
        return zzs(r3);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzw(com.google.android.gms.internal.ads.zzbf r17, long r18, long r20, long r22) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzkp r2 = r0.zzi
            r3 = 0
        L7:
            r4 = 0
            if (r2 == 0) goto La6
            com.google.android.gms.internal.ads.zzkq r5 = r2.zzg
            if (r3 != 0) goto L15
            com.google.android.gms.internal.ads.zzkq r3 = r0.zzx(r1, r5)
            r6 = r18
            goto L30
        L15:
            r6 = r18
            com.google.android.gms.internal.ads.zzkq r8 = r0.zzE(r1, r3, r6)
            if (r8 == 0) goto La1
            long r9 = r5.zzb
            long r11 = r8.zzb
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto La1
            com.google.android.gms.internal.ads.zzuu r9 = r5.zza
            com.google.android.gms.internal.ads.zzuu r10 = r8.zza
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto La1
            r3 = r8
        L30:
            long r8 = r5.zzc
            com.google.android.gms.internal.ads.zzkq r8 = r3.zzb(r8)
            r2.zzg = r8
            long r8 = r5.zze
            long r10 = r3.zze
            int r3 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r3 == 0) goto L98
            r2.zzs()
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r10 > r6 ? 1 : (r10 == r6 ? 0 : -1))
            if (r1 != 0) goto L52
            r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            goto L57
        L52:
            long r12 = r2.zza()
            long r10 = r10 + r12
        L57:
            com.google.android.gms.internal.ads.zzkp r1 = r0.zzj
            r12 = -9223372036854775808
            r3 = 1
            if (r2 != r1) goto L6c
            com.google.android.gms.internal.ads.zzkq r1 = r2.zzg
            boolean r1 = r1.zzg
            int r1 = (r20 > r12 ? 1 : (r20 == r12 ? 0 : -1))
            if (r1 == 0) goto L6a
            int r1 = (r20 > r10 ? 1 : (r20 == r10 ? 0 : -1))
            if (r1 < 0) goto L6c
        L6a:
            r1 = r3
            goto L6d
        L6c:
            r1 = r4
        L6d:
            com.google.android.gms.internal.ads.zzkp r14 = r0.zzk
            if (r2 != r14) goto L7b
            int r12 = (r22 > r12 ? 1 : (r22 == r12 ? 0 : -1))
            if (r12 == 0) goto L79
            int r10 = (r22 > r10 ? 1 : (r22 == r10 ? 0 : -1))
            if (r10 < 0) goto L7b
        L79:
            r10 = r3
            goto L7c
        L7b:
            r10 = r4
        L7c:
            int r2 = r0.zzs(r2)
            if (r2 == 0) goto L83
            return r2
        L83:
            int r2 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r2 != 0) goto L8a
            long r8 = r5.zzd
            r8 = r6
        L8a:
            if (r1 == 0) goto L92
            int r1 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r1 != 0) goto L91
            goto L92
        L91:
            r4 = r3
        L92:
            if (r10 == 0) goto L97
            r1 = r4 | 2
            return r1
        L97:
            return r4
        L98:
            com.google.android.gms.internal.ads.zzkp r3 = r2.zzp()
            r15 = r3
            r3 = r2
            r2 = r15
            goto L7
        La1:
            int r1 = r0.zzs(r3)
            return r1
        La6:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzks.zzw(com.google.android.gms.internal.ads.zzbf, long, long, long):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.google.android.gms.internal.ads.zzkq zzx(com.google.android.gms.internal.ads.zzbf r22, com.google.android.gms.internal.ads.zzkq r23) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            r2 = r23
            com.google.android.gms.internal.ads.zzuu r3 = r2.zza
            boolean r13 = zzL(r3)
            boolean r14 = r0.zzI(r1, r3)
            boolean r15 = r0.zzJ(r1, r3, r13)
            java.lang.Object r4 = r3.zza
            com.google.android.gms.internal.ads.zzbd r5 = r0.zza
            r1.zzo(r4, r5)
            boolean r1 = r3.zzb()
            r4 = -1
            r6 = 0
            r8 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r1 != 0) goto L33
            int r1 = r3.zze
            if (r1 != r4) goto L2e
            goto L33
        L2e:
            r5.zzc(r1)
            r10 = r6
            goto L34
        L33:
            r10 = r8
        L34:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L48
            int r1 = r3.zzb
            int r6 = r3.zzc
            long r6 = r5.zzh(r1, r6)
        L42:
            r19 = r6
            r7 = r10
            r9 = r19
            goto L52
        L48:
            int r1 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r1 == 0) goto L4f
            r9 = r6
            r7 = r9
            goto L52
        L4f:
            long r6 = r5.zzd
            goto L42
        L52:
            boolean r1 = r3.zzb()
            if (r1 == 0) goto L5e
            int r1 = r3.zzb
            r5.zzk(r1)
            goto L65
        L5e:
            int r1 = r3.zze
            if (r1 == r4) goto L65
            r5.zzk(r1)
        L65:
            com.google.android.gms.internal.ads.zzkq r16 = new com.google.android.gms.internal.ads.zzkq
            long r4 = r2.zzb
            long r11 = r2.zzc
            boolean r1 = r2.zzf
            r17 = 0
            r18 = 0
            r1 = r16
            r2 = r3
            r3 = r4
            r5 = r11
            r11 = r17
            r12 = r18
            r1.<init>(r2, r3, r5, r7, r9, r11, r12, r13, r14, r15)
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzks.zzx(com.google.android.gms.internal.ads.zzbf, com.google.android.gms.internal.ads.zzkq):com.google.android.gms.internal.ads.zzkq");
    }

    public final zzuu zzy(zzbf zzbfVar, Object obj, long j) {
        long jZzC;
        int iZze;
        zzbd zzbdVar = this.zza;
        int i = zzbfVar.zzo(obj, zzbdVar).zzc;
        Object obj2 = this.zzo;
        if (obj2 == null || (iZze = zzbfVar.zze(obj2)) == -1 || zzbfVar.zzd(iZze, zzbdVar, false).zzc != i) {
            zzkp zzkpVarZzp = this.zzi;
            while (true) {
                if (zzkpVarZzp == null) {
                    zzkp zzkpVarZzp2 = this.zzi;
                    while (true) {
                        if (zzkpVarZzp2 != null) {
                            int iZze2 = zzbfVar.zze(zzkpVarZzp2.zzb);
                            if (iZze2 != -1 && zzbfVar.zzd(iZze2, zzbdVar, false).zzc == i) {
                                jZzC = zzkpVarZzp2.zzg.zza.zzd;
                                break;
                            }
                            zzkpVarZzp2 = zzkpVarZzp2.zzp();
                        } else {
                            jZzC = zzC(obj);
                            if (jZzC == -1) {
                                jZzC = this.zze;
                                this.zze = 1 + jZzC;
                                if (this.zzi == null) {
                                    this.zzo = obj;
                                    this.zzp = jZzC;
                                }
                            }
                        }
                    }
                } else {
                    if (zzkpVarZzp.zzb.equals(obj)) {
                        jZzC = zzkpVarZzp.zzg.zza.zzd;
                        break;
                    }
                    zzkpVarZzp = zzkpVarZzp.zzp();
                }
            }
        } else {
            jZzC = this.zzp;
        }
        long j2 = jZzC;
        zzbfVar.zzo(obj, zzbdVar);
        int i2 = zzbdVar.zzc;
        zzbe zzbeVar = this.zzb;
        zzbfVar.zzb(i2, zzbeVar, 0L);
        Object obj3 = obj;
        for (int iZze3 = zzbfVar.zze(obj); iZze3 >= zzbeVar.zzn; iZze3--) {
            zzbfVar.zzd(iZze3, zzbdVar, true);
            zzbdVar.zzb();
            if (zzbdVar.zze(zzbdVar.zzd) != -1) {
                Object obj4 = zzbdVar.zzb;
                obj4.getClass();
                obj3 = obj4;
            }
        }
        return zzA(zzbfVar, obj3, j, j2, zzbeVar, zzbdVar);
    }

    final /* synthetic */ void zzz(zzgpb zzgpbVar, zzuu zzuuVar) {
        this.zzc.zzz(zzgpbVar.zzi(), zzuuVar);
    }

    public final zzkp zzi(zzkq zzkqVar) {
        zzkp zzkpVarZza;
        zzkp zzkpVar = this.zzl;
        long jZza = zzkpVar == null ? MediaPeriodQueue.INITIAL_RENDERER_POSITION_OFFSET_US : (zzkpVar.zza() + zzkpVar.zzg.zze) - zzkqVar.zzb;
        int i = 0;
        while (true) {
            if (i >= this.zzq.size()) {
                zzkpVarZza = null;
                break;
            }
            zzkq zzkqVar2 = ((zzkp) this.zzq.get(i)).zzg;
            long j = zzkqVar2.zze;
            long j2 = zzkqVar.zze;
            if ((j == C.TIME_UNSET || j == j2) && zzkqVar2.zzb == zzkqVar.zzb && zzkqVar2.zza.equals(zzkqVar.zza)) {
                zzkpVarZza = (zzkp) this.zzq.remove(i);
                break;
            }
            i++;
        }
        if (zzkpVarZza == null) {
            zzkpVarZza = this.zzr.zza(zzkqVar, jZza);
        } else {
            zzkpVarZza.zzg = zzkqVar;
            zzkpVarZza.zzb(jZza);
        }
        zzkp zzkpVar2 = this.zzl;
        if (zzkpVar2 != null) {
            zzkpVar2.zzo(zzkpVarZza);
        } else {
            this.zzi = zzkpVarZza;
            this.zzj = zzkpVarZza;
            this.zzk = zzkpVarZza;
        }
        this.zzo = null;
        this.zzl = zzkpVarZza;
        this.zzn++;
        zzB();
        return zzkpVarZza;
    }

    public final int zzs(zzkp zzkpVar) {
        zzkpVar.getClass();
        int i = 0;
        if (zzkpVar.equals(this.zzl)) {
            return 0;
        }
        this.zzl = zzkpVar;
        while (zzkpVar.zzp() != null) {
            zzkpVar = zzkpVar.zzp();
            zzkpVar.getClass();
            if (zzkpVar == this.zzj) {
                zzkp zzkpVar2 = this.zzi;
                this.zzj = zzkpVar2;
                this.zzk = zzkpVar2;
                i = 3;
            }
            if (zzkpVar == this.zzk) {
                this.zzk = this.zzj;
                i |= 2;
            }
            zzkpVar.zzn();
            this.zzn--;
        }
        zzkp zzkpVar3 = this.zzl;
        zzkpVar3.getClass();
        zzkpVar3.zzo(null);
        zzB();
        return i;
    }
}
