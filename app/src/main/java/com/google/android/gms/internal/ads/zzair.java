package com.google.android.gms.internal.ads;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.internal.ads.zzada;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@24.7.0 */
/* JADX INFO: loaded from: classes9.dex */
public final class zzair implements zzada {
    private static final byte[] zza;
    private static final zzv zzb;
    private long zzA;
    private long zzB;
    private zzaiq zzC;
    private int zzD;
    private int zzE;
    private int zzF;
    private boolean zzG;
    private boolean zzH;
    private zzadd zzI;
    private zzaem[] zzJ;
    private zzaem[] zzK;
    private boolean zzL;
    private long zzM;
    private final zzakg zzc;
    private final int zzd;
    private final List zze;
    private final SparseArray zzf;
    private final zzeg zzg;
    private final zzeg zzh;
    private final zzeg zzi;
    private final byte[] zzj;
    private final zzeg zzk;
    private final zzagc zzl;
    private final zzeg zzm;
    private final ArrayDeque zzn;
    private final ArrayDeque zzo;
    private final zzfq zzp;
    private final zzacp zzq;
    private zzgpe zzr;
    private int zzs;
    private int zzt;
    private long zzu;
    private int zzv;
    private zzeg zzw;
    private long zzx;
    private int zzy;
    private long zzz;

