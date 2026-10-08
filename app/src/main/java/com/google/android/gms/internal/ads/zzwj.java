package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzwj implements zzaem {
    private boolean zzB;
    private final zzwe zza;
    private final zzrz zzd;
    private final zzru zze;
    private zzwi zzf;
    private zzv zzg;
    private zzrs zzh;
    private int zzp;
    private int zzq;
    private int zzr;
    private int zzs;
    private boolean zzw;
    private zzv zzz;
    private final zzwf zzb = new zzwf();
    private int zzi = 1000;
    private long[] zzj = new long[1000];
    private long[] zzk = new long[1000];
    private long[] zzn = new long[1000];
    private int[] zzm = new int[1000];
    private int[] zzl = new int[1000];
    private zzael[] zzo = new zzael[1000];
    private final zzwq zzc = new zzwq(zzwg.zza);
    private long zzt = Long.MIN_VALUE;
    private long zzu = Long.MIN_VALUE;
    private long zzv = Long.MIN_VALUE;
    private boolean zzy = true;
    private boolean zzx = true;
    private boolean zzA = true;

    protected zzwj(zzyv zzyvVar, zzrz zzrzVar, zzru zzruVar) {
        this.zzd = zzrzVar;
        this.zze = zzruVar;
        this.zza = new zzwe(zzyvVar);
    }

    private final synchronized void zzA() {
        this.zzs = 0;
        this.zza.zzb();
    }

    private final synchronized int zzB(zzkj zzkjVar, zzhh zzhhVar, boolean z, boolean z2, zzwf zzwfVar) {
        zzhhVar.zzd = false;
        if (!zzH()) {
            if (!z2 && !this.zzw) {
                zzv zzvVar = this.zzz;
                if (zzvVar == null || (!z && zzvVar == this.zzg)) {
                    return -3;
                }
                zzI(zzvVar, zzkjVar);
                return -5;
            }
            zzhhVar.zzg(4);
            zzhhVar.zze = Long.MIN_VALUE;
            return -4;
        }
        zzv zzvVar2 = ((zzwh) this.zzc.zza(this.zzq + this.zzs)).zza;
        if (!z && zzvVar2 == this.zzg) {
            int iZzM = zzM(this.zzs);
            if (!zzJ(iZzM)) {
                zzhhVar.zzd = true;
                return -3;
            }
            zzhhVar.zzg(this.zzm[iZzM]);
            if (this.zzs == this.zzp - 1 && (z2 || this.zzw)) {
                zzhhVar.zzh(536870912);
            }
            zzhhVar.zze = this.zzn[iZzM];
            zzwfVar.zza = this.zzl[iZzM];
            zzwfVar.zzb = this.zzk[iZzM];
            zzwfVar.zzc = this.zzo[iZzM];
            return -4;
        }
        zzI(zzvVar2, zzkjVar);
        return -5;
    }

    private final synchronized boolean zzC(zzv zzvVar) {
        this.zzy = false;
        if (Objects.equals(zzvVar, this.zzz)) {
            return false;
        }
        zzwq zzwqVar = this.zzc;
        if (zzwqVar.zzf() || !((zzwh) zzwqVar.zzc()).zza.equals(zzvVar)) {
            this.zzz = zzvVar;
        } else {
            this.zzz = ((zzwh) zzwqVar.zzc()).zza;
        }
        boolean z = this.zzA;
        zzv zzvVar2 = this.zzz;
        this.zzA = z & zzas.zzd(zzvVar2.zzo, zzvVar2.zzk);
        this.zzB = false;
        return true;
    }

    private final synchronized long zzD(long j, boolean z, boolean z2) {
        int i;
        int i2 = this.zzp;
        if (i2 != 0) {
            long[] jArr = this.zzn;
            int i3 = this.zzr;
            if (j >= jArr[i3]) {
                if (z2 && (i = this.zzs) != i2) {
                    i2 = i + 1;
                }
                int iZzK = zzK(i3, i2, j, false);
                if (iZzK != -1) {
                    return zzL(iZzK);
                }
            }
        }
        return -1L;
    }

    private final synchronized long zzE() {
        int i = this.zzp;
        if (i == 0) {
            return -1L;
        }
        return zzL(i);
    }

    private final void zzF() {
        if (this.zzh != null) {
            this.zzh = null;
            this.zzg = null;
        }
    }

    private final synchronized void zzG(long j, int i, long j2, int i2, zzael zzaelVar) {
        int i3 = this.zzp;
        if (i3 > 0) {
            int iZzM = zzM(i3 - 1);
            zzgmd.zza(this.zzk[iZzM] + ((long) this.zzl[iZzM]) <= j2);
        }
        this.zzw = (536870912 & i) != 0;
        this.zzv = Math.max(this.zzv, j);
        int iZzM2 = zzM(this.zzp);
        this.zzn[iZzM2] = j;
        this.zzk[iZzM2] = j2;
        this.zzl[iZzM2] = i2;
        this.zzm[iZzM2] = i;
        this.zzo[iZzM2] = zzaelVar;
        this.zzj[iZzM2] = 0;
        zzwq zzwqVar = this.zzc;
        if (zzwqVar.zzf() || !((zzwh) zzwqVar.zzc()).zza.equals(this.zzz)) {
            zzv zzvVar = this.zzz;
            zzvVar.getClass();
            zzwqVar.zzb(this.zzq + this.zzp, new zzwh(zzvVar, zzry.zzb, null));
        }
        int i4 = this.zzp + 1;
        this.zzp = i4;
        int i5 = this.zzi;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            long[] jArr3 = new long[i6];
            int[] iArr = new int[i6];
            int[] iArr2 = new int[i6];
            zzael[] zzaelVarArr = new zzael[i6];
            int i7 = this.zzr;
            int i8 = i5 - i7;
            System.arraycopy(this.zzk, i7, jArr2, 0, i8);
            System.arraycopy(this.zzn, this.zzr, jArr3, 0, i8);
            System.arraycopy(this.zzm, this.zzr, iArr, 0, i8);
            System.arraycopy(this.zzl, this.zzr, iArr2, 0, i8);
            System.arraycopy(this.zzo, this.zzr, zzaelVarArr, 0, i8);
            System.arraycopy(this.zzj, this.zzr, jArr, 0, i8);
            int i9 = this.zzr;
            System.arraycopy(this.zzk, 0, jArr2, i8, i9);
            System.arraycopy(this.zzn, 0, jArr3, i8, i9);
            System.arraycopy(this.zzm, 0, iArr, i8, i9);
            System.arraycopy(this.zzl, 0, iArr2, i8, i9);
            System.arraycopy(this.zzo, 0, zzaelVarArr, i8, i9);
            System.arraycopy(this.zzj, 0, jArr, i8, i9);
            this.zzk = jArr2;
            this.zzn = jArr3;
            this.zzm = iArr;
            this.zzl = iArr2;
            this.zzo = zzaelVarArr;
            this.zzj = jArr;
            this.zzr = 0;
            this.zzi = i6;
        }
    }

    private final boolean zzH() {
        return this.zzs != this.zzp;
    }

    private final void zzI(zzv zzvVar, zzkj zzkjVar) {
        zzv zzvVar2 = this.zzg;
        zzq zzqVar = zzvVar2 == null ? null : zzvVar2.zzs;
        this.zzg = zzvVar;
        zzq zzqVar2 = zzvVar.zzs;
        zzrz zzrzVar = this.zzd;
        zzkjVar.zzb = zzvVar.zzb(zzrzVar.zzb(zzvVar));
        zzkjVar.zza = this.zzh;
        if (zzvVar2 == null || !Objects.equals(zzqVar, zzqVar2)) {
            zzrs zzrsVarZza = zzrzVar.zza(this.zze, zzvVar);
            this.zzh = zzrsVarZza;
            zzkjVar.zza = zzrsVarZza;
        }
    }

    private final boolean zzJ(int i) {
        if (this.zzh != null) {
            return (this.zzm[i] & 1073741824) != 0 ? false : false;
        }
        return true;
    }

    private final int zzK(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.zzn[i];
            if (j2 > j) {
                break;
            }
            if (!z || (this.zzm[i] & 1) != 0) {
                i3 = i4;
                if (j2 == j) {
                    break;
                }
            }
            i++;
            if (i == this.zzi) {
                i = 0;
            }
        }
        return i3;
    }

    private final int zzM(int i) {
        int i2 = this.zzr + i;
        int i3 = this.zzi;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final void zza() {
        zzb(true);
        zzF();
    }

    public final void zzb(boolean z) {
        this.zza.zza();
        this.zzp = 0;
        this.zzq = 0;
        this.zzr = 0;
        this.zzs = 0;
        this.zzx = true;
        this.zzt = Long.MIN_VALUE;
        this.zzu = Long.MIN_VALUE;
        this.zzv = Long.MIN_VALUE;
        this.zzw = false;
        this.zzc.zze();
        if (z) {
            this.zzz = null;
            this.zzy = true;
            this.zzA = true;
        }
    }

    public final void zzc(long j) {
        this.zzt = j;
    }

    public final int zzd() {
        return this.zzq + this.zzp;
    }

    public final void zze() {
        zzs();
        zzF();
    }

    public final void zzf() throws IOException {
        zzrs zzrsVar = this.zzh;
        if (zzrsVar != null) {
            throw zzrsVar.zza();
        }
    }

    public final int zzg() {
        return this.zzq;
    }

    public final int zzh() {
        return this.zzq + this.zzs;
    }

    public final synchronized zzv zzi() {
        if (this.zzy) {
            return null;
        }
        return this.zzz;
    }

    public final synchronized long zzj() {
        return this.zzv;
    }

    public final synchronized boolean zzk() {
        return this.zzw;
    }

    public final synchronized boolean zzl(boolean z) {
        boolean z2 = true;
        if (zzH()) {
            if (((zzwh) this.zzc.zza(this.zzq + this.zzs)).zza != this.zzg) {
                return true;
            }
            return zzJ(zzM(this.zzs));
        }
        if (!z && !this.zzw) {
            zzv zzvVar = this.zzz;
            if (zzvVar == null) {
                z2 = false;
            } else if (zzvVar == this.zzg) {
                return false;
            }
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r9 != 0) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzm(com.google.android.gms.internal.ads.zzkj r9, com.google.android.gms.internal.ads.zzhh r10, int r11, boolean r12) {
        /*
            r8 = this;
            r0 = r11 & 2
            r1 = 1
            if (r0 == 0) goto L7
            r5 = r1
            goto L9
        L7:
            r0 = 0
            r5 = r0
        L9:
            com.google.android.gms.internal.ads.zzwf r0 = r8.zzb
            r2 = r8
            r3 = r9
            r4 = r10
            r6 = r12
            r7 = r0
            int r9 = r2.zzB(r3, r4, r5, r6, r7)
            r12 = -4
            if (r9 != r12) goto L3b
            boolean r9 = r10.zzb()
            if (r9 != 0) goto L3a
            r9 = r11 & 1
            r11 = r11 & 4
            if (r11 != 0) goto L31
            if (r9 == 0) goto L2b
            com.google.android.gms.internal.ads.zzwe r9 = r8.zza
            r9.zzd(r10, r0)
            goto L3a
        L2b:
            com.google.android.gms.internal.ads.zzwe r9 = r8.zza
            r9.zzc(r10, r0)
            goto L34
        L31:
            if (r9 == 0) goto L34
            goto L3a
        L34:
            int r9 = r8.zzs
            int r9 = r9 + r1
            r8.zzs = r9
            return r12
        L3a:
            r9 = r12
        L3b:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzwj.zzm(com.google.android.gms.internal.ads.zzkj, com.google.android.gms.internal.ads.zzhh, int, boolean):int");
    }

    public final synchronized boolean zzn(int i) {
        zzA();
        int i2 = this.zzq;
        if (i >= i2 && i <= this.zzp + i2) {
            this.zzt = Long.MIN_VALUE;
            this.zzs = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean zzo(long j, boolean z) {
        int iZzK;
        zzA();
        int i = this.zzs;
        int iZzM = zzM(i);
        if (zzH() && j >= this.zzn[iZzM]) {
            if (j > this.zzv) {
                if (z) {
                    z = true;
                }
            }
            if (this.zzA) {
                iZzK = this.zzp - i;
                int i2 = 0;
                while (true) {
                    if (i2 < iZzK) {
                        if (this.zzn[iZzM] >= j) {
                            iZzK = i2;
                            break;
                        }
                        iZzM++;
                        if (iZzM == this.zzi) {
                            iZzM = 0;
                        }
                        i2++;
                    } else if (!z) {
                        iZzK = -1;
                    }
                }
            } else {
                iZzK = zzK(iZzM, this.zzp - i, j, true);
            }
            if (iZzK != -1) {
                this.zzt = j;
                this.zzs += iZzK;
                return true;
            }
        }
        return false;
    }

    public final synchronized int zzp(long j, boolean z) {
        int i = this.zzs;
        int iZzM = zzM(i);
        if (zzH() && j >= this.zzn[iZzM]) {
            if (j > this.zzv && z) {
                return this.zzp - i;
            }
            int iZzK = zzK(iZzM, this.zzp - i, j, true);
            if (iZzK == -1) {
                return 0;
            }
            return iZzK;
        }
        return 0;
    }

    public final synchronized void zzq(int i) {
        boolean z = false;
        if (i >= 0) {
            try {
                if (this.zzs + i <= this.zzp) {
                    z = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        zzgmd.zza(z);
        this.zzs += i;
    }

    public final void zzr(long j, boolean z, boolean z2) {
        this.zza.zze(zzD(j, false, z2));
    }

    public final void zzs() {
        this.zza.zze(zzE());
    }

    public final void zzt(zzwi zzwiVar) {
        this.zzf = zzwiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzu(zzv zzvVar) {
        boolean zZzC = zzC(zzvVar);
        zzwi zzwiVar = this.zzf;
        if (zzwiVar == null || !zZzC) {
            return;
        }
        zzwiVar.zzy(zzvVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final int zzv(zzj zzjVar, int i, boolean z, int i2) throws IOException {
        return this.zza.zzg(zzjVar, i, z);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzw(zzeg zzegVar, int i, int i2) {
        this.zza.zzh(zzegVar, i);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public final void zzx(long j, int i, int i2, int i3, zzael zzaelVar) {
        if (this.zzx) {
            if ((i & 1) == 0) {
                return;
            } else {
                this.zzx = false;
            }
        }
        if (this.zzA) {
            if (j < this.zzt) {
                return;
            }
            if ((i & 1) == 0) {
                if (!this.zzB) {
                    String strValueOf = String.valueOf(this.zzz);
                    String.valueOf(strValueOf);
                    zzdt.zzc("SampleQueue", "Overriding unexpected non-sync sample for format: ".concat(String.valueOf(strValueOf)));
                    this.zzB = true;
                }
                i |= 1;
            }
        }
        zzG(j, i, (this.zza.zzf() - ((long) i2)) - ((long) i3), i2, zzaelVar);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public /* synthetic */ int zzy(zzj zzjVar, int i, boolean z) {
        return zzv(zzjVar, i, z, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaem
    public /* synthetic */ void zzz(zzeg zzegVar, int i) {
        zzw(zzegVar, i, 0);
    }

    private final long zzL(int i) {
        long j = this.zzu;
        long jMax = Long.MIN_VALUE;
        if (i != 0) {
            int iZzM = zzM(i - 1);
            for (int i2 = 0; i2 < i; i2++) {
                jMax = Math.max(jMax, this.zzn[iZzM]);
                if ((this.zzm[iZzM] & 1) != 0) {
                    break;
                }
                iZzM--;
                if (iZzM == -1) {
                    iZzM = this.zzi - 1;
                }
            }
        }
        this.zzu = Math.max(j, jMax);
        this.zzp -= i;
        int i3 = this.zzq + i;
        this.zzq = i3;
        int i4 = this.zzr + i;
        this.zzr = i4;
        int i5 = this.zzi;
        if (i4 >= i5) {
            this.zzr = i4 - i5;
        }
        int i6 = this.zzs - i;
        this.zzs = i6;
        if (i6 < 0) {
            this.zzs = 0;
        }
        this.zzc.zzd(i3);
        if (this.zzp != 0) {
            return this.zzk[this.zzr];
        }
        int i7 = this.zzr;
        if (i7 == 0) {
            i7 = this.zzi;
        }
        int i8 = i7 - 1;
        return this.zzk[i8] + ((long) this.zzl[i8]);
    }
}