    static {
        int i = zzain.zza;
        zza = new byte[]{-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
        zzt zztVar = new zzt();
        zztVar.zzm(MimeTypes.APPLICATION_EMSG);
        zzb = zztVar.zzM();
    }

    @Deprecated
    public zzair() {
        this(zzakg.zza, 32, null, null, zzgpe.zzi(), null);
    }

    private final void zzh() {
        this.zzs = 0;
        this.zzv = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:305:0x07e1, code lost:
    
        zzh();
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x07e4, code lost:
    
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:139:0x03f7  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x03fd  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x040d  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x049e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void zzi(long r60) throws com.google.android.gms.internal.ads.zzat {
        /*
            Method dump skipped, instruction units count: 2021
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzair.zzi(long):void");
    }

    private static int zzj(int i) throws zzat {
        if (i >= 0) {
            return i;
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 27);
        sb.append("Unexpected negative value: ");
        sb.append(i);
        throw zzat.zzb(sb.toString(), null);
    }

    private static void zzk(zzeg zzegVar, int i, zzajh zzajhVar) throws zzat {
        zzegVar.zzh(i + 8);
        int iZzB = zzegVar.zzB();
        int i2 = zzaik.zza;
        if ((iZzB & 1) != 0) {
            throw zzat.zzc("Overriding TrackEncryptionBox parameters is unsupported.");
        }
        boolean z = (iZzB & 2) != 0;
        int iZzH = zzegVar.zzH();
        if (iZzH == 0) {
            Arrays.fill(zzajhVar.zzl, 0, zzajhVar.zze, false);
            return;
        }
        int i3 = zzajhVar.zze;
        if (iZzH != i3) {
            StringBuilder sb = new StringBuilder(String.valueOf(iZzH).length() + 58 + String.valueOf(i3).length());
            sb.append("Senc sample count ");
            sb.append(iZzH);
            sb.append(" is different from fragment sample count");
            sb.append(i3);
            throw zzat.zzb(sb.toString(), null);
        }
        Arrays.fill(zzajhVar.zzl, 0, iZzH, z);
        zzajhVar.zza(zzegVar.zzd());
        zzeg zzegVar2 = zzajhVar.zzn;
        zzegVar.zzm(zzegVar2.zzi(), 0, zzegVar2.zze());
        zzegVar2.zzh(0);
        zzajhVar.zzo = false;
    }

    private static Pair zzl(zzeg zzegVar, long j) throws zzat {
        long jZzJ;
        long jZzJ2;
        zzegVar.zzh(8);
        int iZza = zzaik.zza(zzegVar.zzB());
        zzegVar.zzk(4);
        long jZzz = zzegVar.zzz();
        if (iZza == 0) {
            jZzJ = zzegVar.zzz();
            jZzJ2 = zzegVar.zzz();
        } else {
            jZzJ = zzegVar.zzJ();
            jZzJ2 = zzegVar.zzJ();
        }
        long j2 = jZzJ;
        long j3 = j + jZzJ2;
        long jZzt = zzep.zzt(j2, 1000000L, jZzz, RoundingMode.DOWN);
        zzegVar.zzk(2);
        int iZzt = zzegVar.zzt();
        int[] iArr = new int[iZzt];
        long[] jArr = new long[iZzt];
        long[] jArr2 = new long[iZzt];
        long[] jArr3 = new long[iZzt];
        long j4 = jZzt;
        int i = 0;
        long j5 = j2;
        while (i < iZzt) {
            int iZzB = zzegVar.zzB();
            if ((Integer.MIN_VALUE & iZzB) != 0) {
                throw zzat.zzb("Unhandled indirect reference", null);
            }
            long jZzz2 = zzegVar.zzz();
            iArr[i] = iZzB & Integer.MAX_VALUE;
            jArr[i] = j3;
            jArr3[i] = j4;
            long j6 = j5 + jZzz2;
            long[] jArr4 = jArr3;
            long[] jArr5 = jArr2;
            int i2 = iZzt;
            int[] iArr2 = iArr;
            long jZzt2 = zzep.zzt(j6, 1000000L, jZzz, RoundingMode.DOWN);
            jArr5[i] = jZzt2 - jArr4[i];
            zzegVar.zzk(4);
            j3 += (long) iArr2[i];
            i++;
            iArr = iArr2;
            jArr2 = jArr5;
            jArr = jArr;
            iZzt = i2;
            jArr3 = jArr4;
            j5 = j6;
            j4 = jZzt2;
        }
        return Pair.create(Long.valueOf(jZzt), new zzaco(iArr, jArr, jArr2, jArr3));
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x015d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.internal.ads.zzq zzm(java.util.List r18) {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzair.zzm(java.util.List):com.google.android.gms.internal.ads.zzq");
    }

    private static final zzail zzn(SparseArray sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return (zzail) sparseArray.valueAt(0);
        }
        zzail zzailVar = (zzail) sparseArray.get(i);
        zzailVar.getClass();
        return zzailVar;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final boolean zza(zzadb zzadbVar) throws IOException {
        zzaeh zzaehVarZza = zzaje.zza(zzadbVar);
        this.zzr = zzaehVarZza != null ? zzgpe.zzj(zzaehVarZza) : zzgpe.zzi();
        return zzaehVarZza == null;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final /* synthetic */ List zzb() {
        return this.zzr;
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zzc(zzadd zzaddVar) {
        int i;
        int i2 = this.zzd;
        if ((i2 & 32) == 0) {
            zzaddVar = new zzakj(zzaddVar, this.zzc);
        }
        this.zzI = zzaddVar;
        zzh();
        zzaem[] zzaemVarArr = new zzaem[2];
        this.zzJ = zzaemVarArr;
        int i3 = 100;
        int i4 = 0;
        if ((i2 & 4) != 0) {
            zzaemVarArr[0] = this.zzI.zzu(100, 5);
            i = 1;
            i3 = 101;
        } else {
            i = 0;
        }
        zzaem[] zzaemVarArr2 = (zzaem[]) zzep.zzb(this.zzJ, i);
        this.zzJ = zzaemVarArr2;
        for (zzaem zzaemVar : zzaemVarArr2) {
            zzaemVar.zzu(zzb);
        }
        List list = this.zze;
        this.zzK = new zzaem[list.size()];
        while (i4 < this.zzK.length) {
            zzaem zzaemVarZzu = this.zzI.zzu(i3, 3);
            zzaemVarZzu.zzu((zzv) list.get(i4));
            this.zzK[i4] = zzaemVarZzu;
            i4++;
            i3++;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:101:0x01fd, code lost:
    
        if (((r19 & 126) >> 1) != 39) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x01ff, code lost:
    
        r9 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0201, code lost:
    
        r21 = r10;
        r20 = r14;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0206, code lost:
    
        r9 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x0207, code lost:
    
        r27.zzH = r9;
        r8.zzz(r3, r5);
        r27.zzE += r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x0211, code lost:
    
        if (r5 <= 0) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0215, code lost:
    
        if (r27.zzG != false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x021e, code lost:
    
        if (com.google.android.gms.internal.ads.zzfm.zzc(r7, 4, r5, r4.zzg) == false) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0220, code lost:
    
        r27.zzG = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:112:0x0223, code lost:
    
        r14 = r20;
        r10 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0232, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzb("Invalid NAL length", null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0233, code lost:
    
        r21 = r10;
        r20 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x023a, code lost:
    
        if (r27.zzH == false) goto L128;
     */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x023c, code lost:
    
        r9 = r27.zzi;
        r9.zza(r5);
        r28.zzc(r9.zzi(), 0, r27.zzF);
        r8.zzz(r9, r27.zzF);
        r5 = r27.zzF;
        r10 = com.google.android.gms.internal.ads.zzfm.zza(r9.zzi(), r9.zze());
        r9.zzh(0);
        r9.zzf(r10);
        r10 = r4.zzg.zzq;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x0269, code lost:
    
        if (r10 != (-1)) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x026b, code lost:
    
        r10 = r27.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:120:0x0271, code lost:
    
        if (r10.zzb() == 0) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0273, code lost:
    
        r10.zza(0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x0277, code lost:
    
        r11 = r27.zzp;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x027d, code lost:
    
        if (r11.zzb() == r10) goto L125;
     */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x027f, code lost:
    
        r11.zza(r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x0282, code lost:
    
        r10 = r27.zzp;
        r10.zzc(r12, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x028d, code lost:
    
        if ((r2.zzg() & 4) == 0) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x028f, code lost:
    
        r10.zze();
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0293, code lost:
    
        r5 = r8.zzy(r28, r5, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:129:0x0299, code lost:
    
        r27.zzE += r5;
        r27.zzF -= r5;
        r14 = r20;
        r10 = r21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x02aa, code lost:
    
        r1 = r2.zzg();
     */
    /* JADX WARN: Code restructure failed: missing block: B:131:0x02b0, code lost:
    
        if (r27.zzG != false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b2, code lost:
    
        r1 = r1 | androidx.core.view.accessibility.AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x02b5, code lost:
    
        r21 = r1;
        r1 = r2.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02bb, code lost:
    
        if (r1 == null) goto L136;
     */
    /* JADX WARN: Code restructure failed: missing block: B:135:0x02bd, code lost:
    
        r24 = r1.zzc;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02c2, code lost:
    
        r24 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:137:0x02c4, code lost:
    
        r8.zzx(r12, r21, r27.zzD, 0, r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:138:0x02d1, code lost:
    
        r1 = r27.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x02d7, code lost:
    
        if (r1.isEmpty() != false) goto L453;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02d9, code lost:
    
        r1 = (com.google.android.gms.internal.ads.zzaip) r1.removeFirst();
        r3 = r27.zzy;
        r11 = r1.zzc;
        r27.zzy = r3 - r11;
        r3 = r1.zza;
     */
    /* JADX WARN: Code restructure failed: missing block: B:141:0x02ea, code lost:
    
        if (r1.zzb == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x02ec, code lost:
    
        r3 = r3 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:143:0x02ed, code lost:
    
        r14 = r3;
        r1 = r27.zzJ;
        r3 = r1.length;
        r10 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x02f2, code lost:
    
        if (r10 >= r3) goto L456;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x02f4, code lost:
    
        r1[r10].zzx(r14, 1, r11, r27.zzy, null);
        r10 = r10 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x030b, code lost:
    
        if (r2.zzh() != false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x030d, code lost:
    
        r27.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:149:0x0310, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0311, code lost:
    
        r27.zzs = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x0314, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x05cd, code lost:
    
        throw com.google.android.gms.internal.ads.zzat.zzc("Atom size less than header length (unsupported).");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        r10 = "video/avc";
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x009c, code lost:
    
        if (r27.zzs != 3) goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x009e, code lost:
    
        r27.zzD = r2.zzf();
        r4 = r2.zzd.zza.zzg.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (java.util.Objects.equals(r4, "video/avc") != false) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00b2, code lost:
    
        java.util.Objects.equals(r4, "video/hevc");
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00b5, code lost:
    
        r27.zzG = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00bb, code lost:
    
        if (r2.zzf >= r2.zzi) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00bd, code lost:
    
        r28.zzf(r27.zzD);
        r1 = r2.zzj();
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00c6, code lost:
    
        if (r1 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00c9, code lost:
    
        r4 = r2.zzb;
        r6 = r4.zzn;
        r1 = r1.zzd;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00cf, code lost:
    
        if (r1 == 0) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d1, code lost:
    
        r6.zzk(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00da, code lost:
    
        if (r4.zzb(r2.zzf) == false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00dc, code lost:
    
        r6.zzk(r6.zzt() * 6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00e8, code lost:
    
        if (r2.zzh() != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ea, code lost:
    
        r27.zzC = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00ec, code lost:
    
        r1 = 3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00f5, code lost:
    
        if (r2.zzd.zza.zzh != 1) goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00f7, code lost:
    
        r27.zzD -= 8;
        r28.zzf(8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x010e, code lost:
    
        if (com.google.android.exoplayer2.util.MimeTypes.AUDIO_AC4.equals(r2.zzd.zza.zzg.zzo) == false) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0110, code lost:
    
        r27.zzE = r2.zzi(r27.zzD, 7);
        r4 = r27.zzD;
        r12 = r27.zzk;
        com.google.android.gms.internal.ads.zzace.zzc(r4, r12);
        r2.zza.zzz(r12, 7);
        r4 = r27.zzE + 7;
        r27.zzE = r4;
        r8 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x012c, code lost:
    
        r8 = 0;
        r4 = r2.zzi(r27.zzD, 0);
        r27.zzE = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x0135, code lost:
    
        r27.zzD += r4;
        r27.zzs = 4;
        r27.zzF = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x013e, code lost:
    
        r4 = r2.zzd.zza;
        r8 = r2.zza;
        r12 = r2.zzd();
        r14 = r4.zzk;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x014a, code lost:
    
        if (r14 != 0) goto L69;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x014c, code lost:
    
        r4 = r27.zzE;
        r5 = r27.zzD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0150, code lost:
    
        if (r4 >= r5) goto L452;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0152, code lost:
    
        r27.zzE += r8.zzy(r28, r5 - r4, false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x015e, code lost:
    
        r3 = r27.zzh;
        r7 = r3.zzi();
        r7[0] = 0;
        r7[1] = 0;
        r7[2] = 0;
        r15 = 4 - r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0173, code lost:
    
        if (r27.zzE >= r27.zzD) goto L457;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0175, code lost:
    
        r5 = r27.zzF;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0177, code lost:
    
        if (r5 != 0) goto L458;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x017c, code lost:
    
        if (r27.zzK.length > 0) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0180, code lost:
    
        if (r27.zzG != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0182, code lost:
    
        r5 = com.google.android.gms.internal.ads.zzfm.zzb(r4.zzg);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0191, code lost:
    
        if ((r14 + r5) <= (r27.zzD - r27.zzE)) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0193, code lost:
    
        r5 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0195, code lost:
    
        r5 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0197, code lost:
    
        r28.zzc(r7, r15, r14 + r5);
        r3.zzh(0);
        r11 = r3.zzB();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01a4, code lost:
    
        if (r11 < 0) goto L459;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01a6, code lost:
    
        r27.zzF = r11 - r5;
        r11 = r27.zzg;
        r11.zzh(0);
        r8.zzz(r11, 4);
        r27.zzE += 4;
        r27.zzD += r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x01bf, code lost:
    
        if (r27.zzK.length <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x01c1, code lost:
    
        if (r5 <= 0) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01c3, code lost:
    
        r11 = r4.zzg;
        r19 = r7[4];
        r9 = com.google.android.gms.internal.ads.zzfm.zza;
        r9 = r11.zzo;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01cf, code lost:
    
        if (java.util.Objects.equals(r9, r10) != false) goto L93;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01d1, code lost:
    
        r20 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01d9, code lost:
    
        if (com.google.android.gms.internal.ads.zzas.zze(r11.zzk, r10) == false) goto L92;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x01dc, code lost:
    
        r21 = r10;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x01e0, code lost:
    
        r20 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x01e2, code lost:
    
        r21 = r10;
        r10 = 6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x01e7, code lost:
    
        if ((r19 & com.google.common.base.Ascii.US) == 6) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ed, code lost:
    
        if (java.util.Objects.equals(r9, "video/hevc") != false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x01f5, code lost:
    
        if (com.google.android.gms.internal.ads.zzas.zze(r11.zzk, "video/hevc") == false) goto L104;
     */
    @Override // com.google.android.gms.internal.ads.zzada
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int zzd(com.google.android.gms.internal.ads.zzadb r28, com.google.android.gms.internal.ads.zzaea r29) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 2002
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzair.zzd(com.google.android.gms.internal.ads.zzadb, com.google.android.gms.internal.ads.zzaea):int");
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public final void zze(long j, long j2) {
        SparseArray sparseArray = this.zzf;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            ((zzaiq) sparseArray.valueAt(i)).zzc();
        }
        this.zzo.clear();
        this.zzy = 0;
        this.zzp.zzd();
        this.zzz = j2;
        this.zzn.clear();
        zzh();
    }

    @Override // com.google.android.gms.internal.ads.zzada
    public /* synthetic */ zzada zzf() {
        return zzada.CC.$default$zzf(this);
    }

    final /* synthetic */ void zzg(long j, zzeg zzegVar) {
        zzacn.zza(j, zzegVar, this.zzK);
    }

    public zzair(zzakg zzakgVar, int i, zzem zzemVar, zzajf zzajfVar, List list, zzaem zzaemVar) {
        this.zzc = zzakgVar;
        this.zzd = i;
        this.zze = Collections.unmodifiableList(list);
        this.zzl = new zzagc();
        this.zzm = new zzeg(16);
        this.zzg = new zzeg(zzfm.zza);
        this.zzh = new zzeg(6);
        this.zzi = new zzeg();
        byte[] bArr = new byte[16];
        this.zzj = bArr;
        this.zzk = new zzeg(bArr);
        this.zzn = new ArrayDeque();
        this.zzo = new ArrayDeque();
        this.zzf = new SparseArray();
        this.zzr = zzgpe.zzi();
        this.zzA = C.TIME_UNSET;
        this.zzz = C.TIME_UNSET;
        this.zzB = C.TIME_UNSET;
        this.zzI = zzadd.zza;
        this.zzJ = new zzaem[0];
        this.zzK = new zzaem[0];
        this.zzp = new zzfq(new zzfp() { // from class: com.google.android.gms.internal.ads.zzaio
            @Override // com.google.android.gms.internal.ads.zzfp
            public final /* synthetic */ void zza(long j, zzeg zzegVar) {
                this.zza.zzg(j, zzegVar);
            }
        });
        this.zzq = new zzacp();
        this.zzM = -1L;
    }
}
